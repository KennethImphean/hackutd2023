//
//

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public abstract class CustomerEvaluation {
    
    // Function to evaluate Overall Eligibility for customer
    // First digit is eligibility based on credit score (2 is acceptable, 0 is not)
    // Second digit is eligibility based on LTV (2 is preferred, 1 is acceptable, 0 is not)
    // Third digit is eligibility based on DTI (2 is preferred, 1 is acceptable, 0 is not)
    // Fourth digit is eligibility based on FEDTI (2 is acceptable, 0 is not)
    // A '0' in a digit will give strong suggestions for the user to be able to be eligible in that category, and will disqualify them.
    // A '1' in a digit will give suggestions for the user to improve their eligibility in that category, but will not disqualify them.
    // A '2' in a digit will not give suggestions to the user for that category.
    public static int EvaluateOverall(Customer x) throws FileNotFoundException{
        int evalCredit = EvaluateCreditRating(x);
        int evalLTV = EvaluateLTV(x);
        int evalDTI = EvaluateDTI(x);
        int evalFEDTI = EvaluateFEDTI(x);
        
        int overallScore = evalCredit * 1000 + evalLTV * 100 + evalDTI * 10 + evalFEDTI * 1;
        x.setOverall(overallScore);
        PrintOverall(overallScore);     //TODO: For testing, remove later!!!!
        return overallScore;
    }

    public static void PrintOverall(int overallScore) throws FileNotFoundException{

        FileOutputStream outStream = new FileOutputStream("Evaluations.txt");
        PrintWriter writer = new PrintWriter(outStream);

        int temp = overallScore / 1000;
        overallScore = overallScore % 1000;
        System.out.print("Credit: ");
        if (temp == 2) {
            System.out.println("Good!\t");
        }
        else {
            System.out.println("Bad...\t");
        }

        temp = overallScore / 100;
        overallScore = overallScore % 100;
        System.out.print("LTV: ");
        if (temp == 2) {
            System.out.println("Good!\t");
        }
        else if (temp == 1) {
            System.out.println("Okay.\t");
        }
        else {
            System.out.println("Bad...\t");
        }

        temp = overallScore / 10;
        overallScore = overallScore % 10;
        System.out.print("DTI: ");
        if (temp == 2) {
            System.out.println("Good!\t");
        }
        else if (temp == 1) {
            System.out.println("Okay.\t");
        }
        else {
            System.out.println("Bad...\t");
        }

        temp = overallScore;
        System.out.print("FEDTI: ");
        if (temp == 2) {
            System.out.println("Good!\t");
        }
        else {
            System.out.println("Bad...\t");
        }
        
        writer.close();
        return;
    }
    
    // Function to evaluate Credit Rating
    // Returns 1 if credit score is favorable (x >= 640)
    // Returns 0 if credit score is unfavorable (x < 640)
    public static int EvaluateCreditRating(Customer x) {
        int creditScore = x.getCreditScore();
        if (creditScore >= 640) {
            return 2;
        }
        else {
            return 0;
        }
    }

    // Function to evaluate LTV
    // Returns 2 if LTV is preferred (x < 80%)
    // Returns 1 if LTV is not preferred, but still acceptable (80% <= x <= 95%)
    // Returns 0 if LTV is not acceptable (95% < x)
    public static int EvaluateLTV(Customer x) {
        double LTV = x.getLTV();
        if (LTV < 80.0) {
            return 2;
        }
        else if (80.0 <= LTV && LTV <= 95.0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    // Function to evaluate DTI
    // Returns 2 if DTI is preferred (DTI <= 36%)
    // Returns 1 if DTI is not preferred, but still acceptable (36% < DTI <= 43%)
    // Returns 0 if DTI is not acceptable (43% < DTI)
    public static int EvaluateDTI(Customer x) {
        double DTI = x.getDTI();
        if (DTI <= 36.0) {
            return 2;
        }
        else if  (36.0 < DTI && DTI <= 43.0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    // Function to evaluate FEDTI
    // Returns 1 if FEDTI is acceptable (FEDTI <= 28%)
    // Returns 0 if FEDTI is not acceptable (28% < FEDTI)
    public static int EvaluateFEDTI(Customer x) {
        double FEDTI = x.getFEDTI();
        if (FEDTI <= 28.0) {
            return 2;
        }
        else {
            return 0;
        }
    }
}   