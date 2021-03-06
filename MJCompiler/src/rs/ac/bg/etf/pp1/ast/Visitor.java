// generated with ast extension for cup
// version 0.8
// 10/1/2021 2:49:43


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(DeclarationList DeclarationList);
    public void visit(MethodDecl MethodDecl);
    public void visit(DesignatorFunCall DesignatorFunCall);
    public void visit(NewTypeArr NewTypeArr);
    public void visit(ClassFieldDeclList ClassFieldDeclList);
    public void visit(Relop Relop);
    public void visit(DesignatorExpr DesignatorExpr);
    public void visit(ClassMethodDeclList ClassMethodDeclList);
    public void visit(StatementList StatementList);
    public void visit(ClassName ClassName);
    public void visit(MethodStmts MethodStmts);
    public void visit(DesignatorStmt DesignatorStmt);
    public void visit(ReturnTypeAndName ReturnTypeAndName);
    public void visit(Factor Factor);
    public void visit(TermLst TermLst);
    public void visit(ExtCondFact ExtCondFact);
    public void visit(Designator Designator);
    public void visit(StartOfValDeclLst StartOfValDeclLst);
    public void visit(Term Term);
    public void visit(ExprSub ExprSub);
    public void visit(ClassBody ClassBody);
    public void visit(FormParsList FormParsList);
    public void visit(PrintParam PrintParam);
    public void visit(MethodParams MethodParams);
    public void visit(LocalVars LocalVars);
    public void visit(ConstValue ConstValue);
    public void visit(MiddleOfVarDeclLst MiddleOfVarDeclLst);
    public void visit(Expr Expr);
    public void visit(FunActPars FunActPars);
    public void visit(ActPars ActPars);
    public void visit(ConstDeclarationLine ConstDeclarationLine);
    public void visit(DesignatorList DesignatorList);
    public void visit(EndOfVarDeclLst EndOfVarDeclLst);
    public void visit(ParentClass ParentClass);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(VarAssign VarAssign);
    public void visit(ClassDecl ClassDecl);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(Declaration Declaration);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(FormPars FormPars);
    public void visit(Modop Modop);
    public void visit(Divop Divop);
    public void visit(Mulop Mulop);
    public void visit(Subop Subop);
    public void visit(Addop Addop);
    public void visit(LessOrEqualThen LessOrEqualThen);
    public void visit(LessThen LessThen);
    public void visit(GreaterOrEqualThen GreaterOrEqualThen);
    public void visit(GreaterThen GreaterThen);
    public void visit(NotEqual NotEqual);
    public void visit(Equal Equal);
    public void visit(Assignop Assignop);
    public void visit(AccessDeisgnatorArray AccessDeisgnatorArray);
    public void visit(AccessDeisgnatorField AccessDeisgnatorField);
    public void visit(SingleDesigExpr SingleDesigExpr);
    public void visit(DesigExprLst DesigExprLst);
    public void visit(SingleDsig SingleDsig);
    public void visit(DesigLst DesigLst);
    public void visit(NotNewTypeArray NotNewTypeArray);
    public void visit(NewTypeArray NewTypeArray);
    public void visit(NotInlineFunCall NotInlineFunCall);
    public void visit(InlineFunCall InlineFunCall);
    public void visit(FactorExprInBracket FactorExprInBracket);
    public void visit(FactorNewType FactorNewType);
    public void visit(FactorBoolean FactorBoolean);
    public void visit(FactorCharacter FactorCharacter);
    public void visit(FactorNumber FactorNumber);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(SingleFactor SingleFactor);
    public void visit(FactorList FactorList);
    public void visit(SingleTerm SingleTerm);
    public void visit(TermList TermList);
    public void visit(NoReverseValue NoReverseValue);
    public void visit(ReverseValue ReverseValue);
    public void visit(ConditionTernary ConditionTernary);
    public void visit(FalseBranch FalseBranch);
    public void visit(TrueBranch TrueBranch);
    public void visit(SingleExpr SingleExpr);
    public void visit(SimpleTernaryExpr SimpleTernaryExpr);
    public void visit(NoExtendSimpleCondition NoExtendSimpleCondition);
    public void visit(ExtendSimpleCondition ExtendSimpleCondition);
    public void visit(SimpleCondition SimpleCondition);
    public void visit(CondTerm CondTerm);
    public void visit(Condition Condition);
    public void visit(SingleActPars SingleActPars);
    public void visit(MultiActPars MultiActPars);
    public void visit(FunWithoutArg FunWithoutArg);
    public void visit(FunWithArg FunWithArg);
    public void visit(DecrementDesig DecrementDesig);
    public void visit(IncrementDesig IncrementDesig);
    public void visit(FunCall FunCall);
    public void visit(AssignExpr AssignExpr);
    public void visit(PrintMoreParam PrintMoreParam);
    public void visit(PrintOneParam PrintOneParam);
    public void visit(StatementError StatementError);
    public void visit(PrintStatement PrintStatement);
    public void visit(ReadStatement ReadStatement);
    public void visit(DesignatorStatementLine DesignatorStatementLine);
    public void visit(SingleStatement SingleStatement);
    public void visit(MultiStatements MultiStatements);
    public void visit(Type Type);
    public void visit(SingleParam SingleParam);
    public void visit(SingleFormPar SingleFormPar);
    public void visit(MultiFormPars MultiFormPars);
    public void visit(NoMethodStatements NoMethodStatements);
    public void visit(MethodStatements MethodStatements);
    public void visit(MethodLocalVars MethodLocalVars);
    public void visit(NoMethodParams NoMethodParams);
    public void visit(MethodParameters MethodParameters);
    public void visit(MethodName MethodName);
    public void visit(NoReturnType NoReturnType);
    public void visit(SomeReturnType SomeReturnType);
    public void visit(SingleMethodDecl SingleMethodDecl);
    public void visit(NoMethodDeclList NoMethodDeclList);
    public void visit(MethodDeclarationList MethodDeclarationList);
    public void visit(NoClassMethodDeclList NoClassMethodDeclList);
    public void visit(ClassMethodDeclarationList ClassMethodDeclarationList);
    public void visit(NoLocalVariables NoLocalVariables);
    public void visit(LocalVariables LocalVariables);
    public void visit(ClassieldDeclarationList ClassieldDeclarationList);
    public void visit(ClassBodyDeclaration ClassBodyDeclaration);
    public void visit(NoParentClass NoParentClass);
    public void visit(ParentClassName ParentClassName);
    public void visit(NewClassName NewClassName);
    public void visit(ClassDeclaration ClassDeclaration);
    public void visit(VarAssignArray VarAssignArray);
    public void visit(VarAssignSingle VarAssignSingle);
    public void visit(ErrorVarDeclarationWithComma ErrorVarDeclarationWithComma);
    public void visit(VarDeclarationWithComma VarDeclarationWithComma);
    public void visit(SingleVarDeclList SingleVarDeclList);
    public void visit(MultiVarDeclList MultiVarDeclList);
    public void visit(SingleVarDecl SingleVarDecl);
    public void visit(MultiVarDecl MultiVarDecl);
    public void visit(ErrorVarDeclSemi ErrorVarDeclSemi);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumConst NumConst);
    public void visit(ConstAssign ConstAssign);
    public void visit(SingleConstDecl SingleConstDecl);
    public void visit(MultiConstDecl MultiConstDecl);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(GlobalClassDeclaration GlobalClassDeclaration);
    public void visit(GlobalVarDeclaration GlobalVarDeclaration);
    public void visit(GlobalConstDeclaration GlobalConstDeclaration);
    public void visit(NoGlobalDeclarations NoGlobalDeclarations);
    public void visit(GlobalDeclarations GlobalDeclarations);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
