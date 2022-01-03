package out.Kevin_Murphy_657729_assignsubmission_file_;/**
 * Kevin Murphy 
 * 816003734
 * 
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Participant{
    
     private String participantID;

   //Constructor 
    public Participant(String participantID){
        
        this.participantID = participantID;
        
    }//end function

    
    public boolean verifyID(String participantID){
        int participantLen = participantID.length();
        
        while(participantLen == 8){
            
            for(int i = 0; i < 8; i=i+1) {
                
                if(participantID.charAt(i) >= '0' && participantID.charAt(i) <= '9'){
                    
                }else{
                   return false;
                }//end else
            }//end for         
        }//end while
        return true;
    }//end function


    public String getParticipantID(){
        return participantID;
    }//end function
    
    
    public void setID(String participantID){  
        this.participantID = participantID;
    }//end function

    
    public String toString(){ 
        return participantID; 
    }//end function


}
