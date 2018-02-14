package Calc;

import java.util.ArrayList;

public class EXPTable extends ArrayList<EXPNode>  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String[][] getData(){
		String[][] data = new String[this.size()][2];
		int i = 0;
		for(EXPNode node: this){
			data[i][0] = node.getName();
			data[i][1] = node.getExp() + "";
			i++;
		}
		return data;
	}
	
	public void resetData(){
		this.forEach(node -> node.setExp(0));
	}
	
}
