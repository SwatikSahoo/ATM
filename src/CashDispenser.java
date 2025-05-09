public class CashDispenser {
    private int cashAvailable;
    public CashDispenser(int initialCash){
        this.cashAvailable=initialCash;
    }
    public synchronized void dispenseCash(int amt){
        if(amt>cashAvailable){
            throw new IllegalArgumentException("Insufficient Cash in ATM");
        }
        cashAvailable-=amt;
        System.out.println("Cash dispensed: "+amt);
    }
}
