import Drawers.Pixel.BufferedImagePixelDrawer;
import Drawers.Pixel.PixelDrawer;
import Geometry.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {
    public DrawPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D canvas = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        clearImage(image);
        drawOnImage(image);

        canvas.drawImage(image, 0, 0, null);
    }

    protected void clearImage(BufferedImage image){
        Graphics2D imageGraphics = image.createGraphics();

        imageGraphics.setColor(Color.WHITE);
        imageGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        imageGraphics.setColor(Color.BLACK);

        imageGraphics.dispose();
    }

    protected void drawOnImage(BufferedImage image){
        PixelDrawer pixelDrawer = new BufferedImagePixelDrawer(image);
        pixelDrawer.drawPixel(new Vec2(100, 100));
    }
}
