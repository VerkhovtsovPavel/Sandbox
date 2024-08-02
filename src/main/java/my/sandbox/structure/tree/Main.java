package my.sandbox.structure.tree;

import static java.lang.String.format;
import static my.sandbox.common.logger.CommonLogger.LOG;


//TODO Move to tests
public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();

        integerBinaryTree.add(5);
        integerBinaryTree.add(6);
        integerBinaryTree.add(3);
        integerBinaryTree.add(8);
        integerBinaryTree.add(1);

        LOG.info(integerBinaryTree.contains(5));
        LOG.info(integerBinaryTree.contains(6));
        LOG.info(integerBinaryTree.contains(10));

        LOG.info(integerBinaryTree.traverse(TraversalOrder.IN_ORDER));
    }
}
