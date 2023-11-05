import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class Main {
    
    public static final String labels = "ID,GrossMonthlyIncome,CreditCardPayment,CarPayment,StudentLoanPayments,AppraisedValue,DownPayment,LoanAmount,MonthlyMortgagePayment,CreditScore";
    
    
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
                ExampleProcess.process();
                break;
            case 2:
                UserProcess.process(testGetFileName(scnr));
                break;
        }
         

    }

    //TODO: Fix so that you don't have to press enter again to try again
    public static String testGetFileName(Scanner scnr)
    {
        scnr.nextLine();
        String fileName = "";
        while (fileName.equals(""))
        {
            System.out.println("Enter the file name:");
            fileName = scnr.nextLine();
            System.out.println(fileName);
            try {
                checkFileInput(fileName);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                fileName = "";
                scnr.nextLine();
            }
        }

        return fileName;
    }



    public static void checkFileInput(String fileName) throws Exception
    {
        File file = new File(fileName);
        if (file.exists())
        {
            Scanner inScan = new Scanner(file);
            String input = inScan.nextLine();
            if (!input.equals(labels))
            {
                inScan.nextLine();
                throw new InvalidInputException("File does not contain labels to confirm the correct data is provided");
            }
                
            
            while (inScan.hasNextLine())
            {
                try {
                    checkCustomerInput(inScan.nextLine().split(","));    
                } catch (Exception e) {
                    inScan.nextLine();
                    inScan.close();
                    throw new InvalidInputException("File does not include valid data");
                }
                
            }
            inScan.close();
        }

        else
            throw new FileNotFoundException("File does not exist");
    }

    public static void checkCustomerInput(String[] arrInput) throws InvalidInputException
    {
        if (arrInput.length > 10)
            throw new InvalidInputException("Too much input");
        else if (arrInput.length < 10)
        {
            throw new InvalidInputException("Not enough input");
        }
        for (int i = 0; i < arrInput.length; i++)
        {
            switch (i)
            {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 9:
                    try {
                        Integer.parseInt(arrInput[i]);    
                    } 
                    catch (Exception e) {
                        throw new InvalidInputException(getInputType(i));
                    }
                case 6:
                case 7:
                case 8:
                    try {
                        Double.parseDouble(arrInput[i]);    
                    } 
                    catch (Exception e) {
                        throw new InvalidInputException(getInputType(i));
                    }
            }


        }

        

        
    }

    public static String getInputType(int i)
    {
        switch (i)
        {
            case 0:
                return "ID";
            case 1:
                return "Gross Monthly Income";
            case 2:
                return "Credit Card Payment";
            case 3:
                return "Car Payment";
            case 4:
                return "Student Loan Payments";
            case 5:
                return "Appraised Value";
            case 6:
                return "Down Payment";
            case 7:
                return "Loan Amount";
            case 8:
                return "Monthly Mortgage Payment";
            case 9:
                return "Credit Score";
            default:
                return "";   
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
