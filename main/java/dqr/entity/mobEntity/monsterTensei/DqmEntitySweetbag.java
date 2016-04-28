package dqr.entity.mobEntity.monsterTensei;

import java.util.Random;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumDqmMonster;

public class DqmEntitySweetbag extends DqmMobBaseTensei
{

	public DqmEntitySweetbag(World world)
	{
		super(world, EnumDqmMonster.SWEETBAG );

		//this.monsterType = EnumDqmMonster.SWEETBAG;

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
		return EnumDqmMonster.SWEETBAG.isCAI();
	}

	/*
	 * このEntityに性質を付与する.
	 * 今回は移動速度を変更.
	 */
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(DQR.funcMob.getCalcSPEED(EnumDqmMonster.SWEETBAG.getSPEED()));
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(DQR.funcMob.getCalcHP(EnumDqmMonster.SWEETBAG.getHP()));
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(DQR.funcMob.getCalcPW(EnumDqmMonster.SWEETBAG.getPW()));
	}

	@Override
    public int getTotalArmorValue()
    {
        return EnumDqmMonster.SWEETBAG.getDF();
    }

	@Override
    protected void dropFewItems(boolean par1, int par2)
    {
		Item dropItem = null;

		Random rand = new Random();

		switch(rand.nextInt(22))
		{
			case 0: dropItem = DQMiscs.itemBougu; break;
			case 1: dropItem = DQMiscs.itemDensetu; break;
			case 2: dropItem = DQMiscs.itemHakai; break;
			case 3: dropItem = DQMiscs.itemHonooRyuu; break;
			case 4: dropItem = DQMiscs.itemKenTanken; break;
			case 5: dropItem = DQMiscs.itemTanken; break;
			case 6: dropItem = DQMiscs.itemKooriMetaru; break;
			case 7: dropItem = DQMiscs.itemMahou; break;
			case 8: dropItem = DQMiscs.itemMaJu; break;
			case 9: dropItem = DQMiscs.itemOnoTutiKon; break;
			case 10: dropItem = DQMiscs.itemTuti; break;
			case 11: dropItem = DQMiscs.itemKon; break;
			case 12: dropItem = DQMiscs.itemTenkuu; break;
			case 13: dropItem = DQMiscs.itemYariMutiTume; break;
			case 14: dropItem = DQMiscs.itemMuti; break;
			case 15: dropItem = DQMiscs.itemTume; break;
			case 16: dropItem = DQMiscs.itemYumiNage; break;
			case 17: dropItem = DQMiscs.itemNage; break;
			case 18: dropItem = DQMiscs.itemSorobanR; break;
			case 19: dropItem = DQMiscs.itemOugiR; break;
		}

		if(dropItem != null)
		{
			this.dropItem(dropItem, 1);
		}

		dropItem = null;

		switch(rand.nextInt(22))
		{
			case 0: dropItem = DQMiscs.itemBougu; break;
			case 1: dropItem = DQMiscs.itemDensetu; break;
			case 2: dropItem = DQMiscs.itemHakai; break;
			case 3: dropItem = DQMiscs.itemHonooRyuu; break;
			case 4: dropItem = DQMiscs.itemKenTanken; break;
			case 5: dropItem = DQMiscs.itemTanken; break;
			case 6: dropItem = DQMiscs.itemKooriMetaru; break;
			case 7: dropItem = DQMiscs.itemMahou; break;
			case 8: dropItem = DQMiscs.itemMaJu; break;
			case 9: dropItem = DQMiscs.itemOnoTutiKon; break;
			case 10: dropItem = DQMiscs.itemTuti; break;
			case 11: dropItem = DQMiscs.itemKon; break;
			case 12: dropItem = DQMiscs.itemTenkuu; break;
			case 13: dropItem = DQMiscs.itemYariMutiTume; break;
			case 14: dropItem = DQMiscs.itemMuti; break;
			case 15: dropItem = DQMiscs.itemTume; break;
			case 16: dropItem = DQMiscs.itemYumiNage; break;
			case 17: dropItem = DQMiscs.itemNage; break;
			case 18: dropItem = DQMiscs.itemSorobanR; break;
			case 19: dropItem = DQMiscs.itemOugiR; break;
		}

		if(dropItem != null)
		{
			this.dropItem(dropItem, 1);
		}

		dropItem = null;

		switch(rand.nextInt(22))
		{
			case 0: dropItem = DQMiscs.itemBougu; break;
			case 1: dropItem = DQMiscs.itemDensetu; break;
			case 2: dropItem = DQMiscs.itemHakai; break;
			case 3: dropItem = DQMiscs.itemHonooRyuu; break;
			case 4: dropItem = DQMiscs.itemKenTanken; break;
			case 5: dropItem = DQMiscs.itemTanken; break;
			case 6: dropItem = DQMiscs.itemKooriMetaru; break;
			case 7: dropItem = DQMiscs.itemMahou; break;
			case 8: dropItem = DQMiscs.itemMaJu; break;
			case 9: dropItem = DQMiscs.itemOnoTutiKon; break;
			case 10: dropItem = DQMiscs.itemTuti; break;
			case 11: dropItem = DQMiscs.itemKon; break;
			case 12: dropItem = DQMiscs.itemTenkuu; break;
			case 13: dropItem = DQMiscs.itemYariMutiTume; break;
			case 14: dropItem = DQMiscs.itemMuti; break;
			case 15: dropItem = DQMiscs.itemTume; break;
			case 16: dropItem = DQMiscs.itemYumiNage; break;
			case 17: dropItem = DQMiscs.itemNage; break;
			case 18: dropItem = DQMiscs.itemSorobanR; break;
			case 19: dropItem = DQMiscs.itemOugiR; break;
		}

		if(dropItem != null)
		{
			this.dropItem(dropItem, 1);
		}

		dropItem = null;

    }

}
