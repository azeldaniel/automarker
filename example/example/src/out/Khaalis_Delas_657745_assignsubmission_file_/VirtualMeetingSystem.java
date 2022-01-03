package out.Khaalis_Delas_657745_assignsubmission_file_;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//Khaalis De Las- 8160071114
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class VirtualMeetingSystem
{
   int NumVirtualRooms=0;
   boolean isOpen=false;
   //String VirtualRoom;
   //VirtualRoom VR1 = new VirtualRoom( VR1, 5, breakoutRooms[10], true, 0 );






  public void loadParticipantData(String filename){
      //unsure how to incorporate my ReadFile  into this function
    }


    public void createVirtualRoom(String name){
        String VirtualRoomName="";
        if( NumVirtualRooms < 10){
            VirtualRoomName=name;
            NumVirtualRooms++;
            System.out.println("Room has been created with the name: " +
            name );

    }
    else{
    System.out.println("The maximum number of rooms has been met");
    }

    }

    public void allocateParticipants(String code){
    //C5 code

    }

   /*
    public boolean addParticipant(String participantID, int roomNumber){
     boolean confirm;
    if(VirtualRoom.breakoutRoomLimit() < 5 && findBreakoutRoom(roomNumber)!= null){
    openBreakoutRoom(roomNumber);
    confirm= findBreakoutRoom(roomNumber).addParticipant(participantID);
    if(confirm==true)
    return true;
    }

    return false;

    }



   public String listParticipants(int roomNumber){
      string roomDetails= "";
      roomDetails= "BreakoutRoom: " + roomNumber;
      roomDetails= ""
    }



   public boolean openBreakoutRoom(int roomNumber){
    if (breakoutRooms[roomNumber] == null){
        return null;
    }

    openBreakoutRoom(roomNumber);

    }

   */
   public boolean openBreakoutRoom (int roomNumber){
      isOpen= true; 
return isOpen;
   }
   public boolean closeBreakoutRoom (int roomNumber){
       isOpen=false;
return isOpen;
   }

   public String findParticipantBreakoutRoom(String participantID){
String Brooomid= findParticipantBreakoutRoom(participantID);
if(Brooomid != null){
  System.out.println("Participant:" + participantID + "is in " + Brooomid);

  return Brooomid;
}
     else
     {
     return null;
   }
   }

public String listAllBreakoutRooms(){
  return listAllBreakoutRooms();
}

/*
public String listParticipantsInAllBreakoutRooms(){
  String List= "Participants present in rooms are as follows: " + "\n";
  for(int i=0; i<5; i++){
    List+= listParticipantsInAllBreakoutRooms + "\n";
  }
  return List;
}
*/
}
