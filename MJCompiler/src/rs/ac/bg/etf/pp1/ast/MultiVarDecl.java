// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class MultiVarDecl extends StartOfValDeclLst {

    private MiddleOfVarDeclLst MiddleOfVarDeclLst;
    private VarAssign VarAssign;

    public MultiVarDecl (MiddleOfVarDeclLst MiddleOfVarDeclLst, VarAssign VarAssign) {
        this.MiddleOfVarDeclLst=MiddleOfVarDeclLst;
        if(MiddleOfVarDeclLst!=null) MiddleOfVarDeclLst.setParent(this);
        this.VarAssign=VarAssign;
        if(VarAssign!=null) VarAssign.setParent(this);
    }

    public MiddleOfVarDeclLst getMiddleOfVarDeclLst() {
        return MiddleOfVarDeclLst;
    }

    public void setMiddleOfVarDeclLst(MiddleOfVarDeclLst MiddleOfVarDeclLst) {
        this.MiddleOfVarDeclLst=MiddleOfVarDeclLst;
    }

    public VarAssign getVarAssign() {
        return VarAssign;
    }

    public void setVarAssign(VarAssign VarAssign) {
        this.VarAssign=VarAssign;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MiddleOfVarDeclLst!=null) MiddleOfVarDeclLst.accept(visitor);
        if(VarAssign!=null) VarAssign.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MiddleOfVarDeclLst!=null) MiddleOfVarDeclLst.traverseTopDown(visitor);
        if(VarAssign!=null) VarAssign.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MiddleOfVarDeclLst!=null) MiddleOfVarDeclLst.traverseBottomUp(visitor);
        if(VarAssign!=null) VarAssign.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiVarDecl(\n");

        if(MiddleOfVarDeclLst!=null)
            buffer.append(MiddleOfVarDeclLst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarAssign!=null)
            buffer.append(VarAssign.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiVarDecl]");
        return buffer.toString();
    }
}
