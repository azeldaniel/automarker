package out.Lorenzo_La_Caille_657775_assignsubmission_file_;//816015560

public class VirtualRoom
{
    
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    
    public VirtualRoom(String name)
    {
        this.name=name;
        breakoutRoomLimit=5;
        BreakoutRoom[] breakoutRooms=new BreakoutRoom[breakoutRoomLimit];
    }
    public VirtualRoom(String name,int limit)
    {
        this.name=name;
        breakoutRoomLimit=limit;
        BreakoutRoom[] breakoutRooms=new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
        }
        
    public void createBreakoutRooms(){
        for(int i=0;i<breakoutRoomLimit;i++){
            //BreakoutRoom b=new BreakoutRoom(name);
            //breakoutRooms[i]=b;
            //System.out.println(name);
            BreakoutRoom b=new BreakoutRoom(name);
            breakoutRooms[i]= b;
            
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        
        if(breakoutRoomLimit>roomNumber+1){
            return null;
        }else{
            return breakoutRooms[roomNumber-1];
        }
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom present=new BreakoutRoom(name);
        present=findBreakoutRoom(roomNumber);
        if(present==null){
            return false;
        }else{
            breakoutRooms[roomNumber-1].closeBreakoutRoom();
            return true;
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom present=new BreakoutRoom(name);
        present=findBreakoutRoom(roomNumber);
        if(present==null){
            return false;
        }else{
            breakoutRooms[roomNumber-1].openBreakoutRoom();
            return true;
        }
    }
    
    public String listBreakoutRooms(){
        String list="";
        for(int i=0;i<breakoutRoomLimit;i++){
            //list=breakoutRooms[i].toString();
            list=list+breakoutRooms[i].toString()+" ";
        }
        return list;
    }
    
    public String listParticipantInBreakoutRoom(int roomNumber){
        String list;
        BreakoutRoom present=new BreakoutRoom(name);
        present=findBreakoutRoom(roomNumber);
        if(present==null){
            return null;
        }
        else{
            list=breakoutRooms[roomNumber-1].listParticipant();
            return list;
        }
    }
    
    public boolean addParticipantBreakoutRoom(String participantID,int roomNumber){
        boolean test;
        BreakoutRoom present=new BreakoutRoom(name);
        present=findBreakoutRoom(roomNumber);
        if(present==null){
            return false;
        }
        test=breakoutRooms[roomNumber-1].addParticipant(participantID);
        if(test==true){
            return true;
        }else {
            return false;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String ID="";
        for(int i=0;i<breakoutRoomLimit;i++){
            breakoutRooms[i].findParticipant(participantID);
        }
        return ID;
    }
}

