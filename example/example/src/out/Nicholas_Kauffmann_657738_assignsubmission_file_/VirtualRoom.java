package out.Nicholas_Kauffmann_657738_assignsubmission_file_;  
public class VirtualRoom        //ID: 816015405
{

    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;


    public VirtualRoom(String name)
    {
        this.name = name;
        breakoutRoomLimit = 5;      
        breakoutRooms = new BreakoutRoom[5];
    }
    
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[limit];
    }


    public int getNumberOfBreakoutRooms()
    {
        return breakoutRoomLimit;
    }


    public void createBreakoutRooms(){
        for(int i=0; i<breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom("Breakout Room "+(i+1));
            //System.out.println("Created breakout Room");
        }
        
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        BreakoutRoom searched ;
        if ((roomNumber >= breakoutRoomLimit) || (roomNumber<0)){
            searched = null;     
            return searched;
        }
        else{
            return breakoutRooms[(roomNumber)];
        }         
        
    }
    
    public boolean closeBreakoutRoom (int roomNumber){
        BreakoutRoom temp = null;
        temp = findBreakoutRoom(roomNumber);
        if(temp != null){                                           //check if room exists
             breakoutRooms[(roomNumber)].closeBreakoutRoom();
             return true;
        }
        else{
            return false;
        }
    }
    
    public boolean openBreakoutRoom (int roomNumber){
        BreakoutRoom temp = null;

        temp = findBreakoutRoom(roomNumber);
        if(temp !=null){
            breakoutRooms[(roomNumber)].openBreakoutRoom();
            return true;
        }
        else{
            return false;
        }
        
    }

    public String listBreakoutRooms (){
        String a ="Virtual Room: "+name+"\n"+"Breakout Rooms: \n";
        String b = null;
        String result = "";
        for(int i=0; i<breakoutRoomLimit; i++){
            b = breakoutRooms[i].toString();
            result = result+b+"\n";
        }


        return (a+result);
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String participants = "";
        if(roomNumber >= 0 && roomNumber<11)
            participants = breakoutRooms[(roomNumber)].listParticipants();
        else
            return ("Invalid roomNumber");
        
        return (participants);
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        Boolean check;
        if(roomNumber < breakoutRoomLimit){
            check = breakoutRooms[(roomNumber)].addParticipant(participantID);      //true = added

            if (check == false && (breakoutRooms[roomNumber].getNumberOfParticipants()) == (10))
                System.out.println("Cannot add participant to room.\tRoom is full!");
            return check;
        }
        else{
            System.out.println("Invalid Room Number");
            check = false;
            return check;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String result = new String();
        int roomNum = 0;
        
        for(int i=0; i<breakoutRoomLimit; i++){
            roomNum = i;


            if(breakoutRooms[i].findParticipant(participantID).getParticipantID() !="null"){
                result = "Found participant in "+breakoutRooms[i].getBreakoutRoomID();
                break;
            }
            else
                result = "Participant not found";

        }





        return(result);
    }
    

}
