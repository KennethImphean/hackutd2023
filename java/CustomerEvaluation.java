//
//

abstract class CustomerEvaluation {
    // Function to evaluate Credit Rating
    // Returns true if credit score is favorable (x >= 640)
    // Returns false if credit score is unfavorable (x < 640)
    public static boolean EvaluateCreditRating(Customer x) {
        int creditScore = x.getCreditScore();
        if (creditScore >= 640) {
            return true;
        }
        else {
            return false;
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
    // Returns true if FEDTI is acceptable (FEDTI <= 28%)
    // Returns false if FEDTI is not acceptable (28% < FEDTI)
    public static boolean EvaluateFEDTI(Customer x) {
        double FEDTI = x.getFEDTI();
        if (FEDTI <= 28.0) {
            return true;
        }
        else {
            return false;
        }
    }
}   