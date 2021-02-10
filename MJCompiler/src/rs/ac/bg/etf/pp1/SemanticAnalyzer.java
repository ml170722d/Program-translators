package rs.ac.bg.etf.pp1;

import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	private boolean errorDetected = false;
	private boolean semanticError = false;
	private boolean mainDetected = false;

	private int globVars;

	private Struct currType = Tab.noType;
	private Obj currScope = ExtendedTab.noObj;

	private int adr;
	private Stack<String> currOp = new Stack<String>();

	private Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
//		errorDetected = true;
		semanticError = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" on line ").append(line);
		log.error(msg.toString());
	}

	public void report_warn(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" on line ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" on line ").append(line);
		log.info(msg.toString());
	}

	public boolean getSemanticError() {
		return semanticError;
	}

	public boolean getMainDetected() {
		return mainDetected;
	}

	public int getNumOfGlobVars() {
		return globVars;
	}

	/*
	 * Program ---------------------------------------- START
	 */
	public void visit(ProgramName progName) {
//		System.out.println("ProgramName");
		if (errorDetected)
			return;

		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(Program program) {
//		System.out.println("Program");
		if (!mainDetected) {
			report_error("Main function wasn't detected", null);
		}

		if (errorDetected)
			return;

		globVars = ExtendedTab.currentScope().getnVars();
		Tab.chainLocalSymbols(program.getProgramName().obj);
		Tab.closeScope();
	}
	/*
	 * Program ---------------------------------------- END
	 */

	/*
	 * Type ---------------------------------------- START
	 */
	public void visit(Type type) {
//		System.out.println("Type");
		if (errorDetected)
			return;

		Obj typeByName = Tab.find(type.getTypeName());

		if (typeByName == Tab.noObj) {
			report_error("Undeclared type " + type.getTypeName(), type);
			type.struct = Tab.noType;
			return;
		}

		if (Obj.Type != typeByName.getKind()) {
			report_error("Type " + type.getTypeName() + " is not a type", type);
			type.struct = Tab.noType;
			return;
		}

		type.struct = typeByName.getType();
		currType = typeByName.getType();
	}
	/*
	 * Type ---------------------------------------- END
	 */

	/*
	 * ConstDecl ---------------------------------------- START
	 */
	public void visit(NumConst val) {
//		System.out.println("NumConst");
		if (errorDetected)
			return;

		val.struct = ExtendedTab.intType;
		this.adr = val.getValue();
	}

	public void visit(CharConst val) {
//		System.out.println("CharConst");
		if (errorDetected)
			return;

		val.struct = ExtendedTab.charType;
		this.adr = val.getValue();
	}

	public void visit(BoolConst val) {
//		System.out.println("BoolConst");
		if (errorDetected)
			return;

		int value;
		switch (val.getValue()) {
		case "true":
			value = 1;
			break;
		case "false":
			value = 0;
			break;
		default:
			report_error("Not bool value", val);
			return;
		}

		val.struct = ExtendedTab.boolType;
		this.adr = value;
	}

	@Override
	public void visit(ConstAssign assign) {
//		System.out.println("ConstAssign");
		if (errorDetected)
			return;

		if (this.currType == ExtendedTab.noType) {
			report_error("Const can't be void type", assign);
			return;
		}

		if (this.currType != assign.getConstValue().struct) {
			report_error("Type mismatch in const", assign);
			return;
		}

		assign.obj = ExtendedTab.insert(Obj.Con, assign.getName(), assign.getConstValue().struct);
		assign.obj.setAdr(this.adr);

//		ExtendedTab.printObj(assign.obj);
	}

	@Override
	public void visit(GlobalConstDeclaration constLine) {
//		System.out.println("GlobalConstDeclaration");
		if (errorDetected) {
//			errorDetected = false;
//			report_warn("Recovery from error in const decl", constLine);
			return;
		}

		currType = ExtendedTab.noType;
	}
	/*
	 * ConstDecl ---------------------------------------- END
	 */

	/*
	 * Var ---------------------------------------- START
	 */
	public void visit(VarAssignSingle var) {
//		System.out.println("VarAssignSingle");
		if (errorDetected)
			return;

		if (currType == ExtendedTab.noType) {
			report_error("Var can't be void type", var);
			return;
		}

		Obj tmp = ExtendedTab.find(var.getName());
		if (tmp.getName().equals(var.getName())) {
			report_error("Name " + var.getName() + " is defind", var);
			return;
		}

		var.obj = ExtendedTab.insert(Obj.Var, var.getName(), this.currType);

//		ExtendedTab.printObj(var.obj);
	}

	public void visit(VarAssignArray var) {
//		System.out.println("VarAssignArray");
		if (errorDetected)
			return;

		if (currType == ExtendedTab.noType) {
			report_error("Var array can't be void type", var);
			return;
		}

		Obj tmp = ExtendedTab.find(var.getName());
		if (tmp.getName().equals(var.getName())) {
			report_error("Name " + var.getName() + " is defind", var);
			return;
		}

		var.obj = ExtendedTab.insert(Obj.Var, var.getName(), new Struct(Struct.Array, this.currType));

//		ExtendedTab.printObj(var.obj);
	}

	@Override
	public void visit(GlobalVarDeclaration varLine) {
//		System.out.println("GlobalVarDeclaration");
		if (errorDetected)
			return;

		if (errorDetected) {
//			errorDetected = false;
//			report_warn("Recovery from error in var decl", varLine);
			return;
		}

		currType = ExtendedTab.noType;
	}
	/*
	 * Var ---------------------------------------- END
	 */

	/*
	 * Class ---------------------------------------- START
	 */
	@Override
	public void visit(GlobalClassDeclaration classLine) {
//		System.out.println("GlobalClassDeclaration");
	}
	/*
	 * Class ---------------------------------------- END
	 */

	/*
	 * Method ---------------------------------------- START
	 */
	public void visit(SingleMethodDecl method) {
//		System.out.println("SingleMethodDecl");
		if (errorDetected)
			return;

		method.obj = currScope;

		if (method.obj.getName().equals("main")) {
			if (!mainDetected) {
				mainDetected = true;
			} else {
				report_error("Only one main function is allowed", null);
				return;
			}

			if (method.obj.getLevel() > 0) {
				report_error("Function main can't have any arguments", null);
				return;
			}
		}

		ExtendedTab.chainLocalSymbols(method.obj);
		ExtendedTab.closeScope();

//		ExtendedTab.printObj(method.obj);

		currType = ExtendedTab.noType;
		currScope = ExtendedTab.noObj;
	}

	@Override
	public void visit(SomeReturnType retType) {
//		System.out.println("SomeReturnType");
		if (errorDetected)
			return;

		Obj tmp = ExtendedTab.find(retType.getMethodName().getName());
		if (tmp.getName().equals(retType.getMethodName().getName())) {
			report_error("More than one function/method named " + tmp.getName(), null);
			return;
		}

		retType.obj = tmp;
		currScope = ExtendedTab.insert(Obj.Meth, retType.getMethodName().getName(), retType.getType().struct);

		ExtendedTab.openScope();
	}

	@Override
	public void visit(NoReturnType retType) {
//		System.out.println("NoReturnType");
		if (errorDetected)
			return;

		Obj tmp = ExtendedTab.find(retType.getMethodName().getName());
		if (tmp.getName().equals(retType.getMethodName().getName())) {
			report_error("More than one function/method named " + tmp.getName(), null);
			return;
		}

		retType.obj = tmp;
		currScope = ExtendedTab.insert(Obj.Meth, retType.getMethodName().getName(), ExtendedTab.noType);

		ExtendedTab.openScope();
	}

	@Override
	public void visit(NoMethodParams params) {
//		System.out.println("NoMethodParams");
		currScope.setLevel(0);
	}
	/*
	 * Method ---------------------------------------- END
	 */

	/*
	 * FormPars ---------------------------------------- START
	 */
	@Override
	public void visit(SingleParam param) {
//		System.out.println("SingleFormPar");
		if (errorDetected)
			return;

		currScope.setLevel(currScope.getLevel() + 1);
	}
	/*
	 * FormPars ---------------------------------------- END
	 */

	/*
	 * Factor ---------------------------------------- START
	 */
	@Override
	public void visit(FactorNumber factor) {
//		System.out.println("FactorNumber");
		if (errorDetected)
			return;

		factor.obj = new Obj(Obj.Con, null, ExtendedTab.intType);
		factor.obj.setAdr(factor.getValue());
	}

	public void visit(FactorCharacter factor) {
//		System.out.println("FactorCharacter");
		if (errorDetected)
			return;

		factor.obj = new Obj(Obj.Con, null, ExtendedTab.charType);
		factor.obj.setAdr(factor.getValue());
	}

	public void visit(FactorBoolean factor) {
//		System.out.println("FactorBoolean");
		if (errorDetected)
			return;

		factor.obj = new Obj(Obj.Con, null, ExtendedTab.boolType);
		switch (factor.getValue()) {
		case "true":
			factor.obj.setAdr(1);
			break;
		case "false":
			factor.obj.setAdr(0);
			break;
		default:
			report_error("Value of type must be 'true' or 'false'", factor);
			break;
		}
	}

	public void visit(FactorNewType factor) {
//		System.out.println("FactorNewType"); incompatible
		if (errorDetected)
			return;

		factor.obj = new Obj(Obj.Fld, null, new Struct(Struct.Array, factor.getType().struct));
	}

	public void visit(FactorExprInBracket factor) {
//		System.out.println("FactorExprInBracket");
		if (errorDetected)
			return;

		factor.obj = factor.getExpr().obj;
	}

	public void visit(FactorDesignator factor) {
//		System.out.println("FactorDesignator");
		if (errorDetected)
			return;

		Obj tmp = factor.getDesignator().obj;
		if (tmp.getType().getKind() == Struct.Array) {
//			if (tmp.getType().getElemType() != ExtendedTab.intType) {
//				report_error("Incompatible type used", factor);
//				return;
//			}

			factor.obj = tmp;
			return;
		}

		factor.obj = tmp;
	}

	public void visit(NewTypeArray factor) {
//		System.out.println("FactorDesignator"); 
		if (errorDetected)
			return;

		if (factor.getExpr().obj.getType() != ExtendedTab.intType) {
			report_error("Size of array must use int for initialized", factor);
			return;
		}
	}
	/*
	 * Factor ---------------------------------------- END
	 */

	/*
	 * Designator ---------------------------------------- START
	 */
	@Override
	public void visit(AccessDeisgnatorArray arrElem) {
//		System.out.println("AccessDeisgnatorArray");
		if (errorDetected)
			return;

		if (arrElem.getExpr().obj.getType() != ExtendedTab.intType
				&& arrElem.getExpr().obj.getType().getElemType() != ExtendedTab.intType) {
			report_error("Array must me accessed with index of type int", arrElem);
			return;
		}
	}

	@Override
	public void visit(SingleDsig desig) {
//		System.out.println("SingleDsig");
		if (errorDetected)
			return;

		Obj tmp = ExtendedTab.find(desig.getVar());
		if (tmp == ExtendedTab.noObj) {
			report_error("Undefind variable", desig);
			return;
		}

		desig.obj = tmp;

		ExtendedObj printObj = new ExtendedObj();
		printObj.visitObjNode(desig.obj);
		System.out.println(
				"Search for " + desig.getVar() + " on line " + desig.getLine() + ", found " + printObj.getOutput());
	}

	@Override
	public void visit(DesigLst desigList) {
//		System.out.println("DesigLst");
		if (errorDetected)
			return;

		Obj tmp = ExtendedTab.find(desigList.getVar());
		if (tmp == ExtendedTab.noObj) {
			report_error("Undefind symbol", desigList);
			return;
		}

		desigList.obj = tmp;
	}

	@Override
	public void visit(AssignExpr assignDesig) {
//		System.out.println("DesigLst");
		if (errorDetected)
			return;

		Struct tmp1 = assignDesig.getDesignator().obj.getType(), tmp2 = assignDesig.getExpr().obj.getType();

		/* FUJJJJ!!!!!; al' me mrzi da napravim lepse (dok god radi, srecan sam :)) */
		if (tmp1.getKind() == Struct.Array) {
			if (tmp2.getKind() == Struct.Array) {
				if (tmp1.getElemType().getKind() != tmp2.getElemType().getKind()) {
					report_error("Uncompatible types", assignDesig);
					return;
				}
			} else {
				if (tmp1.getElemType().getKind() != tmp2.getKind()) {
					report_error("Uncompatible types", assignDesig);
					return;
				}
			}
		} else {
			if (tmp2.getKind() == Struct.Array) {
				if (tmp1.getKind() != tmp2.getElemType().getKind()) {
					report_error("Uncompatible types", assignDesig);
					return;
				}
			} else {
				if (tmp1.getKind() != tmp2.getKind()) {
					report_error("Uncompatible types", assignDesig);
					return;
				}
			}
		}

		assignDesig.obj = assignDesig.getExpr().obj;
	}

	@Override
	public void visit(IncrementDesig incDesig) {
		if (errorDetected)
			return;

		if (incDesig.getDesignator().obj.getType() != ExtendedTab.intType) {
			report_error("Designator must be of type int", incDesig);
			return;
		}

		incDesig.obj = incDesig.getDesignator().obj;
	}

	@Override
	public void visit(DecrementDesig decDesig) {
		if (errorDetected)
			return;

		if (decDesig.getDesignator().obj.getType() != ExtendedTab.intType) {
			report_error("Designator must be of type int", decDesig);
			return;
		}

		decDesig.obj = decDesig.getDesignator().obj;
	}
	/*
	 * Designator ---------------------------------------- END
	 */

	/*
	 * Expr ---------------------------------------- START
	 */
	@Override
	public void visit(SingleExpr expr) {
//		System.out.println("");
		if (errorDetected)
			return;

		expr.obj = expr.getExprSub().obj;
	}

	@Override
	public void visit(ReverseValue expr) {
//		System.out.println("");
		if (errorDetected)
			return;

		if (expr.getTermLst().obj.getType() != ExtendedTab.intType) {
			report_error("Non numerical values can not be inverted", expr);
			return;
		}

		expr.obj = expr.getTermLst().obj;
	}

	@Override
	public void visit(NoReverseValue expr) {
//		System.out.println("");
		if (errorDetected)
			return;

		expr.obj = expr.getTermLst().obj;
	}

	@Override
	public void visit(SingleTerm term) {
//		System.out.println("");
		if (errorDetected)
			return;

		term.obj = term.getTerm().obj;
	}

	@Override
	public void visit(TermList term) {
//		System.out.println("");
		if (errorDetected)
			return;

		if ((term.getTermLst().obj.getType() != ExtendedTab.intType
				&& term.getTermLst().obj.getType().getElemType() != ExtendedTab.intType)
				|| (term.getTerm().obj.getType() != ExtendedTab.intType
						&& term.getTerm().obj.getType().getElemType() != ExtendedTab.intType)) {
			report_error("Unexpected symbol encountered", term);
			return;
		}

		switch (this.currOp.pop()) {
		case "+":
		case "-":
			term.obj = new Obj(Obj.Var, null, ExtendedTab.intType);
			break;
		default:
			report_error("Unexpected operation", term);
			break;
		}

	}

	/*
	 * ExprSub -> Condition; ExprSub1 -> true statement; ExprSub2 -> false statement
	 */
	@Override
	public void visit(SimpleTernaryExpr expr) {
		if (errorDetected)
			return;

		if (expr.getExprSub1().obj.getType() != expr.getExprSub2().obj.getType()) {
			report_error("Return types of ternary expresion must be same", expr);
			return;
		}

		if (expr.getExprSub().obj.getType() != ExtendedTab.boolType) {
			report_error("Condition in ternary expresion must be bool type", expr);
			return;
		}

		switch (expr.getExprSub().obj.getAdr()) {
		case 1:
			expr.obj = expr.getExprSub1().obj;
			break;
		case 0:
			expr.obj = expr.getExprSub2().obj;
			break;
		default:
			report_error("Unexpected error encountered", expr);
			break;
		}
	}
	/*
	 * Expr ---------------------------------------- END
	 */

	/*
	 * Term ---------------------------------------- START
	 */
	@Override
	public void visit(FactorList factorLst) {
//		System.out.println("");
		if (errorDetected)
			return;

		if (factorLst.getFactor().obj.getType() != ExtendedTab.intType
				&& factorLst.getTerm().obj.getType().getElemType() != ExtendedTab.intType) {
			report_error("Types must be int", factorLst);
			return;
		}

		factorLst.obj = new Obj(Obj.Var, null, ExtendedTab.intType);
		switch (this.currOp.pop()) {
		case "*":
		case "/":
		case "%":
			factorLst.obj = new Obj(Obj.Var, null, ExtendedTab.intType);
			break;
		default:
			report_error("Unexpected operation", factorLst);
			break;
		}

	}

	@Override
	public void visit(SingleFactor factor) {
//		System.out.println("");
		if (errorDetected)
			return;

		factor.obj = factor.getFactor().obj;
	}
	/*
	 * Term ---------------------------------------- END
	 */

	/*
	 * Statement ---------------------------------------- START
	 */
	@Override
	public void visit(PrintStatement print) {
//		System.out.println("");
		if (errorDetected)
			return;

		Struct tmp = print.getExpr().obj.getType();
		if (tmp.getKind() != Struct.Array) {
			switch (tmp.getKind()) {
			case Struct.Int:
			case Struct.Bool:
			case Struct.Char:
				break;
			default:
				report_error("Print must recieve int, char or bool as first argument", print);
				break;
			}
		} else {
			switch (tmp.getElemType().getKind()) {
			case Struct.Int:
			case Struct.Bool:
			case Struct.Char:
				break;
			default:
				report_error("Print must recieve int, char or bool as first argument", print);
				break;
			}
		}
	}

	@Override
	public void visit(DesignatorStatementLine desig) {
//		System.out.println("");
		if (errorDetected)
			return;

		desig.obj = desig.getDesignatorStmt().obj;
	}

	@Override
	public void visit(ReadStatement read) {
//		System.out.println("");
		if (errorDetected)
			return;

		Struct tmp = read.getDesignator().obj.getType();
		if (tmp.getKind() != Struct.Array) {
			switch (tmp.getKind()) {
			case Struct.Int:
			case Struct.Bool:
			case Struct.Char:
				break;
			default:
				report_error("Print must recieve int, char or bool as first argument", read);
				break;
			}
		} else {
			switch (tmp.getElemType().getKind()) {
			case Struct.Int:
			case Struct.Bool:
			case Struct.Char:
				break;
			default:
				report_error("Print must recieve int, char or bool as first argument", read);
				break;
			}
		}
	}
	/*
	 * Statement ---------------------------------------- END
	 */

	/*
	 * Addop ---------------------------------------- START
	 */
	@Override
	public void visit(Addop op) {
//		System.out.println("");
		if (errorDetected)
			return;

		this.currOp.push("+");
	}

	@Override
	public void visit(Subop op) {
//		System.out.println("");
		if (errorDetected)
			return;

		this.currOp.push("-");
	}
	/*
	 * Addop ---------------------------------------- END
	 */

	/*
	 * Mulop ---------------------------------------- START
	 */
	@Override
	public void visit(Mulop op) {
//		System.out.println("");
		if (errorDetected)
			return;

		this.currOp.push("*");
	}

	@Override
	public void visit(Divop op) {
//		System.out.println("");
		if (errorDetected)
			return;

		this.currOp.push("/");
	}

	@Override
	public void visit(Modop op) {
//		System.out.println("");
		if (errorDetected)
			return;

		this.currOp.push("%");
	}
	/*
	 * Mulop ---------------------------------------- END
	 */

	/*
	 * placeholder ---------------------------------------- START
	 */
	@Override
	public void visit() {
//		System.out.println("");
		if (errorDetected)
			return;

	}
	/*
	 * placeholder ---------------------------------------- END
	 */
}
