package out.Kwame_Trancoso_657796_assignsubmission_file_;//816005595
public class BreakoutRoom
{
    public String breakoutRoomID;
    public int breakoutRoomNumberCounter;
    public int breakoutRoomSize=10;
    public Participant[] participants;
    public int numberOfParticipants;
    public boolean open;
    
    public BreakoutRoom(String name, int num)
    {
      breakoutRoomNumberCounter=num;
      breakoutRoomID=name+breakoutRoomNumberCounter;
      participants = new Participant[10];
      numberOfParticipants=0;
      open=true;
    }
    
    public String getbreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getStatus(){
        return open;
    }
    
    public boolean addParticipant(String participantID){
        if(open==false)
            return false;
        if (participantID.length()==8 && numberOfParticipants<10){
            participants[numberOfParticipants]= new Participant(participantID);
            numberOfParticipants+=1;
            return true;
        }
        return false;
    }
    
    public Participant findParticipant(String participantID){
        for(int i = 0; i < 9; i++)
            if(participants[i].getParticipantID()==participantID)
                return participants[i];
            return null;
    }
    
    public String listParticipants(){
        String list;
        list = breakoutRoomID + "\n";
        for(int i = 0; i < numberOfParticipants; i++)
            list+=participants[i].getParticipantID() + "\n";
        return list;
    }
    
    public String toString(){
        String s,status;
        if(!open)
            status="CLOSED";
        else
            status="OPEN";   
        s= breakoutRoomID + " " + status + " " + numberOfParticipants;
        return s;
    }
    
    public void closeBreakoutRoom(){
        open = false;
        numberOfParticipants=0;
        participants = null;
    }
    
    public void openBreakoutRoom(){
        open = true;
    }
}
