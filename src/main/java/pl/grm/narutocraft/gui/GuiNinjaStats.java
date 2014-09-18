package pl.grm.narutocraft.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.ExtendedProperties;
import pl.grm.narutocraft.libs.References;
import pl.grm.narutocraft.network.PacketNinjaStatsRequest;
import pl.grm.narutocraft.registry.RegJutsus;

public class GuiNinjaStats extends GuiContainer {
	private EntityPlayer player;
	private int padLeft = 44, padTop = 27;
	private Boolean jutsuMenu = false;
	private int jutsuPage = 0;

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
				ExtendedProperties.get(this.player).psa
						.setStrength(ExtendedProperties.get(this.player).psa
								.getStrength() + 1);
				ExtendedProperties.get(this.player).psa.skillPoints -= 3;
				break;
			case 8 : // increase Resist
				ExtendedProperties.get(this.player).psa
						.setResistance(ExtendedProperties.get(this.player).psa
								.getResistance() + 1);
				ExtendedProperties.get(this.player).psa.skillPoints -= 3;
				break;
			case 9 : // increase Dex
				ExtendedProperties.get(this.player).psa
						.setDexterity(ExtendedProperties.get(this.player).psa
								.getDexterity() + 1);
				ExtendedProperties.get(this.player).psa.skillPoints -= 3;
				break;
			case 10 : // increase Agi
				ExtendedProperties.get(this.player).psa
						.setAgility(ExtendedProperties.get(this.player).psa
								.getAgility() + 1);
				ExtendedProperties.get(this.player).psa.skillPoints -= 3;
				break;
			case 11 : // increase elm
				ExtendedProperties.get(this.player).psa
						.setElementPowerModifier(ExtendedProperties
								.get(this.player).psa.getElementPowerModifier() + 1);
				ExtendedProperties.get(this.player).psa.skillPoints -= 1;
				break;
			case 12 : // increase mcha
				ExtendedProperties.get(this.player).psa
						.setChakraModifier(ExtendedProperties.get(this.player).psa
								.getChakraModifier() + 1);
				ExtendedProperties.get(this.player).psa.skillPoints -= 1;
				break;
			case 13 : // increase char
				if (ExtendedProperties.get(this.player).psa
						.getChakraRegenBonus() < 75) {
					ExtendedProperties.get(this.player).psa
							.setChakraRegenBonus(ExtendedProperties
									.get(this.player).psa.getChakraRegenBonus() + 1);
					ExtendedProperties.get(this.player).psa.skillPoints -= 1;
				}
				break;
			case 14 : // send changes
				NarutoCraft.netHandler
						.sendToServer(new PacketNinjaStatsRequest("set",
								ExtendedProperties.get(this.player).psa
										.getValues()));
				break;
			case 15 : // reset all
				NarutoCraft.netHandler
						.sendToServer(new PacketNinjaStatsRequest("reset",
								ExtendedProperties.get(this.player).psa
										.getValues()));
				break;
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		this.xSize = this.jutsuMenu ? 210 : 256;
		this.ySize = this.jutsuMenu ? 210 : 256;

		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(this.jutsuMenu
				? References.jutsuGUI[this.jutsuPage]
				: References.stats);
		drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize,
				this.ySize);

		this.buttonList.clear();
		// Start with main control buttons

		int x1 = this.guiLeft;
		int x2 = (this.guiLeft + this.xSize) - (22);
		int x3 = (x2 + x1) / 2;

		// Controls
		// Tabs
		this.buttonList.add(new GuiNinjaTab(0, x2, this.guiTop - 22,
				RegJutsus.Enmakugire.getIconFromDamage(0)));// Stats page
		this.buttonList.add(new GuiNinjaTab(1, x1, this.guiTop - 22,
				Items.apple.getIconFromDamage(0)));// Jutsu
		this.buttonList.add(new GuiNinjaTab(2, x1 + 22, this.guiTop - 22,
				Items.apple.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(3, x1 + (22 * 2), this.guiTop - 22,
				Items.apple.getIconFromDamage(0)));// Jutsu
		this.buttonList.add(new GuiNinjaTab(4, x1 + (22 * 3), this.guiTop - 22,
				Items.apple.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(5, x1 + (22 * 4), this.guiTop - 22,
				Items.apple.getIconFromDamage(0)));// Jutsu
		this.buttonList.add(new GuiNinjaTab(6, x1 + (22 * 5), this.guiTop - 22,
				Items.apple.getIconFromDamage(0)));

		// Stats
		ExtendedProperties props = ExtendedProperties.get(this.player);
		if (!this.jutsuMenu) {
			this.drawString(this.fontRendererObj,
					"Ninja Level: " + props.psa.getNinjaLevel(), this.guiLeft
							+ this.padLeft, (this.guiTop + this.padTop) - 9,
					0xddeeee);
			if (props.psa.skillPoints > 0) {
				this.drawString(this.fontRendererObj, "Skill Points: "
						+ props.psa.skillPoints, this.guiLeft + this.padLeft,
						this.guiTop + this.padTop, 0xddeeee);
			}
			Minecraft.getMinecraft().renderEngine
					.bindTexture(References.ninjaWidgets);
			drawTexturedModalRect(this.guiLeft + 132,
					(this.guiTop + this.padTop) - 7, 66, 0, 39, 4);
			drawTexturedModalRect(
					this.guiLeft + 132,
					(this.guiTop + this.padTop) - 7,
					66,
					4,
					(props.psa.getCurrentNinjaXp() * 39)
							/ props.psa.getNinjaXpCap(), 4);

			this.drawString(this.fontRendererObj, "Stats (3 points)",
					this.guiLeft + this.padLeft, this.guiTop + this.padTop
							+ (9 * 2), 0xddeeee);
			this.drawString(this.fontRendererObj, "Strength: ", this.guiLeft
					+ this.padLeft, this.guiTop + this.padTop + (9 * 3),
					0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getStrength(),
					this.guiLeft + this.padLeft + 110, this.guiTop
							+ this.padTop + (9 * 3), 0xddeeee);

			this.drawString(this.fontRendererObj, "Resistance: ", this.guiLeft
					+ this.padLeft, this.guiTop + this.padTop + (9 * 4),
					0xddeeee);
			this.drawString(this.fontRendererObj,
					"" + props.psa.getResistance(), this.guiLeft + this.padLeft
							+ 110, this.guiTop + this.padTop + (9 * 4),
					0xddeeee);

			this.drawString(this.fontRendererObj, "Dexterity: ", this.guiLeft
					+ this.padLeft, this.guiTop + this.padTop + (9 * 5),
					0xddeeee);
			this.drawString(this.fontRendererObj,
					"" + props.psa.getDexterity(), this.guiLeft + this.padLeft
							+ 110, this.guiTop + this.padTop + (9 * 5),
					0xddeeee);

			this.drawString(this.fontRendererObj, "Agility: ", this.guiLeft
					+ this.padLeft, this.guiTop + this.padTop + (9 * 6),
					0xddeeee);
			this.drawString(this.fontRendererObj, "" + props.psa.getAgility(),
					this.guiLeft + this.padLeft + 110, this.guiTop
							+ this.padTop + (9 * 6), 0xddeeee);

			// Level up Controls
			if (props.psa.skillPoints >= 3) {
				this.buttonList.add(new GuiNinjaButton(7, this.guiLeft
						+ this.padLeft + 125, this.guiTop + this.padTop
						+ (9 * 3), "plus"));
				this.buttonList.add(new GuiNinjaButton(8, this.guiLeft
						+ this.padLeft + 125, this.guiTop + this.padTop
						+ (9 * 4), "plus"));
				this.buttonList.add(new GuiNinjaButton(9, this.guiLeft
						+ this.padLeft + 125, this.guiTop + this.padTop
						+ (9 * 5), "plus"));
				this.buttonList.add(new GuiNinjaButton(10, this.guiLeft
						+ this.padLeft + 125, this.guiTop + this.padTop
						+ (9 * 6), "plus"));
			}

			this.drawString(this.fontRendererObj, "Training (1 point)",
					this.guiLeft + this.padLeft, this.guiTop + this.padTop
							+ (9 * 8), 0xddeeee);
			this.drawString(this.fontRendererObj, "Element Power: ",
					this.guiLeft + this.padLeft, this.guiTop + this.padTop
							+ (9 * 9), 0xddeeee);
			this.drawString(this.fontRendererObj,
					"" + props.psa.getElementPowerModifier(), this.guiLeft
							+ this.padLeft + 110, this.guiTop + this.padTop
							+ (9 * 9), 0xddeeee);

			this.drawString(this.fontRendererObj, "Max Chakra Bonus: ",
					this.guiLeft + this.padLeft, this.guiTop + this.padTop
							+ (9 * 10), 0xddeeee);
			this.drawString(this.fontRendererObj,
					"" + props.psa.getChakraModifier(), this.guiLeft
							+ this.padLeft + 110, this.guiTop + this.padTop
							+ (9 * 10), 0xddeeee);

			this.drawString(this.fontRendererObj, "Chakra Regen Bonus: ",
					this.guiLeft + this.padLeft, this.guiTop + this.padTop
							+ (9 * 11), 0xddeeee);
			this.drawString(this.fontRendererObj,
					"" + props.psa.getChakraRegenBonus(), this.guiLeft
							+ this.padLeft + 110, this.guiTop + this.padTop
							+ (9 * 11), 0xddeeee);

			// Level up Controls
			if (props.psa.skillPoints >= 1) {
				this.buttonList.add(new GuiNinjaButton(11, this.guiLeft
						+ this.padLeft + 125, this.guiTop + this.padTop
						+ (9 * 9), "plus"));
				this.buttonList.add(new GuiNinjaButton(12, this.guiLeft
						+ this.padLeft + 125, this.guiTop + this.padTop
						+ (9 * 10), "plus"));
				this.buttonList.add(new GuiNinjaButton(13, this.guiLeft
						+ this.padLeft + 125, this.guiTop + this.padTop
						+ (9 * 11), "plus"));
			}
			this.buttonList.add(new GuiButton(14, this.guiLeft + this.padLeft,
					this.guiTop + this.padTop + (9 * 13), 50, 20, "Save"));
			this.buttonList
					.add(new GuiButton(15, this.guiLeft + this.padLeft + 50,
							this.guiTop + this.padTop + (9 * 13), 50, 20,
							"Reset"));
		}
	}

	/** Keyboard Clicks **/
	@Override
	protected void keyTyped(char par1, int par2) {
		if ((par2 == 1)
				|| (par2 == this.mc.gameSettings.keyBindInventory.getKeyCode())) {
			this.mc.thePlayer.closeScreen();
		}
	}
}
