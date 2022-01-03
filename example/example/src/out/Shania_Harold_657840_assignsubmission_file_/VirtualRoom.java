package out.Shania_Harold_657840_assignsubmission_file_;// 816006213

/* NOTE: The first breakout room (BreakoutRoom1)
 * starts at position 0 in the array of breakout rooms.
 * i.e. openBreakoutRoom(0) would create a breakout room called
 * BreakoutRoom1
 * & openBreakoutRoom(1) would create a breakout room called
 * BreakoutRoom2.
 */
public class VirtualRoom{
    
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    private int brCount = 0;
    
    public VirtualRoom(String name){
        this.breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        this.name = name;
    }
    
    public String getVirtualRoomName(){
        return this.name;
    }

    public VirtualRoom(String name, int limit){
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        this.name = name;
    }
    
    public int getBreakoutRoomIDNum(String breakoutRoomID){
        char c = breakoutRoomID.charAt(breakoutRoomID.length() - 1);
        int num = Character.getNumericValue(c);
        num = num-1;
        return num;
    }
    
    public int getNumberOfBreakoutRooms(){
        //return brCount;
        return this.breakoutRoomLimit;
    }
    
    public int getNumberOfExistingBreakoutRooms(){
        return brCount;
    }
    
    public void createBreakoutRooms(){ // Fill array
        //breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        for (int i = 0; i < breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(getVirtualRoomName());
            breakoutRooms[i].openBreakoutRoom();
            brCount++;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for (int i = 0; i < brCount; i++){
            if (breakoutRooms[i].getBreakoutRoomCount() == roomNumber){
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        for (int i = 0; i < breakoutRoomLimit; i++){
            if (getBreakoutRoomIDNum(breakoutRooms[i].getBreakoutRoomID()) == roomNumber){
                breakoutRooms[i].closeBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){ // FIX
        for (int i = 0; i < breakoutRoomLimit; i++){
            //System.out.println(getBreakoutRoomIDNum(breakoutRooms[i].getBreakoutRoomID()));
            //int x = getBreakoutRoomIDNum(breakoutRooms[i].getBreakoutRoomID());
            if (getBreakoutRoomIDNum(breakoutRooms[i].getBreakoutRoomID()) == roomNumber){
                breakoutRooms[i].openBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String details = getVirtualRoomName() + "\n";
        for (int i = 0; i < breakoutRoomLimit; i++){
            details += breakoutRooms[i] + "\n";
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String details = getVirtualRoomName() + "\n";
        //BreakoutRoom breakoutRoom = new BreakoutRoom(name);
        //breakoutRooms[getNumberOfBreakoutRooms()] = breakoutRoom;
        //System.out.println(getNumberOfBreakoutRooms());
        
        /*for (int i = 0; i < getNumberOfExistingBreakoutRooms(); i++){
            //System.out.println(breakoutRooms[i].getBreakoutRoomCount());
            if (breakoutRooms[i].getBreakoutRoomCount() == roomNumber){
                return details + breakoutRooms[i].listParticipants();
            }
        }*/
        
        if (breakoutRooms[roomNumber] != null){
            details += breakoutRooms[roomNumber].listParticipants();
            return details;
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        //BreakoutRoom breakoutRoom = new BreakoutRoom(name);
        //breakoutRooms[getNumberOfBreakoutRooms()] = breakoutRoom;
        //System.out.println(getNumberOfBreakoutRooms());
        //System.out.println(getVirtualRoomName());
        for (int i = 0; i < getNumberOfExistingBreakoutRooms(); i++){
            //System.out.println(i);
            String id = breakoutRooms[i].getBreakoutRoomID();
            //System.out.println("id: " + id);
            //System.out.println("Breakoutroom NC: " + breakoutRooms[i].getBreakoutRoomNumberCounter());
            int idNum = getBreakoutRoomIDNum(id);
            //System.out.println("ID num: " + idNum);
            if (idNum == roomNumber){
                //System.out.println("Added");
                boolean flag = true;
                flag = breakoutRooms[i].addParticipant(participantID); // CHANGED: breakoutRooms[i]
                //System.out.println(flag);
                //System.out.println(breakoutRooms[i]);
                //System.out.println(i);
                if (flag == false){
                    //System.out.println("Participant not added.");
                    return false;
                }
                return flag;
            }
        }
        return false;
        
        //boolean flag = false;
        
        //flag = breakoutRooms[roomNumber].addParticipant(participantID);
        
        //return flag;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for (int i = 0; i < breakoutRoomLimit; i++){
            //System.out.println(breakoutRooms[i]); // prints out room as not open. could be issue :(
            if (breakoutRooms[i].findParticipant(participantID) != null){
                //System.out.println("inside if :)");
                return breakoutRooms[i].getBreakoutRoomID();
            }
        }
        return null;
    }
    
    public static void main(String[] args){
        VirtualRoom v1 = new VirtualRoom("Spanish");
        v1.createBreakoutRooms();
        v1.openBreakoutRoom(1);
        v1.addParticipantToBreakoutRoom("00000001", 1);
        //System.out.println(v1.breakoutRooms[0].getBreakoutRoomNumberCounter());
        System.out.println(v1.listParticipantsInBreakoutRoom(1));
        //System.out.println(v1.listBreakoutRooms());
        //System.out.println(v1.findParticipantBreakoutRoom("00000001"));
        //System.out.println(v1.getNumberOfBreakoutRooms());
        //System.out.println(v1.breakoutRooms[0]);
        //System.out.println(v1.breakoutRooms[1]);
    }
}
