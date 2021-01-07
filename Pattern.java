Pattern programs in java : Pattern 16

1
2 6
3 7 10 
4 8 11 13
5 9 12 14 15


import java.util.Scanner;
 
public class MainClass
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.println("How many rows you want in this pattern?");
         
        int rows = sc.nextInt();
         
        System.out.println("Here is your pattern....!!!");
         
        for (int i = 1; i <= rows; i++) 
        {
            int num = i;
             
            for (int j = 1; j <= i; j++) 
            {
                System.out.print(num+" ");
                 
                num = num+rows-j;
            }
             
            System.out.println();
        }
         
        sc.close();
    }
}
