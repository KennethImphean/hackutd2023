import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class Main {
    
    public static final String LABELS = "ID,GrossMonthlyIncome,CreditCardPayment,CarPayment,StudentLoanPayments,AppraisedValue,DownPayment,LoanAmount,MonthlyMortgagePayment,CreditScore";
    public static final String USER_INPUT_FILE_NAME = "hackutd2023\\data\\UserInputData.csv";
    
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
                File file = new File(USER_INPUT_FILE_NAME);
                Scanner inScan = null;
                if (file.exists())
                {
                    try {
                        writeUserInput(testGetUserInput(scnr), file);
                        inScan = new Scanner(file);    
                        testGetFileName(scnr, file);
                    } catch (Exception e) {
                        System.out.println("Check to make sure UserInputData.csv exists inside the data folder");
                    }
                    
                    
                    UserProcess.process(USER_INPUT_FILE_NAME);    
                }
                    
                break;
        }
         

    }

    public static String[] tempTest(Scanner scnr)
    {
        if (scnr.next().equals("test"))
        {
            return "1,3103,317,374,250,268468,32216.16,236251.84,1127.9,778".split(",");


        }    

        else
            return null;
    }

    public static String[] testGetUserInput(Scanner scnr)
    {

        String [] arrInput = null;

        arrInput = tempTest(scnr);
        if (arrInput != null)
            return arrInput;
        
        boolean validInput = false;
        while (!validInput)
        {
            arrInput = new String[10];
            arrInput[0] = "0";

            System.out.println("Enter gross monthly income:");
            arrInput[1] = scnr.next();

            System.out.println("Enter credit card payment:");
            arrInput[2] = scnr.next();

            System.out.println("Enter car payment:");
            arrInput[3] = scnr.next();

            System.out.println("Enter student loan payment:");
            arrInput[4] = scnr.next();

            System.out.println("Enter appraised value:");
            arrInput[5] = scnr.next();

            System.out.println("Enter down payment:");
            arrInput[6] = scnr.next();

            System.out.println("Enter loan Amount:");
            arrInput[7] = scnr.next();

            System.out.println("Enter monthly mortgage payment:");
            arrInput[8] = scnr.next();

            System.out.println("Enter credit score:");
            arrInput[9] = scnr.next();

            try {
                checkCustomerInput(arrInput);
                validInput = true;
            } catch (Exception e) {
                scnr.next();


            }
            
        }

        return arrInput;
        


    }



    //TODO: Fix so that you don't have to press enter again to try again
    public static String testGetFileName(Scanner scnr, File file) throws FileNotFoundException 
    {
        Scanner inScan = new Scanner(file);
        inScan.nextLine();
        String fileName = "";
        while (fileName.equals(""))
        {
            System.out.println("Enter the file name:");
            fileName = scnr.nextLine();
            //System.out.println(fileName);
            try {
                checkFileInput(fileName);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                fileName = "";
                inScan.nextLine();
            }
        }
        inScan.close();
        return fileName;
    }

    

    public static void checkFileInput(String fileName) throws Exception
    {
        File file = new File(fileName);
        if (file.exists())
        {
            Scanner inScan = new Scanner(file);
            String input = inScan.nextLine();
            if (!input.equals(LABELS))
            {
                inScan.nextLine();
                inScan.close();
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

            if (Integer.parseInt(arrInput[0]) < 0)
            {
                throw new InvalidInputException(getInputType(1));    
            }

            else if (Integer.parseInt(arrInput[1]) <= 0)
            {
                throw new InvalidInputException(getInputType(1));
            }

            else if (Integer.parseInt(arrInput[5]) <= 0)
            {
                throw new InvalidInputException(getInputType(5));   
            }

            else if (Double.parseDouble(arrInput[7]) <= 0)
            {
                throw new InvalidInputException(getInputType(7));   
            }

            else if (Double.parseDouble(arrInput[8]) <= 0)
            {
                throw new InvalidInputException(getInputType(8));   
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

    public static void writeUserInput(String[] arr, File file) throws FileNotFoundException
    {
        PrintWriter outFile = new PrintWriter(file);
        outFile.println(LABELS);
        for (int i = 0; i < arr.length; i++)
        {
            outFile.print(arr[i]);
        }

        outFile.close();


    }

    // TODO: delete test function when done
    //Test with customer with id 1
    public static void test()
    {
        
        Customer test = new Customer(1,3103,317,374,250,268468,32216.16,236251.84,1127.9,778);
        System.out.println(test.toString());
    }

    
     

    
}
