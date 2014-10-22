package pl.grm.narutocraft.gui.stats;

import net.minecraft.entity.player.EntityPlayer;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.network.PacketNinjaStatsRequest;
import pl.grm.narutocraft.stats.ExtendedProperties;
import pl.grm.narutocraft.stats.PlayerSkillsAtrributes;

public class GuiNinjaStatsPresenter {
	private EntityPlayer	player;

	private Boolean			jutsuMenu	= false;
	private int				jutsuPage	= 0;
	private int				strUpg		= 0, agiUpg = 0, dexUpg = 0, resUpg = 0, epmUpg = 0,
			chaUpg = 0, crbUpg = 0;
	private int				stbUpg		= 0, stfUpg = 0, stgUpg = 0, stiUpg = 0, stnUpg = 0,
			sttUpg = 0;
	
	public GuiNinjaStatsPresenter(EntityPlayer player) {
		this.player = player;
	}
	
	public void actionHandler(int id)
	{
		if (id < 7) {
			actionSwitchPage(id);
		} else if (id < 15) {
			actionStatUp(id);
		} else {
			actionOther(id);
		}
	}
	
	private void actionSwitchPage(int id) {
		switch (id) {
			case 0 : // Stats
				this.jutsuMenu = false;
				break;
			case 1 : // jutsu
				this.jutsuMenu = true;
				//this.mc.displayGuiScreen(new GuiJutsu(this));
				this.jutsuPage = 0;
				break;
			case 2 : // jutsu
				this.jutsuMenu = true;
				this.jutsuPage = 1;
				break;
			case 3 : // jutsu
				this.jutsuMenu = true;
				this.jutsuPage = 2;
				break;
			case 4 : // jutsu
				this.jutsuMenu = true;
				this.jutsuPage = 3;
				break;
			case 5 : // jutsu
				this.jutsuMenu = true;
				this.jutsuPage = 4;
				break;
			case 6 : // jutsu
				this.jutsuMenu = true;
				this.jutsuPage = 5;
				break;
			default :
				break;
		}
	}
	
	private void actionStatUp(int id) {
		PlayerSkillsAtrributes psa = ExtendedProperties.get(this.player).psa;
		switch (id) {
			case 7 : // increase Strength
				strUpg += 1;
				psa.skillPoints -= 2;
				break;
			case 8 : // increase Resist
				resUpg += 1;
				psa.skillPoints -= 2;
				break;
			case 9 : // increase Dex
				dexUpg += 1;
				psa.skillPoints -= 2;
				break;
			case 10 : // increase Agi
				agiUpg += 1;
				psa.skillPoints -= 2;
				break;
			case 11 : // increase elm
				epmUpg += 1;
				psa.skillPoints -= 1;
				break;
			case 12 : // increase mcha
				chaUpg += 1;
				psa.skillPoints -= 1;
				break;
			case 13 : // increase char
				if (psa.getChakraRegenMod() + crbUpg < 75) {
					crbUpg += 1;
					psa.skillPoints -= 1;
				}
				break;
			default :
				break;
		}
	}
	
	private void actionOther(int id) {
		PlayerSkillsAtrributes psa = ExtendedProperties.get(this.player).psa;
		switch (id) {
			case 14 : // send changes
				int[] upgradeStats = new int[]{
						strUpg, agiUpg, dexUpg, resUpg, epmUpg, chaUpg, crbUpg, stbUpg, stfUpg,
						stgUpg, stiUpg, stnUpg, sttUpg, psa.skillPoints};
				if (canSaveData()) {
					NarutoCraft.netHandler.sendToServer(new PacketNinjaStatsRequest("set",
							upgradeStats));
					resetData();
				}
				break;
			case 15 : // reset all
				// NarutoCraft.netHandler.sendToServer(new
				// PacketNinjaStatsRequest("reset",new int[]{0}));
				resetData();
				break;
			case 16 :
				stbUpg++;
				psa.skillPoints -= 3;
				break;
			case 17 :
				stfUpg++;
				psa.skillPoints -= 3;
				break;
			case 18 :
				stgUpg++;
				psa.skillPoints -= 3;
				break;
			case 19 :
				stiUpg++;
				psa.skillPoints -= 3;
				break;
			case 20 :
				stnUpg++;
				psa.skillPoints -= 3;
				break;
			case 21 :
				sttUpg++;
				psa.skillPoints -= 3;
				break;
			default :
				break;
		}
	}
	
	private boolean canSaveData() {
		PlayerSkillsAtrributes ppsa = ExtendedProperties.get(player).psa;
		int totalSkillPoints = (ppsa.getNinjaLevel() - 1)
				* PlayerSkillsAtrributes.skillPointsPerLevel;
		int totalSkillPointsUsed = 0;
		
		// Stats
		totalSkillPointsUsed += (ppsa.getStrength() + strUpg + ppsa.getAgility() + agiUpg
				+ ppsa.getDexterity() + dexUpg + ppsa.getResistance() + resUpg) * 2;
		// Training/Main
		totalSkillPointsUsed += (ppsa.getElementPowerMod() + epmUpg + ppsa.getMaxChakraMod()
				+ chaUpg + ppsa.getChakraRegenMod() + crbUpg);
		// Jutsu
		totalSkillPointsUsed += (ppsa.getBukiTreeLevel() + stbUpg + ppsa.getFuuinTreeLevel()
				+ stfUpg + ppsa.getGenTreeLevel() + stgUpg + ppsa.getIryoTreeLevel() + stiUpg
				+ ppsa.getNinTreeLevel() + stnUpg + ppsa.getTaiTreeLevel() + sttUpg) * 3;
		if (totalSkillPointsUsed <= totalSkillPoints) { return true; }
		
		return false;
	}
	
	private void resetData() {
		PlayerSkillsAtrributes psa = ExtendedProperties.get(player).psa;
		int totalSkillPoints = (psa.getNinjaLevel() - 1)
				* PlayerSkillsAtrributes.skillPointsPerLevel;
		int totalSkillPointsUsed = 0;
		// Stats
		totalSkillPointsUsed += (psa.getStrength() + psa.getAgility() + psa.getDexterity() + psa
				.getResistance()) * 2;
		// Training/Main
		totalSkillPointsUsed += (psa.getElementPowerMod() + psa.getMaxChakraMod() + psa
				.getChakraRegenMod());
		// Jutsu
		totalSkillPointsUsed += (psa.getBukiTreeLevel() + psa.getFuuinTreeLevel()
				+ psa.getGenTreeLevel() + psa.getIryoTreeLevel() + psa.getNinTreeLevel() + psa
				.getTaiTreeLevel()) * 3;
		strUpg = 0;
		agiUpg = 0;
		dexUpg = 0;
		resUpg = 0;
		epmUpg = 0;
		chaUpg = 0;
		crbUpg = 0;
		stbUpg = 0;
		stfUpg = 0;
		stgUpg = 0;
		stiUpg = 0;
		stnUpg = 0;
		sttUpg = 0;
		psa.skillPoints = totalSkillPoints - totalSkillPointsUsed;
	}
}
