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

        // TODO add work with our implementation
        Graphics2D imageGraphics = image.createGraphics();
        imageGraphics.setColor(Color.BLACK);
        imageGraphics.drawLine(0, 0, 200, 200);
        imageGraphics.dispose();

        canvas.drawImage(image, 0, 0, null);
    }

    protected void clearImage(BufferedImage image){
        Graphics2D imageGraphics = image.createGraphics();

        imageGraphics.setColor(Color.WHITE);
        imageGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        imageGraphics.setColor(Color.BLACK);

        imageGraphics.dispose();
    }
}
