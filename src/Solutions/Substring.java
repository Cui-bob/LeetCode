package Solutions;
import java.util.ArrayList;
import java.util.List;

public class Substring {
	public static List<Integer> substring(String str, String substr)
	{
		List<Integer> substrList = new ArrayList<Integer>();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i) == substr.charAt(0) && i+substr.length()-1<str.length())
			{
				substrList.add(i);
			}
		}
		for(int indexSubstr = 1; indexSubstr < substr.length(); indexSubstr++)
		{
			for(int j=0;j<substrList.size();j++)
			{
				if(str.charAt(substrList.get(j)+indexSubstr)!=substr.charAt(indexSubstr))
				{
					substrList.remove(j);
					j--;
				}
			}
		}
		return substrList;
	}
	
	public static void main(String[] arg)
	{
	}
}
