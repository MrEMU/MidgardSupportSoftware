package Calc;

public class EXPNode {

	private String name;
	private int exp;
	private EXPNode nextNode;
	
	public EXPNode(String name) {
		this(name, 0);
	}

	public EXPNode(String name, int exp){
		this.name = name;
		this.exp = exp;
		this.nextNode = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public void addToExp(int exp) {
		this.exp += exp;
	}

	public EXPNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(EXPNode nextNode) {
		this.nextNode = nextNode;
	}
	
}
