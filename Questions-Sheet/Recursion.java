public class Recursion {
    
    public static int factorialLoop(int n){
        int fact = 1;
        for(int i=1;i<=n;i++){
            fact = fact * i;
        }
        return fact;
    }

   public static int factorial(int n)
   {
        /**sabse chota case, jiske liye tumhe lag rha hai, ki sahi se chal jaega*/
        if(n == 0)
            return 1;

        /**using PMI, assume karlo ki chote problem kaa answer usne de diya hai*/
        int smallOutput = factorial(n-1);
        
        /**ab jo small problem kaa op aaya hai, usko use karke apna op nikal lo*/
        return n*smallOutput;
    }

    public static void main(String[] args)
    {
        System.out.println(factorial(5)); // 120
        System.out.println(factorialLoop(5)); // 120
    }
}

