
public class Parser {
	String s;
	int index;
	
	public Stm parse(String str){
		s=str.replaceAll(" ", "");
		index=0;
		return parseStm();
	}

	private Stm parseStm() {
		Stm stm1;
		if(s.length()-index>5&&"print".equals(s.substring(index, index+5))){
			index+=5;
			stm1=parsePrintStm();
		}else{
			stm1=parseAssignStm();
		}
		if(s.length()>index&&s.charAt(index)==';'){
			index++;
			Stm stm2=parseStm();
			return new CompoundStm(stm1,stm2);
		}else{
			return stm1;
		}
	}

	private AssignStm parseAssignStm() {
		int i=s.indexOf("=", index);
		String id=s.substring(index, i);
		index=i+1;
		Exp exp=parseExp();
		return new AssignStm(id,exp);
	}

	private PrintStm parsePrintStm() {
		match("(");
		ExpList list=parseExpList();
		match(")");
		return new PrintStm(list);
	}
	
	private Exp parseExp() {
		Exp exp;
		if(s.charAt(index)=='('){
			index++;
			Stm stm=parseStm();
			match(",");
			Exp last=parseExp();
			match(")");
			exp=new EseqExp(stm,last);
		}else if(s.charAt(index)>='0'&&s.charAt(index)<='9'){
			exp=parseNumExp();
		}else if(Character.isJavaLetter(s.charAt(index))){
			exp=parseIdExp();
		}else{
			throw new IllegalStateException("无效的表达式："+s.substring(index));
		}
		if(s.length()>index){
			char c=s.charAt(index);
			index++;
			Exp exp2;
			switch(c){
			case '+':exp2=parseExp();return new OpExp(exp,Binop.PLUS,exp2);
			case '-':exp2=parseExp();return new OpExp(exp,Binop.MINUS,exp2);
			case '*':exp2=parseExp();return new OpExp(exp,Binop.MULTIPLY,exp2);
			case '/':exp2=parseExp();return new OpExp(exp,Binop.DIVIDE,exp2);
			}
			index--;
		}
		return exp;
	}

	private IdExp parseIdExp() {
		int i=index;
		while(Character.isJavaLetter(s.charAt(i))) i++;
		IdExp ret=new IdExp(s.substring(index, i));
		index=i;
		return ret;
	}

	private NumExp parseNumExp() {
		int i=index;
		while(s.charAt(i)>='0'&&s.charAt(i)<='9') i++;
		Integer integer=Integer.parseInt(s.substring(index,i));
		NumExp ret = new NumExp(integer);
		index=i;
		return ret;
	}

	private ExpList parseExpList() {
		Exp exp=parseExp();
		if(s.length()>index&&s.charAt(index)==','){
			index++;
			ExpList el=parseExpList();
			return new PairExpList(exp,el);
		}else{
			return new LastExpList(exp);
		}
	}

	private void match(String string) {
		if(s.length()>=index+string.length()){
			if(s.substring(index,index+string.length()).equals(string)){
				index+=string.length();
				return;
			}
		}
		throw new IllegalStateException("expect:"+string+",real:"+s.substring(index, s.length()));
	}
	
	

}
