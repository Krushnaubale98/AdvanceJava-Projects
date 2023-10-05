package maccess;

public class DB06GenBrCode {

	public String generate(String brCode) {

		return switch (brCode) {
		case "01":
			yield "CE";
		case "02":
			yield "EEE";
		case "03":
			yield "ECE";
		case "04":
			yield "SCE";
		case "05":
			yield "MECH";
		default:
			yield null;
		};

	}

}
