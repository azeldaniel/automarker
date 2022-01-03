package out.Amrutha_Ginkala_657811_assignsubmission_file_;/**
 *
 *816117625
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

/**
 * The methods in this class are involked by the VirtualRunner class.
 *
 * @author (Amrutha Ginkala (816117625))
 * @version (11/02/2021)
 */
public class VirtualMeetingSystem
{
 
    private VirtualRoom virtualRoom;

    private List<String> participantsList;

    public void loadParticipantData(String fileName) throws IOException {
        participantsList = new ArrayList<>();
        String filePath =  System.getProperty("user.dir") + "/" + fileName.trim();
        System.out.println(filePath);
        File file = new File(filePath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            participantsList.add(line.trim());
        }
        if (participantsList.size() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("Participant IDs:  ");
            for (String id : participantsList) {
                builder.append(id + ",");
            }
            builder.deleteCharAt(builder.length() - 1);
            System.out.println(builder.toString());
        }
        fr.close();
    }

    public void createVirtualRoom(String name) {
        virtualRoom = new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
    }

    public void allocateParticipants(String code) {
        if (code.contains("C")) {
            int clusterSize = Integer.parseInt(String.valueOf(code.charAt(1)));
            allocateInCluster(clusterSize);
        } else if (code.equals("RR")) {
            allocateInRoundRobin();
        }
    }

    private void allocateInCluster(int clusterSize) {
        virtualRoom.createBreakoutRooms();
        int breakOutRoomNumber = 1;
        int participantIndex = 1;
        for (String participant : participantsList) {
            try {
                if (participantIndex > clusterSize) {
                    participantIndex = 1;
                    breakOutRoomNumber++;
                }
                virtualRoom.openBreakoutRoom(breakOutRoomNumber);
                virtualRoom.addParticipantToBreakoutRoom(participant, breakOutRoomNumber);
                participantIndex++;
            } catch (Exception e) {
                System.out.println("Participant ID: " + participant + " Is not valid. Not Allocated.");
            }
        }
    }

    private void allocateInRoundRobin() {
        virtualRoom.createBreakoutRooms();
        float roomCounts = virtualRoom.getNumberOfBreakoutRooms();
        System.out.println("RR Allocations: ");
        int roomNumber = 1;
        for (String participant : participantsList) {
            if (roomNumber > roomCounts) {
                roomNumber = 1;
            }
            try {
                virtualRoom.openBreakoutRoom(roomNumber);
                virtualRoom.addParticipantToBreakoutRoom(participant, roomNumber);
                roomNumber++;
            } catch (Exception e) {
                System.out.println("Participant ID: " + participant + " Is not valid. Not Allocated.");
            }

        }
    }

    public boolean addParticipant(String participantID, int roomNumber) throws Exception {
        return virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
    }

    public String listParticipants(int roomNumber) {
        return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
    }

    public boolean openBreakoutRoom(int roomNumber) {
        return virtualRoom.openBreakoutRoom(roomNumber);
    }

    public boolean closeBreakoutRoom(int roomNumber) {
        return virtualRoom.closeBreakoutRoom(roomNumber);
    }

    public String findParticipantBreakoutRoom(String participantID) {
        return virtualRoom.findParticipantBreakoutRoom(participantID);

    }

    public String listAllBreakoutRooms() {
        
        
        StringBuilder list = new StringBuilder();
        list.append("Virtual Room name: " + virtualRoom.listBreakoutRooms());
        return list.toString();

    }

    public String listParticipantsInAllBreakoutRooms() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= virtualRoom.getNumberOfBreakoutRooms(); i++) {
            String participants = virtualRoom.listParticipantsInBreakoutRoom(i);
            if (participants != null) {
                builder.append(participants);
            }
            builder.append("}, ");
        }
        if (builder.length() > 1) {
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        } else {
            return null;
        }
    }

}
