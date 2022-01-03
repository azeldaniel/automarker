package out.Brittney_Cupen_657790_assignsubmission_file_;// Brittney Cupen 816022438

public class Participant
{   
    private String participantID;
    
    public Participant(String participantID){
        if(verifyID(participantID)){
            this.participantID = participantID;
        }
        else{
            System.out.println("Invalid form of ID");
        }
            
    }
    
    public static boolean verifyID(String participantID){
        if(participantID.equals(null)  || participantID.length() != 8){
            return false;
        }
        for(int i=0; i<participantID.length(); i++){
            if(participantID.charAt(i) < '0' || participantID.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
    
    public String getParticipantID(){
        return this.participantID;
    }
    
    public String toString(){
        String part = "Participant: " + this.participantID;
        return part;
    }

}
