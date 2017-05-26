import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class MergeKSortedLists {
	
	
	
	public ListNode merge_old(ListNode[] lists){
		ListNode result = new ListNode(0);
		ListNode current = result;
		Boolean toContinue = true;
		while(toContinue){
			toContinue = false;
			int smallest = Integer.MAX_VALUE;
			int index = 0;
			for(int i=0;i<lists.length;i++){
				if(lists[i]!=null && lists[i].val<smallest){
					smallest = lists[i].val;
					index = i;
					toContinue = true;
				}
			}
			if(toContinue == false){
				break;
			}
			current.next = lists[index];
			lists[index] = lists[index].next;
			current = current.next;
		}
		return result.next;
	}
	
	public ListNode merge_withSet(ListNode[] lists){
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> toRemove = new HashSet<Integer>();
		for(int i=0; i<lists.length; i++){
			if(lists[i]!=null){
				set.add(i);
			}
		}
		ListNode result = new ListNode(0);
		ListNode current = result;
		int smallest;
		int index;
		while(!set.isEmpty()){
			smallest = Integer.MAX_VALUE;
			index = -1;
			for(int i : set){
				if(lists[i]!=null && lists[i].val<smallest){
					smallest = lists[i].val;
					index = i;
					if(lists[i].next == null)
					{
						toRemove.add(i);
					}
				}else if(lists[i]==null){
					toRemove.add(i);
				}
			}
			set.removeAll(toRemove);
			toRemove.clear();
			if(index == -1){
				break;
			}
			current.next = lists[index];
			lists[index] = lists[index].next;
			current = current.next;
		}
		return result.next;
	}
	
	public ListNode merge_withfunction(ListNode[] lists){
		if(lists.length<=0){
			return null;
		}
		ListNode result = lists[0];
		for(int i=1;i<lists.length;i++){
			result = mergeTwoLists(result, lists[i]);
		}
		return result;
	}
	
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
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
	
	
	public ListNode merge(ListNode[] lists){
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(11, new Comparator<ListNode>(){

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
			
		});
		
		for(int i=0;i<lists.length;i++){
			while(lists[i]!=null){
				pq.add(lists[i]);
				lists[i] = lists[i].next;
			}
		}
		
		ListNode result = new ListNode(0);
		ListNode current = result;
		while((current.next = pq.poll())!=null){
			current = current.next;
		}
		return result.next;
	}
	
	
	public ListNode merge_withHeap(ListNode[] lists){
		
	}



}

