import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserProcess {
    public static void process(String fileName)
    {
        Scanner inScan = null;
        try 
        {
            inScan = new Scanner(new FileInputStream(fileName));
        } 
        
        catch (Exception e)
            {
                System.out.println("Block 1 - " + e.getMessage());
            }

            String csvOutputFileName = "";
            File csvFile = null;

            try
            {
                csvOutputFileName = createCSVOutputFile(fileName, csvFile);
                System.out.println("Output file name: " + csvOutputFileName);
                CSVtoJSON.convert(csvOutputFileName);
            }

            catch (Exception e)
            {
                System.out.println("Block 2 - " + e.getMessage());
            }
            

            inScan.close();

    }

    public static String createCSVOutputFile(String inputFileName, File csvFile) throws FileNotFoundException
    {
        Scanner inScan = new Scanner(new FileInputStream(inputFileName));
        String csvFileName = inputFileName.substring(0, inputFileName.length()-4) + "Output.csv";
        csvFile = new File(csvFileName);
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
