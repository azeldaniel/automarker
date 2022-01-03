package out.Jewel_Coker_657713_assignsubmission_file_;// ID : 816014352
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
//import librabries found on w3schools @ https://www.w3schools.com/java/java_files_read.asp

public class VirtualMeetingSystem{
   private String[] Participants = new String[50];// come back to this
   private int participantIndex=0;
   VirtualRoom virtualRoom;
   
   public void VirtualMeetingSystem(){
    
   }
    
   public void loadParticipantData(String file){
       String participantID;
       try{
           
           File participantId= new File(file);
           Scanner scanner = new Scanner(participantId);
           while(scanner.hasNextLine()){
               participantID=scanner.nextLine();
               Participants[participantIndex]= participantID;
               participantIndex++;
               //System.out.println(participantID);
            }
            scanner.close();
       }catch (FileNotFoundException e) {
          System.out.println("Error, File not found.");
          e.printStackTrace();
       }  
    }
    
    public void createVirtualRoom(String name){
       VirtualRoom newRoom = new VirtualRoom(name); // containing five breakout room 
       this.virtualRoom= newRoom;
    }
    
    public void allocateParticipants(String code){
      int stopCounter1;
      int stopCounter2;
      int roomNumber =1;
      int participantCount=0; 
      int RRCount = 1;
        if(code.equals("C5")){
            if(participantIndex%5 == 0){
                for(int x=1 ; x<=participantIndex ; x=x+5){
                    for(int y=0; y<5; y++){
                      virtualRoom.addParticipantToBreakoutRoom(Participants[participantCount],roomNumber);
                        participantCount++;
                      
                    }
                    if(roomNumber==5){
                        roomNumber=1;
                    }else{ 
                        roomNumber++;
                    }
                }
               
            }else{
                stopCounter1= (participantIndex / 5 ) * 5 ;
                stopCounter2= (participantIndex%5);
                for(int x=1 ; x<=stopCounter1 ; x=x+5){
                    for(int y=0; y<5; y++){
                      virtualRoom.addParticipantToBreakoutRoom(Participants[participantCount],roomNumber);
                        participantCount++;
                        
                    }
                    
                    if(roomNumber==5){
                        roomNumber=1;
                    }else{ 
                        roomNumber++;
                    }
                }
                 for(int i=1 ; i<=stopCounter2 ; i++){
                    virtualRoom.addParticipantToBreakoutRoom(Participants[participantCount],roomNumber);
                    participantCount++;
                    }
                
            
            }
            
        }else if(code.equals("RR")){
            for(int x=1 ; x<participantIndex ; x=x+5 ){
                for(int y=1; y<=5 ; y++){
                   virtualRoom.addParticipantToBreakoutRoom(Participants[participantCount],y);
                   participantCount++;  
                
                }
            }
            
        }
        
       
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        boolean participantAdded;
        if(virtualRoom.findBreakoutRoom(roomNumber)!=null){
            
            participantAdded=virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
            if(participantAdded==true){
                System.out.println("Participant: "+participantID+ " has been added to room "+roomNumber);
                return true;
            }
        }
        System.out.println("Unable to add participant ");
        return false;
    
    }
        
    public String listParticipants(int roomNumber){
       String participantList;
       participantList = virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
      
       return participantList; 
    }
    
    public boolean openBreakoutRoom(int roomNumber){
         if(virtualRoom.findBreakoutRoom(roomNumber)!=null){
            virtualRoom.openBreakoutRoom(roomNumber);
             return true;
         }
         return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
         if(virtualRoom.findBreakoutRoom(roomNumber)!=null){
            virtualRoom.closeBreakoutRoom(roomNumber);
             return true;
         }
         return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String breakoutRoomID;
        breakoutRoomID=virtualRoom.findParticipantBreakoutRoom(participantID);
        if(breakoutRoomID==null){
            System.out.println("Unable to find participant");
            return null;
        }else{
            System.out.println("Participant: "+participantID+ " found in "+breakoutRoomID);
            return breakoutRoomID;
        }
    
    }
    
    public String listAllBreakoutRooms(){
       return virtualRoom.listBreakoutRooms(); 
    }
    
    public String listParticipantsInAllBreakoutRooms(){
      String participantList="Participant List for All Breakout Rooms \n";
        for(int i=1; i<=5; i++){
      
          participantList+= virtualRoom.listParticipantsInBreakoutRoom(i)+ "\n";
        }
        return participantList;
    }
}