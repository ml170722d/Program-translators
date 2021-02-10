// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public class SimpleTernaryExpr extends Expr {

    private ExprSub ExprSub;
    private ConditionTernary ConditionTernary;
    private ExprSub ExprSub1;
    private TrueBranch TrueBranch;
    private FalseBranch FalseBranch;
    private ExprSub ExprSub2;

    public SimpleTernaryExpr (ExprSub ExprSub, ConditionTernary ConditionTernary, ExprSub ExprSub1, TrueBranch TrueBranch, FalseBranch FalseBranch, ExprSub ExprSub2) {
        this.ExprSub=ExprSub;
        if(ExprSub!=null) ExprSub.setParent(this);
        this.ConditionTernary=ConditionTernary;
        if(ConditionTernary!=null) ConditionTernary.setParent(this);
        this.ExprSub1=ExprSub1;
        if(ExprSub1!=null) ExprSub1.setParent(this);
        this.TrueBranch=TrueBranch;
        if(TrueBranch!=null) TrueBranch.setParent(this);
        this.FalseBranch=FalseBranch;
        if(FalseBranch!=null) FalseBranch.setParent(this);
        this.ExprSub2=ExprSub2;
        if(ExprSub2!=null) ExprSub2.setParent(this);
    }

    public ExprSub getExprSub() {
        return ExprSub;
    }

    public void setExprSub(ExprSub ExprSub) {
        this.ExprSub=ExprSub;
    }

    public ConditionTernary getConditionTernary() {
        return ConditionTernary;
    }

    public void setConditionTernary(ConditionTernary ConditionTernary) {
        this.ConditionTernary=ConditionTernary;
    }

    public ExprSub getExprSub1() {
        return ExprSub1;
    }

    public void setExprSub1(ExprSub ExprSub1) {
        this.ExprSub1=ExprSub1;
    }

    public TrueBranch getTrueBranch() {
        return TrueBranch;
    }

    public void setTrueBranch(TrueBranch TrueBranch) {
        this.TrueBranch=TrueBranch;
    }

    public FalseBranch getFalseBranch() {
        return FalseBranch;
    }

    public void setFalseBranch(FalseBranch FalseBranch) {
        this.FalseBranch=FalseBranch;
    }

    public ExprSub getExprSub2() {
        return ExprSub2;
    }

    public void setExprSub2(ExprSub ExprSub2) {
        this.ExprSub2=ExprSub2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprSub!=null) ExprSub.accept(visitor);
        if(ConditionTernary!=null) ConditionTernary.accept(visitor);
        if(ExprSub1!=null) ExprSub1.accept(visitor);
        if(TrueBranch!=null) TrueBranch.accept(visitor);
        if(FalseBranch!=null) FalseBranch.accept(visitor);
        if(ExprSub2!=null) ExprSub2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprSub!=null) ExprSub.traverseTopDown(visitor);
        if(ConditionTernary!=null) ConditionTernary.traverseTopDown(visitor);
        if(ExprSub1!=null) ExprSub1.traverseTopDown(visitor);
        if(TrueBranch!=null) TrueBranch.traverseTopDown(visitor);
        if(FalseBranch!=null) FalseBranch.traverseTopDown(visitor);
        if(ExprSub2!=null) ExprSub2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprSub!=null) ExprSub.traverseBottomUp(visitor);
        if(ConditionTernary!=null) ConditionTernary.traverseBottomUp(visitor);
        if(ExprSub1!=null) ExprSub1.traverseBottomUp(visitor);
        if(TrueBranch!=null) TrueBranch.traverseBottomUp(visitor);
        if(FalseBranch!=null) FalseBranch.traverseBottomUp(visitor);
        if(ExprSub2!=null) ExprSub2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SimpleTernaryExpr(\n");

        if(ExprSub!=null)
            buffer.append(ExprSub.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionTernary!=null)
            buffer.append(ConditionTernary.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprSub1!=null)
            buffer.append(ExprSub1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TrueBranch!=null)
            buffer.append(TrueBranch.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FalseBranch!=null)
            buffer.append(FalseBranch.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprSub2!=null)
            buffer.append(ExprSub2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SimpleTernaryExpr]");
        return buffer.toString();
    }
}
