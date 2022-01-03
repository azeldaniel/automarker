package out.Isaiah_Norcisse_657783_assignsubmission_file_;// Student ID : 816016804
// COMP 2603 A1
import java.lang.String;
import java.util.Scanner;
import java.io.File;  
import java.io.FileNotFoundException;

public class VirtualMeetingSystem
{
    private String filename;
    private String name;
    private String code;
    protected VirtualRoom vr;
    private String[] data;
    private int numOfData;
    /**
     * Constructor for objects of class VirtualMeetingSystem
     */
    public VirtualMeetingSystem()
    {
        this.filename="";
        this.name="";
        this.code="";
        this.numOfData=0;
        this.data= new String[100];
        
    }
    
    public void setNumOfData(int i){
        this.numOfData=i;
    }
    
    public void loadParticipantData(String filename)
    {  int j=0;
        
       try{
          File file1 = new File(filename);
          Scanner i = new Scanner(file1);
          
          while (i.hasNextLine()) {
            data[j]=i.nextLine();
            //System.out.println(data[j]);
            j++;
          }
          i.close();
          setNumOfData(j);
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
       }
    
    
    public void createVirtualRoom(String name)
    {
        vr = new VirtualRoom(name);
 
    }
    
    public void allocateParticipants(String code)
    {
        if(code.equals("C5")){
            for(int j=0;j<numOfData;j++)
            {
                for(int i=0;i<this.vr.breakoutRooms.length;i++)
                {
                  vr.addParticipantToBreakoutRoom(data[j],i);
        
                }
            }
        }
        
        else if(code.equals("RR")){
            
           for(int i=0;i<this.vr.breakoutRooms.length;i++) {
               for(int j=0;j<numOfData;j++) 
                {
                  vr.addParticipantToBreakoutRoom(data[j],i);
                }
            }
        }
 
    }
    
    public boolean addParticipant (String participantID, int roomNumber)
    { 
        return vr.addParticipantToBreakoutRoom(participantID, roomNumber);
        
    }
    
    public String listParticipants(int roomNumber) 
    {
        
        if(this.vr.findBreakoutRoom(roomNumber)==null)
            return null;
        else 
        {
           return vr.listParticipantsInBreakoutRoom(roomNumber);
        }
        
    }
    
    public boolean openBreakoutRoom(int roomNumber) 
    {
           if(this.vr.findBreakoutRoom(roomNumber)!=null)
            return vr.openBreakoutRoom(roomNumber);
           else 
           return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
            if(this.vr.findBreakoutRoom(roomNumber)!=null)
            return vr.closeBreakoutRoom(roomNumber);
           else 
           return false;

    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        return this.vr.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms( )
    {
        return this.vr.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRoom()
    {
        String details="";
        for(int i=0;i<this.vr.breakoutRooms.length;i++) {
               details+=vr.listParticipantsInBreakoutRoom(i);
            }
          return details;
    }
}
