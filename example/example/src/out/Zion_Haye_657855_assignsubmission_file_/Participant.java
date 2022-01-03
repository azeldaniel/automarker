package out.Zion_Haye_657855_assignsubmission_file_;/*
 Student ID : 816020871
*/
public class Participant{
     
    private String participantID;
    
    public Participant(String participantID){
        
        this.participantID = participantID;
        
    }
    
    public static boolean verifyID (String participantID){
        
        int len;
        char ch;
        int num;
        
        len = participantID.length();
        
        if (participantID==null){
            return false;   
        }
        
        if(len == 8){
           
            for(int x = 0 ;  x < len ; x++){
             
                ch = participantID.charAt(x);// gets charaction from string
                num = participantID.charAt(x); //gets ASCII value
                num = num - 48;// gets integer value
                           
               if ( (num < 0) || (num >= 10) ){
                    return false;  
                }
            }
            
        }else{
            return false;   
        }
        
        return true;
    }
    
    public String getParticipantID(){
        
        return participantID;
    }
    
    public String toString(){
        
        String details;
        
        details = "Participant: " + participantID;
        
        return details;
    }
}