package polygon;

public class Main {
    public static void main(String [] args)
    {
        IrregularPolygon myPolygon = new IrregularPolygon();
        myPolygon.add(new java.awt.geom.Point2D.Double(100, 100));
        myPolygon.add(new java.awt.geom.Point2D.Double(200, 100));
        myPolygon.add(new java.awt.geom.Point2D.Double(200, 200));
        myPolygon.add(new java.awt.geom.Point2D.Double(100, 200));
        myPolygon.draw();

        TestSuite.run();
    }
    
}
