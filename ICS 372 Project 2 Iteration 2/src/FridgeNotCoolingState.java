/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
public class FridgeNotCoolingState extends FridgeRunState {

	public static int fridgeTimer = 0;

	private static FridgeNotCoolingState instance;
	static {
		instance = new FridgeNotCoolingState();
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static FridgeNotCoolingState instance() {
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

		if (fridgeTimer == Confugration.timeFridgeTempRiseCoolingNotActiveDoorOpen
				&& RefrigeratorContext.instance().getCurrentFridgeDoorEvent().equals(FreezerContext.FreezerEvents.FREEZER_DOOR_OPENED_EVENT)) {
			context.setFridgeTemp(context.getFridgeTemp() + 1);
			display.setFridgeTemp(context.getFridgeTemp());
			fridgeTimer = 0;
		} else if (fridgeTimer == Confugration.timeFridgeTempRiseCoolingNotActiveDoorClosed
				&& RefrigeratorContext.instance().getCurrentFridgeDoorEvent().equals(RefrigeratorContext.FridgeEvents.FRIDGE_DOOR_CLOSED_EVENT)) {
			context.setFridgeTemp(context.getFridgeTemp() + 1);
			display.setFridgeTemp(context.getFridgeTemp());
			fridgeTimer = 0;
		}

		if (context.getFridgeTemp() == RefrigeratorContext.instance().getDesiredFridgeTemp() + Confugration.tempDifferenceFridgeToStartCooling) {
			context.changeCurrentFridgeRunState(FridgeCoolingState.instance());
		}

		fridgeTimer++;
	}

	/**
	 * Initializes the state
	 */
	@Override
	public void run() {
		context.setFridgeTemp(RefrigeratorContext.instance().getDesiredFridgeTemp());
		display.stopFridgeCooling();
		display.setFridgeTemp(context.getFridgeTemp());
	}
}
