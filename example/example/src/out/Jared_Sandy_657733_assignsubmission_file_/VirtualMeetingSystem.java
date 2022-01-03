package out.Jared_Sandy_657733_assignsubmission_file_;// 816018721

import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;
 
public class VirtualMeetingSystem{
    
    private String[] participantArray;
    private String filename;
    private int participantsCount = 0;
    VirtualRoom virtualRoom;
    
 
    
    public void loadParticipantData(String filename) {
        //String filename="participant.dat";
        participantArray= new String[100];
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                participantArray [participantsCount] = myReader.nextLine();
                participantsCount++;
            }
            
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name) {
        virtualRoom = new VirtualRoom(name);
    }
    
    public void allocateParticipants(String code) {
        virtualRoom.createBreakoutRooms(); 
       
        int numberRooms = virtualRoom.getNumberOfBreakoutRooms();
        int y = 0;
        switch(code){
            case  "C5" :
            for(int i=1; i<=numberRooms;i++){
                System.out.println(participantArray[i]);
                for(int j=0;j<=4;j++){
                  virtualRoom.addParticipantToBreakoutRoom(participantArray[y], i);  
                  y++;
                }
                if((i==5)&&(y<participantsCount))
                     i=0;
                    else if (y==participantsCount)
                       break;
            }
         
        break;
            
          case "RR":
            for(int i=1; i<=numberRooms;i++){
                System.out.println(participantArray[i]);
                  virtualRoom.addParticipantToBreakoutRoom(participantArray[y], i);  
                  y++;
                if((i==5)&&(y<participantsCount))
                     i=0;
                    else if (y==participantsCount)
                       break;
            }
        break;
            default:
                  System.out.println("Invalid code specifed");
                  break;
                }
        } 
    
    public boolean addParticipant(String participantID, int roomNumber) {
        if (virtualRoom.findBreakoutRoom(roomNumber) != null) {
            virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
            return true;
        }
        return false;
    }
    
    public String listParticipants(int roomNumber){
        if (virtualRoom.findBreakoutRoom(roomNumber) != null)
            return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if (virtualRoom.findBreakoutRoom(roomNumber) != null) 
            return virtualRoom.openBreakoutRoom(roomNumber);
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){ 
        if (virtualRoom.findBreakoutRoom(roomNumber) != null) {
            return virtualRoom.closeBreakoutRoom(roomNumber);
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID) {
      if(virtualRoom.findParticipantBreakoutRoom(participantID) != null)
         return virtualRoom.findParticipantBreakoutRoom(participantID);
      return null;
    }
    
    public String listAllBreakoutRooms(){
        return virtualRoom.listBreakoutRooms();
    }
 
    public String listParticipantsInAllBreakoutRooms() {
       int roomroomNumber = virtualRoom.getNumberOfBreakoutRooms( );
       String AllParticipants="";
       if (roomroomNumber ==0)
         return null;
        for(int i = 1; i <= roomroomNumber; i++) {
            AllParticipants= listParticipants(i) + AllParticipants;
        }
        return AllParticipants;
    }
    
}
    // FILE READING socuce from: https://www.w3schools.com/java/java_files_read.asp

