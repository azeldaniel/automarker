package out.Justin_Baldeosingh_657692_assignsubmission_file_;/* Justin Baldeosingh
 * 816021226
 * COMP 2603 - OOP
 * Assignment 1
 */

//Breakout Room Class.
public class BreakoutRoom{
    //Breakout Room Variables
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    
    
    //The BreakoutRoom constructor takes a breakout room name and creates and initializes the breakout room.
    public BreakoutRoom(String name){
        //Creats the breakoutroom ID by concatenating the name of the virtual room and the room count.
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
        //Allocates memory for 10 participant objects.
        this.participants = new Participant[breakoutRoomSize];
        //Increments the room counter.
        breakoutRoomNumberCounter += 1;
        //Opens the breakout room.
        openBreakoutRoom();
        //Sets the number ofparticipants in the breakout room to 0.
        this.numberOfParticipants = 0;
    }
    
    //Given a participant ID, adds that participant to the breakout room; if it is valid and not duplicate.
    public boolean addParticipant(String participantID){
        //If the breakout room is open, validate the ID and determine if the room has space, then add the participant.
        if(this.open == true){
            //Determines if the entered participant does not already exist in the breakout room.
            if(this.findParticipant(participantID) == null){
                //If the number of the participants in the room is less than the limit, and the ID is valid, add the participant ID.
                if(this.getNumberOfParticipants() < this.breakoutRoomSize && Participant.verifyID(participantID)){
                    //Adds the participant to the breakout room.
                    this.participants[numberOfParticipants] = new Participant(participantID);
                    this.numberOfParticipants++;
                    
                    //Returns true to indiciate that the operation was successful.
                    return true;
                }
            } else 
            //If the entered participant is already in the breakout room, inform the user.
                System.out.println("Entered ID is a duplicate!");
        }
        
        //Otherwise, return false if the participant could not be added.
        return false;
    }
    
    //Returns the participant object corresponding to a participant ID for a given breakout room.
    public Participant findParticipant(String participantID){
        //If the breakout room is open, and the passed ID is valid, find a match for the participant ID.
        if(this.open && Participant.verifyID(participantID)){
            //Iterates over the number of participants in the breakout room and returns the key participant.
            for(int i = 0; i < this.getNumberOfParticipants(); i++){
                //If the current iterating participant equals the passed ID, return that participant object.
                if(this.participants[i].getParticipantID().equals(participantID))
                    return this.participants[i];           
            }
        } 
        
        //Returns null of the breakout room is not open.
        return null;
    }
    
    //Returns a list of all the participants in the breakout room.
    public String listParticipants(){
        //Initializes the header of the participant list string.
        String participantsOfRoom = "BREAKOUT ROOM ID: " + this.getBreakoutRoomID() + "\n";
        
        //If the number of participants in the breakout room is not 0, print the participants details.
        if(this.numberOfParticipants > 0){
            //Iterates over the number of participants in the breakout room and prints their details.
            for(int i = 0; i < this.numberOfParticipants; i++)
                participantsOfRoom += this.participants[i].toString() + "\n";
        } else 
        //Otherwise no participants exist in the room.
            participantsOfRoom += "No participants in room!\n";
        
        //Returns the list of the participants in the room.
        return participantsOfRoom;
    }
    
    //Returns the status of the breakout room.
    public String toString(){
        String openStatus;
        
        //If the open status of the room is true, copy the "OPEN" string status to a status variable.
        if(getOpen()){
            openStatus = "OPEN";
        } else {
        //Otherwise, the room is closed and the "CLOSED" string status is copied to the status variable.
            openStatus = "CLOSED";
        } 
        
        //Returns the status of the breakout room.
        return this.getBreakoutRoomID() + " " + openStatus + " " + this.getNumberOfParticipants();
    }
    
    //Sets the breakout room's open status to false and resets the room.
    public void closeBreakoutRoom(){
        //Sets the open status of the room to false.
        this.open = false;
        //Resets the participants in the room and sets the number of participants to 0.
        this.participants = new Participant[breakoutRoomSize];
        this.numberOfParticipants = 0;
        
    }
    
    //Sets the breakout room's open status to true.
    public void openBreakoutRoom(){
        this.open = true;
    }
    
    //Gets and returns the breakout room ID.
    public String getBreakoutRoomID(){
        return this.breakoutRoomID;
    }
    
    //Gets and returns the number of participants in the breakout room.
    public int getNumberOfParticipants(){
        return this.numberOfParticipants;
    }
    
    //Gets and returns the status of the breakout room.
    public boolean getOpen(){
        return this.open;
    }
    
}
