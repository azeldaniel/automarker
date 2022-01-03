package out.Rashad_Downes_657743_assignsubmission_file_;//
/**
 * ID#: 816015845
 *
 * @author (Rashad Downes)
 * @version (Thursday, February 11th, 2021)
 */

public class Participant{

    private String participantID;

    public Participant (String participantID){
        this.participantID = participantID;
    }

    public static boolean isNumber(String participantID){
        try{
            Integer.parseInt(participantID);
            return true;
        }
        catch(Exception E){
            return false;
        }
    }

    public static boolean verifyID(String participantID){
        if (isNumber(participantID) == true && participantID.length() == 8)
            return true;
        else 
            return false;
    }

    public String getParticipantID(){
        return participantID;
    }

    public String toString(){
        return "Participant: " + getParticipantID();
    }
}
