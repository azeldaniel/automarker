package out.Dhanesh_Sankar_657707_assignsubmission_file_;/**
 * Dhanesh Sankar
 * 816020350
 */

import java.util.Scanner; 
import java.io.File; 
import java.io.FileNotFoundException;
public class VirtualMeetingSystem
{
    private VirtualRoom createRoom;  
    private String[] fileID = new String[50];
     
    public void loadParticipantData(String filename) throws Exception{
        String firstPath = " ";
        String P1 = " ";
        int arrayCount = 0;
        boolean checkFile = false;
        

        File Participants= new File(filename); //participants.dat file
        Scanner keyboard = new Scanner(Participants);
        P1 = Participants.getAbsolutePath();
        System.out.println("File loaded from:" + " " + P1);
        checkFile = Participants.exists();
        if(checkFile == false){
            System.out.println("The file not found");   
            return;
        }
    
        while(keyboard.hasNextLine()){
            fileID[arrayCount]= keyboard.nextLine();
            System.out.println("ID: " + fileID[arrayCount] + "\n");
            arrayCount = arrayCount + 1; 
        }
        keyboard.close();
    }
    
    public void createVirtualRoom(String name){
        createRoom = new VirtualRoom(name);
        createRoom.createBreakoutRooms();
    }
        
    public void allocateParticipants(String code){
        int totalBreakoutRooms=0;
        totalBreakoutRooms = createRoom.getNumberOfBreakoutRooms();
        int roomCount = 0;
        int i=0;
        int num;

        if(code.equals("C5")){
            while(roomCount<totalBreakoutRooms){
                 for(num = 0; num<10 ; num++){
                     createRoom.addParticipantToBreakoutRoom(fileID[i], roomCount);
                     i++;                         
                 }
                 num = 0;
                 roomCount++;
            }
        }
     }

    public boolean addParticipant(String participantID,int roomNumber){
        boolean check = createRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
        if(check==true){
            return true;
        }
        return false;
     }
    
    public String listParticipants(int roomNumber){
        String plist = " ";
        plist = plist + createRoom.listParticipantsInBreakoutRoom(roomNumber);
        System.out.println(plist);
        return plist; 
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean checkRoom = createRoom.openBreakoutRoom(roomNumber);
        if(checkRoom==true){
            return true;
        }
        else{ 
            System.out.println("Room already open");
            return false;
        }
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean checkClose = createRoom.closeBreakoutRoom(roomNumber);
        if(checkClose== true){
            return true;
        }
        else{
            System.out.println("Room already closed");
            return false;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String findParticipant = " "+ " \n";
        findParticipant= findParticipant + createRoom.findParticipantBreakoutRoom(participantID);
        //System.out.println(findParticipant);
        return findParticipant;
    }
    
    public String listAllBreakoutRooms(){
        String listbRooms = " ";
        listbRooms  = listbRooms  + createRoom.listBreakoutRooms();
        System.out.println(listbRooms );
        return listbRooms ;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        int allRoom = 0;
        String allParticipants = " "; 
        allRoom = createRoom.getNumberOfBreakoutRooms();

        System.out.println("The total number of Breakout rooms are: " + " " +  allRoom);
        System.out.println("\n");

        for(int num=0; num<allRoom; num++){       
          allParticipants += createRoom.listParticipantsInBreakoutRoom(num) + "\n"; 
        }        
        //System.out.println(allParticipants);
        return allParticipants;        
    }
}