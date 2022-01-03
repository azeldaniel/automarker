package out.Amelia_Lalla_657844_assignsubmission_file_;import java.util.Scanner;
/**
 * Write a description of class ParticipantClass here.
 *
 * @author Amelia Lalla 816021543
 * @version (a version number or a date)
 */
public class Participant
{
    private String participantID;

    public Participant (String participantID){
        boolean verified = false;
        verified = verifyID (participantID);
        if (verified == true){
            this.participantID = participantID;
        }
    }

    public static boolean verifyID (String participantID){
        int length = participantID.length();
        boolean digit=false;
        if (length == 8){
            for (int i=0; i<length; i++){
                digit = Character.isDigit(participantID.charAt(i));
                if (digit == false){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public String getParticipantID(){
        return this.participantID;
    }
    
    public String toString(){
        String line = "Participant: " + this.participantID;
        return line;
    }
}

