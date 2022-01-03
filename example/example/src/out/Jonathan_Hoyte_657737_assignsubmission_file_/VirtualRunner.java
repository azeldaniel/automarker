package out.Jonathan_Hoyte_657737_assignsubmission_file_;// 816013096
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;

public class VirtualRunner{
    /** Menu function used to display options by number to avoid retyping   */
  public static void Menu(){
    System.out.println(" Menu: Please select an Option but typing in the corrisponding number for your Virtual Meeting System. \n"+
                            "1. Add a new participant to a breakout room. \n "+
                            "2. Display a list of all participants in a breakout room \n"+ 
                            "3. Close a breakout room \n"+
                            "4. Open a breakout room \n"+ 
                            "5. Find a participant’s breakout room number \n"+
                            "6. Display a list of all breakout rooms managed by the system \n"+
                            "7. Display a list of all breakout rooms and the participants in each room \n"+
                            "8. Close Virtual Meeting System \n");
                     }
  public static void main(String args[]){
      String[] IDs = {""}; //ID Array
      String VirtualNames; // Stores name for Vitual Room;
      String ID = ""; // For inputting ID number
      String filename="";
      int roomNumber=0; //Made for input;
      int Opt = 0;
      boolean Door; // Deals with the opening and closing of breakrooms
      VirtualMeetingSystem VMS = new VirtualMeetingSystem();
      
      Scanner Sel = new Scanner(System.in); // Menu option scanner
      Scanner ipt = new Scanner(System.in); // input scanner
      System.out.println("Welcome to the Virtual meeting System \n"+
      "Please enter a name for your virtual Room \n");
      VirtualNames=ipt.nextLine();
     
      VMS.createVirtualRoom(VirtualNames);
      VMS.loadParticipantData(filename);
      System.out.println("Loading successful \n");
      Menu();
      Opt = Sel.nextInt();
      
      while(Opt!=8){
        switch(Opt) {
          case 1:
             System.out.println("Option 1: Add participant ID and breakout Room that you need \n");
             System.out.println("Enter ParticipantID (must have 8 characters) \n");
             ID=ipt.nextLine();
             while(ID.length()!=8){//Precaution
             if(ID.length()!=8){ //Double Precaution
                System.out.println("Participant ID must be 8 characters please redo \n");
                ID=ipt.nextLine();
             }
            }
             System.out.println("ParticipantID: "+ID + "\n");
             System.out.println(VMS.listAllBreakoutRooms()+"\n Enter of choice Room Number: ");
             roomNumber = ipt.nextInt();
            while(roomNumber >5 || roomNumber<1){
             System.out.println("Room does not exist please choose again. \n");
             roomNumber = ipt.nextInt();
            }
             System.out.println("BreakRoom"+roomNumber+ "\n");
             if(VMS.addParticipants(ID,roomNumber)==false)
              System.out.println("Error could not add participant to breakroom \n");
            else{ 
              System.out.println("Participant added successfully \n");
            }
             
            Menu();
            Opt=Sel.nextInt();
          break;
          
          case 2: 
            System.out.println("Option 2: Input Breakroom number \n");
            roomNumber=ipt.nextInt();
            while(roomNumber >5 || roomNumber<1){
             System.out.println("Room does not exist please choose again. \n");
             roomNumber = ipt.nextInt();
            }
            System.out.println(VMS.listParticipants(roomNumber));
            Menu();
            Opt=Sel.nextInt();
          break;
          
          case 3: 
            System.out.println("Option 3: Close Breakout room \n Enter BreakRoom number");
            roomNumber = ipt.nextInt();
            while(roomNumber >5 || roomNumber<1){
             System.out.println("Room does not exist please choose again. \n");
             roomNumber = ipt.nextInt();
            }
            Door = VMS.closeBreakoutRoom(roomNumber);
            if(Door == true)
              System.out.println("Room closed \n");
            
             Menu();
             Opt=Sel.nextInt(); 
          break;
          
          case 4:
            System.out.println("Option 4: Open Breakoutroom \n Enter Room number.");
            roomNumber = ipt.nextInt();
            while(roomNumber >5 || roomNumber<1){
             System.out.println("Room does not exist please choose again. \n");
             roomNumber = ipt.nextInt();
            }
            Door = VMS.openBreakoutRoom(roomNumber);
            if(Door == true)
              System.out.println("Room opened \n");
            
             Menu();
             Opt=Sel.nextInt(); 
          break;
          
          case 5:
            System.out.println("Option 5: Enter Participant ID to find breakroom \n");
            ID=ipt.nextLine();
             while(ID.length()!=8){//Precaution
             if(ID.length()!=8){ //Double Precaution
                System.out.println("Participant ID must be 8 characters please redo \n");
                ID=ipt.nextLine();
             }
            }
            String Found = VMS.findParticipantBreakoutRoom(ID);
            if(Found==null){
              System.out.println("Breakout/Participant not found");
             Menu();
             Opt=Sel.nextInt(); 
             break;
            }
            else{
             System.out.println(Found);
             Menu();
             Opt=Sel.nextInt();
             break;
            }
          
          case 6:
            System.out.println("Option 6: Display all Breakout Rooms \n");
            String listo = VMS.listAllBreakoutRooms();
            System.out.println(listo);
            Menu();
            Opt=Sel.nextInt();
          break;
          
          case 7:
            System.out.println("Option 7: Display all Breakrooms & Participants \n");
            String list2 = VMS.listParticipantInAllBreakoutRooms();
            if(list2==null){
                System.out.println("System error \n");
                 Menu();
                Opt=Sel.nextInt();
                break;
             } 
             else{
                System.out.println(list2);
                Menu();
                Opt=Sel.nextInt();
                break;
            }
            
          case 8:
             System.out.println("Closing System");
             break;
             
          default: 
           System.out.println("Number entered is invalid \n Please re-enter");
                 Opt=Sel.nextInt();
        }
    }  
 }
}
