package out.Adrienne_Baptiste_657672_assignsubmission_file_;
import java.util.Scanner;
public class VirtualRunner
{
    public static void main(String[] args){
    String hold1;
    int hold2;
    int choice;
    VirtualMeetingSystem run=new VirtualMeetingSystem();
   
    run.loadParticipantData("participant.txt");
   
    Scanner keyboard = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    System.out.println("Enter Room Name");
    hold1 = keyboard.nextLine();
    run.createVirtualRoom(hold1);
   
     System.out.println("Enter Code C5 or RR");//RR or C5
    hold1 = keyboard.nextLine();
    run.allocateParticipants(hold1);
   
    System.out.println("Chose from options below 1 to 6");
    for(int x=0;x<50;x++){
     System.out.println("1-Add your own participant");  
     System.out.println("2-Show participant in a room");
     System.out.println("3-Close or open a room");
     System.out.println("4-Find participant location");
     System.out.println("5-Display all managed Rooms");
     System.out.println("6-Show break out rooms and their participants");
     System.out.println("99-Exit program");
     choice = input.nextInt();
     if(choice==1){
         System.out.println("Add your own Participant");
        System.out.println("Enter 8 digit Participant ID ");
        keyboard.nextLine();
        String hold = keyboard.nextLine();
        stringtest(hold);
        //System.out.println(hold);
        System.out.println("Enter room ID number eg 1 for Room 1 ");
        int hold3 = keyboard.nextInt();
        run.addParticipant(hold,hold3);
       
        }
     if(choice==2){
        System.out.println("Participants in selected Room");
        System.out.println("Enter room ID number eg 1 for Room 1");
        hold2 = keyboard.nextInt();
        System.out.println(run.listParticipants(hold2));
       
        }
     if(choice==3){
         System.out.println("1 to open room and 2 to close");
        int choice2 = input2.nextInt();
       
        if(choice2==1){System.out.println("Open room of your choice from 1 to 5");
            hold2 = keyboard.nextInt();
            run.openBreakoutRoom(hold2);
        }
       
       
        if(choice2==2){
            System.out.println("Close room of your choice from 1 to 5");
            hold2 = keyboard.nextInt();
            run.closeBreakoutRoom(hold2);
        }
         
        }
     if(choice==4){
         System.out.println("Participant Locator");
         keyboard.nextLine();
         hold1 = keyboard.nextLine();
         System.out.println("Participant is located at "+run.findParticipantBreakoutRoom(hold1));
       
        }
     if(choice==5){
        System.out.println("Breakout Room Manager");
        System.out.println(run.listAllBreakoutRooms());
        }
     if(choice==6){
         System.out.println("Over View");
         System.out.println(run.listParticipantsInAllBreakoutRooms());
       
        }
     if(choice==99){System.out.println("Exiting");break;}
     
     else if (choice>6 && choice!=99){System.out.println("Try Again");}
   
   
    }
   
   
   
   
 
   
      //System.out.println(run.listParticipants(1));
    //System.out.println(run.listParticipants(1));
   
   
    }
  public static void stringtest(String test){
    int count=test.length();
          for (int i = 0; i < count; i++) {
 
           
            if (test.charAt(i) >= '0'
                && test.charAt(i) <= '9' && count==8) {
                 
            }
            else {
                System.out.println("ID contains letters or less than 8 ");
               
            }
        }}
}