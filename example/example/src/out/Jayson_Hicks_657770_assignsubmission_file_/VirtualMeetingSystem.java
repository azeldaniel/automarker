package out.Jayson_Hicks_657770_assignsubmission_file_;//breakoutRoomSizebreakoutRoomSize/Student ID:816000935
import java.io.*;
import java.util.*;
import java.text.ParseException;
        
public class VirtualMeetingSystem extends VirtualRoom{
    private static String[] content = new String[50];
    private static VirtualRoom vr;
    
 
                           
    public void loadParticipantData(String filename)
    {
            try{ 
                int i=0,count=0;
                
                Scanner x = new Scanner(new File(filename));
                while(x.hasNext()){
                    //count++;
                    x.next();
                    //System.out.println("Good file: " + count + x.next());
                    
                }
                x.close();
                //System.out.println("====================");
                //content = new String[count];
                x = new Scanner(new File(filename));
                
                while (x.hasNext()){ 
                    content[i]= x.next(); 
                    //System.out.println("Good file: "+ content[i]);
                    i++;
                }
                x.close();
            }
            catch( Exception e){
                System.out.println("couldnt find file" + e);
            }
    }
    public void createVirtualRoom(String name)
    {
        vr = new VirtualRoom(name);
        vr.createBreakoutRooms();
        //System.out.println("Room Created");

    }
                       
            
    public void allocateParticipants(String code){
        String names = "";
        int count=0,numbreakRooms,tracker=1,allocator=5;
        numbreakRooms = vr.getNumberOfBreakoutRooms();
        if ((code) == "RR"){
            System.out.println("Round Robin allocation"+"\n");
            for(int i=0; i<content.length; i++){
                
                names = content[i];
                vr.addParticipantToBreakoutRoom(names,tracker);                                         
                tracker++;
                    
             
                if (tracker>numbreakRooms){                        
                    tracker=1; 
                }
            }
            
        }else if ((code) == "C5"){
            
            System.out.println("C5 allocation"+"\n");
            for(int i=0; i<content.length; i++){
                    
                    names = content[i];
                    vr.addParticipantToBreakoutRoom(names,tracker);                                         
                    count++;
                    
                    if (count%allocator==0){
                        tracker +=1; 
                    }
                    if (tracker>numbreakRooms){                        
                        tracker=1; 
                    }
            }
        } else {
            System.out.println("Please enter a valid allocation type by exiting the program and retrying");
        }
                       
  
    }
    

    public boolean addParticipant(String participantID,int roomNumber){
        return vr.addParticipantToBreakoutRoom(participantID,roomNumber);
    }
    public String listParticipants(int roomNumber){
        return vr.listParticipantsInBreakoutRoom(roomNumber);
    }
    public boolean closeBreakoutRoom(int roomNumber){         
        return vr.closeBreakoutRoom(roomNumber);               
    }
    public boolean openBreakoutRoom(int roomNumber){
        return vr.openBreakoutRoom(roomNumber); 
    }
    public String findParticipantBreakoutRoom(String participantID){
        return "ParticipantID:"+participantID +" located in "+ vr.findParticipantBreakoutRoom(participantID);         
    }
    public String listAllBreakoutRooms(){
        return vr.listBreakoutRooms();        
    }
    public String listParticipantsInAllBreakoutRooms(){
        int numbreakRooms = vr.getNumberOfBreakoutRooms();
        String roomnames = "";
        for(int z=1; z<=numbreakRooms; z++){ //starts at the first room and ends at the last
            
            roomnames += listParticipants(z) + "\n"; 
        }
       
        return roomnames + "\n";
    }

}

    
