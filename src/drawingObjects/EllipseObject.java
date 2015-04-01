package drawingObjects;

import java.awt.Graphics;

import javax.swing.JFrame;

public class EllipseObject extends DrawingObject{

	public EllipseObject(int x_start, int y_start, int x_end, int y_end,
			String color) {
		super(x_start, y_start, color);
	}
	
	public void draw(Graphics g) {
		g.drawLine(m_x_start, m_y_start, m_x_end, m_y_end);
	}
}
