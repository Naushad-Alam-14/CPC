public class Synchronization {

    public static void main(String[] args){

        Bank bn = new Bank();
        CheckBalThread cbt = new CheckBalThread(bn);
        cbt.start();
        CustomThread ct = new CustomThread(bn);
        ct.start();
        bn.cashWithdrawl(800);


    }
}


class CustomThread extends Thread{
    Bank st = null;
    CustomThread(Bank bnk){
        st = bnk;
    }
    public void run(){
        st.cashWithdrawl(100);
    }
}

class CheckBalThread extends Thread{
    Bank b = null;
    CheckBalThread(Bank bnk){
        b = bnk;
    }
    public void run(){
        System.out.println("Available balance - " + b.checkBalance() + " by thread - "
                + Thread.currentThread().getName());
    }
}


class Bank {
    public int balance = 1000;
    public Bank st = null;

    public synchronized void cashWithdrawl(int amount) {
            System.out.println("Entering - " + Thread.currentThread().getName());

        try {
            System.out.println("Sleeping ->" + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("Woke up ->" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(balance > amount){
                System.out.println("Withdrawing cash - " + amount);
                balance = balance - amount;
            }else {
                System.out.println("Insufficient fund" + Thread.currentThread().getName());
            }
            System.out.println("Exiting - " + Thread.currentThread().getName());
    }
    public int checkBalance(){
        return balance;
    }

}
