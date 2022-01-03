package out.Jediah_Castle_657839_assignsubmission_file_;public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private int RoomNum;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        breakoutRoomID = name;
        RoomNum = breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        numberOfParticipants = 0;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        open = false;
    }
     
    public boolean addParticipant( String participantID){
        if(numberOfParticipants < 10 && open == true){
            participants[numberOfParticipants] = new Participant(participantID);
            numberOfParticipants++;
            return true;
        }
        return false;
    }
    
    public Participant findParticipant( String participantID){
        for(int i = 0; i < numberOfParticipants; i++){
            String pID = participants[i].getParticipantID();
            if(pID.equals(participantID)){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipants(){
        if(open == false){
          return "Breakout room close";
        }
        else{
           String list = "Breakout Room";
           for(int i = 0; i < numberOfParticipants; i++){
           list += "\n" + participants[i].toString();
          }
          return list;
        }
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID + RoomNum;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public String toString(){
        String details = breakoutRoomID + RoomNum;
        if(open == true){
            details += " OPEN" +  numberOfParticipants;
        }
        return details;
    }
    
    public void closeBreakoutRoom(){
        open = false;
        RoomNum = 0;
        for(int i = 0; i < numberOfParticipants; i++){
         participants[i] = null;
        }
        numberOfParticipants = 0;
    }
    
    public void openBreakoutRoom(){
        open = true;
        //RoomNum = breakoutRoomNumberCounter++;
    }
    /*
     //Used for testing
     public static void  main(String[] args){ 
        System.out.println("Breakout Room"); 
        BreakoutRoom b1 = new BreakoutRoom("Seminar");
        BreakoutRoom b2 = new BreakoutRoom("Seminar");
        b1.closeBreakoutRoom();
        b2.closeBreakoutRoom();
        System.out.println(b1.toString());
        System.out.println(b2.toString());
    } 
   */
}
