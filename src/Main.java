import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main (String[] args) {
        MyThread mt = new MyThread();
        mt.start();
        printNumbers();

    }

    public static void printNumbers(){
        System.out.println("Inside positive ->" + Thread.currentThread().getName());
        for(int i=1;i<=1000;i++){
            System.out.print(i);
        }
        System.out.println();
    }

    public static void printNegativeNumbers(){
        System.out.println("Inside negative number ->" + Thread.currentThread().getName());
        for(int i=-1;i>=-1000;i--){
            System.out.println(i);
        }
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
        Main.printNegativeNumbers();
    }

}




class Test {
    public static void readfile() throws Exception{
        File f=new File("Test.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String s=br.readLine();
        System.out.println(s);
    }
}