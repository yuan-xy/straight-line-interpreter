import java.util.Map;


public class ExecVisitor implements Visitor {
	
	private Map<String, Integer> runtime;//符号表及其值
	private int value;//存储表达式的值
	
	public ExecVisitor(Map<String, Integer> runtime){
		this.runtime=runtime;
	}

	public void visitAssignStm(AssignStm stm) {
		stm.getExp().accept(this);
		runtime.put(stm.getId(), value);
	}

	public void visitPrintStm(PrintStm stm) {
		stm.getList().accept(this);
	}

	public void visitCompoundStm(CompoundStm stm) {
		stm.getStm1().accept(this);
		stm.getStm2().accept(this);
	}

	public void visitIdExp(IdExp exp) {
		Integer ret=runtime.get(exp.getId());
		if(ret==null) throw new RuntimeException("变量未赋值："+exp.getId());
		value=ret.intValue();
	}

	public void visitNumExp(NumExp exp) {
		value=exp.getNum();
	}

	public void visitOpExp(OpExp exp) {
		int tmp;
		switch(exp.getOp()){
		case PLUS: exp.getExp1().accept(this);tmp=value; exp.getExp2().accept(this); value=tmp+value;return;
		case MINUS: exp.getExp1().accept(this);tmp=value; exp.getExp2().accept(this); value=tmp-value;return;
		case MULTIPLY: exp.getExp1().accept(this);tmp=value; exp.getExp2().accept(this); value=tmp*value;return;
		case DIVIDE: exp.getExp1().accept(this);tmp=value; exp.getExp2().accept(this); value=tmp/value;return;
		}
		throw new IllegalStateException("未知操作符:"+exp.getOp());
	}

	public void visitEseqExp(EseqExp exp) {
		exp.getStm().accept(this);
		exp.getExp().accept(this);
	}

	public void visitLastExpList(LastExpList lastExpList) {
		lastExpList.getExp().accept(this);
		System.out.println(value);
	}

	public void visitPairExpList(PairExpList pairExpList) {
		pairExpList.getExp().accept(this);
		System.out.println(value);
		pairExpList.getList().accept(this);
	}

}
