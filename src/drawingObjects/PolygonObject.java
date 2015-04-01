package drawingObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class PolygonObject extends DrawingObject {
	
	private ArrayList<Point> points = new ArrayList<Point>();;
	public PolygonObject(int x_start, int y_start, Color color) {
		super(x_start, y_start, color);
	}
	
	public void addPoint(Point p){
		points.add(p);
	}
	
	public Point getLastPoint(){
		return points.get(points.size() - 1);
	}
	
	public void draw(Graphics g) {
		g.setColor(m_color);
		
		for(int i = 0; i < points.size() - 1; i++){
			g.drawLine(points.get(i).x, points.get(i).y, points.get(i+1).x, points.get(i+1).y);
		}
	}
	
	public void shift(int x_shift, int y_shift){
		for(Point p : points){
			p.x += x_shift;
			p.y += y_shift;
		}

		m_x_start += x_shift;
		m_y_start += y_shift;
		m_x_end += x_shift;
		m_y_end += y_shift;
	}
	
	public void stopAdjusting(){
		m_isAdjusting = false;
		
		for(Point p : points){
			//setting left region
			if(p.x < m_x_start) m_x_start = (int) p.x;
			//setting right region
			if(p.x > m_x_end) m_x_end = (int)p.x;
			
			//setting top region
			if(p.y < m_y_start) m_y_start = (int) p.y;
			//Setting bottom region
			if(p.y > m_y_end) m_y_end = (int) p.y;
		}
	}

}
