
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }


"program"   { return new_symbol(sym.PROG, yytext());}

"break"   	{ return new_symbol(sym.BREAK, yytext());}
"continue"  { return new_symbol(sym.CONTINUE, yytext());}
"const"   	{ return new_symbol(sym.CONST, yytext());}
"new"   	{ return new_symbol(sym.NEW, yytext());}

"if"   		{ return new_symbol(sym.IF, yytext());}
"else"   	{ return new_symbol(sym.ELSE, yytext());}
"switch"   	{ return new_symbol(sym.SWITCH, yytext());}
"case" 		{ return new_symbol(sym.CASE, yytext());}
"do"   		{ return new_symbol(sym.DO, yytext());}
"while"   	{ return new_symbol(sym.WHILE, yytext());}

"class"   	{ return new_symbol(sym.CLASS, yytext());}
"enum"   	{ return new_symbol(sym.ENUM, yytext());}
"extends"   { return new_symbol(sym.EXTENDS, yytext());}

"print"   	{ return new_symbol(sym.PRINT, yytext());}
"read"   	{ return new_symbol(sym.READ, yytext());}

"return"   	{ return new_symbol(sym.RETURN, yytext());}

"void"   	{ return new_symbol(sym.VOID, yytext());}


"+" 		{ return new_symbol(sym.ADD, yytext()); }
"-" 		{ return new_symbol(sym.SUB, yytext()); }
"*" 		{ return new_symbol(sym.MUL, yytext()); }
"/" 		{ return new_symbol(sym.DIV, yytext()); }
"%" 		{ return new_symbol(sym.MOD, yytext()); }

"=="		{ return new_symbol(sym.EQ, yytext()); }
"!=" 		{ return new_symbol(sym.NEQ, yytext()); }
">" 		{ return new_symbol(sym.GT, yytext()); }
">=" 		{ return new_symbol(sym.GEQT, yytext()); }
"<" 		{ return new_symbol(sym.LT, yytext()); }
"<=" 		{ return new_symbol(sym.LEQT, yytext()); }
"&&" 		{ return new_symbol(sym.AND, yytext()); }
"||" 		{ return new_symbol(sym.OR, yytext()); }


"=" 		{ return new_symbol(sym.ASSIGN, yytext()); }
"++" 		{ return new_symbol(sym.INC, yytext()); }
"--" 		{ return new_symbol(sym.DEC, yytext()); }


";" 		{ return new_symbol(sym.SEMI, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"." 		{ return new_symbol(sym.DOT, yytext()); }

"(" 		{ return new_symbol(sym.LBRACKET, yytext()); }
")" 		{ return new_symbol(sym.RBRACKET, yytext()); }
"[" 		{ return new_symbol(sym.LSQUAREB, yytext()); }
"]"			{ return new_symbol(sym.RSQUAREB, yytext()); }
"{"			{ return new_symbol(sym.LBRACE, yytext()); }
"}"			{ return new_symbol(sym.RBRACE, yytext()); }


"?"			{ return new_symbol(sym.QUESMART, yytext()); }
":"			{ return new_symbol(sym.COLON, yytext()); }


"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }


[0-9]+  			{ return new_symbol(sym.NUMCONST, new Integer (yytext())); }
"'"."'"				{ return new_symbol(sym.CHARCONST, new Character (yytext().charAt(1))); }
("true"|"false")	{ return new_symbol(sym.BOOLCONST, yytext()); }

([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext()); }


. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }










