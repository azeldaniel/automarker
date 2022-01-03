package out.Justin_Mahabir_657709_assignsubmission_file_;//ID: 816000496
/**
 * Write a description of class VirtualRoom here.
 *
 * @author Justin Mahabir
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
   
    public VirtualRoom(String name)
    {
        this.name = name;
        this.breakoutRoomLimit = 5;
        breakoutRooms =  new BreakoutRoom[5];
    }
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms =  new BreakoutRoom[limit];
    }
    
    public int getNumberOfBreakoutRooms()
    {
        return this.breakoutRoomLimit;
    }
    public void createBreakoutRooms(){
        for(int x = 0; x < breakoutRoomLimit; x++){
            breakoutRooms[x] = new BreakoutRoom(name);
        }
    }
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        BreakoutRoom result = null;
        if(roomNumber >= 1 && roomNumber < this.breakoutRoomLimit){
            result = this.breakoutRooms[roomNumber - 1];
        }
        return result;
    }
    public boolean closeBreakoutRoom(int roomNumber){
        if(roomNumber >= 1 && roomNumber < this.breakoutRoomLimit){
            this.breakoutRooms[roomNumber - 1].closeBreakoutRoom();
            return true;
        }
        return false;
    }
    public boolean openBreakoutRoom(int roomNumber){
        if(roomNumber >= 1 && roomNumber < this.breakoutRoomLimit){
            this.breakoutRooms[roomNumber - 1].openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        
        String list="";
        String roomIDs="";
        list += "\n"+ name +":\n";
        if(breakoutRoomLimit == 0){
              roomIDs = "Virtual Room Empty.";
        }
        else{
            int x = 0;
            roomIDs = breakoutRooms[x].getBreakoutRoomID();
            roomIDs += "\n";
            x++;
            while(x < breakoutRoomLimit){
                roomIDs += breakoutRooms[x].getBreakoutRoomID();
                roomIDs += "\n";
                x++;
            }
            list += roomIDs;
        }
        return list;
    }
    public String listParticipantsInBreakoutRoom(int roomNumber){
        int rNum = roomNumber-1;
        if(rNum >= 0 && rNum < breakoutRoomLimit){
           return breakoutRooms[rNum].listParticipants(); 
        }
        return null;
    }
    public boolean addParticipantToBreakoutRoom( String participantID, int roomNumber){
        int rNum = roomNumber-1;
        boolean result = false;
        String ID = null;
        if(rNum >= 0 && rNum < 5){
            ID = findParticipantBreakoutRoom(participantID);
            if(ID == null){
                result = this.breakoutRooms[rNum].addParticipant(participantID);
                return result;
            }
        }
        return false;
    }
    public String findParticipantBreakoutRoom(String participantID){
        for(int x = 0; x < this.breakoutRoomLimit; x++){
            if(this.breakoutRooms[x].findParticipant(participantID) != null){
              return this.breakoutRooms[x].getBreakoutRoomID();  
            }
        }
        return null;
    }
}
