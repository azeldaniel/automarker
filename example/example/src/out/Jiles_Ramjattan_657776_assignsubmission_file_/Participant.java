package out.Jiles_Ramjattan_657776_assignsubmission_file_;
/**
 * Write a description of class Participants here.
 *
 * @author (Jiles Tony Ramjattan-816008647)
 * @version (V.1a)
 */
public class Participant {

    private String participantID;

    public Participant (String participantID){
        this.participantID =participantID;
    }

    public Boolean verifyID(String participantID){
        boolean test=false;
        for (int x=0; x<8; x++){
            if(participantID.charAt(x)>='0' && participantID.charAt(x)<='9'){
                test=true;
            }
            else{
                test=false;
            }
            if(!test){
                System.out.println("invalid id");
                return test;
            }
        }

        return true;
    }

    public String getParticipantID() {
        return participantID;
    }

    public String toString(){
        String val="Participant: "+participantID;

        return val;

    }

}