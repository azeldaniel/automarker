package out.Dhanesh_Sankar_657707_assignsubmission_file_;
/**
Dhanesh Sankar
816020350
 */

public class BreakoutRoom
{
    // instance variables
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name){
        this.breakoutRoomID=String.valueOf(this.breakoutRoomNumberCounter);
        this.breakoutRoomNumberCounter++;
        this.breakoutRoomSize=10;
        this.participants = new Participant[breakoutRoomSize];
        this.numberOfParticipants=0;  
        this.open = true;   
    }
    
    /**
     * Accessors 
     */
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    } 
     
    public int getNumberofParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public boolean addParticipant(String participantID){
        Participant Newp = new Participant(participantID);
        String NewID = Newp.getParticipantID();
        boolean checkID = Newp.verifyID(NewID);
        if(this.numberOfParticipants == 10){
            System.out.println("The breakout room is full.");
            return false;
        }        
        if((open==true) && (checkID == true)){
            this.participants[numberOfParticipants]=Newp;
            this.numberOfParticipants+=1;
            return true;
        }        
        return false;       
    }
    
    public Participant findParticipant(String participantID){
       boolean checkID;
       Participant x= new Participant(participantID);
       checkID = x.verifyID(participantID); 
       if(checkID == true){
           for(int num=0; num<numberOfParticipants;num++){
               if(this.participants[num].getParticipantID().equals(participantID)){
                   return this.participants[num]; 
                } 
            }          
       }
       return null;
    }

    public String listParticipants(){
        String listOfParticipants = "List of Participants: " + "\n";; 
        listOfParticipants = "BreakoutRoom ID: " + " " + getBreakoutRoomID() + "\n"; 
        //listOfParticipants = listOfParticipants + "List of Participants: " + "\n";
       
        for(int num = 0; num< numberOfParticipants; num++){
            listOfParticipants = listOfParticipants +  this.participants[num].getParticipantID() + "\n";
        }   
         return listOfParticipants;    
    }
    
    public String toString(){
        String Roomdetails ="BreakoutRoom Number:" + " " + breakoutRoomID + "\n";
        Roomdetails += "Number of Participants: " + " " + numberOfParticipants + "\n";
        Roomdetails += "Room Open?: " + " " + getOpen() + "\n";
        return Roomdetails;
    }
    
    public void closeBreakoutRoom(){
       this.participants=null;
       this.open=false;
       this.numberOfParticipants=0;
    }
    
    public void openBreakoutRoom(){
        this.open= true;
    }
}