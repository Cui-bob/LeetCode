package Solutions;

import Util.Convertor;
import Util.ListNode;

public class ReverseNodesInKGroup {

	public static void main(String[] args){
		int[] a = {1,2,3,4};
		ListNode head = Convertor.arrayToLinkedList(a);
		System.out.println(reverse(head, 2));
	}
	
	public static ListNode reverse(ListNode head, int n){
		ListNode result = null;
		ListNode tmp1=null, tmp2=null;
		while(head != null)
		{
			tmp1 = head;
			head = getNodeAfter(head, n-1);
			if(result==null){
				if(head!=null){
					result = head;
				}else{
					result = tmp1;
					break;
				}
			}
			if(tmp2!=null){
				if(head!=null){
					tmp2.next = head;
				}else
				{
					tmp2.next = tmp1;
					break;
				}
			}
			tmp2 = tmp1;
			if(head!=null){
				head = head.next;
			}
			for(int i=n-1;i>=1;i--){
				tmp1 = getNodeAfter(tmp2, i-1);
				if(tmp1!=null && tmp1.next!=null){
					(tmp1.next).next = tmp1;
				}
			}
			if(head==null){
				tmp1.next =null;
			}
		}
		return result;
	}
	
	public static ListNode getNodeAfter(ListNode head, int n){
		ListNode res = head;
		for(int i=0;i<n;i++){
			if(res==null){
				return null;
			}else{
				res = res.next;
			}
		}
		return res;
	}
}
