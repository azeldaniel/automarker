package out.Maria_Cadogan_657849_assignsubmission_file_;//816013573

public class VirtualRoom{
    private String name;
    private final int breakoutRoomLimit; 
    private BreakoutRoom[] breakoutRooms;
    private int numberOfBreakoutRooms;
    
    public VirtualRoom(){
        name = null;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name){
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public String getName(){
        return name;
    }
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms(){
        
        for(int i = 0; i < breakoutRoomLimit; i++){
            BreakoutRoom bRoom = new BreakoutRoom(name);
            breakoutRooms[i] = bRoom;
        }
        
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        
        for(int i = 0; i < breakoutRoomLimit; i++){
            String roomID = breakoutRooms[i].getBreakoutRoomID();
            //System.out.println("Rooms: " + roomID);
            if(roomID.equals(name + roomNumber)){
                return breakoutRooms[i];
            }
        }

        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);
        if(br != null){
            br.closeBreakoutRoom();
            return true;
        }
        
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);
        if(br != null){
            br.openBreakoutRoom();
            return true;
        }
        
        return false;
    }
    
    public String listBreakoutRooms(){
        String details;
        //Do error message?
        //details = "No Breakout Rooms are being managed by the Virtual Room as yet";
        
        details = "Virtual Room: " + getName() + "\n";
             
        for(int i = 0; i < breakoutRoomLimit; i++){
            details += breakoutRooms[i].toString() + "\n";
                  
        }
        return details;
        
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        
        for(int i = 0; i < breakoutRoomLimit; i++){
            String roomID = breakoutRooms[i].getBreakoutRoomID();
            
            if(roomID.equals(name + roomNumber)){
                String participantList = breakoutRooms[i].listParticipants();
                return participantList;
            }
        }
        
        return null;
    }
    
    //Check over
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom bRoom = new BreakoutRoom(); 
        bRoom = findBreakoutRoom(roomNumber);
        
        if(bRoom != null){
            boolean added = bRoom.addParticipant(participantID);
            
            if(added == true){
                return added;
            }

         }
         
         return false;
    }
    
    
    public String findParticipantBreakoutRoom(String participantID){
        //BreakoutRoom bRoom = new BreakoutRoom();
        
        for(int i = 0; i < breakoutRoomLimit; i++){
            int amountOfParticipants = breakoutRooms[i].getNumberOfParticipants();
            
            for(int j = 0; j < amountOfParticipants; j++){
                
                if(breakoutRooms[i].findParticipant(participantID) != null){
                    String bRoomID = breakoutRooms[i].getBreakoutRoomID();
                    return bRoomID; 
                }
            }
            
        }
        
        return null;
    }
    
    /*
    //Tests
    public static void main(String[] args){
        VirtualRoom vr1 = new VirtualRoom("Seminar");
        
        System.out.println("Constructor Test for initial states.");
        System.out.println("Virtual Room Name: " + vr1.name);
        System.out.println("Breakout Room Limit: " + vr1.breakoutRoomLimit);
        
        System.out.println("\nAfter Initial: ");
        vr1.createBreakoutRooms();
        //vr1.createBreakoutRooms();
        System.out.println("Found " + vr1.findBreakoutRoom(3));
        //System.out.println("Found " + vr1.findBreakoutRoom(6));
        System.out.println("\n");
        
        
        boolean open = vr1.openBreakoutRoom(1);
        System.out.println("Open: " + open);
        System.out.println("Found " + vr1.findBreakoutRoom(1));
        System.out.println("\n");
        System.out.println(vr1.listBreakoutRooms());
        System.out.println("\n");
        
        System.out.println(vr1.listParticipantsInBreakoutRoom(1));
        
        System.out.println("\nAdding Participants to Breakout Room: ");
        boolean added = vr1.addParticipantToBreakoutRoom("12345678", 1);
        System.out.println("Added: " + added);
        System.out.println(vr1.listParticipantsInBreakoutRoom(1));
        //System.out.println(vr1.listParticipantsInBreakoutRoom(6));
        
        
        System.out.println(vr1.findParticipantBreakoutRoom("12345678"));
        System.out.println(vr1.findParticipantBreakoutRoom("12345679"));
        //boolean close = vr1.closeBreakoutRoom(1);
        //System.out.println("Close: " + close);
        //System.out.println(vr1.listBreakoutRooms());
        

    }
    */
    
}