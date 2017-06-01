package Solutions;

public class MergeTwoSortedList {

	public ListNode merge_old(ListNode l1, ListNode l2){
		ListNode resultNode;
		if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
		if(l1.val < l2.val){
			resultNode = new ListNode(l1.val);
			l1 = l1.next;
		}else{
			resultNode = new ListNode(l2.val);
			l2 = l2.next;
		}
		ListNode currentNode = resultNode;
		while(l1!=null && l2!=null){
			if(l1.val < l2.val){
				currentNode.next = new ListNode(l1.val);
				l1 = l1.next;
			}else{
				currentNode.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			currentNode = currentNode.next;
		}
		if(l1 == null){
			while(l2!=null){
				currentNode.next = new ListNode(l2.val);
				l2 = l2.next;
			}
		}else if(l2==null){
			while(l1!=null){
				currentNode.next = new ListNode(l1.val);
				l1 = l1.next;
			}
		}
		return resultNode;
	}
	
	public ListNode merge(ListNode l1, ListNode l2){
		if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
		ListNode result = new ListNode(0);
		ListNode current = result;
		while(l1!=null && l2!=null){
			if(l1.val < l2.val){
				current.next = l1;
				l1 = l1.next;
			}else{
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		while(l2!=null){
		    current.next = l2;
			l2 = l2.next;
			current = current.next;
		}
		while(l1!=null){
		    current.next = l1;
			l1 = l1.next;
			current = current.next;
		}
		return result.next;
    }
	
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){this.val=x;}
}
