package out.Rashad_Downes_657743_assignsubmission_file_;import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * ID#: 816015845
 *
 * @author (Rashad Downes)
 * @version (Thursday, February 11th, 2021)
 * 
 */

public class VirtualMeetingSystem{
    VirtualRoom virtualRoom = new VirtualRoom("VirtualRoom");
    private int count = 0;
    private int roomNumber = 0;
    String [] participants = new String [50];

    public void loadParticipantData(String filename){
        try {
            File file = new File (filename);
            Scanner data = new Scanner(file);

            int i=0;

            while (data.hasNextLine()){
                String participant = data.nextLine();
                participants[i] = participant;
                i++;
            } 
            data.close();
        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void createVirtualRoom(String name){
        virtualRoom = new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
    }

    public void createVirtualRoom(String name, int limit){
        virtualRoom = new VirtualRoom(name, limit);
        virtualRoom.createBreakoutRooms();
    }

    public void allocateParticipants(String code){
        if (code.equals("C5")){
            for(int i=0;i<50;i++){
                virtualRoom.addParticipantToBreakoutRoom (participants[i], roomNumber);
                count++;
                if(count == 5){
                    count = 0;
                    roomNumber++;
                    if (roomNumber == 5)
                        roomNumber = 0;
                }
            }
        }
        else
        if (code.equals("RR")){
            for(int i=0;i<50;i++){
                virtualRoom.addParticipantToBreakoutRoom (participants[i], roomNumber);
                count++;
                if(count == 1){
                    count = 0;
                    roomNumber++;
                    if (roomNumber == 5)
                        roomNumber = 0;                    
                }
            }
        }
    }

    public boolean addParticipant (String participantID, int roomNumber){
        if(virtualRoom.addParticipantToBreakoutRoom (participantID, roomNumber-1) == true)
            return true;
        return false;
    }

    public String listParticipants(int roomNumber){
        String participants = virtualRoom.listParticipantsInBreakoutRoom(roomNumber-1);
        return participants;
    }

    public boolean openBreakoutRoom(int roomNumber){
        return virtualRoom.openBreakoutRoom(roomNumber-1);
    }

    public boolean closeBreakoutRoom(int roomNumber){
        return virtualRoom.closeBreakoutRoom(roomNumber-1);
    }

    public String findParticipantBreakoutRoom(String participantID){
        String participant = virtualRoom.findParticipantBreakoutRoom(participantID);
        return participant;
    }

    public String listAllBreakoutRooms(){
        String listOfRooms = virtualRoom.listBreakoutRooms();
        return listOfRooms;
    }

    public String listParticipantsInAllBreakoutRooms(){
        String list = "";
        for(int i=0; i<virtualRoom.getNumberOfBreakoutRooms(); i++) 
            list += virtualRoom.listParticipantsInBreakoutRoom(i);
        return list;
    }
}
