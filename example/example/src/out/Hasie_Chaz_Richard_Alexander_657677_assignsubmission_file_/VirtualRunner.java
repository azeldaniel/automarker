package out.Hasie_Chaz_Richard_Alexander_657677_assignsubmission_file_;
// ID: 816021429
  


public class VirtualRunner
{
    
    
    public static void main (String[] args){
   
    VirtualMeetingSystem vir = new VirtualMeetingSystem();
    String s = null;
    String hop = null;
    String in = null;
    String out = null;
    String pID = "00000001";
    int rNum1 = 2;
    int rNum2 = 1;
    boolean j = false;
    
    
    vir.loadParticipantData("participant.dat");
    vir.createVirtualRoom("VirtualRoom");
    
    for(int x = 1; x <= 5; x = x + 1)
    {
        
     
     j = vir.openBreakoutRoom(x); 
     
     if(j == true){
        System.out.println("Room" + x + "opened");
        }
     
     
    } 
 
    
    
   
      
    
    vir.allocateParticipants("C5");
  
    vir.addParticipant (pID,rNum2);
    
    s = vir.listParticipants(rNum2);
    
    if(s == null)
      {
       System.out.println("            LIST OF PARTICIPANTS    " + "\n\n"); 
       System.out.println("BreakoutRoom is empty");
      }
    
    else
      {
      System.out.println("            LIST OF PARTICIPANTS    " + "\n\n");  
      System.out.println(s + "\n");  
      }
      
      hop = vir.findParticipantBreakoutRoom(pID);
      
      if(hop == null)
      {
       System.out.println("           FINDING PARTICIPANT BREAKOUTROOM \n  ");  
       System.out.println("Participant isn't in a BreakoutRoom");
      }
    
    else
      {
      System.out.println("           FINDING PARTICIPANT BREAKOUTROOM \n  ");    
      System.out.println(  "\n\n     THE BREAKOUTROOM " + pID + " BELONGS TO IS " + hop + "\n\n");  
      }
      
      
      out =  vir.listAllBreakoutRooms();
      
      System.out.println("           LIST OF ALL BREAKOUTROOMS  ");
      
      System.out.println("\n\n" + out + "\n\n\n");  
      
      in = vir.listParticipantsInAllBreakoutRooms();
     
     if(in == null)
      {
       System.out.println("Participants aren't present in any of the BreakoutRooms");
      }
    
    else
      {
      System.out.println("        ALL PARTICIPANTS IN EVERY BREAKOUROOM      \n\n" + in);  
      }
      
      
     
    for(int n = 1; n <=5; n = n + 1)
    {
        j = vir.closeBreakoutRoom(n); 
     
     if(j == true){
        System.out.println("Room" + n + "closed");
        }
     
    }  
      
    
    
    
    }
   
    
    
    
    
     
    
    
    }
    
