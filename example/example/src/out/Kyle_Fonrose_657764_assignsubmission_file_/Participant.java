package out.Kyle_Fonrose_657764_assignsubmission_file_;//NAME: KYLE E. FONROSE
//ID: 816002546
//TITLE: ASSIGNMENT 1

public class Participant{
    // instance variables
     private String participantID;

   //Constructor 
    public Participant(String participantID){
        // initialise instance variables
        this.participantID = participantID;
    }

    public static boolean verifyID(String participantID){
      int len = participantID.length();
       if(len == 8){
         for(int i = 0; i < 8; i++) {
           if(participantID.charAt(i) >= '0' && participantID.charAt(i) <= '9'){
                //System.out.println("TEST");
               }
           else{
                //System.out.println("FALSE");
                return false;
           }
         }         
       }
       else{
            return false;
       }
        
     return true;
    }


    public String toString(){ 
      return "Participant: " + participantID; 
    }
    
    public String getParticipantID(){
      return participantID;
    }
    
    public void setParticipantID(String participantID){
      this.participantID = participantID;
    }


}
