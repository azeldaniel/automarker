package out.Keston_Mitchell_657689_assignsubmission_file_;public class VirtualRoom
{
    private String name;
    private static int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    public VirtualRoom(String name)
    {
        this.breakoutRoomLimit = 5;
        this.name = name;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    public VirtualRoom(String name, int limit){
        this.breakoutRoomLimit = limit;
        this.name = name;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    public int getNumberOfBreakoutRooms(){
        int i = 0;
        i = breakoutRooms.length;
        return i;
    }

    public void createBreakoutRooms(){
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }

    }


    public BreakoutRoom findBreakoutRoom (int roomNumber){
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++){
        if(i == roomNumber){
            return breakoutRooms[roomNumber];
        }
        }
        return null;
    }

    public boolean closeBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) != null){
            breakoutRooms[roomNumber].closeBreakoutRoom();
            return true;
        }
    return false;
    }

    public boolean openBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) != null){
            breakoutRooms[roomNumber].openBreakoutRoom();
            return true;
        }
    return false;
    }

    public String listBreakoutRooms(){
        String list="Managed Rooms:";
            for(int i= 0; i < getNumberOfBreakoutRooms(); i++){
                list = list + breakoutRooms[i].toString() + "\n";
            }
        return list;
    }

    public String listParticipantsInBreakoutRoom(int roomNumber){

        if(findBreakoutRoom(roomNumber) != null){
            return breakoutRooms[roomNumber].listParticipants();
        }
        return null;
        }

    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){

        for(int i = 0; i < breakoutRoomLimit; i++){
        if((breakoutRooms[i].findParticipant(participantID) != null) && (breakoutRooms[i].stateOpen() == true))
            return false;
        }
        breakoutRooms[roomNumber].addParticipant(participantID);
        return true;
    }

    public String findParticipantBreakoutRoom(String participantID){
        String room = "";

        for(int i = 0; i < breakoutRoomLimit; i++){
        if(breakoutRooms[i].findParticipant(participantID) != null){
            room = room + breakoutRooms[i].setID();
            return room;
        }
     }
    return null;
    }
}