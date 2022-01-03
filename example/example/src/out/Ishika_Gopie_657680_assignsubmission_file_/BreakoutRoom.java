package out.Ishika_Gopie_657680_assignsubmission_file_;
/**
 * StudentID: 816018253
 */
public class BreakoutRoom
{
   private String breakoutRoomID;
   private static int breakoutRoomNumberCounter = 0;
   private final int breakoutRoomSize;
   private Participant[] participants;
   private int numberOfParticipants = 0;
   private boolean open;
   
   
   public BreakoutRoom( String name){
       breakoutRoomNumberCounter++;
       this.breakoutRoomID = name + breakoutRoomNumberCounter;
       breakoutRoomSize = 10;
       participants = new Participant[10];
   }
   
   public boolean addParticipant(String participantID){
       if (Participant.verifyID(participantID) == false){
           return false;
       }
       if (numberOfParticipants < breakoutRoomSize){
           Participant participant = new Participant(participantID);
           participants[numberOfParticipants] = participant;
           numberOfParticipants++;
           return true;
        }
        else{
            return false;
        }
    }
   
    public Participant findParticipant(String participantID){
        if (Participant.verifyID(participantID) == false){
           return null;
       }
        for(int i = 0; i < numberOfParticipants; i++){
            if (participantID == participants[i].getParticipantID()){
                return participants[i];
            }
        }
        return null;
    }
    
    
    public String listParticipants(){
        int i;
        String s = "";
        s = s + breakoutRoomID + ": ";
        for(i = 0; i < numberOfParticipants; i++){
           s = s + participants[i].getParticipantID() + " ";
        }
        return s;
    }
    
    public String toString(){
        String s ="";
        s = s + breakoutRoomID + " ";
        if (open == true){
            s = s + "OPEN" + " ";
        }
        else{
            s = s + "ClOSE" + " ";
        }
        s = s + numberOfParticipants;
        return s;
    }
    
    public void closeBreakoutRoom(){
        open = false;
    }
    
    public void openBreakoutRoom(){
        open = true;
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
    
    public static int getbreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }
}