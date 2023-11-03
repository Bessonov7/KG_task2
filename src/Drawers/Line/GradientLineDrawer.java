package Drawers.Line;


import Geometry.Drawer.Pixel.PixelDrawer;
import Geometry.Line.Line;

import java.awt.*;

public interface GradientLineDrawer extends LineDrawer {
    void drawLineGradient(Line line, PixelDrawer drawer, Color color1, Color color2);
}
