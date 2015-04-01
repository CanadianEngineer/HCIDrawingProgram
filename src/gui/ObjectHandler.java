package gui;

import java.awt.Color;
import java.awt.Graphics;
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
	private DrawingObject m_copyObject;
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
	
	public void updateAll(Graphics g, int x, int y){
		//takes in x and y coordinates because update function takes x and y coordinates to update an object that is being adjusted
		//CLEAR SCREEN
		
		for(int i = 0; i < this.size(); i++){
			m_objects.get(i).update(g, x, y);
			if (m_objects.get(i).getAdjusting()) {
				m_objects.get(i).updateEndpoint(x, y);
			}
		}
	}
	public void updateAll(Graphics g){
		//CLEAR SCREEN
		
		for(int i = 0; i < this.size(); i++){
			m_objects.get(i).update(g);
		}
	}
	
	//Cut Copy and Paste
	public void select(int x, int y){
		boolean foundSelected = false;
		
		//Reversed to select top-most object
		loop:
		for (int i = this.size()-1; i >= 0; i--){
			if(m_objects.get(i).inRegion(x,  y)){
				select(i);
				foundSelected = true;
				break loop;
			}
		}
	
		//If no object is selected, deselect all objects
		if(!foundSelected) m_hasSelected = false;
		for(int i = 0; i < this.size(); i++){
			//If object is not being selected, deselect it
			if(!foundSelected || foundSelected && m_selectedObjectIndex != i) deselect(i);
		}
	}
	public void select(int index){
		m_selectedObjectIndex = index;
		m_hasSelected = true;
		
		//TODO: Modify selected object. Add little squares around object?
		m_objects.get(index).select();
	}
	
	public void deselect(int index){
		m_objects.get(index).deselect();
	}
	
	public void drag(int mouse_x, int mouse_y, int x_disp, int y_disp){
		//Make sure mouse is within selected objects region
		try {
			if(getSelected().inRegion(mouse_x, mouse_y)){
				//If it is, move the object based on displacement values
				getSelected().shift(x_disp, y_disp);
			}
		} catch (Exception e) {
			//If no selected object, do NOTHING
		}
	}
	
	public void copy() throws Exception{
		if(m_hasSelected){
			m_copyObject = m_objects.get(m_selectedObjectIndex);
		} else {
			throw new Exception("No selected Object");
		}
	}
	
	/**
	 * Calls copy, removes the selected object, and updates the screen
	 * @throws Exception Thrown if no object is selected
	 */
	public void cut() throws Exception{
		if(m_hasSelected){
			copy();
			m_objects.remove(m_selectedObjectIndex);
		} else {
			throw new Exception("No selected object");
		}
	}
	
	public void paste(int mouse_x, int mouse_y){
		if(m_copyObject != null){
			
			m_copyObject.setCenter(mouse_x, mouse_y);
			
			m_objects.add(m_copyObject);
		}
	}
	
	public DrawingObject getSelected() throws Exception{
		if(m_hasSelected){
			return m_objects.get(m_selectedObjectIndex);
		} else {
			throw new Exception("No selected object");
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
