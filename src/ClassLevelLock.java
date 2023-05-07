public class ClassLevelLock {
    public static void main(String[] args){
        Math m = new Math();
        TestThread testThread = new TestThread(m);
        testThread.start();
        m.positive();

    }
}

class TestThread extends Thread{
    Math mt = null;
    TestThread(Math mt){
        this.mt = mt;
    }
    public void run(){
        mt.negative();
    }
}

class Math{

    public static synchronized void positive(){
        System.out.println("Inside positive() - " + Thread.currentThread().getName());
        for(int i=1;i<=1000;i++){
            System.out.print(i);
        }
        System.out.println();
    }
    public static synchronized void negative(){
        System.out.println("Inside negative() - " + Thread.currentThread().getName());
        for(int i=-1;i>=-1000;i--){
            System.out.print(i);
        }
    }

}
