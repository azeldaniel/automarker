package out.Shania_Rampersadsingh_657736_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author Shania Rampersadsingh 816016166
 * @version 10/2/2021
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
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    
    /**
     * Overloaded Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name,int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    /**
     *Returns the total number of breakout rooms
     *managed by the virtual room
     */
    public int getNumberOfBreakoutRooms()
    {
        // put your code here
        return breakoutRoomLimit;
    }
    
    /**
     *Creates new BreakoutRoom objects that fill the list
     *of breakout rooms
     */
    public void createBreakoutRooms()
    {
       
        int i = 0;
        
        for(i= 0; i < this.breakoutRoomLimit; i++)
        {
            this.breakoutRooms[i] = new BreakoutRoom(this.name);   
        }
        
    }
    
    /**
     * Locates and returns the breakout room with the
     * supplied room number, otherwise returns null
     */
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        // put your code here
        
        String brID = this.name + roomNumber;
        
        for(int i=0; i<breakoutRoomLimit; i++){
            if(brID.equals(breakoutRooms[i].getBreakoutRoomID())){
                //System.out.println(this.breakoutRooms[i]);
                return breakoutRooms[i];
            }
        }
        
        return null;
        
    }
    
    /**
     * Closes a breakout room with the supplied room
     * number if it exists
     */
    public boolean closeBreakoutRoom(int roomNumber)
    {
        // put your code here
        BreakoutRoom br = findBreakoutRoom(roomNumber);
        if(br != null){
            br.closeBreakoutRoom();
            return true;
        }
        
        return false;
        
    }
    
    /**
     * Opens a breakout room with the supplied room
     * number if it exists
     */
    public boolean openBreakoutRoom(int roomNumber)
    {
        BreakoutRoom br = findBreakoutRoom(roomNumber);
        if(br== null){
            br.openBreakoutRoom();
            return true;
        }
        
        return false;
        
    }
    
    
    /**
     * Returns a list of the breakout rooms managed by
     * the virtual room with the virtual room name heading
     * the list on a separate line
     */
    public String listBreakoutRooms()
    {
        // put your code here
        String breakoutRoomsList;
        int i;
        String breakoutRoomID;
        System.out.println("Name of Virtual Room: " + name + "\n");
        breakoutRoomsList ="" ; 
         for(i = 0; i < this.breakoutRoomLimit; i++){
             breakoutRoomID = this.name + (i);
             breakoutRoomsList += breakoutRoomID + "\n" ;
            }
        return breakoutRoomsList;
        
    }
    
    /**
     * Returns a list of the participants in the breakout
     * room with the supplied room number if found,
     * otherwise returns null
     */
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        String participantsList;
        participantsList = "";
        BreakoutRoom br = findBreakoutRoom(roomNumber);
        
        if (br == null){
            return null;
        }
        
        participantsList += br.listParticipants();
        return participantsList;
        
    }
    
    /**
     * Adds a new participant to the breakout room with
     * the supplied room number if it exists
     */
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        // put your code here
        BreakoutRoom br = findBreakoutRoom(roomNumber);
        
        if (br != null){
            br.addParticipant(participantID);
            return true;
        }
        System.out.println("Room not found.");
        return false;
    }
    
    /**
     * Locates and returns the breakoutRoomID for the
     * breakout room hosting the participant with the
     * (valid) supplied ID, otherwise returns null
     */
    public String findParticipantBreakoutRoom(String participantID)
    {
        // put your code here
        String roomHostingParticipant;
        //roomHostingParticipant = "Room hosting the participant with supplied ID: ";
        
        for (int i=0; i < this.breakoutRoomLimit ; i++)
        {
            BreakoutRoom br = findBreakoutRoom(i);
            if(br.findParticipant(participantID)!=null){
                //roomHostingParticipant += participantID;
                return br.getBreakoutRoomID();
            }
        }
        
        return null;
    }
    
}
