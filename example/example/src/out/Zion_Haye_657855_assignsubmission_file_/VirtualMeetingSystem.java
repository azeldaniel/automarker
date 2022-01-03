package out.Zion_Haye_657855_assignsubmission_file_;/*
 Student ID : 816020871
*/
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class VirtualMeetingSystem{

    private VirtualRoom virtualRoom;
    private String [] participants;
    private static int numberOfParticipants = 0;

    public void loadParticipantData(String filename){
        
        participants =  new String [50];
        
        try {
          File myObj = new File(filename);
          Scanner myReader = new Scanner(myObj);
          
          while (myReader.hasNextLine()) {
              
            String data = myReader.nextLine();
            
            participants[numberOfParticipants] = data;
            numberOfParticipants =  numberOfParticipants + 1;
            
          }
          
          myReader.close();
          
          } catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
              return;
        }
        
        System.out.println("The File has been read and Participant Data has been loaded.");
    
    }
    
    public void createVirtualRoom(String name){
        virtualRoom = new VirtualRoom(name);
    }
    
    public void allocateParticipants(String code){

       int roomNumber;
       String participantID;
       boolean isSuccesful;
       
       roomNumber = 1;
       participantID = null;
       isSuccesful = false;
       
       System.out.println("Code : " + code );
       
       if(code.equals("C5")){
           
                   
           for(int x = 0 ; x <= participants.length - 5 ; x = x + 5){
               
                   participantID = participants[x];
                   isSuccesful= virtualRoom.addParticipantToBreakoutRoom (participantID, roomNumber);
               
                   participantID = participants[x + 1];
                   isSuccesful = virtualRoom.addParticipantToBreakoutRoom (participantID, roomNumber);
               
                   participantID = participants[x + 2];
                   isSuccesful = virtualRoom.addParticipantToBreakoutRoom (participantID, roomNumber);
               
                   participantID = participants[x + 3];
                   isSuccesful = virtualRoom.addParticipantToBreakoutRoom (participantID, roomNumber);
               
                   participantID = participants[x + 4];
                   isSuccesful = virtualRoom.addParticipantToBreakoutRoom (participantID, roomNumber);
                             
                   roomNumber = roomNumber + 1;
               
                   if(roomNumber > 5){
                       roomNumber = 1;    
                   }
                   
                
           }
           
       }else{
           
           roomNumber = 1;
           
           for(int x = 0 ; x < participants.length ; x++){
                  
                participantID = participants[x];
                isSuccesful = virtualRoom.addParticipantToBreakoutRoom (participantID, roomNumber);
               
                roomNumber = roomNumber + 1;
               
                if(roomNumber > 5){
                   roomNumber = 1;    
                }
              
               
           }
           
       }
        
       System.out.println("The Participants have been allocated to Breakout Rooms.");        
        
    }
    
    public boolean addParticipant(String participantID , int roomNumber){
        
        boolean isSuccessful;
        
        isSuccessful = virtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber);
        
        return isSuccessful;
    }
    
    public String listParticipants(int roomNumber){
        String listOfParticipants;
        
        listOfParticipants = virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        
        if(listOfParticipants==null){
             System.out.println();
             return null;
        }
        
        return listOfParticipants;
        
    }
    
    public boolean openBreakoutRoom (int roomNumber){
        
        boolean isOpen;
        
        isOpen = virtualRoom.openBreakoutRoom(roomNumber);
        
        return isOpen;
    }
    
    public boolean closeBreakoutRoom (int roomNumber){
        
        boolean isClose;
        
        isClose = virtualRoom.closeBreakoutRoom(roomNumber);
        
        return isClose;
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        
        String breakoutRoom;
        
        breakoutRoom = virtualRoom.findParticipantBreakoutRoom(participantID);
        
        return breakoutRoom;
    }
    
    public String listAllBreakoutRooms(){
        
        String listOfAllBreakoutRooms;
        
        listOfAllBreakoutRooms = virtualRoom.listBreakoutRooms();
        
        return listOfAllBreakoutRooms;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        
        int numberOfBreakoutRooms;
        String listOfBreakoutRooms;
        
        listOfBreakoutRooms = "List of Breakout Rooms and its Participants:\n";
        
        numberOfBreakoutRooms = virtualRoom.getNumberOfBreakoutRooms();
        
        for(int x = 1 ; x <= numberOfBreakoutRooms ; x++){
            listOfBreakoutRooms += virtualRoom.listParticipantsInBreakoutRoom(x);
            listOfBreakoutRooms += "\n";
        }
        
        return listOfBreakoutRooms;
    }
        
    /*

     Source:https://www.w3schools.com/java/java_files_read.asp
     
     */
    

}