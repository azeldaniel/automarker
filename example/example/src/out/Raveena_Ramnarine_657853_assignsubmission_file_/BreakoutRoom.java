package out.Raveena_Ramnarine_657853_assignsubmission_file_;
//816022556

/**
 * 
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private int numberOfParticipants;
    private boolean open;
    private  Participant[] participants;

   
    public BreakoutRoom (String name)
    {
        numberOfParticipants = 0;
        open=true;
        breakoutRoomSize=10;
        breakoutRoomID = name;
    }
    
    
    
    public boolean addParticipant(String participantID){
        if (Participant.verifyID(participantID) == true){
            while(breakoutRoomSize <= 10){
                numberOfParticipants++;
                return true;
            }       
    }
    return false;
    }
    
    public Participant findParticipant(String ParticipantID){
        for(int o=0; o<numberOfParticipants; o++)
        if(participants[o].getParticipantID().equals(ParticipantID)){
        return participants[o];
        }
        return null;
     
     }

    public String listParticipants(){
        String participantList= breakoutRoomID+ "/n";
        for(int o=1; o<=numberOfParticipants; o=o+1){
            participantList += participants[o].toString() + "/n";
        
    }
    return participantList;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParicipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public String toString(){
        String w="";
     if(open=true){
         w+=breakoutRoomID + "Open";
        }
        else{
        w+=breakoutRoomID + "close";
     }
     return w;
     }
    
    public void closeBreakoutRoom(){
        open=false;
        
    }
   
    public void openBreakoutRoom(){
        open = true;  
    }
   
    

        
}

//lecture notes,labs 
//Java Tutorial. https://www.w3schools.com/java/default.asp. 
    
    
    


