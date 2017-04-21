public class EditDistance {

    public static int minEditDist(String a, String b) {

        int indexa = 0;
        int indexb = 0;
        int[][] memo = new int[a.length()+1][b.length()+1];
        for (int i = 0; i < a.length()+1; i++) {
            for (int j = 0; j < b.length()+1; j++) {
                memo[i][j] = -1;
            }

        }
        return EditDist(a, b, indexa, indexb, memo);
    }

    private static int EditDist(String a, String b, int indexa, int indexb, int[][] memo){
        if((indexa >= a.length()) && (indexb >= b.length())){
            return 0;
        }
        else if((indexa >= a.length()) && (indexb < b.length())){
            return b.length() - indexb;
        }
        else if((indexa < a.length()) && (indexb >= b.length())){
            return a.length() - indexa;
        }
        else if(memo[indexa][indexb] != -1){
            return memo[indexa][indexb];
        }
        else{
            if(a.substring(indexa, indexa+1).equals(b.substring(indexb, indexb+1))){
                memo[indexa][indexb] = EditDist(a, b, indexa+1, indexb+1, memo);
            }
            else{
                memo[indexa][indexb] = Math.min(EditDist(
                        a, b, indexa+1, indexb+1, memo)+1,Math.min(EditDist(
                        a, b, indexa+1, indexb, memo)+1, EditDist(a, b, indexa, indexb+1, memo)+1));
            }
            return memo[indexa][indexb];
        }
    }



    public static void main(String [] args){
        String dood = "";

        System.out.println(dood.length());
    }



}
