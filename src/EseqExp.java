

public class EseqExp extends Exp {

	private Stm stm;
	private Exp exp;
	
	public EseqExp(Stm stm,Exp exp){
		this.stm=stm;
		this.exp=exp;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitEseqExp(this);
	}

	public Stm getStm() {
		return stm;
	}

	public Exp getExp() {
		return exp;
	}


}
