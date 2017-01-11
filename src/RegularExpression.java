
public class RegularExpression {
	public boolean isMatch(String s, String p)
	{
		/*
		 * input: aa...a
		 * output: true/false 
		 */
//		if(s.length()!=0 && !isMatch(s,p))
//		{
//			return isMatch(s.substring(1),p);
//		}
//		else if(s.length() == 0)
//		{
//		return false;
		
		if(s.equals(p))
			return true;
		if(!(s.charAt(1)=='*'))
		{
			switch(s.charAt(0))
			{
			case '.':
				// return (one letter left in both s and p) OR (Iteration isMatch())
				return (s.length()==1 && p.length()==1) || isMatch(s.substring(1),p.substring(1));
			case '*':
				return false; //need to prove
			default:
			}
		}
		else //(s.charAt(1) == '*')
		{
			switch(s.charAt(0))
			{
			case '.':
				break;
			case '*':
				break;
			default:
			}
		}
	}
}
