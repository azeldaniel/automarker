package out.Rongzhen_Chen_657726_assignsubmission_file_;//816014227
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;


public class VirtualMeetingSystem{
    
    private VirtualRoom virtualRoom;
    private String[] participantsArray;
    private int participantCount;
    
    public int getParticipantCount(){
        return participantCount;
    }
    
    public String getParticipantFromArray(int i){
        return participantsArray[i];
    }
    
    public void loadParticipantData(String filename){
        int i =0;
        participantsArray = new String[50];
        try{
            File participantDataFile = new File(filename);
            Scanner input = new Scanner(participantDataFile);
            
            while(input.hasNextLine()){
                participantsArray[i] = input.nextLine();
                i++;
            }
            participantCount = i;
            input.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error loading file");
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
        if(code.equals("C5")){
            int i=0;
            int roomNum=1;
            while(i<participantCount){
                virtualRoom.addParticipantToBreakoutRoom(participantsArray[i], roomNum);
                i++;
                if(i%5 == 0){
                    roomNum++;
                }
            }
        }
        else if(code.equals("RR")){
            int i=0;
            int roomNum = 1;
            while(i<participantCount){
                if(i%5==0)
                    roomNum = 1;
                else if(i%5==1)
                    roomNum = 2;
                else if(i%5==2)
                    roomNum = 3;
                else if(i%5==3)
                    roomNum = 4;
                else if(i%5==4)
                    roomNum = 5;
                
                virtualRoom.addParticipantToBreakoutRoom(participantsArray[i], roomNum);
                i++;
            }
        }
        else 
            System.out.println("Code not recognized. Choose either C5 or RR.");
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        return virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
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
    
    public String findParticipantBreakoutRoom(String participantID){
        return virtualRoom.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        return virtualRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String details = "";
        for(int i=0; i<=virtualRoom.getNumberOfBreakoutRooms(); i++){
            details += virtualRoom.listParticipantsInBreakoutRoom(i) + System.lineSeparator();
        }
        return details;
    }
    

}
