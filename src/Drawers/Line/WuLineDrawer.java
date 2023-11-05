package Drawers.Line;

import Drawers.Pixel.PixelDrawer;
import Geometry.Line;
import Geometry.Vec2;

import java.awt.*;

public class WuLineDrawer implements GradientLineDrawer{
    @Override
    public void drawLine(Line line, PixelDrawer drawer, Color color) {
        boolean steep = Math.abs(line.end.y - line.start.y) > Math.abs(line.end.x - line.start.x);
        if (steep)
        {
            line = new Line(new Vec2(line.start.y, line.start.x), new Vec2(line.end.y, line.end.x));
        }
        if (line.start.x > line.end.x)
        {
            line = new Line(line.end, line.start);
        }

        Vec2 delta = new Vec2( line.end.x-line.start.x, line.end.y-line.start.y);

        //compute the slope
        double gradient = (double) delta.y/delta.x;
        double intersect = line.start.y;

        drawer.setColor(color);
        for (int step = line.start.x ; step <= line.end.x ; step++) {

            Vec2 pos = new Vec2(step, (int) intersect);
            Vec2 pos1 = new Vec2(step, (int) intersect + 1);
            if (steep){
                pos = new Vec2(pos.y, pos.x);
                pos1 = new Vec2(pos1.y, pos1.x);
            }

            double bright = intersect - (int) intersect;

            drawer.drawPixel(pos, 1 - bright);
            drawer.drawPixel(pos1, bright);
            intersect += gradient;
        }
    }

    @Override
    public void drawLineGradient(Line line, PixelDrawer drawer, Color color1, Color color2) {

    }
}
