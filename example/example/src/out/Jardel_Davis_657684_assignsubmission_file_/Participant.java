package out.Jardel_Davis_657684_assignsubmission_file_;
//816017045
public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;

    
    public Participant(String participantID)
    {
        // initialise instance variables
        this.participantID = participantID;
    }

    
    public static boolean verifyID(String participantID)
    {
        // put your code here
        if(participantID.length() == 8){
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