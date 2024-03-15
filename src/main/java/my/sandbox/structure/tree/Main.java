package my.sandbox.structure.tree;

//TODO Move to tests
public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();

        integerBinaryTree.add(5);
        integerBinaryTree.add(6);
        integerBinaryTree.add(3);
        integerBinaryTree.add(8);
        integerBinaryTree.add(1);

        System.out.println(integerBinaryTree.contains(5));
        System.out.println(integerBinaryTree.contains(6));
        System.out.println(integerBinaryTree.contains(10));

        System.out.println(integerBinaryTree.traverse(TraversalOrder.IN_ORDER));
    }
}
