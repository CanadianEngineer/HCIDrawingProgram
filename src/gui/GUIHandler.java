package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

	public GUIHandler() {
		//Initializing Components
		m_objHandler = new ObjectHandler(m_drawingFrame);
		
		//Initializing GUI Objects
		menuBar = new JMenuBar();
		mnFile = new JMenu("File");

		contentPane = new JPanel();
		
		//Setting general options
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Setting menu bar
		setJMenuBar(menuBar);
		menuBar.add(mnFile);
		
		//Setting content pane
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		this.setVisible(true);
	}

}
