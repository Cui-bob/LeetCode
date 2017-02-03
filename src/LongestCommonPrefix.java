
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length==0)
		{
			return "";
		}
        int length = 0;
        for(;;)
        {
        	if(strs[0].length()>length)
        	{
        		char currentChar = strs[0].charAt(length);
	            for(int i=0;i<strs.length;i++)
	            {
	            	if(strs[i].length()>length && strs[i].charAt(length)==currentChar)
	            	{
	            		continue;
	            	}
	            	else
	            	{
	            		return strs[0].substring(0, length);
	            	}
	            }
	        	length++;
        	}
        	else
        	{
        		return strs[0].substring(0, length);
        	}
        }
    }
	
	public static void main(String[] arg)
	{
		String[] strs = {"aaa","aaaa"};
		System.out.println(longestCommonPrefix(strs));
	}
}
