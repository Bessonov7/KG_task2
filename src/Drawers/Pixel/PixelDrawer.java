package Drawers.Pixel;


import Geometry.Vec2;

import java.awt.*;

public interface PixelDrawer {
    void drawPixel(Vec2 pos);

    void setColor(Color color);

}
