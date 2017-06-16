package Solutions;

import java.util.HashMap;
import java.util.Map;

public class N26RemoveDuplicatesfromSortedArray {
	public int removeDuplicatesWithMap(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int[] newNums = new int[nums.length];
        int length = 0;
        for(int i=0;i<nums.length;i++){
            if(!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],1);
                newNums[length++] = nums[i];
            }
        }
        for(int i=0;i<length;i++){
            nums[i] = newNums[i];
        }
        return length;
    }
	
	public int removeDuplicates(int[] nums) {
        int length = 1;
        if(nums.length==0){
        	return 0;
        }
        int last = nums[0];
        for(int i=1;i<nums.length;i++){
        	if(nums[i]!=last){
        		nums[length++] = nums[i];
        		last = nums[i];
        	}
        }
        return length;
    }
}
