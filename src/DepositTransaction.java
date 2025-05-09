public class DepositTransaction extends Transaction{

    public DepositTransaction(String transactionId, Account account, double amt) {
        super(transactionId, account, amt);
    }

    @Override
    public void execute() {
        account.credit(amount);
    }
}
