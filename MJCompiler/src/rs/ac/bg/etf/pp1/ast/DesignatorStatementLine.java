// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementLine extends Statement {

    private DesignatorStmt DesignatorStmt;

    public DesignatorStatementLine (DesignatorStmt DesignatorStmt) {
        this.DesignatorStmt=DesignatorStmt;
        if(DesignatorStmt!=null) DesignatorStmt.setParent(this);
    }

    public DesignatorStmt getDesignatorStmt() {
        return DesignatorStmt;
    }

    public void setDesignatorStmt(DesignatorStmt DesignatorStmt) {
        this.DesignatorStmt=DesignatorStmt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStmt!=null) DesignatorStmt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStmt!=null) DesignatorStmt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStmt!=null) DesignatorStmt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementLine(\n");

        if(DesignatorStmt!=null)
            buffer.append(DesignatorStmt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementLine]");
        return buffer.toString();
    }
}
