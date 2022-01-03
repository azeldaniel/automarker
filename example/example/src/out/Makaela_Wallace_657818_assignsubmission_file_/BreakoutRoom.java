package out.Makaela_Wallace_657818_assignsubmission_file_;/*
 * Name: Makaela Wallace
 * ID: 816018659
*/

import java.util.*; 
import java.io.*;

public class BreakoutRoom{
    
    private String breakoutRoomID="";
    private static int breakoutRoomNumberCounter=0;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom (String name){
        breakoutRoomNumberCounter = breakoutRoomNumberCounter +1;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = true;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen() {
        return open;
    }
    
    public int getBreakoutRoomNumberCounter () {
        return breakoutRoomNumberCounter;
    }
    
    public String getBreakoutRoomID () {
        return breakoutRoomID;
    }
    
    public boolean addParticipant( String participantID){
        
        if (numberOfParticipants == breakoutRoomSize){
            return false;
        }
        
        Participant p = new Participant(participantID);
        
        if (open==true){
            boolean verify = p.verifyID(participantID);
            
            if (verify==true){
                Participant test = new Participant(participantID);
                test = findParticipant (participantID);
                
                if (test==null){
                    
                    participants[numberOfParticipants]=p;
                    
                    numberOfParticipants++;
                } 
            }
        }
        
        if (numberOfParticipants == breakoutRoomSize){
            return false;
        }
        
        return true;
        
    }
    
    public Participant findParticipant (String participantID){
        
        Participant p = new Participant(participantID);
        boolean verify;
        
        verify = p.verifyID (participantID);
        
        p = null;
        
        for (int i = 0; i<numberOfParticipants; i++){
            if (participants[i].getParticipantID().equals(participantID)){
                p= participants[i];
            }
        }
        
        return p;
    }
    
    public boolean getParticipant (String participantID){
        Participant p = new Participant(null); 
        
        p = findParticipant (participantID);
        
        if (p==null){
            return false;
        }
        
        return true;
        
    }
    
    public String listParticipants (){
        
        String ids = "";
        
        for (int i = 0; i<numberOfParticipants; i++){
            ids = ids + participants[i].toString() +"\n";
        }
        
        String list = breakoutRoomID +"\n"+ ids;
        return list;
    }
    
    public String toString(){
        
        String status = "";
        
        if (open==true){
            status = "OPEN";
        }
        
        else if (open==false){
            status= "CLOSE";
        }
        
        String details = breakoutRoomID + " " +status+ " "+ numberOfParticipants;
        return details;
    }
    
    public void closeBreakoutRoom(){
        open=false;
        numberOfParticipants = 0;
        participants= null;
        //Arrays.fill(participants, null);
    }
    
    public void openBreakoutRoom (){
        open=true;
    }
    
    
}
