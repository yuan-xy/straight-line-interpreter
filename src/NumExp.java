

public class NumExp extends Exp {

	private int num;
	
	public NumExp(int num){
		this.num=num;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitNumExp(this);
	}

	public int getNum() {
		return num;
	}


	
}
