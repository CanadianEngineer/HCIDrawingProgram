package drawingObjects;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class DrawingObject {
	//VARIABLES
	protected int m_x_start, m_y_start, m_x_end, m_y_end;
	protected Color m_color;
	protected boolean m_isAdjusting;
	
	//METHODS
	public DrawingObject(int x_start, int y_start, Color color){
		m_x_start = x_start;
		m_y_start = y_start;
		m_x_end = x_start;
		m_y_end = y_start;
		m_color = color;
		m_isAdjusting = true;
	}
	
	/**
	 * If the object is being resized, update will set the end coordinates of the object to the input values. Update automatically calls draw
	 * @param x x coordinate of mouse
	 * @param y y coordinate of mouse
	 */
	public void update(Graphics g, int x, int y){
		if(m_isAdjusting){
			m_x_end = x;
			m_y_end = y;
		}
		draw(g);
	}
	
	public void update (Graphics g){
		draw(g);
	}
	
	public void shift(int x_shift, int y_shift){
		m_x_start += x_shift;
		m_x_end += x_shift;
		m_y_start += y_shift;
		m_y_end += y_shift;
	}
	
	/**
	 * Draw puts the current object onto the screen based on the color
	 */
	public void draw(Graphics g){
		//TODO: Make the draw method
	}
	
	//Set Methods
	public void setColor(Color color){
		m_color = color;
	}
	
	public void stopAdjusting(){
		m_isAdjusting = false;
	}
	
	public boolean getAdjusting() {
		return this.m_isAdjusting;
	}
	
	/**
	 * returns boolean value of whether or not coordinates are within the area of the object.
	 * @param x
	 * @param y
	 */
	public boolean inRegion(int x, int y){
		//TODO: Contour region for ellipses and circles
		boolean inXRegion = false;
		boolean inYRegion = false;
		
		//Check for x region
		//x_start is left of x_end
		if(m_x_start <= x && m_x_end >= x){
			inXRegion = true;
		} 
		if (m_x_start >= x && m_x_end < x){
			inXRegion = true;
		}
		
		//Check for y region
		//y_start is left of y_end
		if(m_y_start <= y && m_y_end >= y){
			inYRegion = true;
		} 
		if (m_y_start >= y && m_y_end < y){
			inYRegion = true;
		}
		
		if(inXRegion && inYRegion){
			return true;
		} else {
			return false;
		}
	}
	
	public void updateEndpoint(int x, int y) {
		this.m_x_end = x;
		this.m_y_end = y;
	}
}
