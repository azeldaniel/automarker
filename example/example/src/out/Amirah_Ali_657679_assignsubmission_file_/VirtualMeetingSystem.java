package out.Amirah_Ali_657679_assignsubmission_file_;//816020184
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class VirtualMeetingSystem{
    private String[] participant = new String[50];
    private VirtualRoom virtualRoom;
      
    public void loadParticipantData(String fileName) throws FileNotFoundException{
      try{
        int i = 0;
        Scanner s = new Scanner(new File(fileName));
        
        while (s.hasNext()){
            participant[i] = s.nextLine();
            i++;
        }
        s.close(); 
      }
      
      catch(FileNotFoundException ex){
          System.out.println("Error");
      }
    }
    
    
    public void createVirtualRoom(String Name){
        virtualRoom = new VirtualRoom(Name, 5);
        virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int i=0, flag = 0;
        int group = 0, room = 1;
        
        if (code.equals("C5")){
            while (flag < 50){
                if (group  == 5){
                    group = 0;
                    room++;
                }
                
                if (room > virtualRoom.getNumberOfBreakoutRooms()){
                    room = 1;
                }
                
                virtualRoom.addParticipantToBreakoutRoom(participant[i], room);
                i++;
                group++;
                flag++;
            }
            System.out.println("\nAllocation: C5\n");
        }
        
        else if (code.equals("RR")){
            while(flag < 50){
                virtualRoom.addParticipantToBreakoutRoom(participant[i], room);
                
                if (room == virtualRoom.getNumberOfBreakoutRooms()){
                    room = 1;
                }
                
                else{
                    room++;
                }
                i++;
                flag++;
            }
        }
        
        else{
            System.out.println("\nInvalid choice\n");
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        if (virtualRoom.findBreakoutRoom(roomNumber) != null){
            virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
            return true;
        }
        return false;
    }
    
    public String listParticipants(int roomNumber){
        if (virtualRoom.findBreakoutRoom(roomNumber) != null){
            return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        }
        else{
            return "Breakout Room not found!";
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if (virtualRoom.findBreakoutRoom(roomNumber) != null){
            virtualRoom.openBreakoutRoom(roomNumber);
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if (virtualRoom.closeBreakoutRoom(roomNumber)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        if (virtualRoom.findParticipantBreakoutRoom(participantID) != null){
            return virtualRoom.findParticipantBreakoutRoom(participantID);
        }
        else{
            return null;
        }
    }
    
    public String listAllBreakoutRooms(){
        String details = "VirtualRoom";
        details += virtualRoom.listBreakoutRooms();
        return details;
    }
    
    public String  listParticipantsInAllBreakoutRooms(){
        if (!virtualRoom.equals(null)){
            String listOfParticipants = "\nParticipants Per Breakout Room:";
            for(int i=0; i<virtualRoom.getNumberOfBreakoutRooms(); i++){
                listOfParticipants += virtualRoom.listParticipantsInBreakoutRoom(i+1) + "\n";
            }
            return listOfParticipants;
        }
        else{
            return null;
        }
    }
}