package out.Justin_Mahabir_657709_assignsubmission_file_;//ID: 816000496
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author Justin Mahabir
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class VirtualMeetingSystem
{
    ArrayList<String> ID = new ArrayList<String>();
    VirtualRoom vr;
    public void loadParticipantData(String filename)
    {
      try{
          File text =  new File(filename);
          Scanner sc = new Scanner(text);
          while(sc.hasNextLine()){
              ID.add(sc.nextLine());
          }
          sc.close();
      }
      catch(FileNotFoundException e){
          System.out.println("File not found!");
          e.printStackTrace();
      }
    }
    public void createVirtualRoom(String name){
        vr = new VirtualRoom(name, 5);
        vr.createBreakoutRooms();
    }
    public void allocateParticipants(String code){
        int y = 1;
        int z = 0;
        boolean result = false;
        String uCode;
        uCode = code.toUpperCase();
      
        if(uCode.equals("C5")){
           for(int x = 0; x < ID.size();x++){
               
               if(z == 50){
                   break;
               }
               result = addParticipant(ID.get(x) , y);
               if(result == true){
                   z++;
                   if(z%5 == 0){
                   if(y == 5){
                       y = 1;
                   }
                   else{
                       y++;
                    }
                }
               }
           }
        }
        else if (uCode.equals("RR")){
            for(int x = 0; x < ID.size();x++){
                if(z == 50){
                   break;
               }
               result = addParticipant(ID.get(x) , y);
               if(result == true){
                   z++;
                   if(y==5){
                       y = 1;
                   }
                   else{
                       y++;
                   }
                }
            }
        }
        else{
            System.out.println("Invalid Code");
        }
    }
    public boolean addParticipant(String participantID, int roomNumber){
        return vr.addParticipantToBreakoutRoom(participantID, roomNumber);
    }
    public String listParticipants(int roomNumber){
        return vr.listParticipantsInBreakoutRoom(roomNumber);
    }
    public boolean openBreakoutRoom(int roomNumber){
        return vr.openBreakoutRoom(roomNumber);
    }
    public boolean closeBreakoutRoom(int roomNumber){
        return vr.closeBreakoutRoom(roomNumber);
    }
    public String findParticipantBreakoutRoom(String participantID){
        return vr.findParticipantBreakoutRoom(participantID);
    }
    public String listAllBreakoutRooms(){
        String list=vr.listBreakoutRooms();
        return list;
    }
    public String listParticipantsInAllBreakoutRooms(){
        String result = "";
        for (int x = 1; x <= vr.getNumberOfBreakoutRooms(); x++){
            result += vr.listParticipantsInBreakoutRoom(x);
            result += "\n";
        }
        return result;
    }
}
