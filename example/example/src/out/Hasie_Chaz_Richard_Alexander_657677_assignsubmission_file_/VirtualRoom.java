package out.Hasie_Chaz_Richard_Alexander_657677_assignsubmission_file_;

 //ID: 816021429
 
public class VirtualRoom
{

    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[ ] breakoutRooms;
    private int r = 0;
    
    

    //Constructor
    public VirtualRoom(String name)
    {
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
       
    }
    
    public VirtualRoom( String name, int limit)
    {
     
     this.name = name;
     breakoutRoomLimit = limit;
     breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    
    }
    
    //Methods
    public void createBreakoutRooms( )
    {
       
      
      
       while (r < breakoutRoomLimit ){
           
        breakoutRooms[r] = new BreakoutRoom(name);
       
       
        r++;
           
        }
        
    }
   
    
    public String listBreakoutRooms( )
    {
    
    String list1;
    String list2 = null;
    String list3;
    
    list1 = "            Virtual Room Name \n                   " + name + "\n\n" + "               BreakoutRooms \n";
    
    list3 = list1;
    int b;
    
    b = breakoutRoomLimit - 1;
      
      for(int z = 0; z < breakoutRoomLimit; z = z + 1){
        
          if(z == b){
            list2 = "                 " + breakoutRooms[z].getBreakoutRoomID();
            }
            
            else{
            if(z == 0){
            list2 = "    " + breakoutRooms[z].getBreakoutRoomID() + "\n";
            }
            
            list2 = "                 " + breakoutRooms[z].getBreakoutRoomID() + "\n";
            
            }
            
        
  
        list3 = list3 + list2;  
        
        } 
        
        
     
     
     
      
     return list3;
        
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
    
    BreakoutRoom list;
    String l1;
    
    
    list = findBreakoutRoom(roomNumber);
    
    if(list == null)
    {
      return null;
    
    }
    else
    {
    
     l1 = list.listParticipants();
     return l1;
     
    }
        
        
  
     
    }
    
      public String findParticipantBreakoutRoom (String participantID)
     
      {
       String ID = null;
       String tester;
       
       for(int hi = 0; hi < breakoutRoomLimit; hi++){
        
              
                     
              if(breakoutRooms[hi].findParticipant(participantID) != null)
              {
                
              ID = breakoutRooms[hi].getBreakoutRoomID();
              
              }
              
      
        
        }
    
       if(ID != null)
       {
       
       return ID;
        
       }
       else
       {
        return null;
       }
    
    
    
     }
       
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        
    BreakoutRoom br;
    boolean added = false;
    
    
    
    br = findBreakoutRoom(roomNumber);
    
    if(br != null){
        
    added = br.addParticipant(participantID);
    
    if(added == true)
    {
    
      return true;   
    
    }
    
    else
    {
    
    return false;
    
    }
    
    }
    
    else
    {
    return false;
    }
    
    

    
    
    }
    
    
    public boolean openBreakoutRoom(int roomNumber)
    {
     
     BreakoutRoom l;
     
     
     l = findBreakoutRoom(roomNumber);
     
     if(l == null)
     {
        
     return false;
     
     }
     else
     {
        
       l.openBreakoutRoom(); 
       return true;
     }
     
     
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
    
     BreakoutRoom b;
     
     b = findBreakoutRoom(roomNumber);
     
     if(b == null)
     {
        
     return false;
     
     }
     else
     {
        
       b.closeBreakoutRoom();
       return true;
       
     }
     
     
     
    
    
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        //https://www.w3schools.com/java/java_ref_string.asp
        // used to fing out String methods .charAt and .valueof.
        
        boolean found = false;
        int location = -1;
        
       
       
       
       for(int c = 0; c < breakoutRoomLimit; c++)
       {
        
       String s = breakoutRooms[c].getBreakoutRoomID(); 
       String g = String.valueOf(roomNumber);
       int k = 0;
       int y = 0;
       int n = 0;
       int a = 0;
       char[] d = new char[s.length()];
       char[] e = new char[g.length()];
       
        
       
       
       while(y < s.length())
       {
        
        d[y] = s.charAt(y);   
        y = y + 1;
        
        }
        
        
        
        //Room Number
       while(n < g.length())
       {
        
        e[n] = g.charAt(n);   
        n = n + 1;
        
        }
        
          
        n = 0;
        k = 0; 
        
        
        for (int f = 0; f < s.length(); f++)
        {   
            if(d[f] >= 'a' && d[f] <= 'z' || d[f] >= 'A' && d[f] <= 'Z'){
           
                  k++;
            }
            
            else if (d[f] >= '0' && d[f] <= '9' ){
                n++;
            }
           
        
        
        }
        
        
        
         if ( n == g.length())
         {
            
        for(int j = 0; j < n; j++)
        {
          
          if(d[k] == e[j])
          {
          a = a + 1;
          k++;
          }
          
        
        }
          
        if(a == n){
        found = true;
        location = c;
        }
      
         
       
       }
          
    
      } 
       
      
      
        if(found == true && location != -1)
      {
       return breakoutRooms[location];
      }
      
      else
      {
       return null; 
      }
        
        
        
       
    
    
    
    }  
    
    
    public int getNumberOfBreakoutRooms( )
    {
      return breakoutRoomLimit;
    }
    
    
}
    
    

