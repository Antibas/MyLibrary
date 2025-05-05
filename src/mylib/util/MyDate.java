package mylib.util;

public class MyDate {
	private int day, month, date;

	public MyDate(int day, int month, int date) {
		this.day = day;
		this.month = month;
		this.date = date;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getDate() {
		return date;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDate(int date) {
		this.date = date;
	}
	
}
