package drawingObjects;

import java.awt.Graphics;
import java.awt.Color;

public class CircleObject extends DrawingObject{

	public CircleObject(int x_start, int y_start, Color color) {
		super(x_start, y_start, color);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		g.setColor(m_color);
		g.drawOval(Math.min(m_x_start, m_x_end), Math.min(m_y_start, m_y_end), Math.max(Math.abs(m_x_end - m_x_start), Math.abs(m_y_end - m_y_start)), Math.max(Math.abs(m_x_end - m_x_start), Math.abs(m_y_end - m_y_start)));

	}
	
}
