

public class AssignStm extends Stm {
	
	private String id;
	private Exp exp;
	
	public AssignStm(String id,Exp exp){
		this.id=id;
		this.exp=exp;
	}

	@Override
	public void accept(Visitor v) {
		v.visitAssignStm(this);
	}

	public String getId() {
		return id;
	}

	public Exp getExp() {
		return exp;
	}
	
	

}
