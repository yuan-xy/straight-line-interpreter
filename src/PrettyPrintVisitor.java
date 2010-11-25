import static java.lang.System.out;

public class PrettyPrintVisitor implements Visitor {
	

	public void visitAssignStm(AssignStm stm) {
		indent();
		out.format("AssignStm: %s = \n", stm.getId());
		indentation++;
		stm.getExp().accept(this);
		indentation--;
	}

	public void visitPrintStm(PrintStm stm) {
		indent();
		out.print("PrintStm: \n");
		indentation++;
		stm.getList().accept(this);
		indentation--;
	}

	public void visitCompoundStm(CompoundStm stm) {
		indent();
		out.print("CompoundStm: \n");
		indentation++;
		stm.getStm1().accept(this);
		stm.getStm2().accept(this);
		indentation--;
	}

	public void visitIdExp(IdExp exp) {
		indent();
		out.format("\"%s\"\n", exp.getId());
	}

	public void visitNumExp(NumExp exp) {
		indent();
		out.format("%d\n", exp.getNum());
	}

	public void visitOpExp(OpExp exp) {
		indent();
		out.print("OpExp:\n");
		indentation++;
		exp.getExp1().accept(this);
		indent();
		out.println(exp.getOp());
		exp.getExp2().accept(this);
		indentation--;
	}

	public void visitEseqExp(EseqExp exp) {
		indent();
		out.print("EseqExp:\n");
		indentation++;
		exp.getStm().accept(this);
		exp.getExp().accept(this);
		indentation--;
	}

	public void visitLastExpList(LastExpList lastExpList) {
		indent();
		out.print("lastExpList:\n");
		indentation++;
		lastExpList.getExp().accept(this);
		indentation--;
	}

	public void visitPairExpList(PairExpList pairExpList) {
		indent();
		out.print("pairExpList:\n");
		indentation++;
		pairExpList.getExp().accept(this);
		pairExpList.getList().accept(this);
		indentation--;
	}
	
    private static final String [] spaces = {
        "",
        "  ",
        "    ",
        "      ",
        "        ",
        "          ",
        "            ",
        "              ",
        "                ",
        "                  ",
        "                    "
    };
    
    private int indentation=0;
    
    private void indent() {
        int indentation = this.indentation;
        if (indentation < 0)
            return;
        final int maxIndex = spaces.length - 1;

        while (indentation > maxIndex) {
            out.print(spaces[maxIndex]);
            indentation -= maxIndex;
        }
        out.print(spaces[indentation]);
    }
    

}
