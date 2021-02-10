// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class NoReverseValue extends ExprSub {

    private TermLst TermLst;

    public NoReverseValue (TermLst TermLst) {
        this.TermLst=TermLst;
        if(TermLst!=null) TermLst.setParent(this);
    }

    public TermLst getTermLst() {
        return TermLst;
    }

    public void setTermLst(TermLst TermLst) {
        this.TermLst=TermLst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermLst!=null) TermLst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermLst!=null) TermLst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermLst!=null) TermLst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoReverseValue(\n");

        if(TermLst!=null)
            buffer.append(TermLst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoReverseValue]");
        return buffer.toString();
    }
}
