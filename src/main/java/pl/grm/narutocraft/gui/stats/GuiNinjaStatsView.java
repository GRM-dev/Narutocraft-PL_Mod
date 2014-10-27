package pl.grm.narutocraft.gui.stats;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.gui.GuiNinjaButton;
import pl.grm.narutocraft.gui.GuiNinjaTabButton;
import pl.grm.narutocraft.gui.skilltrees.GuiJutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;
import pl.grm.narutocraft.libs.config.BaseValues;
import pl.grm.narutocraft.libs.config.References;
import pl.grm.narutocraft.libs.network.PacketNinjaStatsRequest;
import pl.grm.narutocraft.player.ExtendedProperties;
import pl.grm.narutocraft.player.NinjaAtrributes;
import pl.grm.narutocraft.player.NinjaStats;

public class GuiNinjaStatsView extends GuiContainer {
	private EntityPlayer	player;
	private int				padLeft		= 44, padTop = 27;
	private Boolean			jutsuMenu	= false;
	private int				jutsuPage	= 0;
	private int				strUpg		= 0, agiUpg = 0, dexUpg = 0, resUpg = 0, epmUpg = 0,
			chaUpg = 0, crbUpg = 0;
	private int				stbUpg		= 0, stfUpg = 0, stgUpg = 0, stiUpg = 0, stnUpg = 0,
			sttUpg = 0;
	
	public GuiNinjaStatsView(EntityPlayer player) {
		super(new ContainerNull());
		this.player = player;
		this.xSize = this.jutsuMenu ? 210 : 256;
		this.ySize = this.jutsuMenu ? 210 : 256;
	}
	
	/**
	 * Button Clicks
	 * <p>
	 * Tabs id 0-6, Stats and then the 6 Jutsu types
	 **/
	@Override
	protected void actionPerformed(GuiButton button) {
		if (button.id < 7) {
			actionSwitchPage(button.id);
		} else if (button.id < 15) {
			actionStatUp(button.id);
		} else {
			actionOther(button.id);
		}
	}
	
	private void actionSwitchPage(int id) {
		switch (id) {
			case 0 : // Stats
				this.jutsuMenu = false;
				break;
			case 1 : // jutsu
				this.jutsuMenu = true;
				this.mc.displayGuiScreen(new GuiJutsu(this));
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
				if (stats.getChakraRegenBonus() + crbUpg < 75) {
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
	
	/**
	 * Draws Background of GUI
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		this.xSize = this.jutsuMenu ? 210 : 256;
		this.ySize = this.jutsuMenu ? 210 : 256;
		
		NinjaStats stats = ExtendedProperties.get(this.player).getNinStats();
		NinjaAtrributes attrb = ExtendedProperties.get(this.player).getNinAttrs();
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(this.jutsuMenu
				? References.jutsuGUILocation[this.jutsuPage] : References.statsPath);
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		this.buttonList.clear();
		// Start with main control buttons
		int x1 = this.guiLeft;
		int x2 = (this.guiLeft + this.xSize) - (22);
		
		// Controls
		// Tabs buttons
		this.buttonList.add(new GuiNinjaTabButton(0, x2, this.guiTop - 22, References
				.getIconFromJutsu(JutsuEnum.HADAN)));
		this.buttonList.add(new GuiNinjaTabButton(1, x1, this.guiTop - 22, References
				.getIconFromJutsu(JutsuEnum.KAI)));
		this.buttonList.add(new GuiNinjaTabButton(2, x1 + 22, this.guiTop - 22, References
				.getIconFromJutsu(JutsuEnum.BYAKUGO)));
		this.buttonList.add(new GuiNinjaTabButton(3, x1 + (22 * 2), this.guiTop - 22, References
				.getIconFromJutsu(JutsuEnum.FUKIMIHARI)));
		this.buttonList.add(new GuiNinjaTabButton(4, x1 + (22 * 3), this.guiTop - 22, References
				.getIconFromJutsu(JutsuEnum.RANSHINSHO)));
		this.buttonList.add(new GuiNinjaTabButton(5, x1 + (22 * 4), this.guiTop - 22, References
				.getIconFromJutsu(JutsuEnum.YOSAKUGIRI)));
		this.buttonList.add(new GuiNinjaTabButton(6, x1 + (22 * 5), this.guiTop - 22, References
				.getIconFromJutsu(JutsuEnum.ENMAKUGIRE)));
		
		// Stats
		if (!this.jutsuMenu) {
			this.drawString(this.fontRendererObj, "Ninja Level: " + stats.getNinjaLevel(),
					this.guiLeft + this.padLeft, (this.guiTop + this.padTop) - 9, 0xddeeee);
			if (stats.getSkillPoints() > 0) {
				this.drawString(this.fontRendererObj, "Skill Points: " + stats.getSkillPoints(),
						this.guiLeft + this.padLeft, this.guiTop + this.padTop, 0xddeeee);
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(References.ninjaWidgetsPath);
			drawTexturedModalRect(this.guiLeft + 132, (this.guiTop + this.padTop) - 7, 66, 0, 39, 4);
			drawTexturedModalRect(this.guiLeft + 132, (this.guiTop + this.padTop) - 7, 66, 4,
					(stats.getCurrentXp() * 39) / stats.getXpCap(), 4);
			
			// Stats
			this.drawDefaultString("Stats (2 points)", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 2), 0xddeeee);
			this.drawDefaultString("Strength: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 3), 0xddeeee);
			this.drawDefaultString("" + attrb.getStrength(), this.guiLeft + this.padLeft + 110,
					this.guiTop + this.padTop + (9 * 3), 0xddeeee);
			if (strUpg > 0) {
				this.drawDefaultString("+ " + strUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 3), 0x73ff9b);
			}
			
			this.drawDefaultString("Resistance: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 4), 0xddeeee);
			this.drawDefaultString("" + attrb.getResistance(), this.guiLeft + this.padLeft + 110,
					this.guiTop + this.padTop + (9 * 4), 0xddeeee);
			if (resUpg > 0) {
				this.drawDefaultString("+ " + resUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 4), 0x73ff9b);
			}
			
			this.drawDefaultString("Dexterity: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 5), 0xddeeee);
			this.drawDefaultString("" + attrb.getDexterity(), this.guiLeft + this.padLeft + 110,
					this.guiTop + this.padTop + (9 * 5), 0xddeeee);
			if (dexUpg > 0) {
				this.drawDefaultString("+ " + dexUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 5), 0x73ff9b);
			}
			
			this.drawDefaultString("Agility: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 6), 0xddeeee);
			this.drawDefaultString("" + attrb.getAgility(), this.guiLeft + this.padLeft + 110,
					this.guiTop + this.padTop + (9 * 6), 0xddeeee);
			if (agiUpg > 0) {
				this.drawDefaultString("+ " + agiUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 6), 0x73ff9b);
			}
			// Level up Controls
			if (stats.getSkillPoints() >= 2) {
				this.buttonList.add(new GuiNinjaButton(7, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 3), "plus"));
				this.buttonList.add(new GuiNinjaButton(8, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 4), "plus"));
				this.buttonList.add(new GuiNinjaButton(9, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 5), "plus"));
				this.buttonList.add(new GuiNinjaButton(10, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 6), "plus"));
			}
			// Training/Main
			this.drawDefaultString("Training (1 point)", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 8), 0xddeeee);
			this.drawDefaultString("Element Power: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 9), 0xddeeee);
			this.drawDefaultString("" + stats.getElementPowerModifier(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 9), 0xddeeee);
			if (epmUpg > 0) {
				this.drawDefaultString("+ " + epmUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 9), 0x73ff9b);
			}
			this.drawDefaultString("Max Chakra Bonus: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 10), 0xddeeee);
			this.drawDefaultString("" + stats.getChakraModifier(), this.guiLeft + this.padLeft
					+ 110, this.guiTop + this.padTop + (9 * 10), 0xddeeee);
			if (chaUpg > 0) {
				this.drawDefaultString("+ " + chaUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 10), 0x73ff9b);
			}
			this.drawDefaultString("Chakra Regen Bonus: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 11), 0xddeeee);
			this.drawDefaultString("" + stats.getChakraRegenBonus(), this.guiLeft + this.padLeft
					+ 110, this.guiTop + this.padTop + (9 * 11), 0xddeeee);
			if (crbUpg > 0) {
				this.drawDefaultString("+ " + crbUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 11), 0x73ff9b);
			}
			// Level up Controls
			if (stats.getSkillPoints() >= 1) {
				this.buttonList.add(new GuiNinjaButton(11, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 9), "plus"));
				this.buttonList.add(new GuiNinjaButton(12, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 10), "plus"));
				this.buttonList.add(new GuiNinjaButton(13, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 11), "plus"));
			}
			// Jutsu
			this.drawDefaultString("Jutsu Training (3 points)", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 13), 0xddeeee);
			this.drawDefaultString("Bukijutsu: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 14), 0xddeeee);
			this.drawDefaultString("" + stats.getBukiTreeLevel(),
					this.guiLeft + this.padLeft + 110, this.guiTop + this.padTop + (9 * 14),
					0xddeeee);
			if (stbUpg > 0) {
				this.drawDefaultString("+ " + stbUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 14), 0x73ff9b);
			}
			this.drawDefaultString("Fuuinjutsu: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 15), 0xddeeee);
			this.drawDefaultString("" + stats.getFuuinTreeLevel(), this.guiLeft + this.padLeft
					+ 110, this.guiTop + this.padTop + (9 * 15), 0xddeeee);
			if (stfUpg > 0) {
				this.drawDefaultString("+ " + stfUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 15), 0x73ff9b);
			}
			this.drawDefaultString("Genjutsu: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 16), 0xddeeee);
			this.drawDefaultString("" + stats.getGenTreeLevel(), this.guiLeft + this.padLeft + 110,
					this.guiTop + this.padTop + (9 * 16), 0xddeeee);
			if (stgUpg > 0) {
				this.drawDefaultString("+ " + stgUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 16), 0x73ff9b);
			}
			this.drawDefaultString("Iryojutsu: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 17), 0xddeeee);
			this.drawDefaultString("" + stats.getIryoTreeLevel(),
					this.guiLeft + this.padLeft + 110, this.guiTop + this.padTop + (9 * 17),
					0xddeeee);
			if (stiUpg > 0) {
				this.drawDefaultString("+ " + stiUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 17), 0x73ff9b);
			}
			this.drawDefaultString("Ninjutsu: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 18), 0xddeeee);
			this.drawDefaultString("" + stats.getNinTreeLevel(), this.guiLeft + this.padLeft + 110,
					this.guiTop + this.padTop + (9 * 18), 0xddeeee);
			if (stnUpg > 0) {
				this.drawString(this.fontRendererObj, "+ " + stnUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 18), 0x73ff9b);
			}
			this.drawDefaultString("Taijutsu: ", this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 19), 0xddeeee);
			this.drawDefaultString("" + stats.getTaiTreeLevel(), this.guiLeft + this.padLeft + 110,
					this.guiTop + this.padTop + (9 * 19), 0xddeeee);
			if (sttUpg > 0) {
				this.drawDefaultString("+ " + sttUpg, this.guiLeft + this.padLeft + 125,
						this.guiTop + this.padTop + (9 * 19), 0x73ff9b);
			}
			// Level up Controls
			if (stats.getSkillPoints() >= 3) {
				this.buttonList.add(new GuiNinjaButton(16, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 14), "plus"));
				this.buttonList.add(new GuiNinjaButton(17, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 15), "plus"));
				this.buttonList.add(new GuiNinjaButton(18, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 16), "plus"));
				this.buttonList.add(new GuiNinjaButton(19, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 17), "plus"));
				this.buttonList.add(new GuiNinjaButton(20, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 18), "plus"));
				this.buttonList.add(new GuiNinjaButton(21, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 19), "plus"));
			}
			this.buttonList.add(new GuiButton(14, this.guiLeft + this.padLeft, this.guiTop
					+ this.padTop + (9 * 20), 50, 20, "Save"));
			this.buttonList.add(new GuiButton(15, this.guiLeft + this.padLeft + 50, this.guiTop
					+ this.padTop + (9 * 20), 50, 20, "Reset"));
		}
	}
	
	private void drawDefaultString(String text, int x, int y, int color) {
		this.drawString(this.fontRendererObj, text, x, y, color);
	}
	
	public FontRenderer getFontRenderer() {
		return this.fontRendererObj;
	}
	
	public int getTop() {
		return guiTop;
	}
	
	public int getLeft() {
		return guiLeft;
	}
	
	public int getSizeX() {
		return xSize;
	}
	
	public int getSizeY() {
		return ySize;
	}
	
	/** Keyboard Clicks **/
	@Override
	protected void keyTyped(char par1, int par2) {
		if ((par2 == 1) || (par2 == this.mc.gameSettings.keyBindInventory.getKeyCode())) {
			this.mc.thePlayer.closeScreen();
		}
	}
}
