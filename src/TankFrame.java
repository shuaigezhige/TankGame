import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankFrame extends Frame {
    //    private int x=100; int y=100;
//    public static final int SPEED=5;
    private Tank myTank;
    private Tank enemy;


    public TankFrame() {
        this.setTitle("tank war");
        this.setLocation(400, 100);
        this.setSize(800, 600);
        this.addKeyListener(new TankKeyListener());
        myTank = new Tank(100, 100, Dir.R);
        enemy = new Tank(200, 200, Dir.D);
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
//        System.out.println("paint");
//        g.fillRect(x,y,50,50);
//        x+=2;
        myTank.paint(g);
        enemy.paint(g);
    }

    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            myTank.KeyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.KeyReleased(e);
        }
    }
//    private class TankKeyListener implements KeyListener {
//        @Override
//        public void keyTyped(KeyEvent keyEvent) {
//
//        }
//
//        @Override
//        public void keyPressed(KeyEvent keyEvent) {
//
//        }
//
//        @Override
//        public void keyReleased(KeyEvent keyEvent) {
//
//        }
//    }
}
