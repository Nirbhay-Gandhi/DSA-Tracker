
public class StringToInt {
    
    public static int stringToInt(String str)
    {
        int result = 0;
        for(int i=0; i<str.length(); i++)
		{
            /**
             * this is the matheatical formula we use to convert string to int 
             * result = result*10 + str.charAt(i)-'0';
             * 234 -> 0*10 + 2 = 2 | 2*10 + 3 = 23 | 23*10 + 4 = 234
             */
			result = result*10 + str.charAt(i)-'0';
		}
		return result;
    }

    public static int stringToIntRec(String str)
    {
        /**
         * Here, we had a choise to break the string into parts in 2 ways:- "3 | 457" or "345 | 7"
         * this is, either we can work on the 1st part of the string and give the rest to the recursion or we can work on the last part
         * of the string and let the recursion take care of the 1st part.
         * 
         * In 1st - recursion will give us "457", then we have to add "3" at front -> 3*10^3 + 457 = 3457
         * In 2nd - recursion will give us "345", then we have to add "7" at back -> 345*10 + 7 = 3453
         * 2nd one seems easy and practical. 
         */

		//base case
		if(str.length() == 1)
			return str.charAt(0)-'0';
		
		//recursive call
		int smallAns = stringToInt(str.substring(0,str.length()-1));
		
		//small calc
		int finalAns =  smallAns*10 + str.charAt(0)-'0';
		return finalAns;
    }

    public static void main(String[] args)
    {
        String str = "6565";
        int result = stringToInt(str);
        int resultRec = stringToIntRec(str);
        System.out.println("The integer value of the string is: " + resultRec);
        System.out.println("The integer value of the string is: " + result);
        System.out.println("The integer value of the string is: " + Integer.parseInt(str));
    }
}
