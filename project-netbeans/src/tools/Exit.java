// After this class call, the program will in few second
package tools;

public class Exit extends Thread {

    static public void close(int sec) {

        try {
            sleep(sec * 1000);
            System.exit(1);
        } catch (InterruptedException e) {
        }

    }
}
