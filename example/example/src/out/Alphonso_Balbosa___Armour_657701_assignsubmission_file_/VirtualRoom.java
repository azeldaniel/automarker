package out.Alphonso_Balbosa___Armour_657701_assignsubmission_file_;//STUDENT I.D. == 816018750
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private String participantID;
    private BreakoutRoom[] breakoutRooms;
    private int roomNumber;
    

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        this.name = name;
        breakoutRoomLimit = 5;
        createBreakoutRooms();
    }
    
    public VirtualRoom(String name, int limit)
    {
        this.name = name;
        this.breakoutRoomLimit = limit;
        createBreakoutRooms();
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms()
    {
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        for(int i=0; i<breakoutRoomLimit; i++)
        {
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if((roomNumber <= breakoutRoomLimit) && (breakoutRooms[roomNumber-1] != null))
            return breakoutRooms[roomNumber-1];
        else
            return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        String temp = name + (roomNumber-1);
        if(findBreakoutRoom(roomNumber) == null){
            System.out.println("yes");
            return false;
        }
        if(breakoutRooms[roomNumber-1].getOpen() == true){
            breakoutRooms[roomNumber-1].closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        String temp = name + (roomNumber-1);
        if(findBreakoutRoom(roomNumber) == null){
            System.out.println("yes");
            return false;
        }
        if(breakoutRooms[roomNumber-1].getOpen() == false){
            breakoutRooms[roomNumber-1].openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String details = "Virtual Room: " + name + "\n";
        for(int i=0; i<breakoutRoomLimit; i++)
        {
            if(breakoutRooms[i] != null)
                details += name + i + "\n";
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String temp = name + (roomNumber-1);
        if(findBreakoutRoom(roomNumber) == null){
            System.out.println("yes");
            return null;
        }
        if(breakoutRooms[roomNumber-1].getOpen() == true){
            return breakoutRooms[roomNumber-1].listParticipants();
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        if(findBreakoutRoom(roomNumber) == null){
            return false;
        }
        if(breakoutRooms[roomNumber-1].getOpen() == true){
            breakoutRooms[roomNumber-1].addParticipant(participantID);
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for(int i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].findParticipant(participantID)!= null){
                System.out.println("found");
                return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        return null;
    }
}
