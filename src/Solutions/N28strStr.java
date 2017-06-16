package Solutions;

public class N28strStr {

	public static void main(String[] args){
		System.out.println(strStr("s  ", "  "));
	}
	
	public static int strStr(String haystack, String needle) {
        if(haystack=="" && needle ==""){
            return 0;
        }
        for(int i=0;i<haystack.length() - needle.length() + 1;i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
