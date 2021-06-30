package example.capatcha;

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

public class CapatchaImage {

  public static byte[] generate(String capatcha) throws IOException{
    BufferedImage img= drawBaseImage(capatcha);
    ByteArrayOutputStream baos=new ByteArrayOutputStream();
    ImageIO.write(img, "jpg", baos );
    return baos.toByteArray();
  }

  private static void drawCenteredString(String s, int w, int h, Graphics g) {
    FontMetrics fm = g.getFontMetrics();
    int x = (w - fm.stringWidth(s)) / 2;
    int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
    g.drawString(s, x, y);
  }

  private static BufferedImage drawBaseImage(String capatcha) {

    capatcha = (capatcha == null || capatcha == "") ? "empty" : capatcha;

    BufferedImage bi = new BufferedImage(100, 100,  BufferedImage.TYPE_3BYTE_BGR );
    Graphics2D g=(Graphics2D)bi.getGraphics();

    final Font f = new Font("SansSerif", Font.BOLD, 18);

    g.setColor(Color.white);
    g.fillRect(0, 0, 100, 100);
    g.setColor(Color.black);
    g.setFont(f);
    drawCenteredString(capatcha, 100, 100, g);
    g.drawRect(0, 0, 99, 99);
    g.dispose();
    CapatchaNoise.generate(bi);

    return bi;
  }

}
