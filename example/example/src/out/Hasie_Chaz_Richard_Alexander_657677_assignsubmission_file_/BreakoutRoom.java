package out.Hasie_Chaz_Richard_Alexander_657677_assignsubmission_file_;

 //ID: 816021429



public class BreakoutRoom
{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter= 1;
    private final int breakoutRoomSize;
    private Participant[ ] participants;
    private int numberOfParticipants;
    private boolean open;
    
    //Constructor
    public BreakoutRoom(String name)
    {
        
        breakoutRoomNumberCounter = breakoutRoomNumberCounter;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomSize = 10; 
        numberOfParticipants = 0;
        open = false;
        participants = new Participant[breakoutRoomSize];
        breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1; 
       
    }
    
    //Methods
    public  String toString( )
    {
    
    String roomList;
    
    if (open == true)
    {
    
    roomList = breakoutRoomID + " OPEN " +  numberOfParticipants;
    
    }
    
    else 
    {
    
     roomList = breakoutRoomID + " CLOSED " +  numberOfParticipants;
    
    }
    
    
    
    return roomList;
    
    
  }

    
   
    
    
    public void openBreakoutRoom( ){
   
     open = true;
     
    }
    
    public void closeBreakoutRoom( )
    {
    
        
     for(int y = 0; y < numberOfParticipants; y++)
     {
        participants[y] = null;     
     }  
    
    open = false;
    numberOfParticipants = 0;
    
    }
    
    public Participant findParticipant( String participantID)
    {
        boolean c = false;
        Participant a = new Participant(participantID);
        boolean check = false;
        int index = -3;
        
        
        c = a.verifyID(participantID);
        
        if(c == true && open == true)
        {
            
            for(int x = 0; x < numberOfParticipants; x++)
            {
            
              if(participantID.equals(participants[x].getParticipantID()))
               {
                 check = true;
                 index = x;
               } 
              
              
            }
        
        
        } 
        
        if(check == true && index != -3)
        {
         return participants[index];
        
        }
        else
        {
        return null;
        }
        
    
    
    }
    
    public boolean addParticipant( String participantID)
    {
        
        boolean finder = false;
        boolean dup = false;
        Participant b = new Participant(participantID);
        
        
        finder = b.verifyID(participantID);
        
        if(finder == false)
        {
        
        return false;
        
        }
        
         for(int w = 0; w < numberOfParticipants; w++)
             {
             
               if(participantID.equals(participants[w].getParticipantID()))
               {
                 dup = true;
               } 
            
            }
        
         if(finder == true && open == true && numberOfParticipants <  breakoutRoomSize)
           {
               
         
            if(dup == false)
            {
           
            participants[numberOfParticipants] = new Participant(participantID);
            numberOfParticipants++;
            
            }
           
        
    
           }
        
        if(dup == false)
            {
            return true;
            }
            else{
            
            return false;
        
        }
        
   
       
       
    
    }
    
    public String listParticipants( )
    {
    
    String pList;
    String pList2 = null;
    String pList3;
    int v = 0;
    
    
    pList = "                " + breakoutRoomID + "                    \n             ";
    
    
    
    
    pList3 = pList;
    
    
    v = numberOfParticipants - 1;
      
      for(int m = 0; m < numberOfParticipants; m++){
        
          if(m == v){
             pList2 = "                 " + participants[m].getParticipantID( );
            }
            else{
             if(m == 0){
               pList2 = "    " + participants[m].getParticipantID( ) + "\n";  
             } 
             else {
                 
                
                pList2 = "                 " + participants[m].getParticipantID( ) + "\n";
                
                }
             
            
            }
            
        
  
           pList3 = pList3 +  pList2 ;  
        
        } 
        
    
     return pList3;
      
    }
        
    public String getBreakoutRoomID()
    {
    
    return breakoutRoomID;
    
    }
    
    public int getNumberOfParticipants() 
    {
    
    return numberOfParticipants;
    
    }
    
    public boolean getOpen()
    {
    
    return open;
    
    } 
    
   
    
    
    
     
    
    
    

    
    
}
