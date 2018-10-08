package com.deep.geometry;


import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class ConvexHull {
	
	private Stack<Point2D> hull = new Stack<Point2D>();
	private final double x;    // x coordinate
    private final double y;    // y coordinate
	public ConvexHull(Point2D[] pts)
	{
		//defensive copy
		int n = pts.length;
		Point2D[] points = new Point2D[n];
		for(int i=0; i<n; i++)
		{
			points[i] = pts[i];
		}
		//pre process so that points[0] has the lowest y-cordinate
		//break ties by x-cordinate
		//points[0] is an extereme point of the hull
		//(alternatively, it can be done in linear time)
		Arrays.sort(points);
		x = points[0].getX();
		y = points[0].getY();
		// sort by polar angle w.r.t. base point points[0]
		// breaking ties by distance to points[0]
		Arrays.sort(points, 1, n, new Comparator<Point2D>() {

			@Override
			public int compare(Point2D q1, Point2D q2) {

	            double dx1 = q1.getX() - x;
	            double dy1 = q1.getY() - y;
	            double dx2 = q2.getX() - x;
	            double dy2 = q2.getY() - y;

	            if      (dy1 >= 0 && dy2 < 0) return -1;    // q1 above; q2 below
	            else if (dy2 >= 0 && dy1 < 0) return +1;    // q1 below; q2 above
	            else if (dy1 == 0 && dy2 == 0) {            // 3-collinear and horizontal
	                if      (dx1 >= 0 && dx2 < 0) return -1;
	                else if (dx2 >= 0 && dx1 < 0) return +1;
	                else                          return  0;
	            
			}
				return (Integer) null;
			
		}});
		hull.push(points[0]); //points[0] is the first extreme point
		
		// find index k1 of first point not equal to points[0]
		int k1;
		for(k1 = 1; k1<n ; k1++)
		{
			if(!points[0].equals(points[k1]))
			{
				break;
			}
			if(k1 == n)
			{
				return;
			}
		}
		// find the index k2 of first point not co-linear with points[0] and points[k1]
		int k2;
		for(k2 = k1+1; k2<n; k2++)
		{
			if(ccw(points[0],points[k1],points[k2]) != 0)
			{
				break;
			}
			// point[k2 -1] is second extreme point
			hull.push(points[k2 - 1]);
		}
		
	// Points[n-1] is extreme point different from points[0]
		for(int i =k2; i < n; i++)
		{
			Point2D top = hull.pop();
			while(ccw(hull.peek(), top, points[i]) <= 0)
			{
				top = hull.pop();
			}
			hull.push(top);
			hull.push(points[i]);
		}
		assert isConvex();
	}
	
	private boolean isConvex() {
		int  n = hull.size();
		if(n < 2) return true;
		
		Point2D[] points  = new Point2D[n];
		int k =0;
		for(Point2D p : hull)
		{
			points[k++] = p;
		}
		for(int i=0; i <n ; i++)
		{
			if(ccw(points[i], points[(i+1)%n], points[(i+2)%n]) <= 0)
			{
				return false;
			}
		}
			
		return true;
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Point2D[] points = new Point2D[n];
		for(int i=0; i<n ; i++)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			System.out.println(x+" , "+y);
			points[i].setLocation(x, y);
		}
		ConvexHull convexHull = new ConvexHull(points);	
		for(Point2D p : convexHull.hull())
		{
			System.out.println(p);
		}
	}
  // Returns true if a>b>c is a counter clockwise turn
  // {-1,0,1} >> {clockwise, colinear , counter clockise}
	 public static double ccw(Point2D a, Point2D b, Point2D c) {
		 double area2 = (b.getX()-a.getX())*(c.getY()-a.getY()) -
				 (b.getY()-a.getY())*(c.getX()-a.getX());
	        if      (area2 < 0) return -1;
	        else if (area2 > 0) return +1;
	        else                return  0;
	    }
	 
	 
	// Returns the extreme points of hull in counterclockwise manner
	 public Iterable<Point2D> hull()
	 {
		 Stack<Point2D> s = new Stack<Point2D>();
		 for(Point2D p : hull)
		 {
			 s.push(p);
		 }
		 return s;
	 }
}
