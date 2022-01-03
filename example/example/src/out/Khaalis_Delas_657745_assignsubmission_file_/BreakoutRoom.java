package out.Khaalis_Delas_657745_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//Khaalis De Las- 8160071114
public class BreakoutRoom 
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize=10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    private String BreakoutRoomName;
    private final int breakoutRoomLimit=5;
    private String VirtualRoomName;
    
    private static int brIDGenerator = 1;
    //Participant p1= new Participant();
    
    
    
    public String getBreakoutRoomID(){
    return breakoutRoomID;
}
 public int getNumberOfParticipants(){
    return numberOfParticipants;
}
    
    //constructor 
    public BreakoutRoom(String name){
        this.breakoutRoomID= name;
        breakoutRoomNumberCounter=0;
        participants= new Participant[10];
        numberOfParticipants=0;
        open=true;
        
 
        //breakoutRoomID
        /*
     String IDdetails= "Workshop" + brIDGenerator++;
      BreakoutRoomName= name;
      name= VirtualRoomName;
     */
    }
    
    public boolean addParticipant(String participantID){
    if( numberOfParticipants < 10 && open == true){
    Participant p= new Participant(participantID);
    if  (p.verifyID(participantID) == true){
        participants[numberOfParticipants] = p;
                numberOfParticipants++;

        return true;
    }
    }
    return false;
    }
    
    public Participant findParticipant(String participantID){
        Participant p= new Participant(participantID);
        if( p.verifyID(participantID) && open == true){
    for (int i=0; i<10; i++ ){//less that 10 since its per room??
        if(participantID.equals(participants[i])){
            
       // return System.out.println("Participant: " + participants[i] + 
       // " was found");
        return participants[i];
    }
    }
}
        return null;
    
        //not found

    }
    
    public String listParticipants(){
        String pList= " ";
    for(int i=0; i<numberOfParticipants; i++){
    pList= pList + " Breakout RoomID " + breakoutRoomID;
    pList= pList + "Participant" + participants[i] + "\n";
    
    }
    
    return pList;
    
    }
    
    public String toString(){
    String details= (" ");
    details= "BreakoutRoom ID: " + breakoutRoomID + "\n";
    
    details= "BreakoutRoom Size: " + breakoutRoomSize + "\n";
    
    details= "Number of participants in room : " + numberOfParticipants + "\n";
    
    details= "Room Availability: " + open + "\n";
    
    return details;
    
    
    }
    
    
    public void closeBreakoutRoom(){
    this.numberOfParticipants=0;
    this.open= false;
    participants= new Participant[0];
    
    
    }
    
    public void openBreakoutRoom(){
    this.numberOfParticipants=10;
    this.open= true;
    participants= new Participant[10];
    
    }
    
    public boolean getOpen(){
    return open;
    }
    
    public static boolean verifyID(String participantID){
    //if participantID==
    return true;
    }
    
}
