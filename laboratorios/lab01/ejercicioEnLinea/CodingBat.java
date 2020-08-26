
/**
 * Write a description of class CodingBat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CodingBat
{
    public int bunnyEars(int bunnies) { 
        if (bunnies == 0) return 0;  
        return 2+ bunnyEars(bunnies-1); 
    } 

    public int bunnyEars2(int bunnies) { 
        if (bunnies == 0) return 0; 
        if (bunnies % 2 == 0) return 3+ bunnyEars2(bunnies-1); 
        return 2 +bunnyEars2(bunnies-1); 
    } 

    public int fibonacci(int n) { 
        if (n== 0 ) return 0; 

        else if (n== 1) return 1; 
        return fibonacci(n-1) +fibonacci(n-2) ; 
    } 

    public int triangle(int rows) { 
        if (rows == 0) return 0; 
        if (rows ==1) return 1; 
        return rows + triangle(rows-1); 
    } 

    public int sumDigits(int n) { 
        if (n <10) return n; 
        return n%10 + sumDigits(n/10); 
    } 

    public boolean groupNoAdj(int start, int[] nums, int target) { 
        if(start >= nums.length){ 
            return target==0; 
        } 
        if (groupNoAdj(start+2,nums,target-nums[start]))return true; 
        if(groupNoAdj(start+1,nums,target)) return true; 
        return false; 
    } 

    public boolean groupSum6(int start, int[] nums, int target) { 
        if (start>= nums.length) 
            return (target == 0); 
        if (groupSum6(start+1, nums, target - nums[start])) return true; 
        if (nums[start] != 6 && groupSum6(start+1, nums, target)) return true; 
        return false; 
    } 

    public boolean groupSum5(int start, int[] nums, int target) { 
        if(start==nums.length) return target==0; 
        if(nums[start]%5==0 && start < nums.length-1 && nums[start+1]==1) nums[start+1]=0; 
        if(groupSum5(start+1,nums,target-nums[start])) return true; 
        if(nums[start]%5!=0 && groupSum5(start+1,nums,target)) return true; 
        return false; 
    } 

    public boolean splitArray(int[] nums) { 


        return groupSum(0,nums,0,0); 

    } 

    private boolean groupSum(int start,int[] nums,int sum1,int sum2) { 
        if (start >= nums.length) return sum1==sum2; 
        if (groupSum(start+1,nums,sum1+nums[start],sum2)) return true; 
        if (groupSum(start+1,nums,sum1,sum2+nums[start])) return true; 
        return false; 
    } 


    public boolean splitArrayAux(int [] nums, int start, 

    int first, int second) { 

        if (start == nums.length) { 
            return first == second; 
        } else { 
            return splitArrayAux(nums, start + 1, 
                first + nums[start], second) 
            || splitArrayAux(nums, start + 1, first, 
                second + nums[start]); 
        } 
    } 
}
