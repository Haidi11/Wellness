package orodja;

import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;

import vao.Dogodek;
import vao.Oseba;

public class StarostneSkupine {
	
	private int do20=0;
	private int st20_30=0;
	private int st30_40=0;
	private int st40_50=0;
	private int st50_65=0;
	private int nad65=0;
	
	public  StarostneSkupine(Dogodek d) {
		for(Oseba o : d.getUdelezenci()) {
			 int starost = Period.between(o.getDatumRojstva().getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), Calendar.getInstance().getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).getYears();
			starost++;
//			 System.out.println(starost);
			 if(starost<=20)
				do20++;
			if(starost>20&&starost<=30)
				st20_30++;
			if(starost>30&&starost<=40)
				st30_40++;
			if(starost>40&&starost<=50)
				st40_50++;
			if(starost>50&&starost<=65)
				st50_65++;
			if(starost>65)
				nad65++;
			
			
		}
		
		
	}

	public int getDo20() {
		return do20;
	}

	public void setDo20(int do20) {
		this.do20 = do20;
	}

	public int getSt20_30() {
		return st20_30;
	}

	public void setSt20_30(int st20_30) {
		this.st20_30 = st20_30;
	}

	public int getSt30_40() {
		return st30_40;
	}

	public void setSt30_40(int st30_40) {
		this.st30_40 = st30_40;
	}

	public int getSt40_50() {
		return st40_50;
	}

	public void setSt40_50(int st40_50) {
		this.st40_50 = st40_50;
	}

	public int getSt50_65() {
		return st50_65;
	}

	public void setSt50_65(int st50_65) {
		this.st50_65 = st50_65;
	}

	public int getNad65() {
		return nad65;
	}

	public void setNad65(int nad65) {
		this.nad65 = nad65;
	}
	
	

}
