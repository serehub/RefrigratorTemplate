/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
public abstract class FreezerRunState {
	protected static FreezerContext context;
	protected static RefrigeratorDisplay display;

	/**
	 * Initializes the context and display
	 */
	protected FreezerRunState() {
		context = FreezerContext.instance();
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
