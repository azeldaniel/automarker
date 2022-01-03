package out.Jayson_Hicks_657770_assignsubmission_file_;//Student ID:816000935
import java.util.Scanner;
import java.text.ParseException;
import java.util.Date; 
    
class VirtualRunner {
    
   public static void main(String[] args){
        
        String filename = "participant.dat";
        String Virtualname = "Workshop";
        int x=0,opencount = 0,closecount=0;
        VirtualMeetingSystem r = new VirtualMeetingSystem(); //creates object
        VirtualRoom vr = new VirtualRoom(Virtualname);                      
        r.loadParticipantData(filename);
        r.createVirtualRoom(Virtualname);
        r.allocateParticipants("C5");
        
        
        
        for (x=1;x<=vr.getNumberOfBreakoutRooms();x++){
            r.openBreakoutRoom(x);
            if (r.openBreakoutRoom(x)==true)
                opencount++;
            }
        
        
        if (opencount==vr.getNumberOfBreakoutRooms()){
        System.out.println("All of the rooms are now open............\n");
        }
        System.out.println("VirtualRoom: " + r.listAllBreakoutRooms());
        System.out.println("\nParticipants in their respective Breakoutrooms");
        System.out.println("======================================================================================================"+"\n");
        System.out.println(r.listParticipantsInAllBreakoutRooms());
        System.out.println(r.findParticipantBreakoutRoom("11905916") + "\n");
        System.out.println("Breakoutroom participants in " + r.listParticipants(2));
        
        for (int z=1;z<=vr.getNumberOfBreakoutRooms();z++){
            r.closeBreakoutRoom(x);
            if (r.closeBreakoutRoom(x)==true)
                closecount++;
            }
                
        if (closecount==vr.getNumberOfBreakoutRooms()){
        System.out.println("All of the rooms are now closed............");
        }
        

    }
}