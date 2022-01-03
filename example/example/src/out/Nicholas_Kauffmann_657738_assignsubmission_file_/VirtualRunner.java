package out.Nicholas_Kauffmann_657738_assignsubmission_file_;import java.util.Scanner;

public class VirtualRunner      //ID: 816015405
{

    public VirtualRunner()
    {

    }
 
    
    public static void main(String[] args){
        String output = "";
        String caseChoice = "";
        int roomNumber ;
        int input = 0 ;



        VirtualMeetingSystem sys1 = new VirtualMeetingSystem();
        sys1.loadParticipantData("participant.dat");            //q1
        sys1.createVirtualRoom("Virtual Room");                 //q2


        Scanner userInput = new Scanner(System.in);
        Scanner caseInput = new Scanner(System.in);
        //input = userInput.nextInt();

        while(input !=9){
            System.out.println("\n\t\t\t\t\tMain Menu");
            System.out.println("1. Allocate participants to breakout rooms. Enter C5 to allocate in clusters of 5, or RR to allocate in a round robin style.");
            System.out.println("2. Add a new participant to a breakout room.(ID must be 8 digits long)");
            System.out.println("3. Display a list of all participants in a selected breakout room.");
            System.out.println("4. Close selected breakout Room.");
            System.out.println("5. Open a selected breakout Room.");
            System.out.println("6. Find a participants breakout Room number");
            System.out.println("7. Display all breakout rooms managed by the system.");
            System.out.println("8. Display all breakout rooms and the participants in each room.");
            System.out.println("9. Quit Program.");

            System.out.print("\n\tChoice: ");
            input = userInput.nextInt();

            switch (input){
                case 1:
                    System.out.print("Allocation choice(C5 or RR): ");
                    caseChoice = caseInput.nextLine();
                    System.out.println(caseChoice+"\n");
                    sys1.allocateParticipants(caseChoice);
                    break;

                case 2:
                    System.out.print("Enter participant ID: ");
                    caseChoice = caseInput.nextLine();

                    System.out.print("Enter room number: ");
                    roomNumber = caseInput.nextInt();
                    sys1.addParticipant(caseChoice,roomNumber);
                    caseInput.nextLine();       //getting rid of trailing \n from nextInt 
                    break;

                case 3:
                    System.out.print("Enter breakout room number: ");
                    roomNumber = caseInput.nextInt();
                    output = sys1.listParticipants(roomNumber);
                    System.out.println(output);
                    caseInput.nextLine();       //getting rid of trailing \n from nextInt 
                    break;

                case 4:
                    System.out.print("Enter breakout room number: ");
                    roomNumber = caseInput.nextInt();
                    sys1.closeBreakoutRoom(roomNumber);
                    caseInput.nextLine();       //getting rid of trailing \n from nextInt 
                    break;

                case 5:
                    System.out.print("Enter breakout room number: ");
                    roomNumber = caseInput.nextInt();
                    sys1.openBreakoutRoom(roomNumber);
                    caseInput.nextLine();       //getting rid of trailing \n from nextInt 
                    break;

                case 6:
                    System.out.print("Enter participant ID: ");
                    caseChoice = caseInput.nextLine();
                    output = sys1.findParticipantBreakoutRoom(caseChoice);
                    System.out.println(output);
                    break;

                case 7:
                    output = sys1.listAllBreakoutRooms();
                    System.out.println(output);
                    break;

                case 8:
                    output = sys1.listParticipantsInAllBreakoutRooms();
                    System.out.println(output);
                    break;

                case 9:
                    break;
                default:
                    System.out.println("Invalid choice!");

            }

            output="";
            System.out.println("\n\n");
        }




        System.out.println("Exiting Program...");
    }

}
