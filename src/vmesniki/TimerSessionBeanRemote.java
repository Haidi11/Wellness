package vmesniki;

import javax.ejb.Remote;

@Remote
public interface TimerSessionBeanRemote {
	public void ustvariTimer(long milliseconds);
}
