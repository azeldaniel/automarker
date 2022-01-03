package out.Saajida_Khan_657717_assignsubmission_file_;/**
 * @SaajidaAKhan_816013388
 */
public class BreakoutRoom{
  private String breakoutRoomID;
  private static int breakoutRoomNumberCounter;
  private final int breakoutRoomSize;
  private Participant[] participants;
  private int numberOfParticipants;
  private boolean open;

  public BreakoutRoom(String name){
    this.breakoutRoomID=name+breakoutRoomNumberCounter;
    breakoutRoomNumberCounter=0;
    breakoutRoomSize=10;
    participants= new Participant[10];
    numberOfParticipants=0;
    open=true;
  }

  public boolean addParticipant(String participantID){
    if(participantID!="00000000"){
        if(open){
            for(int x=0; x<=numberOfParticipants; x++){
                if(findParticipant(participants[x].getParticipantID()).equals(null)){
                    numberOfParticipants++;
                    participants[x+1]=new Participant(participantID);
                }
            }
        }
    }
    if(numberOfParticipants<10)return true;
    closeBreakoutRoom();
    return false;
  }

  public void openBreakoutRoom(){
    this.open=true;
  }

  public void closeBreakoutRoom(){
    this.open=false;
  }
  
  public boolean getOpen(){
      return this.open;
  }
  
  public int getBreakoutRoomCount(){
      return this.breakoutRoomNumberCounter;
  }
  
  public String getBreakoutRoomID(){
      return this.breakoutRoomID;
  }
  
  public String toString(){
    if(open)return(this.breakoutRoomID+" OPEN "+ numberOfParticipants);
    return(this.breakoutRoomID+" CLOSED "+ numberOfParticipants);
  }

  public String listParticipants(){
    String list="";
    String name="";
    for(int x=0; x<=numberOfParticipants; x++){
      list+=participants[x].getParticipantID()+" "+"\n";
    }
    return list;
  }

  public Participant findParticipant(String participantID){
    if(open){
      for(int x=0; x<=numberOfParticipants;x++){
        if(participantID.equals(participants[x].getParticipantID()))return participants[x];
      }
    }return null;
  }
  
  public static void main(String[] args){
      Participant p=new Participant("abcdefgh");
      BreakoutRoom b=new BreakoutRoom("Fish");
  }
}