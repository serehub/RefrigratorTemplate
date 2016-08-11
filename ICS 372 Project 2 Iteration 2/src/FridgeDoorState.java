/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
public abstract class FridgeDoorState {
	protected static  RefrigeratorContext context;
	protected static RefrigeratorDisplay display;

	/**
	 * Initializes the context and display
	 */
	protected FridgeDoorState() {
		context =  RefrigeratorContext.instance();
		display = context.getDisplay();
	}

	/**
	 * Initializes the state
	 */
	public abstract void run();
	
	/**
	 * Handles an event
	 * 
	 * @param event
	 *            event to be processed
	 */
	public abstract void handle(Object event);
	
	
}

