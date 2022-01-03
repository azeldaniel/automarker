package out.Jared_Sandy_657733_assignsubmission_file_;// 816018721



public class BreakoutRoom{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private static final int breakoutRoomSize = 10;
    private Participant[] participants; 
    private int numberOfParticipants;
    private boolean open;
   
     
    public String getBreakoutRoomID(){
        return this.breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return this.numberOfParticipants;
    }
    
    public boolean isOpen(){
        if( this.numberOfParticipants >0){
            return true;
        }
        return false;
    }
    
    public BreakoutRoom(String name){
        breakoutRoomNumberCounter++;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = true;
    }
   
    public boolean addParticipant(String participantID){
        if(participantID == null) 
            return false;
        
        for(int i=0;i<numberOfParticipants;i++) {
             if (participants[i].getParticipantID().equals(participantID))
                return false;  
        }
            
        if ((numberOfParticipants < breakoutRoomSize) && (open == true)){
            participants[numberOfParticipants] = new Participant(participantID);
            numberOfParticipants++;
            return true;
        }else 
           return false;
     }
    
    public  Participant findParticipant( String participantID){
       for(int i =0; i<breakoutRoomSize;i++)
         if (participants[i].getParticipantID().equals(participantID))
           return participants[i];            
        return null;
    }
    
    public String listParticipants( ){
        String details="\tRoom I.D " + breakoutRoomID + "\n";
        details+="Participants :\n";
        for(int i =0; i<breakoutRoomSize;i++){
            details  +=participants[i] + " \n";
        }
        return details;
    }

    public String toString( ){
        String details;
        details ="\tRoom :" + breakoutRoomID + " :";
        if (open){
            details += "Open,";
            details += "Size :" + numberOfParticipants;
        }    
        else{
            details += "Room is Closed ";
        }    
        return details;
    }

    public void closeBreakoutRoom( ){
        for(int i =0; i<breakoutRoomSize;i++){
            participants[i] =null;
        }
        numberOfParticipants = 0;
        open = false;
    }

    public void openBreakoutRoom( ){
        open = true;
    }

   
   
}
