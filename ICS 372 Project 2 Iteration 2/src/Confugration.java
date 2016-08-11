/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	   :     Lihn Huynh
Project #2:  Iteration #2
Due date:    April 17, 2015
*/

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * 
 * This class reads the configuration file and assigns the appropriate 
 * value to the correct variable 
 */
public class Confugration {
	
	private String fileName;
	protected static int lowestFridgeTemp;
	protected static int highestFridgeTemp;
	protected static int lowestFreezerTemp;
	protected static int highestFreezerTemp;
	protected static int lowestRoomTemp;
	protected static int highestRoomTemp;
	protected static int timeFridgeTempRiseCoolingNotActiveDoorClosed;
	protected static int timeFridgeTempRiseCoolingNotActiveDoorOpen;
	protected static int timeFreezerTempRiseCoolingNotActiveDoorClosed;
	protected static int timeFreezerTempRiseCoolingNotActiveDoorOpen;
	protected static int tempDifferenceFridgeToStartCooling;
	protected static int tempDifferenceFreezerToStartCooling;
	protected static int timeForFridgeToCoolByOneDegree;
	protected static int timeForFreezerToCoolByOneDegree;
	
	/**
	 * constructs the configuration file using the file name and assigns each variable its correct value
	 * @param fileName
	 */
	
	@SuppressWarnings("deprecation")
	public Confugration(String fileName){
		this.fileName=fileName;
		
		DataInputStream input = null;
		try {
			input = new DataInputStream(new FileInputStream(this.fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found!");
		}
			
		try {
			while (input.available()>0){
				lowestFridgeTemp=Integer.valueOf(input.readLine());
				highestFridgeTemp=Integer.valueOf(input.readLine());
				lowestFreezerTemp=Integer.valueOf(input.readLine());
				highestFreezerTemp=Integer.valueOf(input.readLine());
				lowestRoomTemp=Integer.valueOf(input.readLine());
				highestRoomTemp=Integer.valueOf(input.readLine());
				timeFridgeTempRiseCoolingNotActiveDoorClosed=Integer.valueOf(input.readLine());
				timeFridgeTempRiseCoolingNotActiveDoorOpen=Integer.valueOf(input.readLine());
				timeFreezerTempRiseCoolingNotActiveDoorClosed=Integer.valueOf(input.readLine());
				timeFreezerTempRiseCoolingNotActiveDoorOpen=Integer.valueOf(input.readLine());
				tempDifferenceFridgeToStartCooling=Integer.valueOf(input.readLine());
				tempDifferenceFreezerToStartCooling=Integer.valueOf(input.readLine());
				timeForFridgeToCoolByOneDegree=Integer.valueOf(input.readLine());
				timeForFreezerToCoolByOneDegree=Integer.valueOf(input.readLine());
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 
	 * @returns the lowest fridge temperature
	 */
	public static int getLowestFridgeTemp() {
		return lowestFridgeTemp;
	}
	
	
	/**
	 * 
	 * @return the highest fridge temp
	 */
	public static int getHighestFridgeTemp() {
		return highestFridgeTemp;
	}
	
	public static int getLowestFreezerTemp() {
		return lowestFreezerTemp;
	}
	
	/**
	 * returns the highest freezer temp
	 * @return
	 */
	public static int getHighestFreezerTemp() {
		return highestFreezerTemp;
	}
	
	/**
	 * return's the lowest room temp
	 * @return
	 */
	public static int getLowestRoomTemp() {
		return lowestRoomTemp;
	}
	
	/**
	 * return's the highest room temp
	 * @return
	 */
	public static int getHighestRoomTemp() {
		return highestRoomTemp;
	}
	
	/**
	 * return's the time it takes to rise the temperature by one degree when the door is closed
	 * @return
	 */
	public static int getTimeFridgeTempRiseCoolingNotActiveDoorClosed() {
		return timeFridgeTempRiseCoolingNotActiveDoorClosed;
	}
	
	/**
	 * return's the time it takes to rise the temperature by one degree when the door is open
	 * @return
	 */
	public static int getTimeFridgeTempRiseCoolingNotActiveDoorOpen() {
		return timeFridgeTempRiseCoolingNotActiveDoorOpen;
	}
	
	/**
	 * return's the time it takes to rise the temperature by one degree when the door is open
	 * @return
	 */
	public static int getTimeFreezerTempRiseCoolingNotActiveDoorClosed() {
		return timeFreezerTempRiseCoolingNotActiveDoorClosed;
	}
	
	/**
	 * return's the time it takes to rise the temperature by one degree when the door is open
	 * @return
	 */
	public static int getTimeFreezerTempRiseCoolingNotActiveDoorOpen() {
		return timeFreezerTempRiseCoolingNotActiveDoorOpen;
	}
	
	/**
	 * return's the temp difference for the cooling to start
	 * @return
	 */
	public static int getTempDifferenceFridgeToStartCooling() {
		return tempDifferenceFridgeToStartCooling;
	}
	
	/**
	 * return's the temp difference for the cooling to start
	 * @return
	 */
	public static int getTempDifferenceFreezerToStartCooling() {
		return tempDifferenceFreezerToStartCooling;
	}
	
	/**
	 * return's the time for the fridge to cool by one degree
	 * @return
	 */
	public static int getTimeForFridgeToCoolByOneDegree() {
		return timeForFridgeToCoolByOneDegree;
	}
	
	/**
	 * return's the time for the freezer to cool by one degree
	 * @return
	 */
	public static int getTimeForFreezerToCoolByOneDegree() {
		return timeForFreezerToCoolByOneDegree;
	}
	
	
	
	/**
	 * checks if the given value is a valid room temperature
	 * @
	 * @r
	 */
	public boolean isValidRoomTemp(double value){
		
		return (value<=highestRoomTemp && value>=lowestRoomTemp);

	}
	/**
	 * checks if the given value is a valid fridge temperature
	 * @
	 * @r
	 */
	public boolean isValidFridgeTemp(double value){

		return (value<=highestFridgeTemp && value>=lowestFridgeTemp);
			
	}
	/**
	 * checks if the given value is a valid freezer temperature
	 * @
	 * @r
	 */
	public boolean isValidFreezerTemp(double value){

		return (value<=highestFreezerTemp && value>=lowestFreezerTemp);
	}
	
	
}
