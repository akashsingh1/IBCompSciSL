package akash;

import java.util.*;
public class Athlete {
//fields
	/**
	 * stores first name
	 */
	private  String fname;
	/**
	 * stores last name
	 */
	private  String lname;
	/**
	 * stores kit number
	 */
	private int knumber;
	/**
	 * stores athlete's event 
	 */
	private  String eventname;
	private  int minutes;
	private  double seconds;
	
	public Athlete() {
		
	}

	public Athlete ( String firstn, String lastn, int knum, String event, int min, double sec){
	this.setFname(firstn);
	this.setLname(lastn);
	this.setKnumber(knum);
	this.setEventname(event);
	this.setMinutes(min);
	this.setSeconds(sec);
	}
	
	

	
	
	

	/**
	 * @return the fname
	 */
	public  String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String first) {
		fname = first;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	
	/**
	 * @param lname the lname to set
	 */
	public  void setLname(String last) {
		lname = last;
	}

	/**
	 * @return the knumber
	 */
	public int getKnumber() {
		return knumber;
	}

	/**
	 * @param knumber the knumber to set
	 */
	public void setKnumber(int kit) {
		knumber = kit;
	}

	/**
	 * @return the eventname
	 */
	public String getEventname() {
		return eventname;
	}

	/**
	 * @param eventname the eventname to set
	 */
	public  void setEventname(String event) {
		eventname = event;
	}
	
	public  int getMinutes(){
		return minutes;
	}
	/**
	 * @param minutes the minutes to set
	 */
	public  void setMinutes(int min) {
		minutes = min;
	}

	public  double getSeconds(){
		return seconds;
	}
/**
	 * @param seconds the seconds to set
	 */
	public void setSeconds(double sec) {
		seconds = sec;
	}
}
