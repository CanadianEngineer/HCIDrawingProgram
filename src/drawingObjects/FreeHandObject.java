package drawingObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class FreeHandObject extends DrawingObject{
	
	private ArrayList<Point> points = new ArrayList<Point>();

	public FreeHandObject(int x_start, int y_start, Color color) {
		super(x_start, y_start, color);
		// TODO Auto-generated constructor stub
	}
	
	public void addPoint(Point p){
		points.add(p);
	}
	
	public void draw(Graphics g) {
		g.setColor(m_color);
		
		for(int i = 0; i < points.size() - 2; i++){
			g.drawLine(points.get(i).x, points.get(i).y, points.get(i+1).x, points.get(i+1).y);
		}
	}

}
