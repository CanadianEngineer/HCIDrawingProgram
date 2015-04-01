package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import drawingObjects.*;
import develCode.Global;

public class GUIHandler extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	private ObjectHandler m_objHandler;
	private String m_mode = "LINE";
	
	private JPanel contentPane;
	private JFrame m_drawingFrame;
	//Menu Bar
	private JMenuBar menuBar;
	private JMenu mnFile, mnDrawOptions;
	private JMenuItem mnMenuItem;
	private ButtonGroup mnShapeSelect;
	private JRadioButtonMenuItem mnSelectButton, mnScribbleButton, mnLineButton, mnRectangleButton, mnSquareButton, mnEllipseButton, mnCircleButton, mnPolygonButton;
	private int m_currentX, m_currentY;
	
	private DrawingObject m_currentObject;
	
	public GUIHandler() {
		//Initializing Components
		m_objHandler = new ObjectHandler();
		mnShapeSelect = new ButtonGroup();
		
		//Initializing GUI Objects
		menuBar = new JMenuBar();
		mnFile = new JMenu("File");
		mnDrawOptions = new JMenu("Draw Mode");
		
		mnSelectButton = new JRadioButtonMenuItem("Select", false);
		mnDrawOptions.add(mnSelectButton);
		mnShapeSelect.add(mnSelectButton);
		
		mnScribbleButton = new JRadioButtonMenuItem("Scribble", false);
		mnDrawOptions.add(mnScribbleButton);
		mnShapeSelect.add(mnScribbleButton);
		
		mnLineButton = new JRadioButtonMenuItem("Line", false);
		mnDrawOptions.add(mnLineButton);
		mnShapeSelect.add(mnLineButton);
		
		mnRectangleButton = new JRadioButtonMenuItem("Rectangle", false);
		mnDrawOptions.add(mnRectangleButton);
		mnShapeSelect.add(mnRectangleButton);
		
		mnSquareButton = new JRadioButtonMenuItem("Square", false);
		mnDrawOptions.add(mnSquareButton);
		mnShapeSelect.add(mnSquareButton);
		
		mnEllipseButton = new JRadioButtonMenuItem("Ellipse", false);
		mnDrawOptions.add(mnEllipseButton);
		mnShapeSelect.add(mnEllipseButton);
		
		mnCircleButton = new JRadioButtonMenuItem("Circle", false);
		mnDrawOptions.add(mnCircleButton);
		mnShapeSelect.add(mnCircleButton);
		
		mnPolygonButton = new JRadioButtonMenuItem("Polygon", false);
		mnDrawOptions.add(mnPolygonButton);
		mnShapeSelect.add(mnPolygonButton);
		
		mnSelectButton.addActionListener(this);
		mnScribbleButton.addActionListener(this);
		mnLineButton.addActionListener(this);
		mnRectangleButton.addActionListener(this);
		mnSquareButton.addActionListener(this);
		mnEllipseButton.addActionListener(this);
		mnCircleButton.addActionListener(this);
		mnPolygonButton.addActionListener(this);
		
		
		contentPane = new JPanel(){
			
			/*
			 *	repaint() calls paintComponent with the appropriate graphics.
			 *	:. call repaint() in mouse handlers which will call paintComponent which will call updateAll :D we did it 
			 */
			
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				m_objHandler.updateAll(g, m_currentX, m_currentY);
			}
		};
		
		contentPane.addMouseListener(this);
		contentPane.addMouseMotionListener(this);
		
		//Setting general options
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Setting menu bar
		setJMenuBar(menuBar);
		menuBar.add(mnFile);
		menuBar.add(mnDrawOptions);
		
		//Setting content pane
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		this.setSize(800, 600);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		m_mode = e.getActionCommand().toUpperCase();
		
		Global.update(m_mode);
	}
	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(m_mode.equals("SELECT")){
			m_objHandler.select(e.getX(), e.getY());
		}
		
		if(m_currentObject == null) {
			if(m_mode.equals("LINE")) {
				m_currentObject = new LineObject(e.getX(), e.getY(), Color.black);
				m_objHandler.add(m_currentObject);
			}
			else if(m_mode.equals("RECTANGLE")) {
				System.out.println("MAKIN ANOTHER RECTANGLE HERE BOSS");
				m_currentObject = new RectangleObject(e.getX(), e.getY(), Color.black);
				m_objHandler.add(m_currentObject);
			}
			else if(m_mode.equals("SQUARE")) {
				
			}
			else if(m_mode.equals("ELLIPSE")) {
				
			}
			else if(m_mode.equals("CIRCLE")) {
				
			}
			else if(m_mode.equals("SCRIBBBLE")) {
				
			}
		}
		else {
			System.out.println("YES NULL");
			m_currentObject.stopAdjusting();
			m_currentObject = null;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		try {
			if(m_objHandler.getSelected() != null){
				int x_disp = e.getX() - m_currentX;
				int y_disp = e.getY() - m_currentY;
				m_objHandler.drag(e.getX(), e.getY(), x_disp, y_disp);
			}
		} catch (Exception e1) {
			Global.update(e1.getMessage());
		}
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		m_currentX = arg0.getX();
		m_currentY = arg0.getY();
		contentPane.repaint();
	}

}
