
public class LastExpList extends ExpList {

	private Exp exp;

	public LastExpList(Exp exp){
		this.exp=exp;
	}

	public Exp getExp() {
		return exp;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitLastExpList(this);
	}
	
}
