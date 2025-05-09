import java.util.*;
public class Solution {

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) 
	{
		//base case
		if(input.isEmpty())
			return;
		
		//recursive call - on smaller problem
		int firstElement = input.pop();
		reverseStack(input, extra);

		//small calc
		while(!input.isEmpty())
			extra.push(input.pop());

		input.push(firstElement);
	
		while(!extra.isEmpty())
			input.push(extra.pop());
	}

  public static void main(String[] args) {
		Stack<Integer> stk = new Stack<>();
		Stack<Integer> extra = new Stack<>();
		
		stk.push(7);
		stk.push(1);
		stk.push(2);
		stk.push(3);
		
		System.out.println(stk);
		reverseStack(stk, extra);
		System.out.println(stk);
	}
}
