package out.Brandon_Noray_657718_assignsubmission_file_;

/**
 * Write a description of class VirtualRoom here.
 *
 * @author (816018360 | Brandon Noray)
 * @version (v1.6.9)
 */
public class VirtualRoom
{
    /** Variables **/
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    
    /** Constructors **/
    public VirtualRoom(String name)
    {
        // initialise instance variables
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[this.breakoutRoomLimit];
    }


    public VirtualRoom(String name, int limit)
    {
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[this.breakoutRoomLimit];
    }
    
    /** Methods **/
    public int getNumberOfBreakoutRooms() //Re-do
    {
        //This makes more sense
        /*int count = 0;
        for(int i=0; i < this.breakoutRoomLimit; i++){
            try {
                if(this.breakoutRooms[i].getBreakoutRoomID() != "")
                    count++;
            } catch (NullPointerException e) {
                break;
            }
        }
        return count;*/
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms()
    {
        //Code
        for(int i=0; i < this.breakoutRoomLimit; i++){
            this.breakoutRooms[i] = new BreakoutRoom(this.name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        //Code
        /*for(int i=0; i < this.getNumberOfBreakoutRooms(); i++){
            if(this.breakoutRooms[i].counter == roomNumber){
                return this.breakoutRooms[i];
            }
        }*/
        if(roomNumber <= this.getNumberOfBreakoutRooms())
            return this.breakoutRooms[roomNumber-1];
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        //Code
        BreakoutRoom room = findBreakoutRoom(roomNumber);
        if(room == null)
            return false;
            
        room.closeBreakoutRoom();
        return true;
    }
    
        
    public boolean openBreakoutRoom(int roomNumber)
    {
        //Code
        BreakoutRoom room = findBreakoutRoom(roomNumber);
        if(room == null)
            return false;
            
        room.openBreakoutRoom();
        return true;
    }
    
    public String listBreakoutRooms()
    {
        //Code
        String list = "";
        list += "Virtual Room Name: " + this.name + "\n";
        list += "===========" + "\n";
        for(int i=0; i<this.getNumberOfBreakoutRooms(); i++){
            //System.out.println(this.breakoutRooms[i].breakoutRoomID);
            list += this.breakoutRooms[i].toString() + "\n";
        }
        
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        //Code
        BreakoutRoom room = findBreakoutRoom(roomNumber);
        if(room == null)
            return null;
            
        return room.listParticipants();
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        //Code
        BreakoutRoom room = findBreakoutRoom(roomNumber);
        if(room == null)
            return false;
        
        room.addParticipant(participantID);
        return true;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        //Code
        for(int i=0; i < this.getNumberOfBreakoutRooms(); i++)
        {
            if(this.breakoutRooms[i].findParticipant(participantID) != null){
                return this.breakoutRooms[i].getBreakoutRoomID();
            }
        }

        return null;
    }
}
