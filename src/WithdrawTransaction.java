public class WithdrawTransaction extends Transaction {

    public WithdrawTransaction(String transactionId, Account account, double amt) {
        super(transactionId, account, amt);
    }

    @Override
    public void execute() {
        account.debit(amount);
    }
}
