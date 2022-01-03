package out.Derwin_Jack_657816_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (Derwin Jack 816022295)
 * @version (14/02/2021)
 */
public class BreakoutRoom
{
    private String breakoutroomID;
    private static int breakoutRoomNumberCounter = 0;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        this.breakoutroomID = name + breakoutRoomNumberCounter;
        this.breakoutRoomNumberCounter++;
        this.breakoutRoomSize = 10;
        this.participants = new Participant[breakoutRoomSize];
        this.numberOfParticipants = 0;
        this.open = true;
    }   
    
    public String getBreakoutRoomID(){
      return this.breakoutroomID;  
  }  
    
    public boolean addParticipant(String participantID){
         Participant a = new Participant(participantID);
         if(a.verifyID(participantID)){
            if(numberOfParticipants < breakoutRoomSize){
                this.participants[numberOfParticipants] = a;
                numberOfParticipants++;
                return true;
            }       
        }
        return false;
    }
    
    public Participant findParticipant(String participantID){
 
        for(int i = 0 ; i < numberOfParticipants; i++){
            if(participants[i].getParticipantID().equals(participantID )){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String BID = this.breakoutroomID;
        BID += "\n"; 
        for(int i = 0 ; i < numberOfParticipants; i++){
            BID += participants[i].toString() + "\n";
            
        }
        return BID;
    }
    
    public String toString(){
    String details = breakoutroomID+" ";
         if(open){
            details+="OPEN   ";   
         }else{
            details+="CLOSE   ";
         }
        details+= numberOfParticipants;
    return details;
    }
    
    
    public void closeBreakoutRoom(){
        if(open){
            participants = new Participant[breakoutRoomSize];
            numberOfParticipants = 0;
            this.open = false;
        }
    }
    
    
    public void openBreakoutRoom(){
        if(!open){
           this.open = true;  
        }
    }
    
}
