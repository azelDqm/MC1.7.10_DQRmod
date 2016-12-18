package dqr.blocks.mobObj;

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
import dqr.api.Blocks.DQMobObjects;
import dqr.blocks.mobObj.tileEntity.*;

public class DqmBlockMobObj extends BlockContainer
{
    public static String setmodel;
    private String model;
    private float rotationYaw;

    public DqmBlockMobObj(Material var2)
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
    	if(this == DQMobObjects.BlockObjAkairai)
    	{
    		return new DqmTileEntityObjAkairai();
    	}else if(this == DQMobObjects.BlockObjAkumanosyo)
    	{
    		return new DqmTileEntityObjAkumanosyo();
    	}else if(this == DQMobObjects.BlockObjAkumanotubo)
    	{
    		return new DqmTileEntityObjAkumanotubo();
    	}else if(this == DQMobObjects.BlockObjAnimaruzonbi)
    	{
    		return new DqmTileEntityObjAnimaruzonbi();
    	}else if(this == DQMobObjects.BlockObjAnkokumajin)
    	{
    		return new DqmTileEntityObjAnkokumajin();
    	}else if(this == DQMobObjects.BlockObjAroinpu)
    	{
    		return new DqmTileEntityObjAroinpu();
    	}else if(this == DQMobObjects.BlockObjArukemisuton)
    	{
    		return new DqmTileEntityObjArukemisuton();
    	}else if(this == DQMobObjects.BlockObjArumiraji)
    	{
    		return new DqmTileEntityObjArumiraji();
    	}else if(this == DQMobObjects.BlockObjAtorasu)
    	{
    		return new DqmTileEntityObjAtorasu();
    	}else if(this == DQMobObjects.BlockObjAxedoragon)
    	{
    		return new DqmTileEntityObjAxedoragon();
    	}else if(this == DQMobObjects.BlockObjAyasiikage)
    	{
    		return new DqmTileEntityObjAyasiikage();
    	}else if(this == DQMobObjects.BlockObjBaburin)
    	{
    		return new DqmTileEntityObjBaburin();
    	}else if(this == DQMobObjects.BlockObjBaburuking)
    	{
    		return new DqmTileEntityObjBaburuking();
    	}else if(this == DQMobObjects.BlockObjBakudanbebi)
    	{
    		return new DqmTileEntityObjBakudanbebi();
    	}else if(this == DQMobObjects.BlockObjBakudaniwa)
    	{
    		return new DqmTileEntityObjBakudaniwa();
    	}else if(this == DQMobObjects.BlockObjBarakku)
    	{
    		return new DqmTileEntityObjBarakku();
    	}else if(this == DQMobObjects.BlockObjBariidodog)
    	{
    		return new DqmTileEntityObjBariidodog();
    	}else if(this == DQMobObjects.BlockObjBassaimasin)
    	{
    		return new DqmTileEntityObjBassaimasin();
    	}else if(this == DQMobObjects.BlockObjBatorurex)
    	{
    		return new DqmTileEntityObjBatorurex();
    	}else if(this == DQMobObjects.BlockObjBazuzu)
    	{
    		return new DqmTileEntityObjBazuzu();
    	}else if(this == DQMobObjects.BlockObjBebingosatan)
    	{
    		return new DqmTileEntityObjBebingosatan();
    	}else if(this == DQMobObjects.BlockObjBebisatan)
    	{
    		return new DqmTileEntityObjBebisatan();
    	}else if(this == DQMobObjects.BlockObjBehoimisuraimu)
    	{
    		return new DqmTileEntityObjBehoimisuraimu();
    	}else if(this == DQMobObjects.BlockObjBehoimusuraimu)
    	{
    		return new DqmTileEntityObjBehoimusuraimu();
    	}else if(this == DQMobObjects.BlockObjBehomasuraimu)
    	{
    		return new DqmTileEntityObjBehomasuraimu();
    	}else if(this == DQMobObjects.BlockObjBerobero)
    	{
    		return new DqmTileEntityObjBerobero();
    	}else if(this == DQMobObjects.BlockObjBeronyaago)
    	{
    		return new DqmTileEntityObjBeronyaago();
    	}else if(this == DQMobObjects.BlockObjBesuking)
    	{
    		return new DqmTileEntityObjBesuking();
    	}else if(this == DQMobObjects.BlockObjBigCrow)
    	{
    		return new DqmTileEntityObjBigCrow();
    	}else if(this == DQMobObjects.BlockObjBiggufeisu)
    	{
    		return new DqmTileEntityObjBiggufeisu();
    	}else if(this == DQMobObjects.BlockObjBigguhatto)
    	{
    		return new DqmTileEntityObjBigguhatto();
    	}else if(this == DQMobObjects.BlockObjBiggumoai)
    	{
    		return new DqmTileEntityObjBiggumoai();
    	}else if(this == DQMobObjects.BlockObjBighanma)
    	{
    		return new DqmTileEntityObjBighanma();
    	}else if(this == DQMobObjects.BlockObjBosutororu)
    	{
    		return new DqmTileEntityObjBosutororu();
    	}else if(this == DQMobObjects.BlockObjBoureikensi)
    	{
    		return new DqmTileEntityObjBoureikensi();
    	}else if(this == DQMobObjects.BlockObjBubsura)
    	{
    		return new DqmTileEntityObjBubsura();
    	}else if(this == DQMobObjects.BlockObjBuchunpa)
    	{
    		return new DqmTileEntityObjBuchunpa();
    	}else if(this == DQMobObjects.BlockObjBuraddihando)
    	{
    		return new DqmTileEntityObjBuraddihando();
    	}else if(this == DQMobObjects.BlockObjBuraddosodo)
    	{
    		return new DqmTileEntityObjBuraddosodo();
    	}else if(this == DQMobObjects.BlockObjBurakkubejita)
    	{
    		return new DqmTileEntityObjBurakkubejita();
    	}else if(this == DQMobObjects.BlockObjBurasu)
    	{
    		return new DqmTileEntityObjBurasu();
    	}else if(this == DQMobObjects.BlockObjBurauni)
    	{
    		return new DqmTileEntityObjBurauni();
    	}else if(this == DQMobObjects.BlockObjBurizado)
    	{
    		return new DqmTileEntityObjBurizado();
    	}else if(this == DQMobObjects.BlockObjButisuraimu)
    	{
    		return new DqmTileEntityObjButisuraimu();
    	}else if(this == DQMobObjects.BlockObjButtizukinya)
    	{
    		return new DqmTileEntityObjButtizukinya();
    	}else if(this == DQMobObjects.BlockObjDaiyamondosuraimu)
    	{
    		return new DqmTileEntityObjDaiyamondosuraimu();
    	}else if(this == DQMobObjects.BlockObjDakuhobitto)
    	{
    		return new DqmTileEntityObjDakuhobitto();
    	}else if(this == DQMobObjects.BlockObjDakunaito)
    	{
    		return new DqmTileEntityObjDakunaito();
    	}else if(this == DQMobObjects.BlockObjDansunidoru)
    	{
    		return new DqmTileEntityObjDansunidoru();
    	}else if(this == DQMobObjects.BlockObjDarkRamia)
    	{
    		return new DqmTileEntityObjDarkRamia();
    	}else if(this == DQMobObjects.BlockObjDarkslime)
    	{
    		return new DqmTileEntityObjDarkslime();
    	}else if(this == DQMobObjects.BlockObjDarktororu)
    	{
    		return new DqmTileEntityObjDarktororu();
    	}else if(this == DQMobObjects.BlockObjDasudragon)
    	{
    		return new DqmTileEntityObjDasudragon();
    	}else if(this == DQMobObjects.BlockObjDebirurodo)
    	{
    		return new DqmTileEntityObjDebirurodo();
    	}else if(this == DQMobObjects.BlockObjDeddopekka)
    	{
    		return new DqmTileEntityObjDeddopekka();
    	}else if(this == DQMobObjects.BlockObjDenga)
    	{
    		return new DqmTileEntityObjDenga();
    	}else if(this == DQMobObjects.BlockObjDesufuratta)
    	{
    		return new DqmTileEntityObjDesufuratta();
    	}else if(this == DQMobObjects.BlockObjDesujakkaru)
    	{
    		return new DqmTileEntityObjDesujakkaru();
    	}else if(this == DQMobObjects.BlockObjDesunyago)
    	{
    		return new DqmTileEntityObjDesunyago();
    	}else if(this == DQMobObjects.BlockObjDesupisaro1)
    	{
    		return new DqmTileEntityObjDesupisaro1();
    	}else if(this == DQMobObjects.BlockObjDesupisaro2)
    	{
    		return new DqmTileEntityObjDesupisaro2();
    	}else if(this == DQMobObjects.BlockObjDesupisaro3)
    	{
    		return new DqmTileEntityObjDesupisaro3();
    	}else if(this == DQMobObjects.BlockObjDesusutoka)
    	{
    		return new DqmTileEntityObjDesusutoka();
    	}else if(this == DQMobObjects.BlockObjDgizumo)
    	{
    		return new DqmTileEntityObjDgizumo();
    	}else if(this == DQMobObjects.BlockObjDokuroarai)
    	{
    		return new DqmTileEntityObjDokuroarai();
    	}else if(this == DQMobObjects.BlockObjDokuyazukin)
    	{
    		return new DqmTileEntityObjDokuyazukin();
    	}else if(this == DQMobObjects.BlockObjDollmaster)
    	{
    		return new DqmTileEntityObjDollmaster();
    	}else if(this == DQMobObjects.BlockObjDoragonsoruja)
    	{
    		return new DqmTileEntityObjDoragonsoruja();
    	}else if(this == DQMobObjects.BlockObjDoraki)
    	{
    		return new DqmTileEntityObjDoraki();
    	}else if(this == DQMobObjects.BlockObjDorakima)
    	{
    		return new DqmTileEntityObjDorakima();
    	}else if(this == DQMobObjects.BlockObjDoroningyou)
    	{
    		return new DqmTileEntityObjDoroningyou();
    	}else if(this == DQMobObjects.BlockObjDoronuba)
    	{
    		return new DqmTileEntityObjDoronuba();
    	}else if(this == DQMobObjects.BlockObjDorozara)
    	{
    		return new DqmTileEntityObjDorozara();
    	}else if(this == DQMobObjects.BlockObjDoruido)
    	{
    		return new DqmTileEntityObjDoruido();
    	}else if(this == DQMobObjects.BlockObjDqmdragon)
    	{
    		return new DqmTileEntityObjDqmdragon();
    	}else if(this == DQMobObjects.BlockObjDragometaru)
    	{
    		return new DqmTileEntityObjDragometaru();
    	}else if(this == DQMobObjects.BlockObjDragondarknaito)
    	{
    		return new DqmTileEntityObjDragondarknaito();
    	}else if(this == DQMobObjects.BlockObjDragonnaito)
    	{
    		return new DqmTileEntityObjDragonnaito();
    	}else if(this == DQMobObjects.BlockObjDragonraida)
    	{
    		return new DqmTileEntityObjDragonraida();
    	}else if(this == DQMobObjects.BlockObjDragosuraimu)
    	{
    		return new DqmTileEntityObjDragosuraimu();
    	}else if(this == DQMobObjects.BlockObjDucksbill)
    	{
    		return new DqmTileEntityObjDucksbill();
    	}else if(this == DQMobObjects.BlockObjEbiruapple)
    	{
    		return new DqmTileEntityObjEbiruapple();
    	}else if(this == DQMobObjects.BlockObjEnzeruslime)
    	{
    		return new DqmTileEntityObjEnzeruslime();
    	}else if(this == DQMobObjects.BlockObjEriminator)
    	{
    		return new DqmTileEntityObjEriminator();
    	}else if(this == DQMobObjects.BlockObjEsterk)
    	{
    		return new DqmTileEntityObjEsterk();
    	}else if(this == DQMobObjects.BlockObjFaratto)
    	{
    		return new DqmTileEntityObjFaratto();
    	}else if(this == DQMobObjects.BlockObjFgizumo)
    	{
    		return new DqmTileEntityObjFgizumo();
    	}else if(this == DQMobObjects.BlockObjFureimu)
    	{
    		return new DqmTileEntityObjFureimu();
    	}else if(this == DQMobObjects.BlockObjFureizado)
    	{
    		return new DqmTileEntityObjFureizado();
    	}else if(this == DQMobObjects.BlockObjFurosutogizumo)
    	{
    		return new DqmTileEntityObjFurosutogizumo();
    	}else if(this == DQMobObjects.BlockObjGaikotu)
    	{
    		return new DqmTileEntityObjGaikotu();
    	}else if(this == DQMobObjects.BlockObjGaikotukensi)
    	{
    		return new DqmTileEntityObjGaikotukensi();
    	}else if(this == DQMobObjects.BlockObjGamegon)
    	{
    		return new DqmTileEntityObjGamegon();
    	}else if(this == DQMobObjects.BlockObjGamegonload)
    	{
    		return new DqmTileEntityObjGamegonload();
    	}else if(this == DQMobObjects.BlockObjGamegonrejendo)
    	{
    		return new DqmTileEntityObjGamegonrejendo();
    	}else if(this == DQMobObjects.BlockObjGanirasu)
    	{
    		return new DqmTileEntityObjGanirasu();
    	}else if(this == DQMobObjects.BlockObjGappurin)
    	{
    		return new DqmTileEntityObjGappurin();
    	}else if(this == DQMobObjects.BlockObjGenjutusi)
    	{
    		return new DqmTileEntityObjGenjutusi();
    	}else if(this == DQMobObjects.BlockObjGhost)
    	{
    		return new DqmTileEntityObjGhost();
    	}else if(this == DQMobObjects.BlockObjGigantesu)
    	{
    		return new DqmTileEntityObjGigantesu();
    	}else if(this == DQMobObjects.BlockObjGizumo)
    	{
    		return new DqmTileEntityObjGizumo();
    	}else if(this == DQMobObjects.BlockObjGizumoAZ)
    	{
    		return new DqmTileEntityObjGizumoAZ();
    	}else if(this == DQMobObjects.BlockObjGod)
    	{
    		return new DqmTileEntityObjGod();
    	}else if(this == DQMobObjects.BlockObjGodonheddo)
    	{
    		return new DqmTileEntityObjGodonheddo();
    	}else if(this == DQMobObjects.BlockObjGodraida)
    	{
    		return new DqmTileEntityObjGodraida();
    	}else if(this == DQMobObjects.BlockObjGoldenmetalslime)
    	{
    		return new DqmTileEntityObjGoldenmetalslime();
    	}else if(this == DQMobObjects.BlockObjGoldman)
    	{
    		return new DqmTileEntityObjGoldman();
    	}else if(this == DQMobObjects.BlockObjGoldmanto)
    	{
    		return new DqmTileEntityObjGoldmanto();
    	}else if(this == DQMobObjects.BlockObjGoremu)
    	{
    		return new DqmTileEntityObjGoremu();
    	}else if(this == DQMobObjects.BlockObjGorotuki)
    	{
    		return new DqmTileEntityObjGorotuki();
    	}else if(this == DQMobObjects.BlockObjGorudenkon)
    	{
    		return new DqmTileEntityObjGorudenkon();
    	}else if(this == DQMobObjects.BlockObjGorudensuraimu)
    	{
    		return new DqmTileEntityObjGorudensuraimu();
    	}else if(this == DQMobObjects.BlockObjGorudentotemu)
    	{
    		return new DqmTileEntityObjGorudentotemu();
    	}else if(this == DQMobObjects.BlockObjGuntaigani)
    	{
    		return new DqmTileEntityObjGuntaigani();
    	}else if(this == DQMobObjects.BlockObjHagumeta)
    	{
    		return new DqmTileEntityObjHagumeta();
    	}else if(this == DQMobObjects.BlockObjHaguremetaruking)
    	{
    		return new DqmTileEntityObjHaguremetaruking();
    	}else if(this == DQMobObjects.BlockObjHatonaito)
    	{
    		return new DqmTileEntityObjHatonaito();
    	}else if(this == DQMobObjects.BlockObjHerughost)
    	{
    		return new DqmTileEntityObjHerughost();
    	}else if(this == DQMobObjects.BlockObjHgizumo)
    	{
    		return new DqmTileEntityObjHgizumo();
    	}else if(this == DQMobObjects.BlockObjHiitogizumo)
    	{
    		return new DqmTileEntityObjHiitogizumo();
    	}else if(this == DQMobObjects.BlockObjHitokuibako)
    	{
    		return new DqmTileEntityObjHitokuibako();
    	}else if(this == DQMobObjects.BlockObjHitokuiga)
    	{
    		return new DqmTileEntityObjHitokuiga();
    	}else if(this == DQMobObjects.BlockObjHitokuikibako)
    	{
    		return new DqmTileEntityObjHitokuikibako();
    	}else if(this == DQMobObjects.BlockObjHitokuisaberu)
    	{
    		return new DqmTileEntityObjHitokuisaberu();
    	}else if(this == DQMobObjects.BlockObjHoimisura)
    	{
    		return new DqmTileEntityObjHoimisura();
    	}else if(this == DQMobObjects.BlockObjHoroghost)
    	{
    		return new DqmTileEntityObjHoroghost();
    	}else if(this == DQMobObjects.BlockObjHotatewarabi)
    	{
    		return new DqmTileEntityObjHotatewarabi();
    	}else if(this == DQMobObjects.BlockObjHyouganmajin)
    	{
    		return new DqmTileEntityObjHyouganmajin();
    	}else if(this == DQMobObjects.BlockObjIkkakuusagi)
    	{
    		return new DqmTileEntityObjIkkakuusagi();
    	}else if(this == DQMobObjects.BlockObjItamogu)
    	{
    		return new DqmTileEntityObjItamogu();
    	}else if(this == DQMobObjects.BlockObjJeriman)
    	{
    		return new DqmTileEntityObjJeriman();
    	}else if(this == DQMobObjects.BlockObjJigokunohasami)
    	{
    		return new DqmTileEntityObjJigokunohasami();
    	}else if(this == DQMobObjects.BlockObjJigokunoyoroi)
    	{
    		return new DqmTileEntityObjJigokunoyoroi();
    	}else if(this == DQMobObjects.BlockObjKagenokisi)
    	{
    		return new DqmTileEntityObjKagenokisi();
    	}else if(this == DQMobObjects.BlockObjKandatakobun)
    	{
    		return new DqmTileEntityObjKandatakobun();
    	}else if(this == DQMobObjects.BlockObjKedamon)
    	{
    		return new DqmTileEntityObjKedamon();
    	}else if(this == DQMobObjects.BlockObjKemunkurusu)
    	{
    		return new DqmTileEntityObjKemunkurusu();
    	}else if(this == DQMobObjects.BlockObjKimendousi)
    	{
    		return new DqmTileEntityObjKimendousi();
    	}else if(this == DQMobObjects.BlockObjKimera)
    	{
    		return new DqmTileEntityObjKimera();
    	}else if(this == DQMobObjects.BlockObjKingbesu)
    	{
    		return new DqmTileEntityObjKingbesu();
    	}else if(this == DQMobObjects.BlockObjKinghidora)
    	{
    		return new DqmTileEntityObjKinghidora();
    	}else if(this == DQMobObjects.BlockObjKingsura)
    	{
    		return new DqmTileEntityObjKingsura();
    	}else if(this == DQMobObjects.BlockObjKiraama)
    	{
    		return new DqmTileEntityObjKiraama();
    	}else if(this == DQMobObjects.BlockObjKirakurabu)
    	{
    		return new DqmTileEntityObjKirakurabu();
    	}else if(this == DQMobObjects.BlockObjKiramajinga)
    	{
    		return new DqmTileEntityObjKiramajinga();
    	}else if(this == DQMobObjects.BlockObjKiramasin)
    	{
    		return new DqmTileEntityObjKiramasin();
    	}else if(this == DQMobObjects.BlockObjKiramasin2)
    	{
    		return new DqmTileEntityObjKiramasin2();
    	}else if(this == DQMobObjects.BlockObjKirapan)
    	{
    		return new DqmTileEntityObjKirapan();
    	}else if(this == DQMobObjects.BlockObjKirapan2)
    	{
    		return new DqmTileEntityObjKirapan2();
    	}else if(this == DQMobObjects.BlockObjKirapike)
    	{
    		return new DqmTileEntityObjKirapike();
    	}else if(this == DQMobObjects.BlockObjKirasuko)
    	{
    		return new DqmTileEntityObjKirasuko();
    	}else if(this == DQMobObjects.BlockObjKiratoti)
    	{
    		return new DqmTileEntityObjKiratoti();
    	}else if(this == DQMobObjects.BlockObjKirikabuobake)
    	{
    		return new DqmTileEntityObjKirikabuobake();
    	}else if(this == DQMobObjects.BlockObjKisudragon)
    	{
    		return new DqmTileEntityObjKisudragon();
    	}else if(this == DQMobObjects.BlockObjKuinmomon)
    	{
    		return new DqmTileEntityObjKuinmomon();
    	}else if(this == DQMobObjects.BlockObjKuinsuraimu)
    	{
    		return new DqmTileEntityObjKuinsuraimu();
    	}else if(this == DQMobObjects.BlockObjMaaburun)
    	{
    		return new DqmTileEntityObjMaaburun();
    	}else if(this == DQMobObjects.BlockObjMadohando)
    	{
    		return new DqmTileEntityObjMadohando();
    	}else if(this == DQMobObjects.BlockObjMadrainbow)
    	{
    		return new DqmTileEntityObjMadrainbow();
    	}else if(this == DQMobObjects.BlockObjMagematango)
    	{
    		return new DqmTileEntityObjMagematango();
    	}else if(this == DQMobObjects.BlockObjMagemomonja)
    	{
    		return new DqmTileEntityObjMagemomonja();
    	}else if(this == DQMobObjects.BlockObjMagumaron)
    	{
    		return new DqmTileEntityObjMagumaron();
    	}else if(this == DQMobObjects.BlockObjMajikaruhatto)
    	{
    		return new DqmTileEntityObjMajikaruhatto();
    	}else if(this == DQMobObjects.BlockObjManemane)
    	{
    		return new DqmTileEntityObjManemane();
    	}else if(this == DQMobObjects.BlockObjMaounokage)
    	{
    		return new DqmTileEntityObjMaounokage();
    	}else if(this == DQMobObjects.BlockObjMapetman)
    	{
    		return new DqmTileEntityObjMapetman();
    	}else if(this == DQMobObjects.BlockObjMaporena)
    	{
    		return new DqmTileEntityObjMaporena();
    	}else if(this == DQMobObjects.BlockObjMarinsuraimu)
    	{
    		return new DqmTileEntityObjMarinsuraimu();
    	}else if(this == DQMobObjects.BlockObjMashougumo)
    	{
    		return new DqmTileEntityObjMashougumo();
    	}else if(this == DQMobObjects.BlockObjMasso)
    	{
    		return new DqmTileEntityObjMasso();
    	}else if(this == DQMobObjects.BlockObjMasterdoragon)
    	{
    		return new DqmTileEntityObjMasterdoragon();
    	}else if(this == DQMobObjects.BlockObjMatango)
    	{
    		return new DqmTileEntityObjMatango();
    	}else if(this == DQMobObjects.BlockObjMegazarurokku)
    	{
    		return new DqmTileEntityObjMegazarurokku();
    	}else if(this == DQMobObjects.BlockObjMeijidoraki)
    	{
    		return new DqmTileEntityObjMeijidoraki();
    	}else if(this == DQMobObjects.BlockObjMeijikimera)
    	{
    		return new DqmTileEntityObjMeijikimera();
    	}else if(this == DQMobObjects.BlockObjMeragosuto)
    	{
    		return new DqmTileEntityObjMeragosuto();
    	}else if(this == DQMobObjects.BlockObjMetaking)
    	{
    		return new DqmTileEntityObjMetaking();
    	}else if(this == DQMobObjects.BlockObjMetaruburazazu)
    	{
    		return new DqmTileEntityObjMetaruburazazu();
    	}else if(this == DQMobObjects.BlockObjMetaruhanta)
    	{
    		return new DqmTileEntityObjMetaruhanta();
    	}else if(this == DQMobObjects.BlockObjMetaruhantaken)
    	{
    		return new DqmTileEntityObjMetaruhantaken();
    	}else if(this == DQMobObjects.BlockObjMetaruhoimin)
    	{
    		return new DqmTileEntityObjMetaruhoimin();
    	}else if(this == DQMobObjects.BlockObjMetaruraida)
    	{
    		return new DqmTileEntityObjMetaruraida();
    	}else if(this == DQMobObjects.BlockObjMetasura)
    	{
    		return new DqmTileEntityObjMetasura();
    	}else if(this == DQMobObjects.BlockObjMetoroghost)
    	{
    		return new DqmTileEntityObjMetoroghost();
    	}else if(this == DQMobObjects.BlockObjMimikku)
    	{
    		return new DqmTileEntityObjMimikku();
    	}else if(this == DQMobObjects.BlockObjMimikkukibako)
    	{
    		return new DqmTileEntityObjMimikkukibako();
    	}else if(this == DQMobObjects.BlockObjMinidemon)
    	{
    		return new DqmTileEntityObjMinidemon();
    	}else if(this == DQMobObjects.BlockObjMokomokojuu)
    	{
    		return new DqmTileEntityObjMokomokojuu();
    	}else if(this == DQMobObjects.BlockObjMomoirosansimai)
    	{
    		return new DqmTileEntityObjMomoirosansimai();
    	}else if(this == DQMobObjects.BlockObjMomon)
    	{
    		return new DqmTileEntityObjMomon();
    	}else if(this == DQMobObjects.BlockObjMomonja)
    	{
    		return new DqmTileEntityObjMomonja();
    	}else if(this == DQMobObjects.BlockObjMoonkimera)
    	{
    		return new DqmTileEntityObjMoonkimera();
    	}else if(this == DQMobObjects.BlockObjMrippusu)
    	{
    		return new DqmTileEntityObjMrippusu();
    	}else if(this == DQMobObjects.BlockObjNightwalker)
    	{
    		return new DqmTileEntityObjNightwalker();
    	}else if(this == DQMobObjects.BlockObjNoroinoiwa)
    	{
    		return new DqmTileEntityObjNoroinoiwa();
    	}else if(this == DQMobObjects.BlockObjNorowaretaturugi)
    	{
    		return new DqmTileEntityObjNorowaretaturugi();
    	}else if(this == DQMobObjects.BlockObjObakekinoko)
    	{
    		return new DqmTileEntityObjObakekinoko();
    	}else if(this == DQMobObjects.BlockObjObakekyandoru)
    	{
    		return new DqmTileEntityObjObakekyandoru();
    	}else if(this == DQMobObjects.BlockObjObakeumiusi)
    	{
    		return new DqmTileEntityObjObakeumiusi();
    	}else if(this == DQMobObjects.BlockObjOdoruhouseki)
    	{
    		return new DqmTileEntityObjOdoruhouseki();
    	}else if(this == DQMobObjects.BlockObjOnikozou)
    	{
    		return new DqmTileEntityObjOnikozou();
    	}else if(this == DQMobObjects.BlockObjOokiduti)
    	{
    		return new DqmTileEntityObjOokiduti();
    	}else if(this == DQMobObjects.BlockObjOokutibasi)
    	{
    		return new DqmTileEntityObjOokutibasi();
    	}else if(this == DQMobObjects.BlockObjOomedama)
    	{
    		return new DqmTileEntityObjOomedama();
    	}else if(this == DQMobObjects.BlockObjOonamekuji)
    	{
    		return new DqmTileEntityObjOonamekuji();
    	}else if(this == DQMobObjects.BlockObjPandorabox)
    	{
    		return new DqmTileEntityObjPandorabox();
    	}else if(this == DQMobObjects.BlockObjPandorakibako)
    	{
    		return new DqmTileEntityObjPandorakibako();
    	}else if(this == DQMobObjects.BlockObjPapetkozou)
    	{
    		return new DqmTileEntityObjPapetkozou();
    	}else if(this == DQMobObjects.BlockObjPapettoman)
    	{
    		return new DqmTileEntityObjPapettoman();
    	}else if(this == DQMobObjects.BlockObjPikusi)
    	{
    		return new DqmTileEntityObjPikusi();
    	}else if(this == DQMobObjects.BlockObjPinkbonbon)
    	{
    		return new DqmTileEntityObjPinkbonbon();
    	}else if(this == DQMobObjects.BlockObjPinkmomon)
    	{
    		return new DqmTileEntityObjPinkmomon();
    	}else if(this == DQMobObjects.BlockObjPisaronaito)
    	{
    		return new DqmTileEntityObjPisaronaito();
    	}else if(this == DQMobObjects.BlockObjPombom)
    	{
    		return new DqmTileEntityObjPombom();
    	}else if(this == DQMobObjects.BlockObjPuratinaking)
    	{
    		return new DqmTileEntityObjPuratinaking();
    	}else if(this == DQMobObjects.BlockObjPuremiasuraimu)
    	{
    		return new DqmTileEntityObjPuremiasuraimu();
    	}else if(this == DQMobObjects.BlockObjPurizunyan)
    	{
    		return new DqmTileEntityObjPurizunyan();
    	}else if(this == DQMobObjects.BlockObjPuyon)
    	{
    		return new DqmTileEntityObjPuyon();
    	}else if(this == DQMobObjects.BlockObjRaimusuraimu)
    	{
    		return new DqmTileEntityObjRaimusuraimu();
    	}else if(this == DQMobObjects.BlockObjReddoatya)
    	{
    		return new DqmTileEntityObjReddoatya();
    	}else if(this == DQMobObjects.BlockObjRedsaikuron)
    	{
    		return new DqmTileEntityObjRedsaikuron();
    	}else if(this == DQMobObjects.BlockObjRemonsuraimu)
    	{
    		return new DqmTileEntityObjRemonsuraimu();
    	}else if(this == DQMobObjects.BlockObjRippusu)
    	{
    		return new DqmTileEntityObjRippusu();
    	}else if(this == DQMobObjects.BlockObjRiripat)
    	{
    		return new DqmTileEntityObjRiripat();
    	}else if(this == DQMobObjects.BlockObjRyuiso)
    	{
    		return new DqmTileEntityObjRyuiso();
    	}else if(this == DQMobObjects.BlockObjRyuuou)
    	{
    		return new DqmTileEntityObjRyuuou();
    	}else if(this == DQMobObjects.BlockObjRyuuou2)
    	{
    		return new DqmTileEntityObjRyuuou2();
    	}else if(this == DQMobObjects.BlockObjSabotenboru)
    	{
    		return new DqmTileEntityObjSabotenboru();
    	}else if(this == DQMobObjects.BlockObjSabotengold)
    	{
    		return new DqmTileEntityObjSabotengold();
    	}else if(this == DQMobObjects.BlockObjSaikuropusu)
    	{
    		return new DqmTileEntityObjSaikuropusu();
    	}else if(this == DQMobObjects.BlockObjSamayoutamasii)
    	{
    		return new DqmTileEntityObjSamayoutamasii();
    	}else if(this == DQMobObjects.BlockObjSamayouyoroi)
    	{
    		return new DqmTileEntityObjSamayouyoroi();
    	}else if(this == DQMobObjects.BlockObjSeigin)
    	{
    		return new DqmTileEntityObjSeigin();
    	}else if(this == DQMobObjects.BlockObjShuvaluts)
    	{
    		return new DqmTileEntityObjShuvaluts();
    	}else if(this == DQMobObjects.BlockObjSibireageha)
    	{
    		return new DqmTileEntityObjSibireageha();
    	}else if(this == DQMobObjects.BlockObjSibiredanbira)
    	{
    		return new DqmTileEntityObjSibiredanbira();
    	}else if(this == DQMobObjects.BlockObjSibirekurage)
    	{
    		return new DqmTileEntityObjSibirekurage();
    	}else if(this == DQMobObjects.BlockObjSimasimacat)
    	{
    		return new DqmTileEntityObjSimasimacat();
    	}else if(this == DQMobObjects.BlockObjSirubadebiru)
    	{
    		return new DqmTileEntityObjSirubadebiru();
    	}else if(this == DQMobObjects.BlockObjSirubamanto)
    	{
    		return new DqmTileEntityObjSirubamanto();
    	}else if(this == DQMobObjects.BlockObjSirudoaniki)
    	{
    		return new DqmTileEntityObjSirudoaniki();
    	}else if(this == DQMobObjects.BlockObjSirudokozou)
    	{
    		return new DqmTileEntityObjSirudokozou();
    	}else if(this == DQMobObjects.BlockObjSiryou)
    	{
    		return new DqmTileEntityObjSiryou();
    	}else if(this == DQMobObjects.BlockObjSiryounokisi)
    	{
    		return new DqmTileEntityObjSiryounokisi();
    	}else if(this == DQMobObjects.BlockObjSkullgaroo)
    	{
    		return new DqmTileEntityObjSkullgaroo();
    	}else if(this == DQMobObjects.BlockObjSodofantomu)
    	{
    		return new DqmTileEntityObjSodofantomu();
    	}else if(this == DQMobObjects.BlockObjStarkimera)
    	{
    		return new DqmTileEntityObjStarkimera();
    	}else if(this == DQMobObjects.BlockObjStonman)
    	{
    		return new DqmTileEntityObjStonman();
    	}else if(this == DQMobObjects.BlockObjSukippaa)
    	{
    		return new DqmTileEntityObjSukippaa();
    	}else if(this == DQMobObjects.BlockObjSumairurokku)
    	{
    		return new DqmTileEntityObjSumairurokku();
    	}else if(this == DQMobObjects.BlockObjSumoruguru)
    	{
    		return new DqmTileEntityObjSumoruguru();
    	}else if(this == DQMobObjects.BlockObjSunomon)
    	{
    		return new DqmTileEntityObjSunomon();
    	}else if(this == DQMobObjects.BlockObjSupekutetto)
    	{
    		return new DqmTileEntityObjSupekutetto();
    	}else if(this == DQMobObjects.BlockObjSupini)
    	{
    		return new DqmTileEntityObjSupini();
    	}else if(this == DQMobObjects.BlockObjSura)
    	{
    		return new DqmTileEntityObjSura();
    	}else if(this == DQMobObjects.BlockObjSura2)
    	{
    		return new DqmTileEntityObjSura2();
    	}else if(this == DQMobObjects.BlockObjSuraimubehomazun)
    	{
    		return new DqmTileEntityObjSuraimubehomazun();
    	}else if(this == DQMobObjects.BlockObjSuraimubesu)
    	{
    		return new DqmTileEntityObjSuraimubesu();
    	}else if(this == DQMobObjects.BlockObjSuraimubogu)
    	{
    		return new DqmTileEntityObjSuraimubogu();
    	}else if(this == DQMobObjects.BlockObjSuraimuburesu)
    	{
    		return new DqmTileEntityObjSuraimuburesu();
    	}else if(this == DQMobObjects.BlockObjSuraimuhaitawa)
    	{
    		return new DqmTileEntityObjSuraimuhaitawa();
    	}else if(this == DQMobObjects.BlockObjSuraimujeneraru)
    	{
    		return new DqmTileEntityObjSuraimujeneraru();
    	}else if(this == DQMobObjects.BlockObjSuraimuking)
    	{
    		return new DqmTileEntityObjSuraimuking();
    	}else if(this == DQMobObjects.BlockObjSuraimumadyura)
    	{
    		return new DqmTileEntityObjSuraimumadyura();
    	}else if(this == DQMobObjects.BlockObjSuraimunaito)
    	{
    		return new DqmTileEntityObjSuraimunaito();
    	}else if(this == DQMobObjects.BlockObjSuraimutawa)
    	{
    		return new DqmTileEntityObjSuraimutawa();
    	}else if(this == DQMobObjects.BlockObjSuraimutumuri)
    	{
    		return new DqmTileEntityObjSuraimutumuri();
    	}else if(this == DQMobObjects.BlockObjSweetbag)
    	{
    		return new DqmTileEntityObjSweetbag();
    	}else if(this == DQMobObjects.BlockObjSyado)
    	{
    		return new DqmTileEntityObjSyado();
    	}else if(this == DQMobObjects.BlockObjTahodoraki)
    	{
    		return new DqmTileEntityObjTahodoraki();
    	}else if(this == DQMobObjects.BlockObjTaipug)
    	{
    		return new DqmTileEntityObjTaipug();
    	}else if(this == DQMobObjects.BlockObjTattyan)
    	{
    		return new DqmTileEntityObjTattyan();
    	}else if(this == DQMobObjects.BlockObjTogebouzu)
    	{
    		return new DqmTileEntityObjTogebouzu();
    	}else if(this == DQMobObjects.BlockObjTogekonbou)
    	{
    		return new DqmTileEntityObjTogekonbou();
    	}else if(this == DQMobObjects.BlockObjTomosibikozou)
    	{
    		return new DqmTileEntityObjTomosibikozou();
    	}else if(this == DQMobObjects.BlockObjTonburero)
    	{
    		return new DqmTileEntityObjTonburero();
    	}else if(this == DQMobObjects.BlockObjTororu)
    	{
    		return new DqmTileEntityObjTororu();
    	}else if(this == DQMobObjects.BlockObjTororubakkosu)
    	{
    		return new DqmTileEntityObjTororubakkosu();
    	}else if(this == DQMobObjects.BlockObjTororubonba)
    	{
    		return new DqmTileEntityObjTororubonba();
    	}else if(this == DQMobObjects.BlockObjTororuking)
    	{
    		return new DqmTileEntityObjTororuking();
    	}else if(this == DQMobObjects.BlockObjTubo)
    	{
    		return new DqmTileEntityObjTubo();
    	}else if(this == DQMobObjects.BlockObjTubokku)
    	{
    		return new DqmTileEntityObjTubokku();
    	}else if(this == DQMobObjects.BlockObjTukaima)
    	{
    		return new DqmTileEntityObjTukaima();
    	}else if(this == DQMobObjects.BlockObjTumurinmama)
    	{
    		return new DqmTileEntityObjTumurinmama();
    	}else if(this == DQMobObjects.BlockObjTutiwarasi)
    	{
    		return new DqmTileEntityObjTutiwarasi();
    	}else if(this == DQMobObjects.BlockObjTyokonuba)
    	{
    		return new DqmTileEntityObjTyokonuba();
    	}else if(this == DQMobObjects.BlockObjUmibouzu)
    	{
    		return new DqmTileEntityObjUmibouzu();
    	}else if(this == DQMobObjects.BlockObjUmiusi)
    	{
    		return new DqmTileEntityObjUmiusi();
    	}else if(this == DQMobObjects.BlockObjUragirikozou)
    	{
    		return new DqmTileEntityObjUragirikozou();
    	}else if(this == DQMobObjects.BlockObjUzusioking)
    	{
    		return new DqmTileEntityObjUzusioking();
    	}else if(this == DQMobObjects.BlockObjWanpakusatan)
    	{
    		return new DqmTileEntityObjWanpakusatan();
    	}else if(this == DQMobObjects.BlockObjWaraibukuro)
    	{
    		return new DqmTileEntityObjWaraibukuro();
    	}else if(this == DQMobObjects.BlockObjYamatanooroti)
    	{
    		return new DqmTileEntityObjYamatanooroti();
    	}else if(this == DQMobObjects.BlockObjYouganmajin)
    	{
    		return new DqmTileEntityObjYouganmajin();
    	}else if(this == DQMobObjects.BlockObjZinmentyou)
    	{
    		return new DqmTileEntityObjZinmentyou();
    	}else if(this == DQMobObjects.BlockObjZoma)
    	{
    		return new DqmTileEntityObjZoma();
    	}else if(this == DQMobObjects.BlockObjZukkinya)
    	{
    		return new DqmTileEntityObjZukkinya();
    	}else if(this == DQMobObjects.BlockObjKandata)
    	{
    		return new DqmTileEntityObjKandata();
    	}else if(this == DQMobObjects.BlockObjBlackchack)
    	{
    		return new DqmTileEntityObjBlackchack();
    	}else if(this == DQMobObjects.BlockObjSuraimuemperor)
    	{
    		return new DqmTileEntityObjSuraimuemperor();
    	}else if(this == DQMobObjects.BlockObjDarkdoriado)
    	{
    		return new DqmTileEntityObjDarkdoriado();
    	}else if(this == DQMobObjects.BlockObjShadopan)
    	{
    		return new DqmTileEntityObjShadopan();
    	}else if(this == DQMobObjects.BlockObjShadopan2)
    	{
    		return new DqmTileEntityObjShadopan2();
    	}else if(this == DQMobObjects.BlockObjOrutega)
    	{
    		return new DqmTileEntityObjOrutega();
    	}

    	return new DqmTileEntityObjSura();
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
