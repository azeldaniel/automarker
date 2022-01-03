package out.Khaalis_Delas_657745_assignsubmission_file_;
/**
 * Write a description of class ReadFile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//Khaalis De Las- 8160071114
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//method for loadParticipantData
public class ReadFile //method and class info gathered from w3schools.com
{
   public static void main(String [] args){
       int count=0;
    try {
        File myInput= new File ("participant.txt");
        Scanner myReader= new Scanner(myInput);
        while(myReader.hasNextLine()){
        String data= myReader.nextLine();
        count++; 
    }
          //array of IDs
        String [] Parray= new String [count];
        Scanner myReader2= new Scanner(myInput);
        for(int i=0; i<count; i++){
            Parray[i]= myReader2.next();
        }
        
        
    myReader.close();
    
    }
    catch (FileNotFoundException e){
    System.out.println("Error opening file");
    e.printStackTrace();
}
    
} 
    
}
