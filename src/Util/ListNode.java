package Util;


public class ListNode {

	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }
	public String toString(){
		String str = val + "->";
		ListNode current = next;
		while(current!=null){
			str += current.val + "->";
			current = current.next;
		}
		return str;
	}
}
