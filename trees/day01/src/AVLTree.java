import apple.laf.JRSUIUtils;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    /**
     * Delete a key from the tree rooted at the given node.
     */
    @Override
    TreeNode<T> delete(TreeNode<T> n, T key) {
        n = super.delete(n,key);
        if(n != null) {
            n.height = 1 + Math.max(height(n.rightChild), height(n.leftChild));
            return balance(n);
        }
        return null;
    }
    /**
     * Insert a key into the tree rooted at the given node.
     */
    @Override
    TreeNode<T> insert(TreeNode<T>  n, T key) {
        n = super.insert(n,key);
        if(n != null) {
            n.height = 1 + Math.max(height(n.rightChild), height(n.leftChild));
            return balance(n);
        }
        return null;
    }

    /**
     * Delete the minimum descendant of the given node.
     */
    @Override
    TreeNode<T> deleteMin(TreeNode<T> n){
        n = super.deleteMin(n);
        if(n != null) {
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    // Return the height of the given node. Return -1 if null.
    private int height(TreeNode<T> n) {
        if(n == null){
            return -1;

        }
        else{
            return n.height;
        }
    }

    public int height() {
        return Math.max(height(root),0);
    }

    // Restores the AVL tree property of the subtree.
    TreeNode<T> balance(TreeNode<T> n) {
        if(balanceFactor(n) > 1){
            if(balanceFactor(n.rightChild) < 0){
                n.rightChild = rotateRight(n.rightChild);
            }
            n = rotateLeft(n);
        }
        else if(balanceFactor(n) < -1){
            if(balanceFactor(n.leftChild) > 0){
                n.leftChild = rotateLeft(n.leftChild);
            }
            n = rotateRight(n);
        }
        return n;
    }

    /**
     * Returns the balance factor of the subtree. The balance factor is defined
     * as the difference in height of the left subtree and right subtree, in
     * this order. Therefore, a subtree with a balance factor of -1, 0 or 1 has
     * the AVL property since the heights of the two child subtrees differ by at
     * most one.
     */
    private int balanceFactor(TreeNode<T> n) {
        return height(n.rightChild) - height(n.leftChild);
    }

    /**
     * Perform a right rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateRight(TreeNode<T> n) {
        TreeNode<T> a = n;
        TreeNode<T> b = n.leftChild;
        TreeNode<T> beta = null;
        if(b.hasRightChild()) {
            beta = b.rightChild;
        }
        b.rightChild = a;
        a.leftChild = beta;
        a.height = 1 + Math.max(height(a.rightChild), height(a.leftChild));
        b.height = 1 + Math.max(height(b.rightChild), height(b.leftChild));
        return b;
    }

    /**
     * Perform a left rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateLeft(TreeNode<T> n) {
        TreeNode<T> a = n;
        TreeNode<T> b = n.rightChild;
        TreeNode<T> beta = null;
        if(b.hasLeftChild()) {
            beta = b.leftChild;
        }
        b.leftChild = a;
        a.rightChild = beta;
        a.height = 1 + Math.max(height(a.rightChild), height(a.leftChild));
        b.height = 1 + Math.max(height(b.rightChild), height(b.leftChild));
        return b;
    }
    public static void  main(String [] args){
        Integer[] chicken = new Integer[]{3, 1, 2, 7, 10, -3, 5, -10, 16, 13};
        AVLTree<Integer> test1 = new AVLTree<>();
        test1.addAll(chicken);
        System.out.println(" ");
//        System.out.println(test1.height());
        test1.insert(test1.root,-20);
    }

}

