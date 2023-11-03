package Drawers.Line;


import Geometry.Drawer.Pixel.PixelDrawer;
import Geometry.Line.Line;

import java.awt.*;

public interface LineDrawer {
    void drawLine(Line line, PixelDrawer drawer, Color color);
}
