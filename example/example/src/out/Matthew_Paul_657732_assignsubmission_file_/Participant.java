package out.Matthew_Paul_657732_assignsubmission_file_;
/**
 * Write a description of class Participant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

//Matthew Paul 816018640
public class Participant
{
    private String participantID;
    
    
    //constructor;
    public Participant(String participantID){
        if(verifyID(participantID)){
        this.participantID=participantID;
        }
        else{
            System.out.println("Invalid id");
        }
    }
    
    private boolean verifyID(String participantID){
        if(participantID.length()==8){
            return true;
        }
        else{
            return false;
        }
    }
    
    //accessor
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
     
        String details="Participant: "+ participantID;
        return details;
    }
}
