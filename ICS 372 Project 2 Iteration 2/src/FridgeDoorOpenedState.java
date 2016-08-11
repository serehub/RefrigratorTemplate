/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
public class FridgeDoorOpenedState extends FridgeDoorState {
	private static FridgeDoorOpenedState instance;
	static {
		instance = new FridgeDoorOpenedState();
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static FridgeDoorOpenedState instance() {
		return instance;
	}

	/**
	 * Handle door closed event
	 */
	@Override
	public void handle(Object event) {
		if (event.equals(RefrigeratorContext.FridgeEvents.FRIDGE_DOOR_CLOSED_EVENT)) {
			processFridgeDoorClose();
		}
	}

	/**
	 * Process door closed event
	 */
	public void processFridgeDoorClose() {
		context.changeCurrentFridgeDoorState(FridgeDoorClosedState.instance());
	}

	/**
	 * Initialize the state
	 */
	@Override
	public void run() {
		display.openFridgeDoor();
		display.setFreezerTemp(context.getFridgeTemp());
	}
}