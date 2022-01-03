package out.Shivam_Persad_657803_assignsubmission_file_;/** COMP2603 Assignment1
 *  Name: Shivam Persad
 *  ID: 816016854
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    //CONSTRUCTORS
    public VirtualRoom(String name)
    {
        this.name=name;
        this.breakoutRoomLimit=5;
        this.breakoutRooms = new BreakoutRoom[this.breakoutRoomLimit];
    }
    public VirtualRoom(String name,int limit){
        this.name=name;
        this.breakoutRoomLimit=limit;
        this.breakoutRooms = new BreakoutRoom[limit];
    }
    
    //METHODS
    public int getNumberOfBreakoutRooms(){
        return this.breakoutRoomLimit;
    }
    public void createBreakoutRooms(){
        for(int i=0;i<this.breakoutRoomLimit;i++){
            this.breakoutRooms[i]=new BreakoutRoom(this.name);
        }
    }
    public String listBreakoutRooms(){
        String list="Room Name: "+this.name+"\n";
        for(int i=0;i<this.getNumberOfBreakoutRooms();i++){
            list+=this.breakoutRooms[i].toString()+"\n";
        }
        System.out.println(list);
        return list;
    }
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i=0;i<this.getNumberOfBreakoutRooms();i++){
            if(i+1==roomNumber){
                return this.breakoutRooms[i];
            }
        }
        return null;
    }
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom found=findBreakoutRoom(roomNumber);
        if(found==null) return false;
        found.closeBreakoutRoom();
        return true;
    }
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom found=findBreakoutRoom(roomNumber);
        if(found==null) return false;
        found.openBreakoutRoom();
        return true;
    }
    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom bRoom=findBreakoutRoom(roomNumber);
        //System.out.println(findBreakoutRoom(roomNumber));
        if(bRoom==null) return null;
        return bRoom.listParticipants();
    }
    public boolean addParticipantToBreakoutRoom(String participantID,int roomNumber){
        BreakoutRoom bRoom=findBreakoutRoom(roomNumber);
        if(bRoom==null) return false;
        bRoom.addParticipant(participantID);
        return true;
    }
    public String findParticipantBreakoutRoom(String participantID){
        for(int i=0;i<this.getNumberOfBreakoutRooms();i++){
            if(this.breakoutRooms[i].findParticipant(participantID)!=null){
                return this.name;
            }
        }
        return null;
    }
}
