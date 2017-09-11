package adil;


public class kthelement {
	
	public Node kthelement(Node head,int k)
	{
		if(head==null)
		{
			System.out.println("Empty list");
		}
	
		Node currnode = head;
		Node prevnode = head;
		
		for(int i = 0 ;i<k-1;i++)
		{
			currnode = currnode.next;
			if(currnode == null)
			{return null;}
		}
		
		while(currnode.next != null)
		{
		prevnode = prevnode.next;
		currnode = currnode.next;
	}
		System.out.print("Oa" + prevnode.data);
		return prevnode;
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
	        n.next.next = new Node(3);
	        n.next.next.next = new Node(4);
	        n.next.next.next.next = new Node(5);
	      //  n.next.next.next.next.next = new Node(4);
	      //  n.next.next.next.next.next.next = new Node(2);
	        System.out.print("Original List : ");
	        kthelement rm = new kthelement();
	        rm.display(n);
	        System.out.print("\n Updated List: ");
	        Node x =rm.kthelement(n,3);
	        rm.display(x);
	}
}
