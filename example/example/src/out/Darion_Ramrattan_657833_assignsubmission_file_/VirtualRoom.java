package out.Darion_Ramrattan_657833_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (816018746)
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name; 
    private final int breakoutRoomLimit; 
    private BreakoutRoom[] breakoutRooms; 
    
    public VirtualRoom(String name){
     breakoutRoomLimit = 5; // 5 
     this.name = name;  
     breakoutRooms = new BreakoutRoom[5];
     
    }

    public VirtualRoom(String name, int limit){
      breakoutRoomLimit = limit; 
      this.name = name;   
      breakoutRooms = new BreakoutRoom[limit];
        
    } 
    
    public int getNumberOfBreakoutRooms () {
        
      return breakoutRoomLimit;   
        
    } 
    
    public void createBreakoutRooms(){ 
      String bname= "BreakoutRoom"; 
        for(int i =0; i<breakoutRoomLimit; i++){
         breakoutRooms[i] = new BreakoutRoom(bname);
            
        }
        
    } 
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        

        if(roomNumber>= breakoutRoomLimit){
         return null;    
        }
        
        else
            return breakoutRooms[roomNumber]; 
    }
    
    public boolean closeBreakoutRoom(int roomNumber){ 
      
        BreakoutRoom temp = new BreakoutRoom(this.name); 
        
        temp=findBreakoutRoom(roomNumber); 
        
        if(temp != null){
         breakoutRooms[roomNumber].closeBreakoutRoom(); 
         return true;    
            
        }
        
     return false; 
    } 
    
    public boolean openBreakoutRoom(int roomNumber){
     BreakoutRoom temp = new BreakoutRoom(this.name); 
        
     temp=findBreakoutRoom(roomNumber); 
        
        if(temp != null){
         breakoutRooms[roomNumber].openBreakoutRoom(); 
         return true;    
            
        }
        
     return false;   
        
    }
    
    public String listBreakoutRoom(){
      String list= ""; 
      
      for(int i=0; i<breakoutRoomLimit; i++){
         
         list+= breakoutRooms[i].toString() +" "; 
          
        }
      
      return list;   
    } 
    
    public String listParticipantsInBreakoutRoom(int roomNumber){ 
      String participantsbreak="";   
      BreakoutRoom temp = new BreakoutRoom(this.name); 
        
      temp=findBreakoutRoom(roomNumber); 
        
        if(temp != null){
          participantsbreak+= temp.getBreakoutRoomID()+ " " + breakoutRooms[roomNumber].listParticipants(); 
          return participantsbreak;   
        }
     return null;    
    } 
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        
       
      BreakoutRoom temp = new BreakoutRoom(this.name); 
        
      temp=findBreakoutRoom(roomNumber); 
        
        if(temp != null){
           boolean a = breakoutRooms[roomNumber].addParticipant(participantID); 
           if( a == true){
           return true; 
        }
        
    }
      return false;   
    }
    
    public String findParticipantBreakoutRoom(String participantID){
     String p= ""; 
    // Participant temp = new Participant(participantID); 
        BreakoutRoom temp = new BreakoutRoom(p); 
     for(int i=0; i<breakoutRoomLimit; i++){
       try{
            if((breakoutRooms[i].findParticipant(participantID).getParticipantID()).equals(participantID)){
             p= breakoutRooms[i].getBreakoutRoomID();
             return p; 
            }
        }
        catch(NullPointerException e){
           // System.out.println("NullPointerException !");
        }
        /* if(temp != null){
             
             p= breakoutRooms[i].getBreakoutRoomID(); 
             return p; 
         }*/
        }
    return null; 
}
}