
public interface Visitor {
	public void visitAssignStm(AssignStm stm);
	public void visitPrintStm(PrintStm stm);
	public void visitCompoundStm(CompoundStm stm);
	
	public void visitIdExp(IdExp exp);
	public void visitNumExp(NumExp exp);
	public void visitOpExp(OpExp exp);
	public void visitEseqExp(EseqExp exp);
	
	public void visitLastExpList(LastExpList lastExpList);
	public void visitPairExpList(PairExpList pairExpList);

}
