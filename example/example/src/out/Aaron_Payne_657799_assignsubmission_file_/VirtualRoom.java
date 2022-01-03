package out.Aaron_Payne_657799_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author Aaron Payne | ID: 816009846
 * @version 05/02/2021
 */
public class VirtualRoom
{

    private String name;
    public int breakoutRoomLimit=0;
    public BreakoutRoom[] breakoutRooms;
     
    public VirtualRoom (String name){
        breakoutRoomLimit=5;
    }
    
    public VirtualRoom (String name, int limit){
        breakoutRoomLimit=limit;
    }
    
    public int getNumberOfBreakOutRooms(){
        int roomCount=0;
        for (int i=0; i < breakoutRoomLimit;i++){
            if (breakoutRooms[i]!=null)
                roomCount=+1;
        }
        return roomCount;
    }
    
    public void createBreakoutRooms(){
        BreakoutRoom[] breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        for (int i=0; i< breakoutRoomLimit;i++){
            BreakoutRoom room = new BreakoutRoom(name+i);
            breakoutRooms[i]=room;
        }
        
    }
    
    public BreakoutRoom findBreakoutRoom (int roomNumber){
        BreakoutRoom room = new BreakoutRoom("");
        if (breakoutRooms[roomNumber]== room)
            return breakoutRooms[roomNumber];
        return null;
    }
    
    public boolean closeBreakoutRoom (int roomNumber){
        if (breakoutRooms[roomNumber]!=null){
            breakoutRooms[roomNumber].closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom (int roomNumber){
        if (breakoutRooms[roomNumber]!=null){
            breakoutRooms[roomNumber].openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String list = name +"\n";
        for (int i=0; i<breakoutRoomLimit; i++)
            list = list + breakoutRooms[i].toString();
        
        return list;
    }
    
    public String listParticipantsInBreakoutRoom (int roomNumber){
        if (breakoutRooms[roomNumber]!=null)
            return String.valueOf(roomNumber) + "\n" + breakoutRooms[roomNumber].listParticipants();
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        if (breakoutRooms[roomNumber]!=null){
            breakoutRooms[roomNumber].addParticipant(participantID);
            return true;
        }
        return false;
          
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        Participant p = new Participant(participantID);
    
        if (p.verifyID(participantID)==true){
            for (int i=0; i<breakoutRoomLimit; i++){
                if (breakoutRooms[i].findParticipant(participantID)==p){
                    System.out.println("ParticipantID found");
                    return breakoutRooms[i].breakoutRoomID;
                }     
           
            }
        
            System.out.println("ParticipantID not found");
        }
    
        else {System.out.println("Invalid participantID");}
    
        return null;
    }
}
