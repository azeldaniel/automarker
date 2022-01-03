package out.Hasie_Chaz_Richard_Alexander_657677_assignsubmission_file_;

 //ID: 816021429

import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class VirtualMeetingSystem
{
    
     private  String[] arr;
     private VirtualRoom v;
     private int counter = 0;
     private int rnum = 1;
     private int q =0;
     private int half; 
    
        
    
    public void loadParticipantData  (String filename)
    {  
        // Step 1:
        //Count how many lines first inorder to get the number of ID's there are in the file
        //Step 2:
        // Create array and put elements inside
        
        
       
      try {
        
      File part = new File(filename);
      Scanner scanner1;
      
      scanner1 = new Scanner(part);
     
       
      while (scanner1.hasNextLine()) {
       scanner1.next();   
       counter = counter + 1;
       
      }
      
     
      arr = new String [counter];  
      
      Scanner scanner2;
      
      scanner2 = new Scanner(part);
      
      
      
      for(int y = 0; y < counter; y = y + 1){
           arr[y] = scanner2.next();
           
        
       }
       
       half = ((counter/2));
       
      
    }
 
    catch (FileNotFoundException e ) {
      System.out.println(" Error ....... File not found");
     
    }
    
    
    
    } 
    
        
    public void createVirtualRoom(String name)
    {
    
    
       v = new VirtualRoom(name);
       v.createBreakoutRooms( );
       
       
    
    
    } 
    
    public boolean openBreakoutRoom(int roomNumber)
    {
    
    boolean is;
    
    is = v.openBreakoutRoom(roomNumber);
    
    if(is == true)
    {
    
    return true;
        
    }
    
    else 
    {
    return false;
    }
    
    
    }
    
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
    boolean it;
    
    it = v.closeBreakoutRoom(roomNumber);
    
    if(it == true)
    {
    
    return true;
        
    }
    
    else
    {
    return false;
    }
    
    }
    
    
    public String listParticipants(int roomNumber)
    {
    
    String ok;
    
    ok = v.listParticipantsInBreakoutRoom(roomNumber);
    
    if(ok != null)
    {
   
    return  ok;
    }
    
    else
    {
    return null;
    }
    
    
    }
    
    
    
     
    public void allocateParticipants(String code )
    {
    
     
       
     
     if(code == "C5")
     {
       
       
   
    
       for(int f = 0; f < 5; f = f + 1)
       {
        
       for( int r = 0; r < 5; r++){
        
        
            
        v.addParticipantToBreakoutRoom(arr[q],rnum);
        q++;
        
           
        
        
        }
        
        rnum = rnum + 1;
       
        
       
        
        }
        
       
      rnum = 1;  
      
      
    }
     
     else if(code == "RR")
     {
        
           
        
           for(int u = 0; u < 5; u++)
           {
             if(half >= counter)
             {
               break;   
             } 
             else
             {
             v.addParticipantToBreakoutRoom(arr[q],rnum);
             v.addParticipantToBreakoutRoom(arr[half],rnum);
             
             q++;
             half++;
             rnum = rnum + 100;
             
             
             }
            
           }
           
           
          rnum = 100;
        
        
         
     
        
     }
    
    
    
    }
    
    
    public boolean addParticipant (String participantID, int roomNumber)
    {
    
    Boolean tru;
    
    tru = v.addParticipantToBreakoutRoom(participantID,roomNumber);
    
    if(tru == true)
    {
    
    return true;
    
    }
    
    else
    {
        
    return false;
    
    }
    
    
    
    } 
    
    public String findParticipantBreakoutRoom(String participantID)
    {
    String e;
    
    e = v.findParticipantBreakoutRoom(participantID);
    
    if(e == null)
    {
    return null;
    
    }
    
    else
    {
    
    return e;
    
    }
    
    
    }
    
    public String listAllBreakoutRooms( )
    {
    String all;
    
    all = v.listBreakoutRooms();
    
    return all;
    
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
    
    String room1;
    String room2;
    String room3;
    String room4;
    String room5;
    String total;
    
    room1 = v.listParticipantsInBreakoutRoom(1);
    room2 = v.listParticipantsInBreakoutRoom(2);
    room3 = v.listParticipantsInBreakoutRoom(3);
    room4 = v.listParticipantsInBreakoutRoom(4);
    room5 = v.listParticipantsInBreakoutRoom(5);
    
    if(room1 == null || room2 == null || room3 == null || room4 == null || room5 == null)
    {
    return null;
    }
    else
    {
    total = room1 + "\n\n" + room2 + "\n\n" + room3 + "\n\n" + room4 + "\n\n" + room5;
     return total;
    }
    
   
    
    }
    
    
    
    
    
    
    
    
}
    
    
    

