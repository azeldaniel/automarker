package out.Warren_Shanghie_657782_assignsubmission_file_;import java.util.Random;
/**
 * Write a description of class Participant here.
 *
 * @author (Warren Shanghie - 816020039)
 * @version (8/2/2021)
 */
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=0;
    private int breakoutRoomSize;
    private int numberOfParticipants;
    private boolean open;
    private Participant[] participants;
  
  public BreakoutRoom(String name)
  {
        Random random = new Random();
        this.breakoutRoomNumberCounter++;
        this.breakoutRoomID = name + breakoutRoomNumberCounter;
        this.breakoutRoomSize = 10; 
        this.numberOfParticipants = 0;
        this.open = true; 
        this.participants = new Participant[breakoutRoomSize]; 
  }
  
  //method or behavior:
  public boolean addParticipant(String participantID){
      
     Participant p = new Participant(participantID);
     
     if(p.verifyID(participantID) && open){
         if(numberOfParticipants < breakoutRoomSize){
             participants[numberOfParticipants] = p;
             numberOfParticipants++;
             return true;
            }
        }  
     return false;
   }
   
    
  public Participant findParticipant(String participantID){
      
      Participant p = new Participant(participantID);
      
      for(int i=0; i<numberOfParticipants; i++){
          if((participants[i].getParticipantID()).equals(participantID)){
              return participants[i]; 
           }
      }   
      return null;   
   }
  
  
  public String listParticipants(){
      String detail= ""; 
      detail += breakoutRoomID + "\n";
     for(int i=0;i<numberOfParticipants; i++){
         detail += participants[i].toString(); 
         detail += "\n"; 
     }
     return detail;
  }
  
  public String toString(){
     String details = breakoutRoomID; 
     if(open){
         details +=" OPEN "; 
        }else{
         details += "CLOSE ";    
        }
     details += numberOfParticipants;  
     return details; 
  }
   
  public void closeBreakoutRoom(){
      this.open = false;
      participants = new Participant[breakoutRoomSize]; 
      numberOfParticipants = 0;
  }
   
  public void openBreakoutRoom(){
      this.open =  true;
  }
  
  //accessor 
  public String getBreakoutRoomID(){
   return breakoutRoomID;   
   }
   
  public boolean getOpen(){
     return this.open; 
    }
  
}
