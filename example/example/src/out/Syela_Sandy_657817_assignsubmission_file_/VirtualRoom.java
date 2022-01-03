package out.Syela_Sandy_657817_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @Student ID: 816020390
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    public BreakoutRoom breakoutroom;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];  
    }

    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    
    }
    
    public int getbreakoutRoomLimit(){
        return breakoutRoomLimit;
    }
    
    public BreakoutRoom getbreakoutRooms(int counter){
        return breakoutRooms[counter];
    }
    
    public int getNumberOfBreakoutRooms(){
        
            int numberofBreakoutRooms = 0;
            for (int i = 0; i < breakoutRooms.length; i ++){
                if (breakoutRooms[i] != null)
                numberofBreakoutRooms ++;
            }
            return numberofBreakoutRooms;
           
    }
    
    public void createBreakoutRooms(){
            for (int i=0; i < breakoutRoomLimit; i++){
                 
                 breakoutRooms[i] = new BreakoutRoom(name);
                 //breakoutroom = new BreakoutRoom(name);
                 //breakoutRooms[i] = breakoutroom;
            }
            
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
            
            
            for (int i=0; i < breakoutRoomLimit; i++){
                if (breakoutRooms[i].getbreakoutRoomNumberCounter() == roomNumber){
                    //breakoutRooms[i] = BreakoutRoom bor;
                    //return bor;
                    return breakoutRooms[i];
                }
                
            }
           
            return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){

            for (int i=0; i < breakoutRoomLimit; i++){

                 if(breakoutRooms[i].getbreakoutRoomNumberCounter() == roomNumber){
                     breakoutRooms[i].closeBreakoutRoom();
                     return true;
                 }
            }
            System.out.println("The breakout room with this room number doesn't exist.");
            return false;
            
    }
    
    public boolean openBreakoutRoom(int roomNumber){
           
            
            for (int i=0; i < breakoutRoomLimit; i++){

                 if(breakoutRooms[i].getbreakoutRoomNumberCounter() == roomNumber){
                     breakoutRooms[i].openBreakoutRoom(); 
                     return true;
                 }
            }
            System.out.println("The breakout room with this room number doesn't exist.");
            return false;

    }
    
    public String listBreakoutRooms(){
            
             System.out.println(name);
             String s ="";
              for (int i=0; i < breakoutRoomLimit; i++){
                   s = s + breakoutRooms[i].toString()+ "\n";
              }
             return s;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){

              BreakoutRoom bor = findBreakoutRoom(roomNumber);
              if (bor == null){
                  System.out.println("There is no breakout room with this room number.");
                  return null;
              }
              else{
                    return bor.listParticipants();
              }
                  
  
    }
    
    public String ParticipantsInAllBreakoutRooms(){
        
           String s ="";

           for(int i=0; i < breakoutRoomLimit; i++){
              
              if(breakoutRooms[i].getNumberOfParticipants()!=0){

                 s = s + breakoutRooms[i].listParticipants();
              }
              else {
                    s = s + breakoutRooms[i].listParticipants()+"/nThere are no participants in this breakout room.";
              }
           }
           return s;
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
      
         BreakoutRoom bor = findBreakoutRoom(roomNumber);
         if (bor == null){
             System.out.println("There is no breakout room with this room number. Failed to add participant.");
             return false;
         }
         else{
             return bor.addParticipant(participantID);
         }
    }
    
    public String findParticipantBreakoutRoom(String participantID){

             for (int i=0; i < breakoutRoomLimit; i++){

                  if(breakoutRooms[i].findParticipant(participantID) != null){

                      return breakoutRooms[i].getBreakoutRoomID();
                  }
             
             }
                  
           System.out.println("There is no participant with this ID in any breakoutrooms.");
           return null;
                  
    }
    
    
       
}
