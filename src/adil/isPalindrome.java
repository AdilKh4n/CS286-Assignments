package adil;

public class isPalindrome {
	public static boolean isPalindrome(Node head) {
	    if(head == null)
	        return true;
	 
	    Node p = head;
	    Node prev = new Node(head.data);
	 
	    while(p.next != null){
	        Node temp = new Node(p.next.data);
	        temp.next = prev;
	        prev = temp;
	        p = p.next;
	    }
	 
	    Node p1 = head;
	    Node p2 = prev;
	 
	    while(p1!=null){
	        if(p1.data != p2.data)
	            return false;
	 
	        p1 = p1.next;
	        p2 = p2.next;
	    }
	 
	    return true;
	}
	
	public static void main(String[] args) {
		 Node n = new Node(1);
	        n.next = new Node(2);
	        n.next.next = new Node(3);
	        n.next.next.next = new Node(2);
	        n.next.next.next.next = new Node(1);
	      //  n.next.next.next.next.next = new Node(4);
	      //  n.next.next.next.next.next.next = new Node(2);
	        Boolean b = isPalindrome(n);
	        System.out.println(b);
	}
}
