package out.Madeenah_Salamat_657821_assignsubmission_file_;// ID: 816020303

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem{
    //attributes
    private VirtualRoom virtualRoom;
    private int numP = 0;
    private String[] readIn = new String[50];
    private BreakoutRoom[] breakoutRooms;
    
    //methods
    public void loadParticipantData(String filename){
        int x = 0;
        try{
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            readIn[x] = reader.nextLine();
            x++;
            while (reader.hasNextLine()){
                this.readIn[x] = reader.nextLine();
                x++;
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error occured; file not found.");
            e.printStackTrace();
        }
        this.numP = x;
    }
    
    public void createVirtualRoom(String name){
        this.virtualRoom = new VirtualRoom(name,5);
        this.virtualRoom.createBreakoutRooms();
    }
    
    public void allocatePartipants(String code){
        int x = 0;
        int y = 0;
        int rLimit = 0;
        boolean found;
        
        BreakoutRoom[] breakoutRooms = new BreakoutRoom[]{};
        
        if(code.equals("C5")){
            createVirtualRoom("Workshop");
            for (x = 0; x < breakoutRooms.length; x++){
                while (rLimit < 10){
                    found = virtualRoom.addParticipantToBreakoutRoom(readIn[y], x) ;
                    rLimit++;
                    y++;
                }
                rLimit = 0;
            }
        }
        else{
            if (code.equals("RR")){
                createVirtualRoom("Workshop");
                while(rLimit < numP){
                    for(x = 0; x <breakoutRooms.length; x++){
                       found = virtualRoom.addParticipantToBreakoutRoom(readIn[y], x);
                       y++;
                    }
                    rLimit = rLimit + 5;
                }
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        boolean addP;
        addP = virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
        return addP;
    }
    
    public String listParticipants(int roomNumber){
        String listOfP;
        listOfP = virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        return listOfP;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean openBR;
        openBR = virtualRoom.openBreakoutRoom(roomNumber);
        return openBR;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean closeBR;
        closeBR = closeBreakoutRoom(roomNumber);
        return closeBR;
    }
    
    /*
    public String findParticipantBreakoutRoom(String participantID){
        String BRHost;
        BRHost = virtualRoom.findParticipantBreakoutRoom(participantID);
        return BRHost;
    }
    */
    
    public String listAllBreakoutRooms(){
        String listOfBR;
        listOfBR = virtualRoom.listBreakoutRooms();
        return listOfBR;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String listOfAllP;
        listOfAllP = virtualRoom.listParticipantsInBreakoutRoom(0);
        
        //for breakoutRooms.length
        BreakoutRoom[] breakoutRooms = new BreakoutRoom[]{};
        for(int i = 1; i < breakoutRooms.length; i++){
            listOfAllP += virtualRoom.listParticipantsInBreakoutRoom(i);
        }
        return listOfAllP;
    }
}
// Code used from w3schools to open a file using scanner:
// https://www.w3schools.com/java/java_files_read.asp