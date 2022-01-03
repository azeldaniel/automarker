package out.Alec_Sieupresad_657762_assignsubmission_file_;// Student ID: 816022470
/**
 * Write a description of class Participant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Participant{
    private String participantID;

    public Participant(String participantID) {
        this.participantID = participantID;
    }

    public boolean verifyID (String participantID){
        int lowerlim = 10000000;
        int upperlim = 99999999;
        int ID = Integer.parseInt(participantID);
        if ((ID < upperlim) && (ID > lowerlim)){
           return true; 
        }else{
            return false;
           }   
    }
    
    public String getParticipantID(){
        return this.participantID;
    }
    
    public String toString(){
        String details = "Participant ID: " + participantID; 
        return details;
    }
}
