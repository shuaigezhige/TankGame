import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TankFrame tf = new TankFrame();
//        tf.setLocation(400,100);
//        tf.setSize(800,600);
        tf.setVisible(true);
        for (; ; ) {
            try {
                Thread.sleep(20);
//                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tf.repaint();
        }
    }
}
