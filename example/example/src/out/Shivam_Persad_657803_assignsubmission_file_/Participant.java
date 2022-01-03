package out.Shivam_Persad_657803_assignsubmission_file_;/** COMP2603 Assignment1
 *  Name: Shivam Persad
 *  ID: 816016854
 */
public class Participant
{
    private String participantID;

    //CONSTRUCTOR
    public Participant(String participantID)
    {
        this.participantID=participantID;
    }

    public static boolean verifyID(String participantID){
        if(participantID!=null && participantID.length()==8) return true;
        return false;
    }
    public String getParticipantID(){
        return participantID;
    }
    public String toString(){
        String data="Participant: " + this.getParticipantID();
        return data;
    }
}
