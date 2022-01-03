package out.Melika_Ogarro_657708_assignsubmission_file_;
/**
 *
 * @authorID (816002233)
 * @version (13.02.2021)
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    private int numberOfBreakoutRooms;
    
    
   public VirtualRoom(String name){
       this.name = name;
       breakoutRoomLimit = 5;
       breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
       numberOfBreakoutRooms = 0;
   }
    
   public VirtualRoom(String name, int limit){
       this.name = name;
       breakoutRoomLimit = limit;
       breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
       numberOfBreakoutRooms = 0;
   }
    
   public int getNumberOfBreakoutRooms(){
       numberOfBreakoutRooms = 0;
       int j=0;
       while(j<breakoutRoomLimit){
           numberOfBreakoutRooms = breakoutRooms[j].getBreakoutRoomNumberCounter();
           j++;
       }
       return numberOfBreakoutRooms;
   }
   
   public int getBreakoutRoomLimit(){
       return breakoutRoomLimit;
   }
   
   public String getName(){
       return this.name;
   }
   
   public void createBreakoutRooms(){

       for(int i=0; i<getBreakoutRoomLimit(); i++){
           breakoutRooms[i] = new BreakoutRoom(getName());
       } 
   }
   
   public BreakoutRoom findBreakoutRoom(int roomNumber){
       for(int i=0; i<getBreakoutRoomLimit(); i++){
           if(breakoutRooms[i].getBreakoutRoomID().equals(getName() + roomNumber)){
               return breakoutRooms[i];
           }
       }
       return null; 
   }
   
   public boolean closeBreakoutRoom(int roomNumber){
       BreakoutRoom br = findBreakoutRoom(roomNumber);
       if(br!= null){
            br.closeBreakoutRoom();
            return true;
       }
       else{
           System.out.println("Breakout Room " + getName() + roomNumber + "does not exist");
           return false;
        }
   }
    
   public boolean openBreakoutRoom(int roomNumber){
       BreakoutRoom br = findBreakoutRoom(roomNumber);
       if(br!= null){
            br.openBreakoutRoom();
            return true;
       }
       else{
           System.out.println("Breakout Room " + getName() + roomNumber + "does not exist");
           return false;
        }
   }
   
   public String listBreakoutRooms(){
       String list = getName() + ": \n";
       for(int i=0; i<getBreakoutRoomLimit(); i++){
          list += breakoutRooms[i].getBreakoutRoomID() + "\n";
        }
        return list;
   }
   
   public String listParticipantsInBreakoutRoom(int roomNumber){
       BreakoutRoom br = findBreakoutRoom(roomNumber);
       if(br!= null){
           return br.listParticipants();
       }
       else{
           return null;
       }
    }
    
   public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
       BreakoutRoom br = findBreakoutRoom(roomNumber);
       boolean added;
       if(br!= null){
           openBreakoutRoom(roomNumber);
           added = br.addParticipant(participantID);
           if(added){
               return true;
           }
           return false;
       }
       return false;
   }
   
   
   public String findParticipantBreakoutRoom(String participantID){
       for(int i=0; i<getBreakoutRoomLimit(); i++){
           if(breakoutRooms[i].findParticipant(participantID) != null){
              return breakoutRooms[i].getBreakoutRoomID();
           }
      } 
      return null;
   }

}
