package out.Dexter_Cain_657793_assignsubmission_file_;/* The University of the West Indies St. Augustine Campus
    COMP2603 2021 S2
    Assignment1
    NAME: Dexter Cain
    ID: 816021817
    
    SUBMISSION #2
    
    PLEASE WATCH DEMO VIDEO: https://drive.google.com/file/d/17CVyw-Nj3GWwAEHrx-DkVL_CRC5LAxaN/view?usp=sharing
*/

public class VirtualRoom {
    // instance variables
    private String name; // The name of the virtual room
    private final int breakoutRoomLimit; // A constant that specifies the maximum number of breakout rooms allowed for
                                          // a virtual room
    private BreakoutRoom[] breakoutRooms; // A list of breakout rooms managed by the virtual room
    //private BreakoutRoom breakoutRoom = new BreakoutRoom(); // A breakout room object for invoking BreakoutRoom methods

    /**
     * Constructor for objects of class VirtualRoom Initialises the
     * breakoutRoomLimit to 5
     */
    public VirtualRoom(String name) {
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    // Overloaded constructor. Initialises the breakoutRoomLimit to the supplied
    // limit
    public VirtualRoom(String name, int limit) {
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];

    }

    // Returns the total number of breakout rooms managed by the virtual room
    public int getNumberOfBreakoutRooms() {
        return breakoutRoomLimit;
        //return breakoutRoom.getBreakoutRoomNumberCounter();
    }

    // Creates new BreakoutRoom objects that fill the list of breakout rooms
    public void createBreakoutRooms() {
        for (int i = 0; i < breakoutRoomLimit; i++) {
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }

    // Locates and returns the breakout room with the supplied room number,
    // otherwise returns null
    public BreakoutRoom findBreakoutRoom(int roomNumber) {
        // alternative technique: combine roomnumber with name and check
        for (int i = 0; i < breakoutRoomLimit; i++) {
            if (breakoutRooms[i].getBreakoutRoomNumber() == roomNumber) {
                return breakoutRooms[i];
            }
        }

        System.out.println("Unable to find breakout room because it doesn't exist.");
        
        return null;
    }

    // Closes a breakout room with the supplied room number if it exists
    public boolean closeBreakoutRoom(int roomNumber) {
        for (int i = 0; i < breakoutRoomLimit; i++) {

            if (breakoutRooms[i].getBreakoutRoomNumber() == roomNumber) {
                breakoutRooms[i].closeBreakoutRoom();
                return true;
            }
        }
        System.out.println("Unable to close breakout room or it doesn't exist.");
        
        return false;
    }

    // Opens a breakout room with the supplied room number if it exists
    public boolean openBreakoutRoom(int roomNumber) {
        for (int i = 0; i < breakoutRoomLimit; i++) {

            if (breakoutRooms[i].getBreakoutRoomNumber() == roomNumber) {
                breakoutRooms[i].openBreakoutRoom();
                return true;
            }
        }
        System.out.println("Unable to open breakout room or it doesn't exist.");
        
        return false;
    }

    // Returns a list of the breakout rooms managed by the virtual room with the
    // virtual room name heading the list on a separate line
    public String listBreakoutRooms() {
        String details = name + "\n";
        for (int i = 0; i < breakoutRoomLimit; i++) {
            details += breakoutRooms[i].toString() + "\n";
        }
        return details;
    }

    // Returns a list of the participants in the breakout room with the supplied
    // room number if found, otherwise returns null
    public String listParticipantsInBreakoutRoom(int roomNumber) {
        BreakoutRoom checkBreakoutRoom;
        checkBreakoutRoom = findBreakoutRoom(roomNumber);
        if (checkBreakoutRoom != null) {
            return checkBreakoutRoom.listParticipants();
        }
        return null;

    }

    // Adds a new participant to the breakout room with the supplied room number if
    // it exists
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber) {
        System.out
                .println("Attempting to add participant " + participantID + " to room number " + roomNumber + "...\n");
        BreakoutRoom roomLocation;

        roomLocation = findBreakoutRoom(roomNumber);
        if (roomLocation != null) {
            roomLocation.addParticipant(participantID);
            return true;
        }
        System.out.println("Failed to add participant to breakout room.");
        return false;
    }

    // Locates and returns the breakoutRoomID for the breakout room hosting the
    // participant with the (valid) supplied ID, otherwise returns null
    public String findParticipantBreakoutRoom(String participantID) {
        
        if ((participantID == null)) {
        //if ((participantID == null) || (breakoutRoom.verifyParticipantID(participantID) == false)) {
            System.out.println("Error...participantID is either missing or invalid.");

            return null;
        }

        for (int i = 0; i < getNumberOfBreakoutRooms(); i++) {

            if (breakoutRooms[i].findParticipant(participantID) != null) {
                System.out.println(participantID + " was found in " + breakoutRooms[i].getBreakoutRoomID());
                return breakoutRooms[i].getBreakoutRoomID();
            }

        }

        System.out.println(participantID + " was not found.");
        return null;
    }
}
