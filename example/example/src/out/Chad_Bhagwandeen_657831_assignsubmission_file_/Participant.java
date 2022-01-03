package out.Chad_Bhagwandeen_657831_assignsubmission_file_;//Student ID:816002273
import java.util.Scanner;

public class Participant
{
    private String participantID;
    public Participant(String participantID)
    {
        this.participantID=participantID;
    }
    
    public static boolean verifyID(String participantID)
    {
        
        if(participantID.equals(null))
        {
            return false;
        }
        int len=String.valueOf(participantID).length();
        if(len<8)
        {
            return false;
        }
        if(len>8)
        {
            return false;
        }
        return true;
        
        
    }
    public String getParticipantID()
    {
        return participantID;
    }
    public String toString()
    {
        return("Participant: "+participantID);
        
    }
    

}
