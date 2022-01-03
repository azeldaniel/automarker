package out.Maria_Cadogan_657849_assignsubmission_file_;//816013573

public class Participant{
    private String participantID;
    
    public Participant(){
        participantID = null;
    }
    
    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public static boolean verifyID(String participantID){
        
        if((participantID != null) && (participantID.length() == 8)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String toString(){
        String details = "Participant: " + getParticipantID();
        
        return details;
    }
    
    /*
    //Tests
    public static void main(String[] args){
        Participant p1 = new Participant("12345678");
        Participant p2 = new Participant("12345");
        Participant p3 = new Participant();
        
        //System.out.println("Constructor Test for initial states.");
        System.out.println("Participant ID: " + p1.participantID);
        boolean valid1 = verifyID(p1.participantID);
        System.out.println("Valid ID: " + valid1);
        System.out.println("\n");
        
        System.out.println("Participant ID: " + p2.participantID);
        boolean valid2 = verifyID(p2.participantID);
        System.out.println("Valid ID: " + valid2);
        System.out.println("\n");
        
        System.out.println("Participant ID: " + p3.participantID);
        boolean valid3 = verifyID(p3.participantID);
        System.out.println("Valid ID: " + valid3);
        System.out.println("\n");
        
        System.out.println("toString Method Test");
        System.out.println(p1.toString());
        
        
    }
    */
}