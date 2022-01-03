package out.Andrei_Guevara_657703_assignsubmission_file_;/**816022711
 * Andrei Guevara
 * OwO - O3O
**/

public class VirtualRoom{
    
    private String name = "";
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms = null;
    
    
    VirtualRoom(String name){
        
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        //createBreakoutRooms();
        
    }
    
    
    VirtualRoom(String name, int limit){
        
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
        //createBreakoutRooms();
        
    }
    
    
    public int getNumberOfBreakoutRooms(){
 
        int i=0;
        
        while (i < this.breakoutRoomLimit && this.breakoutRooms[i] != null)
        
            if (this.breakoutRooms[i].getOpen())
                
                i++;
        
        return i;
        
    }
    
    
    public void createBreakoutRooms(){
        
        for (int count = 0; count < this.breakoutRoomLimit; count++)
            
            this.breakoutRooms[count] = new BreakoutRoom(this.name);
        
            this.breakoutRooms[0].breakoutRoomNumberFixer();
            
    }
    
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        
        if (roomNumber >= 1 && roomNumber <= this.getBreakoutRoomLimit() && this.getBreakoutRooms()[(roomNumber-1)] != null)
        
            return this.getBreakoutRooms()[roomNumber-1];
        
        return null;
        
    }
    
    
    public boolean closeBreakoutRoom(int roomNumber){
        
        BreakoutRoom temp = this.findBreakoutRoom(roomNumber);
        boolean state = false;
        
        if (temp != null){
        
            temp.closeBreakoutRoom();
            state = true;
            
        }
        
        return state;
        
    }
    
    
    public boolean openBreakoutRoom(int roomNumber){
        
        BreakoutRoom temp = this.findBreakoutRoom(roomNumber);
        boolean state = false;
        
        if (temp != null){
        
            temp.openBreakoutRoom();
            state = true;
            
        }
        
        return state;
        
    }
    
    
    public String listBreakoutRooms(){
    
        String list = name + "\n";
        
        for (int count = 0; count < getNumberOfBreakoutRooms(); count++){
            
            list += breakoutRooms[count].toString() + "\n";
            
        }

        return list;
        
    }
    
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        
        BreakoutRoom temp = this.findBreakoutRoom(roomNumber);
        
        if (temp != null)
            
            return temp.listParticipants();

        return null;
        
    }
    
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        
        BreakoutRoom temp = findBreakoutRoom(roomNumber);
        boolean res = false;
        
        if (temp != null){
         
            temp.addParticipant(participantID);
            res = true;
            
        }
        
        return res;
        
    }
    
    
    public String findParticipantBreakoutRoom(String participantID){
        
        for (int count = 0; count < breakoutRoomLimit; count++){
           
            if (this.breakoutRooms[count].findParticipant(participantID) != null){
               
                return this.breakoutRooms[count].getBreakoutRoomID();
                
            }
            
        }
        
        return null;
        
    }
    
    
    public int getBreakoutRoomLimit(){
     
        return breakoutRoomLimit;
        
    }
    
    
    public BreakoutRoom[] getBreakoutRooms(){
        
        return breakoutRooms;
        
    }

    /*
    public static void main(String[] args){
        
        VirtualRoom vr = new VirtualRoom("Hell");
        
        System.out.println(vr.getNumberOfBreakoutRooms());
        
        vr.createBreakoutRooms();
        
        System.out.println(vr.getNumberOfBreakoutRooms());
        
        int x = 0;
        
        while (x < 5){
            
            if (vr.findBreakoutRoom(x) != null)
                
                System.out.println("Room found.");
                
            else
            
                System.out.println("Room not found.");
            
                
            x++;
        }

    }
    */
}
