import java.util.Arrays;

/**
 * Created by sidd on 2/20/17.
 */
public class PeakFinding {

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
