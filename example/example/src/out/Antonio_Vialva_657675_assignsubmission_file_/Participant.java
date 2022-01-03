package out.Antonio_Vialva_657675_assignsubmission_file_;/*
 816004121
 */
/**
 * Write a description of class Participant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant (String participantID)
    {
        this.participantID = participantID;
    }
    
    //Accessor to get the particiapantID
    public String getParticipantID(){
        return this.participantID;
    }
    
    //Converts the participantID to String
    public String toString(){
        String details = "Participant: " + participantID;
        return details;
    }
    
    //Verifies that the participantID is an 8 digit figure
    public boolean verifyID(String participantID)
    {
        int count = 0;
        if(this.participantID == null){
            return false;
        }
        else{
            if(this.participantID.length() == 8){
                return true;
            }
            else{
                return false;
            }
        }

    }
}
