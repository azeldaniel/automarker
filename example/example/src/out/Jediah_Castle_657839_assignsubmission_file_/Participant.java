package out.Jediah_Castle_657839_assignsubmission_file_; public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;
    
    public Participant(String participantID)
    {
        this.participantID = participantID;
    }

    public static boolean verifyID(String participantID){
        if(participantID != null && participantID.length() == 8){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String details = "Participant: " ;
        details += participantID;
        return details;
    }
  
      //Used for testing
     public static void  main(String[] args){ 
        System.out.println("  Participant  "); 
        Participant p1 = new Participant("12345678");
        System.out.println(p1.toString());
       
    } 
   
}