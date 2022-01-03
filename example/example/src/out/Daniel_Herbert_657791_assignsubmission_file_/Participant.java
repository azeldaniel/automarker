package out.Daniel_Herbert_657791_assignsubmission_file_;//816021155
public class Participant
{
    
    private String participantID;
    private static int length;
    
    public Participant()
    {
       
    }
    
    public Participant(String participantID)
    {
       this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        length = participantID.length();
        if(participantID != null && length == 8)
            return true;
        else
            return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        return "Participant: " + participantID;
    }
}
