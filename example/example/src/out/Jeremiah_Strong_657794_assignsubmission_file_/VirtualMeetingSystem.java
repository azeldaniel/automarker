package out.Jeremiah_Strong_657794_assignsubmission_file_;import java.util.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 ** @author (Jeremiah Strong)
 * @ID: 816023620
 */
public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    private String[] data;
    private int numOfParticipants;
    public int allocatedParticipants;
    private String virtualRoomname;
    VirtualRoom vr;
    
    public VirtualMeetingSystem()
    {
        numOfParticipants= 0;
        data= new String[50];
        allocatedParticipants=0;
        
    }
    
    public void loadParticipantData(String filename){
       try{
        File input= new File(filename);
        Scanner scanner= new Scanner(input);
        
        while (scanner.hasNextLine()) {
            
            data[numOfParticipants] = scanner.nextLine();
            //System.out.println(data[numOfParticipants]);
             numOfParticipants++;
        }
        scanner.close();
        System.out.println("Participnts Data has been loaded.");
       }
       
       catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
       }
       
        
    }

    
    public void createVirtualRoom(String name){
        vr= new VirtualRoom(name, 5);
        vr.createBreakoutRooms();
        this.virtualRoomname= name;
        
        boolean check;
        for(int i=0; i <5;i++){
            check= vr.openBreakoutRoom(i+1);
            if(check== false)
                System.out.println( name + (i+1) + " could not be found.");
        }
        
    }
    
    public void allocateParticipants(String code ){
        int roomNum=1;
        if( (code.equals("C5")==false) && !(code.equals("RR")) ){
            System.out.println(" An invalid code was entered.\nParticipants allocation was unsuccessful."); 
            return;
        }
        if(code.equals("C5") ){ //allocates in cluster
           // String BreakoutRoomName= this.virtualRoomname + roomNum;
            
           for(int i=0; i< numOfParticipants;i++){
               if( this.vr.fullBreakoutRoom( roomNum) ){
                    allocatedParticipants=0;
                    System.out.println(vr.getVRName() + roomNum +
                        "is full.");
                        
                    if( roomNum==5)   
                        roomNum=1;
                    else
                        roomNum++;
                        
                    System.out.println("Allocating participants to next Breakout Room, " +
                        vr.getVRName() + roomNum + ".\n");
                }
               boolean check= this.vr.addParticipantToBreakoutRoom(data[i], roomNum);
               
               if(check==false)
                System.out.println(" Participant ID, " + data[i] + ", could not be added. ");
                                
               else{
                allocatedParticipants++;
                if( allocatedParticipants%5 == 0){
                    if(roomNum== 5)
                        roomNum=1;
                    else
                        roomNum++;
                        
                   
                }
               }
               
            }//End of for loop
        }
        
        else if(code.equals("RR") ){
            
            for(int i=0; i< numOfParticipants;i++){
               if( this.vr.fullBreakoutRoom( roomNum) ){
                   System.out.println(vr.getVRName() + roomNum +
                        " is full.");
                    if( roomNum==5)   
                        roomNum=1;
                    else
                        roomNum++;
                        
                   System.out.println("Allocating participants to next Breakout Room, " +
                        vr.getVRName() + roomNum + ".\n");
                }
                
               boolean check2= this.vr.addParticipantToBreakoutRoom(data[i], roomNum);
               
               if(check2==false)
                System.out.println(" Participant ID, " + data[i] + ", could not be added. ");
               
                else{
                allocatedParticipants++;
                    if(roomNum== 5)
                        roomNum=1;
                    else
                        roomNum++;
                        
                } 
                
            }
            
        }
    }
    
    
    public boolean addParticipant( String participantID, int roomNumber){
        if( vr.isPresent( roomNumber) ){
        boolean check= this.vr.addParticipantToBreakoutRoom (participantID, roomNumber);
        return check;
        }
        else{
            System.out.println("The room number, " + roomNumber + " is invalid");
            return false;
        }
    }
    
    public String listParticipants(int roomNumber){
        String details= "\n" + vr.getVRName() + "\n";
        if( vr.isPresent( roomNumber) ){
            
            details+= vr.listParticipantsInBreakoutRoom( roomNumber);
            
        }
        
        else{
            //System.out.println("The room number, " + roomNumber + " is invalid");
            details+= "BreakoutRoom ID: does not exist\n";
        }
        return details;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if( vr.isPresent( roomNumber) ){ 
            return vr.openBreakoutRoom(roomNumber);
        }
        
        else{
            System.out.println("The room number, " + roomNumber + " is invalid");
            return false;
        }
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if( vr.isPresent( roomNumber) ){ 
            return vr.closeBreakoutRoom(roomNumber);
        }
        
        else{
            System.out.println("The room number, " + roomNumber + " is invalid");
            return false;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String breakoutRoomName= vr.findParticipantBreakoutRoom (participantID);
        return breakoutRoomName;
    }
    
    public String listAllBreakoutRooms( ){
        return vr.listBreakoutRooms( );
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String info= "";
        for(int i=1; i<= vr.getNumberOfBreakoutRooms(); i++){
            if( vr.isPresent(i) )
            info += "\n\nVirtualRoom Name: " + vr.getVRName() + "\n"  + vr.listParticipantsInBreakoutRoom(i) + "\n";
        }
        return info;
    }
    
    
}
