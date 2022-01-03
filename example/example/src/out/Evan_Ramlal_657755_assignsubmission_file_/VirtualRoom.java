package out.Evan_Ramlal_657755_assignsubmission_file_;
/**
 * Evan Ramlal
 * 813117763
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    //constructor // VIrtualRoom v1 = new VirtualROom("cock); v1.createBreakoutRooms(();
    public VirtualRoom(String name)
    {
        this.name = name;
        breakoutRooms = new BreakoutRoom[5];
        this.breakoutRoomLimit = 5;
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRooms = new BreakoutRoom[limit];
        this.breakoutRoomLimit = limit;
    }

    public int getNumberOfBreakoutRooms(){
        return this.breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        for (int i = 0; i < this.breakoutRoomLimit; i++) {
            this.breakoutRooms[i] = new BreakoutRoom(this.name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        String breakoutRoomID = this.name + roomNumber;
        for (int i = 0; i < this.breakoutRoomLimit; i++) {
            if (this.breakoutRooms[i].getBreakoutRoomID().equals(breakoutRoomID)){
                return this.breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom b1 = findBreakoutRoom(roomNumber);
        if (b1 != null) {
            b1.closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom b1 = findBreakoutRoom(roomNumber);
        if (b1 != null) {
            b1.openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String list = this.name + "\n";
        for (int i = 0; i < this.breakoutRoomLimit; i++) {
            list += this.breakoutRooms[i].toString() + "\n";
        }
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom b1 = findBreakoutRoom(roomNumber);
        if (b1 != null) {
            return b1.listParticipants();
        }
        return "room invalid";
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom b1 = findBreakoutRoom(roomNumber);
        if (b1 != null) {
            b1.addParticipant(participantID);
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for (int i = 0; i < breakoutRoomLimit; i++) {
            BreakoutRoom b1 = findBreakoutRoom(i);
            if (b1 != null) {
                if (b1.findParticipant(participantID) != null){
                    return b1.getBreakoutRoomID();
                }
            }
        }
        return null;
    }

    public static void tester(){
        VirtualRoom v1 = new VirtualRoom("COMP");
        v1.createBreakoutRooms();
        System.out.println(v1.getNumberOfBreakoutRooms());
        System.out.println(v1.findBreakoutRoom(1));
        System.out.println(v1.closeBreakoutRoom(1));
        System.out.println(v1.openBreakoutRoom(1));
        System.out.println(v1.listBreakoutRooms());
        v1.addParticipantToBreakoutRoom("12345678", 1);
        v1.addParticipantToBreakoutRoom("12945678", 1);
        System.out.println(v1.listBreakoutRooms());
        System.out.println(v1.listParticipantsInBreakoutRoom(1));
        System.out.println(v1.findParticipantBreakoutRoom("12345678"));
        v1.closeBreakoutRoom(1);
        System.out.println(v1.listParticipantsInBreakoutRoom(1));

        VirtualRoom v2 = new VirtualRoom("INFO", 2);
    }

    public static void main(String[] args) {
        //tester();
    }
    
    
}
