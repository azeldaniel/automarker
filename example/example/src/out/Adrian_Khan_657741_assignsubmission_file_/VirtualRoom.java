package out.Adrian_Khan_657741_assignsubmission_file_;
/*
 * StudentID: 816020488
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5]; //holds up to the limit
    }
    
    public VirtualRoom(String name, int limit)
    {
        // initialise instance variables
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit]; //holds up to the specified limit
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getNumberOfBreakoutRooms()
    {
        return breakoutRoomLimit;
    }

    public void createBreakoutRooms()
    {
        for(int i = 0; i < breakoutRoomLimit; i++){
            BreakoutRoom rooms = new BreakoutRoom(this.name); 
            this.breakoutRooms[i] = rooms;                      
        }
        System.out.println("Created BreakoutRooms"); 
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(name+roomNumber)){
                System.out.println("Found the BreakoutRoom!");
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(name+roomNumber)){
                breakoutRooms[i].closeBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(name+roomNumber)){
                breakoutRooms[i].openBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms()
    {
        String details = "";
        for(int i = 0; i < breakoutRoomLimit; i++){
            details += breakoutRooms[i].toString();
        }
        return name + "\n" + details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].getOpen() == true && breakoutRooms[i].getBreakoutRoomID().equals(name+roomNumber)){
                return breakoutRooms[i].listParticipants() + "\n";
            }
        }
        return null;
    } 
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        for(int i = 0; i < breakoutRoomLimit; i++){
            if(breakoutRooms[i].getBreakoutRoomID().equals(name+roomNumber)){  
                breakoutRooms[i].addParticipant(participantID);
                return true; 
            }               
        }
        return false;
    } 
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        for(int i = 0; i < breakoutRoomLimit; i++){ 
            if(breakoutRooms[i].findParticipant(participantID) != null){
                return participantID + " found in " + breakoutRooms[i].getBreakoutRoomID();
            }
        }
        return null;
    }
    /*
     * Sources:
     * Lab 2 
     * Lab 3
     */
}
