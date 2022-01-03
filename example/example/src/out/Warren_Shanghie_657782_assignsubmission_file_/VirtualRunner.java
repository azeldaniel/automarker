package out.Warren_Shanghie_657782_assignsubmission_file_;import java.util.Arrays;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * Write a description of class Participant here.
 *
 * @author (Warren Shanghie - 816020039)
 * @version (8/2/2021)
 */
public class VirtualRunner
{
  public static void main(String[] args){
      VirtualMeetingSystem virtualSpace = new VirtualMeetingSystem();
      //1.
      virtualSpace.loadParticipantData("participant.dat");
      //2.
      virtualSpace.createVirtualRoom("WorkShop");
      //3.
      virtualSpace.allocateParticipants("C5");
      //4
      System.out.println("Participant with ID 11111111 was added to breakoutRoom 1: " +virtualSpace.addParticipants("11111111",1));
      //5
      System.out.println("All participants in Workshop2: " +virtualSpace.listParticipants(2)); 
      //6 and 7 not sure how to implement
      
      
      //8
      System.out.println("Participant with ID 24721757 is in: " +virtualSpace.findParticipantBreakoutRoom("24721757"));
      //9
      System.out.println(virtualSpace.listAllBreakoutRooms());
      //10
      System.out.println(virtualSpace.listParticipantsInAllBreakoutRooms());
      
      
    }
}
