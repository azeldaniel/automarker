package out.Govinda_Ramcharan_657806_assignsubmission_file_;/**
 * @author Govinda Ramcharan 816003108
 * 
 */
public class Participant
{
    // instance variables
    private String participantID;

    // Constructor
    public Participant(String participantID)
    {
        this.participantID = participantID;
    }

    public static boolean verifyID(String participantID)
    {
        int getLen = participantID.length();
        for(int i = 0; i < 8; i++) {
            if(participantID.charAt(i) >= '0' && participantID.charAt(i) <= '9' && getLen == 8){
                //runs to completion, exits for loop and returns true
                //if conditions not met, returns false in the else statement
            }
            else{
                return false;
            }
        }

        return true;
    }

    //Getter
    public String getParticipantID()
    {
        return participantID; //returns the stored participantID

    }

    //Setter
    public void setID(String participantID)
    {
        this.participantID = participantID;
        //gives access to participantID variable
    }

    public String toString()
    { 
        return "Participant: " + participantID;
        //returns a string containing the contents of participantID
    }

}
