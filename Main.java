
import java.util.*; //Scanner and Math

class Main{
    public static void main(String[] args){ //MAIN
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Welcome to the plotter ***");
        System.out.println("What would you like to plot?");
        System.out.println("[1] Point / [2] Line / [3] Circle / [4] Vector Path / [5] 3D Plotting ");
        int start = scan.nextInt();

        if(start == 1){ //POINT
            System.out.println("enter x then y:");
            int xpoint = scan.nextInt();
            int ypoint = scan.nextInt();
            Point p1p = new Point(xpoint, ypoint);
            int respp = 0;

            while(respp != 4){ //LOOP FOR POINT MENU
                System.out.println("What would you like to do?");
                System.out.println("[1] Graph / [2] Edit / [3] Add point (turn into line) / [4] quit");
                respp = scan.nextInt();

                if(respp == 1){ //GRAPH POINT
                    GraphPrinter.printGraph(p1p);
                }

                if(respp == 2){ //EDIT POINT
                    System.out.println("Enter new x and y:");
                    int newx = scan.nextInt();
                    int newy = scan.nextInt();
                    p1p.changeX(newx);
                    p1p.changeY(newy);
                }

                if(respp == 3){ //POINT TO LINE
                    System.out.println("Enter your additional point (x then y)");
                    int newx = scan.nextInt();
                    int newy = scan.nextInt();
                    Point p2p = new Point(newx,newy);
                    Line lpoint = new Line(p1p,p2p);
                    int respl = 0;
                    while(respl != 4){ //LOOP FOR POINT TO LINE MENU

                        System.out.println("What would you like to do?");
                        System.out.println("[1] graph / [2] calculate / [3] to circle (first point becomes center) / [4] reset"); //MENU
                        respl = scan.nextInt();

                        if(respl == 1){ //GRAPH LINE
                            GraphPrinter.printGraph(lpoint);
                        }

                        if(respl == 2){ //CALCULATE LINE
                            System.out.println("What would you like to calculate?");
                            System.out.println("[1] Length / [2] Midpoint / [3] Angle / [4] back");
                            int resplCalc = scan.nextInt();

                            if(resplCalc == 1){ //GET LENGTH LINE
                                System.out.println("The length of your line is: " + lpoint.getLength());
                            }

                            if(resplCalc == 2){ //GET MIDPOINT LINE
                                System.out.println("The midpoint of your line is: (" + lpoint.getMidX() + "," + lpoint.getMidY() + ")");
                            }

                            if(resplCalc == 3){ //GET ANGLE LINE
                                System.out.println("The angle of your line, relative to the x-axis, is: " + lpoint.getAngle());
                            }

                            if(resplCalc == 4){ //BACK TO POINT MENU
                                continue;
                            }
                        }


                        if(respl == 3){ //LINE TO CIRCLE
                            Circle cline = new Circle(lpoint);
                            System.out.println("What would you like to do with your new circle?");
                            System.out.println("[1] graph / [2] calculate / [3] point checker (if point is in/on circle) / [4] back");
                            int respcir = scan.nextInt();

                            if(respcir == 1){ //GRAPH CIRCLE
                                GraphPrinter.printGraph(cline);
                            }

                            if(respcir == 2){ //CALCULATE CIRCLE
                                System.out.println("What would you like to calculate?");
                                System.out.println("[1] Circumference / [2] Area");
                                int repcircalc = scan.nextInt();

                                if(repcircalc == 1){ //GET CIRCUMFERENCE
                                    System.out.println("The circumference is: " +cline.getCircumference());
                                }

                                if(repcircalc == 2){ //GET AREA
                                    System.out.println("the area is " + cline.getArea());
                                }
                                if(respcir == 3){ //POINT CHECKER
                                    System.out.println("Enter the x then y coords for the point");
                                    int xtest = scan.nextInt();
                                    int ytest = scan.nextInt();
                                    Point tester = new Point(xtest,ytest);

                                    if(cline.liesOnCircle(tester)){
                                        System.out.println("The point DOES lie within the circle:");
                                    }

                                    else{
                                        System.out.println("The point DOES NOT lie within the circle:");
                                    }
                                }


                                if(repcircalc == 4){ //BACK TO POINT MENU
                                    continue;
                                }

                            }
                        }

                        if(respl == 4){
                            break;
                        }
                    }
                }
                if(respp == 4){ //QUIT
                    break;
                }
            }
        }

        if(start == 2){ //LINE
            System.out.println("enter first point(x then y):");
            int X1 = scan.nextInt();
            int Y1 = scan.nextInt();
            Point p1l = new Point(X1,Y1);    // <--- Instanciates 2 points
            System.out.println("enter second point:");
            int X2 = scan.nextInt();
            int Y2 = scan.nextInt();
            Point p2l = new Point(X2,Y2);
            Line L1 = new Line(p1l, p2l);    // <--- Line from the 2 points
            int respl = 0;
            while(respl != 4){

                System.out.println("What would you like to do?");
                System.out.println("[1] graph / [2] calculate / [3] to circle (first point becomes center) / [4] reset"); //MENU
                respl = scan.nextInt();

                if(respl == 1){ //GRAPH LINE
                    GraphPrinter.printGraph(L1);
                }

                if(respl == 2){ //CALCULATE LINE
                    System.out.println("What would you like to calculate?");
                    System.out.println("[1] Length / [2] Midpoint / [3] Angle");
                    int resplCalc = scan.nextInt();

                    if(resplCalc == 1){ //GET LENGTH
                        System.out.println("The length of your line is: " + L1.getLength());
                    }
                    if(resplCalc == 2){ //GET MIDPOINT
                        System.out.println("The midpoint of your line is: (" + L1.getMidX() + "," + L1.getMidY() + ")");
                    }
                    if(resplCalc == 3){ //GET ANGLE
                        System.out.println("The angle of your line, relative to the x-axis, is: " + L1.getAngle());
                    }
                }

                if(respl == 3){ //LINE TO CIRCLE
                    Circle cline = new Circle(L1);
                    System.out.println("What would you like to do with your new circle?");
                    System.out.println("[1] graph / [2] calculate / [3] point checker (if point is in/on circle) / [4] reset");
                    int respcir = scan.nextInt();

                    if(respcir == 1){ //GRAPH CIRCLE
                        GraphPrinter.printGraph(cline);
                    }

                    if(respcir == 2){ //CALCULATE CIRCLE
                        System.out.println("What would you like to calculate?");
                        System.out.println("[1] Circumference / [2] Area");
                        int repcircalc = scan.nextInt();

                        if(repcircalc == 1){ //GET CIRCUMFERENCE
                            System.out.println("The circumference is: " +cline.getCircumference());
                        }

                        if(repcircalc == 2){ //GET AREA
                            System.out.println("the area is " + cline.getArea());
                        }
                    }
                    if(respcir == 3){ //POINT CHECKER
                        System.out.println("Enter the x then y coords for the Point");
                        int xtest = scan.nextInt();
                        int ytest = scan.nextInt();
                        Point tester = new Point(xtest,ytest);

                        if(cline.liesOnCircle(tester)){
                            System.out.println("The Point DOES lie within the circle:");
                        }

                        else{
                            System.out.println("The Point DOES NOT lie within the circle:");
                        }
                    }
                }

                if(respl == 4){
                    break;
                }
            }
        }

        if(start == 3){ //CIRCLE

            System.out.println("Enter the x then y coords for the center:");
            int xcir = scan.nextInt();
            int ycir = scan.nextInt();
            Point pcir = new Point(xcir, ycir);
            System.out.println("Enter the length of the radius:");
            int radcir = scan.nextInt();
            Circle c1 = new Circle(pcir, radcir);
            int respcir = 0;
            while(respcir != 4){

                System.out.println("What would you like to do?");
                System.out.println("[1] graph / [2] calculate / [3] Point checker (if Point is in/on circle) / [4] quit");
                respcir = scan.nextInt();

                if(respcir == 1){ //GRAPH CIRCLE
                    GraphPrinter.printGraph(c1);
                }

                if(respcir == 2){ //CALCULATE CIRCLE
                    System.out.println("What would you like to calculate?");
                    System.out.println("[1] Circumference / [2] Area");
                    int repcircalc = scan.nextInt();

                    if(repcircalc == 1){ //GET CIRCUMFERENCE
                        System.out.println("The circumference is: " +c1.getCircumference());
                    }

                    if(repcircalc == 2){ //GET AREA
                        System.out.println("the area is " + c1.getArea());
                    }
                }

                if(respcir == 3){ //POINT CHECKER
                    System.out.println("Enter the x then y coords for the Point");
                    int xtest = scan.nextInt();
                    int ytest = scan.nextInt();
                    Point tester = new Point(xtest,ytest);

                    if(c1.liesOnCircle(tester)){
                        System.out.println("The Point DOES lie within the circle:");
                    }

                    else{
                        System.out.println("The Point DOES NOT lie within the circle:");
                    }
                }

                if(respcir == 4){ //QUIT
                    break;
                }
            }
        }

        if(start == 4){ //VECTOR PATH
            System.out.println("Enter your start Point (x then y):");
            double xv = scan.nextDouble();
            double yv = scan.nextDouble();
            PrecisePoint pv = new PrecisePoint(xv, yv);

            double deg;
            double mag;
            ArrayList<Line> arrpath = new ArrayList<>();

            while (true) { // Infinite loop until user enters -1
                System.out.println("Enter your direction (degrees: N is 90) and magnitude or enter -1 to end:");

                deg = scan.nextDouble();
                if (deg == -1) { // End the input if -1 is entered
                    break;
                }

                mag = scan.nextDouble();
                if (mag < 0) {
                    System.out.println("Magnitude cannot be negative. Try again.");
                    continue;
                }

                Line temp = new Line(pv, deg, mag);
                arrpath.add(temp);
                pv = temp.getPPoint2(); // Update to the new endpoint
            }

            if (!arrpath.isEmpty()) {
                Path p = new Path(arrpath);

                System.out.println("Displacement Length = " + p.getResLength() + " units");
                System.out.println("Displacement Angle = " + p.getResAngle() + " degrees");
                System.out.println("End Point = " + pv.printCoord());
            }

            else {
                System.out.println("No valid lines were entered.");
            }
        }

        if(start == 5){ //3D PLOTTING
            System.out.println("What would you like to plot?");
            System.out.println("[1] Point / [2] Line / [3] Sphere ");
            int start3d = scan.nextInt();

            if(start3d == 1){ //Point
                System.out.println("Enter your x, y, and z values");
                int xp3 = scan.nextInt();
                int yp3 = scan.nextInt();
                int zp3 = scan.nextInt();
                Point3d p1 = new Point3d(xp3, yp3, zp3);

                System.out.println("What would you like to do?");
                System.out.println("[1] To Line (add point) / [2] reset");
                int men = scan.nextInt();

                if(men == 1){
                    System.out.println("Enter your x, y, and z values");
                    int xpp3 = scan.nextInt();
                    int ypp3 = scan.nextInt();
                    int zpp3 = scan.nextInt();
                    Point3d p2 = new Point3d(xp3, yp3, zp3);
                    Line3d l1 = new Line3d(p1,p2);
                    System.out.println("length = " + l1.getLength());
                }

            }
            if(start3d == 2){ //Line
                System.out.println("Enter your x, y, and z values for your first point");
                int xl1 = scan.nextInt();
                int yl1 = scan.nextInt();
                int zl1 = scan.nextInt();
                Point3d p1 = new Point3d(xl1,yl1,zl1);
                System.out.println("Enter your x, y, and z values for your second point");
                int xl2 = scan.nextInt();
                int yl2 = scan.nextInt();
                int zl2 = scan.nextInt();
                Point3d p2 = new Point3d(xl2,yl2,zl2);
                Line3d l1 = new Line3d(p1,p2);
                System.out.println("length = " + l1.getLength());


            }
            if(start3d == 3){ //SPHERE
                System.out.println("Enter your center point(x then y then z)");
                int sphx = scan.nextInt();
                int sphy = scan.nextInt();
                int sphz = scan.nextInt();
                Point3d p = new Point3d(sphx,sphy,sphz);
                System.out.println("Enter your radius)");
                int rad = scan.nextInt();
                Sphere s = new Sphere(p, rad);
                System.out.println("Volume: " + s.getVolume());
                System.out.println("Surface Area: " + s.getArea());
            }
        }
    }
}

class Point{

    private int x;
    private int y;

    public Point(int xcoord, int ycoord){ //CONSTRUCTOR
        x=xcoord;
        y=ycoord;
    }
    public int getPointX(){ //RETURNS X COORDINATE
        return x;
    }
    public int getPointY(){ //RETURNS Y COORDINATE
        return y;
    }
    public void changeX(int newx){ //CHANGE X
        x = newx;
    }
    public void changeY(int newy){ //CHANGE Y
        y = newy;
    }
    public String printCoord(){
        return "(" + x + ", " + y + ")";
    }
}

class Line{
    private Point p1;
    private Point p2;
    private PrecisePoint pp1;
    private PrecisePoint pp2;
    private double angle;
    private double length;

    public Line(Point Point1, Point Point2){ //CONSTRUCTOR (Point, Point)
        p1 = Point1;
        p2 = Point2;

        int x1 = p1.getPointX();
        int y1 = p1.getPointY();
        int x2 = p2.getPointX();
        int y2 = p2.getPointY();
        length = (double) Math.sqrt((Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2))); //CALCULATES AND SETS LENGTH AND ANGLE

        angle = Math.toDegrees(Math.asin( (p2.getPointY() - p1.getPointY()) / length)); // ||
    }

    public Line(PrecisePoint p, double a, double l) { // Constructor (PrecisePoint, angle, length)
        pp1 = p;
        angle = a;
        length = l;

        // Convert the angle to radians before using trigonometric functions
        double angleRadians = Math.toRadians(a);

        // Calculate the displacement in x and y
        double dx = l * Math.cos(angleRadians);
        double dy = l * Math.sin(angleRadians);

        // Create the second point based on the first point and the displacement
        pp2 = new PrecisePoint(dx + pp1.getPointX(), dy + pp1.getPointY());
    }
    public double getLength(){ //RETURNS LENGTH
        return length;
    }
    public double getMidX(){ //X MIDPOINT
        int x1 = p1.getPointX();
        int x2 = p2.getPointX();

        return (double) (x1 + x2)/2;
    }
    public double getMidY(){ //Y MIDPOINT
        int y1 = p1.getPointY();
        int y2 = p2.getPointY();

        return (double) (y1 + y2)/2;
    }
    public double getAngle(){ //RETURNS ANGLE
        return angle;
    }
    public Point getPoint1(){ //RETURNS FIRST POINT
        return p1;
    }
    public Point getPoint2(){ //RETURNS SECOND POINT
        return p2;
    }
    public PrecisePoint getPPoint2(){ //RETURNS SECOND POINT
        return pp2;
    }
}

class Circle{
    private Point center;
    private double radius;
    public final double pi = Math.PI;

    public Circle(Line l1){ //CONSTRUCTOR
        center = l1.getPoint1();
        radius = l1.getLength();
    }
    public Circle(Point p1, double len){ //CONSTRUCTOR
        center = p1;
        radius = len;
    }
    public double getCircumference(){ //RETURNS CIRCUMFERENCE
        return 2 * pi * radius;
    }
    public double getArea(){ //RETURNS AREA
        return pi * Math.pow(radius,2);
    }
    public Point getCenter(){ //RETURNS CENTER
        return center;
    }
    public double getRadius(){ //RETURNS RADIUS
        return radius;
    }
    public boolean liesOnCircle(Point target){ //POINT TESTER
        Line tester = new Line(center,target);
        if(tester.getLength() <= radius){
            return true;
        }
        else{
            return false;
        }
    }
}

class Path {
    private ArrayList<Line> arrline = new ArrayList<>();
    private double Rlength;
    private double Rx;
    private double Ry;
    private double Rangle;

    public Path(ArrayList<Line> list) { // Constructor (Array of lines)
        for (int j = 0; j < list.size(); j++) { // Go through array of lines
            Rx += Math.cos(Math.toRadians(list.get(j).getAngle())) * list.get(j).getLength(); // Calculate dx
            Ry += Math.sin(Math.toRadians(list.get(j).getAngle())) * list.get(j).getLength(); // Calculate dy
        }

        // Pythagorean theorem to get resultant length
        Rlength = Math.sqrt(Math.pow(Rx, 2) + Math.pow(Ry, 2));

        // Calculate angle with proper handling for atan2
        Rangle = Math.toDegrees(Math.atan2(Ry, Rx)); // atan2 handles full range of angles
    }

    public double getResLength() {
        return Rlength;
    }

    public double getResAngle() {
        return Rangle;
    }
}

class PrecisePoint{ //USED FOR FINDING ENDPOINT OF VECTOR LINE WITH DEFINED LENGTH & UNDEFINED ENDPOINT (POINT WITH DOUBLES RATHER THAN INTS)
    private double x;
    private double y;

    public PrecisePoint(double x1, double y1){
        x = x1;
        y = y1;
    }
    public double getPointX(){
        return x;
    }
    public double getPointY(){
        return y;
    }
    public String printCoord(){
        return "(" + x + ", " + y + ")";
    }
}

class Point3d{
    private int x;
    private int y;
    private int z;

    public Point3d(int x1, int y1, int z1){
        x = x1;
        y = y1;
        z = z1;
    }

    public int getPointX(){
        return x;
    }
    public int getPointY(){
        return y;
    }
    public int getPointZ(){
        return z;
    }
}

class Line3d{
    private Point3d p1;
    private Point3d p2;
    private double length;

    public Line3d(Point3d point1, Point3d point2){ //CONSTRUCTOR WITH 2 POINTS
        p1 = point1;
        p2 = point2;

        int x1 = p1.getPointX();
        int x2 = p2.getPointX();
        int y1 = p1.getPointY();
        int y2 = p2.getPointY();
        int z1 = p1.getPointZ();
        int z2 = p2.getPointZ();

        double dx = x2 - x1;
        double dy = y2 - y1;
        double dz = z2 - z1;

        length = Math.sqrt(dx * dx + dy * dy + dz * dz); //CALCULATES LENGTH WITH 3D PYTHAGOREAN THM

    }
    public double getLength(){
        return length;
    }
}

class Sphere{
    private double radius;
    private Point3d center;
    private double volume;
    private double area;

    public Sphere(Point3d p, double r){ //CONSTRUCTOR WITH CENTER AND RADIUS
        radius = r;
        center = p;

        volume = (4/3) * (Math.PI * Math.pow(radius,3));
        area = 4 * (Math.PI * Math.pow(radius,2));
    }
    public Sphere(Circle c){ //CONSTRUCTOR WITH CIRCLE
        radius = c.getRadius();

        volume = (4/3) * (Math.PI * Math.pow(radius,3));
        area = 4 * (Math.PI * Math.pow(radius,2));
    }

    public double getVolume(){
        return volume;
    }
    public double getArea(){
        return area;
    }
}

class GraphPrinter {
    public static void printGraph(Point p) {
        char[][] grid = createEmptyGrid();
        int x = p.getPointX();
        int y = p.getPointY();

        if (isValidPoint(x, y)) {
            grid[20 - y][x] = '*';
        }

        printGrid(grid);
    }

    public static void printGraph(Line l) {
        char[][] grid = createEmptyGrid();
        Point p1 = l.getPoint1();
        Point p2 = l.getPoint2();

        drawLine(grid, p1.getPointX(), p1.getPointY(), p2.getPointX(), p2.getPointY());

        printGrid(grid);
    }

    public static void printGraph(Circle c) {
        char[][] grid = createEmptyGrid();
        Point center = c.getCenter();
        double radius = c.getRadius();

        drawCircle(grid, center.getPointX(), center.getPointY(), radius);

        printGrid(grid);
    }

    private static char[][] createEmptyGrid() {
        char[][] grid = new char[21][21];
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                if (i == 20) {
                    grid[i][j] = (j == 20) ? '+' : '-';
                } else {
                    grid[i][j] = (j == 20) ? '|' : ' ';
                }
            }
        }
        return grid;
    }

    private static boolean isValidPoint(int x, int y) {
        return x >= 0 && x <= 20 && y >= 0 && y <= 20;
    }

    private static void drawLine(char[][] grid, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int err = dx - dy;

        while (true) {
            if (isValidPoint(x1, y1)) {
                grid[20 - y1][x1] = '*';
            }
            if (x1 == x2 && y1 == y2) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }

    private static void drawCircle(char[][] grid, int centerX, int centerY, double radius) {
        int x = 0;
        int y = (int) radius;
        int d = 1 - (int) radius;

        drawCirclePoints(grid, centerX, centerY, x, y);
        while (x < y) {
            if (d < 0) {
                d = d + 2 * x + 3;
            } else {
                d = d + 2 * (x - y) + 5;
                y--;
            }
            x++;
            drawCirclePoints(grid, centerX, centerY, x, y);
        }
    }

    private static void drawCirclePoints(char[][] grid, int cx, int cy, int x, int y) {
        int[][] points = {
                {cx + x, cy + y}, {cx - x, cy + y}, {cx + x, cy - y}, {cx - x, cy - y},
                {cx + y, cy + x}, {cx - y, cy + x}, {cx + y, cy - x}, {cx - y, cy - x}
        };

        for (int[] Point : points) {
            if (isValidPoint(Point[0], Point[1])) {
                grid[20 - Point[1]][Point[0]] = '*';
            }
        }
    }

    private static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }

    public static void main(String[] args) {
        // Create a Point for the center of the circle
        Point center = new Point(10, 10);  // example coordinates

        // Create a Circle with the center and a radius
        Circle c1 = new Circle(center, 5);  // example radius

        // Print the circle using GraphPrinter
        printGraph(c1);
    }
}
