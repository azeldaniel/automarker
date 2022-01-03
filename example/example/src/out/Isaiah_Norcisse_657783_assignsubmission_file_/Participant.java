package out.Isaiah_Norcisse_657783_assignsubmission_file_;// Student ID : 816016804
// COMP 2603 A1
import java.lang.String;

public class Participant
{
    private String participantID;
    
    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
        this.participantID=participantID;
    }
    
    public static boolean verifyID(String participantID)
    {
        if(participantID.length()==8)
            return true;
            
        return false;
    }
    
    public String getParticipantID()
    {
        return this.participantID;
    }
    
    public String toString()
    {        String details="Participant: "+ getParticipantID();
        return details;
    }
}
