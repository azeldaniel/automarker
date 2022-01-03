package out.Arun_Persaud_657699_assignsubmission_file_;//Arun Persaud 816019788
public class BreakoutRoom
{
    private String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name){
        breakoutRoomID = name;
        breakoutRoomNumberCounter = 0;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = true;
    }
    
    
    public boolean addParticipant(String participantID){
       Participant participant = new Participant(participantID);
       if(open = true && findParticipant(participantID) == null ){
           //if(numberOfParticipants < 10){
               participants[numberOfParticipants] = participant;
               numberOfParticipants += 1;
               return true;
           //}
       }
       return false;
    }
    
   
    public Participant findParticipant(String participantID){
        for(int i=0;i<numberOfParticipants;i++){
            if(participants[i].equals(participantID)){
                return participants[i];
            }else{
                return null;
            }
        }
        return null;
    }
    
    public String listParticipants(){
        String details = "";
        System.out.println(breakoutRoomID);
        
        for(int i=0; i < breakoutRoomSize;i++){
          details += participants[i];
        }
        return details;
    }
    
    public void closeBreakoutRoom(){
        for(int i=0;i<breakoutRoomSize;i++){
            participants[i]=null;
        }
        numberOfParticipants = 0;
        open = false;
    }
    
    public void openBreakoutRoom(){
        open = true;
    }
    
    
    public int getBreakoutRoomNumberCounter(){
       return breakoutRoomNumberCounter;
    }
    
    public int getBreakoutRoomSize(){
        return breakoutRoomSize;
    }
    
    public String getParticipants(int i){
        return participants[i].getParticipantID(); 
    }
    
    public int getBreakoutRoomID(){
        int x = Integer.parseInt(breakoutRoomID);
        return x;
    }
    
    
    public String getStringBreakoutRoomID(){
       return breakoutRoomID;
    }
    
}
