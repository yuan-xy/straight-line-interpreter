

public class OpExp extends Exp {
	private Exp exp1;
	private Exp exp2;
	private Binop op;
	
	public OpExp(Exp exp1,Binop op,Exp exp2){
		this.exp1=exp1;
		this.exp2=exp2;
		this.op=op;
	}

	@Override
	public void accept(Visitor v) {
		v.visitOpExp(this);
	}

	public Exp getExp1() {
		return exp1;
	}

	public Exp getExp2() {
		return exp2;
	}

	public Binop getOp() {
		return op;
	}
	
	

}
