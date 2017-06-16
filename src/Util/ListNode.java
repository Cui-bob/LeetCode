package Util;


public class ListNode {

	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }
	public String toString(){
		int counter = 0;
		String str = val + "->";
		ListNode current = next;
		while(current!=null && counter++ <=10){
			str += current.val + "->";
			current = current.next;
		}
		return str;
	}
}
