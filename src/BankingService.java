import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    private final Map<String, Account> accounts= new ConcurrentHashMap<>();

    public void createAccount(String acntNo, double bal){
        accounts.put(acntNo, new Account(acntNo, bal));
    }
    public Account getAccount(String acntNo){
        return accounts.get(acntNo);
    }
    public void processTransaction(Transaction trx){
        trx.execute();
    }
}
