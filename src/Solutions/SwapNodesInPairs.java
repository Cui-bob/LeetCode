package Solutions;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tmp = null;
        ListNode result = head.next;
        while(head!=null){
            if(head.next!=null){
                tmp = head.next.next;
                head.next.next = head;
                if(tmp!=null && tmp.next != null){
                    head.next = tmp.next;
                }else{
                    head.next = tmp;
                }
                head=tmp;
            }else{
                head = head.next;
            }
        }
        return result;
    }
}
