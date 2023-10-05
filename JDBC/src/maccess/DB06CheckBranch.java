package maccess;

public class DB06CheckBranch {

	public boolean verify(String br) {
		return switch (br) {
		case "CE":
			yield true;
		case "EEE":
			yield true;
		case "ECE":
			yield true;
		case "SCE":
			yield true;
		case "MECH":
			yield true;
		default:
			yield false;

		};

	}
}
