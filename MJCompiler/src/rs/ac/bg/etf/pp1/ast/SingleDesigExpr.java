// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class SingleDesigExpr extends DesignatorList {

    private DesignatorExpr DesignatorExpr;

    public SingleDesigExpr (DesignatorExpr DesignatorExpr) {
        this.DesignatorExpr=DesignatorExpr;
        if(DesignatorExpr!=null) DesignatorExpr.setParent(this);
    }

    public DesignatorExpr getDesignatorExpr() {
        return DesignatorExpr;
    }

    public void setDesignatorExpr(DesignatorExpr DesignatorExpr) {
        this.DesignatorExpr=DesignatorExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorExpr!=null) DesignatorExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorExpr!=null) DesignatorExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorExpr!=null) DesignatorExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleDesigExpr(\n");

        if(DesignatorExpr!=null)
            buffer.append(DesignatorExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleDesigExpr]");
        return buffer.toString();
    }
}
