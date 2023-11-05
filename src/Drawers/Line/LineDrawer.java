package Drawers.Line;


import Drawers.Pixel.PixelDrawer;
import Geometry.Line;

import java.awt.*;

public interface LineDrawer {
    void drawLine(Line line, PixelDrawer drawer, Color color);
}
