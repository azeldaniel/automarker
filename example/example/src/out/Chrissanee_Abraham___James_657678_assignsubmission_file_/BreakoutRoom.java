package out.Chrissanee_Abraham___James_657678_assignsubmission_file_;
/**
 Name:Chrissanee Abraham-James
 ID: 816000377
 Course: Object Oriented Programming
 Course Code: COMP 2603
 Assignment 1
 */
public class BreakoutRoom
{
    private String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private int breakoutRoomSize;
    private Participant[] participants = new Participant[10];
    private int numberOfParticipants=-1;
    private boolean open;
    
    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {int rid;
        
         this.breakoutRoomID = new String(name);
         rid=Integer.parseInt(breakoutRoomID.substring(breakoutRoomID.length() - 1));
         this.breakoutRoomNumberCounter = rid -1;
         this.breakoutRoomSize = 10;
         this.participants =  new Participant[10];
         numberOfParticipants += 1;         this.open = false;
         openBreakoutRoom( );//I chose to open the breakout room upon creation
        //System.out.println("\nBreakoutRoom ID: "+ breakoutRoomID +"\nBreakoutRoom Size: "+breakoutRoomSize +"\nParticipants: " +numberOfParticipants);
        
    }
    
    public boolean addParticipant( String participantID){
    //Adds a new participant (no duplicates) with a valid ID to the (open) breakout room if the room is not filled and then returns true, otherwise returns false
        Participant p = new Participant(participantID);
        if(!this.open){
            System.out.println("Room Closed. Participant not added:  "+participantID);
            return false;
        }
        if(findParticipant(participantID)!=null){
            System.out.println("Duplicate ID Found. Participant not added:  "+participantID);
            return false;
        }
        if(numberOfParticipants>=breakoutRoomSize){
            System.out.println("Room Full. Participant not added:  "+participantID);
            return false;
        }
        if(!p.verifyID(participantID)){
            System.out.println("Invalid ID Length. Participant not added:  "+participantID);
            return false;  
        }
        participants[numberOfParticipants] = new Participant(participantID);
        numberOfParticipants++;
        return true;
        
    }
        
    public Participant findParticipant( String participantID){
        //kind works -finds participants even when room is closed
        //Locates and returns a participant based on a supplied (valid) ID if present in the (open) breakout room, otherwise returns null.
                
        int i;
        String details ="";  
        String test ="";
        
        if(this.open){
            
            for(i=0;i<breakoutRoomSize;i++){
                if(participants[i]==null){
                    return null;
                }
                test= participants[i].toString();
                if(test.contains(participantID)){
                    //System.out.println(participants[i].toString());
                    return participants[i];
                    
                }
            }
        }
        return null;
    }
    
    public String listParticipants( ){ //WORKS
        //Returns a list of the participants names in the breakout room with the breakout room ID heading the list on a separate line
        String output = new String("");
        output = "\nBreakoutRoom Name: "+breakoutRoomID+"\tBreakoutRoom Index: "+breakoutRoomNumberCounter;
        int i= 0;
        if(!this.open){
            output = "\nBreakoutRoom "+ breakoutRoomID +" is closed. No Participants within room.\n";
            return output;
        }
        
        //null check not working not sure why
        if(participants[i]==null ){
            output = "\nBreakoutRoom "+ breakoutRoomID +" currently has no participants.\n";
            return output;
        }
        
        for(i=0;i<breakoutRoomSize;i++){
            if(participants[i]==null){
                break;
            }
            output += " "+participants[i].toString();
            }
        
        return output;
    }
    
    public String toString( ) {
        //Returns a String representation of the aggregated state of a BreakoutRoom
        String output = new String ("");
        output+= "\nBreakoutRoom ID:"+breakoutRoomID +" "+open;
        output+= "\nBreakoutRoom ID: "+breakoutRoomID;
        output+= "\nBreakoutRoom Number: "+breakoutRoomNumberCounter;
        output+= "\nBreakoutRoom Size: "+breakoutRoomSize;
        output+= "\nParticipant Count: "+numberOfParticipants;
        //System.out.println(output);
        return output;
    }
        
    public void closeBreakoutRoom( ){ //kinda works 
        //Closes the breakout room, clears the participant list and resets any relevant state of the breakout room
        int i;
         this.breakoutRoomSize = 0;
         this.participants =  null;
         numberOfParticipants =0;
         this.open = false;
    }
    
    public void openBreakoutRoom( ) { //kinda works
        //Opens the breakout room and sets the state as open
         this.open = true;
         this.breakoutRoomSize = 10;
         this.participants =  new Participant[10];
        
        }    
        
    public boolean getOpen(){
    //open accessor
        return this.open;
    }    
    
    public String getBreakoutRoomID(){
    //breakoutRoomID accessor
        return this.breakoutRoomID;
    }
       
    public int getNumberOfParticipants(){
    //breakoutRoomID accessor
        return this.numberOfParticipants;
    }
       
     
    
}