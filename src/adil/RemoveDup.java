package adil;

import java.util.HashMap;

public class RemoveDup {
	//Unsorted
	public Node removDup(Node head)
	{
		if(head==null)
		{
			System.out.println("Empty list");
		}
		
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		
		Node currnode = head.next;
		Node prevnode = head;
		Node temp;
        
		hm.put(head.data, 1);
		while(currnode!=null)
		{
			int data = currnode.data;
			if(hm.containsKey(data)){
				prevnode.next=currnode.next;
				temp = currnode;
				currnode = currnode.next;
				temp.next = null;
			}
			else
			{
				hm.put(data, 1);
				prevnode = currnode;
				currnode = currnode.next;
			}
			
		}
		return head;
	}
	
	//Sorted LL
	public Node deleteDuplicates(Node head) {
        Node list = head;
         
         while(list != null) {
        	 if (list.next == null) {
        		 break;
        	 }
        	 if (list.data == list.next.data) {
        		 list.next = list.next.next;
        	 } else {
        		 list = list.next;
        	 }
         }
         
         return head;
    }

	
	public void display(Node head){
        Node n=head;
        while(n!=null){
            System.out.print("->" + n.data);
            n=n.next;
        }
	}
	
	public static void main(String[] args) {
		 Node n = new Node(1);
	        n.next = new Node(2);
	        n.next.next = new Node(2);
	        n.next.next.next = new Node(3);
	        n.next.next.next.next = new Node(4);
	        n.next.next.next.next.next = new Node(4);
	        n.next.next.next.next.next.next = new Node(2);
	        System.out.print("Original List : ");
	        RemoveDup rm = new RemoveDup();
	        rm.display(n);
	        System.out.print("\n Updated List: ");
	        Node x =rm.removDup(n);
	        rm.display(x);
	}
}	
	class Node{
	    int data;
	    Node next;
	    public Node(int data){
	        this.data = data;
	        next = null;
	    }

	}
