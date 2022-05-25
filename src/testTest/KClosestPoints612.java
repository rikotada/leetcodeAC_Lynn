package testTest;

import java.util.Arrays;
import java.util.Comparator;

class Point {
	    int x;
	    int y;
	    Point() { x = 0; y = 0; }
	    Point(int a, int b) { x = a; y = b; }
}

public class KClosestPoints612 {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        Point[] result = new Point[k];
        if(points == null || points.length == 0 || k == 0){
            return result;
        }
        Arrays.sort(points, new Comparator<Point>(){
            public int compare(Point o1,Point o2){
                 int a = (int)(Math.pow(o1.x - origin.x, 2) + Math.pow(o1.y - origin.y, 2));
                 int b = (int)(Math.pow(o2.x - origin.x, 2) + Math.pow(o2.y - origin.y, 2));
                 if(a != b){
                     return a - b;
                 }
                 if(o1.x != o2.x){
                     return o1.x - o2.x;
                 }
                 return o1.y - o2.y;
            }
        });

        return Arrays.copyOf(points, k);

    }
}