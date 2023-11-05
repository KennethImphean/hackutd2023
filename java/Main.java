import java.util.Scanner;
import java.io.*;
public class Main {
    
    // TODO delete after testing
    public static final String exampleFileName = "C:\\Users\\School\\Desktop\\NEW PROJECT HACKUTDX\\hackutd2023\\data\\ExampleData.csv";
    public static void main(String[] args)
    {
        //Scanner scnr = new Scanner(System.in);
        Scanner inScan = null;
        try {
            inScan = new Scanner(new FileInputStream(exampleFileName));
        } catch (Exception e) {
            System.out.println("Block 1 - " + e.getMessage());
        }

        try {
            System.out.println("Output file name: " + createCSVOutputFile(exampleFileName));
        } catch (Exception e) {
            System.out.println("Block 2 - " + e.getMessage());
        }
        
        inScan.close();
        

        



    }

    // TODO: delete test function when done
    //Test with customer with id 1
    public static void test()
    {
        
        Customer test = new Customer(1,3103,317,374,250,268468,32216.16,236251.84,1127.9,778);
        System.out.println(test.toString());
    }

    
    public static String createCSVOutputFile(String inputFileName) throws FileNotFoundException
    {
        Scanner inScan = new Scanner(new FileInputStream(inputFileName));
        String csvFileName = inputFileName.substring(0, inputFileName.length()-4) + "Output.csv";
        File csvFile = new File(csvFileName);
        PrintWriter csvPrintWriter = new PrintWriter(csvFile);
        
        String input = "";

        while (inScan.hasNextLine())
        {
            input = inScan.nextLine();
            String[] arr = input.split(",");;

            if (!Character.isDigit(input.charAt(0)))
            {
                csvPrintWriter.println(input);    
            }
            
            else
            {
                Customer customer = new Customer(arr);
                csvPrintWriter.println(customer.toString());
            }
        }
        inScan.close();
        csvPrintWriter.close();
        return csvFileName;

        
        

        

    } 

    
}
