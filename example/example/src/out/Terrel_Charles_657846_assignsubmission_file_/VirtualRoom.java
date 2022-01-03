package out.Terrel_Charles_657846_assignsubmission_file_;



/**
 * Write a description of class VirtualRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    
    final private  int breakoutRoomLimit;

    private BreakoutRoom[] breakoutRooms;
    public VirtualRoom(String name)
    {
        this.name=name;
        breakoutRoomLimit=5;
        breakoutRooms=new BreakoutRoom[5];
        
    }

    
    public VirtualRoom(String name,int limit)
    {
        this.name=name;
        breakoutRoomLimit=limit;
        breakoutRooms=new BreakoutRoom[limit];
        
    }
    
    public int getNumberOfBreakoutRooms(){ 
    
        
    return breakoutRoomLimit;
        
    }
    
    
    
    
    
    
    
    public void createBreakoutRooms(){
    
        for(int i=0;i<breakoutRoomLimit;i++)
        {
            this.breakoutRooms[i]=new BreakoutRoom(name);
        
        }
    }
    
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
    for(int i=0;i<breakoutRoomLimit;i++){
    if(roomNumber==i){
    return breakoutRooms[i];
    }
            }
    return null;
    
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
    breakoutRooms[roomNumber]=findBreakoutRoom(roomNumber);
    if(breakoutRooms[roomNumber]==null){
         return false;}
       breakoutRooms[roomNumber].closeBreakoutRoom();
    
    return true;
    
    }
    
    public boolean openBreakoutRoom(int roomNumber){
    
        breakoutRooms[roomNumber]=findBreakoutRoom(roomNumber);
    if(breakoutRooms[roomNumber]==null){
         return false;}  
        
    breakoutRooms[roomNumber].openBreakoutRoom();
    return true;
    }
    
    public String listBreakoutRooms(){
    String list="";
    for(int i=0;i<breakoutRoomLimit;i++){
    list+=breakoutRooms[i].toString()+ "     ";
    }
    return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
    
          BreakoutRoom breakout=findBreakoutRoom(roomNumber);
    if(breakout!=null && breakout.getOpen()  ){
         return breakout.listParticipants();}  
    
         return null;
    
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID,
    int roomNumber){
    
        BreakoutRoom b1 = findBreakoutRoom(roomNumber);
        if (b1 != null) {
            b1.addParticipant(participantID);
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
   
   
    
    for(int i=0;i<breakoutRoomLimit;i++){
    
        BreakoutRoom breakoutRoom= findBreakoutRoom(i);
        //check if the break out room is open 
        
        if(breakoutRoom.findParticipant(participantID)!=null){
            return breakoutRoom.getBreakoutRoomID();
        }
        
     
    
    
    
    } 
     return null;
}
 
  
}

