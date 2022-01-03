package out.Aaron_Payne_657799_assignsubmission_file_;import java.io.FileInputStream;
import java.util.*; 
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author Aaron Payne | ID: 816009846
 * @version 05/02/2021
 */
public class VirtualMeetingSystem{
    private VirtualRoom virtualRoom;
    private Participant[] allParticipants;
    private int totalParticipants=0;
    
    
    public void loadParticipantData (String filename){
        try {
            Scanner scanner = new Scanner(filename);
            //int i=0;
            Participant p = new Participant (scanner.toString());
            Participant[] allParticipants = new Participant[1000];
            
            while (scanner.hasNextLine()) {
                p=allParticipants[totalParticipants];
                String data = scanner.nextLine();
                p.participantID=scanner.nextLine();
                totalParticipants=+1;
                
                System.out.println(data);
            }
            scanner.close();
        }
        catch (Exception e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom (String name){
        VirtualRoom virtualRoom = new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
        
    }
    
    public void allocateParticipants (String code){
        
    }

    public boolean addParticipant (String participantID, int roomNumber){
        if (virtualRoom!=null){
            if (virtualRoom.findBreakoutRoom(roomNumber)!=null){
                System.out.println("Breakout room found. Adding Participant");
                return virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
            }
            else System.out.println("Breakout room not found.");        
        }
        return false;

    }
    
    public String listParticipants (int roomNumber){
        return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom (int roomNumber){
        virtualRoom.openBreakoutRoom(roomNumber);
        return false;
    }
    
    public boolean closeBreakoutRoom (int roomNumber){
        virtualRoom.closeBreakoutRoom(roomNumber);
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        return virtualRoom.findParticipantBreakoutRoom(participantID);
    
    }
    
    public String listAllBreakoutRooms(){
        return virtualRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String participantList="";
        for (int i=0; i<virtualRoom.breakoutRoomLimit;i++){
            participantList = participantList + virtualRoom.listParticipantsInBreakoutRoom(i) + "\n";
        }
        return participantList;
    }
    
    
    
    
    
}
