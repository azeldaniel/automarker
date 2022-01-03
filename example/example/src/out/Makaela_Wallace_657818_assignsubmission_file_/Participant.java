package out.Makaela_Wallace_657818_assignsubmission_file_;/*
 * Name: Makaela Wallace
 * ID: 816018659
*/

import java.util.*; 
import java.io.*;

public class Participant
{
    private String participantID;
    
    public Participant (String participantID){
        this.participantID = participantID;
    }
    
    public static boolean verifyID (String participantID){
        if ( participantID.length()==8 ){
            return true;
        }
        return false;
    }
    
    public String getParticipantID( ){
        return participantID;
    }
    
    public String toString(){
        String details = "Participant: " +participantID ;
        return details;
    }
    
}
