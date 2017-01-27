
public class IntegerToRoman {
	 public static String intToRoman(int num) {
		 String str = "";
		 String[] strSet = {"M","D","C","L","X","V","I"};
		 int[] intSet = {1000,500,100,50,10,5,1};
		 int state = 0;
		 while(state<7)
		 {
			 if(num/intSet[state]!=0)
			 {
				 str+=strSet[state];
				 num-=intSet[state];
			 }
			 else
			 {
				 if(state<6 && (num+intSet[(((state/2)+1)*2)])/intSet[state]!=0)
				 {
					 str+=strSet[(((state/2)+1)*2)];
					 str+=strSet[state];
					 num+=intSet[(((state/2)+1)*2)]-intSet[state];
				 }
/*				 switch(state)
				 {
				 case 0:
				 case 1:
					 if((num+intSet[2])/intSet[state] != 0)
					 {
						 str+=strSet[2];
						 str+=strSet[state];
						 num+=intSet[2]-intSet[state];
					 }
					 break;
				 case 2:
				 case 3:
					 if((num+intSet[4])/intSet[state] != 0)
					 {
						 str+=strSet[4];
						 str+=strSet[state];
						 num+=intSet[4]-intSet[state];
					 }
					 break;
				 case 4:
				 case 5:
					 if((num+intSet[6])/intSet[state] != 0)
					 {
						 str+=strSet[6];
						 str+=strSet[state];
						 num+=intSet[6]-intSet[state];
					 }
					 break;
				 default:
				 }  */
				 state++;
			 }
		 }
		 return str;
	 }
	 
	 public static void main(String[] args)
	 {
		 System.out.println(intToRoman(1999));
	 }
}
