import java.awt.*;

public class Circle {

    private double centerx;
    private double centery;
    private int radius;
    private Color color;

    //Default Constructor
    public Circle( ){
        this.centerx=0;
        this.centery=0;
        this.radius=5;
        this.color= Color.black;
    }

    //Parametrized Constructor
    public Circle(double centerx, double centery, int radius, Color color){
        this.centerx=centerx;
        this.centery=centery;
        this.radius=radius;
        this.color=color;
    }
    //Accessors
    public double getCenterX() {
        return centerx;
    }

    public double getCenterY() {
        return centery;
    }

    public int getRadius(){
        return radius;
    }
    public Color getColor(){
        return color;
    }

    //Mutators
    public void setCenterx(double centerx){
        this.centerx=centerx;
    }

    public void setCentery(double centery){
        this.centery=centery;
    }
    public void setRadius(int radius){
        this.radius=radius;
    }
    public void setColor(String Color){
        this.color= java.awt.Color.black;
    }

    public void drawCircle(){
        StdDraw.setPenColor(this.color);
        StdDraw.filledCircle(this.centerx, this.centery, this.radius);
    }
}
