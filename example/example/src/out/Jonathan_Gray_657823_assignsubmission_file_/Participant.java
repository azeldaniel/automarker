package out.Jonathan_Gray_657823_assignsubmission_file_;// StudentID: 816022996
// Student Name: Jonathan Gray

public class Participant{
    private String participantID;

    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    public static boolean verifyID(String participantID){
        if (participantID.equals(null)){
            return false;
        }
        
        try{
              int num = Integer.parseInt(participantID);
            }
            catch(Exception e){
              return false;
            }

        if(participantID.length() != 8) {
            return false;
        }
        
        return true;
    }

    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        return "ParticipantID: " + participantID;
    }
}