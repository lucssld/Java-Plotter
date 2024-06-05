public class GraphPrinter {
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
