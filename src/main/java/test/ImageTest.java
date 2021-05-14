package test;

import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author GuoYou
 * @create 2021-02-08-17:30
 */
public class ImageTest {

    @Test
    void test(){
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\Guoyo\\IdeaProjects\\tank\\src\\images\\bulletR.gif"));
            assertNotNull(image);

            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
