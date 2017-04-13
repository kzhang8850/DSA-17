import java.util.*;

public class MixingMilk {
    public static int solve(int M, int N, int[] units, int[] price) {
        ArrayList<int[]> inventory = new ArrayList<>();
        for (int i = 0; i < price.length; i++) {
            int[] thing = new int[2];
            thing[0] = price[i];
            thing[1] = units[i];
            inventory.add(thing);
        }

        Collections.sort(inventory, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int buying = 0;
        int index = 0;
        int money = 0;
        while(buying < M){
            int cost = inventory.get(index)[0];
            int amount = inventory.get(index)[1];
            if((buying + amount) < M){
                money += amount * cost;
                buying += amount;
            }
            else{
                money += (M - buying) * cost;
                buying += amount;
            }
            index++;
        }
        System.out.println(money);
        return money;
    }
}
