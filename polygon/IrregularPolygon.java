package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public double perimeter() {
       double perimeter = 0.0;
        for(int i = 1; i < myPolygon.size(); i++){
            double dx = myPolygon.get(i).getX() - myPolygon.get(i-1).getX();
            double dy = myPolygon.get(i).getY() - myPolygon.get(i-1).getY();              
            double distance = Math.sqrt(dx*dx + dy*dy);
            perimeter += distance;
            }
        double dx = myPolygon.get(0).getX() - myPolygon.get(myPolygon.size()-1).getX();
        double dy = myPolygon.get(0).getY() - myPolygon.get(myPolygon.size()-1).getY();
        double distance = Math.sqrt(dx*dx + dy*dy);
        perimeter += distance;
        return perimeter;
    }

   public double area() {
    Double area = 0.0;
    for(int i = 1; i < myPolygon.size(); i++){
        area += (myPolygon.get(i-1).getX() * myPolygon.get(i).getY()) - (myPolygon.get(i).getX() * myPolygon.get(i-1).getY());
    }
    area += (myPolygon.get(myPolygon.size()-1).getX() * myPolygon.get(0).getY()) - (myPolygon.get(0).getX() * myPolygon.get(myPolygon.size()-1).getY());
    return Math.abs(area) / 2;
}

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            myDrawingTool.move(myPolygon.get(0).getX(), myPolygon.get(0).getY());
            for(int i = 1; i < myPolygon.size(); i++){
                double dx = myPolygon.get(i).getX() - myPolygon.get(i-1).getX();
                double dy = myPolygon.get(i).getY() - myPolygon.get(i-1).getY();   
                double angle = Math.toDegrees(Math.atan2(dy, dx));
                double distance = Math.sqrt(dx*dx + dy*dy);
                myDrawingTool.setDirection(angle);
                myDrawingTool.forward(distance);
            }
            double dx = myPolygon.get(0).getX() - myPolygon.get(myPolygon.size()-1).getX();
            double dy = myPolygon.get(0).getY() - myPolygon.get(myPolygon.size()-1).getY();   
            double angle = Math.toDegrees(Math.atan2(dy, dx));
            double distance = Math.sqrt(dx*dx + dy*dy);
            myDrawingTool.setDirection(angle);
            myDrawingTool.forward(distance);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
