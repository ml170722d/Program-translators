// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class SingleVarDeclList extends MiddleOfVarDeclLst {

    private EndOfVarDeclLst EndOfVarDeclLst;

    public SingleVarDeclList (EndOfVarDeclLst EndOfVarDeclLst) {
        this.EndOfVarDeclLst=EndOfVarDeclLst;
        if(EndOfVarDeclLst!=null) EndOfVarDeclLst.setParent(this);
    }

    public EndOfVarDeclLst getEndOfVarDeclLst() {
        return EndOfVarDeclLst;
    }

    public void setEndOfVarDeclLst(EndOfVarDeclLst EndOfVarDeclLst) {
        this.EndOfVarDeclLst=EndOfVarDeclLst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(EndOfVarDeclLst!=null) EndOfVarDeclLst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(EndOfVarDeclLst!=null) EndOfVarDeclLst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(EndOfVarDeclLst!=null) EndOfVarDeclLst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleVarDeclList(\n");

        if(EndOfVarDeclLst!=null)
            buffer.append(EndOfVarDeclLst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleVarDeclList]");
        return buffer.toString();
    }
}
