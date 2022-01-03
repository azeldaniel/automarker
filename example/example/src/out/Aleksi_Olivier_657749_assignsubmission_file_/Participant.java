package out.Aleksi_Olivier_657749_assignsubmission_file_;/**
 * Write a description of class Participant here.
 * All classes originally written in VS code
 * @author (ALEKSI OLIVIER 816023287)
 * @version (a version number or a date)
 */
public class Participant {
    private String participantID;

    //constructor
    public Participant(String participantID){
        this.participantID = participantID;
    }

    public static boolean verifyID(String participantID){
         // check lenght of id first
        if(participantID.length() == 8){
            return true;
        }
        return false;
    }

    public String getParticipantID(){
        return participantID;
    }

    public String toString(){
        return "Participant: " +participantID+ "\n";
    }


}



