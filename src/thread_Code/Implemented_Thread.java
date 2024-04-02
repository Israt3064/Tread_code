
package thread_Code;

public class Implemented_Thread implements Runnable{
    public static void main(String[] args) {
        Implemented_Thread e2 = new Implemented_Thread();
        Thread th = new Thread(e2);
        th.start();
    }
    @Override
    public void run()
    {
        System.out.println("Its threading");  
    }
    
}
