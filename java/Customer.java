public class Customer extends CustomerEvaluation{
    protected int ID;
    protected int GrossMonthlyIncome;
    protected int CarPayment;
    protected int StudentLoanPayments;
    protected int AppraisedValue;
    protected double DownPayment;
    protected double LoanAmount;
    protected double MonthlyMortgagePayment;
    protected int CreditScore;
    protected int LTV;
    protected int DTI;
    protected double debtServicingMortage;
    protected double overall;
    public double getOverall() {
        return overall;
    }
    public void setOverall(double overall) {
        this.overall = overall;
    }
    public Customer(int iD, int grossMonthlyIncome, int carPayment, int studentLoanPayments, int appraisedValue,
            double downPayment, double loanAmount, double monthlyMortgagePayment, int creditScore) {
        ID = iD;
        GrossMonthlyIncome = grossMonthlyIncome;
        CarPayment = carPayment;
        StudentLoanPayments = studentLoanPayments;
        AppraisedValue = appraisedValue;
        DownPayment = downPayment;
        LoanAmount = loanAmount;
        MonthlyMortgagePayment = monthlyMortgagePayment;
        CreditScore = creditScore;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public int getGrossMonthlyIncome() {
        return GrossMonthlyIncome;
    }
    public void setGrossMonthlyIncome(int grossMonthlyIncome) {
        GrossMonthlyIncome = grossMonthlyIncome;
    }
    public int getCarPayment() {
        return CarPayment;
    }
    public void setCarPayment(int carPayment) {
        CarPayment = carPayment;
    }
    public int getStudentLoanPayments() {
        return StudentLoanPayments;
    }
    public void setStudentLoanPayments(int studentLoanPayments) {
        StudentLoanPayments = studentLoanPayments;
    }
    public int getAppraisedValue() {
        return AppraisedValue;
    }
    public void setAppraisedValue(int appraisedValue) {
        AppraisedValue = appraisedValue;
    }
    public double getDownPayment() {
        return DownPayment;
    }
    public void setDownPayment(double downPayment) {
        DownPayment = downPayment;
    }
    public double getLoanAmount() {
        return LoanAmount;
    }
    public void setLoanAmount(double loanAmount) {
        LoanAmount = loanAmount;
    }
    public double getMonthlyMortgagePayment() {
        return MonthlyMortgagePayment;
    }
    public void setMonthlyMortgagePayment(double monthlyMortgagePayment) {
        MonthlyMortgagePayment = monthlyMortgagePayment;
    }
    public int getCreditScore() {
        return CreditScore;
    }
    public void setCreditScore(int creditScore) {
        CreditScore = creditScore;
    }

    public int getLTV() {
        return LTV;
    }
    public void setLTV(int lTV) {
        LTV = lTV;
    }

    public int getDTI() {
        return DTI;
    }
    public void setDTI(int dTI) {
        DTI = dTI;
    }

    





}