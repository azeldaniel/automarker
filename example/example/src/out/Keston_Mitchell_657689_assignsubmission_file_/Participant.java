package out.Keston_Mitchell_657689_assignsubmission_file_;public class Participant
{
    private String participantID;

    public Participant(String participantID)
    {
        this.participantID = participantID;
    }

    public boolean verifyID(String participantID)
    {
        if(participantID.contains("[0-9]+") && (participantID.length() == 8)){
            return true;
        }
        else
            return false;
    }

    public String getParticipantID(){
        return this.participantID;
    }

    public String toString(){
        String output = "Participant: " + participantID;
        return output;
    }
}
