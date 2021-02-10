package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.VarAssignSingle;
import rs.etf.pp1.mj.runtime.Code;
import rs.ac.bg.etf.pp1.ast.*;

public class CustomVisitor extends VisitorAdaptor {

	protected int count = 0;

	public int getCount() {
		return count;
	}

	public static class VarCounter extends CustomVisitor {
		public void visit(VarAssignSingle var) {
			count++;
		}
		
		public void visit(VarAssignArray var) {
			count++;
		}
	}
	
	public static class ParamCounter extends CustomVisitor {
		public void visit(SingleParam var) {
			count++;
		}
	}
	
	public static class TernaryExprVisitor extends CustomVisitor {
		private boolean detectedTernary = false;
		
		public TernaryExprVisitor() {
		}
		
		public boolean isTernaryDetected() {
			return detectedTernary;
		}
		
		@Override
		public void visit(SimpleTernaryExpr expr) {
			detectedTernary = true;			
		}
	}
	
	public static class DesignatorVisitor extends CustomVisitor {
		private boolean detected = false;
		
		public DesignatorVisitor() {
		}
		
		public boolean hasBrackets() {
			return detected;
		}
		
		@Override
		public void visit(DesigLst expr) {
			detected = true;			
		}
	}
	
	public static class SingleDesigVisitor extends CustomVisitor {
		private boolean detected = false;
		
		public boolean shouldLoad() {
			return detected;
		}
		
		@Override
		public void visit(IncrementDesig expr) {
			detected = true;			
		}
		
		@Override
		public void visit(DecrementDesig expr) {
			detected = true;			
		}
	}
	
}
