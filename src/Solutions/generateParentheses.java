package Solutions;
import java.util.ArrayList;
import java.util.List;
/**
 * Consider the generating process as a building process of a binary tree with value "(" and "right".
 * The constraints are:
 * 	1. Number of right braces can not exceed the number of left braces.
 * 	2. Number of left braces can not exceed the number of pairs.
 * 	3. If the sum of left braces and right braces reaches the twice of number of pairs, the process finishes.
 * Once finishing any of the process, add the generated string to the ArrayList.
 * @author Zhijie Cui
 *
 */
public class generateParentheses {

	 public List<String> generateParenthesis(int n) {
	        List<String> list = new ArrayList<String>();
	        String s = "";
	        int right = 0;
	        int left = 0;
	        nextNode(list, s, left, right, n);
	        return list;
	    }
	    
	    public void nextNode(List<String> list, String s, int left, int right, int n){
	        
	        // if finish
	        if(left + right == 2*n){
	            list.add(s);
	            return;
	        }
	        
	        // next to be left
	        if(left + 1 >= right && left + 1 <= n){
	            int leftedLeft = left + 1;
	            String leftedS = s + "(";
	            nextNode(list, leftedS, leftedLeft, right, n);
	        }
	        
	        // next to be right
	        if(left >= right + 1 && left <= n){
	            int rightedRight = right + 1;
	            String rightedS = s + ")";
	            nextNode(list, rightedS, left, rightedRight, n);
	        }
	    }
}
