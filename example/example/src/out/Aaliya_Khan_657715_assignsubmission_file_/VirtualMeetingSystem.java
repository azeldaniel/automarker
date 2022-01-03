package out.Aaliya_Khan_657715_assignsubmission_file_;/**
 * Student ID - 816019696
 */

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class VirtualMeetingSystem
{
    private String[] data = new String[50];
    private VirtualRoom room;
    private int numParticipants;
    
    public void loadParticipantData(String filename){
        int i = 0;
 
        try{
            File inFile = new File(filename);
            Scanner reader = new Scanner(inFile);
            
            data[i] = reader.nextLine();
         /*   System.out.println(i);
              System.out.print(". ");
              System.out.println(this.data[i]);
                System.out.println(); */
            i++;
            while(reader.hasNextLine()){
                this.data[i] = reader.nextLine();
            /*    System.out.println(i);
                  System.out.print(". ");
                  System.out.println(this.data[i]);
                  System.out.println(); */
                i++;
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
        }
        
        this.numParticipants = i;
    }
    
    public void createVirtualRoom(String name){
        this.room = new VirtualRoom(name, 5);
        
        this.room.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int i = 0;
        int j = 0;
        int k = 0;
        int s = 0;
        
        if(code.equals("C5")){
            while(s < numParticipants){
                for(i = 0; i < room.getNumberOfBreakoutRooms(); i++){
                    while(k < 5){
                        boolean added = room.addParticipantToBreakoutRoom(data[j], i);
                        j++;
                        k++;
                    }
                    k = 0;
                }
                s += j;
            }
        }
        else {
            if(code.equals("RR")){
                i = 0;
                j = 0;
                k = 0;
                
                while(i < numParticipants){
                    for(j = 0; j < room.getNumberOfBreakoutRooms(); j++){
                        boolean added;
                        added = room.addParticipantToBreakoutRoom(data[k], j);
                        k++;
                    }
                    i += 5;
                }
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        boolean add;
        add = room.addParticipantToBreakoutRoom(participantID, roomNumber);
        return add;
    }
    
    public String listParticipants(int roomNumber){
        String list;
        list = room.listParticipantsInBreakoutRoom(roomNumber);
        return list;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean open;
        open = room.openBreakoutRoom(roomNumber);
        return open;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean closed;
        closed = room.closeBreakoutRoom(roomNumber);
        return closed;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String participant;
        participant = room.findParticipantBreakoutRoom(participantID);
        return participant;
    }
    
    public String listAllBreakoutRooms(){
        String list;
        list = room.listBreakoutRooms();
        return list;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String list;
        
        list = "List of Participants in Breakout Rooms";
        list += "\r\n";
        for(int i = 0; i < room.getNumberOfBreakoutRooms(); i++){
            list += room.listParticipantsInBreakoutRoom(i);
        }
        return list;
    }
    
}

/* code for loadParticipant - https://www.programiz.com/java-programming/basic-input-output */
