package out.Amrik_Boodoo_657780_assignsubmission_file_;
/**
 * 
 *
 * Amrik Boodoo 816018329
 * 
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=0;    
    private final int breakoutRoomSize=10;
    private Participant[] participants;
    private int numberOfParticipants=0;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        breakoutRoomNumberCounter+=1;           //increment with each new breakout Room  
        breakoutRoomID= name + breakoutRoomNumberCounter;
        numberOfParticipants=0;
        participants= new Participant[breakoutRoomSize];

        open= true;
        
        
    }

    
    public boolean addParticipant(String participantID)
    {
       
        // if breakout room is full or participant ID is not valid then return false;
        if ((numberOfParticipants == breakoutRoomSize)|| participantID.length()!=8){
            return false;
        }
        else{
         
             
         for (int i=0; i<numberOfParticipants; i++){
             if(participants[i]!=null){
                   // if participant ID is already in breakroom then return false
                 if(participants[i].getParticipantID()==participantID){
                     return false;
                  }
                 
            
               }
         }

            participants[numberOfParticipants]= new Participant(participantID);
            numberOfParticipants+=1;
         
        }
        return true;
   
    }


    
    public Participant findParticipant(String participantID)
     {
         // fix if statement
         if((open==true) && (participantID.length()== 8)){
             for (int i=0; i<breakoutRoomSize; i++){
                 if(participants[i].getParticipantID().equals( participantID)){
                     return participants[i];
                }
                
             }
         
        }
        return null;
    }
    
    public String listParticipants()
    {
        String list;
        list= breakoutRoomID + "\n";
     
        for (int i=0; i<breakoutRoomSize; i++){ 
            if(participants[i]!=null){
                
                //list+= participants[i].toString();     ADDED
                list+=participants[i].getParticipantID();
                list+="\n";
            }
            
        }
        return list;
    }
        
    public String toString()
    {
        String state;
        
        state= breakoutRoomID +" " + open;//+ numberOfParticipants; 
        
        return state;
    }
        
    public void closeBreakoutRoom()
    {
        open= false;
        for (int i=0; i<breakoutRoomSize; i++){
            participants[i]=null;
        }
        numberOfParticipants=0;
          
    }
    
    public void openBreakoutRoom()
    {
        open= true;
        
        
    }

    public String getBreakoutRoomID(){
        return breakoutRoomID;
        
    }
    
    public boolean getOpen(){  
        return open;
        
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
        
    }

}
