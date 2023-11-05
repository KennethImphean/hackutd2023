//
//

abstract class CustomerEvaluation {

    public static void test(Customer x) {
        System.out.print(x.getID());

    }

    public static boolean CreditRatingCheck(Customer x) {
        int creditScore = x.getCreditScore();
        if (creditScore >= 640) {
            return true;
        }
        else {
            return false;
        }
    }

}   