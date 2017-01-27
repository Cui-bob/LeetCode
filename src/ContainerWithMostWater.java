
public class ContainerWithMostWater {
	public static int maxArea_slow(int[] height)
	{
		int maxArea = 0;
		int factor = 0;
		for(int length = height.length - 1; length > 0; length--)
		{
			for(int i=0;i<height.length - length;i++)
			{
				int currentFactor = Math.min(height[i], height[i+length]);
				if(factor<currentFactor)
				{
					int currentArea = currentFactor*length;
					if(maxArea<currentArea)
					{
						maxArea = currentArea;
						factor = currentFactor;
					}
				}
				else
				{
					continue;
				}
			}
		}
		return maxArea;
	}
	
	public static int maxArea(int[] height)
	{
		int maxArea = Math.min(height[0],height[height.length-1])*(height.length-1);
		int x = 0,
			y = height.length-1;
		int i=x,
			j=y;
		boolean xLarger = height[x]>height[y];
		while(i<j)
		{
			if(xLarger)
			{
				if(height[--j] > height[y] && (j-i)*Math.min(height[i], height[j]) > maxArea)
				{
					y=j;
					maxArea = (j-i)*Math.min(height[i], height[j]);
				}
			}
			else
			{
				if(height[++i] > height[x] && (j-i)*Math.min(height[i], height[j]) > maxArea)
				{
					x=i;
					maxArea = (j-i)*Math.min(height[i], height[j]);
				}
			}
			xLarger = height[i]>height[j];
		}
		return maxArea;
	}
	
	
	public static void main(String[] args)
	{
		int[] height = {2,3,4,5,18,17,6};
		System.out.println(maxArea(height));
	}
}
