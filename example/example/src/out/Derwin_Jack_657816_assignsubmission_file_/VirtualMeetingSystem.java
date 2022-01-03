package out.Derwin_Jack_657816_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Scanner; 

/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (Derwin Jack 816022295)
 * @version (14/02/2021)
 */
public class VirtualMeetingSystem{
public VirtualRoom Vr;
public String[] parr;

public VirtualMeetingSystem(){
    parr = new String[50];
} 


 public void loadParticipantData(String filename ){
    ArrayList<String> data = new ArrayList<String>();
    File f = new File(filename);
     try{
            Scanner readIn = new Scanner(new File(filename));
            while (readIn.hasNextLine()){
            data.add(readIn.nextLine());
            }
        readIn.close();
        parr = data.toArray(new String[]{});
        }
    catch(FileNotFoundException e){
        System.out.println("An error occurred.");
            e.printStackTrace();
    }

}

public void createVirtualRoom(String name){
    Vr = new VirtualRoom(name);
    Vr.createBreakoutRooms();
}

public void allocateParticipants(String code ){
    if(code == null){
        System.out.println("Code Invalid");
   }
     else if(code == "C5"){
        int b = 0;
        for(int a=0 ; a < 50; a++){
            if(a%5==0){
                b++;
            }
            if(b==5){
                b=0;
            }
            Vr.addParticipantToBreakoutRoom(parr[a],b);
        }
        
    }
}

public boolean addParticipant (String participantID,int roomNumber){
    boolean AddP = false;
    AddP= Vr.addParticipantToBreakoutRoom(participantID, roomNumber);
    return AddP;
}

public String listParticipants(int roomNumber){
    String LP = "";
    LP += Vr.listParticipantsInBreakoutRoom(roomNumber);
    return LP;

}

public boolean openBreakoutRoom(int roomNumber){
    boolean OBR = false;
    OBR = Vr.openBreakoutRoom(roomNumber);
    return OBR;

}

public boolean closeBreakoutRoom(int roomNumber){
    boolean CBR = false;
    CBR = Vr.closeBreakoutRoom(roomNumber);
    return CBR;
}

public String findParticipantBreakoutRoom(String participantID){
    String FPBR = "";
    FPBR += Vr.findParticipantBreakoutRoom(participantID);
    return FPBR;
}

public String listAllBreakoutRooms(){
    String LABR = "";
    LABR += Vr.listBreakoutRooms();
    return LABR;

}

public String listParticipantsInAllBreakoutRooms(){
    String LPIABR = "";
    for(int i =0; i < 5; i++){
        LPIABR += Vr.listParticipantsInBreakoutRoom(i);
        LPIABR +="\n  ";
    }
    return LPIABR;    
}
 
}
