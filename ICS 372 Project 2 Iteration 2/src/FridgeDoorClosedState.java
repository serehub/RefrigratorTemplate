/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
public class FridgeDoorClosedState extends FridgeDoorState {
	private static FridgeDoorClosedState instance;
	static {
		instance = new FridgeDoorClosedState();
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static FridgeDoorClosedState instance() {
		return instance;
	}

	/**
	 * Handles door open events
	 * 
	 */
	@Override
	public void handle(Object event) {
		if (event.equals(RefrigeratorContext.FridgeEvents.FRIDGE_DOOR_OPENED_EVENT)) {
			processFridgeDoorOpen();
		}
	}

	/**
	 * processes door open event
	 * 
	 */
	public void processFridgeDoorOpen() {
		context.changeCurrentFridgeDoorState(FridgeDoorOpenedState.instance());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void run() {
		display.closeFridgeDoor();
		display.setFreezerTemp(context.getFridgeTemp());
	}
}