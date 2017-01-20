import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SubstringConcatenationAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
		if(words[0].equals(""))
		{
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<s.length()+1;i++)
            	list.add(i);
            return list;
		}
		int[] index = new int[words.length];
		for(int i=0;i<index.length;i++)
		{
			index[i] = i;
		}
		String orgStr = s;
		String[] str = words;
		HashSet<Integer> hashSet = new HashSet<Integer>();
		allRange(index, 0, str, hashSet, orgStr);
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(hashSet);
		return list;
    }
	
	private static void swap(int[] index, int i, int j)
	{
		if(i>=index.length || j>=index.length || i<0 || j<0 )
			return;
		int temp = index[i];
		index[i] = index[j];
		index[j] = temp;
	}
	
	public static void allRange(int[] index, int start, String[] str, HashSet<Integer> hashSet, String orgStr)
	{
		int[] currentIndex = new int[index.length];
		System.arraycopy(index, 0, currentIndex, 0, index.length);
		for(int j = start; j<currentIndex.length;j++)
		{
			if(start == 0 && j!=0)
				continue;
			for(int i=j;i<currentIndex.length;i++)
			{
				if(i == j && i!=0)
					continue;
				swap(currentIndex, j, i);
//				for(int k=0;k<currentIndex.length;k++)
//					System.out.print(currentIndex[k]);
//				System.out.println("  "+i+" "+j + "  "+start + " " + (++n));
				//check the substring here
				String currentStr="";
				for(int k=0;k<index.length;k++)
				{
					currentStr+=str[currentIndex[k]];
				}
				//System.out.println(currentStr);
				hashSet.addAll(substring(orgStr,currentStr));
				
				if(j!=currentIndex.length-2)
				{
					allRange(currentIndex, j + 1, str, hashSet, orgStr);
				}
				swap(currentIndex, j, i);
			}
		}
	}
	
	public static HashSet<Integer> substring(String str, String substr)
	{
		HashSet<Integer> substrList = new HashSet<Integer>();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i) == substr.charAt(0) && i+substr.length()-1<str.length())
			{
				substrList.add(i);
			}
		}
		for(int indexSubstr = 1; indexSubstr < substr.length(); indexSubstr++)
		{
			for(Iterator<Integer> it=substrList.iterator();it.hasNext();)
			{
			   Integer k = it.next();
			   if(str.charAt(k+indexSubstr)!=substr.charAt(indexSubstr))
			   {
					it.remove();
			   }
			}
		}
		
		return substrList;
	}
	
	public static void main(String[] arg)
	{
		String orgStr = " ";
		String[] str = {"",""};
		System.out.println(findSubstring(orgStr,str));
	}
}
