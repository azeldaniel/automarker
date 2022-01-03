package out.Deepak_Ramsubhag_657786_assignsubmission_file_;
/**
 Deepak Ramsubhag
 816016482
 */

public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=0;
    private final int breakoutRoomSize=10;
    private Participant[] participants;
    private int numberOfParticipants=0;
    private boolean open = true;
    
    public BreakoutRoom(String name){
        breakoutRoomNumberCounter++; 
        breakoutRoomID = name + Integer.toString(breakoutRoomNumberCounter);
        participants = new Participant[10];
    }
    
    public boolean addParticipant(String participantID){   
        Participant x = new Participant(participantID);
        
        if(x.verifyID(participantID)==false || numberOfParticipants >= breakoutRoomSize || open==false){
            return false;
        }
        
        participants[numberOfParticipants]=x;
        numberOfParticipants++;
        
        return true;
    }
    
    public Participant findParticipant (String participantID){
        for(int i=0; i<numberOfParticipants; i++){
            if((participants[i].getParticipantID()).equals(participantID)){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String details = breakoutRoomID;
        
        if(numberOfParticipants == 0){
            return details;
        }
        
        else{
            for(int i=0;i<numberOfParticipants;i++){
                details += "\n" + participants[i].getParticipantID();
            }
            return details;
        }
    }
    
    public String toString(){ 
        String details=breakoutRoomID + " ";
        if(open==true){
            details += "OPEN ";
        }  
        else{
            details += "CLOSE ";
        }    
        details += numberOfParticipants;
        
        return details;
    }
    
    public void closeBreakoutRoom(){
        open=false;
        numberOfParticipants=0;
        participants = new Participant[50];
    }
    
    public void openBreakoutRoom(){
        open=true;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public boolean getOpen(){
        if(open==true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    
    
    
}