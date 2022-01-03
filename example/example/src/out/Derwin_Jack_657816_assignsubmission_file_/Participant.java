package out.Derwin_Jack_657816_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @author (Derwin Jack 816022295)
 * @version (14/02/2021)
 */
public class Participant
{
  private String participantID;
  
  public Participant(String participantID){
    this.participantID = participantID;
    }
    
  public boolean verifyID(String participantID){
    if(participantID.length() != 0 && participantID.length() ==8 ){
        return true;
    }
     return false;
    
  }
    
  public String getParticipantID(){
      return this.participantID;  
  }  
  
  public String toString(){
     String details = "Participant ID: "+participantID;
     return details;
  }
}
