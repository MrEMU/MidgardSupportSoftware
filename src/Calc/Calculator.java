package Calc;

public class Calculator {
	
	public static int getCloseCombatExp(int dmg, int grad, boolean monsterkill){
		if(monsterkill)
			return 5*(grad+3);
		if(dmg<8)
			return (grad+3);
		else
			return 2*(grad+3);
	}
	
	public static int getSpellExp(int apcost){
		return 3*apcost;
	}
	
	public static int getHealSpellExp(int apcost, int regenerated, boolean rescue){
		if(rescue || regenerated>=20)
			return getSpellExp(apcost)*5;
		if(regenerated>=8)
			return getSpellExp(apcost)*2;
		else
			return getSpellExp(apcost);
	}
	
}
