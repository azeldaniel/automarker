package out.Nickal_Winter_657706_assignsubmission_file_;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
    
    private VirtualRoom[] vRoom;
    private String[] participantdata;
    
    
    
    public VirtualMeetingSystem(){
    vRoom = new VirtualRoom[1]; 
    
}
    

    public void loadParticipantData (String file){
        
        int ctr = 0;
        try{
            Scanner s1 = new Scanner (new File(file));
            while (s1.hasNextLine()){
                ctr = ctr + 1;
                s1.next();
        }
        
        participantdata = new String[ctr];
        
        Scanner s2 = new Scanner(new File(file));
        for (int i = 0; i < ctr; i = i + 1){
            participantdata[i] = s2.next();
        }
        
    }
        catch (FileNotFoundException e){
    }
    
}


/// VirtualRoom was created above,only the BreakoutRooms are to created now.
public void createVirtualRoom (String name){
        
         VirtualRoom v = new VirtualRoom (name);
        
        
        vRoom[0] = v;
       
        
        vRoom[0].createBreakoutRooms();
        
        
                 
                
        
    }

    
    public void allocateParticipants (){
    ///CC
    vRoom[0].addParticipantToBreakoutRoom(participantdata[0],0);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[1],0);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[2],0);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[3],0);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[4],0);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[5],1);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[6],1);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[7],1);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[8],1);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[9],1);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[10],2);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[11],2);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[12],2);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[13],2);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[14],2);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[15],3);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[16],3);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[17],3);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[18],3);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[19],3);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[20],4);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[21],4);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[22],4);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[23],4);
    vRoom[0].addParticipantToBreakoutRoom(participantdata[24],4);
    
    
    
    
    
    
}

///CC------------------------------------------------------------------------

   public boolean addParticipant (String participantID, int roomNumber){
          
          if (roomNumber<5){
              vRoom[0].addParticipantToBreakoutRoom(participantID,roomNumber);
              return true;
            }else{
        
return false;
}
}


public String listParticipants (int roomNumber){
    int i;
          
          if (roomNumber<5){
              
              return vRoom[0].listParticipantsInBreakoutRoom(roomNumber);
            }else{
        
return null;
}
}


public boolean openBreakoutRoom (int roomNumber){
   
          if (roomNumber<5){
              vRoom[0].openBreakoutRoom(roomNumber);
              return true;
            }else{
        
return false;
}
}

public boolean closeBreakoutRoom (int roomNumber){
   
          if (roomNumber<5){
              vRoom[0].closeBreakoutRoom(roomNumber);
              return true;
            }else{
        
return false;
}
}

public String listAllBreakoutRooms(){
    
                return vRoom[0].listBreakoutRooms();
                
            
        
        
}


public String findParticipantBreakoutRoom(String participantID){
    
    return vRoom[0].findParticipantBreakoutRoom(participantID);
}




public String listParticipantsInAllBreakoutRooms(){
    int i;
    String details = "VirtualRoom" + " " + "\n";
    
    for(i=0;i<5;i++){
    details += vRoom[0].listParticipantsInBreakoutRoom(i) + " " + "\n";
    
    
}
return details;
}



}
