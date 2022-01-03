package out.Cleopatra_Arrindell___Walker_657673_assignsubmission_file_;   
/**
 * @author (813001054)
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
  
    
    
    public VirtualRoom(String name){
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];

    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        
    }
    
    public int getNumberOfBreakoutRooms(){
        
        return breakoutRoomLimit;
    }
   
  
    
    public void createBreakoutRooms(){
        
 
          for(int i = 0; i<breakoutRoomLimit; i++){
            if(findBreakoutRoom(i) == null){ 
                
                System.out.println("Breakout room is not created.");
            
            }else{
                breakoutRooms = new BreakoutRoom[i];
                System.out.println("Breakout room: " + breakoutRooms);
            }
            }
    }
   
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
       
        for(BreakoutRoom room : breakoutRooms){
             
            if(openBreakoutRoom(roomNumber) && room.equals(roomNumber)){
                return breakoutRooms[breakoutRoomLimit];
    
           }
          }
          return null;
        }    
        
    
     
     public boolean closeBreakoutRoom(int roomNumber){
         
        if(!openBreakoutRoom(roomNumber)){
           System.out.println("BreakoutRoom is closed");
           return true;
        }
        return false;
    }  
    
    public boolean openBreakoutRoom(int roomNumber){
          if(roomNumber != 0 ){
           
            return true;
        
        }else{
            return false;
        }
    }
    
     public String listBreakoutRooms(){
         
         for(int i = 0; i<breakoutRoomLimit; i++){
            if(findBreakoutRoom(i) == null){ 
                System.out.println("Breakout room is not created.");
            
            }else{
                 System.out.println("Virtual room: " + name + breakoutRooms[i]);
            }
       
        }
        return null;
    }  
    
 
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
         
         for(int i=0; i<50; i++){
            if(listBreakoutRooms().equals(roomNumber)){
             return listParticipantsInBreakoutRoom(i).toString();
           }
     
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
       
             for (int i=0; i<breakoutRoomLimit; i++) {
            BreakoutRoom s = breakoutRooms[i]; 
            if(s!=null) {
             addParticipantToBreakoutRoom(participantID,roomNumber);
          }
        }
           return true;
       
        }

    public String findParticipantBreakoutRoom(String participantID){
        int s = getNumberOfBreakoutRooms();
        for (int i=0; i<s; i++) {
          BreakoutRoom r = findBreakoutRoom(s); 
        if(r!=null) {
         listParticipantsInBreakoutRoom(s);
        }
      } 
      return null;
   } 
}





