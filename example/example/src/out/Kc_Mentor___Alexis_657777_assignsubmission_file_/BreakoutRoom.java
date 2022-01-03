package out.Kc_Mentor___Alexis_657777_assignsubmission_file_;//816018833
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=1;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    private Participant p;
    
    public BreakoutRoom(String name){
        breakoutRoomSize = 10;
        numberOfParticipants = 0;
        participants = new Participant[breakoutRoomSize];
        open = false;
        this.breakoutRoomID = name + breakoutRoomNumberCounter++;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID; 
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants; 
    }
    
    public boolean getOpen(){
        return open; 
    }
   
    public boolean addParticipant(String participantID){
        
        p = new Participant(participantID);
        
        if(p.verifyID(participantID) && open == true && findParticipant(participantID) ==null){
           if(numberOfParticipants < breakoutRoomSize){
              participants[numberOfParticipants] = p;
              numberOfParticipants++;
              return true; 
           }
           return false;
        }
        return false;
    }
    
    public Participant findParticipant(String participantID){
       String temp;
       p = new Participant(participantID);
       if(open == true){
            if(p.verifyID(participantID)){
                for(int i=0; i < numberOfParticipants; i++){
                      temp = participants[i].getParticipantID();
                      if(temp.equals(participantID)){
                         return participants[i];
                      }
                }
            }
            return null;
       }
       return null;
       
    }
    
    public String listParticipants(){
       
       String heading = breakoutRoomID + "\n";
       String list = heading;
       
       for(int i=0; i < numberOfParticipants; i++){
           list = list + participants[i].toString() + "\n";
       }
       return list;
    }
    
   public String toString(){
        
        String list ="";
        list = list +  breakoutRoomID +" ";
        if(open == true){
            list = list + "OPEN ";
        }
        else{
            list = list + "CLOSE ";
        }
        list = list +  numberOfParticipants + "\n";
        
        return list;
    }
    
   public void closeBreakoutRoom(){
        
        open = false;
        participants[breakoutRoomNumberCounter] = null;
        numberOfParticipants =0;
        
   }
    
   public void openBreakoutRoom(){
      open = true; 
   }
}
