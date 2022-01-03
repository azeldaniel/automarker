package out.Aleksi_Olivier_657749_assignsubmission_file_;/**
 * Write a description of class VirtualRoom here.
 * All classes originally written in VS code
 * @author (ALEKSI OLIVIER 816023287)
 * @version (a version number or a date)
 */
public class VirtualRoom {
    private String name;
    private final int breakoutRoomLimit = 5;
    private BreakoutRoom[] breakoutRooms;

    public VirtualRoom(String name){
        this.name = name;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    public VirtualRoom(String name, int limit){
        this.name = name;
        breakoutRooms = new BreakoutRoom[limit];
        //System.out.println("Room: " +this.name+ " created"); //outputs to test each method is working
    }

    public int getNumberOfBreakoutRooms(){
        return breakoutRooms.length;
    }

    public void createBreakoutRooms(){ //chanege to createBreakoutRooms
        for(int i =0; i<breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
            System.out.println("Breakout Room: " +breakoutRooms[i].getBreakoutRoomID()+ " created");
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int i = 0; i<=breakoutRoomLimit; i++){
            if(roomNumber == i){
                return breakoutRooms[roomNumber-1]; //suppose 1 is input, its supposed to find room 1 which is actually index 0 so it subtracts 1 from i to get there
            }
        }
        return null;
    }


    public boolean closeBreakoutRoom(int roomNumber){
        for(int i = 0; i<=breakoutRoomLimit; i++){
            if(roomNumber == i){
                breakoutRooms[roomNumber-1].closeBreakoutRoom();
                return true;
            }
        }
        return false;
    }

    public boolean openBreakoutRoom(int roomNumber){
        for(int i = 0; i<=breakoutRoomLimit; i++){
            if(roomNumber == i){
                breakoutRooms[roomNumber-1].openBreakoutRoom();
                return true;
            }
        }
        return false;
    }

    public String listBreakoutRooms(){
        String details = "Virtual Room Name: "+name+"\n\n";
        for(int i = 0; i<breakoutRoomLimit; i++){
            details += "BreakoutRoom" +breakoutRooms[i].toString();
        }
        return details;
    }

    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom loc = findBreakoutRoom(roomNumber);
        if(loc != null){
            return loc.listParticipants();
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        if(findBreakoutRoom(roomNumber) !=null){ //if 1 is sent from addParticipant, index is now 0
            findBreakoutRoom(roomNumber).addParticipant(participantID);
            return true;
        }
        return false;
    }

    public String findParticipantBreakoutRoom(String participantID){
        
        int len = participantID.length(); // check lenght of id first
        if(len != 8)
            return null;
        
        for(int i = 0; i<breakoutRoomLimit; i++){
            if(findBreakoutRoom(i+1) != null){
                BreakoutRoom temp = findBreakoutRoom(i+1);
                for(int j = 0; j<temp.getNumberOfParticipants();j++){
                    if(temp.findParticipant(participantID) != null){
                        return breakoutRooms[i].getBreakoutRoomID();
                    }
                }
            }
        }
        return null;
    }

}