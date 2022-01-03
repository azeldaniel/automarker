package out.Leeia_Ahyew_657830_assignsubmission_file_;//816016640

public class VirtualRoom
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
        int count = 0;
        count = breakoutRooms.length;
        return count;
    }

    public void createBreakoutRooms(){
        for(int count =0;count<getNumberOfBreakoutRooms();count++ ){
            breakoutRooms[count] = new BreakoutRoom(name);
        }

    }


    public BreakoutRoom findBreakoutRoom (int roomNumber){
        for(int count =0;count<getNumberOfBreakoutRooms();count++ ){
        if(count == roomNumber)
            return breakoutRooms[roomNumber];
        }
        return null;
    }

    public boolean closeBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber)!=null){
            breakoutRooms[roomNumber].closeBreakoutRoom();
            return true;
        }
    return false;
    }

    public boolean openBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber)!=null){
            breakoutRooms[roomNumber].openBreakoutRoom();
            return true;
        }
    return false;
    }

    public String listBreakoutRooms(){
        String roomlist="Breakout rooms: ";
            for(int count= 0;count<getNumberOfBreakoutRooms(); count++){
                roomlist += breakoutRooms[count].toString() + " ";
            }
        return roomlist;
    }

    public String listParticipantsInBreakoutRoom(int roomNumber){

        if(findBreakoutRoom(roomNumber)!=null){
            return breakoutRooms[roomNumber].listParticipants();
        }
        return null;
        }

    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){

        for(int count = 0;count<breakoutRoomLimit;count++){
        if((breakoutRooms[count].findParticipant(participantID) !=null) && (breakoutRooms[count].stateOpen() == true))
            return false;
        }

        breakoutRooms[roomNumber].addParticipant(participantID);
        return true;
    }

    public String findParticipantBreakoutRoom(String participantID){
        String room="";

        for(int count=0; count<breakoutRoomLimit; count++){
        if(breakoutRooms[count].findParticipant(participantID) != null){
            room+= breakoutRooms[count].setID();
            return room;
        }
     }
    return null;

    }
}

