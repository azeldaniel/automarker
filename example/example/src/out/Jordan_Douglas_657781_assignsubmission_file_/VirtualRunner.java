package out.Jordan_Douglas_657781_assignsubmission_file_;// Name: Jordan Douglas ID: 816022324

import java.io.*; 
import java.util.*;
public class VirtualRunner
{
  public static void main( String[]args){
    VirtualMeetingSystem v= new VirtualMeetingSystem();
    Scanner in= new Scanner(System.in);
    String options="Choose one of the following options: \n";
    options+="1. Load participant data from a data file\n";
    options+="2. Create a new virtual room\n";
    options+="3. Allocate participants to breakout rooms\n" ;
    options+="4. Add a new participant to a breakout room\n" ;
    options+="5. Display a list of all participants in a breakout room\n" ;
    options+="6. Close a breakout room based on a room number\n" ;
    options+="7. Open a breakout room based on a room number\n" ;
    options+="8. Find a participant’s breakout room number\n" ;
    options+="9. Display a list of all breakout rooms managed by the system\n" ;
    options+="10. Display a list of all breakout rooms managed by the system and the participants in each room\n" ;
    options+="11. Exit\n" ;
    System.out.println(options);
    
    int choice= in.nextInt();
    int num;
    while(choice !=11){
    if(choice==1){
        v.loadParticipantData("participant.dat");
    }
    if(choice==2){
        System.out.print("Enter the name of the room: ");
         Scanner reader= new Scanner(System.in);
        String name= reader.nextLine();
        v.createVirtualRoom(name);
    }
    
    if(choice==3){
        System.out.print("Enter code: ");
        Scanner reader= new Scanner(System.in);
        String code= reader.nextLine();
        v.allocateParticipants(code);
    }
    if(choice==4){
        System.out.print("Enter participant ID: ");
         Scanner reader= new Scanner(System.in);
        String code= reader.nextLine();
        System.out.print("Enter room number: ");
         num= in.nextInt();
        
        v.addParticipant(code,num);
    }
    if(choice==5){
        System.out.print("Enter room number: ");
        num= in.nextInt();
        System.out.println(v.listParticipants(num));
    }
    if(choice==6){
        System.out.print("Enter room number: ");
       num= in.nextInt();
        v.closeBreakoutRoom(num);
    }
    if(choice==7){
         System.out.print("Enter room number: ");
       num= in.nextInt();
        v.closeBreakoutRoom(num);
    }
    if(choice==8){
        System.out.print("Enter participant ID: ");
        Scanner reader= new Scanner(System.in);
        String code= reader.nextLine();
        v.findParticipantBreakoutRoom(code);
    }
    if(choice==9){
        System.out.println(v.listAllBreakoutRooms());
    }
    if(choice==10){
        System.out.println(v.listParticipantsInAllBreakoutRooms());
    }
     System.out.println(options);
    choice= in.nextInt();
}
    
  
   
    
    
    
    
    
    
    
}
}
