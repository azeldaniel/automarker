package out.Kc_Mentor___Alexis_657777_assignsubmission_file_;//816018833
public class VirtualRoom{
    
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
     public VirtualRoom(String name){
         breakoutRoomLimit = 5;
         this.name = name;
         breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
     }
        
     public VirtualRoom(String name,int limit){
         this.name = name;
         breakoutRoomLimit = limit;
     }
     
     public int getNumberOfBreakoutRooms(){
         return breakoutRoomLimit;
     }
       
     public void createBreakoutRooms(){
        for(int i =0; i < breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
            breakoutRooms[i].openBreakoutRoom();
        }
     }
       
     public BreakoutRoom findBreakoutRoom(int roomNumber){
         
         int i=0; 
         while(i < breakoutRoomLimit){
             if(roomNumber == i){
                 return breakoutRooms[roomNumber];
             }
             i++;
         }
         return null;
     }
     
     public boolean closeBreakoutRoom(int roomNumber){
         
         if(findBreakoutRoom(roomNumber) !=null){
             breakoutRooms[roomNumber].closeBreakoutRoom();
             return true;
         }
         return false;
     }
     
     public boolean openBreakoutRoom(int roomNumber){
         
         if(findBreakoutRoom(roomNumber) !=null){
             breakoutRooms[roomNumber].openBreakoutRoom();
             return true;
         }
         return false;
     }
     
     public String listBreakoutRooms(){
        String list=name + "\n";
        
        for(int i=0; i < breakoutRoomLimit; i++){
            list = list + breakoutRooms[i] + "\n";
        }
        return list;
     }
     
    public String listParticipantsInBreakoutRoom(int roomNumber){
         String list="";
         
         if(findBreakoutRoom(roomNumber) != null){
             list = list + breakoutRooms[roomNumber].listParticipants();
         }
         return list;
    }
     
   public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
   
    boolean test;
    if(breakoutRooms[roomNumber] != null){
       test = breakoutRooms[roomNumber].addParticipant(participantID);
       if(test == true)
        return true;
        
    }
    return false;
   }
     
   public String findParticipantBreakoutRoom (String participantID){
         
    for(int i =0; i < breakoutRoomLimit; i++){
        if(breakoutRooms[i].findParticipant(participantID) !=null){
           return breakoutRooms[i].getBreakoutRoomID();
        }
    } 
    return null;
   }
     
}

             
         