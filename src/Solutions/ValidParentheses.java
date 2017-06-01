package Solutions;

public class ValidParentheses {
	class Stack{
        int size;
        char[] elements;
        int top =-1;
        public Stack(int size){
        	this.size = size;
            elements = new char[size];
        }
        
        public void push(char c){
            elements[++top] = c;
        }
        
        public void pop(){
            top--;
        }
        
        public char top(){
        	if(top < 0)
        		return 0;
        	if(elements[top] == '('){
        		return ')';
        	}
        	else if(elements[top] == '['){
        		return ']';
        	}
        	else{
        		return '}';
        	}
        }
    }
    
    public boolean isValid(String s) {
        Stack stack = new Stack(s.length());
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
                if(s.charAt(i) != stack.top()){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        if(stack.top==-1){
            return true;
        }
        return false;
    }
    
    public static void main(String args[]){
    	ValidParentheses vp = new ValidParentheses();
    	System.out.print(vp.isValid("]"));
    }
}
