package out.Jewel_Coker_657713_assignsubmission_file_;// ID : 816014352

public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms = new BreakoutRoom[5];
    private int breakoutRoomCount = 0;
  
    public VirtualRoom( String name)
    {
     breakoutRoomLimit= 5;
     this.name = name;
     createBreakoutRooms();
    }

    public VirtualRoom(String name, int limit){
       this.breakoutRoomLimit = limit;
       this.name = name; 
       createBreakoutRooms();
    }
    
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomCount; 
    }
    
    public void createBreakoutRooms(){
        BreakoutRoom breakoutRoom ;
        for (int i=0; i<5 ; i++){
        breakoutRooms[i] = new BreakoutRoom(this.name);
        
        breakoutRoomCount++;
        
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        String roomID;
       if(roomNumber<0 || roomNumber > 5){
        return null;
        }
        
      
        return breakoutRooms[roomNumber-1]; 
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
    BreakoutRoom breakoutRoom = new BreakoutRoom(this.name);
    breakoutRoom = findBreakoutRoom(roomNumber);
    if(breakoutRoom!=null && breakoutRoom.getOpen()!=false){
        breakoutRoom.closeBreakoutRoom();
        return true;
    }
    return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
    BreakoutRoom breakoutRoom = new BreakoutRoom(this.name);
    breakoutRoom = findBreakoutRoom(roomNumber);
    if(breakoutRoom!=null && breakoutRoom.getOpen()!=true){
        breakoutRoom.openBreakoutRoom();
        return true;
    }
    return false;
    }
    
    public String listBreakoutRooms(){
    String breakoutRoomList="";
    for(int i=0; i<breakoutRoomCount ; i++){
        breakoutRoomList+= breakoutRooms[i].getBreakoutRoomID()+ "\n";
    }
    return "Virtual Room: "+this.name+"\n" +breakoutRoomList; 
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
    BreakoutRoom breakoutRoom = new BreakoutRoom(this.name);
    breakoutRoom= findBreakoutRoom(roomNumber);
    
  
    String participantList;
        if(breakoutRoom!=null){
            participantList=breakoutRoom.listParticipants();
            return participantList;
        }
    return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID,
    int roomNumber){
       boolean participantAdded;
        if(findBreakoutRoom(roomNumber)!=null){
            participantAdded=findBreakoutRoom(roomNumber).addParticipant(participantID);
            if(participantAdded==true){ 
              
                return true;
            }
        }
        
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
    int x =0;
    while(breakoutRooms[x].findParticipant(participantID)==null ){
       x++;
       if(x==5){
           return null;
        }
    }

        return breakoutRooms[x].getBreakoutRoomID();    
    }
}
