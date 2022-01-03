package out.Daniel_Yorke_657808_assignsubmission_file_;/**
* 816019400
 */
public class Participant{
   String participantID;
   public Participant(String participantID){
       this.participantID=participantID;
    }
   public boolean verifyID(String participantID){
       if(this.participantID==null){
           return false;
       }
       for(int i = 0; i<participantID.length(); i++){
           if(participantID.charAt(i)<= '0' || participantID.charAt(i)>= '9'){
               return false;
           }
       }
       return true;
    }
   public String getParticipantID(){
       return participantID;
    }
   public String toString(){
       String format = "Participant: " + participantID;
       return format;
   }
}