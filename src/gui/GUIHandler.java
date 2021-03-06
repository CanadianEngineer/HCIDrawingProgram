package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
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
import java.awt.Dimension;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class GUIHandler extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	private ObjectHandler m_objHandler;
	private String m_mode = "LINE";
	
	private JPanel contentPane;
	private JFrame m_drawingFrame;
	//Menu Bar
	private JMenuBar menuBar;
        private JColorChooser chooser;
	private JMenu mnFile, mnDrawOptions;
	private JMenuItem mnMenuItem;
	private ButtonGroup mnShapeSelect, mnFileButtons;
	private JRadioButtonMenuItem mnCutButton, mnPasteButton, mnSelectButton, mnScribbleButton, mnLineButton, mnRectangleButton, mnSquareButton, mnEllipseButton, mnCircleButton, mnPolygonButton;
	private int m_currentX, m_currentY;
	private Color m_selectedColor;
        private JOptionPane optionPane;
	
	private DrawingObject m_currentObject;
	
	public GUIHandler() {
		m_selectedColor = Color.BLACK;
		//Initializing Components
		m_objHandler = new ObjectHandler();
		mnShapeSelect = new ButtonGroup();
		mnFileButtons = new ButtonGroup();
		
		//Initializing GUI Objects
		menuBar = new JMenuBar();
		mnFile = new JMenu("File");
		mnDrawOptions = new JMenu("Draw Mode");
		
		mnCutButton = new JRadioButtonMenuItem("Cut", false);
		mnFile.add(mnCutButton);
		mnFileButtons.add(mnCutButton);
		
		mnPasteButton = new JRadioButtonMenuItem("Paste", false);
		mnFile.add(mnPasteButton);
		mnFileButtons.add(mnPasteButton);
		
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
                
                Dimension dim = new Dimension(200,800);
                chooser = new JColorChooser(m_selectedColor);
                chooser.setMaximumSize(dim);
                m_selectedColor = chooser.getColor();
		
		mnSelectButton.addActionListener(this);
		mnScribbleButton.addActionListener(this);
		mnLineButton.addActionListener(this);
		mnRectangleButton.addActionListener(this);
		mnSquareButton.addActionListener(this);
		mnEllipseButton.addActionListener(this);
		mnCircleButton.addActionListener(this);
		mnPolygonButton.addActionListener(this);
		
		mnCutButton.addActionListener(this);
		mnPasteButton.addActionListener(this);
		
		
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
                contentPane.add(chooser, BorderLayout.SOUTH);
		
		this.setSize(800, 600);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		m_mode = e.getActionCommand().toUpperCase();
		
		if(m_mode.equals("CUT")){
			try {
				m_objHandler.cut();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
		}
		
		m_currentObject = null;
		
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
		
		if(m_mode.equals("PASTE")){
			m_objHandler.paste(e.getX(), e.getY());
			contentPane.repaint();
			m_mode = "SELECT";
		}
		
		if(m_currentObject == null) {
			if(m_mode.equals("LINE")) {
				m_currentObject = new LineObject(e.getX(), e.getY(), chooser.getColor());
				m_objHandler.add(m_currentObject);
			}
			else if(m_mode.equals("RECTANGLE")) {
				m_currentObject = new RectangleObject(e.getX(), e.getY(), chooser.getColor());
				m_objHandler.add(m_currentObject);
			}
			else if(m_mode.equals("SQUARE")) {
				m_currentObject = new SquareObject(e.getX(), e.getY(), chooser.getColor());
				m_objHandler.add(m_currentObject);
			}
			else if(m_mode.equals("ELLIPSE")) {
				m_currentObject = new EllipseObject(e.getX(), e.getY(), chooser.getColor());
				m_objHandler.add(m_currentObject);
			}
			else if(m_mode.equals("CIRCLE")) {
				m_currentObject = new CircleObject(e.getX(), e.getY(), chooser.getColor());
				m_objHandler.add(m_currentObject);
			}
			else if(m_mode.equals("POLYGON")) {
				m_currentObject = new PolygonObject(e.getX(), e.getY(), chooser.getColor());
				m_objHandler.add(m_currentObject);
				((PolygonObject) m_currentObject).addPoint(new Point(e.getX(), e.getY()));
			}
			else if(m_mode.equals("SCRIBBLE")) {
				m_currentObject = new FreeHandObject(e.getX(), e.getY(), chooser.getColor());
				m_objHandler.add(m_currentObject);
			}
			

		}
		else {
			if(m_mode.equals("POLYGON")){
				if(e.getButton() == e.BUTTON1){
					((PolygonObject) m_currentObject).addPoint(new Point(e.getX(), e.getY()));
					contentPane.repaint();
				}
				else if(e.getButton() == e.BUTTON3){
					m_currentObject.stopAdjusting();
					m_currentObject = null;
				}
			}
			else {
				m_currentObject.stopAdjusting();
				m_currentObject = null;
			}
		}
		
		contentPane.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(m_mode.equals("SCRIBBLE")){
			m_currentObject.stopAdjusting();
			m_currentObject = null;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(m_mode.equals("SELECT")){
			try {
				if(m_objHandler.getSelected() != null){
					int x_disp = e.getX() - m_currentX;
					int y_disp = e.getY() - m_currentY;
					m_objHandler.drag(e.getX(), e.getY(), x_disp, y_disp);
					
					mouseMoved(e);
				}
			} catch (Exception e1) {
				Global.update(e1.getMessage());
			}
		}
		else if (m_mode.equals("SCRIBBLE")){
			((FreeHandObject) m_currentObject).addPoint(new Point(e.getX(), e.getY()));
			contentPane.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		m_currentX = arg0.getX();
		m_currentY = arg0.getY();
		contentPane.repaint();
	}

}
