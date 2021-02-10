// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class SingleMethodDecl extends MethodDecl {

    private ReturnTypeAndName ReturnTypeAndName;
    private MethodParams MethodParams;
    private MethodLocalVars MethodLocalVars;
    private MethodStmts MethodStmts;

    public SingleMethodDecl (ReturnTypeAndName ReturnTypeAndName, MethodParams MethodParams, MethodLocalVars MethodLocalVars, MethodStmts MethodStmts) {
        this.ReturnTypeAndName=ReturnTypeAndName;
        if(ReturnTypeAndName!=null) ReturnTypeAndName.setParent(this);
        this.MethodParams=MethodParams;
        if(MethodParams!=null) MethodParams.setParent(this);
        this.MethodLocalVars=MethodLocalVars;
        if(MethodLocalVars!=null) MethodLocalVars.setParent(this);
        this.MethodStmts=MethodStmts;
        if(MethodStmts!=null) MethodStmts.setParent(this);
    }

    public ReturnTypeAndName getReturnTypeAndName() {
        return ReturnTypeAndName;
    }

    public void setReturnTypeAndName(ReturnTypeAndName ReturnTypeAndName) {
        this.ReturnTypeAndName=ReturnTypeAndName;
    }

    public MethodParams getMethodParams() {
        return MethodParams;
    }

    public void setMethodParams(MethodParams MethodParams) {
        this.MethodParams=MethodParams;
    }

    public MethodLocalVars getMethodLocalVars() {
        return MethodLocalVars;
    }

    public void setMethodLocalVars(MethodLocalVars MethodLocalVars) {
        this.MethodLocalVars=MethodLocalVars;
    }

    public MethodStmts getMethodStmts() {
        return MethodStmts;
    }

    public void setMethodStmts(MethodStmts MethodStmts) {
        this.MethodStmts=MethodStmts;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnTypeAndName!=null) ReturnTypeAndName.accept(visitor);
        if(MethodParams!=null) MethodParams.accept(visitor);
        if(MethodLocalVars!=null) MethodLocalVars.accept(visitor);
        if(MethodStmts!=null) MethodStmts.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnTypeAndName!=null) ReturnTypeAndName.traverseTopDown(visitor);
        if(MethodParams!=null) MethodParams.traverseTopDown(visitor);
        if(MethodLocalVars!=null) MethodLocalVars.traverseTopDown(visitor);
        if(MethodStmts!=null) MethodStmts.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnTypeAndName!=null) ReturnTypeAndName.traverseBottomUp(visitor);
        if(MethodParams!=null) MethodParams.traverseBottomUp(visitor);
        if(MethodLocalVars!=null) MethodLocalVars.traverseBottomUp(visitor);
        if(MethodStmts!=null) MethodStmts.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleMethodDecl(\n");

        if(ReturnTypeAndName!=null)
            buffer.append(ReturnTypeAndName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodParams!=null)
            buffer.append(MethodParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodLocalVars!=null)
            buffer.append(MethodLocalVars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodStmts!=null)
            buffer.append(MethodStmts.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleMethodDecl]");
        return buffer.toString();
    }
}
