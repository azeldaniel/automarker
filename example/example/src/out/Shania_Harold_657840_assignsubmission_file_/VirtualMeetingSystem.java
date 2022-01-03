package out.Shania_Harold_657840_assignsubmission_file_;// 816006213

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.util.Arrays;

public class VirtualMeetingSystem{
    private VirtualRoom virtualRoom;
    private String[] participantID;

    public VirtualMeetingSystem(){
        //createVirtualRoom("");
        participantID = new String[50];
    }

    public void loadParticipantData(String filename) throws IOException{
        // Reads data from file
        // Loads data into array for breakout rooms allocation
        
        String fileContent = "";
        //String[] participantID;
        //participantID = new String[50];
        int count = 0;
        
        try{
            FileReader file = new FileReader(filename);
            BufferedReader fileStream = new BufferedReader(file);
            
            String temp = fileStream.readLine();
            while(temp!=null){
                fileContent = fileContent + " " + temp;
                participantID[count] = temp;
                //System.out.println(temp);
                temp = fileStream.readLine();
                count++;
            }
            fileStream.close();
        }
        catch(FileNotFoundException e){
            System.out.println("No file was read");
        }
        catch(IOException e){
            System.out.println("There was a problem");
        }
        //System.out.println(fileContent);
        
        //for (int i = 0; i < 50; i++){
            //System.out.println(participantID[i]);
        //}
    }
    
    public void createVirtualRoom(String name){
        virtualRoom = new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int j = 0; // Breakout room array position
        int x = 0;
        int z = 0;
        int counter = 0; // Breakout room count
        int counter2 = 0;
        
        if (code.equals("C5")){
            for (int i = 0; i < 25; i++){
                j = i + 1;
                if (j%5 != 0){
                    addParticipant(participantID[i], counter);
                } else {
                    addParticipant(participantID[i], counter);
                    counter++;
                }
            }
            //System.out.println(counter);
            counter = 0;
            for (int i = 25; i < 50; i++){
                j = i + 1;
                if (j%5 != 0){
                    addParticipant(participantID[i], counter);
                } else {
                    addParticipant(participantID[i], counter);
                    counter++;
                }
            }
            //System.out.println(counter);
        }
        
        if (code.equals("RR")){
            for (int a = 0; a < 50; a++){
                if (counter2 == 5){
                    addParticipant(participantID[a], counter2);
                    counter2 = 0;
                } else {
                    addParticipant(participantID[a], counter2);
                    //System.out.println(counter2);
                    counter2++;
                }
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        // create virtual room
        String name = virtualRoom.getVirtualRoomName();
        //System.out.println(name);
        //createVirtualRoom("Chem");
        //System.out.println("VMS: " + roomNumber);
        //VirtualRoom virtualRoom = new VirtualRoom("Spanish");
        boolean flag; 
        flag = virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
        //System.out.println(flag);
        if (flag == false){
            //System.out.println("Invalid ID");
            return false;
        }
        return true;
        //return virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
        //return false;
    }
    
    public String listParticipants(int roomNumber){
        //String details = "VirtualRoom \n";
        return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        //return details;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return virtualRoom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return virtualRoom.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        return virtualRoom.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        return virtualRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        int num = virtualRoom.getNumberOfBreakoutRooms();
        String details = "";
        //System.out.println(num);
        //BreakoutRoom br;
        //return virtualRoom.listParticipantsInBreakoutRoom(1);
        for (int i = 0; i < num; i++){
            //br = virtualRoom.findBreakoutRoom(i);
            details += virtualRoom.listParticipantsInBreakoutRoom(i) + "\n";
        }
        return details;
    }
    
    public static void main(String[] args) throws Exception{
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        vms.loadParticipantData("participant.dat");
        vms.createVirtualRoom("Russian");
        //vms.allocateParticipants("C5");
        vms.allocateParticipants("RR");
        //vms.addParticipant("00000001", 1);
        
        //System.out.println(vms.listParticipants(1));
        //vms.openBreakoutRoom(1);
        //System.out.println(vms.closeBreakoutRoom(1));
        //System.out.println(vms.findParticipantBreakoutRoom("00000001"));
        System.out.println(vms.listParticipantsInAllBreakoutRooms());
    }
}