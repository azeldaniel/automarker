package out.Bria_Paul_657710_assignsubmission_file_;
/**
 * 816018930
 * @author BriaPaul
 * Assumptions: Room number is Room ID
 * @version 20/01/2021
 */

import java.io.File;  // Import the File class
import java.util.Scanner; //Import input class

public class VirtualMeetingSystem{
    private String[] IDs;
    private VirtualRoom newVirtualRoom;
    
    //Constructor for objects of class
    public VirtualMeetingSystem(){
        this.IDs = new String[50];
    }
    
    //Read data from a file and loads the data into an array for allocation to breakout rooms
    public void loadParticipantData(String filename ) throws Exception{
        int i=0;
        System.out.println("Method entered");
        
        File file = new File(filename);
        Scanner input = new Scanner(file);
        
        System.out.println("Attempting to read from file: "+ file.getCanonicalPath());
        
        if (!file.exists()){
        System.out.println("The file you entered either do not exist.\nProgram is now being terminated.\nGoodbye!");
        return;
       }    
       
       IDs[i] = input.nextLine();
       
        while(input.hasNextLine()){
            i++;
            IDs[i] = input.nextLine();
       }
       
       System.out.println("Participants have been successfully read from file. \n");
       input.close();
}

    /*** Creates a virtual room with the supplied name, containing 5 breakout rooms */
    
       public void createVirtualRoom(String name){
           newVirtualRoom = new VirtualRoom(name);
           
           newVirtualRoom.createBreakoutRooms();
}

        /*** Allocates participants to the breakout rooms of a virtual room using a strategy determined by the supplied code */
    public void allocateParticipants(String code){
        int i=1, j=0, k=0, x=0, y=0;
        boolean openedRoom;
        
         int amountOfRooms = newVirtualRoom.getNumberOfBreakoutRooms();
         
        if(code.equals("C5")){
            while (i<=amountOfRooms){
             
               while(j<10){
                  if( newVirtualRoom.findParticipantBreakoutRoom(IDs[k]) == null){ //add participant once not found (prevents duplicates)
                    newVirtualRoom.addParticipantToBreakoutRoom(IDs[k], i); //room number entered
                }
                
                k++;
                j++;    
            }
              j=0;
              i++;
            }
        }
        
        if(code.equals("RR")){
            k = IDs.length; //get length of array
            while (i<=amountOfRooms){
                
                  while(j<10){ //adding 10 participant to each room
                      
                      if( newVirtualRoom.findParticipantBreakoutRoom(IDs[y]) == null){
                      newVirtualRoom.addParticipantToBreakoutRoom(IDs[y], i); //room number entered
                    }
                      x=k/2 + y;
                      
                      if( newVirtualRoom.findParticipantBreakoutRoom(IDs[x]) == null){
                      newVirtualRoom.addParticipantToBreakoutRoom(IDs[x], i);
                    }
                    
                      y++;
                      j+=2;
                    }
                    
                  j=0;
                  i++;
                }
        }
        System.out.println("All participants have been allocated to a room.");
        return;
    }

    /*** Adds a new participant to the breakout room with the supplied room number if it exists */
    public boolean addParticipant (String participantID, int roomNumber){
        if( newVirtualRoom.findParticipantBreakoutRoom(participantID) == null){
          boolean newParticipant = newVirtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
          
          if(newParticipant == true)
            return true;
        }
        
        if( newVirtualRoom.findParticipantBreakoutRoom(participantID) != null){
            System.out.println("Participant has been found in a breakout room.");
        }
        return false;
     }
    
    /*** Returns a list of the participants in the breakout room with the supplied room number if found,
         otherwise returns null */
      public String listParticipants(int roomNumber){
        String participantsList = "";
          
         participantsList=newVirtualRoom.listParticipantsInBreakoutRoom(roomNumber);
          
          if(participantsList != null){
           System.out.println(participantsList);
           return participantsList;
        }
        
        return null;
     }


      /*** Opens a breakout room with the supplied room number if it exists */
      public boolean openBreakoutRoom(int roomNumber){
          if(newVirtualRoom.openBreakoutRoom(roomNumber) == true){
              System.out.println("Breakout room successfully open");
              return true;
          }
            
          return false;
      }
        
      /*** Opens a breakout room with the supplied room number if it exists */
      public boolean closeBreakoutRoom(int roomNumber){
          
          if(newVirtualRoom.closeBreakoutRoom(roomNumber) == true){
              System.out.println("Breakout room successfully closed");
              return true;
            }
                      
          return false;
      }
       
      /** Locates and returns the breakoutRoomID for the breakout room hosting the participant with the
         (valid) supplied ID, otherwise returns null */
       public String findParticipantBreakoutRoom (String participantID){
           String participant = "";
           participant += newVirtualRoom.findParticipantBreakoutRoom(participantID);
           
           if(participant != null){
           System.out.println(participant);
           return participant;
       }
          
         System.out.println("Participant has not been found!");
         return null;
    }
       
       /** String Returns a list of the breakout rooms managed by the virtual room */
       public String listAllBreakoutRooms( ){
           String listOfRooms="";
           
           listOfRooms = newVirtualRoom.listBreakoutRooms();
           System.out.println(listOfRooms);
           
           return listOfRooms;
        }
      
       /*** Returns a list of all of the participants per breakout room managed by the virtual room, otherwise
         returns null */
        public String listParticipantsInAllBreakoutRooms(){
         String list="";
         int numberOfBreakoutRoom = newVirtualRoom.getNumberOfBreakoutRooms( );
         System.out.println("Amount of BR: " + numberOfBreakoutRoom + "\n");
         
         for (int i=1; i<=numberOfBreakoutRoom; i++){
             list += newVirtualRoom.listParticipantsInBreakoutRoom(i);
             list += "\n";
        }
        
        if(list != null)
           return list;
           
        return null;
}

}