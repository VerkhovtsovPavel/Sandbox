package my.sandbox.classification.graphics;

import my.sandbox.classification.entity.Entity;
import my.sandbox.classification.util.CloneUtils;
import my.sandbox.classification.util.SyncUtils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serial;
import java.util.List;

import static my.sandbox.classification.util.Constants.UI_REDRAW_EVENT;

/**
 * Class containing methods to visualize classes.
 */
public final class GraphicsClass extends JPanel {

    @Serial
    private static final long serialVersionUID = 1L; //service variable
    private static final int CIRCLE_RADIUS = 5;
    private static final int OFFSET = 50;
    private static int screenSize;
    private static List<Entity> objectArrayBinding;
    private static List<Entity> classArrayBinding;

    private final List<Entity> objectArray;
    private final List<Entity> classArray;

    private boolean isRepaint;

    private GraphicsClass() {
        this.objectArray = CloneUtils.clone(objectArrayBinding);
        this.classArray = CloneUtils.clone(classArrayBinding);
    }

    /**
     * Show form with visualization classes.
     */
    public static void visualizeClasses(final String titleComment) {
        JPanel panel = new GraphicsClass();
        panel.setOpaque(true);

        JFrame mainFrame = new JFrame("Visualization division classes [" + titleComment + "]");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(panel);
        mainFrame.setSize(screenSize + (OFFSET * 2), screenSize + (OFFSET * 2));
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.white);
    }

    /**
     * Setter to screen size.
     *
     * @param scrSize screen size
     */
    public static void setScreenSize(final int scrSize) {
        screenSize = scrSize;
    }

    /**
     * Setter to object array.
     *
     * @param entities list of objects
     * @param classes  list of classes centers
     */
    public static void bindEntityLists(final List<Entity> entities, final List<Entity> classes) {
        objectArrayBinding = entities;
        classArrayBinding = classes;
    }

    /**
     * Drawing form.
     *
     * @param g graphics object
     */
    @Override
    public void paint(final Graphics g) {
        final int areaCount = classArray.size();

        for (Entity value : objectArray) {
            g.setColor(generateColor(value.getAreaNumber(), areaCount));
            g.fillOval(value.getX() + OFFSET, value.getY() + OFFSET, CIRCLE_RADIUS, CIRCLE_RADIUS);
        }

        for (Entity entity : classArray) {
            g.setColor(Color.BLACK);
            g.fillOval(entity.getX() + OFFSET, entity.getY() + OFFSET, CIRCLE_RADIUS * 2, CIRCLE_RADIUS * 2);
        }
        if (!isRepaint) {
            SyncUtils.notify(UI_REDRAW_EVENT);
            isRepaint = true;
        }
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    private Color generateColor(final int areaNumber, final int areaCount) {
        return switch (areaNumber) {
            case 0 -> Color.RED;
            case 1 -> Color.BLUE;
            case 2 -> Color.GREEN;
            case 3 -> Color.GRAY;
            default -> new Color(
                    0,
                    255 / areaCount * areaNumber,
                    255 / areaCount * areaNumber
            );
        };
    }
}
