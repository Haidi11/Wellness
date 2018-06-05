package timer;
   
import vmesniki.TimerSessionBeanRemote;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EJBTimerTest {
   BufferedReader brConsoleReader = null; 
   Properties props;
   InitialContext ctx;
   {
      props = new Properties();
      try {
         props.load(new FileInputStream("jndi.properties"));
      } catch (IOException ex) {
         ex.printStackTrace();
      }
      try {
         ctx = new InitialContext(props);            
      } catch (NamingException ex) {
         ex.printStackTrace();
      }
      brConsoleReader = 
      new BufferedReader(new InputStreamReader(System.in));
   }
   
   public static void main(String[] args) {

	   EJBTimerTest ejbTester = new  EJBTimerTest();

      ejbTester.testTimerService();
   }
   
   private void showGUI(){
      System.out.println("**********************");
      System.out.println("Welcome to Book Store");
      System.out.println("**********************");
      System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
   }
   
   private void testTimerService(){
      try {
         TimerSessionBeanRemote timerServiceBean = (TimerSessionBeanRemote)ctx.lookup("TimerSessionBean/remote");

         System.out.println("["+(new Date()).toString()+ "]" + "timer created.");
         timerServiceBean.ustvariTimer(2000);            

      } catch (NamingException ex) {
         ex.printStackTrace();
      }
   }
}
