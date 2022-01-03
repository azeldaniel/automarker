package out.Adrian_Khan_657741_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * StudentID: 816020488
 */
public class VirtualMeetingSystem
{
    private VirtualRoom room;
    private String[] data = new String[999];
    private int lineCounter = 1;

    public void loadParticipantData(String filename)
    {
        try{
            File participantData = new File(filename);
            Scanner scnr = new Scanner(participantData);
            while(scnr.hasNextLine()){
                data[lineCounter] = scnr.nextLine();
                lineCounter++;
            }
        } catch (Exception e){
            e.getMessage();
        }
    }
    
    public void createVirtualRoom(String name)
    {
        room = new VirtualRoom(name);
        room.createBreakoutRooms();
    }

    public void allocateParticipants(String code)
    {
        int nextParticipant = 1;
        int nextRoomCounter = 1;
        if (code.toUpperCase().equals("C5")){ 
            while(nextParticipant < lineCounter){ 
                if(nextRoomCounter > room.getNumberOfBreakoutRooms()){
                    nextRoomCounter = 1;
                }
                for (int i = 0; i < 5 ; i++){ //Allocates in clusters of 5 to a room
                    room.addParticipantToBreakoutRoom(data[nextParticipant], nextRoomCounter);
                    nextParticipant++;
                }
                nextRoomCounter++; 
            }
        } else if (code.toUpperCase().equals("RR")){
            while(nextParticipant < lineCounter){
                if(nextRoomCounter > room.getNumberOfBreakoutRooms()){
                    nextRoomCounter = 1;
                }
                room.addParticipantToBreakoutRoom(data[nextParticipant], nextRoomCounter);
                nextParticipant++;
                nextRoomCounter++;
            }
        } else {
            System.out.println("Invalid Allocation Strategy!");
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber)
    {
        if(this.room.findBreakoutRoom(roomNumber) != null){
            this.room.addParticipantToBreakoutRoom(participantID, roomNumber);
            return true;
        }
        return false;
    }
    
    public String listParticipants(int roomNumber)
    {
        String[] details = new String[10];
        for(int i = 0; i < 10; i++){
            details[i] += this.room.listParticipantsInBreakoutRoom(roomNumber);
            System.out.println(room.listParticipantsInBreakoutRoom(roomNumber));
            return details[i];
        }
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        if(this.room.findBreakoutRoom(roomNumber) != null){
            this.room.openBreakoutRoom(roomNumber);
            return true;
        }
        return false;        
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        if(this.room.findBreakoutRoom(roomNumber) != null){
            this.room.closeBreakoutRoom(roomNumber);
            return true;
        }
        return false; 
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        System.out.println(room.findParticipantBreakoutRoom(participantID));
        return room.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms()
    {
        for(int i = 0; i < 5; i++){
            String[] details = new String[5];
            details[i] = this.room.listBreakoutRooms();
            System.out.println(details[i]);
            return details[i];
        }
        return null;
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
        int i = 1;
        String[] details = new String[10];
        for(i = 1; i < 6; i++){
            details[i] += (listParticipants(i));
        }
        return details[i];
    }
    
    /* Sources:
     * https://www.java67.com/2012/11/how-to-read-file-in-java-using-scanner-example.html
     * Lab 3
     */

}