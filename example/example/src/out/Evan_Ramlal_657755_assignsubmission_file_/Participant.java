package out.Evan_Ramlal_657755_assignsubmission_file_;
/**
 * Evan Ramlal
 * 813117763
 */
public class Participant
{
    
    private final String participantID;

    /**
     * Constructor for objects of class Participant
     */
    public Participant(String participantID)
    {
        //        if (verifyID(participantID)){
        //            this.participantID = participantID;
        //        } else{
        //            this.participantID = null;
        //        }
        this.participantID = participantID;
    }
    
    public boolean verifyID(String participantID){
        if(participantID == null || participantID.length() != 8){
            System.out.println("ERROR: ID length is not 8");
            return false;
        } else {
            for (int i = 0; i < 8; i++) {
                if(!Character.isDigit(participantID.charAt(i))){
                    System.out.println("ERROR: non-numeric character detected");
                    return false;
                }
            }
        }
        return true;
    }
    
    public String getParticipantID(){
        return participantID; 
    }
    
    public String toString(){
        return "Participant: " + getParticipantID();
    }


    private static void tester(){
        Participant p1 = new Participant("12345678");
        System.out.println(p1.toString());
        System.out.println(p1.verifyID("12345678"));

        Participant p2 = new Participant("1");
        System.out.println(p2.toString());
        System.out.println(p2.verifyID("1"));

        Participant p3 = new Participant("abc");
        System.out.println(p3.toString());
        System.out.println(p3.verifyID("abc"));

        Participant p4 = new Participant("abc45678");
        System.out.println(p4.toString());
        System.out.println(p4.verifyID("abc45678"));
    }

    public static void main(String args[]){
//         tester();
    }


}        