package out.Michael_Joseph_657804_assignsubmission_file_;// 816009482- Michael Joseph


public class Participant{
    // instance variables - replace the example below with your own
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(){
        
    }

    public Participant(String participantsID){
    
    }
    
    public void getParticipantID(){
        participantID= this.participantID;
    }
    
    
    public boolean verifyID(String participantID){
       int x= participantID.length();
       
       if(x == 8){
           return true;
       }
       else{
           return false;
       }
       
    }
    
    public String toString(){
    String s= "";
    s+= "Participant: " + participantID;
    
    return s;
    }
}
