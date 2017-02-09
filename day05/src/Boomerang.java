public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
        // TODO

        int total = 0;
        for(int i = 0; i < points.length; i++){
            MyHashMap<Integer, Integer> distances = new MyHashMap<Integer, Integer>();
            for(int j = 0; j < points.length; j ++){
                int vector = getSquaredDistance(points[i], points[j]);
                int num = 0;
                if(distances.get(vector) == null){
                    num = 0;
                }
                else{
                    num = distances.get(vector);
                }
                distances.put(vector, num + 1);
            }
            for(int distance: distances.keySet()){
                int freq = distances.get(distance);
                System.out.println(freq);
                if(freq > 1){
                    total += (freq * (freq-1));
                }
            }
        }
        return total;
    }

    private static int getSquaredDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}
