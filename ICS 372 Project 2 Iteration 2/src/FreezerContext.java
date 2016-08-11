
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
import java.util.Observer;

/**
 * The context is an observer for the clock and stores the context information for states
 *
 */
public class FreezerContext implements Observer {
	public static enum FreezerEvents {
		FREEZER_DOOR_CLOSED_EVENT, FREEZER_DOOR_OPENED_EVENT
	};
	public static enum FreezerCoolingEvents {
		FREEZER_START_COOLING_EVENT, FREEZER_STOP_COOLING_EVENT
	};
	
	private static RefrigeratorDisplay display;
	private FreezerRunState currentFreezerCoolingState;
	private FreezerDoorState currentFreezerDoorState;
	private FreezerEvents currentFreezerDoorEvent;
	private int currentFreezertemp;
	private int desiredFreezerTemp;
	private static FreezerContext instance;
	
	static {
		instance = new FreezerContext();
		display = RefrigeratorDisplay.instance();
	}

	/**
	 * Make it a singleton
	 */
	private FreezerContext() {
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static FreezerContext instance() {
		if (instance == null) {
			instance = new FreezerContext();
		}
		return instance;
	}

	/**
	 * lets the freezer door closed and cooling state initialized
	 */
	public void initialize() {
		instance.changeCurrentFreezerDoorState(FreezerDoorClosedState.instance());
		instance.setFreezerTemp(display.getRoomTemp());
		instance.changeCurrentFreezerRunState(FreezerCoolingState.instance());		
		currentFreezerDoorEvent = FreezerEvents.FREEZER_DOOR_CLOSED_EVENT;
		Clock.instance().addObserver(instance);
		
	}

	

	/**
	 * For observer
	 * 
	 * @param observable
	 *            will be the clock
	 * @param arg
	 *            the event that clock has ticked
	 */
	@ Override
	public void update(Observable observable, Object arg) {
		currentFreezerCoolingState.handle(arg);
		currentFreezerDoorState.handle(arg);
	}
	
	/**
	 * handles freezer cooling and not cooling
	 * 
	 * @param arg
	 */
	public void processFreezerRunEvent(Object arg) {
		currentFreezerCoolingState.handle(arg);
	}
	
	/**
	 * processes the freezer door close/open events
	 * 
	 * 
	 */
	public void processFreezerDoorEvent(Object arg) {
		currentFreezerDoorState.handle(arg);
		currentFreezerDoorEvent = (FreezerEvents) arg;
		FreezerNotCoolingState.freezerTimer = 0;
	}
	
	
	/**
	 *  changes the current cooling state
	 * 
	 * @param nextState
	 *            the next state
	 */
	public void changeCurrentFreezerRunState(FreezerRunState nextFreezerRunState) {
		currentFreezerCoolingState = nextFreezerRunState;
		nextFreezerRunState.run();
	}

	/**
	 * Changes the current stste of the door
	 * 
	 * @param nextState
	 *            the next state
	 */
	public void changeCurrentFreezerDoorState(FreezerDoorState nextFreezerDoorState) {
		currentFreezerDoorState = nextFreezerDoorState;
		nextFreezerDoorState.run();
	}
	
	/**
	 * Gets the display
	 * 
	 * @return the display
	 */
	public RefrigeratorDisplay getDisplay() {
		return display;
	}

	/**
	 * get the current event of the freezer door
	 * 
	 * @return currentFreezerDoorEvent
	 */
	public FreezerEvents getCurrentFreezerDoorEvent() {
		return currentFreezerDoorEvent;
	}

	/**
	 * returns the freezer temperature
	 * 
	 *
	 */
	public int getFreezerTemp() {
		return currentFreezertemp;
	}
	
	/**
	 * Sets the current freezer temperature
	 * 
	 * @param temp
	 *            
	 */
	public void setFreezerTemp(int temp) {
		this.currentFreezertemp = temp;
	}
	
	
	/**
	 * set the desired freezer temperature
	 * 
	 * @return 
	 */
	public void setDesiredFreezerTemp(int temp) {
		this.desiredFreezerTemp = temp;
	}
	
	/**
	 * returns the desired freezer temperature
	 * 
	 * @return 
	 */
	public int getDesiredFreezerTemp() {
		return desiredFreezerTemp;
	}



}