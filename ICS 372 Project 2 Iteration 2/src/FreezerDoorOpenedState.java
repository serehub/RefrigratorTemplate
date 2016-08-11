
/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
public class FreezerDoorOpenedState extends FreezerDoorState {
	private static FreezerDoorOpenedState instance;
	static {
		instance = new FreezerDoorOpenedState();
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static FreezerDoorOpenedState instance() {
		return instance;
	}

	/**
	 * Handle door closed event
	 */
	@Override
	public void handle(Object event) {
		if (event.equals(FreezerContext.FreezerEvents.FREEZER_DOOR_CLOSED_EVENT)) {
			processFreezerDoorClose();
		}
	}

	/**
	 * Process door closed event
	 */
	public void processFreezerDoorClose() {
		context.changeCurrentFreezerDoorState(FreezerDoorClosedState.instance());
	}

	/**
	 * Initialize the state
	 */
	@Override
	public void run() {
		display.openFreezerDoor();
		display.setFreezerTemp(context.getFreezerTemp());
	}
}