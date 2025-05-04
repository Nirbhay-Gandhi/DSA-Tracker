class Stack
{
    int top;
    int size;
    String[] arr;
    
    Stack(int size)
    {
        this.top = -1;
        this.size = size;
        
        arr = new String[size];
    }
    
    public void push(String element)
    {
        if(top == size-1)
        {
            System.out.println("Stack Overflow");   
            return;
        }
        arr[++top] = element;
    }
    
    public String pop()
    {
        if(top == -1)
        {
            System.out.println("Stack Underflow");
            return "";
        }
        
        return arr[top--]; 
    }
    
    public String peek()
    {
        if(top == -1)
            return "";
        return arr[top];
    }
}


public class Main
{
	public static void main(String[] args) {
	    Stack st = new Stack(4);
		st.push("1");
		st.push("2");
		st.push("3");
		st.push("4");
		st.push("5");
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}
