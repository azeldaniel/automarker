package out.Joshua_Aird_657797_assignsubmission_file_;

public class VirtualRoom
{
   
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    

    
    public VirtualRoom(String name)
    {
       this.name=name;
       breakoutRoomLimit=5;
       breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    
    public VirtualRoom(String name, int limit)
    {
       this.name=name;
       breakoutRoomLimit=limit;
       breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    
    public void createBreakoutRooms(){
        for(int i=0;i<5;i++){
            breakoutRooms[i]=new BreakoutRoom(name);
            System.out.println(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRoomLimit; i++){
                if(roomNumber == i ){
                    return breakoutRooms[i];
                }
            }
            return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        for(int i=0; i<breakoutRoomLimit; i++){
                if(roomNumber == i ){
                    breakoutRooms[roomNumber].closeBreakoutRoom();
                    return true;
                }
                
            }
            return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
         for(int i=0; i<breakoutRoomLimit; i++){
                if(roomNumber == i ){
                    breakoutRooms[roomNumber].openBreakoutRoom();
                    return true;
                }
                
            }
            return false;
    }
    
    public String listBreakoutRooms(){
        String details= "Virtual Room: " + name + "\n";
        for(int i=0; i<breakoutRoomLimit; i++){
                details += breakoutRooms[i].toString();
            }
            return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
       String detail = "";
        
        if(breakoutRooms[roomNumber].equals(null)){ 
            return null;
        }
            else {
            
            detail+="\n" +  breakoutRooms[roomNumber].getBreakoutRoomID();
             
            detail+="\n" + breakoutRooms[roomNumber].listParticipants();
            
            return detail;
        }
           
        
    }
    
    
    
    public boolean addParticipantToBreakoutRoom(String participantsID, int roomNumber){
        
        for(int i=0; i<breakoutRoomLimit; i++){
                if(roomNumber == i ){
                    return breakoutRooms[roomNumber].addParticipant (participantsID);
                   
                }
                
            }
            return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        for(int i=0; i<breakoutRoomLimit;i++){
            if(breakoutRooms[i].findParticipant(participantID)!=null){
                  return breakoutRooms[i].toString();
            }
        }
        return null;
    }
    
}
