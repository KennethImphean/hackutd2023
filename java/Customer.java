
public class Customer extends CustomerEvaluation{
    protected int ID;
    protected int GrossMonthlyIncome;
    protected int CreditCardPayment;
    protected int CarPayment;
    protected int StudentLoanPayment;
    protected int AppraisedValue;
    protected double DownPayment;
    protected double LoanAmount;
    protected double MonthlyMortgagePayment;
    protected int CreditScore;
    protected double LTV;
    protected double DTI;
    protected double FEDTI;
    protected double debtServicingMortage;
    protected double overall;
    
    public String toString()
    {
        return "" + ID + "," + GrossMonthlyIncome + "," + CreditCardPayment + "," + CarPayment + "," + StudentLoanPayment + "," + AppraisedValue + "," + DownPayment + "," + LoanAmount + "," + MonthlyMortgagePayment + "," + CreditScore + "," + LTV + "," + DTI + "," + FEDTI + "," + debtServicingMortage + "," + overall;
    }

    public Customer()
    {
        ID = 0;
        GrossMonthlyIncome = 0;
        CreditCardPayment = 0;
        CarPayment = 0;
        StudentLoanPayment = 0;
        AppraisedValue = 0;
        DownPayment = 0;
        LoanAmount = 0;
        MonthlyMortgagePayment = 0;
        CreditScore = 0;
        LTV = 0;
        DTI = 0;
        debtServicingMortage = 0;
        overall = 0;
    }

    public Customer(String[] arr)
    {
        this.ID = Integer.parseInt(arr[0]);
        this.GrossMonthlyIncome = Integer.parseInt(arr[1]);
        this.CreditCardPayment = Integer.parseInt(arr[2]);
        this.CarPayment = Integer.parseInt(arr[3]);
        this.StudentLoanPayment = Integer.parseInt(arr[4]);
        this.AppraisedValue = Integer.parseInt(arr[5]);
        this.DownPayment = Double.parseDouble(arr[6]);
        this.LoanAmount = Double.parseDouble(arr[7]);
        this.MonthlyMortgagePayment = Double.parseDouble(arr[8]);
        this.CreditScore = Integer.parseInt(arr[9]);
        CalculateLTV();
        CalculateDTI();
        CalculateFEDTI();

    //6 int, 3 double, 1 int
    }
    
    public Customer(int iD, int grossMonthlyIncome, int creditCardPayment, int carPayment, int studentLoanPayment,
            int appraisedValue, double downPayment, double loanAmount, double monthlyMortgagePayment, int creditScore) {
        ID = iD;
        GrossMonthlyIncome = grossMonthlyIncome;
        CreditCardPayment = creditCardPayment;
        CarPayment = carPayment;
        StudentLoanPayment = studentLoanPayment;
        AppraisedValue = appraisedValue;
        DownPayment = downPayment;
        LoanAmount = loanAmount;
        MonthlyMortgagePayment = monthlyMortgagePayment;
        CreditScore = creditScore;
        LTV = 0;
        DTI = 0;
        debtServicingMortage = 0;
        overall = 0;
        CalculateLTV();
        CalculateDTI();
        CalculateFEDTI();
    }

    

    protected void CalculateLTV() {
        LTV = ((LoanAmount - DownPayment) / LoanAmount) * 100;
        return;
    }

    protected void CalculateDTI() {
        double totalDebt = CreditCardPayment + CarPayment + StudentLoanPayment + MonthlyMortgagePayment;
        DTI = totalDebt / GrossMonthlyIncome;
        return;
    }
    
    protected void CalculateFEDTI() {
        FEDTI = MonthlyMortgagePayment / GrossMonthlyIncome;
        return;
    }
    
    public double getOverall() {
        return overall;
    }
    public void setOverall(double overall) {
        this.overall = overall;
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
        return StudentLoanPayment;
    }
    public void setStudentLoanPayments(int studentLoanPayments) {
        StudentLoanPayment = studentLoanPayments;
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

    public double getLTV() {
        return LTV;
    }
    public void setLTV(double lTV) {
        LTV = lTV;
    }

    public double getDTI() {
        return DTI;
    }
    public void setDTI(double dTI) {
        DTI = dTI;
    }

    public double getFEDTI() {
        return DTI;
    }
    public void setFEDTI(double dTI) {
        DTI = dTI;
    }

    
}