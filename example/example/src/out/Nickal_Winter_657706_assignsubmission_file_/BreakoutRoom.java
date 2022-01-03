package out.Nickal_Winter_657706_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    final private int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    private static int roomnumber = 1;
    

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
       breakoutRoomID = name + roomnumber;
       roomnumber++;
       breakoutRoomNumberCounter = 0;
       numberOfParticipants = 0;
       
       open = false;
       participants = new Participant[breakoutRoomSize];
    }

    
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public boolean addParticipant (String participantID){
        if (numberOfParticipants < 10 && open == true){
            Participant p = new Participant(participantID);
        participants[numberOfParticipants] = p;
        
        numberOfParticipants++;
       
        return true;
    }
    
return false;
    }
    
    public String listParticipants (){
        String details = breakoutRoomID + " " + "\n";
            for(int i = 0;i < numberOfParticipants; i++){
                details += participants[i].toString() + " " + "\n";
                
            
        }
        return details;
    }

    public Participant findParticipant(String participantID){
        if (open == true){
        for (int i = 0;i < numberOfParticipants; i++){
            if (participants[i].getParticipantID().equals(participantID)){
                
                System.out.println("Participant "+participantID+" found in breakout room!" + "\n");
                return participants[i];
        }
        
    }
    
}
return null;
}


    public String toString(){
        String details = "RoomID:" + breakoutRoomID + " " + "\n";
        details += "StateOpen:" + open + " " + "\n";
        details += "NumberofParticipants: " + numberOfParticipants + "\n";
        return details;
    }
    
    
    
    public void closeBreakoutRoom(){
        if (open == true){
            open = false;
           
        }
    }
    
    public void openBreakoutRoom(){
        if (!open){
            open = true;
    }
    }
}

