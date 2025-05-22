public class checkingAccount extends BankAccount{
    private double transactionFee;

    public checkingAccount(String accountNumber, double initialBalance, String ownerName, double transactionFee) {
        super(accountNumber, initialBalance, ownerName);
        setTransactionFee(transactionFee);
    }

    public double getTransactionFee() {
        return transactionFee; 
    }

    public double setTransactionFee(double transactionFee) {
        if (transactionFee < 0) {
            throw new IllegalArgumentException("Transaction fee cannot be negative");
        }
        this.transactionFee = transactionFee;
        return this.transactionFee;
    }

    @Override 
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount + transactionFee > getBalance()) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal and transaction fee");
        }
        super.withdraw(amount + transactionFee);
    }

    public double calculateMonthlyFee() {
        return transactionFee * 5; // Monthly fee is the transaction fee
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Transaction Fee: $" + String.format("%.2f", transactionFee));
    }
}