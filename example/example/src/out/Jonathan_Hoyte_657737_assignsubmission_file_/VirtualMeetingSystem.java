package out.Jonathan_Hoyte_657737_assignsubmission_file_;
// ID - 816013096
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
public class VirtualMeetingSystem
{
    
   
    private String filename;
    private String name;
    private VirtualRoom VR;
    private String[] IDs;
   public VirtualMeetingSystem(){
     
   }
   public void setName(String name){
    this.name=name;
    }
   public void setFileName(String Filename){
        this.filename =  filename;
    }
   
    
    public void loadParticipantData(String filename){
        // Taken from W3Schools.com & stack overflow
        /**Array list used to store the particpant IDs individually for ease of distrubution*/
        ArrayList<String> perps = new ArrayList<String>();
        try {
      File myObj = new File("participant.dat");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
         filename = myReader.nextLine();
         perps.add(filename);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    /**Loading the participant IDs into a regular array from the ArrayList */
    String[] pIDs = perps.toArray(new String[0]);
    allocateParticipants(pIDs);
   }
    
    public void createVirtualRoom(String name){
        VirtualRoom VR =new VirtualRoom(name,5); 
   }
    
   public void allocateParticipants(String[] code){
     int cry =code.length;
     int y =0;
     boolean deca = false;
     //for(int u =0; u<cry)
     for(int o=0; o<cry;o++){
        if(o%5==0){ y++;}
        if(y%5==0){ y=0;}
        deca=addParticipants(code[o],y);
        if(deca = true){
        System.out.println("particpants added \n");
       }
        else{
        System.out.println("System error");}
     }
   }
    
   public boolean addParticipants(String participantID, int roomNumber){
        boolean Dec=false;
        Dec=VR.addParticipantToBreakoutRoom(participantID,roomNumber);
        if(Dec==false)
         return false;
      return true;
    }
    
    public String listParticipants(int roomNumber){
        String C = "";
        if(VR.listParticipantsInBreakoutRoom(roomNumber)==null){ return null;}
         C =VR.listParticipantsInBreakoutRoom(roomNumber);
        return C;
   }
    
    public boolean openBreakoutRoom(int roomNumber){
       
     if(VR.findBreakoutRoom(roomNumber)==null){
        return false; 
    }
     else if(VR.findBreakoutRoom(roomNumber) !=null){
      VR.openBreakoutRoom(roomNumber);
     return true; }
     return false;
   }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(VR.findBreakoutRoom(roomNumber)==null){
        return false; 
     }
      else if(VR.findBreakoutRoom(roomNumber) !=null){
          boolean Door=false;
          Door= VR.closeBreakoutRoom(roomNumber);
          if(Door == true)
            return true;}
    
     return false;
   }
    
    public String findParticipantBreakoutRoom(String participantID){
      String A ="";
      A =VR.findParticipantBreakoutRoom(participantID);
      if(A==null)
        return null;
      return A;
   }
    
    public String listAllBreakoutRooms(){
    String A ="";
    A=VR.listBreakoutRooms();
    return A;
   }
    
    public String listParticipantInAllBreakoutRooms(){
     String B="";
     int num= 0;
      num = VR.getNumberOfBreakoutRooms();
     
     for(int i=0; i<=num; i++){
        if(VR.listParticipantsInBreakoutRoom(i)==null){
        return null;
    }
        B +="\n"+"Workshop "+i+"\n"+"Participants: "+VR.listParticipantsInBreakoutRoom(i);
     }
      return B;
   }
    
}
