package out.Danielle_Charles_657700_assignsubmission_file_;
/**
 * @author Danielle Charles 816017229
 */

import org.apache.commons.lang3.math.*;

public class Participant
{
    private String participantID;

    public Participant(String participantID)
    {
        this.participantID = participantID;
        
    }

    public static boolean verifyID(String participantID)
    {
        if(participantID.length() == 8 && participantID!= null && NumberUtils.isDigits(participantID))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String getParticipantID()
    {
     return participantID;   
    }
    
    public String toString()
    {
        return "Participant: " + this.participantID;
    }
    
    /*public static void main(String[] args)
    {
        Participant p = new Participant("12345678");
        System.out.println(p.toString());
        System.out.println(p.verifyID("12345678"));
        System.out.println(p.getParticipantID());
    }*/
}

