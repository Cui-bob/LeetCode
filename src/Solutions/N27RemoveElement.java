package Solutions;

public class N27RemoveElement {
	public int removeElement(int[] nums, int val) {
        if(nums.length==0){
            return 0;
        }
        int length = nums.length;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] == val){
                nums[i] = nums[length-1];
                length --;
            }
        }
        return length;
    }
}
