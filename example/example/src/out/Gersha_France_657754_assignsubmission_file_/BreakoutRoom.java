package out.Gersha_France_657754_assignsubmission_file_;
//816009767
public class BreakoutRoom
{
     private String breakoutRoomID;
     private int breakoutRoomNumberCounter;
     private int breakoutRoomSize;
     private Participant[] participant;
     private int numberOfParticipants;
     
     private String name;
     private int P;
     private boolean isopen;
     private static int PGenerator=1000;
     
     private boolean open;
     private Participant p;
     
     private String participantID;
     
    public BreakoutRoom(String name){
     this.name= name;
     P = PGenerator; 
      PGenerator++;
       
      numberOfParticipants=0;
      
    }

    
    public boolean addParticipant(String participantID)
    {
        String details =  " ";
       if(numberOfParticipants < 5){
           
           
            participant[numberOfParticipants] = p;
            
            details += participantID;
         numberOfParticipants += 1; 
      return true; 
    }
    
    return false;
     }
    
   public  Participant findParticipant(String participantID){
      return p ;
    }
    
   public String listParticipants(){
       if(numberOfParticipants == 0){
            return "no Participants ";
        }else{
            String details =  " ";
            for(int i = 0; i < numberOfParticipants; i++){
            details += participantID;
            
        }
        return details;
    }
   }
    
    
     public String toString(){
          String details =  "ParticipantID ";
         details += participantID;
         
         
       return details;
        }
        
    public void closeBreakoutRoom(){
        if (isopen == true)
                isopen = false;
    }
    
     public void openBreakoutRoom(){
        if (!isopen)
                isopen = true;  
           
    }
    
    
}
