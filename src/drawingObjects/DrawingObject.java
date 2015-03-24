package drawingObjects;

import javax.swing.JFrame;

public class DrawingObject {
	//VARIABLES
	private int m_x_start, m_y_start, m_x_end, m_y_end;
	private String m_color;
	private boolean m_isAdjusting;
	private boolean m_isSelected;
	
	//METHODS
	public DrawingObject(int x_start, int y_start, String color){
		m_x_start = x_start;
		m_y_start = y_start;
		m_x_end = x_start;
		m_y_end = y_start;
		m_color = color;
		m_isAdjusting = true;
		this.select();
	}
	
	/**
	 * If the object is being resized, update will set the end coordinates of the object to the input values. Update automatically calls draw
	 * @param x x coordinate of mouse
	 * @param y y coordinate of mouse
	 */
	public void update(JFrame frame, int x, int y){
		if(m_isAdjusting){
			m_x_end = x;
			m_y_end = y;
			m_isSelected = true;
		}
		draw(frame);
	}
	
	/**
	 * Draw puts the current object onto the screen based on the color
	 */
	public void draw(JFrame frame){
		
	}
	
	//Set Methods
	public void setColor(String color){
		m_color = color;
	}
	
	public void stopAdjusting(){
		m_isAdjusting = false;
	}
	
	public void stopSelected(){
		m_isAdjusting = false;
		m_isSelected = false;
	}
	public void select(){
		m_isSelected = true;
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
}
