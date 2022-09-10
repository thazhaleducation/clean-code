// Problem: Find area of rectangle. Data points are length and width of the rectangle
class Rectangle {
  public int length;
  public int height;

  public Rectangle(int length, int height) {
    this.length = length;
    this.height = height;
  }
}

public class AreaCalculator {
  
  public static void main(String[] args) {
    Rectangle r  = new Rectangle(10, 20);
    System.out.println("Area of the rectangle is " + new RectangleAreaCalculator().area(r)); 
  }
}


class RectangleAreaCalculator {
  public int area(Rectangle r) {
    return r.length * r.height;
  }
}