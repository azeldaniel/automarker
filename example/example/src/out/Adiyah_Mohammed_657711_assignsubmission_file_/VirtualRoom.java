package out.Adiyah_Mohammed_657711_assignsubmission_file_;
/**
 816014197
 */
public class VirtualRoom
{
   private String name;
   private final int breakoutRoomLimit;
   private BreakoutRoom[ ] breakoutRooms;
   
   VirtualRoom( String name){
        this.name = name;
        breakoutRoomLimit=5;
        breakoutRooms = new BreakoutRoom [5];
       
   }
   VirtualRoom( String name, int limit){
        this.name=name;
        this.breakoutRoomLimit=limit;
        breakoutRooms = new BreakoutRoom [limit];
        
   }
   public String getName() {
    return this.name;
  }
   public int getNumberOfBreakoutRooms( ) {
       int i=0;
       int count=0;
       for( i=0; i<breakoutRooms.length; i++){
           if(breakoutRooms[i] != null){
                  count++;
                }
                
            } 
            return count;
   }
   public void createBreakoutRooms( ) {
       
          BreakoutRoom b1 = new BreakoutRoom (name);
          BreakoutRoom b2 = new BreakoutRoom (name);
          BreakoutRoom b3 = new BreakoutRoom (name);
          BreakoutRoom b4 = new BreakoutRoom (name);
          BreakoutRoom b5 = new BreakoutRoom (name);
         
    }
   public BreakoutRoom findBreakoutRoom(int roomNumber){
        
             if (  breakoutRooms[roomNumber].equals(null)){
                  return  null  ;
                } 
             
            return breakoutRooms[roomNumber];
    }
   public boolean closeBreakoutRoom(int roomNumber) {
       BreakoutRoom b= new BreakoutRoom(name);
       if (breakoutRooms[roomNumber].equals(null)){
                  return false ;
                } 
        b.closeBreakoutRoom( ); 
       return true;
    }
   public boolean openBreakoutRoom(int roomNumber) {
       BreakoutRoom b= new BreakoutRoom(name);
       if (  breakoutRooms[roomNumber].equals(null)){
                  return false ;
                }
       b.openBreakoutRoom( );         
       return true;
    }
   public String listBreakoutRooms( ) {
        int i=0;
        String breakoutroom=" ";
        for( i=0; i<breakoutRoomLimit; i++){
            breakoutroom =breakoutroom+ String.valueOf(breakoutRooms[i]);
            
                }
            
          return name + breakoutroom;
        
        
    }
   public String listParticipantsInBreakoutRoom(int roomNumber){
        int i=0;
        BreakoutRoom b= new BreakoutRoom(name);
        String breakoutroom= "";
        for( i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].equals(roomNumber)){
                breakoutroom= b.listParticipants( ) ;
               return roomNumber +  breakoutroom;
            }
                }
            
          return null;
       
        
    }
 
   public boolean addParticipantToBreakoutRoom(String participantID,int roomNumber) {
       int i=0;
        BreakoutRoom b1= new BreakoutRoom(name);
        String breakoutroom= "";
        for( i=0; i<breakoutRoomLimit; i++){
            if(breakoutRooms[i].equals(roomNumber)){
              return b1.addParticipant(participantID) ;
              
            }
                }
       return false;
    }
   public String findParticipantBreakoutRoom(String participantID){
        int i=0;
        for( i=0; i<=breakoutRoomLimit; i++){
              if(breakoutRooms[i].equals(participantID)){
                   return breakoutRooms[i] + participantID;
                }
            }
        
          return null;
        
        
    }

}
