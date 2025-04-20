class MyLinkedList
{
	Node head;
	private int size;
	
	//creating a Node class
	class Node
	{
		String data;
		Node next;
		
		Node(String data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	//LinkedList constructor
	MyLinkedList()
	{
		this.head = null;
		this.size = 0;
	}
	
	public void addFirst(String data)
	{
		Node newNode = new Node(data);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	
	public void add(String data)
	{
		Node newNode = new Node(data);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			Node temp = head;
			
			//make temp reach to last node
			while(temp.next != null)
				temp = temp.next;
			temp.next = newNode;
		}
		size++;
	}
	
	public String deleteFirst()
	{
		if(head == null)
        {
            return "";
        }
		size--;
        head = head.next;
		return head.data;
	}
	
	public String deleteLast()
	{
		if(head == null)
			return "";
		if(head.next == null)
		{
            size--;
			String val = head.data;
			head = null;
			return val;
		}
			
		size--;
		Node temp = head;
		
		//make temp to reeach 2nd last node
		while(temp.next.next != null)
			temp = temp.next;
		String val = temp.next.data;
		temp.next = null;
		return val;
	}
	
	public String print()
	{
	    StringBuilder lstStr = new StringBuilder("");
	    
		Node temp = head;
		while(temp != null)
		{
			lstStr.append(temp.data + "->");
			temp = temp.next;
			//System.out.print(temp.data + "->");
		}
		//System.out.print("NULL");
		
		
		lstStr.append("NULL");
        return lstStr.toString();
	}
	
	public void reverse()
	{
	    if(head == null || head.next == null)
	        return;
	        
	    Node prev = null, curr = head;
	    while(curr != null)
	    {
	        Node nxt = curr.next;

	        curr.next = prev;
	        prev = curr;
	        curr = nxt;
	    }

	    //update head to prev
	    head = prev;
	}
	
	public String toString()
	{
	    return this.print();
	}
}




public class Main
{
	public static void main(String[] args) {
		MyLinkedList lst = new MyLinkedList();
        lst.add("1");
        lst.add("3");
        lst.add("7");
        lst.add("12");
        
        System.out.println(lst);
        
        lst.reverse();
        
        System.out.println(lst);
	}
}
