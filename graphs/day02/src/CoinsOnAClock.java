import java.util.ArrayList;
import java.util.List;

public class CoinsOnAClock {
    private static char[] copyOf(char[] A) {
        char[] B = new char[A.length];
        System.arraycopy(A, 0, B, 0, A.length);
        return B;
    }
    private static void populate(char[] currentcoins, int n){
        for (int j = 0; j < n; j++) {
            currentcoins[j] = '.';
        }
    }

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        List<char[]> clock = new ArrayList<>();
        char[] currentcoins = new char[hoursInDay];
        int hour = 0;
        populate(currentcoins, hoursInDay);
        return clockwork(clock, currentcoins, pennies, nickels, dimes, hoursInDay, hour);
    }

    private static List<char[]> clockwork(List<char[]> clock, char[] currentcoins,int p, int n, int d, int hours, int hour){
        if((p==0) && (n ==0) && (d ==0)){
            clock.add(copyOf(currentcoins));
            return clock;
        }
        else{
             if(currentcoins[hour] == '.'){
                    for (int j = 0; j < 3; j++) {
                        if((j == 0) && (p > 0)){
                            currentcoins[hour] = 'p';
                            clockwork(clock, currentcoins, p-1, n, d, hours, (hour+1)%hours);
                            currentcoins[hour] = '.';
                        }
                        else if((j == 1)&&(n > 0)){
                            currentcoins[hour] = 'n';
                            clockwork(clock, currentcoins, p, n-1, d, hours, (hour+5)%hours);
                            currentcoins[hour] = '.';
                        }
                        else if((j==2)&&(d>0)){
                            currentcoins[hour] = 'd';
                            clockwork(clock, currentcoins, p, n, d-1, hours, (hour+10)%hours);
                            currentcoins[hour] = '.';
                        }

                    }
                }
                else{
                    return clock;
                }

            return clock;
        }
    }

}
