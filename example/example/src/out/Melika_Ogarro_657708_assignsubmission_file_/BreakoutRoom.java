package out.Melika_Ogarro_657708_assignsubmission_file_;
/**
 *
 * @authorID (816002233)
 * @version (13.02.2021)
 */
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomSize = 10;
        breakoutRoomNumberCounter++;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = false;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getBreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public boolean addParticipant(String participantID){
        
        if(Participant.verifyID(participantID)){
       
            if(numberOfParticipants < breakoutRoomSize){
                for(int i=0; i<numberOfParticipants; i++){
                    if(participants[i].getParticipantID().equals(participantID)){
                        System.out.println("Patient already exists");
                        return false;
                    }
                }
                participants[numberOfParticipants] = new Participant(participantID);
                numberOfParticipants++;
                return true;
            }   
            //System.out.println("Room is full");
            return false;
            
        }
        System.out.println("Invalid ID");
        return false;
        
    }
    
    public Participant findParticipant(String participantID){
        if(Participant.verifyID(participantID)){
            if(open){
                for(int i=0; i<numberOfParticipants; i++)
                    if(participants[i].getParticipantID().equals(participantID)){
                        return participants[i];
                    }
                return null;
            }
            System.out.println("Breakout Room is closed. \n");
        }
        else{
            System.out.println("Invalid ID");
        }
        return null;
    }
    
    public String listParticipants(){
        String list = breakoutRoomID + ":\n";
        for (int i=0; i<numberOfParticipants; i++){
            list += participants[i].getParticipantID() + "\n";
        }
        return list;
    }
    
    public String toString(){
        String state = getBreakoutRoomID();
        if (getOpen()){
            state+= " OPEN ";
        }
        else{
            state += " CLOSED ";
            state += getNumberOfParticipants();
        }
        return state;
    }
    
    public void closeBreakoutRoom(){
        if(getOpen()){
            open = false;
            for (int i=0; i < getNumberOfParticipants(); i++)
                participants[i]= null;
            numberOfParticipants = 0;
        }
    }
    
    public void openBreakoutRoom(){
        if(!getOpen()){
            open = true;
        }
    }
    
    public static void main (String[] args){
          
      }
   

}
