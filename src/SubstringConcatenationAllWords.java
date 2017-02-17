import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SubstringConcatenationAllWords {
	static int n=0;
	// the array solution is TLE
	// to improve
		public static List<Integer> findSubstring(final String s, final String[] words)
		{
			final int wLen = words[0].length();
			final int sLen = s.length();
			final int len = words.length;
			final List<Integer> list = new ArrayList<Integer>();
			String[] wordsCounts = new String[len];
			int[] counts = new int[len];
			int count = 0;
			outter1:
			for(int i=0;i<len;i++)
			{
				for(int j=0;j<=count;j++)
				{
					if(wordsCounts[j]!=null && wordsCounts[j].equals(words[i]))
					{
						counts[j]++;
						continue outter1;
					}
				}
				wordsCounts[count++] = words[i];
			}
			String[] tmpWords;
			int[] tmpInt;
			outter2:
			for(int i=0;i<sLen-len*wLen+1;i++)
			{
				tmpWords = wordsCounts.clone();
				tmpInt = counts.clone();
				inner1:
				for(int j=0;j<words.length;j++)
				{
					final String substr = s.substring(i+j*wLen,i+(j+1)*wLen);
					for(int k=0;k<count;k++)
					{
						if(tmpWords[k].equals(substr))
						{
							if(tmpInt[k]<0)
							{
								continue outter2;
							}
							else
							{
								tmpInt[k]--;
								continue inner1;
							}
						}
					}
				}
				for(int p=0;p<count;p++)
				{
					if(tmpInt[p]>=0)
					{
						continue outter2;
					}
				}
				list.add(i);
				
			}
			return list;
		}
	
	// passed
	public static List<Integer> findSubstring_slowNo3(final String s, final String[] words)
	{
		final int wLen = words[0].length();
		final int sLen = s.length();
		final int len = words.length;
		final List<Integer> index = new ArrayList<Integer>();
		final HashMap<String, Integer> wordsMap = new HashMap<String, Integer>(len);
		for(int i=0;i<len;i++)
		{
			if(!wordsMap.containsKey(words[i]))
			{
				wordsMap.put(words[i], 1);
			}
			else
			{
				wordsMap.put(words[i], wordsMap.get(words[i]).intValue()+1);
			}
		}
		HashMap<String, Integer> copy;
		outter:
		for(int i=0;i<sLen-len*wLen+1;i++)
		{
			copy =  new HashMap<String ,Integer>(wordsMap);
			for(int j=0;j<words.length;j++)
			{
				final String substr = s.substring(i+j*wLen,i+(j+1)*wLen);
				if(copy.containsKey(substr))
				{
					if(!copy.remove(substr, 1))
					{
						copy.put(substr,copy.get(substr).intValue()-1);
					}
				}
				else
				{
					//copy.put(substr, -1);
					continue outter;
				}
			}
			if(copy.isEmpty())
			{
				index.add(i);
			}
		}
		return index;
	}
	
	public static List<Integer> findSubstring_slowNo2(String s, String[] words)
	{
		if(words[0].length()==0)
		{		
			List<Integer> index = new ArrayList<Integer>();
			for(int i=0;i<s.length()+1;i++)
				index.add(i);
			return index; //exceptions to be test
		}
		boolean isSatisfy = true;
		boolean[] identifier = new boolean[words.length]; 
		for(int i=0;i<identifier.length;i++)
			identifier[i] = false;
		List<Integer> index = new ArrayList<Integer>();
		outter:
		for(int i=0;i<s.length()-words[0].length()*words.length+1;i++)
		{
			inner:
			for(int j=0;j<words.length;j++)
			{
				boolean toContinue = true;
				for(int k=0;k<words.length;k++)
				{
					if(s.substring(i+j*words[0].length(), i+(j+1)*words[0].length()).equals(words[k]))
					{
						if(identifier[k]!=true)
						{
							identifier[k]=true;
							toContinue = false;
							continue inner;
						}
					}
				}
				if(toContinue)
					break;
			}
			for(int q=0;q<identifier.length;q++)
			{
				isSatisfy = (isSatisfy && identifier[q]);
				identifier[q] = false;
			}
			if(isSatisfy == true)
			{
				index.add(i);
			}
			isSatisfy = true;
		}
		return index;
	}
	
	public static List<Integer> findSubstring_slow(String s, String[] words) {
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
				for(int k=0;k<currentIndex.length;k++)
					System.out.print(currentIndex[k]);
				System.out.println("  "+i+" "+j + "  "+start + " " + (++n));
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
		String orgStr = "wordgoodgoodgoodbestword";
		String[] str = {"word","good","best","good"};
		System.out.println(findSubstring(orgStr,str));
	}
}
