package out.Lorenzo_La_Caille_657775_assignsubmission_file_;//816015560
public class BreakoutRoom
{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=1;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name)
    {
        
        
        breakoutRoomID=name+breakoutRoomNumberCounter;
        Participant[] participants = new Participant[10];
        numberOfParticipants=0;
        breakoutRoomSize=10;
        open=false;
        breakoutRoomNumberCounter++;
        
    }

    
    public boolean addParticipant(String participantID)
    {
        Participant present=new Participant(participantID);
        present=findParticipant(participantID);
        boolean response=participants[numberOfParticipants].verifyID(participantID);
        Participant p0= new Participant (participantID);
        if(present!=null){
            return false;
        }
        if(numberOfParticipants==breakoutRoomSize){
            return false;
        }
        if(response==false){
            return false;
        }
        
        participants[numberOfParticipants]=p0;
        numberOfParticipants=numberOfParticipants+1;
        return true;
    }
    
    public Participant findParticipant(String participantID){
        for(int i=0;i<numberOfParticipants;i++){
            if(participants[i].getParticipantID().equals(participantID)){
                return participants[i];
            }
        }
        return null;
    }
    
    public String listParticipant(){
        String list=breakoutRoomID;
        for(int i=0;i<numberOfParticipants;i++){
            list=list+participants[i].getParticipantID()+"\n" ;
        }
       
        return list;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
        
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        if(open==true){
            return true;
        }else{
            return false;
        }
    }
    
    /*public String listParticipants(){
        System.out.println(breakoutRoomID);
        String id;
        for (int i=0;i<numberOfParticipants;i++){
            id=participants[i].toString();
        }
    }*/
    
    public String toString(){
        if(open==true){
            String state=breakoutRoomID+" OPEN "+numberOfParticipants;
            return state;
        }else{
            String state=breakoutRoomID+" CLOSE "+numberOfParticipants;
            return state;
        }
        
        
}      

    public void closeBreakoutRoom(){
        
    open=false;
    for(int i=0;i<numberOfParticipants;i++){
            participants[i]=null;  
    }
    numberOfParticipants=0;
}
    
    public void openBreakoutRoom(){
        open=true;
}
}
    
    
            
        
        
            
        
        
        
        
            
        
       
    

