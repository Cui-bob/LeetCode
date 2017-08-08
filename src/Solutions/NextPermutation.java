package Solutions;

import java.util.Arrays;

public class NextPermutation {
	public static void nextPermutation(int[] nums) {
		if(nums.length<2)
			return;
		loop(nums,nums.length-2);
    }
	
	public static void loop(int[] nums, int count){
		if(nums[count]>nums[count+1]){
			if(count-1>=0){
				loop(nums,count-1);
			}
			else{
				Arrays.sort(nums, 0, nums.length);
			}
		}else{
			Arrays.sort(nums, count+1, nums.length);
			int n = 1;
			while(count+n<nums.length && nums[count]>=nums[count+n]){
				n++;
			}
			if(count+n<nums.length){
				int tmp = nums[count];
				nums[count] = nums[count+n];
				nums[count+n] = tmp;
			}
		}
	}
	
	
	public static void main(String[] args){
		int[] a  = {1,1};
		nextPermutation(a);
		System.out.println(Arrays.toString(a));
	}
}
