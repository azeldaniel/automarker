package out.Brandon_Rampersad_657676_assignsubmission_file_;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author 816019037
 * @version (a version number or a date)
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    private String[] participantFile = new String[50];
    private VirtualRoom vRoom;
    
    

   public void loadParticipantData(String filename){
       int arrayCount = 0;
       try{
           File inputFile = new File("participant.dat");
           Scanner reader = new Scanner (inputFile);
           while(reader.hasNextLine()){
               participantFile[arrayCount] = reader.nextLine();
               System.out.println("Participant ID: " + participantFile[arrayCount] + "\n");
               arrayCount++;
            }
            reader.close();
        }
            catch (FileNotFoundException e){
                System.out.println("An error occured");
                e.printStackTrace();
            }
}


public void createVirtualRoom(String name){
    vRoom.createBreakoutRooms();
}

public void allocateParticipants(String code){
    int x,y;
    int numRooms = vRoom.getNumberOfBreakoutRooms();
    int numP=0;
    
    for (x=0; x<numRooms; x++){
        for (y=0; y<5; y++){
            vRoom.addParticipantToBreakoutRoom(participantFile[numP], x);
            numP++;
        }
        y = 0;
    }

    
    
    
}

public boolean addParticipant (String participantID, int roomNumber){
    boolean check;
    check = vRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
    if(check == true)
        return true;
    else
    return false;
}

public String listParticipants(int roomNumber){
    String list;
    list = vRoom.listParticipantsInBreakoutRoom(roomNumber);
    
    return list;
}

public boolean openBreakoutRoom(int roomNumber){
    boolean check;
    check = vRoom.openBreakoutRoom(roomNumber);
    if (check == true)
        return true;
     else
        return false;
}

public boolean closeBreakoutRoom(int roomNumber){
    boolean check;
    check = vRoom.closeBreakoutRoom(roomNumber);
    if (check == true)
        return true;
    else
    return false;
}

public String findParticipantBreakoutRoom(String participantID){
    String foundRoom;
    foundRoom = vRoom.findParticipantBreakoutRoom(participantID);
    return foundRoom;
}

public String listAllBreakoutRoom(){
    String listallrooms;
    listallrooms = vRoom.listBreakoutRooms();
    return listallrooms;
}

public String listParticipantsInAllBreakoutRooms(){
    String pList=null;
    int room = vRoom.getNumberOfBreakoutRooms();
    for(int x=0; x<room; x++){
        pList += vRoom.listParticipantsInBreakoutRoom(x);
        
    }
    return pList;
}
}
    

    
    

