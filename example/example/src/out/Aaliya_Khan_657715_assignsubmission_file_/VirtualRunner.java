package out.Aaliya_Khan_657715_assignsubmission_file_;
/**
 * Student ID - 816019696
 */

import java.util.Scanner;

public class VirtualRunner
{

    public static void main(String[] args){
        VirtualMeetingSystem room = new VirtualMeetingSystem();
        String list;
        Scanner input = new Scanner(System.in);
        
        room.loadParticipantData("participant.dat"); // 1
        
        System.out.println("Please enter the name of the virtual room");
        String name = input.next();
        
        room.createVirtualRoom(name);  // 2
        
        System.out.println("Please select the method you would like to use to allocate the participants. C5 or RR");
        String type = input.next();
        
        room.allocateParticipants(type);  // 3
        
        System.out.println("Please enter the ID of the participant you want to add.");
        String ID = input.next();
        System.out.println("Please enter which room you would like to add the participant to.");
        int roomNum = input.nextInt();
        
        boolean add;
        add = room.addParticipant(ID, roomNum);  // 4
        
        if(add == false){
            System.out.println("Chosen room is full.");
            System.out.println();
        }
        else {
            System.out.println("Participant was added to the room.");
            System.out.println();
        }
        
        System.out.println("Please enter a breakout room number to see its participants");
        roomNum = input.nextInt();
        
        list = room.listParticipants(roomNum);  // 5
        System.out.println(list);
        
        System.out.println("Please enter the number of the room you could like to close.");
        roomNum = input.nextInt();
        
        boolean close;  // 6
        close = room.closeBreakoutRoom(roomNum);
        
        if(close == true){
            System.out.println("Breakout room was closed.");
            System.out.println();
        }
                
        System.out.println("Please enter the number of the room you could like to open.");
        roomNum = input.nextInt();
        
        boolean open;  // 7
        open = room.openBreakoutRoom(2);
        
        if(open == true){
            System.out.println("Breakout room was opened.");
            System.out.println();
        }
        
        System.out.println("Please enter the ID of the participant you would like to locate.");
        ID = input.next();
        
        String find;  // 8
        find = room.findParticipantBreakoutRoom(ID);
        System.out.println("This person is in " + find); 
        System.out.println();
        
        list = room.listAllBreakoutRooms( );  // 9
        System.out.println(list);
        System.out.println();
        
        list = room.listParticipantsInAllBreakoutRooms();
        System.out.print(list); 
        System.out.println();
        
    }
}
