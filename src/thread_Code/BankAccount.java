
package thread_Code;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double initial_Balance;
    private Lock lock;
    BankAccount()
    {
        initial_Balance = 0.0;
        lock = new ReentrantLock();
    }
    void deposite(double amnt)
    {
        lock.lock();
        try{
            System.out.println("Enter deposite amount: "+amnt);
            initial_Balance += amnt;
            System.out.println("After deposite: "+initial_Balance);
        }
        finally{
            lock.unlock();
        }
            
    }
    void withdraw(double amnt)
    {
        lock.lock();
        try{
            if(initial_Balance > amnt)
            {
                System.out.println("Enter withdraw amount: "+amnt);
                initial_Balance -= amnt;
                System.out.println("After withdraw: "+initial_Balance);
            }
            else
            {
                System.out.println("Insufficient balance.");
            }
        }
        finally{
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        BankAccount Ba = new BankAccount();
        Thread d1 = new Thread(()->Ba.deposite(50.0));
        Thread d2 = new Thread(()->Ba.deposite(100.0));
        Thread w1 = new Thread(()->Ba.withdraw(50.0));
        
        d1.start();
        d2.start();
        w1.start();
    }
    
}
