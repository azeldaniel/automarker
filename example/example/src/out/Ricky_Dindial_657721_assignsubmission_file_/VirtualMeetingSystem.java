package out.Ricky_Dindial_657721_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * Ricky Dindial
 * 816022023
 */
public class VirtualMeetingSystem
{
    private String[] participantFile = new String[50];
    private VirtualRoom virtualRoom;
    
    public void loadParticipantData(String filename){
        int arrayCount = 0;
        try{
        File inputFile = new File("participant.dat");
        Scanner reader = new Scanner(inputFile);
        while(reader.hasNextLine()){
            participantFile[arrayCount] = reader.nextLine();
            System.out.println("Participant ID: " + participantFile[arrayCount] + "\n");
            arrayCount++;
        }
        reader.close();
    }   catch (FileNotFoundException e){
        System.out.println("An error occured");
        e.printStackTrace();
        }  
    }
    
    
    public void createVirtualRoom(String name){
        virtualRoom = new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
    }
    
    
    public void allocateParticipants(String code){
        int numberOfBreakoutrooms = 0;
        numberOfBreakoutrooms = virtualRoom.getNumberOfBreakoutRooms();
        int i;
        int j;
        int count = 0;
        if(code.equals("C5")){
            for(i = 0; i < numberOfBreakoutrooms; i++){
                for(j = 0; j < 10; j++){
                    virtualRoom.addParticipantToBreakoutRoom(participantFile[count], i);
                    count++;
                }
                j = 0;
            }
        }
    }
    
    
    
    public boolean addParticipant(String participantID, int roomNumber){
        if(virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber) == true){
            return true;
        }
        return false;
    }
    
    
    public String listParticipants(int roomNumber){
        String listing;
        listing = virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        System.out.println(listing);
        return listing;
    }
    
    
    public boolean openBreakoutRoom(int roomNumber){
        if(virtualRoom.openBreakoutRoom(roomNumber) == true){
            return true;
        }
        return false;
    }
    
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(virtualRoom.closeBreakoutRoom(roomNumber) == true){
            return true;
        }
        return false;
    }
    
    
    public String findParticipantBreakoutRoom(String participantID){
        String findRoom;
        findRoom = virtualRoom.findParticipantBreakoutRoom(participantID);
        System.out.println(findRoom);
        return findRoom;
    }
    
    
    public String listAllBreakoutRooms(){
        String listRooms;
        listRooms = virtualRoom.listBreakoutRooms();
        System.out.println(listRooms);
        return listRooms;
    }
    
    
    public String listParticipantsInAllBreakoutRooms(){
        int room = virtualRoom.getNumberOfBreakoutRooms();
        String participantsInRoom = " ";
        for(int i = 0; i < room; i++){
            participantsInRoom += virtualRoom.listParticipantsInBreakoutRoom(i) + "\n";
        }
        return participantsInRoom;
    }
    
    
    
}
