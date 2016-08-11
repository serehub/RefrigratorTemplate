
/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
public class FreezerNotCoolingState extends FreezerRunState {

	public static int freezerTimer = 0;

	private static FreezerNotCoolingState instance;
	static {
		instance = new FreezerNotCoolingState();
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static FreezerNotCoolingState instance() {
		return instance;
	}

	/**
	 * Handle the event
	 * 
	 * @param event
	 *            the event to be processed
	 * 
	 */
	@Override
	public void handle(Object event) {
		if (event.equals(Clock.Events.CLOCK_TICKED_EVENT)) {
			processClockTick();
		}
	}

	/**
	 * Process clock ticks Generates the timer runs out event 
	 * Checks if freezer door is open or closed to adjust warming rate
	 */
	public void processClockTick() {

		if (freezerTimer == Confugration.timeFreezerTempRiseCoolingNotActiveDoorOpen
				&& FreezerContext.instance().getCurrentFreezerDoorEvent().equals(FreezerContext.FreezerEvents.FREEZER_DOOR_OPENED_EVENT)) {
			context.setFreezerTemp(context.getFreezerTemp() + 1);
			display.setFreezerTemp(context.getFreezerTemp());
			freezerTimer = 0;
		} else if (freezerTimer== Confugration.timeFreezerTempRiseCoolingNotActiveDoorClosed&& FreezerContext.instance().getCurrentFreezerDoorEvent()
						.equals(FreezerContext.FreezerEvents.FREEZER_DOOR_CLOSED_EVENT)) {
			context.setFreezerTemp(context.getFreezerTemp() + 1);
			display.setFreezerTemp(context.getFreezerTemp());
			freezerTimer = 0;
		}

		if (context.getFreezerTemp() == FreezerContext.instance().getDesiredFreezerTemp() + Confugration.tempDifferenceFreezerToStartCooling) {
			context.changeCurrentFreezerRunState(FreezerCoolingState.instance());
		}

		freezerTimer++;
	}

	/**
	 * Initializes the state
	 */
	@Override
	public void run() {
		context.setFreezerTemp(FreezerContext.instance().getDesiredFreezerTemp());
		display.stoptFreezerCooling();
		display.setFreezerTemp(context.getFreezerTemp());
	}
}