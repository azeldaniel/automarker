package out.Adiyah_Mohammed_657711_assignsubmission_file_;
/**
 816014197
 */
public class Participant
{
    private String participantID;
    
    public Participant(String participantID)
    {
        this.participantID = participantID;
    }
    
    public static  boolean verifyID(String participantID){
         int l2= 7;
         int l1 = participantID.length();
         if(participantID != " "){
             return false;
            }
          if  ( String.valueOf(l1).equals(String.valueOf(l2))){  
              return true;
        }
         return false;
    }

    public String getParticipantID( ){
        return participantID;
    }
    
    public String toString( ){
        return "Participant : " +getParticipantID( ) ;
    }
}
