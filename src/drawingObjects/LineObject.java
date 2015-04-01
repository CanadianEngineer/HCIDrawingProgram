package drawingObjects;

import java.awt.Color;
import java.awt.Graphics;

public class LineObject extends DrawingObject {

	public LineObject(int x_start, int y_start, Color color) {
		super(x_start, y_start, color);
		
	}
	
	public void draw(Graphics g) {
		g.setColor(m_color);
		g.drawLine(m_x_start, m_y_start, m_x_end, m_y_end);
	}

}
