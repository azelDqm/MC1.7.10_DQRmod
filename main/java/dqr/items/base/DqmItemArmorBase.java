package dqr.items.base;

import java.text.NumberFormat;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dqr.DQR;
import dqr.api.Items.DQArmors;
import dqr.api.enums.EnumColor;

public class DqmItemArmorBase extends ItemArmor {

	private ItemArmor.ArmorMaterial myMaterial;
	private int deffencePoint;
	private boolean setEffectEnable = true;
	private static final int[] maxDamageArrayFix = new int[] {13, 16, 15, 14};
	private static final int[] maxDamageArray = new int[] {11, 16, 15, 13};

	public static final int ATK   = 1;
	public static final int DEF    = 2;
	public static final int MAG = 3;
	public static final int HP    = 4;
	public static final int MP    = 5;

	public DqmItemArmorBase(ItemArmor.ArmorMaterial material, int armorType, int defPoint)
	{
		super(material, 0, armorType);
		myMaterial = material;
		//deffencePoint = defPoint;
		//deffencePoint = this.calcDefPoint(defPoint, armorType);
		this.setMaxDamage(this.getDurabilityReCalc(material, armorType));
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
    	if(stack.getItem() == DQArmors.itemRotonokabuto) return "dqr:textures/armors/ROTO_1.png";
    	if(stack.getItem() == DQArmors.itemRotonoyoroi) return "dqr:textures/armors/ROTO_1.png";
    	if(stack.getItem() == DQArmors.itemRotonokote) return "dqr:textures/armors/ROTO_1.png";
    	if(stack.getItem() == DQArmors.itemRotonokutu) return "dqr:textures/armors/ROTO_2.png";
    	if(stack.getItem() == DQArmors.itemMetarukingnokabuto) return "dqr:textures/armors/METAL_1.png";
    	if(stack.getItem() == DQArmors.itemMetarukingnoyoroi) return "dqr:textures/armors/METAL_1.png";
    	if(stack.getItem() == DQArmors.itemMetarukingnokutu) return "dqr:textures/armors/METAL_1.png";
    	if(stack.getItem() == DQArmors.itemMetarukingnokote) return "dqr:textures/armors/METAL_2.png";
    	if(stack.getItem() == DQArmors.itemSabitakabuto) return "dqr:textures/armors/OLD_1.png";
    	if(stack.getItem() == DQArmors.itemSabitayoroi) return "dqr:textures/armors/OLD_1.png";
    	if(stack.getItem() == DQArmors.itemSabitakote) return "dqr:textures/armors/OLD_1.png";
    	if(stack.getItem() == DQArmors.itemSabitakutu) return "dqr:textures/armors/OLD_2.png";
    	if(stack.getItem() == DQArmors.itemHaganenokabuto) return "dqr:textures/armors/HAGANE_1.png";
    	if(stack.getItem() == DQArmors.itemHaganenoyoroi) return "dqr:textures/armors/HAGANE_1.png";
    	if(stack.getItem() == DQArmors.itemHaganenokote) return "dqr:textures/armors/HAGANE_1.png";
    	if(stack.getItem() == DQArmors.itemHaganenokutu) return "dqr:textures/armors/HAGANE_2.png";
    	if(stack.getItem() == DQArmors.itemKawanobousi) return "dqr:textures/armors/KAWA_1.png";
    	if(stack.getItem() == DQArmors.itemKawanoyoroi) return "dqr:textures/armors/KAWA_1.png";
    	if(stack.getItem() == DQArmors.itemKawanokote) return "dqr:textures/armors/KAWA_1.png";
    	if(stack.getItem() == DQArmors.itemKawanokutu) return "dqr:textures/armors/KAWA_2.png";
    	if(stack.getItem() == DQArmors.itemUrokonoyoroi) return "dqr:textures/armors/UROKO_1.png";
    	if(stack.getItem() == DQArmors.itemHonoonoyoroi) return "dqr:textures/armors/HONOO_1.png";
    	if(stack.getItem() == DQArmors.itemMirayoroi) return "dqr:textures/armors/MIRA_1.png";
    	if(stack.getItem() == DQArmors.itemYaibanoyoroi) return "dqr:textures/armors/YAIBA_1.png";
    	if(stack.getItem() == DQArmors.itemSinpinoyoroi) return "dqr:textures/armors/SINPI_1.png";
    	if(stack.getItem() == DQArmors.itemDoragonmeiru) return "dqr:textures/armors/DRAGON_1.png";
    	if(stack.getItem() == DQArmors.itemTenkuunoyoroi) return "dqr:textures/armors/TENKUUYOROI_1.png";
    	if(stack.getItem() == DQArmors.itemSuraimuhead) return "dqr:textures/armors/SURA_1.png";
    	if(stack.getItem() == DQArmors.itemSuraimunofuku) return "dqr:textures/armors/SURA_1.png";
    	if(stack.getItem() == DQArmors.itemNekomimibando) return "dqr:textures/armors/NEKO_1.png";
    	if(stack.getItem() == DQArmors.itemFantomumasuku) return "dqr:textures/armors/FANTOMU_1.png";
    	if(stack.getItem() == DQArmors.itemArakuremasuku) return "dqr:textures/armors/ARAKURE_1.png";
    	if(stack.getItem() == DQArmors.itemSuraimunokanmuriK) return "dqr:textures/armors/KING_1.png";
    	if(stack.getItem() == DQArmors.itemUsamimibando) return "dqr:textures/armors/BANI_1.png";
    	if(stack.getItem() == DQArmors.itemBanisutu) return "dqr:textures/armors/BANI_1.png";
    	if(stack.getItem() == DQArmors.itemAmitaitu) return "dqr:textures/armors/BANI_2.png";
    	if(stack.getItem() == DQArmors.itemHaihiru) return "dqr:textures/armors/BANI_1.png";
    	if(stack.getItem() == DQArmors.itemAbunaimizugiue) return "dqr:textures/armors/ABUNAI_1.png";
    	if(stack.getItem() == DQArmors.itemAbunaimizugisita) return "dqr:textures/armors/ABUNAI_2.png";
    	if(stack.getItem() == DQArmors.itemSiawasenobousi) return "dqr:textures/armors/SIAWASE_1.png";
    	if(stack.getItem() == DQArmors.itemSiawasenokutu) return "dqr:textures/armors/SIAWASE_1.png";
    	if(stack.getItem() == DQArmors.itemKenjanobousi) return "dqr:textures/armors/KENJA_1.png";
    	if(stack.getItem() == DQArmors.itemKenjanoroubu) return "dqr:textures/armors/KENJA_1.png";
    	if(stack.getItem() == DQArmors.itemKenjanotebukuro) return "dqr:textures/armors/KENJA_1.png";
    	if(stack.getItem() == DQArmors.itemKenjanokutu) return "dqr:textures/armors/KENJA_1.png";
    	if(stack.getItem() == DQArmors.itemSakuretto) return "dqr:textures/armors/KINU_1.png";
    	if(stack.getItem() == DQArmors.itemKinunoroubu) return "dqr:textures/armors/KINU_1.png";
    	if(stack.getItem() == DQArmors.itemKinunotebukuro) return "dqr:textures/armors/KINU_1.png";
    	if(stack.getItem() == DQArmors.itemSandaru) return "dqr:textures/armors/KINU_2.png";
    	if(stack.getItem() == DQArmors.itemMahounobousi) return "dqr:textures/armors/MAHOU_1.png";
    	if(stack.getItem() == DQArmors.itemMahounohoui) return "dqr:textures/armors/MAHOU_1.png";
    	if(stack.getItem() == DQArmors.itemMahounotebukuro) return "dqr:textures/armors/MAHOU_1.png";
    	if(stack.getItem() == DQArmors.itemMahounokutu) return "dqr:textures/armors/MAHOU_1.png";
    	if(stack.getItem() == DQArmors.itemRadatomukabuto) return "dqr:textures/armors/RADATOMU_1.png";
    	if(stack.getItem() == DQArmors.itemRadatomunoyoroi) return "dqr:textures/armors/RADATOMU_1.png";
    	if(stack.getItem() == DQArmors.itemRadatomugurobu) return "dqr:textures/armors/RADATOMU_1.png";
    	if(stack.getItem() == DQArmors.itemRadatomubutu) return "dqr:textures/armors/RADATOMU_2.png";
    	if(stack.getItem() == DQArmors.itemRoresiametto) return "dqr:textures/armors/RORESIA_1.png";
    	if(stack.getItem() == DQArmors.itemRoresianofuku) return "dqr:textures/armors/RORESIA_1.png";
    	if(stack.getItem() == DQArmors.itemRoresiagurobu) return "dqr:textures/armors/RORESIA_1.png";
    	if(stack.getItem() == DQArmors.itemRoresiabutu) return "dqr:textures/armors/RORESIA_1.png";
    	if(stack.getItem() == DQArmors.itemYuusyanokanmuri) return "dqr:textures/armors/YUUSYA_1.png";
    	if(stack.getItem() == DQArmors.itemYuusyanofuku) return "dqr:textures/armors/YUUSYA_1.png";
    	if(stack.getItem() == DQArmors.itemYusyanogurobu) return "dqr:textures/armors/YUUSYA_1.png";
    	if(stack.getItem() == DQArmors.itemYuusyanobutu) return "dqr:textures/armors/YUUSYA_2.png";
    	if(stack.getItem() == DQArmors.itemTenkuunokabuto) return "dqr:textures/armors/TENKUU_1.png";
    	if(stack.getItem() == DQArmors.itemTenkuunofuku) return "dqr:textures/armors/TENKUU_1.png";
    	if(stack.getItem() == DQArmors.itemTenkuunobutu) return "dqr:textures/armors/TENKUU_2.png";
    	if(stack.getItem() == DQArmors.itemTenkuunogurobu) return "dqr:textures/armors/TENKUU_2.png";
    	if(stack.getItem() == DQArmors.itemGurantaban) return "dqr:textures/armors/GURAN_1.png";
    	if(stack.getItem() == DQArmors.itemGuranbaniarobu) return "dqr:textures/armors/GURAN_1.png";
    	if(stack.getItem() == DQArmors.itemGuranbanianokutu) return "dqr:textures/armors/GURAN_1.png";
    	if(stack.getItem() == DQArmors.itemGuranbaniarisuto) return "dqr:textures/armors/GURAN_1.png";
    	if(stack.getItem() == DQArmors.itemRaiannokabuto) return "dqr:textures/armors/RAIAN_1.png";
    	if(stack.getItem() == DQArmors.itemRaiannoyoroi) return "dqr:textures/armors/RAIAN_1.png";
    	if(stack.getItem() == DQArmors.itemRaiannobutu) return "dqr:textures/armors/RAIAN_1.png";
    	if(stack.getItem() == DQArmors.itemRaiannogurobu) return "dqr:textures/armors/RAIAN_1.png";
    	if(stack.getItem() == DQArmors.itemSensinokabuto) return "dqr:textures/armors/SENSI_1.png";
    	if(stack.getItem() == DQArmors.itemSensinoyoroi) return "dqr:textures/armors/SENSI_1.png";
    	if(stack.getItem() == DQArmors.itemSensinogurobu) return "dqr:textures/armors/SENSI_1.png";
    	if(stack.getItem() == DQArmors.itemSensinobutu) return "dqr:textures/armors/SENSI_2.png";
    	if(stack.getItem() == DQArmors.itemRyuukisinokabuto) return "dqr:textures/armors/RYUUKISI_1.png";
    	if(stack.getItem() == DQArmors.itemRyuukisinoyoroi) return "dqr:textures/armors/RYUUKISI_1.png";
    	if(stack.getItem() == DQArmors.itemRyuukisinokote) return "dqr:textures/armors/RYUUKISI_1.png";
    	if(stack.getItem() == DQArmors.itemRyuukisinobutu) return "dqr:textures/armors/RYUUKISI_2.png";
    	if(stack.getItem() == DQArmors.itemPuratinaheddo) return "dqr:textures/armors/PURATINA_1.png";
    	if(stack.getItem() == DQArmors.itemPuratinameiru) return "dqr:textures/armors/PURATINA_1.png";
    	if(stack.getItem() == DQArmors.itemPuratinagantoretto) return "dqr:textures/armors/PURATINA_1.png";
    	if(stack.getItem() == DQArmors.itemPuratinaguribu) return "dqr:textures/armors/PURATINA_2.png";
    	if(stack.getItem() == DQArmors.itemMisuriruherumu) return "dqr:textures/armors/MISURIRU_1.png";
    	if(stack.getItem() == DQArmors.itemMisurirumeiru) return "dqr:textures/armors/MISURIRU_1.png";
    	if(stack.getItem() == DQArmors.itemMisuritugantoretto) return "dqr:textures/armors/MISURIRU_1.png";
    	if(stack.getItem() == DQArmors.itemMisuriruguribu) return "dqr:textures/armors/MISURIRU_2.png";
    	if(stack.getItem() == DQArmors.itemSinpannokabuto) return "dqr:textures/armors/SINWA_1.png";
    	if(stack.getItem() == DQArmors.itemSinwanoyoroi) return "dqr:textures/armors/SINWA_1.png";
    	if(stack.getItem() == DQArmors.itemTenteinobutu) return "dqr:textures/armors/SINWA_1.png";
    	if(stack.getItem() == DQArmors.itemAmaterasunokote) return "dqr:textures/armors/SINWA_2.png";
    	if(stack.getItem() == DQArmors.itemKeikoginobandana) return "dqr:textures/armors/KEIKOGI_1.png";
    	if(stack.getItem() == DQArmors.itemKeikogi) return "dqr:textures/armors/KEIKOGI_1.png";
    	if(stack.getItem() == DQArmors.itemKeikogisita) return "dqr:textures/armors/KEIKOGI_2.png";
    	if(stack.getItem() == DQArmors.itemKeikoginokutu) return "dqr:textures/armors/KEIKOGI_1.png";
    	if(stack.getItem() == DQArmors.itemSatorinowanpisu) return "dqr:textures/armors/SATORI_1.png";
    	if(stack.getItem() == DQArmors.itemSatorinokanmuri) return "dqr:textures/armors/SATORI_1.png";
    	if(stack.getItem() == DQArmors.itemSatorinotebukuro) return "dqr:textures/armors/SATORI_1.png";
    	if(stack.getItem() == DQArmors.itemSatorinokutu) return "dqr:textures/armors/SATORI_2.png";
    	if(stack.getItem() == DQArmors.itemBudoubandana) return "dqr:textures/armors/BUDOU_1.png";
    	if(stack.getItem() == DQArmors.itemBudougi) return "dqr:textures/armors/BUDOU_1.png";
    	if(stack.getItem() == DQArmors.itemBudougirisuto) return "dqr:textures/armors/BUDOU_2.png";
    	if(stack.getItem() == DQArmors.itemBudounokutu) return "dqr:textures/armors/BUDOU_1.png";
    	if(stack.getItem() == DQArmors.itemDaimadounobousi) return "dqr:textures/armors/DAIMADO_1.png";
    	if(stack.getItem() == DQArmors.itemDaimadounorobu) return "dqr:textures/armors/DAIMADO_1.png";
    	if(stack.getItem() == DQArmors.itemDaimadougurobu) return "dqr:textures/armors/DAIMADO_2.png";
    	if(stack.getItem() == DQArmors.itemDaimadounosyuzu) return "dqr:textures/armors/DAIMADO_1.png";
    	if(stack.getItem() == DQArmors.itemTabibitonofuku) return "dqr:textures/armors/TABI_1.png";
    	if(stack.getItem() == DQArmors.itemTabibitonotebukuro) return "dqr:textures/armors/TABI_2.png";
    	if(stack.getItem() == DQArmors.itemSinkannobousi) return "dqr:textures/armors/SINKAN_1.png";
    	if(stack.getItem() == DQArmors.itemSinkannoepuron) return "dqr:textures/armors/SINKAN_1.png";
    	if(stack.getItem() == DQArmors.itemSinkannogurobu) return "dqr:textures/armors/SINKAN_1.png";
    	if(stack.getItem() == DQArmors.itemSinkannobutu) return "dqr:textures/armors/SINKAN_1.png";
    	if(stack.getItem() == DQArmors.itemBusinnobandana) return "dqr:textures/armors/BUSIN_1.png";
    	if(stack.getItem() == DQArmors.itemBusinnobudougi) return "dqr:textures/armors/BUSIN_1.png";
    	if(stack.getItem() == DQArmors.itemBusinrisuto) return "dqr:textures/armors/BUSIN_1.png";
    	if(stack.getItem() == DQArmors.itemBusinnobutu) return "dqr:textures/armors/BUSIN_2.png";
    	if(stack.getItem() == DQArmors.itemBuounokutu) return "dqr:textures/armors/BUOU_1.png";
    	if(stack.getItem() == DQArmors.itemBuounohatigane) return "dqr:textures/armors/BUOU_1.png";
    	if(stack.getItem() == DQArmors.itemBuounoudeate) return "dqr:textures/armors/BUOU_2.png";
    	if(stack.getItem() == DQArmors.itemBuounosutu) return "dqr:textures/armors/BUOU_1.png";
    	if(stack.getItem() == DQArmors.itemKenpougiue) return "dqr:textures/armors/KENPOU_1.png";
    	if(stack.getItem() == DQArmors.itemKenpouginobando) return "dqr:textures/armors/KENPOU_1.png";
    	if(stack.getItem() == DQArmors.itemKenpougirisuto) return "dqr:textures/armors/KENPOU_1.png";
    	if(stack.getItem() == DQArmors.itemKenpouginokutu) return "dqr:textures/armors/KENPOU_2.png";
    	if(stack.getItem() == DQArmors.itemFusiginaborero) return "dqr:textures/armors/FUSIGI_1.png";
    	if(stack.getItem() == DQArmors.itemMadousinosandaru) return "dqr:textures/armors/MADOUSI_1.png";
    	if(stack.getItem() == DQArmors.itemOberonnokutu) return "dqr:textures/armors/OBERON_1.png";
    	if(stack.getItem() == DQArmors.itemSutekinasabo) return "dqr:textures/armors/SUTEKI_1.png";
    	if(stack.getItem() == DQArmors.itemMikawasinofuku) return "dqr:textures/armors/MIKAWASI_1.png";
    	if(stack.getItem() == DQArmors.itemRezamanto) return "dqr:textures/armors/REZA_1.png";
    	if(stack.getItem() == DQArmors.itemMizunohagoromo) return "dqr:textures/armors/MIZU_1.png";
    	if(stack.getItem() == DQArmors.itemKinobousi) return "dqr:textures/armors/KINOBOUSI_1.png";
    	if(stack.getItem() == DQArmors.itemSeijanokakarotto) return "dqr:textures/armors/SEIJA_1.png";
    	if(stack.getItem() == DQArmors.itemSeijanohoui) return "dqr:textures/armors/SEIJA_1.png";
    	if(stack.getItem() == DQArmors.itemSeijanotaitu) return "dqr:textures/armors/SEIJA_2.png";
    	if(stack.getItem() == DQArmors.itemSeijanobutu) return "dqr:textures/armors/SEIJA_1.png";
    	if(stack.getItem() == DQArmors.itemDoragonrobu) return "dqr:textures/armors/DRADONROBU_1.png";
    	if(stack.getItem() == DQArmors.itemSefiramurobu) return "dqr:textures/armors/SERAFIMU_1.png";
    	if(stack.getItem() == DQArmors.itemDansanohanekazaribando) return "dqr:textures/armors/DANSA_1.png";
    	if(stack.getItem() == DQArmors.itemDansanosyatu) return "dqr:textures/armors/DANSA_1.png";
    	if(stack.getItem() == DQArmors.itemDansanozubon) return "dqr:textures/armors/DANSA_1.png";
    	if(stack.getItem() == DQArmors.itemDansanobutu) return "dqr:textures/armors/DANSA_2.png";
    	if(stack.getItem() == DQArmors.itemOdorikonokamikazari) return "dqr:textures/armors/ODORIKO_1.png";
    	if(stack.getItem() == DQArmors.itemOdorikonofuku) return "dqr:textures/armors/ODORIKO_1.png";
    	if(stack.getItem() == DQArmors.itemOdorikononisokkusu) return "dqr:textures/armors/ODORIKO_2.png";
    	if(stack.getItem() == DQArmors.itemOdorikonomyuru) return "dqr:textures/armors/ODORIKO_1.png";
    	if(stack.getItem() == DQArmors.itemPurinsesutexiara) return "dqr:textures/armors/PURIN_1.png";
    	if(stack.getItem() == DQArmors.itemPurinsesurobu) return "dqr:textures/armors/PURIN_1.png";
    	if(stack.getItem() == DQArmors.itemPurinsesugurobu) return "dqr:textures/armors/PURIN_1.png";
    	if(stack.getItem() == DQArmors.itemPurinsesuhiru) return "dqr:textures/armors/PURIN_2.png";
    	if(stack.getItem() == DQArmors.itemStarhatto) return "dqr:textures/armors/STAR_1.png";
    	if(stack.getItem() == DQArmors.itemStarnasutu) return "dqr:textures/armors/STAR_1.png";
    	if(stack.getItem() == DQArmors.itemStarzubon) return "dqr:textures/armors/STAR_2.png";
    	if(stack.getItem() == DQArmors.itemStarbutu) return "dqr:textures/armors/STAR_1.png";

    	return "";
   }

    public int getDefPoint()
    {
    	return this.deffencePoint;
    }

    public int getDurabilityReCalc(ItemArmor.ArmorMaterial material, int armorType)
    {
    	this.deffencePoint = calcDefPoint((material.getDurability(armorType) / this.maxDamageArray[armorType] / 100), armorType);
        return material.getDurability(armorType) / this.maxDamageArray[armorType] * this.maxDamageArrayFix[armorType];
    }

    public void setSetEffectEnable(boolean par1)
    {
    	this.setEffectEnable = par1;
    }

    public int calcDefPoint(int def, int armporType)
    {
    	int calcDef = 0;
    	switch(armporType)
    	{
    		case 0: calcDef = def - 2; break;
    		case 1: calcDef = def; break;
    		case 2: calcDef = def - 1; break;
    		case 3: calcDef = def - 2; break;
    		default: calcDef = 0; break;
    	}

    	if(calcDef < 1)
    	{
    		calcDef = 1;
    	}
    	return calcDef;
    }

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {

    	int[] setEffect;
    	String color = "";

    	p_77624_3_.add("");
    	p_77624_3_.add(I18n.format("dqm.iteminfo.deffence", new Object[]{this.deffencePoint}));

    	color = setEffectEnable ? EnumColor.White.getChatColor() :EnumColor.DarkGray.getChatColor();
    	setEffect = DQR.armorSetEffect.getArmorSetEffect(myMaterial, new ItemStack[]{p_77624_1_});

    	if(setEffect[0] > 0)
    	{
    		p_77624_3_.add("");
    		p_77624_3_.add(color + I18n.format("dqm.iteminfo.setEffect.tile") + ":" + I18n.format("dqm.iteminfo.setEffect." + myMaterial.name()));
    		if(setEffect[HP] > 0) p_77624_3_.add(color + I18n.format("dqm.iteminfo.setEffect.HP", new Object[]{setEffect[HP]}));
    		if(setEffect[MP] > 0) p_77624_3_.add(color + I18n.format("dqm.iteminfo.setEffect.MP", new Object[]{setEffect[MP]}));
    		if(setEffect[ATK] > 0) p_77624_3_.add(color + I18n.format("dqm.iteminfo.setEffect.ATK", new Object[]{setEffect[ATK]}));
    		if(setEffect[MAG] > 0) p_77624_3_.add(color + I18n.format("dqm.iteminfo.setEffect.MAG", new Object[]{setEffect[MAG]}));
    		if(setEffect[DEF] > 0) p_77624_3_.add(color + I18n.format("dqm.iteminfo.setEffect.DEF", new Object[]{setEffect[DEF]}));
    	}

    	NBTTagCompound nbt = p_77624_1_.getTagCompound();
    	if(nbt != null)
    	{
    		NumberFormat nfNum = NumberFormat.getNumberInstance();
    		int medalVal = nbt.getInteger("medalking");
    		//System.out.println("TEST:" + medalVal);
    		if(medalVal > 0)
    		{

        		String medalValue = I18n.format("msg.medalking.item.txt", new Object[]{medalVal});

    			p_77624_3_.add(medalValue);
    		}

    		int coinVal = nbt.getInteger("casinocoin");
    		//System.out.println("TEST:" + medalVal);
    		if(coinVal > 0)
    		{

        		String medalValue = I18n.format("msg.casinocoin.item.txt", new Object[]{nfNum.format(coinVal)});

    			p_77624_3_.add(medalValue);
    		}

    		int itemPrice = nbt.getInteger("ItemPrice");
    		itemPrice = DQR.calcPlayerStatus.calcShoninGold(itemPrice, p_77624_2_);
    		//System.out.println("TEST:" + medalVal);
    		if(itemPrice > 0)
    		{

        		String itmPrice = I18n.format("msg.itemprice.item.txt", new Object[]{nfNum.format(itemPrice)});

    			p_77624_3_.add(itmPrice);
    		}
    	}
    }
/*
    public ArmorMaterial getMaterial()
    {
    	return this.myMaterial;
    }
    */

}
