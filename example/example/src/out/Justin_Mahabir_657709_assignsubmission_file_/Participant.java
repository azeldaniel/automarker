package out.Justin_Mahabir_657709_assignsubmission_file_;//ID: 816000496
/**
 * Write a description of class Participant here.
 *
 * @author Justin Mahabir
 * @version (a version number or a date)
 */
 import java.lang.*;
public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;
    
 public Participant(String participantID)
    {
    if(verifyID(participantID) == true){
            this.participantID = participantID;    
    }
 }
 public static boolean verifyID(String participantID)
    {
        boolean b1;
    if(participantID.length() != 8){
           return false;
    }
    else{
        for(int i = 0; i < participantID.length(); i++){
           b1 = Character.isDigit(participantID.charAt(i)); 
           if(b1 == false){
               return false;
               }    
           }
        return true;
        }
    }
 public String getParticipantID(){
     return this.participantID;
 }
 public String toString(){
     String pInfo;
     pInfo = "Participant: " + this.participantID;
     return pInfo;
 }
}