package out.Dexter_Cain_657793_assignsubmission_file_;/* The University of the West Indies St. Augustine Campus
COMP2603 2021 S2
Assignment1
NAME: Dexter Cain
ID: 816021817

SUBMISSION #2

PLEASE WATCH DEMO VIDEO: https://drive.google.com/file/d/17CVyw-Nj3GWwAEHrx-DkVL_CRC5LAxaN/view?usp=sharing
 */

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class VirtualMeetingSystem {
    private final int arrSize = 50;
    
    private String[] participantList = new String[arrSize];
    private int f = 0; // instance variable for array index
    VirtualRoom virtualRoom; // declare VirtualRoom object

    public VirtualMeetingSystem() {
    }

    // Read data from a file and loads the data into an array for allocation to
    // breakout rooms
    public void loadParticipantData(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                participantList[f] = scanner.nextLine();
                f++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred has occurred.");
            e.printStackTrace();
        }

        System.out.println("\t-> Data read from " + filename + " successfully.");
    }

    // Creates a virtual room with the supplied name, containing 5 breakout rooms
    public void createVirtualRoom(String name) {
        virtualRoom = new VirtualRoom(name);
        System.out.println("Virtual room (" + name + ") created successfully.");
        virtualRoom.createBreakoutRooms();
    }

    // Allocates participants to the breakout rooms of a virtual room using a
    // strategy determined by the supplied code
    public void allocateParticipants(String code) {
        int clusterSize = 0;
        int roomNumber = 1;
        int numberOfBreakoutRooms = virtualRoom.getNumberOfBreakoutRooms();
        f = 0;
        int counter = 0;

        if (code.equals("C5")) {
            //while (participantList[f] != null) {
            while (counter < arrSize) {
                if (clusterSize == 5) {
                    clusterSize = 0;
                    roomNumber++;
                }

                // this condition exhausts the list of participants
                if (roomNumber > numberOfBreakoutRooms)
                    roomNumber = 1;

                virtualRoom.addParticipantToBreakoutRoom(participantList[f], roomNumber);

                f++;
                clusterSize++;
                counter++;
            }
        } else if (code.equals("RR")) {
            //while (participantList[f] != null) {
            while (counter < arrSize) {
                virtualRoom.addParticipantToBreakoutRoom(participantList[f], roomNumber);

                if (roomNumber == numberOfBreakoutRooms) {
                    roomNumber = 1;
                } else {
                    roomNumber++;
                }

                f++;
                counter++;
            }

        } else {
            System.out.println("Error...allocation code supplied is either null or invalid.");
        }

    }

    // Adds a new participant to the breakout room with the supplied room number if
    // it exists
    public boolean addParticipant(String participantID, int roomNumber) {
        if (virtualRoom.findBreakoutRoom(roomNumber) != null) {
            virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
            return true;

        }
        return false;

    }

    // Returns a list of the participants in the breakout room with the supplied
    // room number if found, otherwise returns null
    public String listParticipants(int roomNumber) {
        if (virtualRoom.findBreakoutRoom(roomNumber) != null) {
            System.out.println("List of participants in " + virtualRoom.findBreakoutRoom(roomNumber).getBreakoutRoomID() + "\n");

            return virtualRoom.findBreakoutRoom(roomNumber).listParticipants();

        }
        return null;
    }

    // Opens a breakout room with the supplied room number if it exists
    public boolean openBreakoutRoom(int roomNumber) {
        if (virtualRoom.findBreakoutRoom(roomNumber) != null) {
            return virtualRoom.openBreakoutRoom(roomNumber);
        }

        return false;
    }

    // Closes a breakout room with the supplied room number if it exists
    public boolean closeBreakoutRoom(int roomNumber) {
        if (virtualRoom.findBreakoutRoom(roomNumber) != null) {
            return virtualRoom.closeBreakoutRoom(roomNumber);
        }
        return false;
    }

    // Locates and returns the breakoutRoomID for the breakout room hosting the
    // participant with the (valid) supplied ID, otherwise returns null
    public String findParticipantBreakoutRoom(String participantID) {
        if (participantID == null)
            return null;

        return virtualRoom.findParticipantBreakoutRoom(participantID);

    }

    // Returns a list of the breakout rooms managed by the virtual room
    public String listAllBreakoutRooms() {
        String details = "";
        details += virtualRoom.listBreakoutRooms();
        return details;
    }

    // Returns a list of all of the participants per breakout room managed by the
    // virtual room, otherwise returns null
    public String listParticipantsInAllBreakoutRooms() {
        String details = "";
        details += "List of all participants per breakout room:\n\n";
        for (int i = 1; i <= virtualRoom.getNumberOfBreakoutRooms(); i++) {
            details += virtualRoom.listParticipantsInBreakoutRoom(i) + "\n";
        }

        return details;
    }

}
/*
 * REFERENCES https://www.w3schools.com/java/java_files_read.asp
 * 
 * 
 */
