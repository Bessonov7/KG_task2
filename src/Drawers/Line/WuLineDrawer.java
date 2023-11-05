package Drawers.Line;

import Drawers.Pixel.PixelDrawer;
import Geometry.Line;

import java.awt.*;

public class WuLineDrawer implements GradientLineDrawer{
    @Override
    public void drawLine(Line line, PixelDrawer drawer, Color color) {
        drawLineGradient(line, drawer, color, color);
    }

    @Override
    public void drawLineGradient(Line line, PixelDrawer drawer, Color color1, Color color2) {

    }
}
