package out.Amirah_Ali_657679_assignsubmission_file_;//816020184
import java.io.*;
import java.util.Scanner;
    
public class VirtualRunner{
    public static void main(String[] args) throws FileNotFoundException{
        VirtualMeetingSystem vms = new VirtualMeetingSystem();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter choose option (1-3): ");
        int opt = sc.nextInt();
        if (opt == 1){
            
            System.out.println("Scenario 1:");
            System.out.println("Creates, allocates and allocates participants using C5");
            System.out.println("Prints all breakout rooms manages and their participants.\n");
            
            vms.loadParticipantData("Participant.dat");
            vms.createVirtualRoom("Workshop");
            vms.allocateParticipants("C5");
            System.out.println(vms.listAllBreakoutRooms());
            System.out.println(vms.listParticipantsInAllBreakoutRooms());
            
            System.out.println("Searching for 12103114's Workshop");
            System.out.println(vms.findParticipantBreakoutRoom("12103114"));
            
        }
            
        if (opt == 2){
            System.out.println("Scenario 2:");
            System.out.println("Creates, allocates and allocates participants using RR");
            System.out.println("Prints all breakout rooms manages and their participants.");
            System.out.println("Lists participants in a particular Workshop\n");
            
            vms.loadParticipantData("Participant.dat");
            vms.createVirtualRoom("Workshop");
            vms.allocateParticipants("RR");
            System.out.println(vms.listAllBreakoutRooms());
            System.out.println(vms.listParticipantsInAllBreakoutRooms());
            
            System.out.println("Listing Participants is Workshop2");
            System.out.println(vms.listParticipants(2));
        }
        
        if (opt == 3){
            
            System.out.println("Scenario 1:");
            System.out.println("Creates and manually adds a participant");
            System.out.println("Prints all breakout rooms manages and their participants.\n");
            System.out.println("Closes and opens a breakout room");

            vms.createVirtualRoom("Workshop");
            vms.addParticipant("12345678", 2);
            
            System.out.println(vms.listAllBreakoutRooms());
            System.out.println(vms.listParticipantsInAllBreakoutRooms());
            
            vms.addParticipant("22002020", 2);
            System.out.println(vms.listAllBreakoutRooms());
            System.out.println(vms.listParticipantsInAllBreakoutRooms());

            if (vms.closeBreakoutRoom(3)){
                System.out.println("Room is now closed\n");
            }
            
            if (vms.openBreakoutRoom(3)){
                System.out.println("Room is open\n");
            }
        }
        
        if (opt != 1 && opt != 2 && opt != 3){
            System.out.println("Invalid Option");
        } 
    }
}
