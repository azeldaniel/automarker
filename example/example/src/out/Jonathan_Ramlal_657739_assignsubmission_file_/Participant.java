package out.Jonathan_Ramlal_657739_assignsubmission_file_;
/**
 * Write a description of class VirtualMeeting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Participant{
  public String participantID;

      public Participant(String participantID){ //Constructor (Set participant ID)
       this.participantID=participantID;
      }
  
      private boolean verifyID(String participantID){ //True or false to verify ID
        if((participantID.length())==8)return true;
        return false;
      }
  
      public String getParticipantID(){ //Acquire Participant
          return participantID;
      }
  
      public String toString(){
        return("String: "+getParticipantID());
      }
}
