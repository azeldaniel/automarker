package out.Tamia___Ashley_Tuitt_657761_assignsubmission_file_;/**
 * Student ID: 816021561
 */
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms=new BreakoutRoom[5];
    
    public VirtualRoom(String name){
        this.name=name;
        this.breakoutRoomLimit=5;
    }
    
    public VirtualRoom(String name, int limit){
        this.name=name;
        this.breakoutRoomLimit=limit;
    }
    
    public String getName(){
        return name;
    }
    
    public int getNumberOfBreakoutRooms(){
        
         int NumberOfBreakoutRooms=0;
        for(int i=0; i<breakoutRoomLimit; i++){
          NumberOfBreakoutRooms=breakoutRooms[i].getBreakoutRoomNumberCounter();
        }
         return NumberOfBreakoutRooms;
    }
    
    public void createBreakoutRooms(){
        
        
        for(int i=0; i<breakoutRoomLimit; i++){
            
            breakoutRooms[i] = new BreakoutRoom(this.name);
            
        }
        
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        
       for(int i=0; i<breakoutRoomLimit; i++){
           
           if(breakoutRooms[i].getBreakoutRoomNumber()==roomNumber)
           return breakoutRooms[i];
        }
        
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        
       for(int i=0; i<breakoutRoomLimit; i++){
           
           if(breakoutRooms[i].getBreakoutRoomNumber()==roomNumber){
           breakoutRooms[i].closeBreakoutRoom();
           return true;
        }
        
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        
       for(int i=0; i<breakoutRoomLimit; i++){
           
           if(breakoutRooms[i].getBreakoutRoomNumber()==roomNumber){
           breakoutRooms[i].openBreakoutRoom();
           return true;
        }
        
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        
        String list=""+name;
        for(int i=0; i<breakoutRoomLimit; i++){
            
            list += "\n" +breakoutRooms[i].toString();
        }
        
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
          String list="";
           for(int i=0; i<breakoutRoomLimit; i++){
           
             if(breakoutRooms[i].getBreakoutRoomNumber()==roomNumber){
             list+="\n"+breakoutRooms[i].listParticipants();
             return list;
             }
        
             }
          return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        
        for(int i=0; i<breakoutRoomLimit; i++){
           if(breakoutRooms[i].getBreakoutRoomNumber()==roomNumber){
            if(breakoutRooms[i].addParticipant(participantID)==true){
              return true;
            }
          }
        }
         return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        
        for(int i=0; i<breakoutRoomLimit; i++){
           
           if(breakoutRooms[i].findParticipant(participantID)!=null){
           return breakoutRooms[i].getBreakoutRoomID();
        }
    
        }
        return null;
    }
}
    
  
        
 
        
    

