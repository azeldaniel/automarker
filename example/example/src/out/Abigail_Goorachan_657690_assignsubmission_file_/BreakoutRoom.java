package out.Abigail_Goorachan_657690_assignsubmission_file_;/**
 * 816007500
 */
import java.util.Random;

public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        Random r = new Random();
        breakoutRoomNumberCounter = r.nextInt(100);
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
        //breakoutRoomSize = 10;
        participants = new Participant[10];
        numberOfParticipants = 0;
        open = false;
    }
    
    public void openBreakoutRoom(){
        if(open == false){
            open = true; //breakout room is successfully opened
        }
    }
    
    public void closeBreakoutRoom(){
        if(open == true){
            open = false; //breakout room is successfully closed
        }
    }
    
    public boolean addParticipant(String participantID){
        openBreakoutRoom();
        while((numberOfParticipants < breakoutRoomSize) && (participantID.length() == 8)){
            for(int i=0; i<participants.length; i++){
                for(int j=i+1; j<participants.length; j++){
                    if(!participants[i].equals(participants[j])){
                        Participant p = new Participant(participantID);
                        participants[numberOfParticipants] = p;
                        numberOfParticipants++;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public Participant findParticipant(String participantID){
        while((open == true) && (participantID.length() == 8)){
            for(int i=0; i<participants.length; i++){
                if(participants[i].getParticipantID() == participantID){
                    return participants[i];
                } 
            }
        }
        return null;
    }
    
    public String listParticipants(){
        System.out.println("Breakout Room ID:" + breakoutRoomID + "\n");
        for(int i=0; i<participants.length; i++){
            return participants[i].toString();
        }
        return null;
    }
    
    public String toString(){
        String details = "";
        String state;
        if(open == true){
            state = "OPEN";
        }
        else{
            state = "CLOSED";
        }
        details += breakoutRoomID + " " + state;
        return details;
    }
    
    public int getBreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
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
}
