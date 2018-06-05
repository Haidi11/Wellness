package timer;


import java.sql.Date;

import javax.ejb.Schedule;
import javax.ejb.Stateless;


@Stateless
public class TimerTest {
	
	@Schedule(dayOfWeek="Tue", hour="0")
	public void cleanupWeekData() {
		
	}
	
    @Schedule(second="*/3", hour="*")
    public void automaticTimeout() {
        this.setLastAutomaticTimeout(new Date(0));
        System.out.println("Automatic timeout occured");
    }

	private void setLastAutomaticTimeout(Date date) {
		// TODO Auto-generated method stub
		
	}

}
