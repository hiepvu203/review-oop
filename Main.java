public class Main {
    public static void main(String[] args) {
        try {
            BankAccount[] accounts = new BankAccount[3];

            accounts[0] = new SavingsAccount("SA123", 1000.0, "Nguyen Van A", 5.0);
            accounts[1] = new checkingAccount("CA456", 2000.0, "Tran Thi B", 2.5);

            // duyệt mảng để hiện thị thông tin ban đầu và phí duy trì
            System.out.println("Initial Account Information:");
            for (BankAccount account : accounts) {
                if (account != null) {
                    account.displayInfo();
                    System.out.println("Monthly Fee: $" + String.format("%.2f", account.calculateMonthlyFee()));
                    System.out.println();
                } else {
                    System.out.println("Warning: Null account detected!");
                }
            }

            // thực hiện các thao tác đặc thù

            System.out.println("After Operations:");
            for (BankAccount account : accounts) {
                if (account instanceof SavingsAccount) {
                    // ép kiểu để gọi phương thức của SavingsAccount
                    SavingsAccount savingsAccount = (SavingsAccount) account;
                    savingsAccount.deposit(500);
                    savingsAccount.addInterest();
                    System.out.println("Deposited $500 and added interest.");
                    savingsAccount.displayInfo();
                } else if (account instanceof checkingAccount) {
                    checkingAccount checkingAccount = (checkingAccount) account;
                    checkingAccount.withdraw(300);
                    System.out.println("Withdrew $300 with transaction fee.");
                    checkingAccount.displayInfo();
                }
                System.out.println();
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
