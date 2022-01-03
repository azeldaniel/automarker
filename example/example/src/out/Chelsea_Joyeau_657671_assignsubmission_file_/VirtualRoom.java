package out.Chelsea_Joyeau_657671_assignsubmission_file_;/**
 * Chelsea Joyeau ~ 816020515
 * Object Oriented Programming
 * Assignment 1.0 ~ Virtual Meeting
 */

public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;    
    
    public VirtualRoom(String name)
    {
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    /*Overloaded constructor. Initialises the breakoutRoomLimit to the supplied limit */
    public VirtualRoom(String name, int limit)
    {
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[this.breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms() 
    {
        return this.breakoutRoomLimit;
    } 
    
    public String getVirtualRoomName() 
    {
        return this.name;
    }
    
    /*Creates new BreakoutRoom objects that fill the list of breakout rooms */
    public void createBreakoutRooms()
    {
        for (int i = 0; i < breakoutRoomLimit; i++)
        {
            BreakoutRoom breakoutRoom = new BreakoutRoom(getVirtualRoomName());
            breakoutRooms[i] =  breakoutRoom;
            System.out.println (breakoutRooms[i].toString());
        }
    } 
   
    /*Locates and returns the breakout room with the supplied room number, otherwise returns null */
    public BreakoutRoom findBreakoutRoom(int roomNumber) 
    {
        String tempID = this.name + roomNumber;
        for (int i = 0; i < breakoutRoomLimit; i++)
        {
            if (breakoutRooms[i].getBreakoutRoomID().equals(tempID))
            {
                return breakoutRooms[i];
            }             
        }
        System.out.println ("Breakout Room With Room Number " +roomNumber+ " Does Not Exist."); 
        return null;
    }
    
    /*Closes a breakout room with the supplied room number if it exists */
    public boolean closeBreakoutRoom(int roomNumber) 
    {
        for (int i = 0; i < breakoutRoomLimit; i++) 
        {
            if (breakoutRooms[i].getBreakoutRoomNumber() == roomNumber) 
            {
                breakoutRooms[i].closeBreakoutRoom();
                breakoutRooms[i].toString();
                return true;
            }
        }
        return false;
    }
    
    /*Opens a breakout room with the supplied room number if it exists */
    public boolean openBreakoutRoom(int roomNumber) 
    {
        for (int i = 0; i < breakoutRoomLimit; i++) 
        {
            if (breakoutRooms[i].getBreakoutRoomNumber() == roomNumber) 
            {
                breakoutRooms[i].openBreakoutRoom();
                breakoutRooms[i].toString();
                return true;
            }
        }
        return false;
    }
        
    /*Returns a list of the breakout rooms managed by the virtual room with the 
     * virtual room name heading the list on a separate line
     */
    public String listBreakoutRooms() 
    {
        String details = ("\nVIRTUAL ROOM: " +this.name +"\n");
        for (int i = 0; i < getNumberOfBreakoutRooms(); i++)
        { 
                details += (breakoutRooms[i].getBreakoutRoomID() +"\n");
        }    
        return details;         
    }
    
    /*Returns a list of the participants in the breakout room with the supplied room
     * number if found, otherwise returns null
     */
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        String details = ("\nVIRTUAL ROOM NAME: " +this.name +"\n");
        String tempID = this.name + roomNumber;
        boolean foundBreakoutRoom = false;
        
        for (int i = 0; i < breakoutRoomLimit; i++)
        {
            if (breakoutRooms[i].getBreakoutRoomID().equals(tempID))
            {
                 details += breakoutRooms[i].listParticipants();
                 foundBreakoutRoom = true;
            }   
        }    
        if (foundBreakoutRoom == false)
        {
            return null;
        }
        
        else {
            return details;
        }
    }
  
    
    /*Adds a new participant to the breakout room with the supplied room number if it exists */
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber) 
    {
        String tempID = this.name + roomNumber;
        for (int i = 0; i < getNumberOfBreakoutRooms(); i++)
        {
            if (breakoutRooms[i].getBreakoutRoomID().equals(tempID)){
                breakoutRooms[i].addParticipant(participantID);
                return true;
            } 
        }
        return false;
    }
    
    /*Locates and returns the breakoutRoomID for the breakout room hosting the participant 
     * with the (valid) supplied ID, otherwise returns null
     */
    public String findParticipantBreakoutRoom(String participantID) 
    {        
        if ((participantID == null)) 
        {
            System.out.println("Error, ParticipantID Is Invalid.");
            return null;
        }

        for (int i = 0; i < getNumberOfBreakoutRooms(); i++) 
        {
            if (breakoutRooms[i].findParticipant(participantID) != null) {
                System.out.println ("\nParticipant: " +participantID +" Found In Breakout Room: " +breakoutRooms[i].getBreakoutRoomID());
                return breakoutRooms[i].getBreakoutRoomID();
            }

        }
        System.out.println ("\nParticipant: " +participantID +" Is Not Located In Any Breakout Room.");
        return null;
    }
}
