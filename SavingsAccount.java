public class SavingsAccount extends BankAccount {
    private double interestRate;
    
    public SavingsAccount(String accountNumber, double initialBalance, String ownerName, double interestRate) {
        super(accountNumber, initialBalance, ownerName);
        setInterestRate(interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        this.interestRate = interestRate;
        return this.interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }

    public double calculateMonthlyFee() {
        return 0; // Savings accounts typically do not have a monthly fee
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
