package out.Dexter_Singh_671780_assignsubmission_file_;//816009215
public class BreakoutRoom
{
  private String breakoutRoomID;
  public int breakoutRoomNumberCounter;//should this not be in the virtualRoom class? why count within the room itself?
  private int breakoutRoomSize = 10;
  private Participant[] participants;
  protected int numberOfParticipants;
  private boolean open;
  
  //constructor
  public BreakoutRoom(String name){
      breakoutRoomID = name; //passed in name + breakoutRoomNumber
      participants = new Participant[breakoutRoomSize];
      numberOfParticipants = 0;
      openBreakoutRoom();
  }
  
  //methods/behaviours-accessors-mutators
  public boolean addParticipant(String participantID){
      if((numberOfParticipants < breakoutRoomSize) && open){
          participants[numberOfParticipants] = new Participant(participantID);
          numberOfParticipants++;
          return true;
        }
      return false;
  }
  
  public Participant findParticipant(String participantID){
      for(int i = 0; i < numberOfParticipants; i++)
        if ((participants[i].getParticipantID().equals(participantID)) && open)
            return participants[i];
      return null;
  }
  
  public String listParticipants(){
      String list = breakoutRoomID + "\nParticipants:";
      if(numberOfParticipants >= 1){
        for(int i = 0; i < numberOfParticipants; i++){
            list = list + participants[i].getParticipantID() + " ";
        }
      }
      return list + "\n";
  }
  
  public String toString(){
      String state = "";
      state = breakoutRoomID + " " + open + " " + String.valueOf(numberOfParticipants);
      return state;
  }
  
  public void closeBreakoutRoom(){
    this.participants = null;
    this.numberOfParticipants = 0;
    this.open = false;
  }
    
  public void openBreakoutRoom(){
    this.open = true;
  }
}
/* Sources:
 * Lecture Notes
 * Convert int to string in java: https://www.educative.io/edpresso/how-to-convert-an-integer-to-a-string-in-java
 */
