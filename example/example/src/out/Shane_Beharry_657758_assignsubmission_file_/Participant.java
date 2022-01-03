package out.Shane_Beharry_657758_assignsubmission_file_;//Shane Beharry
//816023033
public class Participant
{
    private String participantID;
    
    public Participant(String participantID){
        if(verifyID(participantID) == true){
            this.participantID = participantID;
        }
    }
    
    public static boolean verifyID(String participantID){
        int len = participantID.length();
        if(len!=8){
            return false;
        }
        
        for(int i=0; i<len; i++){
            if(!(participantID.charAt(i) >= '0' && participantID.charAt(i) <= '9')){
                return false;
            }
        }
        return true;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String temp;
        temp = "Participant: " + participantID;
        return temp;
    }
}