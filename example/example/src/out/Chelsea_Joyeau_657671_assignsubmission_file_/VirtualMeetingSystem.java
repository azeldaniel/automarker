package out.Chelsea_Joyeau_657671_assignsubmission_file_;
import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Chelsea Joyeau ~ 816020515
 * Object Oriented Programming
 * Assignment 1.0 ~ Virtual Meeting
 */

public class VirtualMeetingSystem
{
   private String participants[] = new String[50]; 
   private int loc = -1;
   private int numParticipants = 0;
   private VirtualRoom newVirtualRoom;
   
   public VirtualMeetingSystem()
   {
        
   }
   
   /*Read data from a file and loads the data into an array for allocation to breakout rooms */
   public void loadParticipantData(String filename) 
    { 
        boolean FileReadSuccessfully = false;

        try 
        {
            File myObj = new File(filename);
            Scanner myReader = new Scanner (myObj);
            
            while (myReader.hasNextLine()) 
            {
                participants[++loc] = myReader.nextLine();
                System.out.println("Participant ID:" +participants[loc] +" At Array Location " +loc);
                numParticipants++;
            }
            FileReadSuccessfully = true;
            myReader.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        if (FileReadSuccessfully == true)
        {
            System.out.println("Input File: " +filename+ " Successfully Read " +numParticipants+ " Participants");
        }
    }
   
    /*Creates a virtual room with the supplied name, containing 5 breakout rooms */
    public void createVirtualRoom(String name)
    {
        this.newVirtualRoom = new VirtualRoom(name);
        System.out.println("\nNAME OF VIRTUAL ROOM: " +name +"\n");
        newVirtualRoom.createBreakoutRooms();
    }
   
    /*Allocates participants to the breakout rooms of a virtual room using a strategy 
     * determined by the supplied code
     */
    public void allocateParticipants(String code){
        int roomNumber = 1;
        int cluster = 0;
        
        if (code == "C5") //  Allocates participants to the virtual rooms in a clusters of 5.
        {
            for (int i = 0; i < numParticipants; i++)
            {   
                if(this.newVirtualRoom.findBreakoutRoom(roomNumber) != null)
                {
                    this.newVirtualRoom.addParticipantToBreakoutRoom(participants[i], roomNumber);
                    cluster++;
                    
                    if  (cluster == 5)
                    {
                        cluster = 0;
                        roomNumber++;
                    }
                    
                    if (roomNumber == 6)
                    {
                        roomNumber = 1;
                    }
                }
            }
        }
        else if (code == "RR") //  //  Allocates participants to the virtual rooms in a round robin fashion. 
        {
                for (int j = 0; j < numParticipants; j++)
                {
                    if(this.newVirtualRoom.findBreakoutRoom(roomNumber) != null)
                    {
                        this.newVirtualRoom.addParticipantToBreakoutRoom(participants[j], roomNumber);
                        cluster++;
                        
                        if  (cluster == 1){
                            cluster = 0;
                            roomNumber++;
                        }
                        
                        if (roomNumber == 6){
                            roomNumber = 1;
                        }
                    }
                }
        }
        else 
        {
            System.out.println("\nInvalid Code.");
        } 
    }
    
    /*Adds a new participant to the breakout room with the supplied room number if it exists */
    public boolean addParticipant (String participantID, int roomNumber)
    {
        if (this.newVirtualRoom.findBreakoutRoom(roomNumber) != null)
        {
            this.newVirtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    /*Returns a list of the participants in the breakout room with the supplied room
     * number if found, otherwise returns null
     */
    public String listParticipants(int roomNumber)
    {
        if (this.newVirtualRoom.findBreakoutRoom(roomNumber) != null)
        {
            return (this.newVirtualRoom.listParticipantsInBreakoutRoom(roomNumber));
        }
        else 
        {
            return null;
        }
    }
    
    /*Opens a breakout room with the supplied room number if it exists */
    public boolean openBreakoutRoom(int roomNumber) 
    {
        if (this.newVirtualRoom.findBreakoutRoom(roomNumber) != null)
        {
            System.out.println ("\nBreakout Room With Room Number: " +roomNumber +" Found.");
            return (this.newVirtualRoom.openBreakoutRoom(roomNumber));
        }
        else 
        {
            System.out.println ("\nBreakout Room With Room Number: " +roomNumber +" Not Found!");
            return false;
        }
    }
    
    /*Closes a breakout room with the supplied room number if it exists */
    public boolean closeBreakoutRoom(int roomNumber) 
    {
        if (this.newVirtualRoom.findBreakoutRoom(roomNumber) != null)
        {
            System.out.println ("\nBreakout Room With Room Number: " +roomNumber +" Found.");
            return (this.newVirtualRoom.closeBreakoutRoom(roomNumber));
        }
        else 
        {
            System.out.println ("\nBreakout Room With Room Number: " +roomNumber +" Not Found!");
            return false;
        }
    }
    
    /*Locates and returns the breakoutRoomID for the breakout room hosting the 
     * participant with the (valid) supplied ID, otherwise returns null
     */
    public String findParticipantBreakoutRoom(String participantID) 
    {
        if (this.newVirtualRoom.findParticipantBreakoutRoom(participantID) != null)
            return this.newVirtualRoom.findParticipantBreakoutRoom(participantID);
        
        else
            return null;
    }
    
    /*Returns a list of the breakout rooms managed by the virtual room */
    public String listAllBreakoutRooms() 
    {
        return (this.newVirtualRoom.listBreakoutRooms());
    }
       
    /*Returns a list of all of the participants per breakout room managed by the 
     * virtual room, otherwise returns null
     */
    public String listParticipantsInAllBreakoutRooms() 
    {
        String details = "";
        boolean breakoutRoomCreated = false;
        for (int j = 1; j < (this.newVirtualRoom.getNumberOfBreakoutRooms() + 1); j++)
        {
            details += (listParticipants(j));
            breakoutRoomCreated = true;
         }
        
        if( breakoutRoomCreated == true)
        {
            return details;
        }
        else
        {
            return null;
        }
    }
}
