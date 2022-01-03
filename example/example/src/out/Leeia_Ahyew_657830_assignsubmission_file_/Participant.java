package out.Leeia_Ahyew_657830_assignsubmission_file_;//816016640
public class Participant
{
   
    private String participantID;

    public Participant(String participantID)
    {

        this.participantID= participantID;
    }
    
    public boolean verifyID(String participantID)
    {
        if( participantID.contains("[0-9]+") && (participantID.length() == 8 )){
            return true;
        }
        else
            return false;
    }
    
    public String getParticipantID(){
        return this.participantID;
    }
    
    public String toString(){
        String output = "Participant: "+participantID;
        return output;
    }
}

