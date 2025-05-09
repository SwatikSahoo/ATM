//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankingService bankingService= new BankingService();
        CashDispenser cashDispenser= new CashDispenser(100000);
        ATM atm= new ATM(bankingService, cashDispenser);
        //create sample accounts
        bankingService.createAccount("1234567890",25000);
        bankingService.createAccount("8765432124",45000);

        //perform ATM oprn
        Card card= new Card("1234567890","1234");
        atm.authenticUser(card);
        double bal= atm.checkBalance("1234567890");
        System.out.println("Account balance: "+bal);
        atm.withdrawCash("1234567890",2000);
        atm.depositCash("1234567890",100);
        bal= atm.checkBalance("1234567890");
        System.out.println("Updated Balance is "+bal);






    }
}