
/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
public class FreezerCoolingState extends FreezerRunState {

	private int freezerTime = 0;

	private static FreezerCoolingState instance;
	static {
		instance = new FreezerCoolingState();
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static FreezerCoolingState instance() {
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
	 * Adjusts the rate at which the freezer cools based on configuration file
	 */
	public void processClockTick() {

		if (freezerTime == Confugration.timeForFreezerToCoolByOneDegree) {
			context.setFreezerTemp(context.getFreezerTemp() - 1);
			display.setFreezerTemp(context.getFreezerTemp());
			freezerTime = 0;
		}
		if (context.getFreezerTemp() == FreezerContext.instance().getDesiredFreezerTemp()) {
			context.changeCurrentFreezerRunState(FreezerNotCoolingState.instance());
		}
		freezerTime++;
	}

	/**
	 * Initializes the state
	 */
	@Override
	public void run() {
		display.startFreezerCooling();
		display.setFreezerTemp(context.getFreezerTemp());
	}
}