package dqr.entity.mobEntity.monsterMetaru;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQArmors;
import dqr.api.Items.DQEmblems;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQWeapons;
import dqr.api.enums.EnumDqmMonster;

public class DqmEntityHaguremetaruking extends DqmMobBaseMetaru
{

	public DqmEntityHaguremetaruking(World world)
	{
		super(world, EnumDqmMonster.HAGUREMETARUKING );

		//this.monsterType = EnumDqmMonster.HAGUREMETARUKING;

		/*
		this.MobClassName = this.monsterType.getMobClassName();
		this.MobName = this.monsterType.getMobName();
		this.MobCateg = this.monsterType.getMobCateg();
		this.DqmMobEXP = DQR.funcMob.getCalcEXP(this.monsterType.getEXP());
		this.DqmMobGOLD = DQR.funcMob.getCalcGOLD(this.monsterType.getGOLD());
		this.DqmMobMP = this.monsterType.getMP();
		this.DqmMobPW = DQR.funcMob.getCalcPW(this.monsterType.getPW());
		this.DqmMobDEF = this.monsterType.getDF();
		this.CFIRE = this.monsterType.isCFIRE();
		this.CPET = this.monsterType.getCPET();
		this.CAI = this.monsterType.isCAI();
		this.CTENSEI = this.monsterType.getCTENSEI();
		this.CTENSEIsp = DQR.funcMob.getCalcTENSEIsp(this.monsterType.getCTENSEIsp());
		this.KougekiPat = this.monsterType.getKougekiPat();
		this.TenseiMob = this.monsterType.getTenseiMob();
		this.TenseiMin = this.monsterType.getTenseiMin();
		this.TenseiMax = this.monsterType.getTenseiMax();
		this.MobRoot = this.monsterType.getMobRoot();
		this.KakuseiMob = this.monsterType.getKakuseiMob();


		this.experienceValue = this.monsterType.getXPS();
		*/

	}

	/*
	 * AIを使うかどうか.
	 * 今回は使うのでtrueを返している.
	 */
	@Override
	public boolean isAIEnabled()
	{
		return EnumDqmMonster.HAGUREMETARUKING.isCAI();
	}

	/*
	 * このEntityに性質を付与する.
	 * 今回は移動速度を変更.
	 */
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(DQR.funcMob.getCalcSPEED(EnumDqmMonster.HAGUREMETARUKING.getSPEED()));
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(DQR.funcMob.getCalcHP(EnumDqmMonster.HAGUREMETARUKING.getHP()));
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(DQR.funcMob.getCalcPW(EnumDqmMonster.HAGUREMETARUKING.getPW()));
	}

	@Override
    public int getTotalArmorValue()
    {
        return EnumDqmMonster.HAGUREMETARUKING.getDF();
    }



	@Override
    protected void dropFewItems(boolean par1, int par2)
    {
        if (DQR.funcMob.getCalcDROP(1, 1))
        {
            this.dropItem(DQMiscs.itemKingdaiya, 1);
        }
        if (DQR.funcMob.getCalcDROP(2, 1))
        {
            this.dropItem(DQMiscs.itemKingdaiya, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemKingdaiya, 1);
        }
        if (DQR.funcMob.getCalcDROP(1, 1))
        {
            this.dropItem(DQMiscs.itemMetaru, 1);
        }
        if (DQR.funcMob.getCalcDROP(2, 1))
        {
            this.dropItem(DQMiscs.itemMetaru, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemMetaru, 1);
        }
        if (DQR.funcMob.getCalcDROP(4, 1))
        {
            this.dropItem(DQMiscs.itemMetaru, 1);
        }
        if (DQR.funcMob.getCalcDROP(5, 1))
        {
            this.dropItem(DQMiscs.itemMetaru, 1);
        }
        if (DQR.funcMob.getCalcDROP(6, 1))
        {
            this.dropItem(DQMiscs.itemMetaru, 1);
        }
        if (DQR.funcMob.getCalcDROP(7, 1))
        {
            this.dropItem(DQMiscs.itemMetaru, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemKingdaiya, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemKinkai, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemMetaru, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQIngots.itemMisriru, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQIngots.itemPuratina, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(Items.diamond, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemKingdaiya, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemKinkai, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemMetaru, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQIngots.itemMisriru, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQIngots.itemPuratina, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(Items.diamond, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemKingdaiya, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemKinkai, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemMetaru, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQIngots.itemMisriru, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQIngots.itemPuratina, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(Items.diamond, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemKingdaiya, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemKinkai, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemMetaru, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQIngots.itemMisriru, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQIngots.itemPuratina, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(Items.diamond, 1);
        }
        if (DQR.funcMob.getCalcDROP(20, 1))
        {
            this.dropItem(DQIngots.itemHikarinoisi, 1);
        }
        if (DQR.funcMob.getCalcDROP(80, 1))
        {
            this.dropItem(DQWeapons.itemMetarukingnoturugi, 1);
        }
        if (DQR.funcMob.getCalcDROP(80, 1))
        {
            this.dropItem(DQArmors.itemMetarukingnokabuto, 1);
        }
        if (DQR.funcMob.getCalcDROP(80, 1))
        {
            this.dropItem(DQArmors.itemMetarukingnoyoroi, 1);
        }
        if (DQR.funcMob.getCalcDROP(80, 1))
        {
            this.dropItem(DQArmors.itemMetarukingnokote, 1);
        }
        if (DQR.funcMob.getCalcDROP(80, 1))
        {
            this.dropItem(DQArmors.itemMetarukingnokutu, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemLittlemedal, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemLittlemedal, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemLittlemedal, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemLittlemedal, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemLittlemedal, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemLittlemedal, 1);
        }
        if (DQR.funcMob.getCalcDROP(3, 1))
        {
            this.dropItem(DQMiscs.itemLittlemedal, 1);
        }
        if (DQR.funcMob.getCalcDROP(10, 1))
        {
            this.dropItem(DQMiscs.itemLittlemedal5, 1);
        }
        if (DQR.funcMob.getCalcDROP(30, 1))
        {
        	this.dropItem(DQEmblems.itemEmbHaguremetal, 1);
        }
        if (DQR.funcMob.getCalcDROP(50, 1))
        {
            this.dropItem(DQMiscs.itemLittlemedal, 1);
        }
        if (DQR.funcMob.getCalcDROP(50, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori0, 1);
        }
        if (DQR.funcMob.getCalcDROP(100, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori1, 1);
        }
        if (DQR.funcMob.getCalcDROP(200, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori2, 1);
        }
        if (DQR.funcMob.getCalcDROP(400, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori3, 1);
        }
        if (DQR.funcMob.getCalcDROP(800, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori4, 1);
        }
        if (DQR.funcMob.getCalcDROP(1600, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori5, 1);
        }
        if (DQR.funcMob.getCalcDROP(3200, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori6, 1);
        }
        if (DQR.funcMob.getCalcDROP(6400, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori7, 1);
        }
        if (DQR.funcMob.getCalcDROP(12800, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori8, 1);
        }
        if (DQR.funcMob.getCalcDROP(25600, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori9, 1);
        }
        if (DQR.funcMob.getCalcDROP(51200, 1))
        {
            this.dropItem(DQMiscs.itemMegaminoinori10, 1);
        }
        if (DQR.funcMob.getCalcDROP(3000, 1))
        {
            this.dropItem(DQArmors.itemSabitakabuto, 1);
        }
        if (DQR.funcMob.getCalcDROP(3000, 1))
        {
            this.dropItem(DQArmors.itemSabitakabuto, 1);
        }
        if (DQR.funcMob.getCalcDROP(3000, 1))
        {
            this.dropItem(DQArmors.itemSabitakote, 1);
        }
        if (DQR.funcMob.getCalcDROP(3000, 1))
        {
            this.dropItem(DQArmors.itemSabitakutu, 1);
        }
    }
}

