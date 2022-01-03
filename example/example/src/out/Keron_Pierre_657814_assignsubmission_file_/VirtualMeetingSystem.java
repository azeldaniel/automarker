package out.Keron_Pierre_657814_assignsubmission_file_;//816022340

import java.util.*;
import java.io.*;
public class VirtualMeetingSystem
{
    VirtualRoom room;
    String[] id;
    int counter;
    public VirtualMeetingSystem() {}
    public void loadParticipantData(String filename) throws IOException{
        
        Scanner input = new Scanner(new File(filename));
        counter =0;
        while(input.hasNextLine()){
            counter++;
            input.nextLine();
        }
        input.close();
        input = new Scanner(new File(filename));
        id = new String[counter];
        
        for(int i=0; i<counter; i++){
            id[i] = input.nextLine();
        }
    }
    
    public void createVirtualRoom(String name){
        room = new VirtualRoom(name);
        room.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        
        if(code == "C5"){
            int j=0;
            
            for(int i=0; i<room.getNumberOfBreakoutRooms(); i++){
                while (j<counter){
                    
                    for(int k=0; k<5;k++){
                    room.findBreakoutRoom(i+1).addParticipant(id[j]);
                    j++;
                }
                break;
                }
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        boolean add = room.addParticipanttoBreakoutRoom(participantID, roomNumber);
        return add;
    }
    
    public String listParticipants(int roomNumber){
        String participants = room.listParticipantsInBreakoutRoom(roomNumber);
        return participants;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean open = room.openBreakoutRoom(roomNumber);
        return open;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean close = room.closeBreakoutRoom(roomNumber);
        return close;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String findPart = room.findParticipantBreakoutRoom(participantID);
        return findPart;
    }
    
    public String listAllBreakoutRooms(){
    String roomList = room.ListBreakoutRooms();
    return roomList;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        int numberOfRooms = room.getNumberOfBreakoutRooms();
        String participantList = "";
        for(int i=0; i<numberOfRooms; i++){
            participantList = participantList + room.listParticipantsInBreakoutRoom(i+1) + "\n";
        }
        return participantList;
    }
}







