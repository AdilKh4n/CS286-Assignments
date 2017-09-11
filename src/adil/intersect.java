package adil;

import adil.SumLists.Node;

public class intersect {


    static Node head1, head2;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    /* Adds contents of two linked lists and return the head node of resultant list */
    int intersectat(Node first, Node second) {
        Node res = null; // res is head node of the resultant list
        Node prev = null;
       
        while(first!=null && second!=null)
        {
        	if(first.data == second.data)
        		return first.data;
        	else
        		first = first.next;
        		second = second.next;
        }
 
        return 0;
    }
    /* Utility function to print a linked list */
 
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }
 
    public static void main(String[] args) {
        intersect list = new intersect();
 
        // creating first list
        list.head1 = new Node(1);
        list.head1.next = new Node(5);
    //    list.head1.next.next = new Node(7);
      // list.head1.next.next.next = new Node(4);
      //  list.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(head1);
 
        // creating seconnd list
        list.head2 = new Node(4);
        list.head2.next = new Node(5);
        list.head2.next.next = new Node(5);
        list.head2.next.next.next = new Node(4);
        
        
        System.out.print("Second List is ");
        list.printList(head2);
 
        // add the two lists and see the result
        int rs = list.intersectat(head1, head2);
        System.out.print("Resultant List is " + rs);
        
    }
}