package out.Kyle_Ramkissoon_657751_assignsubmission_file_;//[816019715]
public class Participant{

    private String participantID;

    public Participant(String participantID){
    	this.participantID = participantID;
    }

    public static boolean verifyID(String participantID){
        if(participantID == null || participantID.length() != 8){

            System.out.println("ID format incorrect");
            return false;
        }

        	else {
            for (int i = 0; i < 8; i++) {
                if(!Character.isDigit(participantID.charAt(i))){
                    System.out.println("ID format incorrect");
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



}