package out.Abigail_Goorachan_657690_assignsubmission_file_;
/**
 * 816007500
 */
import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class VirtualRunner
{
   public static void main(String[] args) throws FileNotFoundException{
       
       VirtualMeetingSystem VMS = new VirtualMeetingSystem();
       
       VMS.loadParticipantData("participant.dat");
       
   }
}
