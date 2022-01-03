package out.Josie_Lewis_657720_assignsubmission_file_;
/**
 * Josie Lewis 816020986
 */

public class BreakoutRoom 
{
    public String breakoutRoomID;
    public int breakoutRoomNumberCounter;
    public int breakoutRoomSize;
    public Participant[] participants;
    public int numberOfParticipants;
    public boolean open;
    public Participant Obj;
    
    
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        breakoutRoomID = null;
        breakoutRoomNumberCounter=0;
        breakoutRoomSize=10;
        participants = new Participant[10];
        numberOfParticipants=0;
        open=true;
    }
    
   
    public boolean addParticipant(String participantID) {
        int i;
        String temp;;
        
        for (i=0; i<breakoutRoomSize; i++) {
            temp = "";
            temp += participants[i];
            if (participantID!=temp) {
               if (Obj.verifyID(participantID)) {
                return true;
                            
                }
            } 
             i++;
       }
       return false;
    }
    
    public Participant findParticipant(String participantID) {
        int i=0;
        String temp;
        while (i<breakoutRoomSize) {
            temp = "";
            temp += participants[i];
          if (Obj.verifyID(participantID)){
              if (participantID==temp){
                  return participants[i];
                }
            }
            i++;
        }
        return null;
    }
    
    public String listParticipants( ) {
        int i=0;
        String temp="";
        
        while (i<breakoutRoomSize) { 
            
            if (participants[i] != null){
                temp += participants[i] + " ";
            }
            i++;
        }               
          return temp;     
    }
    
    public String toString( ) {
        String print ="";
        print= breakoutRoomID + "OPEN" + listParticipants( );
        return print;
        
    }
    
    public void closeBreakoutRoom( ) {
        int i=0;
        while (i < breakoutRoomSize) {
            participants[i]=null;
        }
        
        open = false;
        
    }
    
    public void openBreakoutRoom( ) {
        open = true;
        
    }
}
