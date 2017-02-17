import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {
	public static List<String> letterCombinations(String digits){
		if(digits.length()==0)
            return new ArrayList<String>();
		String[][]  letters = {{"","",""},{"a","b","c"},{"d","e","f"},
				{"g","h","i"},{"j","k","l"},{"m","n","o"},
				{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
		int totalNum = 1;
		for(int i=0;i<digits.length();i++)
		{
			if(digits.charAt(i)=='1')
			{
				return new ArrayList<String>();
			}
			totalNum *= letters[(int)digits.charAt(i) - 49].length;
		}
		
		int currentNum = totalNum;
		List<String> result = new ArrayList<String>(totalNum);
		for(int i=0;i<totalNum;i++)
		{
			result.add("");
		}
		
		for(int i=0;i<digits.length();i++)
		{
			currentNum /= letters[(int)digits.charAt(i) - 49].length;
			for(int j=0;j<totalNum;j++)
			{
				result.set(j, result.get(j) + letters[(int)digits.charAt(i) - 49][(j/(currentNum))%letters[(int)digits.charAt(i) - 49].length]);
			}
		}
		return result;
	}
	
	
	public static void main(String[] arg)
	{
		String digits = "12";
		System.out.print(letterCombinations(digits));
	}
}

