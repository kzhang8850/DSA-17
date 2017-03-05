import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        Collections.sort(values);
        BinarySearchTree<Integer> result = new BinarySearchTree<>();
        balancedBST(result, values, 0, values.size()-1);
        return result;
    }
    private static void balancedBST(BinarySearchTree<Integer> t, List<Integer> a, int start, int end){
        if(start <= end){
            int mid = (start+end)/2;
            int thing = a.get(mid);
            t.add(thing);
            balancedBST(t, a, start, mid -1);
            balancedBST(t, a, mid +1, end);
        }
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        if(n1.isLeaf() && n2.isLeaf()){
            return true;
        }
        else if(n1.isLeaf() != n2.isLeaf()){
            return false;
        }
        else if(!n1.leftChild.equals(n2.leftChild) && !n1.leftChild.equals(n2.rightChild)){
            return false;
        }
        else if(!n1.rightChild.equals(n2.leftChild) && !n1.rightChild.equals(n2.rightChild)){
            return false;
        }
        else{
            if(n1.leftChild.equals(n2.leftChild)){
                return isIsomorphic(n1.leftChild, n2.leftChild) && isIsomorphic(n1.rightChild, n2.rightChild);
            }
            else{
                return isIsomorphic(n1.leftChild, n2.rightChild) && isIsomorphic(n1.rightChild, n2.leftChild);
            }

        }
    }

    public static void main(String [] args){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(3);
        temp.add(2);
        temp.add(4);
        minimalHeight(temp);
    }
}
