package out.Adiyah_Mohammed_657711_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 816014197
 */
public class VirtualMeetingSystem
{
    
    // from w3schools
    public void loadParticipantData(String filename ){
      File Obj = new File(filename); 
      int i=0;
      String data[]= new String [100];
      try {
       Scanner myReader =new Scanner(Obj);
      while (myReader.hasNextLine()) {
         data[i]= myReader.nextLine();
         i++;
        
       }
      myReader.close();
       } 
      catch(FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      }
    }  
    
    
   public void createVirtualRoom(String name) {
         VirtualRoom v = new VirtualRoom(name);
         
         
   }
   public void allocateParticipants(String code ) {
       String data[]= new String [100];
       
       VirtualRoom v1 = new VirtualRoom (" Workshop");
       int j=0;
       int i=0;
       int y=5;
       if ( code.equals("C5")){
         while(j!=5){
          v1.openBreakoutRoom(j) ;
           for(i=0;i<10;i++){
              v1.addParticipantToBreakoutRoom( data[i],j);
        }
         v1.closeBreakoutRoom(j);
         j++;
      }
    }
    if ( code.equals("RR")){
         while((j!=5)||(i!=10)){ 
             v1.openBreakoutRoom(j) ;
             v1.addParticipantToBreakoutRoom( data[i],j);
             v1.closeBreakoutRoom(j);
             j++;
             if(j >4){
                i++;
                j=0;
             }
            }
         
      }
   }
   public boolean addParticipant (String participantID,int roomNumber){
        
        VirtualRoom v1 = new VirtualRoom (" Workshop");
        return v1.addParticipantToBreakoutRoom( participantID,roomNumber); 


    }  
       
    public String listParticipants(int roomNumber) {
        
        VirtualRoom v1 = new VirtualRoom (" Workshop");
        return v1.listParticipantsInBreakoutRoom(roomNumber);
       
    }
    public boolean openBreakoutRoom(int roomNumber){
      
        VirtualRoom v1 = new VirtualRoom (" Workshop");
        return v1.openBreakoutRoom(roomNumber);  
        
    }
    public boolean closeBreakoutRoom(int roomNumber){
        
        VirtualRoom v1 = new VirtualRoom (" Workshop");
        return v1.closeBreakoutRoom(roomNumber);  
        
        
    }
    public String findParticipantBreakoutRoom(String participantID){
        
        VirtualRoom v1 = new VirtualRoom (" Workshop");
        return v1.findParticipantBreakoutRoom(participantID);
        
    }
    public String listAllBreakoutRooms( ){
        
        VirtualRoom v1 = new VirtualRoom (" Workshop");
        return v1.listBreakoutRooms( );
        
        
    }
    public String listParticipantsInAllBreakoutRooms() {
       
       VirtualRoom v1 = new VirtualRoom (" Workshop");
       for(int i=0;i<5;i++){
       return v1.listParticipantsInBreakoutRoom(i );
 
    } 
        return null;
    }

 
}
