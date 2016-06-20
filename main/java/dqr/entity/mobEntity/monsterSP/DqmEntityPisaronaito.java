package dqr.entity.mobEntity.monsterSP;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumDqmMonster;

public class DqmEntityPisaronaito extends DqmMobBaseSP
{

	public DqmEntityPisaronaito(World world)
	{
		super(world, EnumDqmMonster.PISARONAITO );

		//this.monsterType = EnumDqmMonster.PISARONAITO;

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
		return EnumDqmMonster.PISARONAITO.isCAI();
	}

	/*
	 * このEntityに性質を付与する.
	 * 今回は移動速度を変更.
	 */
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(DQR.funcMob.getCalcSPEED(EnumDqmMonster.PISARONAITO.getSPEED()));
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(DQR.funcMob.getCalcHP(EnumDqmMonster.PISARONAITO.getHP()));
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(DQR.funcMob.getCalcPW(EnumDqmMonster.PISARONAITO.getPW()));
	}

	@Override
    public int getTotalArmorValue()
    {
        return EnumDqmMonster.PISARONAITO.getDF();
    }

	@Override
    protected void dropFewItems(boolean par1, int par2)
    {
        if (DQR.funcMob.getCalcDROP(8, 1))
        {
            this.dropItem(DQMiscs.itemKenTanken, 1);
        }
        if (DQR.funcMob.getCalcDROP(4, 1))
        {
            this.dropItem(DQMiscs.itemBougu, 1);
        }
        if (DQR.funcMob.getCalcDROP(20, 1))
        {
            this.dropItem(DQMiscs.itemTenkuu, 1);
        }
    }

}