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
	private ArrayList<DrawingObject> m_objectHistory;
	private int m_selectedObjectIndex;
	private boolean m_hasSelected;
	
	public ObjectHandler(){
		m_objects = new ArrayList<DrawingObject>();
		m_objectHistory = new ArrayList<DrawingObject>();
		m_selectedObjectIndex = 0;
		m_hasSelected = false;
	}
	
	//METHODS
	public void add(DrawingObject obj){
		m_objects.add(obj);
		m_objectHistory.add(obj);
	}
	public int size(){
		return m_objects.size();
	}
	
	public void updateAll(JFrame frame, int x, int y){
		//CLEAR SCREEN
		
		for(int i = 0; i < this.size(); i++){
			m_objects.get(i).update(frame, x, y);
		}
	}
	
	//Cut Copy and Paste
	public void select(int x, int y){
		int selectedID = 0;
		
		//Reversed to select top-most object
		for (int i = this.size(); i >= 0; i--){
			if(m_objects.get(i).inRegion(x,  y)){
				m_selectedObjectIndex = i;
				m_hasSelected = true;
				break;
			}
		}
	}
	
	public void drag(int mouse_x, int mouse_y, int x_disp, int y_disp){
		//Make sure mouse is within selected objects region
		if(getSelected().inRegion(mouse_x, mouse_y)){
			//TODO: If it is, move the object based on displacement values
			
		}
		
		//TODO: Call update
	}
	
	public DrawingObject getSelected(){
		if(m_hasSelected){
			return m_objects.get(m_selectedObjectIndex);
		} else {
			return null;
		}
	}
	
	//ADVANCED SHIT
	public void undo(){
		//TODO: is it size-1? Or just size?
		m_objects.remove(this.size()-1);
	}
	
	public void redo(){
		//TODO: Again, do we need size-1? Or size?
		//TODO: Error proofing: Dont add an element when an undo has not been called
		//TODO: Resetting history when a new object has been added after undo has been called
		m_objects.add(m_objectHistory.get(this.size()));
	}
}
