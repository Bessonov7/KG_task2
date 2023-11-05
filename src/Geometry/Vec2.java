package Geometry;

public class Vec2 {
    public Integer x;
    public Integer y;
    public Vec2(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Vec2 swapPoints(){
        return new Vec2(y, x);
    }
}