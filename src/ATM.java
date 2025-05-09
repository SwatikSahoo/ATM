import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class ATM {
    private final BankingService bankingService;
    private final CashDispenser cashDispenser;
    private static final AtomicLong transactionCounter= new AtomicLong(0);

    public ATM(BankingService bankingService, CashDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
    }
    public void authenticUser(Card card){
        //Authenticate user
    }
    public double checkBalance(String acntNo){
        Account acnt= bankingService.getAccount(acntNo);
        return acnt.getBalance();
    }
    public void withdrawCash(String acntNo, int amt){
        Account acnt= bankingService.getAccount(acntNo);
        if (acnt!=null && acnt.getBalance()<amt){
            System.out.println("Insufficient Balance");
            return;
        }
        Transaction trx=new WithdrawTransaction(generateId(), acnt, amt);
        bankingService.processTransaction(trx);
        cashDispenser.dispenseCash(amt);
    }
    public void depositCash(String acntNo, double amt){
        Account acnt= bankingService.getAccount(acntNo);
        Transaction trx= new DepositTransaction(generateId(),acnt,amt);
        bankingService.processTransaction(trx);
    }

    private String generateId() {
        long trx=transactionCounter.incrementAndGet();
        String timestamp= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "TXN"+timestamp+String.format("%010d", trx);

    }
}
