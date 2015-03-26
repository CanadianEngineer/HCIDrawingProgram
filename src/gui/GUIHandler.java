package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import develCode.Global;

public class GUIHandler extends JFrame implements ActionListener {

	private ObjectHandler m_objHandler;
	private String mode;
	
	private JPanel contentPane;
	private JFrame m_drawingFrame;
	//Menu Bar
	private JMenuBar menuBar;
	private JMenu mnFile, mnDrawOptions;
	private JMenuItem mnMenuItem;
	private ButtonGroup mnShapeSelect;
	private JRadioButtonMenuItem mnScribbleButton, mnLineButton, mnRectangleButton, mnSquareButton, mnEllipseButton, mnCircleButton, mnPolygonButton;

	public GUIHandler() {
		//Initializing Components
		m_objHandler = new ObjectHandler(m_drawingFrame);
		mnShapeSelect = new ButtonGroup();
		
		//Initializing GUI Objects
		menuBar = new JMenuBar();
		mnFile = new JMenu("File");
		mnDrawOptions = new JMenu("Draw Mode");
		
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
		
		mnScribbleButton.addActionListener(this);
		mnLineButton.addActionListener(this);
		mnRectangleButton.addActionListener(this);
		mnSquareButton.addActionListener(this);
		mnEllipseButton.addActionListener(this);
		mnCircleButton.addActionListener(this);
		mnPolygonButton.addActionListener(this);
		
		
		contentPane = new JPanel();
		
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
		
		mode = e.getActionCommand().toUpperCase();
		
		Global.update(mode);
	}

}
