package out.Alexis_Pitypaul_657694_assignsubmission_file_;
/**
 * Write a description of class VirtualMeetingsystemClass here.
 *
 * @author (Alexis Pitypaul)
 * @version (1)
 */
import java.io.*;
import java.util.Scanner;

public class VirtualMeetingSystem
{
   private String[] data = new String[50];
   private int num = 0;
   VirtualRoom virtualRoom;
   
   public VirtualMeetingSystem(){
    }
   
    //https://www.w3schools.com/java/java_files_read.asp
   public void loadParticipantData(String filename){
       try{
            File in = new File("participant.dat");
            Scanner s = new Scanner(in);
            while(s.hasNextLine()){
                data[num] = s.nextLine();
                num = num + 1;
            }
            s.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } 
   }
   public void createVirtualRoom (String name){
       virtualRoom = new VirtualRoom(name);
       virtualRoom.createBreakoutRooms();
   }
   public void allocateParticipants(String code){
       int numRooms = virtualRoom.getNumberOfBreakoutRooms();
       int c = 0, d = 0;
       if(code.equals("C5")){
           for(int a = 0; a < numRooms; a++){
               if(virtualRoom.breakoutRooms[a] != null){            
                   for(int b = 0; b < 5; b++){
                        addParticipant(data[c], a);
                        c = c + 1;
                   }
               }
           }
       }
       if(code.equals("RR")){
           for(int b = 0; b < 5; b++){
               if(virtualRoom.breakoutRooms[b] != null){            
                   for(int a = 0; a < numRooms; a++){
                        addParticipant(data[d], a);
                        d = d + 1;
                   }
                }
           }
       }
   }
   public boolean addParticipant (String participantID,
    int roomNumber){
       return virtualRoom.addParticipantToBreakoutRoom
            (participantID, roomNumber);
   }
   public String listParticipants (int roomNumber){
       return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
   }
   public boolean openBreakoutRoom (int roomNumber){
       return virtualRoom.openBreakoutRoom(roomNumber);
   }
   public boolean closeBreakoutRoom (int roomNumber){
       return virtualRoom.closeBreakoutRoom(roomNumber);
   }
   public String findParticipantBreakoutRoom (String participantID){
       return virtualRoom.findParticipantBreakoutRoom(participantID);
   }
   public String listAllBreakoutRooms(){
       return virtualRoom.listBreakoutRooms();
   }
   public String listAllParticipantsInallBreakoutRooms(){
       int numRooms = virtualRoom.getNumberOfBreakoutRooms();
       String list = virtualRoom.getName() + "\n";
       for(int a = 0; a < numRooms; a++){
           list += "Breakout Room: " + a + "\n";
           list += listParticipants(a) + "\n";
       }
       return list;
   }
}
