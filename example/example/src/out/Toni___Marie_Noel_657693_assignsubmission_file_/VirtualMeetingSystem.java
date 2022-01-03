package out.Toni___Marie_Noel_657693_assignsubmission_file_;    import java.io.*; 
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.util.Scanner; 
    
    
    /**
    * VirtualMeetingSystemClass.
    *
    * @ Toni-Marie Noel - 816017238
    * @ Jan 31, 2021 
    */
    public class VirtualMeetingSystem
    {
    // instance variables - replace the example below with your own
    private int limit = 5;
    private int numberOfParticipants; 
    private String [] caller; // declare array
    private VirtualRoom virtualRoom; 
    
    // read file: Think Java
    public void loadParticipantData(String fileName)
    {
        
        
        try{
            
        
        File fin = new File (fileName);
        Scanner readFile = new Scanner(fin);
       
        // find how many participants there are in the file
        while(readFile.hasNextLine()){
            
            String data = readFile.nextLine();
            numberOfParticipants++;    
            //System.out.println(numberOfParticipants);
            //System.out.println(data);
            
           }

        readFile.close();
        
        //allocate memory to the array
        caller = new String [numberOfParticipants]; 
        int i =0;
        // reopen file and read participants into the array
        Scanner readFile1 = new Scanner(fin);
        while(readFile1.hasNextLine()){
        
        String data = readFile1.nextLine();
       
        //System.out.println(newParticipant.getParticipantID());
        caller[i] = data; 
        
        //System.out.println(caller[i]); 
        
        i++;
    
       
        }
        
        readFile.close();
        
        
       } catch (FileNotFoundException e){
       
        System.out.println("Error opening file");
        e.printStackTrace();
        
      }
    
        
    }
       
    
    public void createVirtualRoom(String name){
        
    virtualRoom = new VirtualRoom(name,limit);
    
    }
    
    // bruh idk 
    public void allocateParticipants(String code){
    
    
        int count = 0; // keeps track of how many people were added to the room
        int breakoutRoom = 0; // this cannot exceed 5
        boolean added= true; 
        int joinedRoom = 0;
        
      
        if(code.equals("C5"))
        {
            for(int i=0; i < numberOfParticipants; i++)
            {
                if(addParticipant(caller[i],breakoutRoom+1))
                joinedRoom++; 
                
                if(joinedRoom == 5)
                {
                  breakoutRoom++;
                  joinedRoom =0;
                }
                
                if(breakoutRoom == virtualRoom.getBreakoutRoomLimit())
                {
                    breakoutRoom = 0; // reset
                    
                } 
            }
        }
        
          if(code.equals("RR"))
        {
            for(int i=0; i < numberOfParticipants; i++)
            {
                if(addParticipant(caller[i],breakoutRoom+1))
                joinedRoom++; 
                
                if(joinedRoom == 1)
                {
                  breakoutRoom++;
                  joinedRoom =0;
                }
                
                if(breakoutRoom == virtualRoom.getBreakoutRoomLimit())
                {
                    breakoutRoom = 0; // reset
                    
                } 
            }
        }
        
       
    
    }
        
    
        
    public boolean addParticipant(String participantID, int roomNumber){
       return virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
    }
    
    public String listParticipants(int roomNumber){
        return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return virtualRoom.openBreakoutRoom(roomNumber);        
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return virtualRoom.closeBreakoutRoom(roomNumber);        
    }
    
    public String findParticipantBreakoutRoom(String participantID){
       return virtualRoom.findParticipantBreakoutRoom(participantID); 
    }
    
    public String listAllBreakoutRooms(){
        return virtualRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
    
        int breakoutRoom = 0; // this cannot exceed 5
        String allParticipants="";
        
        while(breakoutRoom< virtualRoom.getBreakoutRoomLimit()  && virtualRoom.getBreakoutRoom()[breakoutRoom]!= null ){
            allParticipants = allParticipants + virtualRoom.listParticipantsInBreakoutRoom(breakoutRoom+1)+"\n";
           // System.out.println(allParticipants);
            breakoutRoom++;
        }
        
      // System.out.println(allParticipants); 
      
        return allParticipants; 
    }
}

    
    
    
    
