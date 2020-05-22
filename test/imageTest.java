import com.practice.tank.PropertyMgr;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
public class imageTest {
    @Test
    void test() {

        try {
            BufferedImage image = ImageIO.read(new File("G:/tank-master/tank/src/images/bulletD.gif"));
            assertNotNull(image);

            BufferedImage image2 = ImageIO.read(imageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            //this.getClass()
            assertNotNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2() {
        try {
            BufferedImage tankL = ImageIO.read(imageTest.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankL = rotateImage(tankL, 90);
            Assertions.assertNotNull(tankL);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public BufferedImage rotateImage(final BufferedImage bufferedimage,
                                     final int degree) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }

    @Test
    public void test3() {

        System.out.println(PropertyMgr.get("initTankCount"));
    }

}
