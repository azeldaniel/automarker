package out.Chantel_Lewis_657735_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author 816011391
 * @version 06/03/2021
 */
public class VirtualRoom 
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    private int totalBreakoutRooms = 0;

    public VirtualRoom(String name)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit)
    {
        this.breakoutRoomLimit = limit;
        this.name = name;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms()
    {
        this.totalBreakoutRooms = breakoutRooms.length; 
        return totalBreakoutRooms;
    }
    
    public void createBreakoutRooms()
    {
        int count;
        for(count = 0; count < getNumberOfBreakoutRooms(); count++)
        {
            breakoutRooms[count] = new BreakoutRoom(name);
        }
        /*BreakoutRoom bR1 = new BreakoutRoom(name);
        BreakoutRoom bR2 = new BreakoutRoom(name);
        BreakoutRoom bR3 = new BreakoutRoom(name);
        BreakoutRoom bR4 = new BreakoutRoom(name);
        BreakoutRoom bR5 = new BreakoutRoom(name);
        */
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        int count;
        for(count = 0; count < getNumberOfBreakoutRooms(); count++)
        {
            //if the room number is equal to the counter, we return the Breakout Room
            //at that location in the array.
            if(count == roomNumber)
            {
                return breakoutRooms[roomNumber];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        //search for breakout room with given room number, 
        //if it is found we close that breakout room.
        if(findBreakoutRoom(roomNumber) != null)
        {
            breakoutRooms[roomNumber].closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        int i = 0;
        if(breakoutRooms[i].equals(roomNumber))
        {
            breakoutRooms[i].openBreakoutRoom();
            return true;
        }
        
        return false;
    }
    
    public String listBreakoutRooms()
    {
        String details = "";
        System.out.println("Rooms Managed By: " + name + "\n");
        int count;
        for(count = 0; count < getNumberOfBreakoutRooms(); count++)
        {
            details += breakoutRooms[count].toString() + "\n";
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        //if breakout rooom is found, 
        //return the list of participants in that room with the given room number.
        if(findBreakoutRoom(roomNumber) != null)
        {
            return breakoutRooms[roomNumber].listParticipants();
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        int count;
        for(count = 0; count <= breakoutRoomLimit; count++)
        {
            //if the breakout room is open, search for a participant in the breakout room. 
            //if the participant is in the room they cannot be added to the room, 
            //thus return false.
            if(breakoutRooms[count].getOpen() == true && 
                breakoutRooms[count].findParticipant(participantID) != null)
                {
                    return false;
                }
        }
        //else add the participant to the breakout room with the given room number
        breakoutRooms[roomNumber].addParticipant(participantID);
        return true;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        //search for and return the breakout room which hosts the participant.
        //first verify that the participant id is valid
        int count;
        String roomDetails = "";
        for(count = 0; count < breakoutRoomLimit; count++)
        {
            if(breakoutRooms[count].findParticipant(participantID) != null)
            {
                roomDetails += breakoutRooms[count].setBreakoutRoomID();
                return roomDetails;
            }
        }
        return null;
    }
}
