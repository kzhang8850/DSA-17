public class DungeonGame {

    public static int minInitialHealth(int[][] map) {
        int row = 0;
        int col = 0;
        int[][]memo = new int[map.length+1][map[0].length+1];

        for (int i = 0; i < map.length+1; i++) {
            for (int j = 0; j < map[0].length+1; j++) {
                memo[i][j] = -1;
            }
        }

        return Math.abs(Health(map, row, col, memo)) + 1;
    }

    private static int Health(int[][] map, int row, int col, int[][] memo){
        if((row == map.length-1) && (col == map[0].length-1)){
            return map[row][col];
        }
        else if (memo[row][col] != -1) {
            return memo[row][col];
        }
        else{
            if((row+1) == map.length){
                memo[row][col] = Health(map, row, col+1, memo) + map[row][col];
            }
            else if((col+1) == map[0].length){
                memo[row][col] = Health(map, row+1, col, memo) + map[row][col];
            }
            else{
                memo[row][col] = find_min(Health(map, row+1, col, memo) + map[row][col],
                                          Health(map, row, col+1, memo) + map[row][col]);
            }

            return memo[row][col];
        }
    }

    private static int find_min(int a, int b){
        if(Math.abs(a) > Math.abs(b)){
            return b;
        }
        else{
            return a;
        }
    }


}
