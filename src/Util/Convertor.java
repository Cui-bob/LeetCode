package Util;


public class Convertor {

	public static ListNode arrayToLinkedList(int[] array){
		ListNode result = new ListNode(array[0]);
		ListNode current = result;
		for(int i=1; i<array.length; i++){
			current.next = new ListNode(array[i]);
			current = current.next;
		}
		return result;
	}
	
	public static void main(String args[]){
		int[] a = {1,2,3,4,5,6,7};
		ListNode test = arrayToLinkedList(a);
		System.out.println(test.toString());
	}
}
