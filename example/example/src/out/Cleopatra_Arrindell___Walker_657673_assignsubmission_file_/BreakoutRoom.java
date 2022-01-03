package out.Cleopatra_Arrindell___Walker_657673_assignsubmission_file_;
/**
 * @author (813001054)
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
  
  public BreakoutRoom(String name){
      breakoutRoomID = "100 ";
      breakoutRoomSize = 10;
      numberOfParticipants = 0;
      open = false;
      breakoutRoomNumberCounter = 0;
      participants = new Participant[numberOfParticipants];
      this.name = name;
    }
    
  public boolean addParticipant(String participantID){
      
         for(int i=0; i<breakoutRoomSize; i++){
             
          if(open == true && participantID.equals(true) ){
           
                if (!findParticipant(participantID).equals(participantID)) {
                  System.out.println("No participantID found");
               }else {
                  addParticipant(participantID); 
                  numberOfParticipants++;
                 return true;
              }               
            
            
            }
        }
            return false;
    }
  
   public Participant findParticipant(String participantID){
     
       for (int i=0; i<numberOfParticipants; i++) {
         participants = new Participant[i];
         if(participantID.equals(participants[i]) && getOpen()) {
             return participants[i];
        
        }
       }
        return null;
      } 
    

   public String listParticipants(){
        if(participants == null){
            return "There are no participants on the list";
        }else{
            
            return "Breakout room ID: " + getBreakoutRoomID() + "\n" ;
            
            
            
        
        }
         
   }
  
    public String toString(){
    
      if(!open){
          System.out.println("BreakoutRoom is closed ");
        }else{
            
            String details = "Virtual room: "+ this.name;
            details += "Breakout room is: "+ getBreakoutRoomID();
            details += "Breakout room is open: " + getOpen();
            details += "Participants: " + getNumberOfParticipants();
           

            return details;
        }
      return null;
    }
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants++;
    }
  
  public void closeBreakoutRoom(){
      String s = listParticipants();
        boolean state;
        state = !open;
        
       if(numberOfParticipants == 0){
         s = null;  
         state = !open;
         
        }else{
            state = getOpen();
        }

   }
   
   public boolean getOpen(){
       return open = true;
    }
   
  public void openBreakoutRoom(){
        boolean state;
        state =  getOpen();
       
        
            }
  
}
