package out.Jordan_Douglas_657781_assignsubmission_file_;// Name: Jordan Douglas ID: 816022324
public class Participant
{
    private String participantID; 
    
     public Participant (String participantID){
         this.participantID= participantID;
    }
    public static boolean verifyID(String participantID){
        try{
        int n= participantID.length(); 
        
        
    
        if(n==8){
            return true;
        }
        else{
            return false;
        }
    }
        catch(Exception e ){
            System.out.println("Invalid data entered ");
            return false; 
        }
        
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
     public String toString(){
        return("Participant: " +participantID);
    }
    
}
