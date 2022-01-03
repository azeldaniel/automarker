package out.Stephen_Scarlett_657837_assignsubmission_file_;import java.util.ArrayList;
import java.util.Arrays;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (Stephen Scarlett, 816013791)
 * @version (a version number or a date)
 */

public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        this.breakoutRoomID = name + breakoutRoomNumberCounter++;
        numberOfParticipants = 0;
        
        participants = new Participant[breakoutRoomSize];
        
        open = true; 
    }

    public boolean addParticipant(String participantID){
        if(numberOfParticipants < 10){
            Participant part = new Participant(participantID);
            if(part.verifiyID(participantID) == true){
               
               participants[numberOfParticipants] = part;
               
               numberOfParticipants++;
               return true;
            }
            else{
                return false;
            }
        }
        else{
            System.out.println("Room is Full");
            return false;
        }
    }
       
    public Participant findParticipant(String participantID){
        if(open == false){
            return null;
        }
        
        Participant part = new Participant(participantID);
        
        if(part.verifiyID(participantID) == false){
            return null;
        }
        
        for(int i=0; i<numberOfParticipants; i++){
            if(participantID.equals(participants[i].getParticipantID())){
                //System.out.println(participants[i]);
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String details = "BreakoutRoom: " + this.breakoutRoomID + "\n";
        
        for(int i=0; i<numberOfParticipants; i++){
            details += participants[i].toString() + "\n";
        }
        return details;
    }
    
    public String toString(){
        String status = "";  
        
        
        if(this.open == true){
            status = "OPEN";
        }
        else{
            status = "CLOSE";
        }
        return this.breakoutRoomID + " " + status;
    }
    
    public void closeBreakoutRoom(){
        if(open == true){
            open = false;
            for(int i=0; i<numberOfParticipants; i++){
                participants[i] = null;
            }
            numberOfParticipants = 0;
        }
    }
    
    public void openBreakoutRoom(){
        if(open == false){
            open = true;
        }
    }
    
    public int getCounter()
    {
        return breakoutRoomNumberCounter++;
    }

    public boolean getOpen()
    {
        return this.open;
    }
    
    public int getNumberOfParticipants()
    {
        return this.numberOfParticipants;
    }
    
    public String getBreakoutRoomID()
    {
        return this.breakoutRoomID;
    }
    
    
}
