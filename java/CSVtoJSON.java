import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class CSVtoJSON {
    public static void convert() throws FileNotFoundException{
        FileOutputStream outStream = new FileOutputStream("A1.json");
        PrintWriter writer = new PrintWriter(outStream);

        FileInputStream inStream = new FileInputStream("hackutd2023\\data\\ExampleData.csv");
        Scanner inScnr = new Scanner (inStream);

        writer.println("{\n\t\"Customer\": {");

        String[] titleArr = inScnr.nextLine().split(",");
        while(inScnr.hasNext()) {
            String[] dataArr = inScnr.nextLine().split(",");
            writer.println("\t\t\"" + dataArr[0] + "\": {");

            writer.print("\t\t\t\"" + titleArr[1] + "\": \"" + dataArr[1] + "\",");
            writer.println("\t\t\t");

            writer.print("\t\t\t\"" + titleArr[2] + "\": \"" + dataArr[2] + "\",");
            writer.println("\t\t\t");

            writer.print("\t\t\t\"" + titleArr[3] + "\": \"" + dataArr[3] + "\",");
            writer.println("\t\t\t");

            writer.print("\t\t\t\"" + titleArr[4] + "\": \"" + dataArr[4] + "\",");
            writer.println("\t\t\t");

            writer.print("\t\t\t\"" + titleArr[5] + "\": \"" + dataArr[5] + "\",");
            writer.println("\t\t\t");

            writer.print("\t\t\t\"" + titleArr[6] + "\": \"" + dataArr[6] + "\",");
            writer.println("\t\t\t");

            writer.print("\t\t\t\"" + titleArr[7] + "\": \"" + dataArr[7] + "\",");
            writer.println("\t\t\t");

            writer.print("\t\t\t\"" + titleArr[8] + "\": \"" + dataArr[8] + "\",");
            writer.println("\t\t\t");

            writer.print("\t\t\t\"" + titleArr[9] + "\": \"" + dataArr[9] + "\"");
            writer.println("\t\t\t");

            writer.print("\t\t}");
            if (inScnr.hasNext()) {
                writer.println(",");
            }

        }

        writer.println("\n\t}");
        writer.print("}");

        writer.close();
        inScnr.close();
        return;
    }
}
