

public class CompoundStm extends Stm {
	private Stm stm1;
	private Stm stm2;
	
	public CompoundStm(Stm stm1,Stm stm2){
		this.stm1=stm1;
		this.stm2=stm2;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitCompoundStm(this);
	}

	public Stm getStm1() {
		return stm1;
	}

	public Stm getStm2() {
		return stm2;
	}

	
	
}
