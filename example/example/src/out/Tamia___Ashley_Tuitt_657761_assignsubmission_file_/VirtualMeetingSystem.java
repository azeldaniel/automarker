package out.Tamia___Ashley_Tuitt_657761_assignsubmission_file_;
/**
 * Student ID: 816021561
 */
import java.io.File;
import java.util.Scanner;

public class VirtualMeetingSystem
{
   private String filename;
   private String name;
   private String code;
   private String participantID;
   private int roomNumber;
   private String[] PArr = new String[50];
   private VirtualRoom VR; 
   
   public VirtualMeetingSystem(){
   String filename=null;
   String name=null;
   String code=null;
   String participantID=null;
   int roomNumber = 0;
   }
   
    public String getFileName(){
       return filename;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCode(){
        return code;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public int getRoomNumber(){
        return roomNumber;
    }
  
    public void loadParticipantData(String filename)throws Exception{
        File file= new File(filename);
        Scanner sc = new Scanner(file);
        int i=0;
        
        while(sc.hasNextLine()){
        String s= new String(sc.nextLine());
        PArr[i]=s;
        System.out.println(s);
        i++;
       }
    }
    
    public void createVirtualRoom(String name){
        
       VR=new VirtualRoom(name,5);
       VR.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        
        int numRooms=(VR.getNumberOfBreakoutRooms());
        if(code.equals("RR")){
            this.code=code;
            int l=1;
            for(int i=0; i<50; i++){
              if(l>numRooms)
                l=1;
              if(VR.addParticipantToBreakoutRoom(PArr[i],l)==true);
               l++;
            }
        }
            
        else{
          this.code="C5";
          for(int i=0; i<50; i=i+5){
            for(int l=1; l<=numRooms; l++){
                int n=0;
                while(n<4){
                if(VR.addParticipantToBreakoutRoom(PArr[i+n],l)==true);
                n+=1;
                }
            }
           }
        }
    }
    
   
   public boolean addParticipant(String participantID, int roomNumber){
       
       if(VR.findBreakoutRoom(roomNumber)!=null){
 
           if(VR.addParticipantToBreakoutRoom(participantID,roomNumber)==true)
           return true;

        }
        
        return false;
    }
    
    public String listParticipants(int roomNumber){
        if(VR.findBreakoutRoom(roomNumber)!=null){
           String list="";
           list+=VR.listParticipantsInBreakoutRoom(roomNumber);
           return list;
        }
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(VR.findBreakoutRoom(roomNumber)!=null){
           VR.openBreakoutRoom(roomNumber);
           return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(VR.findBreakoutRoom(roomNumber)!=null){
           VR.closeBreakoutRoom(roomNumber);
           return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        
        if(VR.findParticipantBreakoutRoom(participantID)!=null){
        return VR.findParticipantBreakoutRoom(participantID);
        }
    
        return null;
    }
    
    public String listAllBreakoutRooms(){
        
        String details="";
        details += VR.listBreakoutRooms();
        
        return details;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String details="";
        for(int i=1; i<=VR.getNumberOfBreakoutRooms();i++){
         details += "\n"+VR.listParticipantsInBreakoutRoom(i);
        }
        return details;
    }
}
