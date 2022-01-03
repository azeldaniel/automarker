package out.Micah_Thomas_657795_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutRoom{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private int breakoutRoomNumberCounter = 0;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(){
        // initialise instance variables
        this.breakoutRoomID = breakoutRoomID;
        this.breakoutRoomNumberCounter +=1;
        this.breakoutRoomSize = 10;
        this.numberOfParticipants = 0;
        this.open = false;
        
    }
    
    private boolean addParticipant( String participantID){
        Participant[] participant = new Participant[50];
        for(int i=0; i<50; i++){
            if(participant[i].getParticipantID().equals(participantID) || open == false ||numberOfParticipants>=10){
                return false;
            }           
        }
        numberOfParticipants +=1;
        return true;        
    }
    
    private Participant findParticipant( String participantID){
        Participant[] participant = new Participant[50];
        for(int i=0; i<numberOfParticipants; i++){
            if(participant[i].verifyID(participantID) == true && open == true && addParticipant(participantID) == false){
                return participant[i];
            }           
        }
        return null;
    }
    
    private String listParticipants(){
        String list = breakoutRoomID;
        for(int i=0; i<numberOfParticipants; i++){
            list = list.concat(participants[i].getParticipantID());
        }
        return list;
    }
    
    public String toString(){
        String details ="Breakout Room: " + listParticipants() +"Breakout Room Size: " + breakoutRoomSize + "Number Of Participants: " + numberOfParticipants;
        return details;
    }
    
    public void closeBreakoutRoom(){
      if (open==true){
          open=false;
        }
    }
    
    public void openBreakoutRoom(){
      if (open==false){
          open=true;
        }
    }
    
    public String getbreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getnumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public int getbreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public String getListParticipants(){
        return listParticipants();
    }
    
    public boolean getAddParticipant(String participantID){
        return addParticipant(participantID);
    }
    
    public boolean getFindParticipant(String participantID){
        if (findParticipant(participantID)!= null){
            return true;
        }
        return false;
    }
}
