package out.Saajida_Khan_657717_assignsubmission_file_;/**
 * @SaajidaAKhan_816013388
 */
public class VirtualRoom{
   public String name;
   public final int breakoutRoomLimit;
   public BreakoutRoom[] breakoutRooms;
    
   public VirtualRoom(String name){
        this.name=name;
        breakoutRoomLimit=5;
        /*for(int x=0; x<breakoutRoomLimit;x++){
            if(getBreakoutRoomCounter<
        }*/
   }
    
   public VirtualRoom(String name, int limit){
        this.name=name;
        breakoutRoomLimit=limit;
   }
    
   public int getNumberOfBreakoutRooms(){
        //return getBreakoutRoomCount();
        return breakoutRoomLimit;
   }
    
   public void createBreakoutRooms(){
        String rn="Workshop";
        for(int x=0; x<breakoutRoomLimit; x++){
            breakoutRooms[x]=new BreakoutRoom(rn+x);
        }
   }
    
   public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int x=0; x<breakoutRoomLimit; x++){
            if(roomNumber==x) return breakoutRooms[x];
        }return null;
   }
    
   public boolean closeBreakoutRoom(int roomNumber){
        for(int x=0; x<breakoutRoomLimit; x++){
            if(x==roomNumber){
                if(breakoutRooms[x].getOpen()){
                    breakoutRooms[x].closeBreakoutRoom();
                    return true;
                }
            }
        }
        return false;
   }
    
   public boolean openBreakoutRoom(int roomNumber){
        for(int x=0; x<breakoutRoomLimit; x++){
            if(x==roomNumber){
                if(!breakoutRooms[x].getOpen()){
                    breakoutRooms[x].openBreakoutRoom();
                    return true;
                }
            }
        }
        return false;
   }
    
   public String listBreakoutRooms(){
       String lbr=this.name;
       for(int x=0; x<breakoutRoomLimit; x++){
           lbr+=breakoutRooms[x].getBreakoutRoomID()+"\n";
       }
       return  lbr;
   }
   
   public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
       for(int x=0; x<breakoutRoomLimit; x++){
           if(roomNumber==x){
               breakoutRooms[x].addParticipant(participantID);
               return true;
           }
       }
       return false;
   }
   
   public String listPartcipantsInBreakoutRoom(int roomNumber){
       String ps=null;
       for(int x=0; x<breakoutRoomLimit;x++){
           if(x==roomNumber){
               ps=breakoutRooms[x].listParticipants()+"\n";
           }
       }
       return ps;
   }
}
