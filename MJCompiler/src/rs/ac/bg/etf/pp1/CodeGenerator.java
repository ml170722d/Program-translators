package rs.ac.bg.etf.pp1;

import java.util.Stack;

import rs.ac.bg.etf.pp1.CustomVisitor.DesignatorVisitor;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private int pcMain = Code.mainPc;
//	private int conditionTernatyPc;
//	private int endTernaryPc;

	private Stack<Integer> jccAdr = new Stack<Integer>();
	private Stack<Integer> jmpAdr = new Stack<Integer>();

	private Stack<Integer> opStack = new Stack<Integer>();

	public int getPcMain() {
		return pcMain;
	}

	public CodeGenerator() {
	}

	/*
	 * Method ---------------------------------------- START
	 */
	@Override
	public void visit(SomeReturnType methodtypeAndName) {
		if ("main".equalsIgnoreCase(methodtypeAndName.obj.getName())) {
			pcMain = Code.pc;
		}

		methodtypeAndName.obj.setAdr(Code.pc);

		// Count all vars and params in function/method declaration
		CustomVisitor varVisitor = new CustomVisitor.VarCounter();
		methodtypeAndName.traverseTopDown(varVisitor);

		CustomVisitor paramVisitor = new CustomVisitor.ParamCounter();
		methodtypeAndName.traverseTopDown(paramVisitor);

		// Generate function/method entry
		Code.put(Code.enter);
		Code.put(paramVisitor.getCount());
		Code.put(paramVisitor.getCount() + varVisitor.getCount());
	}

	@Override
	public void visit(NoReturnType methodtypeAndName) {
		if ("main".equalsIgnoreCase(methodtypeAndName.getMethodName().getName())) {
			pcMain = Code.pc;
		}

		methodtypeAndName.obj.setAdr(Code.pc);

		// Count all vars and params in function/method declaration
		CustomVisitor varVisitor = new CustomVisitor.VarCounter();
		methodtypeAndName.getParent().traverseTopDown(varVisitor);

		CustomVisitor paramVisitor = new CustomVisitor.ParamCounter();
		methodtypeAndName.getParent().traverseTopDown(paramVisitor);

		// Generate function/method entry
		Code.put(Code.enter);
		Code.put(paramVisitor.getCount());
		Code.put(paramVisitor.getCount() + varVisitor.getCount());
	}

	@Override
	public void visit(SingleMethodDecl method) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	/*
	 * Method ---------------------------------------- END
	 */

	/*
	 * Statement ---------------------------------------- START
	 */
	@Override
	public void visit(PrintStatement print) {

		if (print.getExpr().obj.getType().getKind() != Struct.Array) {
			if (print.getExpr().obj.getType() == ExtendedTab.intType
					|| print.getExpr().obj.getType() == ExtendedTab.boolType) {
				Code.loadConst(5);
				Code.put(Code.print);
			} else {
				Code.loadConst(1);
				Code.put(Code.bprint);
			}
		} else {
			if (print.getExpr().obj.getType().getElemType() == ExtendedTab.intType
					|| print.getExpr().obj.getType().getElemType() == ExtendedTab.boolType) {
				Code.loadConst(5);
				Code.put(Code.print);
			} else {
				Code.loadConst(1);
				Code.put(Code.bprint);
			}
		}
	}

	@Override
	public void visit(ReadStatement read) {

		if (read.getDesignator().obj.getType() == ExtendedTab.charType
				|| read.getDesignator().obj.getType().getElemType() == ExtendedTab.charType) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}

		if (read.getDesignator().obj.getType().getKind() != Struct.Array) {
			Code.store(read.getDesignator().obj);
		} else {
			if (read.getDesignator().obj.getType().getElemType() == ExtendedTab.charType) {
				Code.put(Code.bastore);
//				Code.put(Code.bread);
//				Code.put(Code.bread);
			} else {
				Code.put(Code.astore);
			}
		}
	}
	/*
	 * Statement ---------------------------------------- END
	 */

	/*
	 * Factor ---------------------------------------- START
	 */
	@Override
	public void visit(FactorNumber factor) {
		Code.load(factor.obj);
	}

	@Override
	public void visit(FactorCharacter factor) {
		Code.load(factor.obj);
	}

	@Override
	public void visit(FactorBoolean factor) {
		Code.load(factor.obj);
	}

	@Override
	public void visit(FactorNewType factor) {
		Code.put(Code.newarray);

		if (factor.obj.getType() == ExtendedTab.charType) {
			Code.put(0);
		} else {
			Code.put(1);
		}
	}

	@Override
	public void visit(FactorDesignator factor) {
		DesignatorVisitor v = new CustomVisitor.DesignatorVisitor();
		factor.getDesignator().traverseTopDown(v);

		if (v.hasBrackets()) {
			if (factor.getDesignator().obj.getType().getElemType() == ExtendedTab.charType) {
				Code.put(Code.baload);
			} else {
				Code.put(Code.aload);
			}
			return;
		}

		Code.load(factor.obj);
	}
	/*
	 * Factor ---------------------------------------- END
	 */

	/*
	 * Designator ---------------------------------------- START
	 */
	@Override
	public void visit(IncrementDesig inc) {
		Code.load(inc.obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(inc.obj);
	}

	@Override
	public void visit(DecrementDesig dec) {
		Code.load(dec.obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(dec.obj);
	}

	@Override
	public void visit(SingleDsig assign) {

//		SingleDesigVisitor v = new CustomVisitor.SingleDesigVisitor();
//		assign.getParent().traverseTopDown(v);
//		
//		if (v.shouldLoad()) {
//			Code.load(assign.obj);
//		}
	}

	@Override
	public void visit(AssignExpr assign) {

		DesignatorVisitor v = new CustomVisitor.DesignatorVisitor();
		assign.getDesignator().traverseTopDown(v);

		if (v.hasBrackets()) {
			if (assign.getDesignator().obj.getType().getElemType() == ExtendedTab.charType) {
				Code.put(Code.bastore);
			} else {
				Code.put(Code.astore);
			}
			return;
		}

		Code.store(assign.getDesignator().obj);
	}

	@Override
	public void visit(DesigLst arr) {
		// index
		Code.load(arr.obj);

		// index niz
		swap();

		// niz index
//		if (arr.obj.getType().getKind() == Struct.Array) {
//			if (arr.obj.getType().getElemType() == ExtendedTab.charType) {
//				Code.put(Code.baload);
//			} else {
//				Code.put(Code.aload);
//			}
//		}
	}
	/*
	 * Designator ---------------------------------------- END
	 */

	/*
	 * Expr ---------------------------------------- START
	 */
	@Override
	public void visit(TermList list) {
		Code.put(opStack.pop());
	}

	@Override
	public void visit(ReverseValue val) {
		Code.put(Code.neg);
	}

	@Override
	public void visit(ConditionTernary val) {
		Code.loadConst(1);
		Code.put(Code.jcc + Code.ne);
//		conditionTernatyPc = Code.pc;
		jccAdr.push(Code.pc);

		Code.put2(0);
	}

	@Override
	public void visit(FalseBranch branch) {
//		Code.fixup(conditionTernatyPc);
		Code.fixup(jccAdr.pop());
	}

	@Override
	public void visit(TrueBranch branch) {
		Code.put(Code.jmp);
//		endTernaryPc = Code.pc;
		jmpAdr.push(Code.pc);
		Code.put2(0);
	}

	@Override
	public void visit(SimpleTernaryExpr ternary) {
//		Code.fixup(endTernaryPc);
		Code.fixup(jmpAdr.pop());
	}
	/*
	 * Expr ---------------------------------------- END
	 */

	/*
	 * Term ---------------------------------------- START
	 */
	@Override
	public void visit(FactorList factorList) {
		Code.put(opStack.pop());
	}
	/*
	 * Term ---------------------------------------- END
	 */

	/*
	 * Operations ---------------------------------------- START Addop Mulop
	 */
	@Override
	public void visit(Addop add) {
		opStack.push(Code.add);
	}

	@Override
	public void visit(Subop add) {
		opStack.push(Code.sub);
	}

	@Override
	public void visit(Mulop add) {
		opStack.push(Code.mul);
	}

	@Override
	public void visit(Divop add) {
		opStack.push(Code.div);
	}

	@Override
	public void visit(Modop add) {
		opStack.push(Code.rem);
	}

	/*
	 * Operations ---------------------------------------- END
	 */

	/*
	 * ConstDecl ---------------------------------------- START
	 */
	@Override
	public void visit(ConstAssign cst) {
		Code.put(Code.getstatic);
		Code.put2(cst.obj.getAdr());
	}
	/*
	 * ConstDecl ---------------------------------------- END
	 */

	/*
	 * placeholder ---------------------------------------- START
	 */
	@Override
	public void visit() {
	}
	/*
	 * placeholder ---------------------------------------- END
	 */

	private void swap() {
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
	}
}
