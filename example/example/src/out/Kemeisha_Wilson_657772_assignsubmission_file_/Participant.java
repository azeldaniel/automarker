package out.Kemeisha_Wilson_657772_assignsubmission_file_;/**
 * @author (Kemeisha Wilson 816020815)
 * @version (08/02/2021)
 */
public class Participant
{
    private String participantID;
    private String details;
    public Participant(String participantID)
    {
        details=null;
        this.participantID=participantID;
    }
    
    public static boolean verifyID(String participantID)
    {
        if(participantID.length()==8)
            return true;
        return false;
    }
    
    public String getParticipantID(){return participantID;}
    
    public String toString()
    {
        details="Participant: "+participantID;
        return details;
    }
}
