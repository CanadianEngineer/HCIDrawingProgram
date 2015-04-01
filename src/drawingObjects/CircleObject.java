package drawingObjects;

import java.awt.Graphics;

public class CircleObject extends EllipseObject{

	public CircleObject(int x_start, int y_start, int x_end, int y_end,
			String color) {
		super(x_start, y_start, x_end, y_end, color);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		g.drawLine(m_x_start, m_y_start, m_x_end, m_y_end);
	}
	
}
