import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberLogic {

    public static int countDigits(int num) //558
    {
        int count=0;
        while(num > 0)
        {
            num = num/10;
            count++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        int n = 1;
        System.out.println(countDigits(2)); 
    }
}
