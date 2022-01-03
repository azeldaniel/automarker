package out.Aaron_Payne_657799_assignsubmission_file_;import java.util.Arrays;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author Aaron Payne | ID: 816009846
 * @version 05/02/2021
 */
public class BreakoutRoom
{
    
    public String breakoutRoomID;
    static int breakoutRoomNumberCounter=0;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants=0;
    private boolean open=false;
    
    public BreakoutRoom (String name){
        breakoutRoomNumberCounter=+1;
        breakoutRoomID = name + String.valueOf(breakoutRoomNumberCounter);
    }
    
    public boolean addParticipant (String participantID){
        Participant p = new Participant(participantID);
        
        if (p.verifyID(participantID)==true){
            if (open==true){
                participants[numberOfParticipants]=p;
                numberOfParticipants=+1;
                return true;
            }
        }
        return false;
    }
    
    public Participant findParticipant (String participantID){
        Participant p = new Participant(participantID);
        for (int i=0; i<numberOfParticipants;i++){
            if (p==participants[i]){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String list = "";
        for (int i=0;1<numberOfParticipants;i++){
            list = list + participants[i].toString() + "\n";
        }
        return list;
    }
    
    public String toString(){
       String roomState;
       if (open==true){
           roomState="OPEN";
       }
       else roomState="CLOSED";

       return breakoutRoomID + " " + roomState + " " + numberOfParticipants;
    }
    
    public void closeBreakoutRoom(){
        numberOfParticipants=0;
        open=false;
        Arrays.fill(participants, null);
    }
    
    public void openBreakoutRoom(){
        open=true;
        Participant[] participants = new Participant[breakoutRoomSize];
       
    }
}
