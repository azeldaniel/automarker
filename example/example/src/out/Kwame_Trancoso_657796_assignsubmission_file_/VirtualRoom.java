package out.Kwame_Trancoso_657796_assignsubmission_file_;//816005595
public class VirtualRoom
{
    public String name;
    public int breakoutRoomLimit;
    public BreakoutRoom[] breakoutRooms;

    public VirtualRoom(String vname)
    {
        name= vname;
        breakoutRoomLimit=5;
    }
    
    public VirtualRoom(String vname, int limit)
    {
        name= vname;
        breakoutRoomLimit=limit;
    }
   
    public int getNumberofBreakoutRooms()
    {   
       return breakoutRooms.length;
    }
    
    public void createBreakoutRooms(){
        breakoutRooms= new BreakoutRoom[breakoutRoomLimit];
        for(int i =0; i <=breakoutRoomLimit-1 ; i++){
            breakoutRooms[i]=new BreakoutRoom(name,i+1);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if(roomNumber>=breakoutRooms.length)
            return null;
        else
            return breakoutRooms[roomNumber];
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
        String list;
        list = name + "\n";
        for(int i = 0; i < breakoutRoomLimit; i++)
            list+=breakoutRooms[i].toString() + "\n";
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber) {
        String s;
        BreakoutRoom room;
        room = findBreakoutRoom(roomNumber);
        if(room==null)
            return null;
        else{
        s = room.listParticipants();
        }
        return s;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        boolean state=false;
        if(findBreakoutRoom(roomNumber)==null)
            return false;
        else{
            state=breakoutRooms[roomNumber].addParticipant(participantID);
        }
        if(state==true)
            return true;
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        int i=0;
        String room;
        while(breakoutRooms[i].findParticipant(participantID)==null){
            if(i>breakoutRoomLimit){
                return "Not Found";
            }
            i++;
        }
        room=breakoutRooms[i].getbreakoutRoomID();
        return room;
    }
}
