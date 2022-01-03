package out.Amrutha_Ginkala_657811_assignsubmission_file_;/**
 *
 *816117625
 *
 */

import java.util.List;
import java.util.ArrayList;

/**
 * This class models a break out room in the virutal meeting system.
 * Participants are hosted in a breakout room. Participants are added 
 * if a room is open and has sufficient space for new participants. 
 *
 * @author (Amrutha Ginkala (816117625))
 * @version (11/02/2021)
 */
public class BreakoutRoom
{
 

    private String breakoutRoomID;

    private static int breakoutRoomNumberCounter = 1;

    private final int breakoutRoomSize = 10;

    private Participant[] participants;

    private int numberOfParticipants;

    private boolean open;

    public BreakoutRoom(String name) {
        this.participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        this.breakoutRoomID = name + breakoutRoomNumberCounter++;
    }

    public boolean addParticipant(String participantID) throws Exception {
        if (open) {
            if (findParticipant(participantID) == null) {
                if (numberOfParticipants < breakoutRoomSize) {
                    Participant participant = new Participant(participantID);
                    participants[numberOfParticipants] = participant;
                    numberOfParticipants++;
                    return true;
                } else {
                   return false;
                }
            } else {
                System.out.println("Participant already exist.");
            }
        } else {
            System.out.println("Room is not open");
        }
        numberOfParticipants = participants.length;
        return false;
    }

    public Participant findParticipant(String participantID) {
        for (Participant participant : participants) {
            if(participant != null)
                if (participant.getParticipantID().equals(participantID)) {
                    return participant;
                }
        }
        return null;
    }

    public String listParticipants() {
        StringBuilder list = new StringBuilder();
        list.append(breakoutRoomID + ": {");
        for (Participant participant : participants) {
            if(participant != null)
                list.append(participant.getParticipantID() + ",");
        }
        if (list.length() > 0) {
            list.deleteCharAt(list.length() - 1);
            return list.toString();
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        String isOpen = open ? "OPEN" : "CLOSE";
        list.append(breakoutRoomID + " " + isOpen);
        return list.toString();
    }

    public void closeBreakoutRoom() {
        open = false;
    }

    public void openBreakoutRoom() {
        open = true;
    }

    public static int getBreakoutRoomNumberCounter() {
        return breakoutRoomNumberCounter;
    }

    public static void resetBreakoutRoomNumberCounter() {
        BreakoutRoom.breakoutRoomNumberCounter = 1;
    }

    public String getBreakoutRoomID() {
        return breakoutRoomID;
    }

    public void setBreakoutRoomID(String breakoutRoomID) {
        this.breakoutRoomID = breakoutRoomID;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }


}
