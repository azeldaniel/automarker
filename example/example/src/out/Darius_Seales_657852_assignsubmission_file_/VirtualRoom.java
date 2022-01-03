package out.Darius_Seales_657852_assignsubmission_file_;/**
 * Write a description of class VirtualRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom breakoutRoom[];
  
    public VirtualRoom(String Name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRoom = new BreakoutRoom[breakoutRoomLimit];
    }
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRoom = new BreakoutRoom[breakoutRoomLimit];
    }
    public int getNumberOfBreakoutRooms(){
        int numberOfRooms = 0;
        for(int a = 0; a < breakoutRoomLimit; a=a+1){
            if(breakoutRoom[a] != null)
            numberOfRooms = numberOfRooms + 1;
        }    
        return numberOfRooms;
    }
    public void createBreakoutRooms(){
        for(int a = 0; a < breakoutRoomLimit; a = a+1){
            breakoutRoom[a] = new BreakoutRoom(name);
        } 
    }
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        String roomID = name + roomNumber;
        for(int a = 0; a < breakoutRoomLimit; a = a +1){
            if(breakoutRoom[a].getbreakoutRoom() == roomID)
                return breakoutRoom[a];
        }
        return null;
    }
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom room = findBreakoutRoom(roomNumber);
        if(room != null){
            room.closeBreakoutRoom();
            return true;
        }
        return false;
    }
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom room = findBreakoutRoom(roomNumber);
        if(room != null){
            room.openBreakoutRoom();
            return true;
        }
        return false;
    }
     public String listBreakoutRooms(){
        String rooms = " Virtual Room: " + name + "\n";
        for(int a = 0; a < breakoutRoomLimit; a = a+1){
            rooms = rooms + breakoutRoom[a].getbreakoutRoom() + "\n" ;
        }
        return rooms ;
    }
     public String listParticipantsBreakoutRoom(int roomNumber){
        BreakoutRoom room = findBreakoutRoom(roomNumber);
        String list = room.listParticipants();
        if(room == null)
            return null;
        return list;
    }
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom room = findBreakoutRoom(roomNumber);
        return room.addParticipant(participantID);
    }
    public String findParticipantBreakoutRoom(String participantID){
        for(int a = 0; a < breakoutRoomLimit; a = a+1){
            if(breakoutRoom[a].findParticipant(participantID) != null)
            return breakoutRoom[a].getbreakoutRoom();
        }
        return null;
    }
}

