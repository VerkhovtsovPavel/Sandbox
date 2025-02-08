package my.sandbox.structure.tree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

//TODO Increase coverage
public class BinaryTreeTests {
    @Test
    public void dummyTreeTest() {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();

        integerBinaryTree.add(5);
        integerBinaryTree.add(6);
        integerBinaryTree.add(3);
        integerBinaryTree.add(8);
        integerBinaryTree.add(1);

        assertTrue(integerBinaryTree.contains(5));
        assertTrue(integerBinaryTree.contains(6));
        assertFalse(integerBinaryTree.contains(10));

        assertEquals(integerBinaryTree.traverse(TraversalOrder.IN_ORDER).toString(), "[1, 3, 5, 6, 8]");
    }
}
