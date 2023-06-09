package my.sandbox.classification.main;

import java.util.Scanner;

public class KMeans extends Classification {

    public KMeans(final int dispersion) {
        super(dispersion);
    }

    @Override
    protected int getEntitiesCount() {
        System.out.print("Input count entities: ");
        return (new Scanner(System.in)).nextInt();
    }

    @Override
    protected int getClassesCount() {
        System.out.print("Input count classes: ");
        return (new Scanner(System.in)).nextInt();
    }
}
