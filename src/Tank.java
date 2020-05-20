import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x, y;
    private Dir dir;
    private boolean bL, bU, bR, bD;
    public static final int SPEED = 5;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }


    private void setDirection() {
        if (!bL && !bU && !bR && !bD) {
            dir = Dir.STOP;
        }
        if (bL && !bU && !bR && !bD) {
            dir = Dir.L;
        }
        if (!bL && bU && !bR && !bD) {
            dir = Dir.U;
        }
        if (!bL && !bU && bR && !bD) {
            dir = Dir.R;
        }
        if (!bL && !bU && !bR && bD) {
            dir = Dir.D;
        }

        if (bL && bU && !bR && !bD) {
            dir = Dir.LU;
        }

//        if(!bL && !bU && bR && !bD){
//            dir=Dir.LR;
//        }

        if (bL && !bU && !bR && bD) {
            dir = Dir.LD;
        }

        if (!bL && !bU && bR && bD) {
            dir = Dir.RD;
        }
        if (!bL && bU && bR && !bD) {
            dir = Dir.RU;
        }
    }

    private void move() {
        switch (dir) {
            case L:
                x -= SPEED;
                break;
            case R:
                x += SPEED;
                break;
            case U:
                y -= SPEED;
                break;
            case D:
                y += SPEED;
                break;
            case LU:
                x -= SPEED;
                y -= SPEED;
                break;
            case LD:
                x -= SPEED;
                y += SPEED;
                break;
            case RU:
                x += SPEED;
                y -= SPEED;
                break;
            case RD:
                x += SPEED;
                y += SPEED;
                break;
        }
    }

    public void KeyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
//                x-=SPEED;
//                dir = Dir.L;
                bL = true;
                break;
            case KeyEvent.VK_RIGHT:
//                x+=SPEED;
//                dir = Dir.R;
                bR = true;
                break;
            case KeyEvent.VK_UP:
//                y-=SPEED;
//                dir = Dir.U;
                bU = true;
                break;
            case KeyEvent.VK_DOWN:
//                y+=SPEED;
//                dir = Dir.D;
                bD = true;
                break;

        }
        setDirection();

    }

    public void KeyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
//                x-=SPEED;
//                dir = Dir.L;
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
//                x+=SPEED;
//                dir = Dir.R;
                bR = false;
                break;
            case KeyEvent.VK_UP:
//                y-=SPEED;
//                dir = Dir.U;
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
//                y+=SPEED;
//                dir = Dir.D;
                bD = false;
                break;
        }
        setDirection();
    }
}
