class ThreadInner extends Thread {
    int total ; 
    public void run() {
        for (int i = 1 ; i<=50;i++) {
             total = total+i;
               if(total>10000) {
                synchronized(this) {
                 notify();}    
        }
    }try {
        Thread.sleep(5);
    }catch (InterruptedException e) {
    
        System.out.println("user Thread--" + total);
    }
}}
public class InnerCommunication {

 

    public static void main(String[] args) {
    ThreadInner ti1 = new ThreadInner();
Thread ti2 = new Thread(ti1);
ti2.start();
try {
    synchronized (ti1) {
        ti1.wait();
    }}catch (InterruptedException e) {
    
        System.out.println("Main thread --" + ti1.total);
    }
        
    
}
    }