package out.Gersha_France_657754_assignsubmission_file_;//816009767
public class VirtualRoom
{
      private String name;
      private int breakoutRoom;
      private  BreakoutRoom[] breakoutRooms;
      
      private  int NumberOfBreakoutRoom;
      private boolean isopen;
      private int sr;
    
      private BreakoutRoom br;
      
    public VirtualRoom(String name){
       NumberOfBreakoutRoom = 5;
        
        
        
    }
     
    public VirtualRoom(String name , int limit){
        
        if (limit == 5){
            
        System.out.println(name);
       System.out.println(" is has reach its limit");
    }
 }

    public int getNumberOfBreakoutRoom(){
      return NumberOfBreakoutRoom;
        
    }
    
     public void createBreakoutRoom(){

         
         BreakoutRoom[] rooms = new BreakoutRoom [5];
     
     BreakoutRoom r1 = new BreakoutRoom(name);
     BreakoutRoom r2 = new BreakoutRoom (name);
     BreakoutRoom r3 = new BreakoutRoom (name);
     BreakoutRoom r4 = new BreakoutRoom (name);
     BreakoutRoom r5 = new BreakoutRoom (name);
     rooms[0]=r1;
     rooms[1]=r2;
     rooms[2]=r3;
     rooms[3]=r4;        
      rooms[4]=r5;    
        }
        
         public  BreakoutRoom findBreakoutRoom(int roomNumber){
             
             
             return br ;
             
             
            }
            
     public boolean closeBreakoutRoom (int roomNumber){
         
          if (isopen == true){
                isopen = false;
                return true;
            }
            return false;
        }
        
         public boolean openBreakoutRoom (int roomNumber){
              if (!isopen){
                isopen = true;
                return true;
            }
            return false;
        }
        
        
        public String listBreakoutRoom(){
            if(NumberOfBreakoutRoom == 0){
            return "no NumberOfBreakoutRoom ";
        }else{
            String details =  " ";
            for(int i = 0; i < NumberOfBreakoutRoom; i++){
            details += NumberOfBreakoutRoom;
            
        }
        return details;
    }
   } 
        
        
        public String listParticipantsInBreakoutRoom(int roomNumber){
             if(roomNumber == 0){
            return "no roomNumber ";
        }else{
            String details =  " ";
            for(int i = 0; i < roomNumber; i++){
            details += roomNumber;
            
        }
        return details;
    }
        }
        
        public boolean addParticipantToBreakoutRoom( String participantID, int roomNumber){
            if(roomNumber == sr)
            
           
            
          return true;
          
        return false;
    }
        
        public String findParticipantBreakoutRoom(String participantID){
           String details="";
            return details;
        }
        
        
  }
        
        
        

