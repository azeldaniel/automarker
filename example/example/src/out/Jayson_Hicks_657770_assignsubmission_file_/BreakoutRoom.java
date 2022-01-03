package out.Jayson_Hicks_657770_assignsubmission_file_;//Student ID:816000935

import java.util.*;
public class BreakoutRoom extends Participant
{
            // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize = 10;
    private Participant participants[]; 
    private int numberOfParticipants;
    private boolean open;
            
            
            
    BreakoutRoom(String name){
        breakoutRoomID = name;
        numberOfParticipants = 0;
        participants = new Participant[10]; 
                
    }
    BreakoutRoom(){
               
    }
    public Participant findParticipant(String participantID){
        if (open == true){
            for(int i=0; i<numberOfParticipants; i++){
                Participant pID = participants[i];
                if (Objects.equals(participantID,pID.getParticipantID())){ 
                    //was comparing different types of data so i needed to use this function
                    return pID;    
                }  
            }
            return null;
        }
        
        return null;    
    }        
    public boolean addParticipant(String participantID){
        if (numberOfParticipants>=10){
            return false;
        }else
        {   
            Participant found = findParticipant(participantID);
            if ((found==null)){
                participants[numberOfParticipants] = new Participant(participantID);
                numberOfParticipants+=1;
                return true;
            }
        }
        return false;
    }
        
    
    public String listParticipants() {
        String ids= "";
        for(int i=0; i<numberOfParticipants; i++){
            Participant pID = participants[i];
            ids += pID.getParticipantID()+", ";
        }
        return breakoutRoomID + "\n" + ids;
    }
    @Override
    public String toString(){
        
        return "RoomState =  "+ breakoutRoomID + open;//check aggratation not sure
    }
    
    public void closeBreakoutRoom(){
        open = false;
       
    }
    
    public void openBreakoutRoom(){
        open = true;
    }
    

}
