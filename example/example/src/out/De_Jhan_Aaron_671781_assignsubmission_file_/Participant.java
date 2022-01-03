package out.De_Jhan_Aaron_671781_assignsubmission_file_;public class Participant
{
    private String participantID;
    public Participant(String particioantID)
    {
        this.participantID = participantID;
    }

    public static boolean verifyID(String participantID)
    {
        boolean intCheck = true;
        int s = 0;
        int i = 0;
        if(participantID == null)
            return false;
        if(participantID.length() == 8)
        {
            while(i < 8)
            {
                s = 0;
                while(s<10 && intCheck == true)
                {
                    if(participantID.charAt(s) != s)
                        intCheck = false;
                    s += 1;
                }
                if(intCheck == false)
                    return false;
            }
            return true;
        }
        else
            return false;
        
    }
    
    public String getParticipantID()
    {
        return participantID;
    }
    
    public String toString()
    {
        return "Participant: "+participantID;
    }
}
