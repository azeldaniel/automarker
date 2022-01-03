package out.Karsten_Lange_657828_assignsubmission_file_;
//ID:816014018





import java.util.*;
public class BreakoutRoom{    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=0;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants =0;
    
    private boolean open;
    
    /*
    //BreakRoom Constructor that assumes that An open Breakout Room has to have at least 1 participant
    public BreakoutRoom(){
        breakoutRoomSize = 10;
        numberOfParticipants = 0;
        open = true;
        participants = new Participant[10];
        breakoutRoomNumberCounter++;
    }
    */
    
    //Constructor
    public BreakoutRoom(String breakoutRoomID){
        this.breakoutRoomID = breakoutRoomID + String.valueOf(breakoutRoomNumberCounter);
        breakoutRoomSize = 10;
        numberOfParticipants = 0;
        open = true;
        participants = new Participant[10];
        breakoutRoomNumberCounter++;
    }
    
    //Accessor for breakoutRoomID
    public String getBreakoutRoomID(){
        return breakoutRoomID;
        
    }
    
    //Accessor for numberOfParticipants
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    //Accessor for Open attribute
    public boolean getOpen() {
        return open;
    }
    
    public boolean addParticipant(String participantID){
        if((open == true) && (numberOfParticipants <= breakoutRoomSize)){
            for(int i=0; i<10; i++){
                if (participants[i] == null){
                    participants[i] = new Participant(participantID);
                    numberOfParticipants++;
                    return true;
                }
            
            
            }
            
            
        }
        return false;
    }
    
    
    public Participant findParticipant (String participantID){
        String temp;
        if(open == false){
            return null;
        }
        
        else{
            for(int i=0; i<numberOfParticipants; i++){
                temp = participants[i].getParticipantID();
                if(temp.compareTo(participantID) == 0){
                    return participants[i];
                }
                
            }
            
            
        }
        
        return null;
        
    }
    
    public String listParticipants(){
        String  list;
        
        list = breakoutRoomID;
        list += "\n";
        for(int i=0; i<numberOfParticipants; i++){
            if(participants[i] != null){
            list += participants[i].getParticipantID() + "\n";
            }
        }
        return list;
    }
    
    
    
    public void closeBreakoutRoom(){
        open = false;
        for(int i = 0; i<numberOfParticipants; i++){
            participants[i] = new Participant("");
        }
        
        breakoutRoomNumberCounter=0;
        numberOfParticipants=0;
        
    }
    
    
    public void openBreakoutRoom(){
        open = true;
    }
    
    public String toString(){
        String details = breakoutRoomID;
        if(open== false){
        details += " " + "CLOSED " + numberOfParticipants;
        return details;
        
        
        }
        else{
          
            details += " " + "OPEN " + numberOfParticipants;
            return details;
        }
    }
    
    
    
    
}