package out.Nickal_Winter_657706_assignsubmission_file_;
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    
    // instance variables - replace the example below with your own
    private String name;
    final private int breakoutRoomLimit = 5;
    private int numberr;
    private BreakoutRoom[] breakoutRooms;
    private int NumberOfBreakoutRooms;
    
    
    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        // initialise instance variables
        if (!name.equals("VirtualRoom")){
            this.name = "VirtualRoom";
        }else{
            this.name = name;
        }
        NumberOfBreakoutRooms = breakoutRoomLimit;
        numberr = 0;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        
    }

    public VirtualRoom(String name, int limit)
    {
        // initialise instance variables
        if (!name.equals("VirtualRoom")){
            this.name = "VirtualRoom";
        }else{
            this.name = name;
        }
        
        this.NumberOfBreakoutRooms = limit;
        numberr = 0;
        breakoutRooms = new BreakoutRoom[NumberOfBreakoutRooms];
        
    }

    
    

    public String getname(){
        return name;
    }
    
    
   
    
    public int getNumberOfBreakoutRooms(){
        return NumberOfBreakoutRooms;
}


   public void createBreakoutRooms (){
       int i;
       for(i=0;i<5;i++){
       BreakoutRoom b = new BreakoutRoom("Workshop");
           breakoutRooms[i] = b;
           
        }
           
          
    }
    
    

    public boolean closeBreakoutRoom (int roomNumber){
        if (roomNumber < NumberOfBreakoutRooms){
            breakoutRooms[roomNumber].closeBreakoutRoom();    
                return true;
            }else{
                return false;
            }


}

    public boolean openBreakoutRoom (int roomNumber){
        if (roomNumber < NumberOfBreakoutRooms){
            breakoutRooms[roomNumber].openBreakoutRoom();    
              return true;  
            }else{
                return false;
            }


}

    public String listBreakoutRooms (){
        
            String details = name + " " + "\n";
             System.out.println();
            for(int i = 0;i < 5; i++){
                details += breakoutRooms[i].toString() + " " + "\n";
                
                 
                
            }
        
        return details;

    }
    


   
    


    public boolean addParticipantToBreakoutRoom (String participantID,int roomNumber){
        if (roomNumber <NumberOfBreakoutRooms){
        breakoutRooms[roomNumber].addParticipant(participantID);
        numberr++;
        return true;
    }else{


return false;
}
}

public String listParticipantsInBreakoutRoom (int roomNumber){
        if (roomNumber < NumberOfBreakoutRooms){
            String details ="BreakoutRoom Number: " + roomNumber + " " + "\n";
            
                details += breakoutRooms[roomNumber].listParticipants() + " " + "\n";
                return details;
            }else{
        
        return null;
    }
    }

    ///////////////////////////////////////////////
public BreakoutRoom findBreakoutRoom (int roomNumber){
        
           if (roomNumber<5){
               
               System.out.println("Room "+roomNumber+" found in virtual room!" + "\n");
                return breakoutRooms[roomNumber];
                     
        
            }
    
    return null;
    
}

public String findParticipantBreakoutRoom (String participantID){
       int k = 0;
       for(int i = 0;i < NumberOfBreakoutRooms; i++){
           while (k < numberr){
        if (breakoutRooms[i].findParticipant(participantID).getParticipantID().equals(participantID)){
        System.out.println("Participant "+participantID+" found in breakout room"+ breakoutRooms[i].getBreakoutRoomID().toString() + "\n");
        return breakoutRooms[i].getBreakoutRoomID();
    }
    k += 1;
}
}
return null;
}

   

   
}