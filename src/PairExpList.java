
public class PairExpList extends ExpList {

	private Exp exp;
	private ExpList list;
	
	public PairExpList(Exp exp,ExpList list){
		this.exp=exp;
		this.list=list;
	}

	public Exp getExp() {
		return exp;
	}

	public ExpList getList() {
		return list;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitPairExpList(this);
	}
	
	
		
}
