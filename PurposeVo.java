package survey;

public class PurposeVo {
	private int ppcode;
	private int infonumber;
	private int placecode;
	private int purpose;

	public PurposeVo() {

	}

	public PurposeVo(int ppcode, int infonumber, int placecode, int purpose) {
		this.ppcode = ppcode;
		this.infonumber = infonumber;
		this.placecode = placecode;
		this.purpose = purpose;
	}

	public void setppcode(int ppcode) {
		this.ppcode = ppcode;
	}

	public void setinfonumber(int infonumber) {
		this.infonumber = infonumber;
	}

	public void setplacecode(int placecode) {
		this.placecode = placecode;
	}

	public void setpurpose(int purpose) {
		this.purpose = purpose;
	}

	public int getppcode() {
		return ppcode;
	}

	public int getinfonumber() {
		return infonumber;
	}

	public int getplacecode() {
		return placecode;
	}

	public int getpurpose() {
		return purpose;
	}

}