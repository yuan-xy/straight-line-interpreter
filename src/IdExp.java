

public class IdExp extends Exp {

	private String id;
	
	public IdExp(String id){
		this.id=id;
	}

	@Override
	public void accept(Visitor v) {
		v.visitIdExp(this);
	}

	public String getId() {
		return id;
	}
	
	
	
}
