package out.Cameron_Sugden_657788_assignsubmission_file_;//816014699
public class VirtualRoom{

    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom(String name){
        System.out.println(name + ": Virtual Room is created...");
        this.name = name;
        this.breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit];
    }
    
    public int getNumberOfBreakoutRooms(){
        return this.breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        System.out.println("Breakout Room created for: " + name);
        for(int i = 0; i< this.breakoutRoomLimit; i++){
            this.breakoutRooms[i] = new BreakoutRoom(this.name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        String breakoutRoomID = this.name + roomNumber;
        for (int i = 0; i<this.breakoutRoomLimit; i++){
            if(this.breakoutRooms[i].getBreakoutRoomID().equals(breakoutRoomID)){
                return this.breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);
        
        if(br != null){
            br.closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);
        
        if(br!=null){
            br.openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String details = "Virtual Room Name: " + name + "\n";
        for(int i=0; i<this.breakoutRoomLimit; i++){
            details += this.breakoutRooms[i].toString() + "\n";
        }return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);

        if (br != null && br.getOpen()){
            System.out.println("-------------------------------------------------");
            return br.listParticipants();
        }
       return "Error";
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);

        if (br != null){
            br.addParticipant(participantID);
            return true;
        }
        System.out.println("An error occurred");
        return false;

    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for (int i = 0; i<breakoutRoomLimit; i++){
            BreakoutRoom b = findBreakoutRoom(i);
            if (b != null){
                if (b.findParticipant(participantID) != null){
                    return b.getBreakoutRoomID();
                }
            }
        }
        
        return null;
    }
}