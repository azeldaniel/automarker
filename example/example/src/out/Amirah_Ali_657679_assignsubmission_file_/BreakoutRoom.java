package out.Amirah_Ali_657679_assignsubmission_file_;//816020184
import java.util.Arrays;

public class BreakoutRoom{
  // instance variables - replace the example below with your own
  private String breakoutRoomID;
  private final int breakoutRoomSize = 10;
  private Participant[] participants;
  private int numberOfParticipants;
  private boolean open;
  private static int breakoutRoomNumberCounter = 1;
  
  //constructor
  public BreakoutRoom(String name){
      breakoutRoomID = name + breakoutRoomNumberCounter;
      breakoutRoomNumberCounter += 1;
      participants = new Participant[10];
      numberOfParticipants = 0;
      open = true;
  }
  
  // acessors 
  public String getBreakoutRoomID(){
      return this.breakoutRoomID;
  }
  
  public int getNumberOfParticipants(){
      return this.numberOfParticipants;
  }
  
  public boolean getOpen(){
      return this.open;
  }
  
  // Methods 
  public boolean addParticipant(String participantID){
      // Breakoout room is full
      if(getNumberOfParticipants() == 10 ||!Participant.verifyID(participantID)){
          return false;
      }
      
      //test
      if (findParticipant(participantID) != null){
          return false;
      }
      
      else{
          participants[getNumberOfParticipants()] = new Participant(participantID);
          this.numberOfParticipants += 1;
          return true;
      }
  }
  
  public Participant findParticipant(String participantID){
      int i=0;
      
      if (getOpen()){
  
          while (i < 10 && participants[i] != null) {
              if ((this.participants[i].getParticipantID()).equals(participantID)){
                  return participants[i];
              }
              
              i++;
            }
      }
      return null;
    }
    
  //>case where breakout room is empty
  public String listParticipants(){
      String list = "";
      
      if (getNumberOfParticipants() == 0){
          list += "\nBreakout room is empty.";
      }
      else{
          for (int i=0; i<participants.length; i++){
              if (participants[i] != null)
                  list += "\n" + participants[i].getParticipantID(); 
              else
                break;
          }
      }
      
      return list;
  }
  
  public String toString(){
      String details = this.getBreakoutRoomID();
      details += this.listParticipants();
      return details;
  }
  
  public void closeBreakoutRoom(){
      Arrays.fill(this.participants, null);
      this.open = false;
  }
  
  public void openBreakoutRoom(){
      this.open = true;
  }
}
