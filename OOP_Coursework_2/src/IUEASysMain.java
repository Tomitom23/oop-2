import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author aaron
 */
public class IUEASysMain {
    public static void main(String args[]){
    
        ArrayList<String> fullNames = new ArrayList<String>();
        ArrayList<String> firstNames = new ArrayList<String>();
        
        String [] courses = {"BIT-1201", "BIT-1202", "BIT-1203", "BIT-1204", "BIT-1205", "BIT-1206"};
        
        int num = courses.length;
        double [] marks = new double[num];
        double [] gpa = new double[num];
        char [] grade = new char[num];
        
        double sum=0, avg=0;
        
        Scanner scan = new Scanner(System.in);
        boolean done=false;
        
        System.out.println("Welcome to IUEA Grading System");
        System.out.println("------------------------------\n");
        System.out.println("Enter 'exit' as the First name to stop adding new Students.\n");
        int i=0;
        while(true){
            System.out.print("Enter the Student "+(i+1)+"'s First name: ");
            String fName=scan.next();
            
            if(fName.toLowerCase().equals("exit")){
                break;
            }else {
                firstNames.add(fName);
                System.out.print("Enter the Student "+(i+1)+"'s Middle name: ");
                String mName=scan.next();
                System.out.print("Enter the Student "+(i+1)+"'s Last name: ");
                String lName=scan.next();
                String stdFullName=fName+" "+mName+" "+lName;
                fullNames.add(stdFullName);
                
                System.out.println();
                
                for (int j=0;j<num;j++){
                    System.out.print("Enter Student "+(i+1)+", "+firstNames.get(i)+"'s "+courses[j]+" marks: ");
                    double test =scan.nextDouble();
                    
                    if(test>=0 && test<=100) {
                        marks[j]=test;
                        sum+=marks[j];
                        double mygpa = Math.round((marks[j]/100)*5*100)/100.0;
                        gpa[j]=mygpa;
//                        System.out.println(gpa[j]);
                    }else {
                        System.out.println("Error! Enter a number between 0 and 100.\n");
                        j--;
                    }
                }
                for (int k=0;k<num;k++){
                    if(gpa[k]>=4.4){
                        grade[k]='A';
                    }else if(gpa[k]>=3.6) {
                        grade[k]='B';
                    }else if(gpa[k]>=2.8) {
                        grade[k]='C';
                    }else if(gpa[k]>=2.0) {
                        grade[k]='D';
                    }else {
                        grade[k]='F';
                    }
                }
                System.out.println("\nCourses\t\tMarks\tGPA\tGRADE");
                for(int m=0;m<num;m++){
                    System.out.println(courses[m]+"\t"+marks[m]+"\t"+gpa[m]+"\t"+grade[m]);
                }
                System.out.println("\n"+firstNames.get(i)+"'s Total: "+sum+"/"+(num*100));
                
                avg=Math.round((sum/num)*100)/100.0;
                double cgpa=Math.round(sum/(num*100)*5*100)/100.0;
                
                System.out.println(firstNames.get(i)+"'s Average: "+avg);
                System.out.println(firstNames.get(i)+"'s CGPA: "+cgpa+"/5.0");
                i++;
                System.out.println();
            }
        }
    }
}
