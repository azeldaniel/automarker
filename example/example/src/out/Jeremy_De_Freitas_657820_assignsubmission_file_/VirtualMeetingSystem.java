package out.Jeremy_De_Freitas_657820_assignsubmission_file_;//816018479
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class VirtualMeetingSystem
{
    private VirtualRoom newVirtualRoom; 
    private String[] dataFile = new String[50]; 
    
    public void loadParticipantData(String filename) throws Exception
    {

        File file = new File(filename);
        Scanner keyboard = new Scanner(file);
        boolean isPresent = file.exists();

        if(isPresent == false){
            System.out.println("File not found!");    
            return;
        }
        
        int count = 0;
        while(keyboard.hasNextLine())
        {
            dataFile[count] = keyboard.nextLine();
            
            System.out.println("ID: " + dataFile[count] + "\n");
            
            count++; 
            
        }
        keyboard.close();
    }

    
    public void createVirtualRoom(String name)
    {
        newVirtualRoom = new VirtualRoom(name);
        newVirtualRoom.createBreakoutRooms();
    }

        
    public void allocateParticipants(String code){
        int count, count1, count2, count3;
        count = 0;
        count1 = 0;
        count2 = 0;
     
        int total = newVirtualRoom.getNumberOfBreakoutRooms();
        
        
        while(count < total){
                
                while(count1 < 10)
                {
                newVirtualRoom.addParticipantToBreakoutRoom(dataFile[count2], count);
                count1++;
                count2++;
                }
                count1 = 0; 
                count++;
            }
        
        System.out.println("\n");
        System.out.println("No more participants can be added.");
        return;
    }

    public boolean addParticipant(String participantID, int roomNumber){

        if(newVirtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber))
        {
            return true;
        }
        return false;
    }
    
    
    public String listParticipants(int roomNumber)
    {
        String Partlist = " ";
        Partlist += newVirtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        System.out.println(Partlist);
        return Partlist;
    }

    
    public boolean openBreakoutRoom(int roomNumber)
    {
        if(newVirtualRoom.openBreakoutRoom(roomNumber))
        {
            System.out.println("BreakOut room opened!");
            return true;
        }
        else
        {
            System.out.println("BreakOut Room already open!");
            return false;
        }    
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        if(newVirtualRoom.closeBreakoutRoom(roomNumber))
        {
            System.out.println("BreakOut Room closed!");
            return true;
        }
        else
        {
            System.out.println("BreakOut Room already closed!");
            return false;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    { 
        return newVirtualRoom.findParticipantBreakoutRoom(participantID);
        
    }
   
    public String listAllBreakoutRooms()
    {
        System.out.println(newVirtualRoom.listBreakoutRooms());
        return newVirtualRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
        System.out.println("The total number of Breakout rooms are: " + newVirtualRoom.getNumberOfBreakoutRooms());
        System.out.println("\n");

        int count = 0;
        String participant = " ";
        while(count < newVirtualRoom.getNumberOfBreakoutRooms())
        {
          participant += newVirtualRoom.listParticipantsInBreakoutRoom(count) + "\n";
          count++; 
        }
        
        System.out.println(participant);
        return participant;        
    }

}