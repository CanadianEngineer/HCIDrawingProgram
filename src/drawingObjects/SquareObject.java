package drawingObjects;

import java.awt.Graphics;
import java.awt.Color;

public class SquareObject extends RectangleObject{

	public SquareObject(int x_start, int y_start, Color color) {
		super(x_start, y_start, color);
	}
	
	public void draw(Graphics g) {
		g.setColor(m_color);
		g.drawLine(m_x_start, m_y_start, m_x_end, m_y_end);
	}

}
