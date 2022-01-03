package out.Terrel_Charles_657846_assignsubmission_file_;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Participant{
   
    private String participantID;
    
    public Participant(String participantID){
    
        this.participantID=participantID;
    
    }
    
    
    
public static boolean verifyID(String participantID){
        if(participantID == null || participantID.length() != 8){
            
            return false;
        } else {
            for (int i = 0; i < 8; i++) {
                if(!Character.isDigit(participantID.charAt(i))){
                    
                    return false;
                }
            }
        }
        return true;
    }
    
    
    
    public String getParticipantID(){  
        //this is a method that returns the value of a variable of a class,it allows other classes to use this private method
    return this.participantID;
    
    
    
    }
    
    
    
   
   
    public String toString(){
    return "Participant: "+participantID;
    
    
    } 
    

}
