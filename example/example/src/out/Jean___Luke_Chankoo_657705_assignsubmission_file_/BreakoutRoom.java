package out.Jean___Luke_Chankoo_657705_assignsubmission_file_;//816006490
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BreakoutRoom
{
    private String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private int breakoutRoomSize=10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    
    //Custom accessors///////////
    public String getBreakoutRoomID(){
    return breakoutRoomID;
    }
    
    public int getNumberofParticipants(){
    return numberOfParticipants;
    }
    
    public boolean getOpen(){
    return open;
    }
    /////////////////////////////////
    //sets room to open or closed
    public boolean setOpen(){
        return true;
    }
    public boolean setClose(){
        return false;
    }
        
    
    public BreakoutRoom(String name)
    {
       breakoutRoomID=name;
    }

    public boolean addParticipant(String participantID){
    
    if(participants.length>=breakoutRoomSize){ //checks if room is filled
        return false;
    }
    else{   
        for(int i=0; i<participants.length; i++){
            if(participantID.equals(participants[i])){
               
                return true;
            }
    
        }
    }
    return false;
    }
    
    public Participant findParticipant(String participantID){
    
    boolean check=true;
    int numP= getNumberofParticipants();
    Participant p= new Participant(participantID);
    check=p.verifyID(participantID);    
   if(check==false){
    
    return null;
    }
   else{
    for(int i=0; i<numP;i++){
        if(participants[i].equals(participantID)){
            return p;
        }
    }
    return null;

    }

    }
    
    public String listParticipants(){
    
    String details;
    System.out.println(getBreakoutRoomID());
    //System.out.println(participants);
    details= Arrays.toString(participants);
    return details;
 
    }
    
    public String toString(){
        
    String details;
    String roomState;
    if(getOpen()==false){
        roomState="CLOSED";
    }
    else{
        roomState="OPEN";
    }
    details=(getBreakoutRoomID()+" "+roomState+" "+getNumberofParticipants());
    return details;
    }
    
    public void closeBreakoutRoom(){
        open=setClose();
        
        for(int i=0; i<participants.length;i++){
            participants[i]=null;
        }
    }
    
    public void openBreakoutRoom(){
    open=setOpen();
    }
  }
