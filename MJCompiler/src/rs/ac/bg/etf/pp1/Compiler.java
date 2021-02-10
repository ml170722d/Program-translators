package rs.ac.bg.etf.pp1;

import java.io.*;

import org.apache.log4j.Logger;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.mj.runtime.Code;

public class Compiler {

	public static void main(String args[]) throws Exception {
		Logger log = Logger.getLogger(Compiler.class);

		if (args.length < 2) {
			log.error("Not enough arguments");
		} else {
			File sourceCode = new File(args[0]);

			if (!sourceCode.exists()) {
				log.error("Source code .mj file not found");
				return;
			}

			log.info("================ LIST OF TOKENS ===================");

			FileReader sourceCodeFile = new FileReader(sourceCode);

			Yylex lexer = new Yylex(sourceCodeFile);
			MJParser parser = new MJParser(lexer);

			Symbol symbols = parser.parse();

			if (parser.getParserError()) {
				log.error("Error in parsing");
				return;
			}

			Program prog = (Program) (symbols.value);
			ExtendedTab.init();

			log.info("\n================ SINTAX TREE ===================");
			log.info(prog.toString(""));

			log.info("\n================ LIST OF DESIGNATORS FOUND ===================");

			SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
			prog.traverseBottomUp(semanticAnalyzer);

			if (!semanticAnalyzer.getSemanticError() && semanticAnalyzer.getMainDetected()) {

				ExtendedTab.dump();

				CodeGenerator codeGenerator = new CodeGenerator();
				prog.traverseBottomUp(codeGenerator);
//				prog.traverseTopDown(codeGenerator);
				Code.dataSize = semanticAnalyzer.getNumOfGlobVars();
				Code.mainPc = codeGenerator.getPcMain();

				File outputObjectFile = new File(args[1]);
				Code.write(new FileOutputStream(outputObjectFile));

				log.info("Semantics are good");
				log.info("================ PARSING COMPLETED ===================");

			} else {
				log.error("Error in semantics");
			}
		}
	}
}
