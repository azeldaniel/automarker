package out.Amara_Khan_657759_assignsubmission_file_;//816004460
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private static int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    public VirtualRoom(String name)
    {
        // initialise instance variables
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
        int j = 0;
        j = breakoutRooms.length;
        return j;
    }

    public void createBreakoutRooms(){
        for(int j =0;j<getNumberOfBreakoutRooms();j++ ){
            breakoutRooms[j] = new BreakoutRoom(name);
        }

    }


    public BreakoutRoom findBreakoutRoom (int roomNumber){
        for(int j =0;j<getNumberOfBreakoutRooms();j++ ){
        if(j == roomNumber)
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
        String list="Managed Rooms: ";
            for(int j= 0;j<getNumberOfBreakoutRooms(); j++){
                list += breakoutRooms[j].toString() + "\n";
            }
        return list;
    }

    public String listParticipantsInBreakoutRoom(int roomNumber){

        if(findBreakoutRoom(roomNumber)!=null){
            return breakoutRooms[roomNumber].listParticipants();
        }
        return null;
        }

    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){

        for(int j = 0;j<breakoutRoomLimit;j++){
        if((breakoutRooms[j].findParticipant(participantID) !=null) && (breakoutRooms[j].stateOpen() == true))
            return false;
        }

        breakoutRooms[roomNumber].addParticipant(participantID);
        return true;
    }

    public String findParticipantBreakoutRoom(String participantID){
        String room="";

        for(int j=0; j<breakoutRoomLimit; j++){
        if(breakoutRooms[j].findParticipant(participantID) != null){
            room+= breakoutRooms[j].setID();
            return room;
        }
     }
    return null;

    }
}