package out.Celena_Lewis_657697_assignsubmission_file_;//Celena Lewis
//816019582
//Assignment One COMP 2603
import java.util.Scanner;

public class BreakoutRoom{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private int numberOfParticipants;
    private boolean open;
    private Participant[] participants;
    
    public BreakoutRoom(String name){
        this.breakoutRoomID=String.valueOf(this.breakoutRoomNumberCounter);
        this.breakoutRoomNumberCounter++;
        this.breakoutRoomSize=10;
        this.participants = new Participant[breakoutRoomSize];
        this.numberOfParticipants=0; //initialize number of participants
        this.open = true; 
    }
    //constructor for the breakoutRoom class
    
    public String getbreakoutRoomID(){
        return breakoutRoomID;
    }
    //accessor for the breakoutRoomID attribute
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    //accessor for the numberOfParticipants attribute
    
    public boolean getOpen(){
        return open;
    }
    //accessor for the getOpen attribute
    
    public boolean addParticipant(String participantID){
        Participant p = new Participant(participantID);
        //creates new participant with a particular participant ID as given
        String pID = p.getParticipantID();
        //accessor method
        Boolean verify = p.verifyID(pID);
        //verify that the ID is valid
        if(this.numberOfParticipants == 10){
            System.out.println("The breakout room is filled....");
            return false;
            //participant cannot be added to the room
        }
        if((open==true) && (verify == true )){
            //System.out.println("Adding..");
            this.participants[numberOfParticipants]=p;
            this.numberOfParticipants+=1;
            return true;
            //participant added
        }
        
        return false;
        
    }
    //adds new participant with a valid ID to the breakout room if not filled
    
    public Participant findParticipant(String participantID){
        boolean found;
        Participant part; //new Participant(participantID);
        part = new Participant(participantID);
        
       found = part.verifyID(participantID); 
       //verify the ID of a participant object created
       if(found == true){
           int count;
           for(count=0;count<numberOfParticipants;count=count+1){
               if(this.participants[count].getParticipantID().equals(participantID)){
                   //if the participantID retrieved equals the supplied participantID
                   //return the participant data at that location in the array
                   return this.participants[count]; 
                }
            }
        }
        return null;
    }
    //locates and returns a participant based on supplied ID if present
    //in the breakout room
    
    public String listParticipants(){
        String list = " "; 
        //list = "Breakout room ID:" + " " + breakoutRoomID + "\n"; 
        list = list + "Participants List:" + "\n";
        //
        list = "BreakoutRoomID:" + " " + getbreakoutRoomID() + "\n";
        for(int count = 0; count < numberOfParticipants;count = count + 1){
            list = list +  this.participants[count].getParticipantID() + "\n";
            //use of getParticipantID accessor;
        }
        return list;    
    }
    //returns the list of the participants based on supplied ID
    //if present in the breakout room
    
    public String toString(){
       String details ="BreakoutRoom Number: " + " " + breakoutRoomID + "Open Status: ";
       if(getOpen() == true)
           details += "OPEN \n";
         else
             details += "CLOSE \n";
             
       details += "Number of Participants: " + " " + numberOfParticipants + "\n";
       return details;
    }
    //returns a string representation of the state of a breakout room
    
    public void closeBreakoutRoom(){
        /*
       this.open=false;
        for(int i=0;i<getNumberOfParticipants();i++){
            this.participants[i]=null;
        }
        this.numberOfParticipants=0;
        */
       this.participants=null;
       this.open=false;
       this.numberOfParticipants=0;
    }
    //closes the breakout room and clears the participant list
    //resets the relevant state of the breakout room
    
    public void openBreakoutRoom(){
         this.open = true;
    }
    //method to return if the room is opened
    
    /* Code to test break out room to ensure functionality of methods
    public static void main(String args[]){
        BreakoutRoom b1= new BreakoutRoom("TestRoom");
        Boolean added;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter ids...");
        String id = keyboard.nextLine();
        
        added=b1.addParticipant(id);
        id = keyboard.nextLine();
        added=b1.addParticipant(id);
        id = keyboard.nextLine();
        added=b1.addParticipant(id);
        
        System.out.println(b1.listParticipants());
        
        b1.closeBreakoutRoom();
        System.out.println(b1.toString());
    } */
}


