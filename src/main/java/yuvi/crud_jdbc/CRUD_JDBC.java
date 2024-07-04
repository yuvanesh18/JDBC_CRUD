package yuvi.crud_jdbc;
import java.sql.*;
import java.util.Scanner;



public class CRUD_JDBC {

    public static void main(String[] args) throws SQLException {
        Scanner sc= new Scanner(System.in);
       
   
        Crud_operation c = new Crud_operation();
        c.connect();
        
        while(true)
        {
            System.out.println("1. addstudent\n 2. removestudent\n 3. getstudent\n 4. display all\n 5. exit");
            int choose = sc.nextInt();
            
            if(choose == 1)
            {
                System.out.println("Enter Id:");
                int id =sc.nextInt();
                sc.nextLine();
                
                System.out.println("Enter FirstName:");
                String fn=sc.nextLine();
                
                System.out.println("Enter LastName:");
                String ln=sc.nextLine();
                
                System.out.println("Enter Mail id:");
                String mail=sc.nextLine();
                
                System.out.println("Enter City:");
                String city=sc.nextLine();

                c.addstudent(id,fn,ln,mail,city);
            }
            else if(choose == 2)
            {
                System.out.print("Enter Id:");
                int id =sc.nextInt();
                c.removestudent(id);
            }
            else if(choose == 3)
            {
                System.out.print("Enter Id:");
                int id =sc.nextInt();
                c.getstudent(id);
            }
            else if(choose == 4)
            {
                c.display();
            }
            else if(choose == 5)
            {
                break;
            }
            
        }      
//        c.updatestudent(id);
    }
}

