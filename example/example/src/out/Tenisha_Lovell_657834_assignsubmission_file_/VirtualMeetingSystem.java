package out.Tenisha_Lovell_657834_assignsubmission_file_;import java.util.Scanner; 
import java.io.*;
public class VirtualMeetingSystem{
    
    private VirtualRoom vr;
    private String[] partArr;
    private String name;
    public VirtualMeetingSystem(String name){
        //vr = new VirtualRoom(name);
        //this.name = name;
        partArr = new String[999];
    }
    
    public void loadParticipantData(String filename){
        String partId;
        int i = 0;
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
              //  System.out.println(scanner.nextLine());
              partArr[i] = scanner.nextLine();
              i++;
            }
            scanner.close();
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    
    }
    
    public void allocateParticipants(String code){
        
        if(code.equals("C5")){
            int i=0;
            int currRoom = 0;
            while(partArr[i] != null  ){
                if(i % 5 == 0){
                    currRoom++;
                }
                if(!this.addParticipant(partArr[i], currRoom)){
                    break;
                }
               else i++;
            }
            
        }
        
        else if(code.equals("RR")){
            int low = 0;
            int hi = 5;
            int currRoom = 1;
            System.out.println("hi");
           // this.addParticipant(partArr[0], 0);
            //this.addParticipant(partArr[0], 1);
           // this.addParticipant(partArr[0], 2);
            //this.addParticipant(partArr[hi], currRoom);
            while(this.addParticipant(partArr[low], currRoom) == true && this.addParticipant(partArr[hi], currRoom) == true){
                low++;
                hi++;
                currRoom++;
            }
        }
        
    }
    public void test(){
        vr.testView();
        }
    public boolean addParticipant(String participantID, int roomNumber){
        return(vr.addParticipantToBreakoutRoom(participantID, roomNumber));
    }
    public void createVirtualRoom(String name){
            vr = new VirtualRoom(name);
            vr.createBreakoutRooms();   
    }
}