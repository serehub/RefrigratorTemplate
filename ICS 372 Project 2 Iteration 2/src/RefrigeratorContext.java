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
 * The context is an obserer for the clock and stores the context info for
 * states
 *
 */
public class RefrigeratorContext implements Observer {
	public static enum FridgeEvents {
		FRIDGE_DOOR_CLOSED_EVENT, FRIDGE_DOOR_OPENED_EVENT
	};
	public static enum FridgeCoolingEvents {
		 FRIDGE_COOLING_REQUESTED_EVENT,FRIDGE_STOP_COOLING_REQUESTED_EVENT
	};
	
	private static RefrigeratorDisplay display;
	private int currentFridgetemp;
	private int desiredFridgeTemp;
	private FridgeDoorState currentFridgeDoorState;
	private FridgeRunState currentFridgeCoolingState;
	private FridgeEvents currentFridgeEvent;

	private static RefrigeratorContext instance;
	static {
		instance = new RefrigeratorContext();
		display = RefrigeratorDisplay.instance();
	}

	/**
	 * Make it a singleton
	 */
	private RefrigeratorContext() {
	}

	/**
	 * Return the instance
	 * 
	 * @return the object
	 */
	public static RefrigeratorContext instance() {
		if (instance == null) {
			instance = new RefrigeratorContext();
		}
		return instance;
	}

	/**
	 * sets starting state 
	 * - freezer door closed
	 *  - freezer temp at room temp min from configuration file
	 *  - turns freezer on
	 * sets up observable for clock
	 */
	public void initialize() {
		instance.changeCurrentFridgeDoorState(FridgeDoorClosedState.instance());
		instance.setFridgeTemp(display.getRoomTemp());
		instance.changeCurrentFridgeRunState(FridgeCoolingState.instance());		
		currentFridgeEvent = FridgeEvents.FRIDGE_DOOR_CLOSED_EVENT;
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
		currentFridgeCoolingState.handle(arg);
		currentFridgeDoorState.handle(arg);
	}
	/**
	 * handles freezer door events (open/close)
	 * 
	 * @param arg
	 *            the event from the GUI
	 */
	public void processFridgeDoorEvent(Object arg) {
		currentFridgeDoorState.handle(arg);
		currentFridgeEvent = (FridgeEvents) arg;
		FridgeNotCoolingState.fridgeTimer = 0;
	}

	/**
	 * handles freezer run events (run/idle)
	 * 
	 * @param arg
	 */
	public void processFridgeRunEvent(Object arg) {
		currentFridgeCoolingState.handle(arg);
	}
	
	
	/**
	 * Called from the states to change the current run state
	 * 
	 * @param nextState
	 *            the next state
	 */
	public void changeCurrentFridgeRunState(FridgeRunState nextFridgeRunState) {
		currentFridgeCoolingState = nextFridgeRunState;
		nextFridgeRunState.run();
	}

	/**
	 * Called from the states to change the current door state
	 * 
	 * @param nextState
	 *            the next state
	 */
	public void changeCurrentFridgeDoorState(FridgeDoorState nextFridgeDoorState) {
		currentFridgeDoorState = nextFridgeDoorState;
		nextFridgeDoorState.run();
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
	public FridgeEvents getCurrentFridgeDoorEvent() {
		return currentFridgeEvent;
	}

	/**
	 * get the freezer temperature
	 * 
	 * @return current freezer temp
	 */
	public int getFridgeTemp() {
		return currentFridgetemp;
	}
	
	/**
	 * Sets the freezer temperature
	 * 
	 * @param temp
	 *            temperature of freezer
	 */
	public void setFridgeTemp(int temp) {
		this.currentFridgetemp = temp;
	}
	
	
	/**
	 * set the desired freezer temperature
	 * 
	 * @return current freezer temp
	 */
	public void setDesiredFridgeTemp(int temp) {
		this.desiredFridgeTemp = temp;
	}
	
	/**
	 * get the desired freezer temperature
	 * 
	 * @return current freezer temp
	 */
	public int getDesiredFridgeTemp() {
		return desiredFridgeTemp;
	}

	

}