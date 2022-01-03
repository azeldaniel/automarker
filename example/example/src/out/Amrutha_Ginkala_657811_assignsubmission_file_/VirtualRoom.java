package out.Amrutha_Ginkala_657811_assignsubmission_file_;/**
 *
 *816117625
 *
 */
import java.util.List;
import java.util.ArrayList;

/**
 * This class models a virtual room in the virtual meeting system. 
 * This virtual room creates and manages a certain number (5) of breakout rooms.
 *
 * @author (Amrutha Ginkala (816117625))
 * @version (11/02/2021)
 */
public class VirtualRoom
{
 

    private String name;

    private final int breakOutRoomLimit;

  
    private BreakoutRoom[] breakOutRooms = new BreakoutRoom[5];

    public VirtualRoom(String name) {
        this.name = "VirtualRoom";
        this.breakOutRoomLimit = 5;
    }

    public VirtualRoom(String name, int limit) {
        this.name = "VirtualRoom";
        this.breakOutRoomLimit = limit;
    }

    public int getNumberOfBreakoutRooms() {
        int breakOutRoomLimit = 5;
        return breakOutRoomLimit;
    }

    public void createBreakoutRooms() {
        int breakOutRoomLimit = 5;
        breakOutRooms = new BreakoutRoom[breakOutRoomLimit];
        BreakoutRoom.resetBreakoutRoomNumberCounter();
        for (int i = 0; i < breakOutRoomLimit; i++) {
            BreakoutRoom breakoutRoom = new BreakoutRoom(name);
            breakOutRooms[i] = breakoutRoom;
        }
    }

    public BreakoutRoom findBreakoutRoom(int roomNumber) {
        if (breakOutRooms.length >= roomNumber)
            return breakOutRooms[roomNumber - 1];
        else
            return null;
    }

    public boolean closeBreakoutRoom(int roomNumber) {
        if (breakOutRooms.length >= roomNumber) {
            breakOutRooms[roomNumber - 1].closeBreakoutRoom();
            return true;
        } else {
            return false;
        }
    }

    public boolean openBreakoutRoom(int roomNumber) {
        if (breakOutRooms.length >= roomNumber) {
            breakOutRooms[roomNumber - 1].openBreakoutRoom();
            return true;
        } else {
            return false;
        }
    }

    public String listBreakoutRooms() {
        StringBuilder list = new StringBuilder();
        list.append(name + "\nBreakoutRoom IDs: ");
        for (BreakoutRoom room : breakOutRooms) {
            list.append(room.getBreakoutRoomID() + ", ");
        }
        list.deleteCharAt(list.length() - 1);
        return list.toString();
    }

    public String listParticipantsInBreakoutRoom(int roomNumber) {
        if (breakOutRooms.length >= roomNumber) {
            BreakoutRoom room = breakOutRooms[roomNumber - 1];
            return room.listParticipants();
        } else {
            return null;
        }

    }

    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber) throws Exception {
        if (breakOutRooms.length >= roomNumber) {
            BreakoutRoom room = breakOutRooms[roomNumber - 1];
            return room.addParticipant(participantID);
        } else {
            return false;
        }
    }

    public String findParticipantBreakoutRoom(String participantID) {
        for (BreakoutRoom room : breakOutRooms) {
            if (room.findParticipant(participantID) != null) {
                return room.toString();
            }
        }
        return null;
    }


}
