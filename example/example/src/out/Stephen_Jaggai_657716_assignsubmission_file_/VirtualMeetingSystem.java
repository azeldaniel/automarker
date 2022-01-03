package out.Stephen_Jaggai_657716_assignsubmission_file_;// 816019082

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem {
    private VirtualRoom virtualRoom;
    String [] participantID = new String [100];
    int roomNumber;
    
    public void loadParticipantData(String filename ) {
        try {
        File file = new File(filename);
        Scanner dataFile = new Scanner(file);
        int i=0;
            while (dataFile.hasNextLine()) {
                participantID[i] = dataFile.nextLine();
                i++;
            }
        dataFile.close();
        } catch (FileNotFoundException e) {
        System.out.println("File not found.");
        e.printStackTrace();
        }
    }
    
    public void createVirtualRoom (String name) {
        VirtualRoom virtualroom = new VirtualRoom (name);
    }
    
    public void allocateParticipants(String code ){
        if (code == "C5"){
            virtualRoom.createBreakoutRooms();
            for (int i=0; i<100; i++){
                virtualRoom.addParticipantToBreakoutRoom(participantID[i], roomNumber);
            }
        }
    }
    
    public boolean addParticipant (String participantID, int roomNumber){
        if (virtualRoom.findBreakoutRoom (roomNumber) != null){
            virtualRoom.addParticipantToBreakoutRoom (participantID, roomNumber);
            return true;
        }
        return false;
    }
    
    public String listParticipants(int roomNumber){
        if (virtualRoom.findBreakoutRoom (roomNumber) != null){
            String list = virtualRoom.listParticipantsInBreakoutRoom (roomNumber);
            return list;
        }
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if (virtualRoom.findBreakoutRoom (roomNumber) != null){
            openBreakoutRoom(roomNumber);
            return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if (virtualRoom.findBreakoutRoom (roomNumber) != null){
            closeBreakoutRoom(roomNumber);
            return false;
        }
        return true;
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        if (findParticipantBreakoutRoom (participantID) != null){
            String breakoutroomid = findParticipantBreakoutRoom (participantID);
            return breakoutroomid;
        }
        return null;
    }
    
    public String listAllBreakoutRooms( ){
        String list = virtualRoom.listBreakoutRooms( );
        return list;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        if (virtualRoom.listParticipantsInBreakoutRoom (roomNumber) != null){
            String list = virtualRoom.listParticipantsInBreakoutRoom (roomNumber);
            return list;
        }
        return null;
    }
}