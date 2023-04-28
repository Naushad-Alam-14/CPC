import java.io.Closeable;
import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread t = new Thread(myRunnable);
        t.start();

        printPositiveNumber();

    }
    public static void printPositiveNumber(){
        System.out.println("positive number" + Thread.currentThread().getName());
        for(int i=1;i<=1000;i++){
            System.out.print(i);
        }
        System.out.println();
    }
    public static void printNegativeNumber(){
        System.out.println("negative number" + Thread.currentThread().getName());
        for(int i=-1;i>-1000;i--){
            System.out.println(i);
        }
    }

}

class MyRunnable implements Runnable{

    /*
   1st - create custom class as child of Runnable Interface
   2nd - Override run() method
   3rd - Assign the task to child thread (i.e. by writing logic inside the run method)
   4th - Create object of child thread (i.e. Object of MyRunnable)
   5th - Create an object of Thread class and pass runnable as an argument of thread's class constructor
   5th - Start the thread (i.e. By calling start() method on child thread)
   */
    public void run(){
        Main.printNegativeNumber();
    }
}
class MyThread extends Thread{

    /*
   1st - create custom class as child of thread class
   2nd - Override run() method
   3rd - Assign the task to child thread (i.e. by writing logic inside the run method)
   4th - Create object of child thread (i.e. Object of MyThread)
   5th - Start the thread (i.e. By calling start() method on child thread)
   */
    public void run(){
        Main.printNegativeNumber();
    }
}
