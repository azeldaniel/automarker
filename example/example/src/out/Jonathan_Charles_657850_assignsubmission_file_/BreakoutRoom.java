package out.Jonathan_Charles_657850_assignsubmission_file_;/*816020890*/

public class BreakoutRoom{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private static int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
   
  
    public BreakoutRoom(String name){
        this.breakoutRoomID = name;
        breakoutRoomNumberCounter = 1;
        breakoutRoomNumberCounter++;
        breakoutRoomSize = 10;
        Participant[] participants = new Participant[10];
        numberOfParticipants = 0;
        open = false;
        
        
        
        
        
        
    }
      public String getbreakoutRoomID(){
        return breakoutRoomID;
    }
    public int getbreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }
    public int getbreakoutRoomSize(){
        return breakoutRoomSize;
    }
    public int getnumberOfParticipants(){
        return numberOfParticipants;
    }
    public boolean getopen(){
        return open;
    }
    public boolean addParticipants(String ParticipantID){
        if(open!=false){
            participants[numberOfParticipants] = new Participant(ParticipantID); 
            numberOfParticipants++;
            return true;
        }return false;
    
    }
    public Participant findParticipant(String ParticipantID){
        if(open==true){
            for(int i=0;i<10;i++){
               if(participants[i].equals(ParticipantID)){
                   return participants[i];
                }
            }
        }return null;
    }
    public String listParticipants(){
         if(breakoutRoomID == null){
                return " Invalid ID";
            }else{
                breakoutRoomID = getbreakoutRoomID();
                return breakoutRoomID;
                
                
            }
    }
    public String toString(){
        return breakoutRoomID = breakoutRoomID + breakoutRoomNumberCounter;
    }
    public void closeBreakoutRoom(){
        breakoutRoomID = "close"+ breakoutRoomID;
        Participant [] participants = new Participant[10];
        open = false;
    }
    public void openBreakoutRoom(){
        breakoutRoomID = "open"+breakoutRoomID;
        open = true;
    }
}
