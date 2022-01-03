package out.Rajiv_Sadho_657769_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * Rajiv Sadho 816022655
 * 
 * Assorted Notes:
 *  1: I am assuming only one VirtualRoom may exist
 *  2: I set the maximum size of the array for storing file IDs to a reasonable maximum of 250. 
 *  3: listParticipants returns null only if the room is not found. If the room exists but has no participants then it 
 *     returns the string "Room ID: ID\nEmpty\n"
 *  4: Rooms IDs and Participant IDs are all printed on the same line
 *  
 *     
 *  
 */
public class VirtualMeetingSystem {
    private String[] dataArr;
    private VirtualRoom vRoom;
    private int arrMax,readCount, allocatedCount, maxAllocated;
    
    public VirtualMeetingSystem() {
        arrMax = 50;
        dataArr = new String[arrMax];
        readCount = 0;
        allocatedCount = 0;
        maxAllocated = 0;
    }
    
    // Adapted from the fine folks at w3school/Lecture 6 of COMP2603
    public void loadParticipantData(String filename) {
        try {
            File dataFile = new File(filename);
            Scanner dataReader = new Scanner(dataFile);
            readCount = 0;
            while(readCount < arrMax && dataReader.hasNextLine()) {
                dataArr[readCount] = dataReader.nextLine();
                readCount++;
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name) {
        vRoom = new VirtualRoom(name);
        vRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code) {
        if(vRoom == null) {
            return;
        }    
        int bRoomIndex = 0, bRoomMax = vRoom.getNumberOfBreakoutRooms();
        allocatedCount = 0;
        maxAllocated = vRoom.getNumberOfBreakoutRooms() * 10;
        try {
            if(code.equals("C5")) {
                for(int i = 0; i < readCount; i++) {
                    if(allocatedCount == maxAllocated)
                        break;
                    if(vRoom.addParticipantToBreakoutRoom(dataArr[i], bRoomIndex + 1))
                        allocatedCount++;
                    if((i + 1) % 5 == 0)
                    {
                        bRoomIndex++;
                    }
                    if(bRoomIndex == bRoomMax)
                        bRoomIndex = 0;
                }
            } else if(code.equals("RR")) {
                for(int i = 0; i < readCount; i++) {
                    if(allocatedCount == maxAllocated)
                        break;
                    if(vRoom.addParticipantToBreakoutRoom(dataArr[i], bRoomIndex + 1))
                        allocatedCount++;
                    bRoomIndex++;
                    if(bRoomIndex == bRoomMax)
                        bRoomIndex = 0;
                }            
            } else {
                throw new IllegalArgumentException("Code must be C5 or RR");
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
    }
    
    public boolean addParticipant (String participantID,int roomNumber) {
        if(vRoom == null)
            return false;          
        return vRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
    }
    
    public String listParticipants(int roomNumber) {
        if(vRoom == null)
            return null;         
        return vRoom.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber) {
        if(vRoom == null)
            return false;           
        return vRoom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber) {
        if(vRoom == null)
            return false;         
        return vRoom.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID) {
        if(vRoom == null)
            return null;        
        return vRoom.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms() {
        if(vRoom == null)
            return null;
        return vRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms() {
        String data = "";
        
        if(vRoom == null)
            return null;
            
        int numVRooms = vRoom.getNumberOfBreakoutRooms();
        
        if(numVRooms == 0)
            return null;
            
        for(int i = 1; i <= vRoom.getNumberOfBreakoutRooms(); i++) {
            data += vRoom.listParticipantsInBreakoutRoom(i);
        }
        
        // TODO: Ask if "participant_1 \n participant_2 \n ... participant_n" means 
        // return value cannot end in '\n' and adjust as required.
        data = data.substring(0, data.length() - 1);            
        return data;
    }
}
