public abstract class Transaction {
    protected final String transactionId;
    protected final Account account;
    protected final double amount;

    public Transaction(String transactionId, Account account, double amt) {
        this.transactionId = transactionId;
        this.account = account;
        this.amount = amt;
    }
    public abstract void execute();

}
