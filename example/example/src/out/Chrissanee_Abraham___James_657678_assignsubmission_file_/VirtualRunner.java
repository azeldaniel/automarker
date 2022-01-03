package out.Chrissanee_Abraham___James_657678_assignsubmission_file_;/**
 Name:Chrissanee Abraham-James
 ID: 816000377
 Course: Object Oriented Programming
 Course Code: COMP 2603
 Assignment 1
 */

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class VirtualRunner
{

    //private String parArray[];
    //private String parfile;
    private Scanner myscan;
    
    public static void main(String[] args) {
        //String[] parArray = new String[50];
        Scanner uin = new Scanner(System.in);
        String rname = new String("");
        String code = new String("");
        String opt = new String("0");
        String opt2 = new String("0");
        String parfile = new String("participant.dat");
        int rI =0;
        int i = 0;
        String ID = "";
        VirtualMeetingSystem u1 = new VirtualMeetingSystem();
        u1.loadParticipantData(parfile);
        
        while(opt!="9"){  //Menu Loop
            switch(opt) { //Menu Options
              default:    
                System.out.println("\tMenu");
                System.out.println("1.Create New Room");
                System.out.println("2.Allocate Participants");
                System.out.println("3.List And Participant Methods");
                System.out.println("4.Breakoutroom Methods");
                System.out.println("9.Exit");
                
                opt = uin.nextLine();
                break;
              case "1"://WORKS 
                System.out.println("\nName of New Room: ");
                if (rname.equals("")){
                    rname = uin.nextLine();
                }
                u1.createVirtualRoom(rname);
                opt= "0";
                break;
              case "2"://WORKS
              
                System.out.println("\nChoose Allocation method C5 or RR: ");
                if (code.equals("")||code.equals(null)){
                    code = uin.nextLine();
                }
                System.out.println("\nAllocating Participants...");//WORKS
                u1.allocateParticipants(code);
                code="";
                opt= "0";
                break;
              case "3"://WORKS - ALL MENU OPTIONS FUNCTIONAL 
                  while(opt2!="9"){  //subMenu Loop
                    switch(opt2) { //subMenu Options
                      default:
                        System.out.println("\nList and Participant Methods: ");
                        System.out.println("1.List All Breakout Rooms");
                        System.out.println("2.List Participants in Selected Breakroom");
                        System.out.println("3.List Participants In All Breakout Rooms");
                        System.out.println("4.Locate Participant");
                        System.out.println("5.Add Participant to Breakout Room");
                        System.out.println("9.Exit");                
                        opt2 = uin.nextLine();
                        break;
                      case "1":
                        System.out.println(u1.listAllBreakoutRooms( ));
                        opt2= "0";
                        break;
                        
                      case "2":
                        System.out.println("Select Breakroom Index: ");              
                        opt2 = uin.nextLine();
                        i=Integer.parseInt(opt2);
                        System.out.println(u1.listParticipants(i));
                        opt2= "0";
                        break;
                        
                      case "3":
                        System.out.println(u1.listParticipantsInAllBreakoutRooms());
                        opt2= "0";
                        break;
                        
                      case "4":
                        System.out.println("Enter Participant ID key: ");                
                        opt2 = uin.nextLine();
                        System.out.println(u1.findParticipantBreakoutRoom(opt2));
                        opt2= "0";
                        break;
                          
                      case "5":
                        System.out.println("Enter Participant ID to be added: ");                
                        ID = uin.nextLine();
                        System.out.println("Enter Room Index for Participant: ");                
                        opt2 = uin.nextLine();
                        i=Integer.parseInt(opt2);
                        if(u1.addParticipant(ID,i)){
                            System.out.println("Participant "+ID+" successfully added.\n");
                        }else{
                            System.out.println("Participant "+ID+" not added.\n");
                        }    
                        opt2= "0";
                        break;
                        
                      case "9":
                        opt2= "9";
                        break;
                        
                    }
                }
                opt2= "0";
                opt= "0";
                break;
              case "4"://WORKS - ALL MENU OPTIONS FUNCTIONAL
                  while(opt2!="9"){  //subMenu Loop
                    switch(opt2) { //subMenu Options
                      default:
                        System.out.println("\nBreakoutRoom Methods: ");
                        System.out.println("1.Open a BreakoutRoom");
                        System.out.println("2.Close a Breakoutroom");
                        System.out.println("9.Exit");                
                        opt2 = uin.nextLine();
                        break;
                        
                      case "1":
                        System.out.println("Enter BreakoutRoom index to open: ");                
                        opt2 = uin.nextLine();
                        i=Integer.parseInt(opt2);
                        if(!u1.openBreakoutRoom(i)){
                            System.out.println("BreakoutRoom "+opt2+" cannot be opened.");
                        }else{
                            System.out.println("BreakoutRoom "+opt2+" Open status is: "+u1.openBreakoutRoom(i));
                        }
                        opt2= "0";
                        break;
                        
                      case "2":
                        System.out.println("Enter BreakoutRoom index to close: ");                
                        opt2 = uin.nextLine();
                        i=Integer.parseInt(opt2);
                        if(u1.closeBreakoutRoom(i)){
                            System.out.println("BreakoutRoom "+opt2+" cannot be closed.");
                        }else{
                            System.out.println("BreakoutRoom "+opt2+" Open status is: "+u1.closeBreakoutRoom(i));
                        }
                        opt2= "0";
                        break;
                      case "9":
                        opt2= "9";
                        break;
                    }
                }
                opt2= "0";
                opt= "0";
                break;
              case "9":
                System.out.println("\nClosing...");
                System.exit(0);
                break;
             
                
            } 
        }
     
       
  }
    
}

