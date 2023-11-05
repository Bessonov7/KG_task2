package Drawers.Line;

import Drawers.Pixel.PixelDrawer;
import Geometry.Line;
import Geometry.Vec2;

import java.awt.*;

public class WuLineDrawer implements GradientLineDrawer{
    @Override
    public void drawLine(Line line, PixelDrawer drawer, Color color) {
        drawLineGradient(line, drawer, color, color);
    }

    @Override
    public void drawLineGradient(Line line, PixelDrawer drawer, Color color1, Color color2) {
        boolean steep = Math.abs(line.end.y - line.start.y) > Math.abs(line.end.x - line.start.x);
        if (steep)
        {
            line = new Line(line.start.swapPoints(), line.end.swapPoints());
        }
        if (line.start.x > line.end.x)
        {
            line = new Line(line.end, line.start);
        }

        Vec2 delta = new Vec2( line.end.x-line.start.x, line.end.y-line.start.y);

        //compute the slope
        double gradient = (double) delta.y/delta.x;
        double intersect = line.start.y;

        interface PointFactory{
            Vec2 create(int x, int y);
        }

        PointFactory pointCreate = !steep ? Vec2::new : (x, y) -> new Vec2(x, y).swapPoints();

        // work with color
        int diff = line.end.x - line.start.x;
        double diffR = (color2.getRed() - color1.getRed()) / (double) diff;
        double diffG = (color2.getGreen() - color1.getGreen()) / (double) diff;
        double diffB = (color2.getBlue() - color1.getBlue()) / (double) diff;

        for (int step = line.start.x ; step <= line.end.x ; step++) {

            Vec2 pos = pointCreate.create(step, (int) intersect);
            Vec2 pos1 = pointCreate.create(step, (int) intersect + 1);

            double bright = intersect - (int) intersect;

            int step_d = step - line.start.x;
            int r = (int) (color1.getRed() + diffR * step_d);
            int g = (int) (color1.getGreen() + diffG * step_d);
            int b = (int) (color1.getBlue() + diffB * step_d);
            drawer.setColor(new Color(r, g, b));
            drawer.drawPixel(pos, 1 - bright);
            drawer.drawPixel(pos1, bright);
            intersect += gradient;
        }
    }
}
