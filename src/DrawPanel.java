import Drawers.Line.GradientLineDrawer;
import Drawers.Line.LineDrawer;
import Drawers.Line.WuLineDrawer;
import Drawers.Pixel.BufferedImagePixelDrawer;
import Drawers.Pixel.PixelDrawer;
import Geometry.Line;
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
        GradientLineDrawer lineDrawer = new WuLineDrawer();

        lineDrawer.drawLine(new Line(new Vec2(100, 100), new Vec2(400, 400)), pixelDrawer, Color.BLACK);

        lineDrawer.drawLineGradient(new Line(new Vec2(100, 100), new Vec2(100, 400)), pixelDrawer,
                Color.RED, Color.BLUE);

        lineDrawer.drawLineGradient(new Line(new Vec2(100, 100), new Vec2(400, 200)), pixelDrawer,
                Color.RED, Color.GREEN);
    }
}
