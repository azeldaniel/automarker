package out.Jonathan_Charles_657850_assignsubmission_file_;import java.util.ArrayList;
/*816020890*/
public class VirtualRoom{
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    
    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        BreakoutRoom [] breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
   }
    public VirtualRoom(String name,int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        BreakoutRoom [] breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
   }
    public String getname(){
        return name;
   }
    public int breakoutRoomLimit(){
        return breakoutRoomLimit;
   }
    public int getNumberOfBreakoutRooms(){
        return  breakoutRoomLimit;
   }
    public void createBreakoutRoom(){
        for(int i=0;i<breakoutRoomLimit;i++){
            breakoutRooms [i] = new BreakoutRoom(name);
        }
   }   
    public  BreakoutRoom findBreakoutRoom(int RoomNumber){
            int index = java.util.Arrays.asList(breakoutRooms).indexOf(RoomNumber);
            
            if(index ==-1){
                return null;
            }else{
                return java.util.Arrays.asList(breakoutRooms).get(index);
            }
            
   }
    public String closeBreakoutRoom(int RoomNumber){
        int index = java.util.Arrays.asList(breakoutRooms).indexOf(RoomNumber);

        if(index == RoomNumber){
            breakoutRooms[index].closeBreakoutRoom();
        }
        return null;
   } 
    public String openBreakoutRoom(int RoomNumber){
          int index = java.util.Arrays.asList(breakoutRooms).indexOf(RoomNumber);
          
          if(index == RoomNumber){
              breakoutRooms[index].openBreakoutRoom();
            }
            return null;
   }
    public String listBreakoutRooms(){
        if(name == null){
                return " Invalid name";
            }else{
                name = getname();
                return name;
                
                
            }
   }
   public String listParticipantsinBreakoutRoom(int RoomNumber){
          int index = java.util.Arrays.asList(breakoutRooms).indexOf(RoomNumber);
          if(index != -1){
              return this.breakoutRooms[index].listParticipants();
            }else{
                return null;
            }
            

    }
   /*public boolean addParticipantToBreakoutRoom(String ParticipantID,int RoomNumber){
       int index = java.util.Arrays.asList(breakoutRooms).indexOf(RoomNumber);
       
       if(index == RoomNumber){
           this.breakoutRooms[index].addParticipants();
        }else{
            return false;
        }
       
                
    }*/
   
}
