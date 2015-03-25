package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class GUIHandler extends JFrame {

	private ObjectHandler m_objHandler;
	
	private JPanel contentPane;
	private JFrame m_drawingFrame;
	//Menu Bar
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mnMenuItem;
	private ButtonGroup mnShapeSelect;

	public GUIHandler() {
		//Initializing Components
		m_objHandler = new ObjectHandler(m_drawingFrame);
		mnShapeSelect = new ButtonGroup();
		
		//Initializing GUI Objects
		menuBar = new JMenuBar();
		mnFile = new JMenu("File");
		
		mnMenuItem = new JMenuItem("fuck");
		mnMenuItem.setSelected(true);
		mnShapeSelect.add(mnMenuItem);
		mnFile.add(mnMenuItem);
		
		mnMenuItem = new JMenuItem("me");
		mnMenuItem.setSelected(false);
		mnShapeSelect.add(mnMenuItem);
		mnFile.add(mnMenuItem);
		
		contentPane = new JPanel();
		
		//Setting general options
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Setting menu bar
		setJMenuBar(menuBar);
		menuBar.add(mnFile);
		
		//Setting content pane
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		this.setSize(800, 600);
		
		this.setVisible(true);
	}

}
