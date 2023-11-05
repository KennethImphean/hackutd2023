import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class CSVtoJSON {
    public static void convert(String outputFileName) throws FileNotFoundException{
        String outputFileNoExtention = outputFileName.substring(0, outputFileName.length() - 4);
        FileOutputStream outStream = new FileOutputStream(outputFileNoExtention + ".json");
        PrintWriter writer = new PrintWriter(outStream);

        FileInputStream inStream = new FileInputStream("hackutd2023\\data\\" + outputFileName);
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

            writer.print("\t\t\t\"" + titleArr[9] + "\": \"" + dataArr[9] + "\",");
            writer.println("\t\t\t");

            //

            writer.print("\t\t\t\"" + "LTV" + "\": \"" + dataArr[10] + "\",");
            writer.println("\t\t\t");

            writer.print("\t\t\t\"" + "DTI" + "\": \"" + dataArr[11] + "\",");
            writer.println("\t\t\t");

            writer.print("\t\t\t\"" + "LEDTI" + "\": \"" + dataArr[12] + "\",");
            writer.println("\t\t\t");

            writer.print("\t\t\t\"" + "Overall" + "\": \"" + dataArr[13] + "\"");
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
