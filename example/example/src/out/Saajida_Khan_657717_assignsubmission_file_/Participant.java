package out.Saajida_Khan_657717_assignsubmission_file_;/**
 * @SaajidaAKhan_816013388
 */
public class Participant{
  private String participantID;

  public Participant(String participantID){
    this.participantID=participantID;
  }
  
  public static boolean verifyID(String participantID){
    if((participantID.length())==8)return true;
    return false;
  }
  
  public String getParticipantID(){return participantID;}
  
  public String toString(){
    return("Participant: "+getParticipantID());
  }
}