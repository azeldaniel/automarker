package out.Michael_Rampersad_657747_assignsubmission_file_;
public class VirtualRoom
{
    private int breakoutRoomLimit = 0;
    private String name = null;
    //private BreakoutRoom breakoutRooms[];

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
     breakoutRoomLimit = 5 ;
    }
    
     public VirtualRoom(String name,int limit)
    {
      breakoutRoomLimit = limit;
    }
    
    //public int getNumberOfBreakoutRooms()
    //{
    //   return numBreakoutRooms ;
    //}
    
    public void createBreakoutRooms(){
    }
    
    //public BreakoutRoom findBreakoutRoom(int roomNumber){
    //    return breakoutRoomNo;
    //}
    
    public boolean openBreakoutRoom (int roomNumber){
        
        return true;
    }
    
    public boolean closeBreakoutRoom (int roomNumber){
        return true;
    }
    
    //public String listBreakoutRooms(){
    //  return list;
    //}
    
    //public String listParticipantsInBreakoutRoom (int roomNumber){
    //     return listPart;
    //}
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        return true;
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        return null;
    }
    
}
