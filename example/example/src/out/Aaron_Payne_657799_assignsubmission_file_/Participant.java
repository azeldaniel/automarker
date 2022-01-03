package out.Aaron_Payne_657799_assignsubmission_file_;
/**
 * The Participant class models a participant of a virtual meeting.
 *
 * @author Aaron Payne | ID: 816009846
 * @version 05/02/2021
 */
public class Participant{
    
    public String participantID;
    
    public Participant (String participantID){ }
    
    public boolean verifyID (String participantID){
        if (participantID.length()>8 || participantID==null)
             return false;
        return true;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        return "Participant: " + participantID;
    }
}
