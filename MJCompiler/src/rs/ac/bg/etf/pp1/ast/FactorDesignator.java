// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignator extends Factor {

    private Designator Designator;
    private DesignatorFunCall DesignatorFunCall;

    public FactorDesignator (Designator Designator, DesignatorFunCall DesignatorFunCall) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DesignatorFunCall=DesignatorFunCall;
        if(DesignatorFunCall!=null) DesignatorFunCall.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DesignatorFunCall getDesignatorFunCall() {
        return DesignatorFunCall;
    }

    public void setDesignatorFunCall(DesignatorFunCall DesignatorFunCall) {
        this.DesignatorFunCall=DesignatorFunCall;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(DesignatorFunCall!=null) DesignatorFunCall.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DesignatorFunCall!=null) DesignatorFunCall.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DesignatorFunCall!=null) DesignatorFunCall.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignator(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorFunCall!=null)
            buffer.append(DesignatorFunCall.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignator]");
        return buffer.toString();
    }
}
