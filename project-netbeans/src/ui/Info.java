package ui;
// ======= all infomation ===============

public class Info {
	public String start;
	public String mid;
	public String midOrder;
	public String end;
	public int exactLen;
	public int greatLen;
	public int lessLen;
	public String datatype;
	public String reg;
        public int columns;
        public int taFontSize;


	public Info(String start, String mid, String midOrder, String end, int exactLen, int greatLen, int lessLen,
			String reg, String datatype,int columns,int taFontSize) {
		this.start = start;
		this.mid = mid;
		this.midOrder = midOrder;
		this.end = end;
		this.exactLen = exactLen;
		this.greatLen = greatLen;
		this.lessLen = lessLen;
		this.datatype = datatype;
		this.reg = reg;
                this.columns=columns;
                this.taFontSize=taFontSize;
	}

	// =============== isNormalSearchEmpty() ============================================
	public boolean isNormalSearchEmpty(){
		if (start.length()+ mid.length()+midOrder.length()+end.length() > 0)
			return false;
		else
			return true;
	}
	
}
