package out.Narin_Ramnehal_657843_assignsubmission_file_;// ID - 816015907

public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private int limit;
    private BreakoutRoom[] breakoutRooms; 
    
    private int numBreakoutRooms;
    
    // Constructor
    public VirtualRoom(String name)
    {
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    // Overloaded Contructor
    public VirtualRoom(String name, int limit)
    {
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[this.breakoutRoomLimit];
    }
    
    // Accessor
    public int getNumberOfBreakoutRooms( )
    {
        return breakoutRoomLimit;
    }

    // Methods 
    public void createBreakoutRooms()
    {
        for (int i = 0; i < 5; i ++) {
            breakoutRooms[i] = new BreakoutRoom(name);
            System.out.println("Breakout Room" + i + "-" + "WorkShop"+i);
        }
    } 
   
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        String roomID = this.name + roomNumber;  
        for (int i = 0; i < breakoutRoomLimit; i ++) {
            if (breakoutRooms[i].getBreakoutRoomID().equals(roomID)) {  
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        for (int i = 0; i < breakoutRoomLimit; i ++) {
            if (findBreakoutRoom(roomNumber) == breakoutRooms[i]) {
                breakoutRooms[i].closeBreakoutRoom();
                return true;
            }
        }
        return false;
    }  
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        for (int i = 0; i < breakoutRoomLimit; i ++) {
            if (findBreakoutRoom(roomNumber) == breakoutRooms[i]) {
                breakoutRooms[i].openBreakoutRoom();
                return true;
            }
        }
        return false;
    } 
    
    public String listBreakoutRooms() 
    {
        String details = this.name;
        System.out.println();
        for (int i = 0; i < breakoutRoomLimit; i ++) {
            details += "breakoutRoom_" + breakoutRooms[i];
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        String details = this.name;
        String roomID = this.name + roomNumber;
        boolean isBreakoutRoom = false;
        for (int i = 0; i < breakoutRoomLimit; i++){
            if (breakoutRooms[i].getBreakoutRoomID().equals(roomID)) {
                details += breakoutRooms[i].listParticipants();
                isBreakoutRoom = true;
            }
        }
        if (isBreakoutRoom == false) {
            return null;
        }
        else {
            return details;
        }
    }    
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    { 
        String roomID = this.name + roomNumber;
        for (int i = 0; i < numBreakoutRooms; i ++) {
             if (breakoutRooms[i].getBreakoutRoomID().equals(roomID)){
                breakoutRooms[i].addParticipant(participantID);
                return true;
            } 
        }
        return false;
    } 
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        for (int i = 0; i < limit; i ++) {
            breakoutRooms[i].findParticipant(participantID);
            System.out.println("BreakoutRoom: " + breakoutRooms[i]);
        }
        return null;
    }
}
