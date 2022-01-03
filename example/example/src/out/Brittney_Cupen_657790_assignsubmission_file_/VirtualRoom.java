package out.Brittney_Cupen_657790_assignsubmission_file_;//Brittney Cupen 816022438

public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom(String name){
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit];
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        for(int i=0; i<breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if(roomNumber < 1 || roomNumber > breakoutRoomLimit){
            return null; //no such room
        }
        return breakoutRooms[roomNumber - 1];
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(roomNumber < 1 || roomNumber > breakoutRoomLimit){
            return false; //unsuccessful
        }
        breakoutRooms[roomNumber - 1].closeBreakoutRoom();
        if(breakoutRooms[roomNumber - 1].getOpen() == false){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(roomNumber < 1 || roomNumber > breakoutRoomLimit){
            return false; //unsuccessful
        }
        breakoutRooms[roomNumber - 1].openBreakoutRoom();
        if(breakoutRooms[roomNumber - 1].getOpen() == true){
            return true;
        }else{
            return false;
        }
    }
    
    public String listBreakoutRooms(){
        String list = name + "\n";
        for(int i=0; i<breakoutRoomLimit; i++){
            list += (breakoutRooms[i].toString() + "\n");
        }
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom b = findBreakoutRoom(roomNumber);
        if(b == null){
            System.out.println("No such room found");
            return null;
        }
        return b.listParticipants();
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);
        if(br == null){
            System.out.println("No such room exists");
            return false; //unsuccessful
        }
        if(br.addParticipant(participantID)){
            return true; //successful
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        Participant p;
        for(int i=0; i<breakoutRoomLimit; i++){
            p = breakoutRooms[i].findParticipant(participantID);
            if(p != null){
                return breakoutRooms[i].toString();
            }
        }
        return null;
    }
}
