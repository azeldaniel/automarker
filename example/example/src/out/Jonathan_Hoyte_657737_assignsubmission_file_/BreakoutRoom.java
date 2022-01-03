package out.Jonathan_Hoyte_657737_assignsubmission_file_;
// 816013096
public class BreakoutRoom
{
    
    private int x;
    private String breakoutRoomID; 
    private int breakoutRoomNumberCounter=0;
    private int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants = 0;
    private boolean open = true;
 

    public BreakoutRoom(String name)
    { setName(name);
      participants = new Participant[breakoutRoomSize];
    }
    public void setName(String breakoutRoomID){
     this.breakoutRoomID +=breakoutRoomID;
    }
    
    public String getName (String breakoutRoomID){
     return breakoutRoomID;
    }
    
    public boolean getStatus(boolean open){ return open;}
    
    public boolean addParticipant(String participantID){
       if(numberOfParticipants == breakoutRoomSize -1){
        return false;
     }
     for(int h =0; h<breakoutRoomSize; h++){
        if(participantID == participants[h].getParticipant()){
        return false;
      }
     }
       
     if(participants[numberOfParticipants].verifyID(participantID)==false){ 
            return false;
      } else if(participants[numberOfParticipants].verifyID(participantID)==true)
      {
          participants[numberOfParticipants] = new Participant(participantID);
          numberOfParticipants++;
          return true;
      }
      return false;
    }
    
    public Participant findParticipant(String participantID){
      for(int h =0; h<numberOfParticipants; h++){
        if(participantID == participants[h].getParticipant()){
        return participants[h];
      }
     }
     return null;
    }
    
    public String listParticipants(){
        String listo="Participants of "+ breakoutRoomID + "\n";
        if(participants==null){return null;}
     for(int h =0; h<numberOfParticipants; h++){
         listo += participants[h].getParticipant();
         listo += h +"\n";
      }
      return listo;
     }
    
    
    public String toString(){
        String agg = "";
     if(open == false){
        agg = "Breakout Room: "+ breakoutRoomID + " is closed";
        return agg;
     } else if (open == true){
        agg = "Breakout Room " + breakoutRoomID + "\n" + "status: opened \n"
        + listParticipants();
        return agg;
     }
     return "N/A";
    }
    
    public void closeBreakoutRoom(){
     participants = null;
     breakoutRoomID=null;
     breakoutRoomSize = 0;
     numberOfParticipants=0;
     open = false;
    }
    
    public void openBreakoutRoom(){
    open = true;
    }
}
