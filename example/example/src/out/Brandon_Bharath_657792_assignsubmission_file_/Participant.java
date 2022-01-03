package out.Brandon_Bharath_657792_assignsubmission_file_;//816020909 Brandon Bharath
public class Participant
{
  private String participantID;
   
  public Participant(String participantID)
  {
       this.participantID = participantID;
  }
   
  public static boolean verifyID(String participantID)
  {
      if (participantID != null)
      {
           int checker = participantID.length();
           if (checker == 8)
           {
               return true;
           }
      }
      return false;
  }
  
  public String getParticipantID()
  {
      return this.participantID;
  }
  
  public String toString()
  {
      String details = "Participant: " + this.participantID;
      return details;
  }
}