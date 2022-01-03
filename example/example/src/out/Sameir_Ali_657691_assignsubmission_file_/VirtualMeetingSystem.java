package out.Sameir_Ali_657691_assignsubmission_file_;//Student ID#: 816022840
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class VirtualMeetingSystem{
    private String [] IDs = new String[50];
    private VirtualRoom virtualRoom;
    private int sizeOfArray = 0;
    private boolean roomCreated = false;
    
    public void loadParticipantData(String filename){
        try{        
            File inputFile = new File(filename);
            Scanner in = new Scanner(inputFile);
            while(in.hasNext()){
                IDs[sizeOfArray] = in.nextLine();
                sizeOfArray++;
            }
             in.close();
        }
        catch(FileNotFoundException e){
            return;
        }
    }
    
    public void createVirtualRoom(String name){
        virtualRoom = new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
        roomCreated = true;
    }
    
    public void allocateParticipants(String code){
        int i = 0;
        int count = 0;
        int loop;
        if(roomCreated == false)
            virtualRoom.createBreakoutRooms();
        
        switch(code){
            case "C5":    
                for(count = 0; count <5; count ++){
                    virtualRoom.openBreakoutRoom(count+1);
                    loop = 0;
                    while(loop < 5 && i < this.sizeOfArray){
                        virtualRoom.addParticipantToBreakoutRoom(IDs[i],count+1);
                        i++;
                        loop++;
                    }
                }
                loop = 0;
                count = 0;
                while(i < this.sizeOfArray){
                    if(loop == 5){
                        loop = 0;
                        count ++;
                    }
                    if(count == 5)
                        count = 0;
                    virtualRoom.addParticipantToBreakoutRoom(IDs[i],count+1);
                    i++;
                    loop++;
                }
                break;
            case "RR":
                for(count = 0; count <5; count ++){
                    virtualRoom.openBreakoutRoom(count+1);
                }
                count = 0;
                while(i< this.sizeOfArray){
                    if(count == 5)
                        count = 0;
                    virtualRoom.addParticipantToBreakoutRoom(IDs[i],count+1);
                    i++;
                    count++;
                }
                break;
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        boolean addStatus = virtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber);
        return addStatus;
    }
    
    public String listParticipants(int roomNumber){
        String list = virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        return list;
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
        String list = "";
        for(int i = 0; i <5; i++ ){
            list += virtualRoom.listParticipantsInBreakoutRoom(i+1) + "\n";
        }
        return list;
    }
}


//Resources used for this class:
//1. Lecture Notes
//2. Online Resource,  w3schools.com,  url: https://www.w3schools.com/java/java_files_read.asp
//3. Lab session