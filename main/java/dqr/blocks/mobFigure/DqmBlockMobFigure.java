package dqr.blocks.mobFigure;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.api.Blocks.DQMobFigures;
import dqr.blocks.mobFigure.tileEntity.*;

public class DqmBlockMobFigure extends BlockContainer
{
    public static String setmodel;
    private String model;
    private float rotationYaw;

    public DqmBlockMobFigure(Material var2)
    {
        super(var2);
        //光源
        //this.setLightValue(3.0F);
        //キューブサイズ
        //this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    //1で光を通す 0で通さない
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
    //trueで地面が透ける
    public boolean isOpaqueCube()
    {
        return false;
    }
    //trueでサイズ変更時もキューブサイズを維持する(炎が置ける) falseでサイズに合わせる
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    //フラワー系ののようにアイコンをレンダー -1は透明 10で階段
    public int getRenderType()
    {
        return -1;
    }
    //アイコン
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:BukiyaB");
    }

    //TileEntityの指定
    public TileEntity createNewTileEntity(World var1, int par2)
    {
        //if(model == "000000000"){return new DqmTileEntity000000000();}
        //return new DqmTileEntityBukiya();
    	if(this == DQMobFigures.BlockFigureAkairai)
    	{
    		return new DqmTileEntityFigureAkairai();
    	}else if(this == DQMobFigures.BlockFigureAkumanosyo)
    	{
    		return new DqmTileEntityFigureAkumanosyo();
    	}else if(this == DQMobFigures.BlockFigureAkumanotubo)
    	{
    		return new DqmTileEntityFigureAkumanotubo();
    	}else if(this == DQMobFigures.BlockFigureAnimaruzonbi)
    	{
    		return new DqmTileEntityFigureAnimaruzonbi();
    	}else if(this == DQMobFigures.BlockFigureAnkokumajin)
    	{
    		return new DqmTileEntityFigureAnkokumajin();
    	}else if(this == DQMobFigures.BlockFigureAroinpu)
    	{
    		return new DqmTileEntityFigureAroinpu();
    	}else if(this == DQMobFigures.BlockFigureArukemisuton)
    	{
    		return new DqmTileEntityFigureArukemisuton();
    	}else if(this == DQMobFigures.BlockFigureArumiraji)
    	{
    		return new DqmTileEntityFigureArumiraji();
    	}else if(this == DQMobFigures.BlockFigureAtorasu)
    	{
    		return new DqmTileEntityFigureAtorasu();
    	}else if(this == DQMobFigures.BlockFigureAxedoragon)
    	{
    		return new DqmTileEntityFigureAxedoragon();
    	}else if(this == DQMobFigures.BlockFigureAyasiikage)
    	{
    		return new DqmTileEntityFigureAyasiikage();
    	}else if(this == DQMobFigures.BlockFigureBaburin)
    	{
    		return new DqmTileEntityFigureBaburin();
    	}else if(this == DQMobFigures.BlockFigureBaburuking)
    	{
    		return new DqmTileEntityFigureBaburuking();
    	}else if(this == DQMobFigures.BlockFigureBakudanbebi)
    	{
    		return new DqmTileEntityFigureBakudanbebi();
    	}else if(this == DQMobFigures.BlockFigureBakudaniwa)
    	{
    		return new DqmTileEntityFigureBakudaniwa();
    	}else if(this == DQMobFigures.BlockFigureBarakku)
    	{
    		return new DqmTileEntityFigureBarakku();
    	}else if(this == DQMobFigures.BlockFigureBariidodog)
    	{
    		return new DqmTileEntityFigureBariidodog();
    	}else if(this == DQMobFigures.BlockFigureBassaimasin)
    	{
    		return new DqmTileEntityFigureBassaimasin();
    	}else if(this == DQMobFigures.BlockFigureBatorurex)
    	{
    		return new DqmTileEntityFigureBatorurex();
    	}else if(this == DQMobFigures.BlockFigureBazuzu)
    	{
    		return new DqmTileEntityFigureBazuzu();
    	}else if(this == DQMobFigures.BlockFigureBebingosatan)
    	{
    		return new DqmTileEntityFigureBebingosatan();
    	}else if(this == DQMobFigures.BlockFigureBebisatan)
    	{
    		return new DqmTileEntityFigureBebisatan();
    	}else if(this == DQMobFigures.BlockFigureBehoimisuraimu)
    	{
    		return new DqmTileEntityFigureBehoimisuraimu();
    	}else if(this == DQMobFigures.BlockFigureBehoimusuraimu)
    	{
    		return new DqmTileEntityFigureBehoimusuraimu();
    	}else if(this == DQMobFigures.BlockFigureBehomasuraimu)
    	{
    		return new DqmTileEntityFigureBehomasuraimu();
    	}else if(this == DQMobFigures.BlockFigureBerobero)
    	{
    		return new DqmTileEntityFigureBerobero();
    	}else if(this == DQMobFigures.BlockFigureBeronyaago)
    	{
    		return new DqmTileEntityFigureBeronyaago();
    	}else if(this == DQMobFigures.BlockFigureBesuking)
    	{
    		return new DqmTileEntityFigureBesuking();
    	}else if(this == DQMobFigures.BlockFigureBigCrow)
    	{
    		return new DqmTileEntityFigureBigCrow();
    	}else if(this == DQMobFigures.BlockFigureBiggufeisu)
    	{
    		return new DqmTileEntityFigureBiggufeisu();
    	}else if(this == DQMobFigures.BlockFigureBigguhatto)
    	{
    		return new DqmTileEntityFigureBigguhatto();
    	}else if(this == DQMobFigures.BlockFigureBiggumoai)
    	{
    		return new DqmTileEntityFigureBiggumoai();
    	}else if(this == DQMobFigures.BlockFigureBighanma)
    	{
    		return new DqmTileEntityFigureBighanma();
    	}else if(this == DQMobFigures.BlockFigureBosutororu)
    	{
    		return new DqmTileEntityFigureBosutororu();
    	}else if(this == DQMobFigures.BlockFigureBoureikensi)
    	{
    		return new DqmTileEntityFigureBoureikensi();
    	}else if(this == DQMobFigures.BlockFigureBubsura)
    	{
    		return new DqmTileEntityFigureBubsura();
    	}else if(this == DQMobFigures.BlockFigureBuchunpa)
    	{
    		return new DqmTileEntityFigureBuchunpa();
    	}else if(this == DQMobFigures.BlockFigureBuraddihando)
    	{
    		return new DqmTileEntityFigureBuraddihando();
    	}else if(this == DQMobFigures.BlockFigureBuraddosodo)
    	{
    		return new DqmTileEntityFigureBuraddosodo();
    	}else if(this == DQMobFigures.BlockFigureBurakkubejita)
    	{
    		return new DqmTileEntityFigureBurakkubejita();
    	}else if(this == DQMobFigures.BlockFigureBurasu)
    	{
    		return new DqmTileEntityFigureBurasu();
    	}else if(this == DQMobFigures.BlockFigureBurauni)
    	{
    		return new DqmTileEntityFigureBurauni();
    	}else if(this == DQMobFigures.BlockFigureBurizado)
    	{
    		return new DqmTileEntityFigureBurizado();
    	}else if(this == DQMobFigures.BlockFigureButisuraimu)
    	{
    		return new DqmTileEntityFigureButisuraimu();
    	}else if(this == DQMobFigures.BlockFigureButtizukinya)
    	{
    		return new DqmTileEntityFigureButtizukinya();
    	}else if(this == DQMobFigures.BlockFigureDaiyamondosuraimu)
    	{
    		return new DqmTileEntityFigureDaiyamondosuraimu();
    	}else if(this == DQMobFigures.BlockFigureDakuhobitto)
    	{
    		return new DqmTileEntityFigureDakuhobitto();
    	}else if(this == DQMobFigures.BlockFigureDakunaito)
    	{
    		return new DqmTileEntityFigureDakunaito();
    	}else if(this == DQMobFigures.BlockFigureDansunidoru)
    	{
    		return new DqmTileEntityFigureDansunidoru();
    	}else if(this == DQMobFigures.BlockFigureDarkRamia)
    	{
    		return new DqmTileEntityFigureDarkRamia();
    	}else if(this == DQMobFigures.BlockFigureDarkslime)
    	{
    		return new DqmTileEntityFigureDarkslime();
    	}else if(this == DQMobFigures.BlockFigureDarktororu)
    	{
    		return new DqmTileEntityFigureDarktororu();
    	}else if(this == DQMobFigures.BlockFigureDasudragon)
    	{
    		return new DqmTileEntityFigureDasudragon();
    	}else if(this == DQMobFigures.BlockFigureDebirurodo)
    	{
    		return new DqmTileEntityFigureDebirurodo();
    	}else if(this == DQMobFigures.BlockFigureDeddopekka)
    	{
    		return new DqmTileEntityFigureDeddopekka();
    	}else if(this == DQMobFigures.BlockFigureDenga)
    	{
    		return new DqmTileEntityFigureDenga();
    	}else if(this == DQMobFigures.BlockFigureDesufuratta)
    	{
    		return new DqmTileEntityFigureDesufuratta();
    	}else if(this == DQMobFigures.BlockFigureDesujakkaru)
    	{
    		return new DqmTileEntityFigureDesujakkaru();
    	}else if(this == DQMobFigures.BlockFigureDesunyago)
    	{
    		return new DqmTileEntityFigureDesunyago();
    	}else if(this == DQMobFigures.BlockFigureDesupisaro1)
    	{
    		return new DqmTileEntityFigureDesupisaro1();
    	}else if(this == DQMobFigures.BlockFigureDesupisaro2)
    	{
    		return new DqmTileEntityFigureDesupisaro2();
    	}else if(this == DQMobFigures.BlockFigureDesupisaro3)
    	{
    		return new DqmTileEntityFigureDesupisaro3();
    	}else if(this == DQMobFigures.BlockFigureDesusutoka)
    	{
    		return new DqmTileEntityFigureDesusutoka();
    	}else if(this == DQMobFigures.BlockFigureDgizumo)
    	{
    		return new DqmTileEntityFigureDgizumo();
    	}else if(this == DQMobFigures.BlockFigureDokuroarai)
    	{
    		return new DqmTileEntityFigureDokuroarai();
    	}else if(this == DQMobFigures.BlockFigureDokuyazukin)
    	{
    		return new DqmTileEntityFigureDokuyazukin();
    	}else if(this == DQMobFigures.BlockFigureDollmaster)
    	{
    		return new DqmTileEntityFigureDollmaster();
    	}else if(this == DQMobFigures.BlockFigureDoragonsoruja)
    	{
    		return new DqmTileEntityFigureDoragonsoruja();
    	}else if(this == DQMobFigures.BlockFigureDoraki)
    	{
    		return new DqmTileEntityFigureDoraki();
    	}else if(this == DQMobFigures.BlockFigureDorakima)
    	{
    		return new DqmTileEntityFigureDorakima();
    	}else if(this == DQMobFigures.BlockFigureDoroningyou)
    	{
    		return new DqmTileEntityFigureDoroningyou();
    	}else if(this == DQMobFigures.BlockFigureDoronuba)
    	{
    		return new DqmTileEntityFigureDoronuba();
    	}else if(this == DQMobFigures.BlockFigureDorozara)
    	{
    		return new DqmTileEntityFigureDorozara();
    	}else if(this == DQMobFigures.BlockFigureDoruido)
    	{
    		return new DqmTileEntityFigureDoruido();
    	}else if(this == DQMobFigures.BlockFigureDqmdragon)
    	{
    		return new DqmTileEntityFigureDqmdragon();
    	}else if(this == DQMobFigures.BlockFigureDragometaru)
    	{
    		return new DqmTileEntityFigureDragometaru();
    	}else if(this == DQMobFigures.BlockFigureDragondarknaito)
    	{
    		return new DqmTileEntityFigureDragondarknaito();
    	}else if(this == DQMobFigures.BlockFigureDragonnaito)
    	{
    		return new DqmTileEntityFigureDragonnaito();
    	}else if(this == DQMobFigures.BlockFigureDragonraida)
    	{
    		return new DqmTileEntityFigureDragonraida();
    	}else if(this == DQMobFigures.BlockFigureDragosuraimu)
    	{
    		return new DqmTileEntityFigureDragosuraimu();
    	}else if(this == DQMobFigures.BlockFigureDucksbill)
    	{
    		return new DqmTileEntityFigureDucksbill();
    	}else if(this == DQMobFigures.BlockFigureEbiruapple)
    	{
    		return new DqmTileEntityFigureEbiruapple();
    	}else if(this == DQMobFigures.BlockFigureEnzeruslime)
    	{
    		return new DqmTileEntityFigureEnzeruslime();
    	}else if(this == DQMobFigures.BlockFigureEriminator)
    	{
    		return new DqmTileEntityFigureEriminator();
    	}else if(this == DQMobFigures.BlockFigureEsterk)
    	{
    		return new DqmTileEntityFigureEsterk();
    	}else if(this == DQMobFigures.BlockFigureFaratto)
    	{
    		return new DqmTileEntityFigureFaratto();
    	}else if(this == DQMobFigures.BlockFigureFgizumo)
    	{
    		return new DqmTileEntityFigureFgizumo();
    	}else if(this == DQMobFigures.BlockFigureFureimu)
    	{
    		return new DqmTileEntityFigureFureimu();
    	}else if(this == DQMobFigures.BlockFigureFureizado)
    	{
    		return new DqmTileEntityFigureFureizado();
    	}else if(this == DQMobFigures.BlockFigureFurosutogizumo)
    	{
    		return new DqmTileEntityFigureFurosutogizumo();
    	}else if(this == DQMobFigures.BlockFigureGaikotu)
    	{
    		return new DqmTileEntityFigureGaikotu();
    	}else if(this == DQMobFigures.BlockFigureGaikotukensi)
    	{
    		return new DqmTileEntityFigureGaikotukensi();
    	}else if(this == DQMobFigures.BlockFigureGamegon)
    	{
    		return new DqmTileEntityFigureGamegon();
    	}else if(this == DQMobFigures.BlockFigureGamegonload)
    	{
    		return new DqmTileEntityFigureGamegonload();
    	}else if(this == DQMobFigures.BlockFigureGamegonrejendo)
    	{
    		return new DqmTileEntityFigureGamegonrejendo();
    	}else if(this == DQMobFigures.BlockFigureGanirasu)
    	{
    		return new DqmTileEntityFigureGanirasu();
    	}else if(this == DQMobFigures.BlockFigureGappurin)
    	{
    		return new DqmTileEntityFigureGappurin();
    	}else if(this == DQMobFigures.BlockFigureGenjutusi)
    	{
    		return new DqmTileEntityFigureGenjutusi();
    	}else if(this == DQMobFigures.BlockFigureGhost)
    	{
    		return new DqmTileEntityFigureGhost();
    	}else if(this == DQMobFigures.BlockFigureGigantesu)
    	{
    		return new DqmTileEntityFigureGigantesu();
    	}else if(this == DQMobFigures.BlockFigureGizumo)
    	{
    		return new DqmTileEntityFigureGizumo();
    	}else if(this == DQMobFigures.BlockFigureGizumoAZ)
    	{
    		return new DqmTileEntityFigureGizumoAZ();
    	}else if(this == DQMobFigures.BlockFigureGod)
    	{
    		return new DqmTileEntityFigureGod();
    	}else if(this == DQMobFigures.BlockFigureGodonheddo)
    	{
    		return new DqmTileEntityFigureGodonheddo();
    	}else if(this == DQMobFigures.BlockFigureGodraida)
    	{
    		return new DqmTileEntityFigureGodraida();
    	}else if(this == DQMobFigures.BlockFigureGoldenmetalslime)
    	{
    		return new DqmTileEntityFigureGoldenmetalslime();
    	}else if(this == DQMobFigures.BlockFigureGoldman)
    	{
    		return new DqmTileEntityFigureGoldman();
    	}else if(this == DQMobFigures.BlockFigureGoldmanto)
    	{
    		return new DqmTileEntityFigureGoldmanto();
    	}else if(this == DQMobFigures.BlockFigureGoremu)
    	{
    		return new DqmTileEntityFigureGoremu();
    	}else if(this == DQMobFigures.BlockFigureGorotuki)
    	{
    		return new DqmTileEntityFigureGorotuki();
    	}else if(this == DQMobFigures.BlockFigureGorudenkon)
    	{
    		return new DqmTileEntityFigureGorudenkon();
    	}else if(this == DQMobFigures.BlockFigureGorudensuraimu)
    	{
    		return new DqmTileEntityFigureGorudensuraimu();
    	}else if(this == DQMobFigures.BlockFigureGorudentotemu)
    	{
    		return new DqmTileEntityFigureGorudentotemu();
    	}else if(this == DQMobFigures.BlockFigureGuntaigani)
    	{
    		return new DqmTileEntityFigureGuntaigani();
    	}else if(this == DQMobFigures.BlockFigureHagumeta)
    	{
    		return new DqmTileEntityFigureHagumeta();
    	}else if(this == DQMobFigures.BlockFigureHaguremetaruking)
    	{
    		return new DqmTileEntityFigureHaguremetaruking();
    	}else if(this == DQMobFigures.BlockFigureHatonaito)
    	{
    		return new DqmTileEntityFigureHatonaito();
    	}else if(this == DQMobFigures.BlockFigureHerughost)
    	{
    		return new DqmTileEntityFigureHerughost();
    	}else if(this == DQMobFigures.BlockFigureHgizumo)
    	{
    		return new DqmTileEntityFigureHgizumo();
    	}else if(this == DQMobFigures.BlockFigureHiitogizumo)
    	{
    		return new DqmTileEntityFigureHiitogizumo();
    	}else if(this == DQMobFigures.BlockFigureHitokuibako)
    	{
    		return new DqmTileEntityFigureHitokuibako();
    	}else if(this == DQMobFigures.BlockFigureHitokuiga)
    	{
    		return new DqmTileEntityFigureHitokuiga();
    	}else if(this == DQMobFigures.BlockFigureHitokuikibako)
    	{
    		return new DqmTileEntityFigureHitokuikibako();
    	}else if(this == DQMobFigures.BlockFigureHitokuisaberu)
    	{
    		return new DqmTileEntityFigureHitokuisaberu();
    	}else if(this == DQMobFigures.BlockFigureHoimisura)
    	{
    		return new DqmTileEntityFigureHoimisura();
    	}else if(this == DQMobFigures.BlockFigureHoroghost)
    	{
    		return new DqmTileEntityFigureHoroghost();
    	}else if(this == DQMobFigures.BlockFigureHotatewarabi)
    	{
    		return new DqmTileEntityFigureHotatewarabi();
    	}else if(this == DQMobFigures.BlockFigureHyouganmajin)
    	{
    		return new DqmTileEntityFigureHyouganmajin();
    	}else if(this == DQMobFigures.BlockFigureIkkakuusagi)
    	{
    		return new DqmTileEntityFigureIkkakuusagi();
    	}else if(this == DQMobFigures.BlockFigureItamogu)
    	{
    		return new DqmTileEntityFigureItamogu();
    	}else if(this == DQMobFigures.BlockFigureJeriman)
    	{
    		return new DqmTileEntityFigureJeriman();
    	}else if(this == DQMobFigures.BlockFigureJigokunohasami)
    	{
    		return new DqmTileEntityFigureJigokunohasami();
    	}else if(this == DQMobFigures.BlockFigureJigokunoyoroi)
    	{
    		return new DqmTileEntityFigureJigokunoyoroi();
    	}else if(this == DQMobFigures.BlockFigureKagenokisi)
    	{
    		return new DqmTileEntityFigureKagenokisi();
    	}else if(this == DQMobFigures.BlockFigureKandatakobun)
    	{
    		return new DqmTileEntityFigureKandatakobun();
    	}else if(this == DQMobFigures.BlockFigureKedamon)
    	{
    		return new DqmTileEntityFigureKedamon();
    	}else if(this == DQMobFigures.BlockFigureKemunkurusu)
    	{
    		return new DqmTileEntityFigureKemunkurusu();
    	}else if(this == DQMobFigures.BlockFigureKimendousi)
    	{
    		return new DqmTileEntityFigureKimendousi();
    	}else if(this == DQMobFigures.BlockFigureKimera)
    	{
    		return new DqmTileEntityFigureKimera();
    	}else if(this == DQMobFigures.BlockFigureKingbesu)
    	{
    		return new DqmTileEntityFigureKingbesu();
    	}else if(this == DQMobFigures.BlockFigureKinghidora)
    	{
    		return new DqmTileEntityFigureKinghidora();
    	}else if(this == DQMobFigures.BlockFigureKingsura)
    	{
    		return new DqmTileEntityFigureKingsura();
    	}else if(this == DQMobFigures.BlockFigureKiraama)
    	{
    		return new DqmTileEntityFigureKiraama();
    	}else if(this == DQMobFigures.BlockFigureKirakurabu)
    	{
    		return new DqmTileEntityFigureKirakurabu();
    	}else if(this == DQMobFigures.BlockFigureKiramajinga)
    	{
    		return new DqmTileEntityFigureKiramajinga();
    	}else if(this == DQMobFigures.BlockFigureKiramasin)
    	{
    		return new DqmTileEntityFigureKiramasin();
    	}else if(this == DQMobFigures.BlockFigureKiramasin2)
    	{
    		return new DqmTileEntityFigureKiramasin2();
    	}else if(this == DQMobFigures.BlockFigureKirapan)
    	{
    		return new DqmTileEntityFigureKirapan();
    	}else if(this == DQMobFigures.BlockFigureKirapan2)
    	{
    		return new DqmTileEntityFigureKirapan2();
    	}else if(this == DQMobFigures.BlockFigureKirapike)
    	{
    		return new DqmTileEntityFigureKirapike();
    	}else if(this == DQMobFigures.BlockFigureKirasuko)
    	{
    		return new DqmTileEntityFigureKirasuko();
    	}else if(this == DQMobFigures.BlockFigureKiratoti)
    	{
    		return new DqmTileEntityFigureKiratoti();
    	}else if(this == DQMobFigures.BlockFigureKirikabuobake)
    	{
    		return new DqmTileEntityFigureKirikabuobake();
    	}else if(this == DQMobFigures.BlockFigureKisudragon)
    	{
    		return new DqmTileEntityFigureKisudragon();
    	}else if(this == DQMobFigures.BlockFigureKuinmomon)
    	{
    		return new DqmTileEntityFigureKuinmomon();
    	}else if(this == DQMobFigures.BlockFigureKuinsuraimu)
    	{
    		return new DqmTileEntityFigureKuinsuraimu();
    	}else if(this == DQMobFigures.BlockFigureMaaburun)
    	{
    		return new DqmTileEntityFigureMaaburun();
    	}else if(this == DQMobFigures.BlockFigureMadohando)
    	{
    		return new DqmTileEntityFigureMadohando();
    	}else if(this == DQMobFigures.BlockFigureMadrainbow)
    	{
    		return new DqmTileEntityFigureMadrainbow();
    	}else if(this == DQMobFigures.BlockFigureMagematango)
    	{
    		return new DqmTileEntityFigureMagematango();
    	}else if(this == DQMobFigures.BlockFigureMagemomonja)
    	{
    		return new DqmTileEntityFigureMagemomonja();
    	}else if(this == DQMobFigures.BlockFigureMagumaron)
    	{
    		return new DqmTileEntityFigureMagumaron();
    	}else if(this == DQMobFigures.BlockFigureMajikaruhatto)
    	{
    		return new DqmTileEntityFigureMajikaruhatto();
    	}else if(this == DQMobFigures.BlockFigureManemane)
    	{
    		return new DqmTileEntityFigureManemane();
    	}else if(this == DQMobFigures.BlockFigureMaounokage)
    	{
    		return new DqmTileEntityFigureMaounokage();
    	}else if(this == DQMobFigures.BlockFigureMapetman)
    	{
    		return new DqmTileEntityFigureMapetman();
    	}else if(this == DQMobFigures.BlockFigureMaporena)
    	{
    		return new DqmTileEntityFigureMaporena();
    	}else if(this == DQMobFigures.BlockFigureMarinsuraimu)
    	{
    		return new DqmTileEntityFigureMarinsuraimu();
    	}else if(this == DQMobFigures.BlockFigureMashougumo)
    	{
    		return new DqmTileEntityFigureMashougumo();
    	}else if(this == DQMobFigures.BlockFigureMasso)
    	{
    		return new DqmTileEntityFigureMasso();
    	}else if(this == DQMobFigures.BlockFigureMasterdoragon)
    	{
    		return new DqmTileEntityFigureMasterdoragon();
    	}else if(this == DQMobFigures.BlockFigureMatango)
    	{
    		return new DqmTileEntityFigureMatango();
    	}else if(this == DQMobFigures.BlockFigureMegazarurokku)
    	{
    		return new DqmTileEntityFigureMegazarurokku();
    	}else if(this == DQMobFigures.BlockFigureMeijidoraki)
    	{
    		return new DqmTileEntityFigureMeijidoraki();
    	}else if(this == DQMobFigures.BlockFigureMeijikimera)
    	{
    		return new DqmTileEntityFigureMeijikimera();
    	}else if(this == DQMobFigures.BlockFigureMeragosuto)
    	{
    		return new DqmTileEntityFigureMeragosuto();
    	}else if(this == DQMobFigures.BlockFigureMetaking)
    	{
    		return new DqmTileEntityFigureMetaking();
    	}else if(this == DQMobFigures.BlockFigureMetaruburazazu)
    	{
    		return new DqmTileEntityFigureMetaruburazazu();
    	}else if(this == DQMobFigures.BlockFigureMetaruhanta)
    	{
    		return new DqmTileEntityFigureMetaruhanta();
    	}else if(this == DQMobFigures.BlockFigureMetaruhantaken)
    	{
    		return new DqmTileEntityFigureMetaruhantaken();
    	}else if(this == DQMobFigures.BlockFigureMetaruhoimin)
    	{
    		return new DqmTileEntityFigureMetaruhoimin();
    	}else if(this == DQMobFigures.BlockFigureMetaruraida)
    	{
    		return new DqmTileEntityFigureMetaruraida();
    	}else if(this == DQMobFigures.BlockFigureMetasura)
    	{
    		return new DqmTileEntityFigureMetasura();
    	}else if(this == DQMobFigures.BlockFigureMetoroghost)
    	{
    		return new DqmTileEntityFigureMetoroghost();
    	}else if(this == DQMobFigures.BlockFigureMimikku)
    	{
    		return new DqmTileEntityFigureMimikku();
    	}else if(this == DQMobFigures.BlockFigureMimikkukibako)
    	{
    		return new DqmTileEntityFigureMimikkukibako();
    	}else if(this == DQMobFigures.BlockFigureMinidemon)
    	{
    		return new DqmTileEntityFigureMinidemon();
    	}else if(this == DQMobFigures.BlockFigureMokomokojuu)
    	{
    		return new DqmTileEntityFigureMokomokojuu();
    	}else if(this == DQMobFigures.BlockFigureMomoirosansimai)
    	{
    		return new DqmTileEntityFigureMomoirosansimai();
    	}else if(this == DQMobFigures.BlockFigureMomon)
    	{
    		return new DqmTileEntityFigureMomon();
    	}else if(this == DQMobFigures.BlockFigureMomonja)
    	{
    		return new DqmTileEntityFigureMomonja();
    	}else if(this == DQMobFigures.BlockFigureMoonkimera)
    	{
    		return new DqmTileEntityFigureMoonkimera();
    	}else if(this == DQMobFigures.BlockFigureMrippusu)
    	{
    		return new DqmTileEntityFigureMrippusu();
    	}else if(this == DQMobFigures.BlockFigureNightwalker)
    	{
    		return new DqmTileEntityFigureNightwalker();
    	}else if(this == DQMobFigures.BlockFigureNoroinoiwa)
    	{
    		return new DqmTileEntityFigureNoroinoiwa();
    	}else if(this == DQMobFigures.BlockFigureNorowaretaturugi)
    	{
    		return new DqmTileEntityFigureNorowaretaturugi();
    	}else if(this == DQMobFigures.BlockFigureObakekinoko)
    	{
    		return new DqmTileEntityFigureObakekinoko();
    	}else if(this == DQMobFigures.BlockFigureObakekyandoru)
    	{
    		return new DqmTileEntityFigureObakekyandoru();
    	}else if(this == DQMobFigures.BlockFigureObakeumiusi)
    	{
    		return new DqmTileEntityFigureObakeumiusi();
    	}else if(this == DQMobFigures.BlockFigureOdoruhouseki)
    	{
    		return new DqmTileEntityFigureOdoruhouseki();
    	}else if(this == DQMobFigures.BlockFigureOnikozou)
    	{
    		return new DqmTileEntityFigureOnikozou();
    	}else if(this == DQMobFigures.BlockFigureOokiduti)
    	{
    		return new DqmTileEntityFigureOokiduti();
    	}else if(this == DQMobFigures.BlockFigureOokutibasi)
    	{
    		return new DqmTileEntityFigureOokutibasi();
    	}else if(this == DQMobFigures.BlockFigureOomedama)
    	{
    		return new DqmTileEntityFigureOomedama();
    	}else if(this == DQMobFigures.BlockFigureOonamekuji)
    	{
    		return new DqmTileEntityFigureOonamekuji();
    	}else if(this == DQMobFigures.BlockFigurePandorabox)
    	{
    		return new DqmTileEntityFigurePandorabox();
    	}else if(this == DQMobFigures.BlockFigurePandorakibako)
    	{
    		return new DqmTileEntityFigurePandorakibako();
    	}else if(this == DQMobFigures.BlockFigurePapetkozou)
    	{
    		return new DqmTileEntityFigurePapetkozou();
    	}else if(this == DQMobFigures.BlockFigurePapettoman)
    	{
    		return new DqmTileEntityFigurePapettoman();
    	}else if(this == DQMobFigures.BlockFigurePikusi)
    	{
    		return new DqmTileEntityFigurePikusi();
    	}else if(this == DQMobFigures.BlockFigurePinkbonbon)
    	{
    		return new DqmTileEntityFigurePinkbonbon();
    	}else if(this == DQMobFigures.BlockFigurePinkmomon)
    	{
    		return new DqmTileEntityFigurePinkmomon();
    	}else if(this == DQMobFigures.BlockFigurePisaronaito)
    	{
    		return new DqmTileEntityFigurePisaronaito();
    	}else if(this == DQMobFigures.BlockFigurePombom)
    	{
    		return new DqmTileEntityFigurePombom();
    	}else if(this == DQMobFigures.BlockFigurePuratinaking)
    	{
    		return new DqmTileEntityFigurePuratinaking();
    	}else if(this == DQMobFigures.BlockFigurePuremiasuraimu)
    	{
    		return new DqmTileEntityFigurePuremiasuraimu();
    	}else if(this == DQMobFigures.BlockFigurePurizunyan)
    	{
    		return new DqmTileEntityFigurePurizunyan();
    	}else if(this == DQMobFigures.BlockFigurePuyon)
    	{
    		return new DqmTileEntityFigurePuyon();
    	}else if(this == DQMobFigures.BlockFigureRaimusuraimu)
    	{
    		return new DqmTileEntityFigureRaimusuraimu();
    	}else if(this == DQMobFigures.BlockFigureReddoatya)
    	{
    		return new DqmTileEntityFigureReddoatya();
    	}else if(this == DQMobFigures.BlockFigureRedsaikuron)
    	{
    		return new DqmTileEntityFigureRedsaikuron();
    	}else if(this == DQMobFigures.BlockFigureRemonsuraimu)
    	{
    		return new DqmTileEntityFigureRemonsuraimu();
    	}else if(this == DQMobFigures.BlockFigureRippusu)
    	{
    		return new DqmTileEntityFigureRippusu();
    	}else if(this == DQMobFigures.BlockFigureRiripat)
    	{
    		return new DqmTileEntityFigureRiripat();
    	}else if(this == DQMobFigures.BlockFigureRyuiso)
    	{
    		return new DqmTileEntityFigureRyuiso();
    	}else if(this == DQMobFigures.BlockFigureRyuuou)
    	{
    		return new DqmTileEntityFigureRyuuou();
    	}else if(this == DQMobFigures.BlockFigureRyuuou2)
    	{
    		return new DqmTileEntityFigureRyuuou2();
    	}else if(this == DQMobFigures.BlockFigureSabotenboru)
    	{
    		return new DqmTileEntityFigureSabotenboru();
    	}else if(this == DQMobFigures.BlockFigureSabotengold)
    	{
    		return new DqmTileEntityFigureSabotengold();
    	}else if(this == DQMobFigures.BlockFigureSaikuropusu)
    	{
    		return new DqmTileEntityFigureSaikuropusu();
    	}else if(this == DQMobFigures.BlockFigureSamayoutamasii)
    	{
    		return new DqmTileEntityFigureSamayoutamasii();
    	}else if(this == DQMobFigures.BlockFigureSamayouyoroi)
    	{
    		return new DqmTileEntityFigureSamayouyoroi();
    	}else if(this == DQMobFigures.BlockFigureSeigin)
    	{
    		return new DqmTileEntityFigureSeigin();
    	}else if(this == DQMobFigures.BlockFigureShuvaluts)
    	{
    		return new DqmTileEntityFigureShuvaluts();
    	}else if(this == DQMobFigures.BlockFigureSibireageha)
    	{
    		return new DqmTileEntityFigureSibireageha();
    	}else if(this == DQMobFigures.BlockFigureSibiredanbira)
    	{
    		return new DqmTileEntityFigureSibiredanbira();
    	}else if(this == DQMobFigures.BlockFigureSibirekurage)
    	{
    		return new DqmTileEntityFigureSibirekurage();
    	}else if(this == DQMobFigures.BlockFigureSimasimacat)
    	{
    		return new DqmTileEntityFigureSimasimacat();
    	}else if(this == DQMobFigures.BlockFigureSirubadebiru)
    	{
    		return new DqmTileEntityFigureSirubadebiru();
    	}else if(this == DQMobFigures.BlockFigureSirubamanto)
    	{
    		return new DqmTileEntityFigureSirubamanto();
    	}else if(this == DQMobFigures.BlockFigureSirudoaniki)
    	{
    		return new DqmTileEntityFigureSirudoaniki();
    	}else if(this == DQMobFigures.BlockFigureSirudokozou)
    	{
    		return new DqmTileEntityFigureSirudokozou();
    	}else if(this == DQMobFigures.BlockFigureSiryou)
    	{
    		return new DqmTileEntityFigureSiryou();
    	}else if(this == DQMobFigures.BlockFigureSiryounokisi)
    	{
    		return new DqmTileEntityFigureSiryounokisi();
    	}else if(this == DQMobFigures.BlockFigureSkullgaroo)
    	{
    		return new DqmTileEntityFigureSkullgaroo();
    	}else if(this == DQMobFigures.BlockFigureSodofantomu)
    	{
    		return new DqmTileEntityFigureSodofantomu();
    	}else if(this == DQMobFigures.BlockFigureStarkimera)
    	{
    		return new DqmTileEntityFigureStarkimera();
    	}else if(this == DQMobFigures.BlockFigureStonman)
    	{
    		return new DqmTileEntityFigureStonman();
    	}else if(this == DQMobFigures.BlockFigureSukippaa)
    	{
    		return new DqmTileEntityFigureSukippaa();
    	}else if(this == DQMobFigures.BlockFigureSumairurokku)
    	{
    		return new DqmTileEntityFigureSumairurokku();
    	}else if(this == DQMobFigures.BlockFigureSumoruguru)
    	{
    		return new DqmTileEntityFigureSumoruguru();
    	}else if(this == DQMobFigures.BlockFigureSunomon)
    	{
    		return new DqmTileEntityFigureSunomon();
    	}else if(this == DQMobFigures.BlockFigureSupekutetto)
    	{
    		return new DqmTileEntityFigureSupekutetto();
    	}else if(this == DQMobFigures.BlockFigureSupini)
    	{
    		return new DqmTileEntityFigureSupini();
    	}else if(this == DQMobFigures.BlockFigureSura)
    	{
    		return new DqmTileEntityFigureSura();
    	}else if(this == DQMobFigures.BlockFigureSura2)
    	{
    		return new DqmTileEntityFigureSura2();
    	}else if(this == DQMobFigures.BlockFigureSuraimubehomazun)
    	{
    		return new DqmTileEntityFigureSuraimubehomazun();
    	}else if(this == DQMobFigures.BlockFigureSuraimubesu)
    	{
    		return new DqmTileEntityFigureSuraimubesu();
    	}else if(this == DQMobFigures.BlockFigureSuraimubogu)
    	{
    		return new DqmTileEntityFigureSuraimubogu();
    	}else if(this == DQMobFigures.BlockFigureSuraimuburesu)
    	{
    		return new DqmTileEntityFigureSuraimuburesu();
    	}else if(this == DQMobFigures.BlockFigureSuraimuhaitawa)
    	{
    		return new DqmTileEntityFigureSuraimuhaitawa();
    	}else if(this == DQMobFigures.BlockFigureSuraimujeneraru)
    	{
    		return new DqmTileEntityFigureSuraimujeneraru();
    	}else if(this == DQMobFigures.BlockFigureSuraimuking)
    	{
    		return new DqmTileEntityFigureSuraimuking();
    	}else if(this == DQMobFigures.BlockFigureSuraimumadyura)
    	{
    		return new DqmTileEntityFigureSuraimumadyura();
    	}else if(this == DQMobFigures.BlockFigureSuraimunaito)
    	{
    		return new DqmTileEntityFigureSuraimunaito();
    	}else if(this == DQMobFigures.BlockFigureSuraimutawa)
    	{
    		return new DqmTileEntityFigureSuraimutawa();
    	}else if(this == DQMobFigures.BlockFigureSuraimutumuri)
    	{
    		return new DqmTileEntityFigureSuraimutumuri();
    	}else if(this == DQMobFigures.BlockFigureSweetbag)
    	{
    		return new DqmTileEntityFigureSweetbag();
    	}else if(this == DQMobFigures.BlockFigureSyado)
    	{
    		return new DqmTileEntityFigureSyado();
    	}else if(this == DQMobFigures.BlockFigureTahodoraki)
    	{
    		return new DqmTileEntityFigureTahodoraki();
    	}else if(this == DQMobFigures.BlockFigureTaipug)
    	{
    		return new DqmTileEntityFigureTaipug();
    	}else if(this == DQMobFigures.BlockFigureTattyan)
    	{
    		return new DqmTileEntityFigureTattyan();
    	}else if(this == DQMobFigures.BlockFigureTogebouzu)
    	{
    		return new DqmTileEntityFigureTogebouzu();
    	}else if(this == DQMobFigures.BlockFigureTogekonbou)
    	{
    		return new DqmTileEntityFigureTogekonbou();
    	}else if(this == DQMobFigures.BlockFigureTomosibikozou)
    	{
    		return new DqmTileEntityFigureTomosibikozou();
    	}else if(this == DQMobFigures.BlockFigureTonburero)
    	{
    		return new DqmTileEntityFigureTonburero();
    	}else if(this == DQMobFigures.BlockFigureTororu)
    	{
    		return new DqmTileEntityFigureTororu();
    	}else if(this == DQMobFigures.BlockFigureTororubakkosu)
    	{
    		return new DqmTileEntityFigureTororubakkosu();
    	}else if(this == DQMobFigures.BlockFigureTororubonba)
    	{
    		return new DqmTileEntityFigureTororubonba();
    	}else if(this == DQMobFigures.BlockFigureTororuking)
    	{
    		return new DqmTileEntityFigureTororuking();
    	}else if(this == DQMobFigures.BlockFigureTubo)
    	{
    		return new DqmTileEntityFigureTubo();
    	}else if(this == DQMobFigures.BlockFigureTubokku)
    	{
    		return new DqmTileEntityFigureTubokku();
    	}else if(this == DQMobFigures.BlockFigureTukaima)
    	{
    		return new DqmTileEntityFigureTukaima();
    	}else if(this == DQMobFigures.BlockFigureTumurinmama)
    	{
    		return new DqmTileEntityFigureTumurinmama();
    	}else if(this == DQMobFigures.BlockFigureTutiwarasi)
    	{
    		return new DqmTileEntityFigureTutiwarasi();
    	}else if(this == DQMobFigures.BlockFigureTyokonuba)
    	{
    		return new DqmTileEntityFigureTyokonuba();
    	}else if(this == DQMobFigures.BlockFigureUmibouzu)
    	{
    		return new DqmTileEntityFigureUmibouzu();
    	}else if(this == DQMobFigures.BlockFigureUmiusi)
    	{
    		return new DqmTileEntityFigureUmiusi();
    	}else if(this == DQMobFigures.BlockFigureUragirikozou)
    	{
    		return new DqmTileEntityFigureUragirikozou();
    	}else if(this == DQMobFigures.BlockFigureUzusioking)
    	{
    		return new DqmTileEntityFigureUzusioking();
    	}else if(this == DQMobFigures.BlockFigureWanpakusatan)
    	{
    		return new DqmTileEntityFigureWanpakusatan();
    	}else if(this == DQMobFigures.BlockFigureWaraibukuro)
    	{
    		return new DqmTileEntityFigureWaraibukuro();
    	}else if(this == DQMobFigures.BlockFigureYamatanooroti)
    	{
    		return new DqmTileEntityFigureYamatanooroti();
    	}else if(this == DQMobFigures.BlockFigureYouganmajin)
    	{
    		return new DqmTileEntityFigureYouganmajin();
    	}else if(this == DQMobFigures.BlockFigureZinmentyou)
    	{
    		return new DqmTileEntityFigureZinmentyou();
    	}else if(this == DQMobFigures.BlockFigureZoma)
    	{
    		return new DqmTileEntityFigureZoma();
    	}else if(this == DQMobFigures.BlockFigureZukkinya)
    	{
    		return new DqmTileEntityFigureZukkinya();
    	}else if(this == DQMobFigures.BlockFigureKandata)
    	{
    		return new DqmTileEntityFigureKandata();
    	}else if(this == DQMobFigures.BlockFigureBlackchack)
    	{
    		return new DqmTileEntityFigureBlackchack();
    	}else if(this == DQMobFigures.BlockFigureSuraimuemperor)
    	{
    		return new DqmTileEntityFigureSuraimuemperor();
    	}else if(this == DQMobFigures.BlockFigureDarkdoriado)
    	{
    		return new DqmTileEntityFigureDarkdoriado();
    	}else if(this == DQMobFigures.BlockFigureShadopan)
    	{
    		return new DqmTileEntityFigureShadopan();
    	}else if(this == DQMobFigures.BlockFigureShadopan2)
    	{
    		return new DqmTileEntityFigureShadopan2();
    	}else if(this == DQMobFigures.BlockFigureOrutega)
    	{
    		return new DqmTileEntityFigureOrutega();
    	}

    	return new DqmTileEntityFigureSura();
    }
    //ランダム
    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    //方角で角度を変更
    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        //int l = par1World.getBlockMetadata(par2, par3, par4);
        if (l == 0)//南
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
        }

        if (l == 1)//東
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
        }

        if (l == 2)//北
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 3)//西
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }
    }

    //方角でサイズを変更
    /*
    public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4) & 7;
        float f = 0.15F;

        if (l == 0)//南
        {
            this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
        }
        else if (l == 1)//東
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
        }
        else if (l == 2)//北
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
        }
        else if (l == 3)//西
        {
            this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
        }

        return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
    }
    */

}
