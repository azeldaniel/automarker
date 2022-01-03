package out.Amrutha_Ginkala_657811_assignsubmission_file_;/**
 *
 *816117625
 *
 */

/**
 * This class models a participant in the virtual meeting system.
 *
 * @author (Amrutha Ginkala (816117625))
 * @version (11/02/2021)
 */
public class Participant
{
 
    private String participantID;

    public Participant(String participantID) throws Exception {
        if (verifyID(participantID)) {
            this.participantID = participantID;
        } else {
            throw new Exception("Not valid participant ID");
        }
    }

    public static boolean verifyID(String participantID) {
        if (participantID != null) {
            if (participantID.length() == 8) {
                return true;
            }
        }
        return false;
    }

    public String getParticipantID() {
        return participantID;

    }

    @Override
    public String toString() {
        return "Participant: " + participantID;
    }

}
