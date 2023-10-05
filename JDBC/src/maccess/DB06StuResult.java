package maccess;

public class DB06StuResult {

	public String result(float perc, boolean b) {
		if (b)
			return "Fail";
		else if (perc >= 70 && perc <= 100)
			return "Distincion";
		else if (perc >= 70)
			return "FirstClass";
		else if (perc >= 60)
			return "SecondClass";
		else if (perc >= 50)
			return "ThirdClass";
		else
			return "Pass";
	}

}
