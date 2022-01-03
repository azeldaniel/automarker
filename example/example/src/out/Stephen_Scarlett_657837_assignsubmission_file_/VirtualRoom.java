package out.Stephen_Scarlett_657837_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (Stephen Scarlett, 816013791)
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        this.name = name;
        
        
        breakoutRooms = new BreakoutRoom[5];
        this.breakoutRoomLimit = 5;
    }
    
    public VirtualRoom(String name, int limit)
    {
        this.name = name;
        this.breakoutRoomLimit = limit;
        
        breakoutRooms = new BreakoutRoom[limit];
    }
    
    public int getNumberOfBreakoutRooms()
    {
        return this.breakoutRoomLimit;
    }
    
    public void createBreakoutRooms()
    {
        for(int i=0; i < this.breakoutRoomLimit; i++)
        {
            this.breakoutRooms[i] = new BreakoutRoom(this.name);   
        }
    }
         
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        String brID = this.name + roomNumber;
        
        for(int i=0; i<breakoutRoomLimit; i++){
            if(brID.equals(breakoutRooms[i].getBreakoutRoomID())){
                //System.out.println(this.breakoutRooms[i]);
                return breakoutRooms[i];
            }
        }
        
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        BreakoutRoom breakoutRoom1 = findBreakoutRoom(roomNumber);
        
        if(breakoutRoom1 == null)
        {
            return false;
        }        
        
        breakoutRoom1.closeBreakoutRoom();
        return true;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        BreakoutRoom breakoutRoom2 = findBreakoutRoom(roomNumber);
        
        if(breakoutRoom2 != null)
        {
            return false;
        }           
        
        breakoutRoom2.openBreakoutRoom();
        return true;
    }
       
    public String listBreakoutRooms(){
        System.out.println ("Virtual Room Name: " + name + "\n");
        System.out.println ("Breakout Rooms: \n");
        String details = "";
        
        for(int i=0; i<breakoutRoomLimit; i++){
            details += this.breakoutRooms[i].toString() + "\n";
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        if(findBreakoutRoom(roomNumber) != null){
            String details = "List of Participants: " + "\n";
            
            details += findBreakoutRoom(roomNumber).listParticipants();
            return details;
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        BreakoutRoom breakR = findBreakoutRoom(roomNumber);
        
        if(breakR == null)
        {
            System.out.println("Room does not exist\n");
            return false;
        }
        
        breakR.addParticipant(participantID);
        return true;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
       
        for(int i=1; i<=breakoutRoomLimit; i++)
        {
            BreakoutRoom breakR = findBreakoutRoom(i);
            
            if(breakR.findParticipant(participantID) != null){
                return breakR.getBreakoutRoomID();
            }
            
        }
        
        System.out.println("Participant not found");
        return null;
    }
}
