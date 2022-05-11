package survey;

public class PlaceVo {
	private int pcode;
	private int place;

	public PlaceVo() {

	}

	public PlaceVo(int pcode, int place) {
		this.pcode = pcode;
		this.place = place;
	}

	public void setpcode(int pcode) {
		this.pcode = pcode;
	}

	public void setplace(int place) {
		this.place = place;
	}

	public int getpcode() {
		return pcode;
	}

	public int getplace() {
		return place;
	}

	public String toString() {
		return "PlaceVo = (" + pcode + ", " + place + " )";
	}
}
