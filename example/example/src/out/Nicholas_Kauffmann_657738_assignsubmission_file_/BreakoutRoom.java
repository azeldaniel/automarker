package out.Nicholas_Kauffmann_657738_assignsubmission_file_;public class BreakoutRoom       //ID: 816015405
{

    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private int numberOfParticipants;
    private boolean open;
    private Participant[] participants = new Participant[10];
    
    {
        breakoutRoomNumberCounter +=1;      //https://www.geeksforgeeks.org/count-number-of-a-class-objects-created-in-java/
    }
   

    public BreakoutRoom(String name)
    {

        this.breakoutRoomID = (name);
        this.breakoutRoomSize = 10;
    }

    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }

    public boolean addParticipant(String participantID)
    {
        Participant tempParticipant = new Participant(participantID);
        Participant checker = new Participant("null");

        if(Participant.verifyID(participantID)){
            tempParticipant = findParticipant(participantID);   //temp participant = null if participant not in room.

            if(numberOfParticipants < breakoutRoomSize){       //check if room not full

                participants[numberOfParticipants] = new Participant (participantID);
                numberOfParticipants++;

                return true;

            }
            else
                return false;
        }
        else{
            //check = false;
            System.out.println("Invalid ID. Cannot add participant.");
            return false;
        }

            
    }
    
    
    public Participant findParticipant(String participantID){
        Participant searchedParticipant = new Participant("null");
        String id;
        //System.out.println(breakoutRoomID);
        for(int i=0; i<breakoutRoomSize; i++){
            try{
                id = participants[i].getParticipantID();
                //System.out.println(id+ " in findparticipant breakoutroom");
            }
            catch(NullPointerException e){
                //System.out.println("null ptr exception in findparticipant breakroom");
                return searchedParticipant;
            }
            
            if( (participantID).equals(id)){
                //System.out.println("check if equal");
                searchedParticipant = participants[i];           
            }
            //else
               // System.out.println("not found\n");
      
        }
        
        return searchedParticipant;
    }
    
    public String listParticipants(){
        String allParticipants = "";
        String ID;
        //System.out.println(breakoutRoomID+"\nparticipant id [0]: "+participants[0]);
        
        for(int i=0; i<breakoutRoomSize; i++){
            try{
                ID = ( participants[i].getParticipantID() );
                //System.out.println(ID);
                allParticipants = allParticipants+ID+"\n";              
            }
            catch(NullPointerException e){
                //System.out.println("\tError! No participant in this room.");
            }
   
        }
  
        return (breakoutRoomID+"\nParticipants:\n"+allParticipants);        
    }
    
    public String toString(){
        String result = null;
        result = breakoutRoomID+" OPEN?: "+getOpen()+"\n"+"Number of Participants in room: "+numberOfParticipants+"\n";
        
        return (result);
    }
    
    public void closeBreakoutRoom(){
        for(int i=0; i<breakoutRoomSize; i++){
           participants[i] = null;
        }
        numberOfParticipants = 0;
        open = false;
    }
    
    public void openBreakoutRoom(){ 
        open = true;
    }    

}
