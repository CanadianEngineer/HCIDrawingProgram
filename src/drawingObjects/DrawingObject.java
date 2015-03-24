package drawingObjects;

public class DrawingObject {
	//VARIABLES
	private int m_x_start, m_y_start, m_x_end, m_y_end;
	private String m_color;
	
	//METHODS
	public DrawingObject(int x_start, int y_start, String color){
		m_x_start = x_start;
		m_y_start = y_start;
		m_x_end = x_start;
		m_y_end = y_start;
		m_color = color;
	}
	
	/**
	 * If the object is being resized, update will set the end coordinates of the object to the input values. Update automatically calls draw
	 * @param x
	 * @param y
	 */
	public void update(int x, int y){
		m_x_end = x;
		m_y_end = y;
		draw();
	}
	
	/**
	 * Draw puts the current object onto the screen
	 */
	public void draw(){
		
	}
}
