public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        long low = 1;
        long high = n;
        long mid = (low+high)/2;

        while(low <= high){
            mid = (low+high)/2;
            if(isBadVersion.isFailingVersion(mid) && !isBadVersion.isFailingVersion(mid - 1)){
                return mid;
            }
            else if(isBadVersion.isFailingVersion(mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
