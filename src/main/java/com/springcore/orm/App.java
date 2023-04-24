package com.springcore.orm;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.orm.dao.StudentDao;
import com.springcore.orm.entities.Student;




 
public class App 
{
    public static void main( String[] args )
    {
     ApplicationContext ctx =   new ClassPathXmlApplicationContext("springOrms.xml");
          StudentDao studentDao = ctx.getBean("studentDao", StudentDao.class);
          
			/*
			 * Student student = new Student(234, "Mayur" , "saharanpur"); int r =
			 * studentDao.insert(student); System.out.println("done " +r);
			 */
          
          Scanner sc = new Scanner(System.in); 
          boolean go =true;
          while(go)
          {
          System.out.println("press 1 for add new student");
          System.out.println("press 2 for display all students");
          System.out.println("press 3 for get all detail of single student");
          System.out.println("press 4 for delete students");
          System.out.println("press 5 for update student");
          System.out.println("press 6 for exit");
          
          try {
        	  int input = Integer.parseInt(sc.next());
        	  
        	  switch(input)
        	  {
        	  case 1:
        		  System.out.println("Enter user id:");
        		  int id = sc.nextInt();
        		  
        		  System.out.println("Enter your user name:");
        		  String userName = sc.next();
        		  
        		  System.out.println("Enter your city:");
        		  String city = sc.next();
        		  
        		  Student s = new Student();
        		  s.setId(id); s.setName(userName);s.setCity(city);
        		  int r = studentDao.insert(s);
        		  System.out.println(r+ " student added");
        		  System.out.println("*******************************");
        		  System.out.println();
        		  
        		  
        		  break;
        		  
        	  case 2:
        		  List<Student>allStudents = studentDao.getAllStudents();
        		  
        		  for(Student st : allStudents)
        		  {
        			  System.out.println("Name: " + st.getName());
        			  System.out.println("Id: "  +st.getId());
        			  System.out.println("City:" + st.getCity());
        			  System.out.println("__________________________");
        		  }
        		  System.out.println("******************************");
        		  
        		  break;
        		  
        	  case 3:
        		  System.out.println("Enter user id:");
        		  int id2 = sc.nextInt();
        		  Student st1 = studentDao.getStudent(id2);
        		  System.out.println("Name: " + st1.getName());
    			  System.out.println("Id: "  +st1.getId());
    			  System.out.println("City:" + st1.getCity());
    			  System.out.println("__________________________");
        		  
    			  System.out.println("******************************");
    			  
        		  break;
        		  
        	  case 4:
        		  System.out.println("Enter user id:");
        		  int id3 = sc.nextInt();
        		  studentDao.deleteStudent(id3);
        		  System.out.println(id3 +" student data has been deleted");
    			  System.out.println("******************************");

        		  
        		  
        		  break;
        		  
        	  case 5:
                    
        		  
        		  
        		  break;
        		  
        	  case 6:
        		  go = false; // to break the while loop
        		  break;
        		  
        	  }
        	  
        	  
          }catch(Exception e)
          {
        	  System.out.println("Invalid Input try with another one !!");
        	  System.out.println(e.getMessage());
          }
          
    
          }
          
          System.out.println("Thankyou for using this application");
          System.out.println("see you soon!!");
}
    
}
