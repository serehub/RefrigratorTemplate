
/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/
public class FridgeCoolingState extends FridgeRunState {

	private int fridgeTime = 0;
	private static FridgeCoolingState instance;
	static {
		instance = new FridgeCoolingState();
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static FridgeCoolingState instance() {
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
	 * 
	 */
	public void processClockTick() {
		
		if (fridgeTime == Confugration.timeForFridgeToCoolByOneDegree) {
			context.setFridgeTemp(context.getFridgeTemp() - 1);
			display.setFridgeTemp(context.getFridgeTemp());
			fridgeTime = 0;
		}
		if (context.getFridgeTemp() == RefrigeratorContext.instance().getDesiredFridgeTemp()) {
			context.changeCurrentFridgeRunState(FridgeNotCoolingState.instance());
		}
		fridgeTime++;
	}

	/**
	 * Initializes the state
	 */
	@Override
	public void run() {
		display.startFridgeCooling();
		display.setFridgeTemp(context.getFridgeTemp());
	}
}
