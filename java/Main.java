import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class Main {
    
    // TODO delete after testing
    
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        int userMenu = 0;
        while (userMenu == 0) {
            System.out.print("Enter 1 for processing example data, or 2 for processing user data: ");
            try {
                userMenu = scnr.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                scnr.next();
                userMenu = 0;
            }
        }
        
        switch (userMenu) {
            case 1:
                //todo: call function to process example data
                break;
            case 2:
                //todo: call function to process user data
                break;
        }
         

    }

    // TODO: delete test function when done
    //Test with customer with id 1
    public static void test()
    {
        
        Customer test = new Customer(1,3103,317,374,250,268468,32216.16,236251.84,1127.9,778);
        System.out.println(test.toString());
    }

    
     

    
}
