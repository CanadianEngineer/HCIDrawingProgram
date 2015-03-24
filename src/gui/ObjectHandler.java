package gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import drawingObjects.*;

/**
 * Holds array of all the objects and has methods to control all the objects
 * @author andrew
 *
 */
public class ObjectHandler {
	private ArrayList<DrawingObject> m_objects;
	
	public ObjectHandler(){
		m_objects = new ArrayList<DrawingObject>();
	}
	
	//METHODS
	public void add(DrawingObject obj){
		m_objects.add(obj);
	}
	public int size(){
		return m_objects.size();
	}
	
	public void updateAll(JFrame frame, int x, int y){
		//CLEAR SCREEN
		
		for(int i = 0; i < this.size(); i++){
			m_objects.get(i).update(x, y);
		}
	}
}
