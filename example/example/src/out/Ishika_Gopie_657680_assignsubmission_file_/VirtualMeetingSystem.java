package out.Ishika_Gopie_657680_assignsubmission_file_;
/**
 * StudentID: 816018253
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem{
    
    private String virtualRoomName;
    private String[] participantIDs = new String[50];
    private int numberOfParticipantsInVirtualRoom = 0;
    private VirtualRoom virtualRoom;
   
    public void loadParticipantData(String filename){
        try{
            File p = new File(filename);
            Scanner read = new Scanner(p);
            while(read.hasNextLine()){
                String data = read.nextLine();
                participantIDs[numberOfParticipantsInVirtualRoom] = data;
                numberOfParticipantsInVirtualRoom++;
            }
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error opening file! ");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name){
        virtualRoom = new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int roomNumber = 1; 
        int count = 0;  // used as an index for the participantIDs array
        boolean added;
        if(code == "C5"){
            while(roomNumber <= virtualRoom.getNumberOfBreakoutRooms()){
                for(int i = 0; i < 5; i++){
                    added = virtualRoom.addParticipantToBreakoutRoom(participantIDs[count], roomNumber);
                    if(added == false){
                        System.out.println("Failed to allocate participant");
                    }
                    count++;
                }
                roomNumber++;
            }
        }
        else if (code == "RR"){
            for(int i = 0; i < 10; i++){
                while(roomNumber <= virtualRoom.getNumberOfBreakoutRooms()){
                    added = virtualRoom.addParticipantToBreakoutRoom(participantIDs[count], roomNumber);
                    if (added == false){
                        System.out.println("Failed to allocate paritcipant");
                    }
                    roomNumber++;
                    count++;
                }
                roomNumber = 1;
            }
        }
        else{
            System.out.println("Invalid Code!");
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        return virtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber);
    }
    
    public String listParticipants(int roomNumber){
        return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return virtualRoom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return virtualRoom.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String  participantID){
        return virtualRoom.findParticipantBreakoutRooom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        return virtualRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String s = "";
        for (int i = 1; i <= virtualRoom.getNumberOfBreakoutRooms(); i++){
            s = s + virtualRoom.listParticipantsInBreakoutRoom(i) + "\n";
        }
        return s;
    }
    
    /*
     * Refrence
     *  Title: Java Read Files
     *  Author: w3schools.com
     *  Availability: https://www.w3schools.com/java/java_files_read.asp
     */
    
}


