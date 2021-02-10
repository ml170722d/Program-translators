// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class VarDeclaration extends VarDecl {

    private Type Type;
    private StartOfValDeclLst StartOfValDeclLst;

    public VarDeclaration (Type Type, StartOfValDeclLst StartOfValDeclLst) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.StartOfValDeclLst=StartOfValDeclLst;
        if(StartOfValDeclLst!=null) StartOfValDeclLst.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public StartOfValDeclLst getStartOfValDeclLst() {
        return StartOfValDeclLst;
    }

    public void setStartOfValDeclLst(StartOfValDeclLst StartOfValDeclLst) {
        this.StartOfValDeclLst=StartOfValDeclLst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(StartOfValDeclLst!=null) StartOfValDeclLst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(StartOfValDeclLst!=null) StartOfValDeclLst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(StartOfValDeclLst!=null) StartOfValDeclLst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StartOfValDeclLst!=null)
            buffer.append(StartOfValDeclLst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclaration]");
        return buffer.toString();
    }
}
