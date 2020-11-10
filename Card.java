import java.awt.*;
import java.util.Random;

public class Card {

    double centerx;
    double centery;
    double halfwidth;
    double halfheight;
    Color shapecolor;
    Circle circle1;

    //Default Constructor
    public Card(){
        this.centerx=0;
        this.centery=0;
        this.halfheight=12.5;
        this.halfwidth=8.5;
        this.shapecolor=Color.black;
        this.circle1=new Circle(this.centerx, this.centery, 5, this.shapecolor);
    }
    //Parametrized Constructor
    public Card(double centerx, double centery, Color shapecolor){
        this.centerx=centerx;
        this.centery=centery;
        this.shapecolor=shapecolor;
        this.halfwidth=8.5;
        this.halfheight=12.5;
        this.circle1=new Circle(this.centerx, this.centery, 5, this.shapecolor);
    }

    //Draw back public method
    public void drawback() {

        StdDraw.setPenColor(Color.black);
        StdDraw.filledRectangle(this.centerx, this.centery, this.halfwidth, this.halfheight);
    }

    //Draw front public method
    public void drawfront() {
        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(this.centerx, this.centery, this.halfwidth, this.halfheight); //Draw black outline of rectangle
        StdDraw.setPenColor(Color.black);
        StdDraw.rectangle(this.centerx, this.centery, this.halfwidth, this.halfheight);
        this.circle1.drawCircle();

    }

    //Accessor
    public Color getColor(){
        return shapecolor;
    }

    //Mutator
    public void setColor(Color shapecolor){
        this.shapecolor=shapecolor;
    }
}
