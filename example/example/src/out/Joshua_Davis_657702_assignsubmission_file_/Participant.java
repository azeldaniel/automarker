package out.Joshua_Davis_657702_assignsubmission_file_;/*
    Student ID: 816022176
*/


public class Participant {
    private final static int PARTICIPANT_ID_LENGTH = 8;

    private String participantID;

    public Participant(String participantID){
        this.participantID = participantID;
    }
    public static boolean verifyID(String participantID){
        if (participantID == null) return false;
        if (participantID.length() != PARTICIPANT_ID_LENGTH) return false;

        
        for (int i =0; i < participantID.length(); i++){
            if (! Character.isDigit(participantID.charAt(i))) return false;
        }

        return true;
    }

    public String getParticipantID(){
        return participantID;
    }
    public String toString(){
        return "Participant: " + participantID;
    }
}
