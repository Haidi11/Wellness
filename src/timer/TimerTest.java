package timer;

import java.sql.Date;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

import vmesniki.TimerSessionBeanRemote;

@Stateless
public class TimerTest implements TimerSessionBeanRemote {

	@Resource
	private SessionContext context;

	@Schedule(dayOfWeek = "Tue", hour = "0")
	public void cleanupWeekData() {

	}

	@Schedule(second = "*/3", hour = "*")
	public void automaticTimeout() {
		this.setLastAutomaticTimeout(new Date(0));
		System.out.println("Automatic timeout occured");
	}

	private void setLastAutomaticTimeout(Date date) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTimer(long duration) {
		context.getTimerService().createTimer(duration, "Hello World!");
	}

	@Timeout
	public void timeOutHandler(Timer timer) {
		System.out.println("timeoutHandler : " + timer.getInfo());
		timer.cancel();
	}
}
