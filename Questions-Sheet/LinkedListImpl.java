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

    public void add(String data, int pos)
    {
        if(pos == 0)
        {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            return;
        }
        else
        {
            Node newNode = new Node(data);

            //travell to the pos-1 index
            Node temp = head;
            int start = 0;
            while(start < pos-1 && temp.next != null) //2nd cdn, if pos > length
            {
                start++;
                temp = temp.next;
            }

            //update the pointers
            if(temp.next != null)
                newNode.next = temp.next;
            temp.next = newNode;
        }
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

	public String delete(int pos)
    {
        if(head == null)
            return -1;

        if(pos == 0)
        {
            String data = head.data;
            head = head.next;
            return data;
        }

        int start = 0;
        Node temp = head;
        //reach to one node before the node you want to delete
        while(start < pos-1 && temp.next.next != null) //2nd cdn, if pos > length
        {
            start++;
            temp = temp.next;
        }

        String data = temp.next.data;
        temp.next = temp.next.next;
        return data;
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
	        Node temp = curr.next;

	        curr.next = prev;
	        prev = curr;
	        curr = temp;
	    }

	    //update head to prev - since new head will be stored in prev
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



Node reverseList(Node head) 
{
	//base case
	if(head == null || head.next == null)
		return head;
	
	//recursive call - 
	/**
		we give the smaller linked list to recusrion to reverse. it reverses the 
		smaller linkedlist and retrurns the newHead.
	*/
	Node newHead = reverseList(head.next);
	
	//small calc - inserting head at the end
	/**
		now, once we get the smaller linked list sorted, our jobs is to just 
		insert the original head at the end
	*/
	Node temp = newHead;
	while(temp.next != null)//reach to the last node
	{
		temp = temp.next;
	}
	temp.next = head;
	head.next = null;
	
	return newHead;
}
