package out.Toni___Marie_Noel_657693_assignsubmission_file_;
/**
 * The Participant class modles a participant in the virtual
 * meeting system. 
 *
 * @ Toni-Marie Noel- 816017238
 * @ Jan 30, 2021
 */
public class Participant
{
    // instance variables - replace the example below with your own
    private String participantID;
    
    /**
     * Constructor for objects of class Participant
     */
    
     public Participant(String id)
    {
        participantID = id; 
    }

   // public static boolean verifyID()
    public static boolean verifyID(String participantID)
    {
        if(participantID!=null && participantID.length() == 8)
        return true; 
        
            else
            return false;
        
    }
    
    // accessor 
    public String getParticipantID(){
        return participantID; 
    }
    
    public static void println(Object line) {
    System.out.println(line);
    }
    
     public String toString(){
        String printParticipant ="participant_: "+ participantID;
        return printParticipant; 
    }
    
    // Testing 
    
    public static void main(String [] args){
        
        Participant perry = new Participant("12345678"); 
        
        if(perry.verifyID(perry.getParticipantID()))
        println("Verified");
        
        println(perry); 
       
      
    }
    
}
