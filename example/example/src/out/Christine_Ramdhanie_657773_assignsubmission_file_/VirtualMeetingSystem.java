package out.Christine_Ramdhanie_657773_assignsubmission_file_;//ID: 816018588
//NAME: CHRISTINE RAMDHANIE
//COMP 2603 - ASSIGNMENT 1 
import java.util.ArrayList;
import java.io.*; 
import java.util.*;
import java.util.Scanner;

public class VirtualMeetingSystem{
    VirtualRoom virtualRoom;
    int numParticipants = 0;
    Scanner loadData;
    String dataArray[];
  
    public VirtualMeetingSystem(){
 
    }
    
    //Reading in from .dat file to the program and storing it in an array 
    public void loadParticipantData(String filename )throws IOException {
        loadData = new Scanner(new File( "participant.dat"));
        String dataArray[] = new String[50];
        int count= 0;
        while(loadData.hasNext()){
            dataArray[count++] = loadData.next();
            loadData.close();
        }
        
    }
    
    //Creates a virtual room
    public void createVirtualRoom(String name){
        virtualRoom = new VirtualRoom (name, 5);
        this.virtualRoom = virtualRoom;
        virtualRoom.createBreakoutRooms();
    }
    
    //Allocates the participants in the C5 form or the Round Robin form 
    public void allocateParticipants(String code ){
        int count = 0;
        int nextCount = 0;
        int groupOfFive = 1;
        if (code.toUpperCase() == "C5"){
            while((count< numParticipants) && (nextCount < virtualRoom.getNumberOfBreakoutRooms())){
                if (groupOfFive % 5  == 0){
                    groupOfFive++;
                    count++;
                }
                else if (groupOfFive % 5  != 0){
                    addParticipant(dataArray[nextCount],count);
                }
                else 
                nextCount = nextCount + 2; 
            }
        }
        
        
    }
    
    //Using the method in virtual room to add particpants 
    public boolean addParticipant (String participantID, int roomNumber){
        return virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber); 
    }
    
    //Using the method in virtual room to list particpants
    public String listParticipants(int roomNumber){
        return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    //Using the method in virtual room to open Breakout Room
    public boolean openBreakoutRoom(int roomNumber){
        return virtualRoom.openBreakoutRoom(roomNumber);
    }
    
    //Using the method in virtual room to close Breakout Room
      public boolean closeBreakoutRoom(int roomNumber){
        return virtualRoom.closeBreakoutRoom (roomNumber);
    }
    
    //Using the method in virtual room to find participants in Breakout Room
    public String findParticipantBreakoutRoom(String participantID){
        return virtualRoom.findParticipantBreakoutRoom(participantID); 
    }
    
    //Using the method in virtual room to list all Breakout Rooms
    public String listAllBreakoutRooms( ) {
        String breakoutDetails = " ";
        int numRooms = virtualRoom.getNumberOfBreakoutRooms();
        if (numRooms !=0){
            breakoutDetails= "Number of Breakout Rooms: " + numRooms + "\r\n";
        }
        return breakoutDetails;
    }
    
    //Using the method in virtual room to list all participants in all Breakout Rooms
    public String listParticipantsInAllBreakoutRooms(){
        String listDetails = " ";
        int count= 0;
        if(virtualRoom.getNumberOfBreakoutRooms() !=0){
            while (count < virtualRoom.getNumberOfBreakoutRooms()){
                listDetails= "List of all Participants In breakout Room: " + virtualRoom.listParticipantsInBreakoutRoom(count) + "\r\n";
                count++;
            }
        }
        return listDetails;
    }
    
}
 /* In the loadParticipantData method google was used since I had 
  * no prior knowledge for reading in files.
  * The source used was: https://stackoverflow.com/questions/23141851/reading-a-dat-file-into-an-array-in-java
  */
