package Drawers.Line;


import Drawers.Pixel.PixelDrawer;
import Geometry.Line;

import java.awt.*;

public interface GradientLineDrawer extends LineDrawer {
    void drawLineGradient(Line line, PixelDrawer drawer, Color color1, Color color2);
}
