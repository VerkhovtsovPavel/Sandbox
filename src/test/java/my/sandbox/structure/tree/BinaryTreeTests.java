package my.sandbox.structure.tree;

import static my.sandbox.structure.tree.TraversalOrder.IN_ORDER;
import static my.sandbox.structure.tree.TraversalOrder.POST_ORDER;
import static my.sandbox.structure.tree.TraversalOrder.PRE_ORDER;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class BinaryTreeTests {
    @Test
    public void dummyTreeTest() {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>();

        integerBinaryTree.add(5);
        integerBinaryTree.add(7);
        integerBinaryTree.add(3);
        integerBinaryTree.add(4);
        integerBinaryTree.add(8);
        integerBinaryTree.add(9);
        integerBinaryTree.add(1);

        assertTrue(integerBinaryTree.contains(5));
        assertTrue(integerBinaryTree.contains(7));
        assertFalse(integerBinaryTree.contains(10));

        assertEquals(integerBinaryTree.traverse(IN_ORDER).toString(), "[1, 3, 4, 5, 7, 8, 9]");
        assertEquals(integerBinaryTree.traverse(POST_ORDER).toString(), "[1, 4, 3, 9, 8, 7, 5]");
        assertEquals(integerBinaryTree.traverse(PRE_ORDER).toString(), "[5, 3, 1, 4, 7, 8, 9]");
    }
}
