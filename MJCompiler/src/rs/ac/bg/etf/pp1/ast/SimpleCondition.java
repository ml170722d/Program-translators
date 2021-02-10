// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class SimpleCondition extends CondFact {

    private Expr Expr;
    private ExtCondFact ExtCondFact;

    public SimpleCondition (Expr Expr, ExtCondFact ExtCondFact) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.ExtCondFact=ExtCondFact;
        if(ExtCondFact!=null) ExtCondFact.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public ExtCondFact getExtCondFact() {
        return ExtCondFact;
    }

    public void setExtCondFact(ExtCondFact ExtCondFact) {
        this.ExtCondFact=ExtCondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(ExtCondFact!=null) ExtCondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(ExtCondFact!=null) ExtCondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(ExtCondFact!=null) ExtCondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SimpleCondition(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExtCondFact!=null)
            buffer.append(ExtCondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SimpleCondition]");
        return buffer.toString();
    }
}
