package out.Casidy_Mohamed_657801_assignsubmission_file_;//816013169

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
    private String[] data;
    private VirtualRoom vr;
   
    private int x;
    private int y;
    private int count;
    private int start;
    private String list;
    private boolean state;
    
    public VirtualMeetingSystem()
    {
        data=new String[50];
        x=0;
        y=0;
        count=0;
        list="";
        state=false;
    }
    
    public void loadParticipantData(String filename)
    {
       String z=null;
       x=0;
       
       for(x=0;x<50;x++)
       {
           data[x]="null";
       }
     
       File f=new File(filename);
       x=0;
       //reading in data from file
       try
       {
           Scanner input= new Scanner(f);
           while(input.hasNextLine())
           {
              z=input.nextLine();
              data[x]=z;
              x++;
           }
           input.close();
           System.out.println("Data has been loaded from the file!");
       }
       
       catch(FileNotFoundException e)
       {
           e.printStackTrace();
           System.out.println("File not found, sorry!");
       }
    }
    
    public void createVirtualRoom(String name)
    {
        this.vr=new VirtualRoom(name);
        System.out.println("The virtual room " +name+ " has been created");

    }
   
    
    public void allocateParticipants(String code)
    {
        x=0;
        y=0;
        count=0;
        vr.createBreakoutRooms();
       
        if(code.equals("C5"))
        {
            while(x<50 && data[x]!=null )
            {
                y=0;
                while(y<vr.getBreakoutRoomLimit())
                {
                    while (count <5)
                    {
                       System.out.println("Adding " + data[x] + "  to breakout Room  " + (y+1));
                       vr.addParticipantToBreakoutRoom(data[x],(y+1));
                       count++;
                       x++;
                    }
                    y++;
                    count=0;
                }
            }
        }
       
        if(code.equals("RR"))
        {  
           x=0;
            while( x<50 && data[x]!="null")
           {
               while(y<vr.getBreakoutRoomLimit())
               {
                   System.out.println("Adding " + data[x] + "  to breakout Room  " + (y+1));
                   vr.addParticipantToBreakoutRoom(data[x],y+1);
                   x++;
                   y++;
               }
               y=0;
           }
        }   
     }
     
     public boolean addParticipant(String participantID,int roomNumber)
     {
        if (vr.findBreakoutRoom(roomNumber) == null)
        {
            System.out.println("Sorry, this room does not exist");
            return false;
        }
        else
        {
            state = vr.addParticipantToBreakoutRoom(participantID, roomNumber);
            if(state == false)
                System.out.println("Sorry, the ID is not valid");
            else
                return true;
        }
        return false;
     }
    
    public String listParticipants(int roomNumber)
    {
        if(vr.findBreakoutRoom(roomNumber)!= null)
            return vr.listParticipantsInBreakoutRoom(roomNumber);
        
        return null;
    }
     
     public boolean openBreakoutRoom(int roomNumber)
     {
         if(vr.findBreakoutRoom(roomNumber)!= null)
         {
             return vr.openBreakoutRoom(roomNumber);
         }
         return false;
     }
     
     public boolean closeBreakoutRoom(int roomNumber)
     {
         if(vr.findBreakoutRoom(roomNumber)!=null)
         {
             return vr.closeBreakoutRoom(roomNumber);
         }
         return false;
     }
     
     public String findParticipantBreakoutRoom(String participantID)
     {
            return vr.findParticipantBreakoutRoom(participantID);
     }
     
     public String listAllBreakoutRooms()
     {
        return vr.listBreakoutRooms();
     }
     
     public String listParticipantsInAllBreakoutRooms()
     {
         y=1;
         for(x=0;x<vr.getBreakoutRoomLimit();x++)
         {
             list= list+ vr.listParticipantsInBreakoutRoom(y) + "\n";
             y++;
         }
         return list;
     }
}
    
    
    
    
    
    
    
    
    