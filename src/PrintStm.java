

public class PrintStm extends Stm {

	private ExpList list;
	
	public PrintStm(ExpList list){
		this.list=list;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitPrintStm(this);
	}

	public ExpList getList() {
		return list;
	}
	
	
	
	
}
