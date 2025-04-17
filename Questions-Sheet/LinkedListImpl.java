class MyLinkedList
{
	Node head;
	private int size;
	
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
	
	public void print()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print("NULL");
	}
}


public class Main
{
	public static void main(String[] args) {
		MyLinkedList lst = new MyLinkedList();
        lst.add("T");
        lst.add("I");
        lst.add("G");
        lst.add("E");
        lst.add("R");

        lst.addFirst("A");

        lst.print();
	}
}
