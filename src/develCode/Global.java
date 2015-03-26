package develCode;

/**
 * @version 0.2
 * @author Andrew Lampert
 *
 */
public class Global {
	boolean g_devMode = true;
	
	/**
	 * Displays code to console with link back to where code was called
	 * @author Andrew Lampert
	 * @param s display message
	 */
	public void update(String s){
		if(g_devMode){
			
			//Getting trace element that was before entering global.update
			StackTraceElement frame = new Exception().getStackTrace()[1];
			
			//Extracting file name and line number from element
			String fileName = frame.getFileName();
			String lineNumber = frame.getLineNumber() + "";
			
			//Displaying link and message to console
			System.out.println("(" + fileName + ":" + lineNumber + ") " + s);
		}
	}
}
