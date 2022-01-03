package out.Harish_Singh_657826_assignsubmission_file_;//ID#816117713
public class VirtualRoom{
    
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms = new BreakoutRoom[10];
    
    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
    }
    
    public VirtualRoom(String name,int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
    }
    
    public int getNumberOfBreakoutRooms(){
        int count = 0;
        
        for(int i=0;i<breakoutRooms.length;i++){
            if(breakoutRooms[i]!=null){
                count = count + 1;
            }
         }
            return count;
    }
    
    public void createBreakoutRooms(){
        String breakoutRoomName = name;
        int index=0;
        
        for(int i=0;i<breakoutRooms.length;i++){
            if(breakoutRooms[i]!=null){
                index+=1;
            }
        }
        
        breakoutRoomName = name + (index+1);
        BreakoutRoom x = new BreakoutRoom(breakoutRoomName);
        breakoutRooms[index]= x;
        
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        if(breakoutRooms[roomNumber-1]!=null){
        return breakoutRooms[roomNumber-1];
    }else{
        return null;
    }
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber-1)!=null){
            breakoutRooms[roomNumber-1].openBreakoutRoom();
            return true;
        }else{
            return false;
        }
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber-1)!=null){
            breakoutRooms[roomNumber-1].closeBreakoutRoom();
            return true;
        }else{
            return false;
        }
      }
      
    public String listBreakoutRooms(){
        String List = name + "\n";
        
        for(int i=0;i<breakoutRooms.length;i++){
            if(breakoutRooms[i]!=null){
            List += breakoutRooms[i].getBreakoutRoomID() + "\n";
        }
       }
        return List;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String List="";
        
        if(breakoutRooms[roomNumber-1]!=null){
            
            List = breakoutRooms[roomNumber-1].listParticipants();
            
        }else{
            
            return null;
        }
            return List;
        
        
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        if(breakoutRooms[roomNumber-1]!=null){
            if(breakoutRooms[roomNumber-1].addParticipant(participantID)==true){
                return true;
            }
        }
            return false;
        
      }
    
    
    
    
    
      
    
    
    
    
   
}