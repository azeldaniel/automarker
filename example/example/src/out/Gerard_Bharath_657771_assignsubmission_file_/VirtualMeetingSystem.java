package out.Gerard_Bharath_657771_assignsubmission_file_;/**
 * 
 *
 * @Gerard Bharath
 * 816020015
 * @version (a version number or a date)
 */



import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    private String[] participantFile = new String[50];
    private VirtualRoom virtualRoom;

    /**
     * Constructor for objects of class VirtualMeetingSystem
     */
    public void loadParticipantData(String filename)
    {
        int arrayCount= 0;
        try{
        File inputFile= new File("participant.dat");
        Scanner reader= new Scanner(inputFile);
            while(reader.hasNextLine()){
                participantFile[arrayCount]= reader.nextLine();
                System.out.println("Participant's ID: " +participantFile[arrayCount] +"\n");
                arrayCount++;        
            }
        reader.close();
        }
        catch(FileNotFoundException e){
        System.out.println("***Unfortunately An Error Has Occured***");
        e.printStackTrace();
        }        
    }
    
    

    public void createVirtualRoom(String name)
    {
        virtualRoom= new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code )
    {
        int numberOfBreakoutrooms= virtualRoom.getNumberOfBreakoutRooms();
        int count= 0;
        if(code.equals("C5")){
            for(int i= 0; i< numberOfBreakoutrooms; i++)
            {
                for(int j= 0; j< 10; j++){
                    virtualRoom.addParticipantToBreakoutRoom(participantFile[count], i);
                    count++;
                }
            }
        
        }
    
    }
    
    public boolean addParticipant(String participantID, int roomNumber)
    {
        if(virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber)== true)
        {
        return true;        
        }
        return false;
    }
    
    public String listParticipants(int roomNumber)
    {
        String details= null;
        details= virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        System.out.println(details);
        return details;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        if(virtualRoom.openBreakoutRoom(roomNumber)== true)
        {
            return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        if(virtualRoom.closeBreakoutRoom(roomNumber)== true){
            return true;
        }
        return false;
    }    
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        String findRoom;
        findRoom = virtualRoom.findParticipantBreakoutRoom(participantID);
        System.out.println(findRoom);
        return findRoom;
    }
    
    public String listAllBreakoutRooms()
    {
        String listRooms;
        listRooms = virtualRoom.listBreakoutRooms();
        System.out.println(listRooms);
        return listRooms;
    }
    
    
    public String listParticipantsInAllBreakoutRooms()
    {
        int room = virtualRoom.getNumberOfBreakoutRooms();
        String participantsInRoom = null;
        for(int i = 0; i < room; i++){
            participantsInRoom = virtualRoom.listParticipantsInBreakoutRoom(i);
        }
        return participantsInRoom;
    }
    
    
    
}
