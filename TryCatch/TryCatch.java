package LearningOOP.TryCatch;
import java.util.Scanner;
import java.util.InputMismatchException;


public class TryCatch {
    
    public static void main(String[] args) {
        

        Scanner in = new Scanner (System.in);
        /* 
        try{
            System.out.println("Enter a number: ");
            int x = in.nextInt();
        }
       catch(InputMismatchException e){
        */
        do {

            try{
                    System.out.print("Enter a number: ");
                    int x = in.nextInt();
                    
                    System.out.println("Square : " + x*x);
                    break; // break so that when the user inputs a number, it will be terminated

                    // cannot be terminated when the user inputs a non integer.

            }catch(InputMismatchException e)
            {
                // the logic is that because it skips a line after the nextInt() so we have to make sure it does not skip a line
                // by terminating the skip line here, it stops because the next input can now be done.

                in.nextLine();
                //by doing this, we can now go back to enter a number 
                System.out.println("Integers only!\n");
            }
        
            } while (true);
        
        


    }














































    
}
