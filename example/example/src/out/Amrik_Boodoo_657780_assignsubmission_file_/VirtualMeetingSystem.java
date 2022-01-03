package out.Amrik_Boodoo_657780_assignsubmission_file_;
/**
 * 
 *
 * Amrik Boodoo 816018329
 * 
 */
import java.io.*;                   //necessary for file reading


public class VirtualMeetingSystem 
{

    private VirtualRoom VR;
    private String array[]= new String[50];
    private int numVirtualRooms=0;      // in the event where more than 1 virutal room is made
    private int num=1;                  //used for changing room numbers when allocating participants
    int i=0;
    
    //Resources for info on file reading: Keep On Coding                   (Youtube)         Link Below
    // https://www.youtube.com/watch?v=hgF21imQ_Is&t=314s
    // https://stackoverflow.com/questions/18173222/difference-between-catchexception-and-catchexception-ex   - for info on exception ex

    public void loadParticipantData(String filename)    
    {
        String pID= "temp";
        try{
            BufferedReader BR= new BufferedReader(new FileReader(filename));
            while(pID!= null){
                pID= BR.readLine();
                array[i]=pID;
                i+=1;
            }
        
        BR.close();
        }
         catch(Exception ex){
            return;
        }
    }
    
    public void createVirtualRoom(String name){
        VR= new VirtualRoom(name);
        numVirtualRooms+=1;
        
    }
    
    public void allocateParticipants(String code){
        

        if(code== "c5"){
            
            for(int k=0; k<5; k++){
                VR.addParticipantToBreakoutRoom(array[k],num);
            }
            // originally i wanted to do this in one loop but faced an error in allocating to room 1 where only 4 patients would be allocated
            //resorted to allocating the first 5 in room 1 first
            
             for (int j=5; j<i; j++){
                 if (j%5==0){
            
                    num+=1;
                    if(num==6){
                        num=1;
                    }
                 
                }
                VR.addParticipantToBreakoutRoom(array[j],num);             
             
             }
          

            
            }
        
    }
        
        
    public boolean addParticipant(String participantID,int roomNumber){
    
        if(VR.findBreakoutRoom(roomNumber)!=null){
           VR.addParticipantToBreakoutRoom(participantID,roomNumber);
           return true;
        }
        
        return false;
        
    }
    
    public String listParticipants(int roomNumber){
        return VR.listParticipantsInBreakoutRoom(roomNumber);

    }
    
    public boolean openBreakoutRoom(int roomNumber){
        
        if(VR.findBreakoutRoom(roomNumber)!=null){
            VR.openBreakoutRoom(roomNumber);
            return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        
        if(VR.findBreakoutRoom(roomNumber)!=null){
            VR.closeBreakoutRoom(roomNumber);
            return true;
        }
        return false;
    }        
    
    public String findParticipantBreakoutRoom(String participantID){
        return VR.findParticipantBreakoutRoom(participantID);
        
    }
    
    public String listAllBreakoutRooms(){
        String list=VR.listBreakoutRooms();
        return list;
        
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String List= new String();
        
        for (int i=1; i<6; i++){
            
            List+= VR.listParticipantsInBreakoutRoom(i);
            List+="\n";
        }
        return List;
    }
    
    

}
