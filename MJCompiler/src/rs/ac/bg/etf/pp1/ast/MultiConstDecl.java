// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class MultiConstDecl extends ConstDeclarationLine {

    private ConstDeclarationLine ConstDeclarationLine;
    private ConstAssign ConstAssign;

    public MultiConstDecl (ConstDeclarationLine ConstDeclarationLine, ConstAssign ConstAssign) {
        this.ConstDeclarationLine=ConstDeclarationLine;
        if(ConstDeclarationLine!=null) ConstDeclarationLine.setParent(this);
        this.ConstAssign=ConstAssign;
        if(ConstAssign!=null) ConstAssign.setParent(this);
    }

    public ConstDeclarationLine getConstDeclarationLine() {
        return ConstDeclarationLine;
    }

    public void setConstDeclarationLine(ConstDeclarationLine ConstDeclarationLine) {
        this.ConstDeclarationLine=ConstDeclarationLine;
    }

    public ConstAssign getConstAssign() {
        return ConstAssign;
    }

    public void setConstAssign(ConstAssign ConstAssign) {
        this.ConstAssign=ConstAssign;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclarationLine!=null) ConstDeclarationLine.accept(visitor);
        if(ConstAssign!=null) ConstAssign.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclarationLine!=null) ConstDeclarationLine.traverseTopDown(visitor);
        if(ConstAssign!=null) ConstAssign.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclarationLine!=null) ConstDeclarationLine.traverseBottomUp(visitor);
        if(ConstAssign!=null) ConstAssign.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiConstDecl(\n");

        if(ConstDeclarationLine!=null)
            buffer.append(ConstDeclarationLine.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstAssign!=null)
            buffer.append(ConstAssign.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiConstDecl]");
        return buffer.toString();
    }
}
