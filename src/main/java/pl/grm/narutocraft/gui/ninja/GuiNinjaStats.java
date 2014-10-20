package pl.grm.narutocraft.gui.ninja;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.ExtendedProperties;
import pl.grm.narutocraft.libs.PlayerSkillsAtrributes;
import pl.grm.narutocraft.libs.References;
import pl.grm.narutocraft.network.PacketNinjaStatsRequest;

public class GuiNinjaStats extends GuiContainer {
	private EntityPlayer	player;
	private int				padLeft		= 44, padTop = 27;
	private Boolean			jutsuMenu	= false;
	private int				jutsuPage	= 0;
	private int				strUpg		= 0, agiUpg = 0, dexUpg = 0, resUpg = 0, epmUpg = 0,
			chaUpg = 0, crbUpg = 0;
	private int				stbUpg		= 0, stfUpg = 0, stgUpg = 0, stiUpg = 0, stnUpg = 0,
			sttUpg = 0;
	
	public GuiNinjaStats(EntityPlayer player) {
		super(new ContainerNull());
		
		this.player = player;
		this.xSize = this.jutsuMenu ? 210 : 256;
		this.ySize = this.jutsuMenu ? 210 : 256;
	}
	
	/** Button Clicks **/
	@Override
	protected void actionPerformed(GuiButton button) {
		// Tabs 0 - 6, Stats and then the 6 Jutsu types
		switch (button.id) {
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
			case 7 : // increase Strength
				strUpg += 1;
				ExtendedProperties.get(this.player).psa.skillPoints -= 2;
				break;
			case 8 : // increase Resist
				resUpg += 1;
				ExtendedProperties.get(this.player).psa.skillPoints -= 2;
				break;
			case 9 : // increase Dex
				dexUpg += 1;
				ExtendedProperties.get(this.player).psa.skillPoints -= 2;
				break;
			case 10 : // increase Agi
				agiUpg += 1;
				ExtendedProperties.get(this.player).psa.skillPoints -= 2;
				break;
			case 11 : // increase elm
				epmUpg += 1;
				ExtendedProperties.get(this.player).psa.skillPoints -= 1;
				break;
			case 12 : // increase mcha
				chaUpg += 1;
				ExtendedProperties.get(this.player).psa.skillPoints -= 1;
				break;
			case 13 : // increase char
				if (ExtendedProperties.get(this.player).psa.getChakraRegenMod() + crbUpg < 75) {
					crbUpg += 1;
					ExtendedProperties.get(this.player).psa.skillPoints -= 1;
				}
				break;
			case 14 : // send changes
				int[] upgradeStats = new int[]{
						strUpg, agiUpg, dexUpg, resUpg, epmUpg, chaUpg, crbUpg, stbUpg, stfUpg,
						stgUpg, stiUpg, stnUpg, sttUpg,
						ExtendedProperties.get(player).psa.skillPoints};
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
				ExtendedProperties.get(this.player).psa.skillPoints -= 3;
				break;
			case 17 :
				stfUpg++;
				ExtendedProperties.get(this.player).psa.skillPoints -= 3;
				break;
			case 18 :
				stgUpg++;
				ExtendedProperties.get(this.player).psa.skillPoints -= 3;
				break;
			case 19 :
				stiUpg++;
				ExtendedProperties.get(this.player).psa.skillPoints -= 3;
				break;
			case 20 :
				stnUpg++;
				ExtendedProperties.get(this.player).psa.skillPoints -= 3;
				break;
			case 21 :
				sttUpg++;
				ExtendedProperties.get(this.player).psa.skillPoints -= 3;
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
		PlayerSkillsAtrributes ppsa = ExtendedProperties.get(player).psa;
		int totalSkillPoints = (ppsa.getNinjaLevel() - 1)
				* PlayerSkillsAtrributes.skillPointsPerLevel;
		int totalSkillPointsUsed = 0;
		
		// Stats
		totalSkillPointsUsed += (ppsa.getStrength() + ppsa.getAgility() + ppsa.getDexterity() + ppsa
				.getResistance()) * 2;
		// Training/Main
		totalSkillPointsUsed += (ppsa.getElementPowerMod() + ppsa.getMaxChakraMod() + ppsa
				.getChakraRegenMod());
		// Jutsu
		totalSkillPointsUsed += (ppsa.getBukiTreeLevel() + ppsa.getFuuinTreeLevel()
				+ ppsa.getGenTreeLevel() + ppsa.getIryoTreeLevel() + ppsa.getNinTreeLevel() + ppsa
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
		ExtendedProperties.get(player).psa.skillPoints = totalSkillPoints - totalSkillPointsUsed;
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		this.xSize = this.jutsuMenu ? 210 : 256;
		this.ySize = this.jutsuMenu ? 210 : 256;
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(this.jutsuMenu
				? References.jutsuGUI[this.jutsuPage] : References.statsPath);
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		this.buttonList.clear();
		// Start with main control buttons
		
		int x1 = this.guiLeft;
		int x2 = (this.guiLeft + this.xSize) - (22);
		
		// Controls
		// Tabs
		this.buttonList.add(new GuiNinjaTab(0, x2, this.guiTop - 22, Items.apple
				.getIconFromDamage(0)));// Stats page
		
		this.buttonList.add(new GuiNinjaTab(1, x1, this.guiTop - 22, Items.apple
				.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(2, x1 + 22, this.guiTop - 22, Items.apple
				.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(3, x1 + (22 * 2), this.guiTop - 22, Items.apple
				.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(4, x1 + (22 * 3), this.guiTop - 22, Items.apple
				.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(5, x1 + (22 * 4), this.guiTop - 22, Items.apple
				.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(6, x1 + (22 * 5), this.guiTop - 22, Items.apple
				.getIconFromDamage(0)));
		
		// Stats
		ExtendedProperties props = ExtendedProperties.get(this.player);
		if (!this.jutsuMenu) {
			this.drawString(this.fontRendererObj, "Ninja Level: " + props.psa.getNinjaLevel(),
					this.guiLeft + this.padLeft, (this.guiTop + this.padTop) - 9, 0xddeeee);
			if (props.psa.skillPoints > 0) {
				this.drawString(this.fontRendererObj, "Skill Points: " + props.psa.skillPoints,
						this.guiLeft + this.padLeft, this.guiTop + this.padTop, 0xddeeee);
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(References.ninjaWidgetsPath);
			drawTexturedModalRect(this.guiLeft + 132, (this.guiTop + this.padTop) - 7, 66, 0, 39, 4);
			drawTexturedModalRect(this.guiLeft + 132, (this.guiTop + this.padTop) - 7, 66, 4,
					(props.psa.getCurrentXp() * 39) / props.psa.getXpCap(), 4);
			
			// Stats
			this.drawString(this.fontRendererObj, "Stats (2 points)", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 2), 0xddeeee);
			this.drawString(this.fontRendererObj, "Strength: ", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 3), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getStrength(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 3), 0xddeeee);
			if (strUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + strUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 3), 0x73ff9b);
			
			this.drawString(this.fontRendererObj, "Resistance: ", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 4), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getResistance(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 4), 0xddeeee);
			if (resUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + resUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 4), 0x73ff9b);
			
			this.drawString(this.fontRendererObj, "Dexterity: ", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 5), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getDexterity(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 5), 0xddeeee);
			if (dexUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + dexUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 5), 0x73ff9b);
			
			this.drawString(this.fontRendererObj, "Agility: ", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 6), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getAgility(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 6), 0xddeeee);
			if (agiUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + agiUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 6), 0x73ff9b);
			
			// Level up Controls
			if (props.psa.skillPoints >= 2) {
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
			this.drawString(this.fontRendererObj, "Training (1 point)",
					this.guiLeft + this.padLeft, this.guiTop + this.padTop + (9 * 8), 0xddeeee);
			this.drawString(this.fontRendererObj, "Element Power: ", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 9), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getElementPowerMod(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 9), 0xddeeee);
			if (epmUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + epmUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 9), 0x73ff9b);
			
			this.drawString(this.fontRendererObj, "Max Chakra Bonus: ",
					this.guiLeft + this.padLeft, this.guiTop + this.padTop + (9 * 10), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getMaxChakraMod(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 10), 0xddeeee);
			if (chaUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + chaUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 10), 0x73ff9b);
			
			this.drawString(this.fontRendererObj, "Chakra Regen Bonus: ", this.guiLeft
					+ this.padLeft, this.guiTop + this.padTop + (9 * 11), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getChakraRegenMod(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 11), 0xddeeee);
			if (crbUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + crbUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 11), 0x73ff9b);
			
			// Level up Controls
			if (props.psa.skillPoints >= 1) {
				this.buttonList.add(new GuiNinjaButton(11, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 9), "plus"));
				this.buttonList.add(new GuiNinjaButton(12, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 10), "plus"));
				this.buttonList.add(new GuiNinjaButton(13, this.guiLeft + this.padLeft + 145,
						this.guiTop + this.padTop + (9 * 11), "plus"));
			}
			
			// Jutsu
			this.drawString(this.fontRendererObj, "Jutsu Training (3 points)", this.guiLeft
					+ this.padLeft, this.guiTop + this.padTop + (9 * 13), 0xddeeee);
			this.drawString(this.fontRendererObj, "Bukijutsu: ", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 14), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getBukiTreeLevel(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 14), 0xddeeee);
			if (stbUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + stbUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 14), 0x73ff9b);
			
			this.drawString(this.fontRendererObj, "Fuuinjutsu: ", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 15), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getFuuinTreeLevel(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 15), 0xddeeee);
			if (stfUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + stfUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 15), 0x73ff9b);
			
			this.drawString(this.fontRendererObj, "Genjutsu: ", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 16), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getGenTreeLevel(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 16), 0xddeeee);
			if (stgUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + stgUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 16), 0x73ff9b);
			
			this.drawString(this.fontRendererObj, "Iryojutsu: ", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 17), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getIryoTreeLevel(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 17), 0xddeeee);
			if (stiUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + stiUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 17), 0x73ff9b);
			
			this.drawString(this.fontRendererObj, "Ninjutsu: ", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 18), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getNinTreeLevel(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 18), 0xddeeee);
			if (stnUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + stnUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 18), 0x73ff9b);
			
			this.drawString(this.fontRendererObj, "Taijutsu: ", this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 19), 0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getTaiTreeLevel(), this.guiLeft
					+ this.padLeft + 110, this.guiTop + this.padTop + (9 * 19), 0xddeeee);
			if (sttUpg > 0)
				this.drawString(this.fontRendererObj, "+ " + sttUpg, this.guiLeft + this.padLeft
						+ 125, this.guiTop + this.padTop + (9 * 19), 0x73ff9b);
			
			// Level up Controls
			if (props.psa.skillPoints >= 3) {
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
