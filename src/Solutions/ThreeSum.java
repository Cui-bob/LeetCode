package Solutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++)
		{
			if(i>0 && nums[i]==nums[i-1])
				continue;
			for(int j=i+1;j<nums.length;j++)
			{
				if(j>i+1 && nums[j]==nums[j-1])
					continue;
				for(int k=j+1;k<nums.length;k++)
				{
					if(k>j+1 && nums[k]==nums[k-1])
						continue;
					if(nums[i]+nums[j]+nums[k]==0)
					{
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						result.add(list);
						list = new ArrayList<Integer>();
					}
				}
			}
		}
		return result;
	}
	
	
	
	public static void main(String[] arg)
	{
		int[] nums = {2,-1,-1,-1,0,0,0};
		System.out.println(threeSum(nums));
	}
}
