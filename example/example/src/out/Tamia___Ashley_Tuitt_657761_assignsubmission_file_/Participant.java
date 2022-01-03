package out.Tamia___Ashley_Tuitt_657761_assignsubmission_file_;/**
 * Student ID: 816021561
 */
public class Participant
{
    private String participantID;


    public Participant(String participantID)
    {
        this.participantID=participantID;
    }

    public static boolean verifyID(String participantID)
    {
        int count=0;
        for(int i=0; i<participantID.length(); i++){
        if(participantID.charAt(i)!=' ')
        count++;
        }
        
        if(count==8){
            return true;
        }
        return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String details="Participant: " + participantID;
        return details;
    }
}
