package dqr.asm;

import java.util.List;

//import cpw.mods.fml.relauncher.FMLRelauncher;
import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

// Opcodes : インプリメントすると、ASMによるバイトコード定数にアクセスするのに便利です。
// 必須ではありません。不用な場合は implements から削除してください。

public class DqmTransFormer implements IClassTransformer, Opcodes
{
    // 改変対象のクラスの完全修飾名です。
    // 後述でMinecraft.jar内の難読化されるファイルを対象とする場合の簡易な取得方法を紹介します。
	private static final String TARGET_CLASS_NAME = "net.minecraft.util.CombatTracker";
	private static final String TARGET_CLASS_NAME2 = "net.minecraft.enchantment.EnumEnchantmentType";
	//private static final String TARGET_CLASS_NAME3 = "net.minecraft.client.renderer.entity.RenderPlayer";
	private static final String TARGET_CLASS_NAME3 = "net.minecraft.client.renderer.EntityRenderer";
	private static final String TARGET_CLASS_NAME4 = "net.minecraft.util.FoodStats";
	private static final String TARGET_CLASS_NAME5 = "net.minecraft.entity.EntityLivingBase";
	private static final String TARGET_CLASS_NAME6 = "net.minecraft.block.BlockFarmland";
	private static final String TARGET_CLASS_NAME7 = "twilightforest.uncrafting.ContainerTFUncrafting";

    // クラスがロードされる際に呼び出されるメソッドです。
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes)
    {
        // FMLRelauncher.side() : Client/Server どちらか一方のを対象とする場合や、
        // 一つのMODで Client/Sever 両方に対応したMODで、この値を判定して処理を変える事ができます。
        // 今回は"CLIENT"と比較し、Client側のファイルを対象としている例です。
        // Client側専用のMODとして公開するのであれば、判定は必須ではありません。

        // name : 現在ロードされようとしているクラス名が格納されています。
        //if (!FMLRelauncher.side().equals("CLIENT") || !name.equals(TARGET_CLASS_NAME))

    	if (!transformedName.equals(TARGET_CLASS_NAME) && !transformedName.equals(TARGET_CLASS_NAME3) &&
    		!transformedName.equals(TARGET_CLASS_NAME2) && !transformedName.equals(TARGET_CLASS_NAME5) &&
    		!transformedName.equals(TARGET_CLASS_NAME6) && !transformedName.equals(TARGET_CLASS_NAME7))
        {
            // 処理対象外なので何もしない
            return bytes;
        }

    	//System.out.println("CombatTrackerClass patching TRY:");
        try
        {
            // --------------------------------------------------------------
            // クラスファイル丸ごと差し替える場合
            // --------------------------------------------------------------
            //return replaceClass(bytes);

            // --------------------------------------------------------------
            // ASMを使用し、既存のクラスファイルに改変を施す場合。
            // --------------------------------------------------------------
        	if(transformedName.equals(TARGET_CLASS_NAME))
        	{
        		return hookCombatTrackerMethod(bytes);
        	}else if(transformedName.equals(TARGET_CLASS_NAME2))
        	{
        		return hookEnumEnchantment(bytes);
        	}else if(transformedName.equals(TARGET_CLASS_NAME3))
        	{
        		return hookEntityRenderer(bytes);
        	}else if(transformedName.equals(TARGET_CLASS_NAME6))
        	{
        		return hookWaterSearchMethod(bytes);
        	}else if(transformedName.equals(TARGET_CLASS_NAME7))
        	{
        		return hookTFuncrafting(bytes);
        	}else
        	{
        		return bytes;
        	}
        	/*
        	else if(transformedName.equals(TARGET_CLASS_NAME5))
        	{
        		return hookEntityLivingBaseClass(bytes);
        	}*/

        }
        catch (Exception e)
        {
            throw new RuntimeException("failed : TutorialTransformer loading", e);
        }

    }



    private byte[] hookTFuncrafting(byte[] bytes)
    {
        // ASMで、bytesに格納されたクラスファイルを解析します。
    	System.out.println("twilight forest uncrafting patching START");
        ClassNodeDum cnode = new ClassNodeDum();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "a";
        String targetMethodName2 = "getRecipeFor";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        String targetMethoddesc = "(Ladd)Lafg";
        String targetMethoddesc2 = "(Ladd;)Lafg;";
        String targetMethoddesc3 = "(Ladd;)Lafg";
        String targetMethoddesc4 = "(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/crafting/IRecipe;";

        // 対象のメソッドを検索取得します。
        MethodNode mnode = null;
        for (MethodNode curMnode : (List<MethodNode>) cnode.methods)
        {
        	boolean flag = false;

        	//System.out.println("twilight forest uncrafting patching : name:" + curMnode.name + " / desc:" + curMnode.desc);
            if ((targetMethodName.equals(curMnode.name) || targetMethodName2.equals(curMnode.name)) &&
            		(targetMethoddesc.equals(curMnode.desc) || targetMethoddesc2.equals(curMnode.desc) ||
            		 targetMethoddesc3.equals(curMnode.desc) || targetMethoddesc4.equals(curMnode.desc))
            	)
            {
                mnode = curMnode;
                break;
            }
        }

        if (mnode != null)
        {
            try
            {
	        	System.out.println("ContainerTFUncrafting patching");
	            InsnList overrideList = new InsnList();

	            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "addons", "Ldqr/addons/DqrAddon;"));
	            overrideList.add(new InsnNode(POP));
	            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/addons/DqrAddon", "funcUncraftHook", "Ldqr/addons/twilightForest/FuncUncraftHook;"));
	            overrideList.add(new VarInsnNode(ALOAD, 1));
	            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/addons/twilightForest/FuncUncraftHook", "hookTFUncraft", "(Ladd;)Lafg;"));
	            overrideList.add(new InsnNode(ARETURN));

	            /*
	            LabelNode l5 = new LabelNode();

	            // メソッドコールを、バイトコードであらわした例です。
	            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "farmlandHook", "Ldqr/functions/FuncFarmlandExtension;"));
	            overrideList.add(new VarInsnNode(ALOAD, 1));
	            overrideList.add(new VarInsnNode(ILOAD, 2));
	            overrideList.add(new VarInsnNode(ILOAD, 3));
	            overrideList.add(new VarInsnNode(ILOAD, 4));
	            overrideList.add(new VarInsnNode(ALOAD, 0));
	            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncFarmlandExtension", "hookUpdateTick", "(Lahb;IIILaji;)Z"));
	            overrideList.add(new JumpInsnNode(IFEQ, l5));
	            //overrideList.add(new InsnNode(ICONST_1));
	            overrideList.add(new InsnNode(RETURN));
	            overrideList.add(l5);
	            */

	            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
	            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。
	            mnode.instructions.insert(mnode.instructions.get(1), overrideList);
	            // 改変したクラスファイルをバイト列に書き出します
	            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
	            System.out.println("ContainerTFUncrafting patching:" + cnode.name);
	            cnode.accept(cw);
	            bytes = cw.toByteArray();

	            System.out.println("ContainerTFUncrafting patching success!!:");
            } catch (Exception e) {
                throw new RuntimeException("failed : ContainerTFUncrafting patching ", e);
            }
        }

        return bytes;
    }



    private byte[] hookEntityLivingBaseClass(byte[] bytes)
    {
        // ASMで、bytesに格納されたクラスファイルを解析します。
    	System.out.println("EntityLivingBaseClass patching START");
        ClassNodeDum cnode = new ClassNodeDum();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "c";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        String targetMethoddesc = "(Lrw;)V";

        // 対象のメソッドを検索取得します。
        MethodNode mnode = null;
        for (MethodNode curMnode : (List<MethodNode>) cnode.methods)
        {
            if (targetMethodName.equals(curMnode.name) && targetMethoddesc.equals(curMnode.desc))
            {
                mnode = curMnode;
                break;
            }
        }

        if (mnode != null)
        {
            try
            {
	        	System.out.println("EntityLivingBaseClass patching");
	            InsnList overrideList = new InsnList();
	            //LabelNode l2 = new LabelNode();

	            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "entityLivingBHook", "Ldqr/functions/FuncEntityLivingBaseExtension;"));
	            overrideList.add(new VarInsnNode(ALOAD, 1));
	            overrideList.add(new VarInsnNode(ALOAD, 0));
	            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncEntityLivingBaseExtension", "hookAddPotionEffect", "(Lrw;Lsv;)Z"));
	            overrideList.add(new InsnNode(POP));

	            // メソッドコールを、バイトコードであらわした例です。
	            /*
	            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "entityLivingBHook", "Ldqr/functions/FuncEntityLivingBaseExtension;"));
	            overrideList.add(new VarInsnNode(ALOAD, 1));
	            overrideList.add(new VarInsnNode(ALOAD, 0));
	            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncEntityLivingBaseExtension", "hookAddPotionEffect", "(Lrw;Lsv;)Z"));
	            overrideList.add(new JumpInsnNode(IFEQ, l2));
	            overrideList.add(new InsnNode(IRETURN));
	            overrideList.add(l2);
	            */



	            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
	            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。
	            mnode.instructions.insert(mnode.instructions.get(1), overrideList);
	            // 改変したクラスファイルをバイト列に書き出します
	            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
	            System.out.println("EntityLivingBaseClass patching:" + cnode.name);
	            cnode.accept(cw);
	            bytes = cw.toByteArray();

	            System.out.println("EntityLivingBaseClass patching success!!:");
            } catch (Exception e) {
                throw new RuntimeException("failed : EntityLivingBaseClass patching ", e);
            }
        }

        return bytes;
    }




    private byte[] hookWaterSearchMethod(byte[] bytes)
    {
        // ASMで、bytesに格納されたクラスファイルを解析します。
    	System.out.println("BlockFarmlandClass patching START");
        ClassNodeDum cnode = new ClassNodeDum();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "a";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        String targetMethoddesc = "(Lahb;III)V";

        // 対象のメソッドを検索取得します。
        MethodNode mnode = null;
        for (MethodNode curMnode : (List<MethodNode>) cnode.methods)
        {
            if (targetMethodName.equals(curMnode.name) && targetMethoddesc.equals(curMnode.desc))
            {
                mnode = curMnode;
                break;
            }
        }

        if (mnode != null)
        {
            try
            {
	        	System.out.println("BlockFarmlandClass patching");
	            InsnList overrideList = new InsnList();
	            LabelNode l5 = new LabelNode();

	            // メソッドコールを、バイトコードであらわした例です。
	            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "farmlandHook", "Ldqr/functions/FuncFarmlandExtension;"));
	            overrideList.add(new VarInsnNode(ALOAD, 1));
	            overrideList.add(new VarInsnNode(ILOAD, 2));
	            overrideList.add(new VarInsnNode(ILOAD, 3));
	            overrideList.add(new VarInsnNode(ILOAD, 4));
	            overrideList.add(new VarInsnNode(ALOAD, 0));
	            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncFarmlandExtension", "hookUpdateTick", "(Lahb;IIILaji;)Z"));
	            overrideList.add(new JumpInsnNode(IFEQ, l5));
	            //overrideList.add(new InsnNode(ICONST_1));
	            overrideList.add(new InsnNode(RETURN));
	            overrideList.add(l5);

	            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
	            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。
	            mnode.instructions.insert(mnode.instructions.get(1), overrideList);
	            // 改変したクラスファイルをバイト列に書き出します
	            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
	            System.out.println("BlockFarmlandClass patching:" + cnode.name);
	            cnode.accept(cw);
	            bytes = cw.toByteArray();

	            System.out.println("BlockFarmlandClass patching success!!:");
            } catch (Exception e) {
                throw new RuntimeException("failed : BlockFarmlandClass patching ", e);
            }
        }

        return bytes;
    }





    private byte[] hookCombatTrackerMethod(byte[] bytes)
    {
        // ASMで、bytesに格納されたクラスファイルを解析します。
    	System.out.println("CombatTrackerClass patching START");
        ClassNodeDum cnode = new ClassNodeDum();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "a";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        String targetMethoddesc = "(Lro;FF)V";

        // 対象のメソッドを検索取得します。
        MethodNode mnode = null;
        for (MethodNode curMnode : (List<MethodNode>) cnode.methods)
        {
            if (targetMethodName.equals(curMnode.name) && targetMethoddesc.equals(curMnode.desc))
            {
                mnode = curMnode;
                break;
            }
        }

        if (mnode != null)
        {
            try
            {
	        	System.out.println("CombatTrackerClass patching");
	            InsnList overrideList = new InsnList();

	            // メソッドコールを、バイトコードであらわした例です。
	            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "damMessage", "Ldqr/functions/FuncDamageMessage;"));
	            overrideList.add(new VarInsnNode(ALOAD, 0));
	            overrideList.add(new FieldInsnNode(GETFIELD, "rn", "b", "Lsv;"));
	            overrideList.add(new VarInsnNode(ALOAD, 1));
	            overrideList.add(new VarInsnNode(FLOAD, 2));
	            overrideList.add(new VarInsnNode(FLOAD, 3));
	            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncDamageMessage", "message", "(Lsv;Lro;FF)V"));

	            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
	            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。
	            mnode.instructions.insert(mnode.instructions.get(1), overrideList);
	            // 改変したクラスファイルをバイト列に書き出します
	            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
	            System.out.println("CombatTrackerClass patching:" + cnode.name);
	            cnode.accept(cw);
	            bytes = cw.toByteArray();

	            System.out.println("CombatTrackerClass patching success!!:");
            } catch (Exception e) {
                throw new RuntimeException("failed : CombatTrackerClass patching ", e);
            }
        }

        return bytes;
    }


    private byte[] hookFoodStats(byte[] bytes)
    {
        // ASMで、bytesに格納されたクラスファイルを解析します。
    	System.out.println("FoodStatsClass patching START");
        ClassNodeDum cnode = new ClassNodeDum();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "a";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        String targetMethoddesc = "(Lro;FF)V";

        // 対象のメソッドを検索取得します。
        MethodNode mnode = null;
        for (MethodNode curMnode : (List<MethodNode>) cnode.methods)
        {
            if (targetMethodName.equals(curMnode.name) && targetMethoddesc.equals(curMnode.desc))
            {
                mnode = curMnode;
                break;
            }
        }

        if (mnode != null)
        {
            try
            {
	        	System.out.println("CombatTrackerClass patching");
	            InsnList overrideList = new InsnList();

	            // メソッドコールを、バイトコードであらわした例です。
	            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "damMessage", "Ldqr/functions/FuncDamageMessage;"));
	            overrideList.add(new VarInsnNode(ALOAD, 0));
	            overrideList.add(new FieldInsnNode(GETFIELD, "rn", "b", "Lsv;"));
	            overrideList.add(new VarInsnNode(ALOAD, 1));
	            overrideList.add(new VarInsnNode(FLOAD, 2));
	            overrideList.add(new VarInsnNode(FLOAD, 3));
	            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncDamageMessage", "message", "(Lsv;Lro;FF)V"));

	            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
	            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。
	            mnode.instructions.insert(mnode.instructions.get(1), overrideList);
	            // 改変したクラスファイルをバイト列に書き出します
	            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
	            System.out.println("CombatTrackerClass patching:" + cnode.name);
	            cnode.accept(cw);
	            bytes = cw.toByteArray();

	            System.out.println("CombatTrackerClass patching success!!:");
            } catch (Exception e) {
                throw new RuntimeException("failed : CombatTrackerClass patching ", e);
            }
        }

        return bytes;
    }

    private byte[] hookEnumEnchantment(byte[] bytes)
    {
        // ASMで、bytesに格納されたクラスファイルを解析します。
    	System.out.println("EnumEnchantmentrClass patching START");
    	ClassNodeDum cnode = new ClassNodeDum();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "a";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        String targetMethoddesc = "(Ladb;)Z";

        // 対象のメソッドを検索取得します。
        MethodNode mnode = null;
        for (MethodNode curMnode : (List<MethodNode>) cnode.methods)
        {
            if (targetMethodName.equals(curMnode.name) && targetMethoddesc.equals(curMnode.desc))
            {
                mnode = curMnode;
                break;
            }
        }

        if (mnode != null)
        {
        	System.out.println("EnumEnchantmentrClass patching");
            InsnList overrideList = new InsnList();
            LabelNode l2 = new LabelNode();

            // メソッドコールを、バイトコードであらわした例です。
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "enchaHook", "Ldqr/functions/FuncEnchantExtension;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncEnchantExtension", "canEnchantItem", "(Ladb;Lafu;)Z"));
            overrideList.add(new JumpInsnNode(IFEQ, l2));
            overrideList.add(new InsnNode(ICONST_1));
            overrideList.add(new InsnNode(IRETURN));
            overrideList.add(l2);

            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。

            mnode.instructions.insert(mnode.instructions.get(1), overrideList);

            // 改変したクラスファイルをバイト列に書き出します
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

            cnode.accept(cw);
            bytes = cw.toByteArray();
            System.out.println("EnumEnchantmentrClass patching success!!:");
        }

        return bytes;
    }



    private byte[] hookEntityRenderer(byte[] bytes)
    {
        // ASMで、bytesに格納されたクラスファイルを解析します。
    	System.out.println("EntityRendererClass patching START");
    	ClassNodeDum cnode = new ClassNodeDum();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "h";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        String targetMethoddesc = "(F)V";

        // 対象のメソッドを検索取得します。
        MethodNode mnode = null;
        for (MethodNode curMnode : (List<MethodNode>) cnode.methods)
        {
            if (targetMethodName.equals(curMnode.name) && targetMethoddesc.equals(curMnode.desc))
            {
                mnode = curMnode;
                break;
            }
        }

        if (mnode != null)
        {
        	System.out.println("EntityRendererClass patching");
            InsnList overrideList = new InsnList();

            // メソッドコールを、バイトコードであらわした例です。
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "entityRenderHook", "Ldqr/functions/FuncEntityRenderExtension;"));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new VarInsnNode(FLOAD, 1));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncEntityRenderExtension", "hookOrientCamera", "(Lblt;F)V"));

            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。

            mnode.instructions.insert(mnode.instructions.get(1), overrideList);

            // 改変したクラスファイルをバイト列に書き出します
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

            cnode.accept(cw);
            bytes = cw.toByteArray();
            System.out.println("EntityRendererClass patching success!!:");
        }

        return bytes;
    }
    /*
    private byte[] hookRenderPlayer(byte[] bytes)
    {
        // ASMで、bytesに格納されたクラスファイルを解析します。
    	System.out.println("RenderPlayerClass patching START");
    	ClassNodeDum cnode = new ClassNodeDum();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "a";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        String targetMethoddesc = "(Lblg;DDDFF)V";

        // 対象のメソッドを検索取得します。
        MethodNode mnode = null;
        for (MethodNode curMnode : (List<MethodNode>) cnode.methods)
        {
            if (targetMethodName.equals(curMnode.name) && targetMethoddesc.equals(curMnode.desc))
            {
                mnode = curMnode;
                break;
            }
        }

        if (mnode != null)
        {

        	System.out.println("EnumEnchantmentrClass patching");
            InsnList overrideList = new InsnList();
            LabelNode l2 = new LabelNode();


            // メソッドコールを、バイトコードであらわした例です。
            //overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "enchaHook", "Ldqr/functions/FuncEnchantExtension;"));
            //overrideList.add(new VarInsnNode(ALOAD, 1));
            //overrideList.add(new VarInsnNode(ALOAD, 0));
            //overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncEnchantExtension", "canEnchantItem", "(Ladb;Lafu;)Z"));
            //overrideList.add(new JumpInsnNode(IFEQ, l2));
            //overrideList.add(new InsnNode(ICONST_1));
            //overrideList.add(new InsnNode(IRETURN));
            //overrideList.add(l2);

            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。


            //for(int cnt = 0; cnt < mnode.instructions.size(); cnt++)
            //{
            //	System.out.println("TESTLINE1:" + cnt);
            //	System.out.println(mnode.instructions.get(cnt));
            //


            //mnode.instructions.insert(mnode.instructions.get(1), overrideList);

            // 改変したクラスファイルをバイト列に書き出します
            //ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

            //cnode.accept(cw);
            //bytes = cw.toByteArray();
            //System.out.println("RenderPlayerClass patching success!!:");

        }

        return bytes;
    }
    */


    // 下記の想定で実装されています。
    // EntityLiving.class の doRenderLiving の先頭に
    // tutorial/test.class の passTestRender(EntityLiving, double, double, double)メソッドの呼び出しを追加する。

    private byte[] hookDoRenderLivingMethod(byte[] bytes)
    {
        return bytes;
    }

}
