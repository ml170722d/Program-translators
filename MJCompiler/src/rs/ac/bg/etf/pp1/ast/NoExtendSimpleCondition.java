// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class NoExtendSimpleCondition extends ExtCondFact {

    public NoExtendSimpleCondition () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoExtendSimpleCondition(\n");

        buffer.append(tab);
        buffer.append(") [NoExtendSimpleCondition]");
        return buffer.toString();
    }
}
