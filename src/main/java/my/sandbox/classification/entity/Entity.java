package my.sandbox.classification.entity;

import java.util.List;

import static my.sandbox.classification.util.MathUtils.distance;

/**
 * Class describing object with two characteristics x and y coordinates.
 */
public class Entity implements Cloneable {
    private final int xCoordinate;
    private final int yCoordinate;
    private int areaNumber;

    /**
     * Constructor
     *
     * @param x Coordinate x
     * @param y Coordinate y
     */
    public Entity(final int x, final int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    /**
     * Choice area(class).
     *
     * @param centers Array of class centers
     */
    public void choiceArea(final List<Entity> centers) {
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < centers.size(); i++) {
            double distance = distance(this, centers.get(i));
            if (distance < minDistance) {
                minDistance = distance;
                setAreaNumber(i);
            }
        }
    }

    /**
     * Getter for x coordinate.
     *
     * @return x coordinate object's
     */
    public int getX() {
        return xCoordinate;
    }

    /**
     * Getter for y coordinate.
     *
     * @return y coordinate object's
     */
    public int getY() {
        return yCoordinate;
    }

    /**
     * Getter for area number
     *
     * @return area number
     */
    public int getAreaNumber() {
        return areaNumber;
    }

    /**
     * Setter for area number
     *
     * @param areaNumber number of area
     */
    public void setAreaNumber(final int areaNumber) {
        this.areaNumber = areaNumber;
    }

    @Override
    public Entity clone() {
        try {
            return (Entity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
