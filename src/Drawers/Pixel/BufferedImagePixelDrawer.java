package Drawers.Pixel;


import Geometry.Vec2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BufferedImagePixelDrawer implements PixelDrawer {
    final BufferedImage image;
    private Color color = Color.BLACK;

    public BufferedImagePixelDrawer(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void drawPixel(Vec2 pos) {
        try {
            image.setRGB(pos.x, pos.y, color.getRGB());
        }
        catch (ArrayIndexOutOfBoundsException ignored) {

        }
    }

    public void setColor(Color color){
        this.color = color;
    }
}
