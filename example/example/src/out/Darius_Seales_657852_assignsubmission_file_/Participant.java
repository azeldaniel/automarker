package out.Darius_Seales_657852_assignsubmission_file_;
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
    public Participant(String participantID)
    {
        this.participantID = participantID;
    }
    public boolean verifyID(String participantID){
        if(participantID != null && participantID.length() == 8)
            return true;
        return false;
    }
    public String getParticipant(){
        return this.participantID;
    }
    public String toString(){
       return "Participant: " + participantID;
    }
   }
