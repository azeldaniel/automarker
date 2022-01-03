package out.Marc_Mungal_657841_assignsubmission_file_;//816018788
/**
 * Write a description of class Paticipant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;
    
    public Participant(String participantID){
        this.participantID=participantID;
    }
    
    public boolean verifyID(String participantID){
        if(participantID.length()==8){
            return true;
        }
        return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        return "Participant: " + participantID;
    }
}
