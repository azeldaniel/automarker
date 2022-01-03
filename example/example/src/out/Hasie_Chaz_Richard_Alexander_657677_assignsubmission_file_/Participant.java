package out.Hasie_Chaz_Richard_Alexander_657677_assignsubmission_file_;

 //ID: 816021429
 

public class Participant
{
   
    private String participantID;

   
    public Participant(String participantID)
    {
      
     this.participantID = participantID;
        
     
    }
    
    public static boolean verifyID (String participantID){
        
        
       if(participantID != null){
        
        int d = participantID.length(); 
        
        if(d == 8){
        
        return true;
        
        }
        
        else{
        
        return false;
        
        
        }
        
        
        
    }
    
    else{
    return false;
    }

    
     }
    
    public  String getParticipantID( ){
    
    return participantID;
    
    }
 
    
    public   String toString( ){
    
    String info;
   
    info = "Participant: " + participantID;
   
    return info;
    
    }


}