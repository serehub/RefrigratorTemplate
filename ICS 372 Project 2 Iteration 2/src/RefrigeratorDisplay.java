/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
import java.util.Observable;


public abstract class RefrigeratorDisplay extends Observable {
	protected static  RefrigeratorContext context;
	protected static  FreezerContext freezerContext;
	protected static RefrigeratorDisplay instance;

	/**
	 * Initializes the context and instance
	 */
	protected RefrigeratorDisplay() {
		instance = this;
		context =  RefrigeratorContext.instance();
		freezerContext=FreezerContext.instance();
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static RefrigeratorDisplay instance() {
		return instance;
	}

	/**
	 * Do the initializations to make the context an observer
	 */
	public void initialize() {
		instance().addObserver(context);
		context.initialize();
		instance().addObserver(freezerContext);
		freezerContext.initialize();
	}

	

	/**
	 * Indicate that the light is on
	 */
	public abstract void openFridgeDoor();
	/**
	 * Indicate that the light is on
	 */
	public abstract void openFreezerDoor();


	/**
	 * Indicate that the light is off
	 */
	public abstract void closeFridgeDoor();

	/**
	 * Indicate that the light is off
	 */
	public abstract void closeFreezerDoor();

	
	/**
	 * indicate that cooking has begun
	 */
	public abstract void startFridgeCooling();
	/**
	 * indicate that cooking has begun
	 */
	public abstract void startFreezerCooling();
	
	/**
	 * indicate that cooking has begun
	 */
	public abstract void stopFridgeCooling();
	/**
	 * indicate that cooking has begun
	 */
	public abstract void stoptFreezerCooling();
	/**
	 * returns the desired fridge temp
	 * @return
	 */
	public abstract int getDesiredFridgeTemp();
	/**
	 * returens the desired freezer temp
	 * @return
	 */
	public abstract int getDesiredFreezerTemp();
	/**
	 * returns the current fridge temp
	 * @return
	 */
	public abstract int getCurrentFridgeTemp();
	/**
	 * returns the current freezer temp
	 * @return
	 */
	public abstract int getCurrentFreezerTemp();
	/**
	 * sets the current fridge temp
	 * @param double1
	 */
	public abstract void setFridgeTemp(int double1);
	/**
	 * sets the current freezer temp
	 * @param double1
	 */
	public abstract void setFreezerTemp(int double1);
	/**
	 * sets the room temp
	 * @return
	 */
	public abstract int getRoomTemp();
		// TODO Auto-generated method stub


		
}