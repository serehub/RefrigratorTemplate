/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
public abstract class FreezerState {
	
		protected static FreezerContext context;
		protected static RefrigeratorDisplay display;
		protected int currentFreezerTemp;

		/**
		 * Initialzies the context and display
		 */
		protected FreezerState() {
			context = FreezerContext.instance();
			display = context.getDisplay();
			
		}
		/**
		 * Initializes the context and display
		 */
		
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
