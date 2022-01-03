package out.Warren_Shanghie_657782_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @author (Warren Shanghie - 816020039)
 * @version (8/2/2021)
 */
public class Participant
{
  private String participantID; 
 
  //constructor;
  public Participant(String participantID)
  {
        this.participantID = participantID;
  }
    
  //method or behavior:
  
  public boolean verifyID(String participantID){
      if((participantID.length() != 8) && participantID.contains("[0-9]+")){
       return false; 
      }else{
      return true;
      }
  }
  
  
  public String getParticipantID(){
      return participantID; 
  }
  
  public String toString(){
      String details = "ParticipantID: " +participantID;
      return details; 
  }
}
