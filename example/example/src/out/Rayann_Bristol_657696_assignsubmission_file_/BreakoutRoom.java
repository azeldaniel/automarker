package out.Rayann_Bristol_657696_assignsubmission_file_;
/**
 * Rayann Bristol
 * 816013958
 */
public class BreakoutRoom 
{
    private String breakoutRoomID;
    private String name;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    public BreakoutRoom(String name)
    {
        this.name = name;
        breakoutRoomID = getBreakoutRoomID();
        breakoutRoomNumberCounter++;
        breakoutRoomSize = 10;
        participants = new Participant[10] ;
        numberOfParticipants = numberOfParticipants;
        open = open;
    }
    
    public String getBreakoutRoomID()
    {
        for(int breakoutRoomNumberCounter = 0;breakoutRoomNumberCounter<5;breakoutRoomNumberCounter++){
            breakoutRoomID = name + breakoutRoomNumberCounter; 
        }
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants()
    {
        return numberOfParticipants;
    }
        
    
    public boolean getOpen()
    {
        if(open == true){
            open = true;
            return true; // open
        }else {
            return false; //closed
        }
    } 
    
    public boolean addParticipant(String participantID)
    {
        String i = participantID;
        int j = numberOfParticipants;
        if((i.length() == 8)&&(open == true)){    
            for(int k = 0; k<j;k++){
                if(participantID.equals(participants[k])){
                    return false;
                }else{
                    j++;
                    participants[j].getParticipantID();
                }
            
            }
            
        }
        return true;
    }
     
    
    public Participant findParticipant(String participantID)
    {
        String i = participantID;
        if((i.length() == 8) &&(open)){
            for(int k = 0;k<numberOfParticipants;k++){
                if(participants[k].getParticipantID().equals(i)){
                    return participants[k];
                }
            }
        }
            return null;
    }
    
    public String listParticipants()
    {
        if(participants == null){
          return "There are not participants in this breakout room.";
        }else{
          String details = " ";
          details += "Breakout Room: "+breakoutRoomID + "\n";
          details += participants.toString();
          
          return details;
        }
    }
    
    public String toString()
    {
        String details=" ";
        for(int i = 0;i<breakoutRoomNumberCounter;i++){
            
            details+= breakoutRoomID + " "+ open + " "+ numberOfParticipants;
        }
        return details;
    }
    
    public void closeBreakoutRoom(){
        for(int k = numberOfParticipants;k> 0;k--){
            participants[k] = participants[k+1];
            open = false;
        }
    }
    
    public void openBreakoutRoom(){
        open = true;
    }

}
