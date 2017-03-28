import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static List<Integer> levelOrderTraversal(TreeNode<Integer> n) {
        ArrayList<Integer> levelOrder = new ArrayList<>();
        Queue<TreeNode<Integer>> breadthSearch = new LinkedList<>();
        breadthSearch.add(n);

        while(!breadthSearch.isEmpty()){
            TreeNode<Integer> currentNode = breadthSearch.poll();
            levelOrder.add(currentNode.key);
            System.out.println(currentNode.key);
            if(currentNode.hasLeftChild()){
                breadthSearch.offer(currentNode.leftChild);
            }
            if(currentNode.hasRightChild()){
                breadthSearch.offer(currentNode.rightChild);
            }
        }
        System.out.println(levelOrder.toString());
        return levelOrder;
    }
}
