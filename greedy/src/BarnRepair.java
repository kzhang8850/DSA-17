import com.sun.tools.corba.se.idl.IncludeGen;

import java.util.*;


public class BarnRepair {
    public static int solve(int M, int S, int C, int[] occupied) {
        if(M >= occupied.length){
            return occupied.length;
        }
        Arrays.sort(occupied);
        ArrayList<int[]> gaps = new ArrayList<>();
        for (int i = 0; i < occupied.length-1; i++) {
            int[] thing = new int[2];
            thing[0] = occupied[i+1] - occupied[i];
            thing[1] = occupied[i];
            gaps.add(thing);
        }

        Collections.sort(gaps, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -1 * Integer.compare(o1[0], o2[0]);
            }
        });

        int numStalls = 0;
        int previousStall = occupied[0];
        for (int i = M-2; i >= 0; i--) {
            int stuff = gaps.get(i)[1];
            numStalls  = numStalls + (stuff - previousStall + 1);
            for (int j = 0; j < occupied.length-1; j++) {
                if(stuff == occupied[j]){
                    previousStall = occupied[j+1];
                    break;
                }
            }
        }
        numStalls  = numStalls + (occupied[occupied.length - 1] - previousStall + 1);
//        System.out.println(numStalls);
        return numStalls;
    }
}
