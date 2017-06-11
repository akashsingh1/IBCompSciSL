package akash;

import java.util.*;

import mickel.io.Console;

import java.io.File;
import java.io.FileNotFoundException;

public class AthleteManipulater {
	static String filepath = "/Users/AkashSingh/Documents/workspace/Project/src/akash/Data.txt";
	
    static ArrayList <Athlete> athletelist = new ArrayList<Athlete>();  
    /**
     * Stores Athlete who are in the hundred meters
     */
    static ArrayList <Athlete> onehmlist = new ArrayList<Athlete>(); 
    /**
     * Stores Athlete who are in the 4 hundred meters
     */
    static ArrayList <Athlete> fourhmlist = new ArrayList<Athlete>();
    /**
     * Stores Athlete who are in the 2 hundred meters
     */
    static ArrayList <Athlete> twohmlist = new ArrayList<Athlete>();
    /**
     * Stores Athlete who are in the hundred and ten hurdles
     */
    static ArrayList <Athlete> onehtenhurdleslist = new ArrayList<Athlete>();
    
    
    public static void main(String[] args) {
    	Console.show();
    	athleteHandler();
    	System.out.println("Total number of athletes: "+athletelist.size());
    	
    	Scanner person = new Scanner (System.in);
        System.out.println("Enter name of athlete: ");
        String existingathlete = person.nextLine();
        getDetailsofAthlete(existingathlete);	
        
        System.out.flush();
        
        System.out.println("Enter name of Event: ");
        Scanner event = new Scanner (System.in);
    	String search = event.nextLine();
     	double mintime = getMinEvent(search);
    	System.out.println("Minimum time: "+mintime + " minutes");
    	event.close();
    }
    
    /**
     * gets the details of the athlete including kit number, event, time 
     * @param searchathlete The name of the athlete the user wants more information about
     */
    private static void getDetailsofAthlete(String searchathlete) {
    	for (int i = 0; i< athletelist.size()-1;i++)
        {
    	   
        	if(searchathlete.equalsIgnoreCase(athletelist.get(i).getFname()))
        	{
        
        		System.out.println("First Name: "+athletelist.get(i).getFname() );
        		System.out.println("Last Name: " +athletelist.get(i).getLname());
        		System.out.println("Kit Number: " + athletelist.get(i).getKnumber());
        		System.out.println("Event: "+athletelist.get(i).getEventname() + " metres");
        		System.out.println("Time: "+ (athletelist.get(i).getMinutes() + (athletelist.get(i).getSeconds()/60)));
        		return;
        	}
        }
    	
    	System.out.println("Oops...no such athlete is found in the database. Please check that you have input the correct first name of the athlete");
    	return;
        }
    	
    
   /**
    * 
    * @param event the event in which user wants the name of the fastest athelete
    * @return
    */
    private static double getMinEvent(String event) {
    	System.out.println("inside getMinEvent ");
    	double minvalue=0;
    	if (event.equals("100")) {
    		if (onehmlist.size() >= 1) {
    		   minvalue=getMinValue(onehmlist);
    		} else {
    			System.out.println("There is no Athele assigned for 100m Event");
    		}
        }
    	
    	if (event.equals("200")) {
    	  if (twohmlist.size() >= 1)	{
 		   minvalue=getMinValue(twohmlist);
    	  } 
    	  else {
    		  System.out.println("There is no Athele assigned for 200m Event");
    	  }
    		  
    	} 
    	
    	if (event.equals("400")) {
    	   if (fourhmlist.size() >= 1) {	
    		   minvalue=getMinValue(fourhmlist);
    	   } else {
    		   System.out.println("There is no Athele assigned for 400m Event");  
    	   }
     	}
    	
    	if (event.equals("110hurdles")) {
    		if (onehtenhurdleslist.size() >= 1) {
    			minvalue=getMinValue(onehtenhurdleslist);
    		} else {
    			System.out.println("There is no Athele assigned for 110hurdles Event"); 
    		}
       }
    	
    	
    	return minvalue;
    }
    /**
     * Gets the name of the Athlete with the best time
     * @param eventlist the names of the Athletes in the required event
     * @return
     */
    private static double getMinValue( ArrayList <Athlete> eventlist ) {
    	double prevmin = Double.MAX_VALUE;
    	Athlete mintAthlete= new Athlete();
    	for (int i = 0; i< eventlist.size();i++)
		   {
			  double currmin =  (eventlist.get(i).getMinutes() + (eventlist.get(i).getSeconds()/60));
			 
			  
			  if (currmin <= prevmin) {
			  		prevmin=currmin;
			  		mintAthlete = (Athlete) eventlist.get(i);
			  }		
		   }
  	    System.out.println("Athlete with the minimum timed : "+ mintAthlete.getFname() + " "+mintAthlete.getLname());
  	
    	return prevmin;

    }
    /**
     * sorts through the text file and sorts the different characteristics of one athlete with the other
     */
    
	private static void athleteHandler() {
		try {
			int n = 0, j=0	;
			Athlete[] TheAthlete = new Athlete [10];
			Scanner sc = new Scanner(new File(filepath));
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				n++;
				if(n>1){
					TheAthlete [j] = new Athlete();
					athleteMaker(line, TheAthlete[j], j);
					j++;	
				}	
			}
			sc.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	/**
	 * Sets the charcateristics of the individual athletes so that it is easy to access them
	 * @param athleteinfo the line of text which contains the characteristics of the athlete
	 * @param myathlete name of the object Athlete
	 * @param index index at which athlete is added on the AthleteList
	 */
	private static void athleteMaker(String athleteinfo, Athlete myathlete, int index) {
		try {
			String[] info = athleteinfo.split("\\s+");
	 		myathlete.setFname(info [0]);
	 		myathlete.setLname(info[1]);
	 		myathlete.setKnumber(Integer.valueOf(info[2]));
	 		myathlete.setEventname(info[3]);
	 		myathlete.setMinutes(Integer.valueOf(info[4]));
	 		myathlete.setSeconds(Double.valueOf(info[5]));
	 		athletelist.add(index, myathlete);
	 			// this athlete object to 
	 		addtoEventlist(myathlete);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
     
	}
	/**
	 * adds the Athlete to his/her respective event
	 * @param newathlete new Athlete
	 */
	private static void addtoEventlist (Athlete newathlete) {
		// sets this object to particular event list
		//System.out.println("Got in addtoEventlist ");
		//System.out.println("addtoEventlist event: "+newathlete.getEventname());
		if (newathlete.getEventname().equals("100")) {
			//System.out.println("Got in 100m list");
			onehmlist.add(newathlete);
		}
		
		if (newathlete.getEventname().equals("200")) {
			//System.out.println("Got in 200m list");
			twohmlist.add(newathlete);
		}

		if (newathlete.getEventname().equals("400")) {
			//System.out.println("Got in 400m list");
			fourhmlist.add(newathlete);
		}
		
		if (newathlete.getEventname().equals("110hurdles")) {
			//System.out.println("Got in 110hurdles list");
			onehtenhurdleslist.add(newathlete);
		}
		
	}

	
}