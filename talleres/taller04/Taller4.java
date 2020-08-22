public class Taller4 {
    
    public static int ej1(int[] array, int n) {
	int  max, temp;
	max = array[n];
	if(n !=0){
	    temp = ej1(array, n-1 );
	    if(temp > max)
		max = temp;
	}
	return max;
    }
    
    public static boolean ej2(int start, int[] nums, int target) {
	if (start >= nums.length) return target == 0;
	return ej2(start + 1, nums, target - nums[start])
	    || ej2( start+1 , nums, target );
    }
	
    
}