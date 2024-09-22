Program Overview
This program models 2D and 3D geometric shapes, allowing users to create and manipulate points, lines, circles, spheres, and paths, while also providing functionality to visualize these shapes on a grid.

Class Descriptions
Point

Represents a point in 2D space with integer coordinates.
Methods:
Constructor to initialize the point with x and y coordinates.
Getter methods for x and y coordinates.
Methods to change the x and y coordinates.
Method to return the coordinates as a formatted string.
PrecisePoint

Represents a point with double precision in 2D space.
Methods:
Constructor to initialize the precise point with x and y coordinates.
Getter methods for x and y coordinates.
Method to return the coordinates as a formatted string.
Line

Represents a line segment defined by two points or a point with an angle and length.
Methods:
Constructors for creating a line from two points or from a precise point, angle, and length.
Methods to calculate and return the length, midpoint coordinates, and angle of the line.
Getter methods for the points that define the line.
Circle

Represents a circle defined by its center and radius.
Methods:
Constructors to initialize the circle from a line segment or from a point and radius.
Methods to calculate and return the circumference and area of the circle.
Getter methods for the center and radius.
Method to check if a given point lies on the circle.
Path

Represents a collection of line segments, allowing for the calculation of resultant displacement.
Methods:
Constructor to initialize a path from an array of line segments.
Methods to calculate and return the resultant length and angle of the path.
Point3d

Represents a point in 3D space with integer coordinates.
Methods:
Constructor to initialize the point with x, y, and z coordinates.
Getter methods for x, y, and z coordinates.
Line3d

Represents a line segment in 3D space defined by two points.
Methods:
Constructor to initialize the line with two 3D points.
Method to calculate and return the length of the line segment.
Sphere

Represents a sphere defined by its center and radius.
Methods:
Constructors to initialize the sphere from a center point and radius or from a circle.
Methods to calculate and return the volume and surface area of the sphere.
GraphPrinter

Provides methods to visualize points, lines, and circles on a grid.
Methods:
Overloaded methods to print a point, line, or circle on a character grid.
Helper methods to create an empty grid, validate point coordinates, and draw lines and circles on the grid.
Main Functionality
The program can create geometric shapes, compute various properties, and visualize them on a simple grid. It demonstrates the relationships between different geometric entities and enables users to experiment with geometric concepts.
