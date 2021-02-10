package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class ExtendedTab extends Tab {
	public static final Struct boolType = new Struct(Struct.Bool);

	private static ExtendedObj boolObj = new ExtendedObj();

	public static void init() {
		Tab.init();
		Obj tmp = Tab.insert(Obj.Type, "bool", ExtendedTab.boolType);
		tmp.setAdr(-1);
		tmp.setLevel(-1);
	}

//	public static Obj insert(Obj o) {
//		return Tab.insert(o.getKind(), o.getName(), o.getType());
//	}
	
	public static void dump() {
		ExtendedTab.dump(boolObj);
	}

	public static String printObj(Obj o) {
		StringBuilder sb = new StringBuilder();

		sb.append("Kind: ");
		switch (o.getKind()) {
		case Obj.Con:
			sb.append("Const");
			break;
		case Obj.Elem:
			sb.append("Elem");
			break;
		case Obj.Fld:
			sb.append("Fld");
			break;
		case Obj.Meth:
			sb.append("Meth");
			break;
		case Obj.Prog:
			sb.append("Prog");
			break;
		case Obj.Type:
			sb.append("Type");
			break;
		case Obj.Var:
			sb.append("Var");
			break;
		default:
			sb.append("NO_VALUE");
			break;
		}

		sb.append(", Name: " + o.getName() + ", Type: ");
		if (o.getType() == ExtendedTab.boolType) {
			sb.append("bool");
		} else if (o.getType() == ExtendedTab.charType) {
			sb.append("char");
		} else if (o.getType() == ExtendedTab.intType) {
			sb.append("int");
		} else if (o.getType() == ExtendedTab.noType) {
			sb.append("void");
		} else if (o.getType() == ExtendedTab.nullType) {
			sb.append("null");
		}

		sb.append(", Adr: " + o.getAdr());
		sb.append(", Level: " + o.getLevel());
		sb.append(", FpPos: " + o.getFpPos());

		return sb.toString();
	}

	public static String objInfo(Obj o) {
		StringBuilder sb = new StringBuilder();

		sb.append("Kind: ");
		switch (o.getKind()) {
		case Obj.Con:
			sb.append("Const");
			break;
		case Obj.Elem:
			sb.append("Elem");
			break;
		case Obj.Fld:
			sb.append("Fld");
			break;
		case Obj.Meth:
			sb.append("Meth");
			break;
		case Obj.Prog:
			sb.append("Prog");
			break;
		case Obj.Type:
			sb.append("Type");
			break;
		case Obj.Var:
			sb.append("Var");
			break;
		default:
			sb.append("NO_VALUE");
			break;
		}

		sb.append(" " + o.getName() + ": ");
		if (o.getType() == ExtendedTab.boolType) {
			sb.append("bool");
		} else if (o.getType() == ExtendedTab.charType) {
			sb.append("char");
		} else if (o.getType() == ExtendedTab.intType) {
			sb.append("int");
		} else if (o.getType() == ExtendedTab.noType) {
			sb.append("void");
		} else if (o.getType() == ExtendedTab.nullType) {
			sb.append("null");
		}

		sb.append(", Adr: " + o.getAdr());
		sb.append(", Level: " + o.getLevel());
		sb.append(", FpPos: " + o.getFpPos());

		return sb.toString();
	}
}
