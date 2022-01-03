package out.Jeremiah_Strong_657794_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 ** @author (Jeremiah Strong)
 * @ID: 816023620
 */
public class BreakoutRoom 
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=0;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name)
    {
        breakoutRoomNumberCounter++;
        breakoutRoomID= name + breakoutRoomNumberCounter;
        breakoutRoomSize= 10;   //max capacity of participants
        participants= new Participant[10];
        numberOfParticipants= 0;
        open= false;
    }
    
    private void addElement( String ID){
         Participant p= new Participant(ID);
        this.participants[numberOfParticipants]= p;
       // System.out.println("Participant ID, " + ID + ", has been added to " + this.breakoutRoomID);
    }
    
    public boolean addParticipant(String participantID){
        
        if(open){   //if the BreakoutRoom is open
            Participant p= new Participant(participantID);
            boolean check= p.verifyID(participantID);   //verify the password len
            
            if(check){  //if the password length is 8 digits
                
                for(int i=0; i<numberOfParticipants; i++){
                    //Compares each participantID to new participant
                if( participantID.equals(participants[i].getParticipantID()) ){
                    System.out.println("The participant ID, " + participantID + ", already exist.");
                    return false;
                }
         
            }
            
                //If there is no duplicates
                addElement(participantID);
                numberOfParticipants++;
                return true;
         
                
            }
            
            else{   //if the password is not the accurate length
                //System.out.println() is executed in verifyID()
                return false;
            }
            
        }
        else{   //if the breakoutRoom is closed
            System.out.println("This Room is closed.");
            //close Room
            return false;
        }
    }
    
    public Participant findParticipant(String participantID){
        String ID;
        Participant p= new Participant(participantID);
        boolean valid= p.verifyID(p.getParticipantID() );
        if(valid && open ){ //finds out if the Room needs to be open
            for(int i=0; i<numberOfParticipants ; i++){
                ID= participants[i].getParticipantID(); 
                if(ID.equals(participantID) ){
                p = new Participant(ID);
                return p;
                }
           }
            
        }
        
        return null;
    }
    
    public String getParticipantID(String ID){
        Participant p= findParticipant(ID);
        if(p ==null)
            return null;
        else
            return p.getParticipantID();
    }
    

    
    public String listParticipants(){
        String info= "BreakoutRoom ID: " + this.breakoutRoomID + "\n Participants: ";
        
        for(int i=0; i<numberOfParticipants; i++){
            info+= participants[i].getParticipantID() + " ";
        }
        return info;
    }
    
    public String toString(){
        String details= "";
        details += this.breakoutRoomID;
        
        if(this.open== true)
        details += " OPEN ";
        else
        details += " CLOSE ";
        
        details += this.numberOfParticipants + "\n";
        return details;
    }
    
    public void closeBreakoutRoom(){
        //Clears Participant list & closes the room; rests remaining states
        if(this.open==false){
            System.out.println( this.breakoutRoomID + " is already closed.\n" );
            return;
        }
        this.participants= new Participant[10];
        numberOfParticipants= 0;
        open= false;
        System.out.println( toString() );
    }
    
    public void openBreakoutRoom(){
        if(this.open==true){
            System.out.println( this.breakoutRoomID + " is already open.\n" );
            return;
        }
        this.open= true;
        System.out.println( this.breakoutRoomID + " has been opened." );
        System.out.println( toString() );
    }
    
    public String getBreakoutRoomID(){
     return this.breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean isFull(){
        if(numberOfParticipants == breakoutRoomSize)
            return true;
        else
            return false;
    }
    
    public boolean getOpen(){
        if(open== true)
        return true;
        else 
         return false;
    }
    
}
