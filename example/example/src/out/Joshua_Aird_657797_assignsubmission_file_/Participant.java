package out.Joshua_Aird_657797_assignsubmission_file_;

public class Participant
{
    
  
    private String participantID;
    public Participant(String participantID)
    {
       this.participantID=participantID;
    }

   
   public static boolean verifyID(String participantID){
       int length= participantID.length();
       if(length!=8){
         return false;   
    }
    else {
        return true;
    }
    }

    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String details= "Participant:" + participantID + " ";
        return details;
    }
}
