package out.Govinda_Ramcharan_657806_assignsubmission_file_;/**
 * @author Govinda Ramcharan 816003108
 * 
 */
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
     
    private VirtualRoom virtualRooms; //creates an instance of virtualRoom class
    String[] arrayID = new String[50]; //array used to save the participant IDs in the participant.dat file

    public void  loadParticipantData(String filename )
    {
        //code modified from https://www.w3schools.com/java/java_files_read.asp
    
        try 
        {
            int load = 0;
            File myFile = new File(filename);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) 
            {
                arrayID[load] = myReader.nextLine();
                load++;
            }
            myReader.close(); 
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    

    public void createVirtualRoom(String name)
    {
        virtualRooms = new VirtualRoom(name); //creates a virtualRoom with the specified name that is passed in
        virtualRooms.createBreakoutRooms(); //5 breakout rooms are created 
    }

 
    public boolean addParticipant (String participantID, int roomNumber)
    {
        return virtualRooms.addParticipantToBreakoutRoom(participantID, roomNumber); //calls the addParticipantToBreakoutRoom method in the virtualRoom class, adds the specified 
                                                                                     //participantID to the breakout room that corresponds to the room number that is passed in
    }

   
    public void allocateParticipants(String code)
    { 
        int breakoutRoomNumCounter = 100; //matches the breakoutRoomNumberCounter from breakoutRoom class so that the correct breakoutRoom is referenced when adding participant IDs
        int pIDCounter = 0; //used to iterate throught the entire array of stored IDs 
    
        if(code.equals("C5"))
        {
            while(pIDCounter < 50) 
            {
                for(int i = 0; i < virtualRooms.getNumberOfBreakoutRooms(); i++)
                {
                    for(int k = 0; k < 5; k++) //calls .addParticipantToBreakoutRoom method 5 times thus allocating 5 participant IDs to the specificed breakoutRoom
                    {
                        virtualRooms.addParticipantToBreakoutRoom(arrayID[pIDCounter],breakoutRoomNumCounter);
                        pIDCounter++; //increments each time ensuring that all of the IDs stored in the array are allocated 
                    }
                    breakoutRoomNumCounter++; //increments each time ensuring that all of the breakout Rooms are each allocated 5 participant IDs at a time
                }
                if(pIDCounter != 50) //while the counter is less than the size of the array it resets the breakoutRoomNumCounter to 100 
                  //after half of the array is added it goes back to the first breakoutRoom and starts adding IDs in clusters of 5 again until the counter reaches the size of the array
                { 
                    breakoutRoomNumCounter = 100;
                }
            }
        }
    }
  
    public String listParticipants(int roomNumber)
    {
        return virtualRooms.listParticipantsInBreakoutRoom(roomNumber);
    }
  
    public boolean openBreakoutRoom(int roomNumber)
    {
        return virtualRooms.openBreakoutRoom(roomNumber);
    }
  
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        return virtualRooms.closeBreakoutRoom(roomNumber);
    }
  
    
    public String findParticipantBreakoutRoom (String participantID)
    {
        return virtualRooms.findParticipantBreakoutRoom(participantID);
    }  
  
 
    public String listAllBreakoutRooms( )
    {
        return virtualRooms.listBreakoutRooms(); 
    }
    
    
    public String listParticipantsInAllBreakoutRooms()
    {
        String participantList = "";
        int breakoutRoomNumCounter = 100;
      
        for(int i = 0; i < virtualRooms.getNumberOfBreakoutRooms(); i++){
            participantList += virtualRooms.listParticipantsInBreakoutRoom(breakoutRoomNumCounter);
            breakoutRoomNumCounter++;
        }
      
        return participantList;   
    }
    
}
