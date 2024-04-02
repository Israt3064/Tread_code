
package thread_Code;

public class Extended_Thread extends Thread {
    
    public static void main(String[] args) {
        Extended_Thread e1 = new Extended_Thread();
        e1.start();
    }
    @Override
   public void run()
    {
        System.out.println("This code is threading.");
    }
}
