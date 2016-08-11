import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class RefrigeratorGUI extends RefrigeratorDisplay implements ActionListener  {
	
	private static SimpleDisplay frame;
	private static Confugration config;
	protected int roomTemperature=50;
	protected int currentFridgeTemp;
	protected int currentFreezerTemp;
	private int desiredFridgeTemp;
	private int desiredFreezerTemp;
	private RefrigeratorGUI(){
		frame = new SimpleDisplay();
		initialize();
	}
	
	
	private class SimpleDisplay extends JFrame{
		
		private JLabel label1=new JLabel("Room temp"); 
		private JLabel label2=new JLabel("Desired fridge temp"); 
		private JLabel label3=new JLabel("Desired freezer temp"); 
		
		private JLabel status=new JLabel("Status"); 
		private JLabel status1=new JLabel("Fridge light OFF"); 
		private JLabel status2=new JLabel("Freezer light OFF"); 
		private JLabel status3=new JLabel("Fridge temp:  " + roomTemperature); 
		private JLabel status4=new JLabel("Freezer temp:  " + roomTemperature);
		private JLabel status5=new JLabel("Fridge IDLE");
		private JLabel status6=new JLabel("Freezer IDLE");
		
		private JTextArea roomTemp=new JTextArea(2,10);
		private JTextArea fridgeTemp=new JTextArea(2,10);
		private JTextArea freezerTemp=new JTextArea(2,10);
		
		private JButton roomTempBtn=new JButton("Set room temp");
		private JButton fridgeTempBtn=new JButton("Set fridge temp");
		private JButton freezerTempBtn=new JButton("Set freezer temp");
		private JButton openFridgeDoor=new JButton("Open fridge door");
		private JButton closeFridgeDoor=new JButton("Close fridge door");
		private JButton openFreezerDoor=new JButton("Open freezer door");
		private JButton closeFreezerDoor=new JButton("Close freezer door");
		private URL urlFridge;
		private URL urlFreezer;
		
		
		
		private SimpleDisplay(){
			
			super("Refrigerator");
			
			
			try {
				urlFridge = new  URL("http://www.ethicalconsumer.org/portals/0/images/reports/244634_large.jpg");
				urlFreezer = new  URL("http://s3.amazonaws.com/digitaltrends-uploads-prod/2014/02/freezer-header.jpg");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JPanel panel1=new JPanel(new GridLayout(3, 3));
			JPanel panel2=new JPanel(new GridLayout(2, 1));
			JPanel panel3=new JPanel(new GridLayout(1, 2));
			JPanel panel4=new JPanel();
			panel4.setLayout(new BorderLayout());
			JPanel panel5=new JPanel(new GridLayout(1, 2));
			JPanel panel6=new JPanel(new GridLayout(1, 2));
			JPanel panel8=new FridgePanel(urlFridge);
			JPanel panel9=new FridgePanel(urlFreezer);
			
			panel8.setLayout(new GridLayout(3, 1));
			panel9.setLayout(new GridLayout(3, 1));
			//add all the components to panel1
			label1.setForeground(Color.ORANGE);
			label2.setForeground(Color.ORANGE);
			label3.setForeground(Color.ORANGE);
			roomTempBtn.setForeground(Color.BLUE);
			fridgeTempBtn.setForeground(Color.BLUE);
			freezerTempBtn.setForeground(Color.BLUE);
			/**roomTemp.append();
			fridgeTemp.append();
			freezerTemp.append(String.valueOf());*/
			panel1.add(label1);
			panel1.add(roomTemp);
			panel1.add(roomTempBtn);
			panel1.add(label2);
			panel1.add(fridgeTemp);
			panel1.add(fridgeTempBtn);
			panel1.add(label3);
			panel1.add(freezerTemp);
			panel1.add(freezerTempBtn);
			
			roomTemp.append("50");
			openFridgeDoor.setForeground(Color.BLUE);
			closeFridgeDoor.setForeground(Color.BLUE);
			openFreezerDoor.setForeground(Color.BLUE);
			closeFreezerDoor.setForeground(Color.BLUE);
			
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			roomTemp.setBorder(BorderFactory.createCompoundBorder(border, 
			            BorderFactory.createEmptyBorder(2, 10, 2, 10)));
			fridgeTemp.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(2, 10, 2, 10)));
			freezerTemp.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(2, 10, 2, 10)));
			//add all the components to panel2 
			
			panel5.add(openFridgeDoor);
			panel5.add(closeFridgeDoor);
			panel6.add(openFreezerDoor);
			panel6.add(closeFreezerDoor);
			
			panel5.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(2, 10, 2, 10)));
			
			panel6.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(2, 10, 2, 10)));
			
			panel2.add(panel5);
			panel2.add(panel6);
			
			
			status.setForeground(Color.ORANGE);
			status1.setForeground(Color.MAGENTA);
			status2.setForeground(Color.MAGENTA);
			status3.setForeground(Color.MAGENTA);
			status4.setForeground(Color.MAGENTA);
			status5.setForeground(Color.MAGENTA);
			status6.setForeground(Color.MAGENTA);
			//add all components to panel3
			panel8.add(status);
			panel8.add(status1);
			panel9.add(status2);
			panel8.add(status3);
			panel9.add(status4);
			panel8.add(status5);
			panel9.add(status6);
			
			panel8.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(2, 10, 2, 10)));
			
			panel9.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(2, 10, 2, 10)));
			
			panel3.add(panel8);
			panel3.add(panel9);
			
			
			panel4.add(status,BorderLayout.NORTH);
			panel4.add(panel3,BorderLayout.CENTER);
			
			add(panel1, BorderLayout.NORTH);
			add(panel2,BorderLayout.SOUTH);
			add(panel4,BorderLayout.CENTER);
			
			roomTempBtn.addActionListener(RefrigeratorGUI.this);
			fridgeTempBtn.addActionListener(RefrigeratorGUI.this);
			freezerTempBtn.addActionListener(RefrigeratorGUI.this);
			openFridgeDoor.addActionListener(RefrigeratorGUI.this);
			openFreezerDoor.addActionListener(RefrigeratorGUI.this);
			closeFridgeDoor.addActionListener(RefrigeratorGUI.this);
			closeFreezerDoor.addActionListener(RefrigeratorGUI.this);
			
			setSize(400,400);
			setVisible(true);
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource().equals(frame.closeFridgeDoor)) {
			RefrigeratorContext.instance().processFridgeDoorEvent(
					RefrigeratorContext.FridgeEvents.FRIDGE_DOOR_CLOSED_EVENT);
		} else if (event.getSource().equals(frame.openFridgeDoor)) {
			RefrigeratorContext.instance().processFridgeDoorEvent(
					RefrigeratorContext.FridgeEvents.FRIDGE_DOOR_OPENED_EVENT);
		} else if (event.getSource().equals(frame.closeFreezerDoor)) {
			FreezerContext.instance().processFreezerDoorEvent(
					FreezerContext.FreezerEvents.FREEZER_DOOR_CLOSED_EVENT);
		}
		else if (event.getSource().equals(frame.openFreezerDoor)) {
			FreezerContext.instance().processFreezerDoorEvent(
					FreezerContext.FreezerEvents.FREEZER_DOOR_OPENED_EVENT);
			
		}
		else if(event.getSource().equals(frame.roomTempBtn)) {
			
			roomTemperature=Integer.valueOf(frame.roomTemp.getText());
			if(config.isValidRoomTemp(roomTemperature)){
				currentFridgeTemp=roomTemperature;
				currentFreezerTemp=roomTemperature;
				setFridgeTemp(currentFridgeTemp);
				setFreezerTemp(currentFreezerTemp);
			}
			else if(!config.isValidRoomTemp(roomTemperature)){
				System.out.println("Please enter a number between " + Confugration.getLowestRoomTemp() + " and  "
						+ Confugration.getHighestRoomTemp() );
			}
			
		}
		else if(event.getSource().equals(frame.freezerTempBtn)) {
			int temp=Integer.valueOf(frame.freezerTemp.getText());
			if(config.isValidFreezerTemp(temp)){
				desiredFreezerTemp=temp;
				FreezerContext.instance().processFreezerRunEvent(
						FreezerContext.FreezerCoolingEvents.FREEZER_START_COOLING_EVENT);
				freezerContext.setDesiredFreezerTemp(desiredFreezerTemp);
			}
			else if(!config.isValidFreezerTemp(temp)){
			System.out.println("Please enter a number between " + Confugration.getLowestFreezerTemp() + " and  "
					+ Confugration.getHighestFreezerTemp() );
			}
		}
		else if(event.getSource().equals(frame.fridgeTempBtn)) {
			int temp=Integer.valueOf(frame.fridgeTemp.getText());
			if(config.isValidFridgeTemp(temp)){
				desiredFridgeTemp=temp;
				RefrigeratorContext.instance().processFridgeRunEvent(
						RefrigeratorContext.FridgeCoolingEvents.FRIDGE_COOLING_REQUESTED_EVENT);
				context.setDesiredFridgeTemp(desiredFridgeTemp);
			}
			else if(!config.isValidFridgeTemp(temp)){
				System.out.println("Please enter a number between " + Confugration.getLowestFridgeTemp() + " and  "
						+ Confugration.getHighestFridgeTemp() );
				}
		}
		
	}
	/**
	 * returns only numbers out of a bunch of strings
	 *
	 */
	 public String drawDigitsFromString(String strValue){
         String str = strValue.trim();
         String digits="";
         if(!str.isEmpty()){
         for (int i = 0; i < str.length(); i++) {
             char chrs = str.charAt(i);              
             if (Character.isDigit(chrs))
                 digits = digits+chrs;
         }
         }
         return digits;
     }
	public int getDesiredFridgeTemp(){
		return desiredFridgeTemp;
	}
	
	public int getDesiredFreezerTemp(){
		return desiredFreezerTemp;
	}
	public int getCurrentFridgeTemp(){
		String temp="";
		int number=0;
		temp=frame.fridgeTemp.getText();
		if(!temp.isEmpty()){
			number=Integer.valueOf(temp);
		}
		return number;
	}
	public void setFridgeTemp(int double1) {
		// TODO Auto-generated method stub
		frame.status3.setText("Fridge temp:" + double1 + " F");
	}
	public int getCurrentFreezerTemp(){
		String temp="";
		int number=0;
		temp=frame.freezerTemp.getText();
		if(!temp.isEmpty()){
			number=Integer.valueOf(temp);
		}
		return number;
	}
	public void setFreezerTemp(int double1) {
		// TODO Auto-generated method stub
		frame.status4.setText("Freezer temp:" + double1 + " F");
	}
	@Override
	public int getRoomTemp() {
		// TODO Auto-generated method stub
		return Integer.valueOf(frame.roomTemp.getText());
	}
	
	

	@Override
	public void openFridgeDoor() {
		// TODO Auto-generated method stub
		frame.status1.setText("Fridge light ON");
	}

	@Override
	public void openFreezerDoor() {
		// TODO Auto-generated method stub
		frame.status2.setText("Freezer light ON");
	}

	@Override
	public void closeFridgeDoor() {
		// TODO Auto-generated method stub
		frame.status1.setText("Fridge light OFF");
	}

	@Override
	public void closeFreezerDoor() {
		// TODO Auto-generated method stub
		frame.status2.setText("Freezer light OFF");
	}

	@Override
	public void startFridgeCooling() {
		// TODO Auto-generated method stub
		frame.status5.setText("Fridge COOLING");
	}

	@Override
	public void startFreezerCooling() {
		// TODO Auto-generated method stub
		frame.status6.setText("Freezer COOLING");
	}

	@Override
	public void stopFridgeCooling() {
		// TODO Auto-generated method stub
		frame.status5.setText("Fridge IDLE");
	}

	@Override
	public void stoptFreezerCooling() {
		// TODO Auto-generated method stub
		frame.status6.setText("Freezer IDLE");
	}
	
	public static void main(String[] args) {
		config=new Confugration("confugration.txt");
		RefrigeratorDisplay display = new RefrigeratorGUI();
		
	}
	
}
