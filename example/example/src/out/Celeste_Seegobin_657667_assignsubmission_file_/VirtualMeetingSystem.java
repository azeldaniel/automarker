package out.Celeste_Seegobin_657667_assignsubmission_file_;
//Celeste Seegobin - 816019646
import java.util.Scanner;
import java.io.*;
public class VirtualMeetingSystem{
    private Scanner x;
    private int TotalParticipants;
    String arr[];
    VirtualRoom Room;
   
     public void loadParticipant(String filename){
         String numLines;
         try{
             x = new Scanner(new File("participants.dat"));
            }
         catch(Exception e){
             System.out.println("Error opening file");
         
        
     }
     while(x.hasNext()){
             numLines = x.nextLine();
             System.out.printf(numLines);
             arr[TotalParticipants] = numLines;
             
             TotalParticipants++;
         
    }
}


     public void createVirtualRoom(String name){ //Contains 3 rooms
         Room = new VirtualRoom(name,5);
      }

    public void allocateParticipants(String code){
         int groups=1;
         int numBR = Room.getNumberOfBreakoutRooms();
         int count = 0;
         if(code.toUpperCase() == "C5"){
         for(int i=0; i<=TotalParticipants; i++){
             while(i<numBR){
                 if(groups % 5 ==0){
                     groups = groups +1;
                     
     }
    }
}
}
}



    public boolean addParticipant(String participantID, int roomNumber){
        boolean add = false;
        
        for(int i=0; i<=TotalParticipants; i++){
            if(roomNumber!=0){
                add=Room.addParticipantToBreakoutRoom(participantID, roomNumber);

     }
    }
    return add;
}

    public String listParticipant(int roomNumber){
        String list;
        list = Room.listParticipantsInBreakoutRoom(roomNumber);
        if(list==null){
            list = "Empty";
        }
        return list;
     }

    public boolean openBreakoutRoom(int roomNumber){
        boolean open = false;
        if(open == true){
            open = Room.openBreakoutRoom(roomNumber);
     
     }
     return open;
    }  
    
    public boolean closesBreakoutRoom(int roomNumber){
        boolean close = false;
        if(close == true){
            close = Room.closeBreakoutRoom(roomNumber);
         
      }
      return close;
    }
        
   public String findParticipantsBreakoutRoom(String participantID){
       String id=null;
       
       id = Room.findParticipantBreakoutRoom(participantID);
       
       return id;
        
      }
       
   public String listAllBreakoutRoom(){
       String listBR = null;
       int numBR= Room.getNumberOfBreakoutRooms();
       
       if(numBR!=0){
           listBR = Room.listBreakoutRooms();
        
    }
    return listBR;
}

public String listParticipantAllBreakoutRooms(){
    String listAllBR = null;
    int numBR = Room.getNumberOfBreakoutRooms();
    
        for(int i=0; i<=numBR; i++){
            if(numBR!=0){
        listAllBR = Room.listParticipantsInBreakoutRoom(i);
    
    }
}
return listAllBR;
}
    
    //Accessor
    public int getTotalParticipants(){
        return TotalParticipants;
    
}
        
        
}    
        

