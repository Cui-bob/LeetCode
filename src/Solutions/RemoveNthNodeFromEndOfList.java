package Solutions;

public class RemoveNthNodeFromEndOfList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) 
	{
		ListNode current = head;
		ListNode toConnect;
		for(int i=0;i<n;i++)
		{
			if(current.next == null)
			{
				if(n>i || i == n-1)
				{
					return head.next; 
				}
				return null;
			}
			else
			{
				current = current.next;
			}
		}
		toConnect = head;
		while(current.next!=null)
		{
			current = current.next;
			toConnect = toConnect.next;
		}
		toConnect.next = toConnect.next.next;
		return head; 
    }
}
