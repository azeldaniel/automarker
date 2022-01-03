package out.Kymberly_Byanile_657778_assignsubmission_file_;/* Student ID: 814117667 */

public class BreakoutRoom
{
  //Attributes  
  protected String breakoutRoomID;
  private int breakoutRoomNumberCounter;
  protected int breakoutRoomSize=10; //max capacity
  protected int numberOfParticipants=0;
  private Participant[] participants = new Participant[breakoutRoomSize];
  private boolean open;
  
  public BreakoutRoom (String name){
   //BreakoutRoom newRoom = new BreakoutRoom(name);
   this.breakoutRoomID = breakoutRoomID;
   this.breakoutRoomNumberCounter = breakoutRoomNumberCounter;
   this.breakoutRoomSize = breakoutRoomSize;
   this.numberOfParticipants = numberOfParticipants;
   this.open = open;
  }
  
  public String toString( ){
  
  String curr = "";
  if (open == true){
    
    curr = "OPEN";
  }
   else if (open == false){
    curr = "CLOSED";
   }
  
  
  return "" + breakoutRoomID + " " + curr + " " + numberOfParticipants;
  }
  
  public void closeBreakoutRoom(){
  open = false; //not true that room is open
  numberOfParticipants = 0; //set the participants to 0
  breakoutRoomID = null; //remove the breakout room name
  breakoutRoomNumberCounter -= 1; // decrease count of active roms
  }
  
  
  public void openBreakoutRoom(){
  open = true;
  numberOfParticipants = 0;
  breakoutRoomNumberCounter += 1;
  }
  
  //accessor for participant ID
  public Participant findParticipant(String participantID) {
  //if breakoutroom is open
  if (open == true){
    for (int i = 0; i<breakoutRoomSize; i++){
        String temp = participants[i].getParticipantID();
        if (temp == participantID){
              System.out.println("ID matched a participant:");
              return participants[i];
             }
        }
    }
     else{
        return null;
    }
  
    //if the breakoutroom is not open:
  return null;
}
  
// accessor for numberOfParticipants (###)
  public String listParticipants(){
   System.out.println("Room ID: "+breakoutRoomID);
   System.out.println("Participants ("+numberOfParticipants+") : ");
   
   String list = "";
   for (int i = 0; i < numberOfParticipants; i++){
    String temp = participants[i].getParticipantID();
    list +=(temp);
    list +=" ";
    }
   
    return list;
  }
  
  
  
  public boolean addParticipant(String participantID){
    
    for  (int i=0; i<10; i++){ 
       String temp = participants[i].getParticipantID();
       if (temp == participantID){ //if ID is duplicate
        System.out.println("ID is already present!.");
        return false;
        } 
       }

    if (numberOfParticipants == breakoutRoomSize){ //if room is at max capacity
     System.out.println("This breakout room is at capacity! ID not added.");
    return false;
        }
    else{
      //if the room has space and ID isnt duplicate
     Participant newParticipant = new Participant(participantID);
     this.participants[numberOfParticipants+1] = newParticipant;  
     numberOfParticipants+=1; //update number of participants
    }
    return true;
    }
}
