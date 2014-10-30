package pl.grm.narutocraft.gui.stats;

import net.minecraft.entity.player.EntityPlayer;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.config.BaseValues;
import pl.grm.narutocraft.libs.network.PacketNinjaStatsRequest;
import pl.grm.narutocraft.player.ExtendedProperties;
import pl.grm.narutocraft.player.NinjaAtrributes;
import pl.grm.narutocraft.player.NinjaStats;

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
	
	public void actionHandler(int id) {
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
				// this.mc.displayGuiScreen(new GuiJutsu(this));
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
		NinjaStats stats = ExtendedProperties.get(this.player).getNinStats();
		switch (id) {
			case 7 : // increase Strength
				strUpg += 1;
				stats.setSkillPoints(stats.getSkillPoints() - 2);
				break;
			case 8 : // increase Resist
				resUpg += 1;
				stats.setSkillPoints(stats.getSkillPoints() - 2);
				break;
			case 9 : // increase Dex
				dexUpg += 1;
				stats.setSkillPoints(stats.getSkillPoints() - 2);
				break;
			case 10 : // increase Agi
				agiUpg += 1;
				stats.setSkillPoints(stats.getSkillPoints() - 2);
				break;
			case 11 : // increase elm
				epmUpg += 1;
				stats.setSkillPoints(stats.getSkillPoints() - 1);
				break;
			case 12 : // increase mcha
				chaUpg += 1;
				stats.setSkillPoints(stats.getSkillPoints() - 1);
				break;
			case 13 : // increase char
				if (stats.getChakraModifier() + crbUpg < 75) {
					crbUpg += 1;
					stats.setSkillPoints(stats.getSkillPoints() - 1);
				}
				break;
			default :
				break;
		}
	}
	
	private void actionOther(int id) {
		NinjaStats stats = ExtendedProperties.get(this.player).getNinStats();
		switch (id) {
			case 14 : // send changes
				int[] upgradeStats = new int[]{
						strUpg, agiUpg, dexUpg, resUpg, epmUpg, chaUpg, crbUpg, stbUpg, stfUpg,
						stgUpg, stiUpg, stnUpg, sttUpg, stats.getSkillPoints()};
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
				stats.setSkillPoints(stats.getSkillPoints() - 3);
				break;
			case 17 :
				stfUpg++;
				stats.setSkillPoints(stats.getSkillPoints() - 3);
				break;
			case 18 :
				stgUpg++;
				stats.setSkillPoints(stats.getSkillPoints() - 3);
				break;
			case 19 :
				stiUpg++;
				stats.setSkillPoints(stats.getSkillPoints() - 3);
				break;
			case 20 :
				stnUpg++;
				stats.setSkillPoints(stats.getSkillPoints() - 3);
				break;
			case 21 :
				sttUpg++;
				stats.setSkillPoints(stats.getSkillPoints() - 3);
				break;
			default :
				break;
		}
	}
	
	private boolean canSaveData() {
		NinjaStats stats = ExtendedProperties.get(this.player).getNinStats();
		NinjaAtrributes attrb = ExtendedProperties.get(this.player).getNinAttrs();
		
		int totalSkillPoints = (stats.getNinjaLevel() - 1) * BaseValues.skillPointsPerLevel;
		int totalSkillPointsUsed = 0;
		// Stats
		totalSkillPointsUsed += (attrb.getStrength() + strUpg + attrb.getAgility() + agiUpg
				+ attrb.getDexterity() + dexUpg + attrb.getResistance() + resUpg) * 2;
		// Training/Main
		totalSkillPointsUsed += (attrb.getElementPowerMod() + epmUpg + attrb.getMaxChakraMod()
				+ chaUpg + attrb.getChakraRegenMod() + crbUpg);
		// Jutsu
		totalSkillPointsUsed += (stats.getBukiTreeLevel() + stbUpg + stats.getFuuinTreeLevel()
				+ stfUpg + stats.getGenTreeLevel() + stgUpg + stats.getIryoTreeLevel() + stiUpg
				+ stats.getNinTreeLevel() + stnUpg + stats.getTaiTreeLevel() + sttUpg) * 3;
		if (totalSkillPointsUsed <= totalSkillPoints) { return true; }
		
		return false;
	}
	
	private void resetData() {
		NinjaStats stats = ExtendedProperties.get(this.player).getNinStats();
		NinjaAtrributes attrb = ExtendedProperties.get(this.player).getNinAttrs();
		
		int totalSkillPoints = (stats.getNinjaLevel() - 1) * BaseValues.skillPointsPerLevel;
		int totalSkillPointsUsed = 0;
		// Stats
		totalSkillPointsUsed += (attrb.getStrength() + attrb.getAgility() + attrb.getDexterity() + attrb
				.getResistance()) * 2;
		// Training/Main
		totalSkillPointsUsed += (stats.getElementPowerModifier() + stats.getChakraModifier() + stats
				.getChakraRegenBonus());
		// Jutsu
		totalSkillPointsUsed += (stats.getBukiTreeLevel() + stats.getFuuinTreeLevel()
				+ stats.getGenTreeLevel() + stats.getIryoTreeLevel() + stats.getNinTreeLevel() + stats
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
		stats.setSkillPoints(totalSkillPoints - totalSkillPointsUsed);
	}
}
