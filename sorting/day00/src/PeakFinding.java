
public class PeakFinding {

    // Return -1 is left is higher, 1 if right is higher, 0 if peak
    private static int peak(int i, int[] nums) {
        if (i>0 && nums[i] < nums[i-1])
            return -1;
        if (i<nums.length-1 && nums[i] < nums[i+1])
            return 1;
        return 0;
    }

    // Return -1 is left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x>0 && nums[y][x] < nums[y][x-1])
            return -1;
        if (x<nums[0].length-1 && nums[y][x] < nums[y][x+1])
            return 1;
        return 0;
    }

    // Return -1 is up is higher, 1 if down is higher, 0 if peak
    private static int peakY(int x, int y, int[][] nums) {
        if (y>0 && nums[y][x] < nums[y-1][x])
            return -1;
        if (y<nums.length-1 && nums[y][x] < nums[y+1][x])
            return 1;
        return 0;
    }

    // These two functions return the index of the highest value along the X or Y axis, with the given
    // value for the other axis. Searches between hi (exclusive) and lo (inclusive)
    private static int maxXIndex(int y, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int x = lo; x < hi; x++) {
            if (maxIndex == -1 || nums[y][x] > nums[y][maxIndex])
                maxIndex = x;
        }
        return maxIndex;
    }
    private static int maxYIndex(int x, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int y = lo; y < hi; y++) {
            if (maxIndex == -1 || nums[y][x] > nums[maxIndex][x])
                maxIndex = y;
        }
        return maxIndex;
    }



    public static int findOneDPeak(int[] nums){
    	int low = 1;
    	int high = nums.length-1;
        int mid;
    	while(low < high){
    	    mid = (low + high)/2;
    	    if((nums[mid] > nums[mid - 1]) && (nums[mid] > nums[mid + 1])){
    	        return mid;
            }
            else if((nums[mid] >= nums[mid - 1]) && (nums[mid] <= nums[mid + 1])){
    	        low = mid + 1;
            }
            else{
    	        high = mid - 1;
            }
        }
        mid = (low + high)/2;
        return mid;
    }

    public static int[] findTwoDPeak(int[][] nums){
//        int max = 0;
//        int[] answer = {0,0};
//    	for(int i = 0; i < nums.length; i++){
//    	    int c = findOneDPeak(nums[i]);
//    	    if(nums[i][c] > max){
//    	        max = nums[i][c];
//    	        answer = new int[]{i, c};
//            }
//        }
//        return answer;
        int c = nums[0].length/2;
        int[] result = Peaks(nums, c);

        return result;

    }

    private static int[] Peaks(int[][] nums, int c){

        int rowmax = -1;
        for(int i = 1; i < nums.length-1; i++){
            if((nums[i][c] >= nums[i-1][c]) && (nums[i][c] >= nums[i+1][c])){
                rowmax = i;
                break;
            }

        }
        if(rowmax == -1){
            if(nums[0][c] > nums[nums.length-1][c]){
                rowmax = 0;
            }
            else{
                rowmax = nums.length - 1;
            }
        }


        if((c-1 >= 0) && (c+1 < nums.length)){
            if((nums[rowmax][c] > nums[rowmax][c-1]) && (nums[rowmax][c] > nums[rowmax][c+1])){
                int[] answer = new int[]{rowmax, c};
                return answer;
            }
            else if((nums[rowmax][c] > nums[rowmax][c-1]) && (nums[rowmax][c] < nums[rowmax][c+1])){
                return Peaks(nums, c+1);
            }
            else{
                return Peaks(nums, c-1);
            }
        }
        else if((c-1 >= 0) && (c+1 >= nums.length)){
            if((nums[rowmax][c] >= nums[rowmax][c-1])){
                int[] answer = new int[]{rowmax, c};
                return answer;
            }
            else{
                return Peaks(nums, c-1);
            }

        }
        else{
            if((nums[rowmax][c] >= nums[rowmax][c+1])){
                int[] answer = new int[]{rowmax, c};
                return answer;
            }
            else{
                return Peaks(nums, c+1);
            }

        }


    }

}
