import java.util.HashMap;
import java.util.Map;


public class Interpreter {
	
	public static void run(Stm s){
		Map<String, Integer> runtime=new HashMap<String, Integer>();
		ExecVisitor v = new ExecVisitor(runtime);
		s.accept(v);
	}
	
	public static void main(String[] args){
		Stm prog =
			new CompoundStm(new AssignStm("a",
			                     new OpExp(new NumExp(5),
			                    		 Binop.PLUS, new NumExp(3))),
			new CompoundStm(new AssignStm("b",
			   new EseqExp(new PrintStm(new PairExpList(new IdExp("a"),
			             new LastExpList(new OpExp(new IdExp("a"),
			                           Binop.MINUS,new NumExp(1))))),

			        new OpExp(new NumExp(10), Binop.MULTIPLY,
			                  new IdExp("a")))),
			new PrintStm(new LastExpList(new IdExp("b")))));
		run(prog);
		System.out.println("run again");
		Parser parser=new Parser();
		Stm stm=parser.parse("a=5+3;b=(print(a,a-1),10*a);print(b)");
		run(stm);
		stm.accept(new PrettyPrintVisitor());
	}

}
