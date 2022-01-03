package out.Amrik_Boodoo_657780_assignsubmission_file_;
/**
 * 
 *
 * Amrik Boodoo 816018329
 * 
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name){
        breakoutRoomLimit=5;
        breakoutRooms= new BreakoutRoom[breakoutRoomLimit];
        this.name= name;
        createBreakoutRooms();
        
    }
    
     public VirtualRoom(String name,int limit){
        breakoutRoomLimit= limit;
        breakoutRooms= new BreakoutRoom[breakoutRoomLimit];
        this.name= name;
        createBreakoutRooms();
        
    }

    public int getNumberOfBreakoutRooms()
    {

      return breakoutRoomLimit;
    }

    public void createBreakoutRooms() {
        for (int i=0; i<breakoutRoomLimit; i++){
            breakoutRooms[i]= new BreakoutRoom(name);
            
        }
        
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        int num;
       
        for (int i=0; i<breakoutRoomLimit; i++){
            String ID= breakoutRooms[i].getBreakoutRoomID();
            char a = ID.charAt(ID.length()-1); // get last character in ID
            
            num= a-'0';  //change from char to int
            
            while (num== roomNumber){
                return breakoutRooms[i];
            }
        }
        
        return null;
    }
    
    
    public boolean closeBreakoutRoom (int roomNumber){
        
        while(findBreakoutRoom(roomNumber)!=null){
            findBreakoutRoom(roomNumber).closeBreakoutRoom();
            return true;
        }
        
        return false;                                       
    }
    
    public boolean openBreakoutRoom (int roomNumber){
        
        while(findBreakoutRoom(roomNumber)!=null){
            findBreakoutRoom(roomNumber).openBreakoutRoom();
            return true;
        }
        
        return false;                                       
    }  
    
    public String listBreakoutRooms(){
        String list=name+"\n";
        
        for (int i=0; i<breakoutRoomLimit; i++){
            list+= breakoutRooms[i].getBreakoutRoomID(); 
            list+="\n";        
        }
        
        return list;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        //int num;
        String list= "";
        //for (int i=0; i<breakoutRoomLimit; i++){
        //    String ID= breakoutRooms[i].getBreakoutRoomID();
        //    char a = ID.charAt(ID.length()-1); 
            
        //    num= a-'0';
            
        //    while (num== roomNumber){
        //        list= breakoutRooms[i].listParticipants();
        //        return list;
        //   }
        //}
        //return list;
        
        while(findBreakoutRoom(roomNumber)!=null){
            list=breakoutRooms[roomNumber-1].listParticipants();
            return list;
        }
        
        
        
        return null;
   
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber){
        //boolean b= false; //added in
        while(findBreakoutRoom(roomNumber)!=null){
   
            findBreakoutRoom(roomNumber).addParticipant(participantID);
            //b=true;
            return true;
        }
             
        return false;       //added in
    }
 
    public String findParticipantBreakoutRoom (String participantID){
        String list;
        String room="";
       
        for(int i=0; i<breakoutRoomLimit; i++){
            list=breakoutRooms[i].listParticipants();
            while (list.contains(participantID)){
                return breakoutRooms[i].getBreakoutRoomID();
                
            }
 
        }       
        return null;
    }
    

}   

