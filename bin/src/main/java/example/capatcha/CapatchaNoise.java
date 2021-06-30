package example.capatcha;

import java.awt.*;
import java.util.Random;
import java.awt.image.*;

public class CapatchaNoise {

  public static void generate(BufferedImage bi) {
    Random r = new Random();
    int w = 100, h = 100;
    Graphics2D g=(Graphics2D)bi.getGraphics();

    for (int i=0; i<1000; i++) {
      g.setColor(new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()));
       int x = Math.abs(r.nextInt()) % w;
       int y = Math.abs(r.nextInt()) % h;
       g.drawLine(x, y, x, y);
    }

    g.dispose();

  }

}
