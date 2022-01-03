package out.Zion_Haye_657855_assignsubmission_file_;/*
 Student ID : 816020871
*/
import java.util.Scanner;
import java.util.Random;

public class VirtualRunner{
    public static void main(String[] args){
              
        VirtualMeetingSystem virtualMeetingSystem;
        virtualMeetingSystem = new VirtualMeetingSystem();
        
        int option;
        
        option = 0;
        
        while(option!=999){
            option=menu(virtualMeetingSystem);
        }
        
        System.out.println("- System Terminated - ");
               
    }
    
    public static int menu (VirtualMeetingSystem virtualMeetingSystem){
        
        Scanner keyboard = new Scanner (System.in);
        int option;
        
        System.out.println("Welcome to the Virtual Meeting System ");
        System.out.println("---------------------------------------");
        
        System.out.println("1 - Load Participant data from a file.");
        System.out.println("2 - Create a new Virtual Room.");
        System.out.println("3 - Allocate Participants to Breakout Rooms.");
        System.out.println("4 - Add a new Participant to a Breakout Room.");
        System.out.println("5 - Display a list of All Participants in a Breakout Room.");
        System.out.println("6 - Close a Breakout Room based on a Room Number.");
        System.out.println("7 - Open a Breakout Room based on a Room Number.");
        System.out.println("8 - Find a Participant's Breakout Room Number.");
        System.out.println("9 - Display a list of All Breakout Rooms managed by the system.");
        System.out.println("10 - Display a list of all Breakout Rooms managed by the system and Participants in each room.");
        System.out.println("999 - Quit.");
        
        System.out.println("Please enter an option:");
        option = keyboard.nextInt();
        
        if(option == 1){
            option1(virtualMeetingSystem);
        }
        
        else if (option == 2){
            option2(virtualMeetingSystem);
        }
        
        else if (option == 3){
            option3(virtualMeetingSystem);
        }
        
        else if (option == 4){
            option4(virtualMeetingSystem);
        }
        
        else if (option == 5){
            option5(virtualMeetingSystem);
        }
               
        else if (option == 6){
            option6(virtualMeetingSystem);
        }
        
        else if (option == 7){
            option7(virtualMeetingSystem);
        }
        
        else if (option == 8){
            option8(virtualMeetingSystem);
        }
        
        else if (option == 9){
            option9(virtualMeetingSystem);
        }
        
        else if (option == 10){
            option10(virtualMeetingSystem);
        }
        
        else if ( (option <=0) || (option >10) && (option!=999) ){
            System.out.println("Invalid Option.");
        }
        
        return option;
    }
    
    public static void option1(VirtualMeetingSystem virtualMeetingSystem){
        Scanner keyboard = new Scanner (System.in);
        
        String filename;
                
        System.out.println("Please enter the File Name (e.g participant.dat)");
        filename = keyboard.nextLine();
        
        virtualMeetingSystem.loadParticipantData(filename);
        
        
    }
    
    public static void option2(VirtualMeetingSystem virtualMeetingSystem){    
        Scanner keyboard = new Scanner (System.in);
               
        String name;
                
        System.out.println("Please enter the name of the Virtual Room");
        name = keyboard.nextLine();
        
        virtualMeetingSystem.createVirtualRoom(name);
        
        System.out.println("Virtual Room : " + name + " has been created.");        
        
    }
    
    public static void option3(VirtualMeetingSystem virtualMeetingSystem){
        
        Random r = new Random();
        int randomNumber;
        String code;
        
        randomNumber = r.nextInt(2);
        
        if(randomNumber == 0){
            code = "C5";
        }else{
            code = "RR";
        }
        
        virtualMeetingSystem.allocateParticipants(code);
        
        
    } 
    
    public static void option4(VirtualMeetingSystem virtualMeetingSystem){
        Scanner keyboard = new Scanner (System.in);
        
        String participantID;
        int roomNumber;
        boolean isSuccessful;
        
        
        System.out.println("Please enter the Participant ID: ");
        participantID = keyboard.nextLine();
        
        System.out.println("Please enter the Room Number: ");
        roomNumber = keyboard.nextInt();
        
        isSuccessful = virtualMeetingSystem.addParticipant(participantID,roomNumber);
        
        if(isSuccessful == true){
            System.out.println("Participant was added successfully.");
        }else{
            System.out.println("Participant was not added successfully.");
        }
        
        
    } 
    
    public static void option5(VirtualMeetingSystem virtualMeetingSystem){
       Scanner keyboard = new Scanner (System.in);
       
       int roomNumber;
       String listOfParticipants;
       
       System.out.println("Please enter the Room Number: ");
       roomNumber = keyboard.nextInt();
       
       listOfParticipants = virtualMeetingSystem.listParticipants(roomNumber);
       System.out.println(listOfParticipants);
       
    } 
    
    public static void option6(VirtualMeetingSystem virtualMeetingSystem){
       Scanner keyboard = new Scanner (System.in);
       
       int roomNumber;
       boolean isClose;
       
       System.out.println("Please enter the Room Number of the room to be closed: ");
       roomNumber = keyboard.nextInt();
       
       isClose = virtualMeetingSystem.closeBreakoutRoom(roomNumber);
       
       if(isClose == true ){
           System.out.println("Room successfully Closed.");
       }else{
           System.out.println("Room not succesfully Closed.");    
       }
    }
    
    public static void option7(VirtualMeetingSystem virtualMeetingSystem){
       Scanner keyboard = new Scanner (System.in);
       
       int roomNumber;
       boolean isOpen;
       
       System.out.println("Please enter the Room Number of the room to be opened: ");
       roomNumber = keyboard.nextInt();
       
       isOpen = virtualMeetingSystem.openBreakoutRoom(roomNumber);
       
       if(isOpen == true ){
           System.out.println("Room successfully Opened.");
       }else{
           System.out.println("Room not succesfull Opened.");    
       } 

    }
    
    public static void option8(VirtualMeetingSystem virtualMeetingSystem){
       Scanner keyboard = new Scanner (System.in);
       
       String participantID;
       String breakoutRoomID;
       
       System.out.println("Please enter the Participant ID: ");
       participantID = keyboard.nextLine();
       
       breakoutRoomID = virtualMeetingSystem.findParticipantBreakoutRoom(participantID);
       
       if(breakoutRoomID==null){
           System.out.println("Breakout Room not Found for Participant.");    
       }else{
           System.out.println("Participant : " +  participantID);
           System.out.println("Breakout Room ID : " +  breakoutRoomID);
           
       }    
       
    }
    
    public static void option9(VirtualMeetingSystem virtualMeetingSystem){
       String listOfBreakoutRooms;
       
       listOfBreakoutRooms = virtualMeetingSystem.listAllBreakoutRooms();
       
       System.out.println(listOfBreakoutRooms);
       
       
    }
    
    public static void option10(VirtualMeetingSystem virtualMeetingSystem){
        
        String listOfParticipantsInAllBreakoutRooms;
        
        listOfParticipantsInAllBreakoutRooms = virtualMeetingSystem.listParticipantsInAllBreakoutRooms();
        
        System.out.println(listOfParticipantsInAllBreakoutRooms);
        
        
    }
    
}