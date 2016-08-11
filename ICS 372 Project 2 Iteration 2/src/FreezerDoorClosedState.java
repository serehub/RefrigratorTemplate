/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
public class FreezerDoorClosedState extends FreezerDoorState {
	private static FreezerDoorClosedState instance;
	static {
		instance = new FreezerDoorClosedState();
	}

	/**
	 * returns the instance
	 * 
	 * @return this object
	 */
	public static FreezerDoorClosedState instance() {
		return instance;
	}

	/**
	 * Handles door open events
	 * 
	 */
	@Override
	public void handle(Object event) {
		if (event.equals(FreezerContext.FreezerEvents.FREEZER_DOOR_OPENED_EVENT)) {
			processFreezerDoorOpen();
		}
	}

	/**
	 * processes door open event
	 * 
	 */
	public void processFreezerDoorOpen() {
		context.changeCurrentFreezerDoorState(FreezerDoorOpenedState.instance());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void run() {
		display.closeFreezerDoor();
		display.setFreezerTemp(context.getFreezerTemp());
	}
}