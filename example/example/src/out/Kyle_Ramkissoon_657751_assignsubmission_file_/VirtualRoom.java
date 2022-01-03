package out.Kyle_Ramkissoon_657751_assignsubmission_file_;//[816019715]
public class VirtualRoom{

    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;


    public VirtualRoom(String name){

        System.out.println(name + ": Virtual Room is created..");
        this.name = name;
        breakoutRooms = new BreakoutRoom[5];
        this.breakoutRoomLimit = 5;

        }

    public VirtualRoom(String name, int limit){
       this.name = name;
       breakoutRooms = new BreakoutRoom[limit];
       this.breakoutRoomLimit = limit;

       }

    public int getNumberOfBreakoutRooms(){
       return this.breakoutRoomLimit;

       }

    public void createBreakoutRooms(){
       System.out.println("Breakout Room created for: " + name);
       for (int i = 0; i < this.breakoutRoomLimit; i++){
       	this.breakoutRooms[i] = new BreakoutRoom(this.name);

       }
      }

    public BreakoutRoom findBreakoutRoom(int roomNumber){
       String breakoutRoomID = this.name + roomNumber;

        for(int i = 0; i < this.breakoutRoomLimit; i++){
        	if(this.breakoutRooms[i].getBreakoutRoomID().equals(breakoutRoomID)){
        		return this.breakoutRooms[i];
        		}
        	}
        return null;
       }


    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);

        if (br != null){
        	br.closeBreakoutRoom();
        	return true;
        	}
        return false;
       }

    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);

        if (br != null){
            br.openBreakoutRoom();
            return true;
            }
        return false;
       }



    public String listBreakoutRooms(){
    	System.out.println("Listing Virtual Rooms for: " + name +"\n");

        String details = "";
        for (int i = 0; i < this.breakoutRoomLimit; i++){
        	details += this.breakoutRooms[i].toString() + "\n";
        	}
        return details;
        }

    public String listParticipantsInBreakoutRoom(int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);

        if (br != null && br.getOpen()){

        System.out.println("-------------------------------------------------");
        //System.out.println("Listing Participants for the Breakout Rooms in: ");

        return br.listParticipants();
        }
       return "Error";
    }

    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        BreakoutRoom br = findBreakoutRoom(roomNumber);

        if (br != null){
        br.addParticipant(participantID);
        return true;
        }
        System.out.println("\nError occured, either room did not exist or ID entered is invalid.");
       return false;

    }

    public String findParticipantBreakoutRoom(String participantID){
    	for (int i = 1; i <= breakoutRoomLimit; i++){

            BreakoutRoom br = findBreakoutRoom(i);
            if (br != null){
            	if (br.findParticipant(participantID) != null){
            		return br.getBreakoutRoomID();
            		}
            	}
            }
           return null;
         }
}
