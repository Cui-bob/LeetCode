package Solutions;

public class RegularExpression {
	
	public static void main(String[] arg)
	{
		System.out.println(isMatch("",".*"));
	}
	
	/**
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch2(String s, String p)
	{
		// if meet a *, just ignore it and check if the following part has a chance to match
		int sMatched = 0; // The index that has already proved to be matched
		int pMatched = 0;
		int sCurrent = 0; // The current checking index
		int pCurrent = 0;
		while(true)
		{
			switch(p.charAt(pCurrent))
			{
			case '.':
				if(pCurrent+1<p.length() && p.charAt(pCurrent+1) == '*')
				{
					
				}
				else
				{

				}
				break;
			default:
				if(pCurrent+1<p.length() && p.charAt(pCurrent+1)=='*')
				{
					
				}
				else
				{
					pCurrent++;
				}
			}
		}
	}
	
	public static boolean isMatch(String s, String p)
	{
		if(p.equals("") && s.equals(""))
			return true;
		if(p.equals(""))
			return false;
		if(p.equals(s))
			return true;
		if(s.equals("") && !p.endsWith("*"))
			return false;
		if(!(p.length()>1 && p.charAt(1)=='*'))
		{
			switch(p.charAt(0))
			{
			case '.':
				// return (one letter left in both s and p) OR (Iteration isMatch())
				if(s.length() ==1 && p.length() == 1)
					return true;
				else if(s.length()!=0 && p.length()!=0)
					return isMatch(s.substring(1),p.substring(1));
				else
					return false;
				//return (p.length()==1 && s.length()==1) || isMatch(s.substring(1),p.substring(1));
			case '*':
				return false; //need to be proved
			default:
				if(s.length()==0 || p.length()==0)
					return false;
				else if(!(p.charAt(0) == s.charAt(0)))
					return false;
				else
					return isMatch(s.substring(1), p.substring(1));
			}
		}
		else //(s.charAt(1) == '*')
		{
			switch(p.charAt(0))
			{
			case '.':
				int i = 0;
				while(!isMatch(s.substring(i), p.substring(2)))
				{
					if(i<s.length())
						i++;
					else
						return false;
				}
				return isMatch(s.substring(i), p.substring(2));
			case '*':
				return false;
			default:
				int j=0;
				while(!isMatch(s.substring(j), p.substring(2)))
				{
					if(j==s.length() || s.charAt(j) != p.charAt(0))
						return false;
					else
						j++;
				}
				return isMatch(s.substring(j), p.substring(2));
			}
		}
	}
}
