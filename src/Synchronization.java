public class Synchronization {

    public static void main(String[] args){

        Bank s = new Bank();
        CustomThread mt = new CustomThread(s);
        mt.start();
        s.cashWithdrawl(800);
    }
}

class CustomThread extends Thread{
    Bank b = null;
    CustomThread(Bank bank){
        b = bank;
    }
    public void run(){
       b.cashWithdrawl(600);
    }
}


class Bank {
    public int balance = 1000;
    public Bank st = null;

    public synchronized void cashWithdrawl(int amount){

            System.out.println("Entering - " + Thread.currentThread().getName());
            if(balance > amount){
                System.out.println(amount);
                balance = balance - amount;
            }else {
                System.out.println("Insufficient fund" + Thread.currentThread().getName());
            }
            System.out.println("Exiting - " + Thread.currentThread().getName());

    }
    public void printRoll(){
        for(int i=1;i<=1000;i++){
            System.out.println(Thread.currentThread().getName() + " -> " + i + " -> " + this.balance);
        }
    }

}
