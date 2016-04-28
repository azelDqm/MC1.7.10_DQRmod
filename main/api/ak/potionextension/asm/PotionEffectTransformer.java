package ak.potionextension.asm;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import dqr.asm.ClassNodeDum;

/**
 * Created by A.K. on 14/07/07.
 */
public class PotionEffectTransformer implements IClassTransformer, Opcodes {

    private static final String TARGET_CLASS_NAME = "net.minecraft.potion.PotionEffect";
    private static final String TARGET_CLASS_NAME2 = "net.minecraft.util.CombatTracker";
    private static final String TARGET_CLASS_NAME3 = "net.minecraft.enchantment.EnumEnchantmentType";
    private static final String TARGET_CLASS_NAME4 = "net.minecraft.client.renderer.EntityRenderer";

    //private static final String TARGET_CLASS_NAME4 = "net.minecraft.client.renderer.entity.RenderPlayer";
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (/*!FMLLaunchHandler.side().isClient() || */!transformedName.equals(TARGET_CLASS_NAME) && !transformedName.equals(TARGET_CLASS_NAME4) && !transformedName.equals(TARGET_CLASS_NAME2) && !transformedName.equals(TARGET_CLASS_NAME3)) {return basicClass;}

        try {
        	if(transformedName.equals(TARGET_CLASS_NAME))
        	{
	            PotionExtensionCorePlugin.LOGGER.info("Start transforming PotionEffect Class");
	            ClassReader classReader = new ClassReader(basicClass);
	            ClassWriter classWriter = new ClassWriter(1);
	            classReader.accept(new CustomVisitor(name, classWriter), 8);
	            PotionExtensionCorePlugin.LOGGER.info("Finish transforming PotionEffect Class");

	            return classWriter.toByteArray();
        	}else if(transformedName.equals(TARGET_CLASS_NAME3))
        	{
        		//System.out.println("DEBUGLINE3:**********************************************ENCHANT***********************");
        		return hookEnumEnchantment(basicClass);
        	}else if(transformedName.equals(TARGET_CLASS_NAME4))
        	{
        		return hookEntityRenderer(basicClass);
        	}else
        	{
        		//return replaceClass(basicClass);
        		return hookDoRenderLivingMethod(basicClass);

        	}


        	/*
        	else if(transformedName.equals(TARGET_CLASS_NAME4))
        	{
        		//System.out.println("DEBUGLINE3:**********************************************ENCHANT***********************");
        		return hookRenderPlayer(basicClass);
        	}
        	*/

        } catch (Exception e) {
            throw new RuntimeException("failed : PotionEffectTransformer loading", e);
        }
    }

    private byte[] replaceClass(byte[] bytes) throws IOException
    {
        ZipFile zf = null;
        InputStream zi = null;

        try
        {
            zf = new ZipFile(PotionExtensionCorePlugin.location);
            // 差し替え後のファイルです。coremodのjar内のパスを指定します。
            ZipEntry ze = zf.getEntry("dqr/asm/patch/CombatTracker.class");
            if (ze != null)
            {
                zi = zf.getInputStream(ze);
                bytes = new byte[(int) ze.getSize()];
                zi.read(bytes);
                System.out.println("CombatTrackerClass patching success!!:");
            }else
            {
            	System.out.println("CombatTrackerClass patching failed!!:");
            }


            return bytes;
        } catch (Exception e) {
            throw new RuntimeException("failed : PotionEffectTransformer loading", e);
        }
        finally
        {
            if (zi != null)
            {
                zi.close();
            }

            if (zf != null)
            {
                zf.close();
            }
        }
    }


    /*Custom ClassVisitor
    * visitMethodでメソッドを一から書き直すことが出来る。*/
    class CustomVisitor extends ClassVisitor {
        //難読化後のクラス名。FMLDeobfuscatingRemapper.INSTANCE.mapMethodNameを使う際に使用。
        String owner;
        public CustomVisitor(String owner ,ClassVisitor cv) {
            super(Opcodes.ASM4, cv);
            this.owner = owner;
        }
        static final String TARGET_METHOD_NAME1 = "func_76455_a";//onUpdate
        static final String TARGET_METHOD_NAME_DEBUG1 = "onUpdate";
        static final String TARGET_METHOD_DESC1 = "(Lnet/minecraft/entity/EntityLivingBase;)Z";//method description

        static final String TARGET_METHOD_NAME2 = "func_82722_b";//readCustomPotionEffectFromNBT
        static final String TARGET_METHOD_NAME_DEBUG2 = "readCustomPotionEffectFromNBT";
        static final String TARGET_METHOD_DESC2 = "(Lnet/minecraft/nbt/NBTTagCompound;)Lnet/minecraft/potion/PotionEffect;";//method description

        static final String TARGET_METHOD_NAME3 = "func_76456_a";//getPotionID
        static final String TARGET_METHOD_NAME_DEBUG3 = "getPotionID";
        static final String TARGET_METHOD_DESC3 = "()I";//method description

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            //onUpdateメソッドの書き換え
            if (TARGET_METHOD_NAME1.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(owner, name, desc))
                    && TARGET_METHOD_DESC1.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodDesc(desc))) {
                PotionExtensionCorePlugin.LOGGER.info("Transforming onUpdate method");
                return new CustomMethodVisitor1(this.api, super.visitMethod(access, name, desc, signature, exceptions));
            }
            //readCustomPotionEffectFromNBTメソッドの書き換え
            if (TARGET_METHOD_NAME2.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(owner, name, desc))
                    && TARGET_METHOD_DESC2.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodDesc(desc))) {
                PotionExtensionCorePlugin.LOGGER.info("Transforming readCustomPotionEffectFromNBT method");
                return new CustomMethodVisitor2(this.api, super.visitMethod(access, name, desc, signature, exceptions));
            }
            //getPotionIDメソッドの書き換え
            if (TARGET_METHOD_NAME3.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(owner, name, desc))
                    && TARGET_METHOD_DESC3.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodDesc(desc))) {
                PotionExtensionCorePlugin.LOGGER.info("Transforming getPotionID method");
                return new CustomMethodVisitor3(this.api, super.visitMethod(access, name, desc, signature, exceptions));
            }


            return super.visitMethod(access, name, desc, signature, exceptions);
        }
    }

    /*Custom MethodVisitor
    * visit**Methodで、InsnNodeの入れ替えや、追加等出来る。*/
    class CustomMethodVisitor1 extends MethodVisitor {
        public CustomMethodVisitor1(int api, MethodVisitor mv) {
            super(api, mv);
        }
        //visitFieldInsnメソッドの1回めの呼び出しで処理するためのフラグ
        boolean check = false;

        @Override
        public void visitFieldInsn(int opcode, String owner, String name, String desc) {
            //判定。ここは実は、checkだけ見ればよい。
            if (opcode == GETFIELD && desc.equals("I") && !check) {
                check = true;
                PotionExtensionCorePlugin.LOGGER.info("onUpdate:change id in [0 - 255]");
                //これは、PUTFIELDとのペア
                super.visitVarInsn(ALOAD, 0);
                //この２つはペア
                super.visitVarInsn(ALOAD, 0);
                super.visitFieldInsn(GETFIELD, "net/minecraft/potion/PotionEffect", "field_76462_a", "I");//potionID
                //ここで、スタックに数字が１つスタックされる。
                //256をスタック
                super.visitIntInsn(SIPUSH, 256);
                //スタックされた２つの数字を加算する
                super.visitInsn(IADD);
                //加算された数字がスタックされる。
                //もう一度256をスタック
                super.visitIntInsn(SIPUSH, 256);
                //スタックされている２つの数字のうち、あとの数字で最初の数字の剰余をとる
                super.visitInsn(IREM);
                //剰余がスタックされる。
                //スタックされた数字をフィールドに代入する
                super.visitFieldInsn(PUTFIELD, "net/minecraft/potion/PotionEffect", "field_76462_a", "I");//potionID
            }
            super.visitFieldInsn(opcode, owner, name, desc);
        }
    }

    class CustomMethodVisitor2 extends MethodVisitor {
        public CustomMethodVisitor2(int api, MethodVisitor mv) {
            super(api, mv);
        }
        //visitMethodInsnが複数あるため、直前のfieldNameを保存する。
        String fieldName = "";
        @Override
        public void visitLdcInsn(Object cst) {
            if (cst.equals("Id")) {
                fieldName = (String)cst;
            }
            super.visitLdcInsn(cst);
        }
        //識別用description
        static final String TARGET_DESC = "(Ljava/lang/String;)B";
        @Override
        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
            super.visitMethodInsn(opcode, owner, name, desc);
            //処理を割りこませる部分を判定
            if (opcode == INVOKEVIRTUAL && TARGET_DESC.equals(desc) && fieldName.equals("Id")) {
                PotionExtensionCorePlugin.LOGGER.info("readCustomPotionEffectFromNBT:change id in [0 - 255]");
                //256をスタック
                super.visitIntInsn(SIPUSH, 256);
                //スタックされた２つの数字を加算する
                super.visitInsn(IADD);
                //加算された数字がスタックされる。
                //もう一度256をスタック
                super.visitIntInsn(SIPUSH, 256);
                //スタックされている２つの数字のうち、あとの数字で最初の数字の剰余をとる
                super.visitInsn(IREM);
                //剰余がスタックされる。
                //代入してないが、このメソッドが呼ばれたあと、代入処理が呼ばれている。PotionEffectクラスのバイトコードを参照のこと。
            }
        }
    }

    class CustomMethodVisitor3 extends MethodVisitor {
        public CustomMethodVisitor3(int api, MethodVisitor mv) {
            super(api, mv);
        }

        @Override
        public void visitFieldInsn(int opcode, String owner, String name, String desc) {
            //1回しか呼ばれないので、判定なしで、処理を挟み込む。
            PotionExtensionCorePlugin.LOGGER.info("getPotionID:change id in [0 - 255]");
            super.visitFieldInsn(opcode, owner, name, desc);
            super.visitIntInsn(SIPUSH, 256);
            super.visitInsn(IADD);
            super.visitIntInsn(SIPUSH, 256);
            super.visitInsn(IREM);
            //代入してないが、このメソッドが呼ばれたあと、代入処理が呼ばれている。PotionEffectクラスのバイトコードを参照のこと。
        }
    }


    private byte[] hookDoRenderLivingMethod(byte[] bytes)
    {
        // ASMで、bytesに格納されたクラスファイルを解析します。
        ClassNode cnode = new ClassNode();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "func_94547_a";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        String targetMethoddesc = "(Lnet/minecraft/util/DamageSource;FF)V";

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
            InsnList overrideList = new InsnList();

            // メソッドコールを、バイトコードであらわした例です。
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "damMessage", "Ldqr/functions/FuncDamageMessage;"));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new FieldInsnNode(GETFIELD, "net/minecraft/util/CombatTracker", "fighter", "Lnet/minecraft/entity/EntityLivingBase;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(FLOAD, 2));
            overrideList.add(new VarInsnNode(FLOAD, 3));
            overrideList
                    .add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncDamageMessage", "message", "(Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/util/DamageSource;FF)V"));

            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。
            mnode.instructions.insert(mnode.instructions.get(1), overrideList);

            // 改変したクラスファイルをバイト列に書き出します
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            cnode.accept(cw);
            bytes = cw.toByteArray();
        }

        return bytes;
    }


    private byte[] hookEnumEnchantment(byte[] bytes)
    {
    	//System.out.println("DEBUGLINE1:**********************************************ENCHANT***********************");
        // ASMで、bytesに格納されたクラスファイルを解析します。
    	ClassNodeDum cnode = new ClassNodeDum();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "canEnchantItem";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        String targetMethoddesc = "(Lnet/minecraft/item/Item;)Z";

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
            InsnList overrideList = new InsnList();
            LabelNode l2 = new LabelNode();

            //System.out.println("DEBUGLINE2:**********************************************ENCHANT***********************");
            // メソッドコールを、バイトコードであらわした例です。
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "enchaHook", "Ldqr/functions/FuncEnchantExtension;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncEnchantExtension", "canEnchantItem", "(Lnet/minecraft/item/Item;Lnet/minecraft/enchantment/EnumEnchantmentType;)Z"));
            overrideList.add(new JumpInsnNode(IFEQ, l2));
            overrideList.add(new InsnNode(ICONST_1));
            overrideList.add(new InsnNode(IRETURN));
            overrideList.add(l2);
            /*
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "damMessage", "LdqmIII/functions/FuncDamageMessage;"));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new FieldInsnNode(GETFIELD, "net/minecraft/util/CombatTracker", "fighter", "Lnet/minecraft/entity/EntityLivingBase;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(FLOAD, 2));
            overrideList.add(new VarInsnNode(FLOAD, 3));
            overrideList
                    .add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncDamageMessage", "message", "(Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/util/DamageSource;FF)V"));
*/
            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。

            mnode.instructions.insert(mnode.instructions.get(1), overrideList);

            // 改変したクラスファイルをバイト列に書き出します
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

            cnode.accept(cw);
            bytes = cw.toByteArray();

        }

        return bytes;
    }














    private byte[] hookEntityRenderer(byte[] bytes)
    {
    	//System.out.println("DEBUGLINE1:**********************************************ENCHANT***********************");
        // ASMで、bytesに格納されたクラスファイルを解析します。
    	ClassNodeDum cnode = new ClassNodeDum();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "orientCamera";
        String targetMethodName2 = "func_78467_g";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        String targetMethoddesc = "(F)V";

        // 対象のメソッドを検索取得します。
        MethodNode mnode = null;
        for (MethodNode curMnode : (List<MethodNode>) cnode.methods)
        {
            if ((targetMethodName.equals(curMnode.name) || targetMethodName2.equals(curMnode.name)) && targetMethoddesc.equals(curMnode.desc))
            {
                mnode = curMnode;
                break;
            }
        }

        if (mnode != null)
        {
            InsnList overrideList = new InsnList();

            //System.out.println("DEBUGLINE2:**********************************************ENCHANT***********************");
            // メソッドコールを、バイトコードであらわした例です。
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "entityRenderHook", "Ldqr/functions/FuncEntityRenderExtension;"));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new VarInsnNode(FLOAD, 1));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncEntityRenderExtension", "hookOrientCamera", "(Lnet/minecraft/client/renderer/EntityRenderer;F)V"));
            /*
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "damMessage", "LdqmIII/functions/FuncDamageMessage;"));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new FieldInsnNode(GETFIELD, "net/minecraft/util/CombatTracker", "fighter", "Lnet/minecraft/entity/EntityLivingBase;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(FLOAD, 2));
            overrideList.add(new VarInsnNode(FLOAD, 3));
            overrideList
                    .add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncDamageMessage", "message", "(Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/util/DamageSource;FF)V"));
*/
            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。

            mnode.instructions.insert(mnode.instructions.get(1), overrideList);

            // 改変したクラスファイルをバイト列に書き出します
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

            cnode.accept(cw);
            bytes = cw.toByteArray();

        }

        return bytes;
    }
























    private byte[] hookRenderPlayer(byte[] bytes)
    {
    	//System.out.println("DEBUGLINE1:**********************************************ENCHANT***********************");
        // ASMで、bytesに格納されたクラスファイルを解析します。
    	ClassNodeDum cnode = new ClassNodeDum();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);

        // 改変対象のメソッド名です
        String targetMethodName = "doRender";
        //String targetMethodName = "func_76986_a";

        // 改変対象メソッドの戻り値型および、引数型をあらわします
        //String targetMethoddesc = "(Lnet.minecraft.client.entity.AbstractClientPlayer;DDDFF)V";
        String targetMethoddesc = "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF)V";
        // 対象のメソッドを検索取得します。
        MethodNode mnode = null;
        for (MethodNode curMnode : (List<MethodNode>) cnode.methods)
        {
        	//System.out.println("********CASE:" + targetMethodName + "/" + curMnode.name + "/" + targetMethodName.equals(curMnode.name));
        	//System.out.println("********CASE:" + targetMethoddesc + "/" + curMnode.desc + "/" + targetMethoddesc.equals(curMnode.desc));
            if (targetMethodName.equals(curMnode.name) && targetMethoddesc.equals(curMnode.desc))
            {
            	//System.out.println("DEBUGLINE3:**********************************************ENCHANT***********************");
                mnode = curMnode;
                break;
            }
        }

       //System.out.println("DEBUGLINE4:**********************************************ENCHANT***********************");

        if (mnode != null)
        {
            InsnList overrideList = new InsnList();
            LabelNode l2 = new LabelNode();
            LabelNode l3 = new LabelNode();

            //System.out.println("DEBUGLINE5:**********************************************ENCHANT***********************");



            /*
            for(int cnt = 0; cnt < mnode.instructions.size(); cnt++)
            {
            	AbstractInsnNode testX = mnode.instructions.get(cnt);

            	List<TypeAnnotationNode> texVBBB = testX.invisibleTypeAnnotations;
            	System.out.println("DEBUGLINE_A:");
            	if(texVBBB != null)
            	{
            		System.out.println("DEBUGLINE_B:");
	            	for(int cnt2 = 0; cnt2 < texVBBB.size(); cnt2++)
	            	{
	            		System.out.println("DEBUGLINE_10:**************:" + texVBBB.get(cnt2).desc);
	            	}
            	}

            	List<TypeAnnotationNode> texVAAA = testX.visibleTypeAnnotations;
            	System.out.println("DEBUGLINE_C:");
            	if(texVAAA != null)
            	{
            		System.out.println("DEBUGLINE_D:");
	            	for(int cnt2 = 0; cnt2 < texVAAA.size(); cnt2++)
	            	{
	            		System.out.println("DEBUGLINE_11:**************:" + texVAAA.get(cnt2).desc);
	            	}
            	}
            	//System.out.println("TESTLINE1:" + cnt);
            	//System.out.println(mnode.instructions.get(cnt));
            	System.out.println("DEBUGLINE_5:**************:");
            }
            */

            // メソッドコールを、バイトコードであらわした例です。



            /*
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "renderEvent", "Ldqr/api/event/RenderPlayerEvent2;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new VarInsnNode(FLOAD, 9));

            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/api/event/RenderPlayerEvent2", "doRenverEventHookPre", "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/client/renderer/entity/RenderPlayer;F)Z"));
            overrideList.add(new JumpInsnNode(IFEQ, l2));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(DLOAD, 2));
            overrideList.add(new VarInsnNode(DLOAD, 4));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new FieldInsnNode(GETFIELD, "net/minecraft/client/entity/AbstractClientPlayer","field_70129_M","F"));
            overrideList.add(new InsnNode(F2D));
            overrideList.add(new InsnNode(DSUB));
            overrideList.add(new VarInsnNode(DLOAD, 6));

            overrideList.add(new VarInsnNode(FLOAD, 8));
            overrideList.add(new VarInsnNode(FLOAD, 9));
            overrideList.add(new MethodInsnNode(INVOKESPECIAL, "net/minecraft/client/renderer/entity/RendererLivingEntity", "func_76986_a", "(Lnet/minecraft/entity/EntityLivingBase;DDDFF)V"));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new MethodInsnNode(INVOKESTATIC, "org/lwjgl/opengl/GL11", "glColor3f", "(FFF)V"));
            overrideList.add(l2);
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
			*/
            /*
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));

            overrideList.add(new MethodInsnNode(INVOKESTATIC, "org/lwjgl/opengl/GL11", "glColor3f", "(FFF)V"));

            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
			*/

            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "playerRenderHook", "Ldqr/functions/FuncRenderPlayerHook;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new VarInsnNode(FLOAD, 9));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncRenderPlayerHook", "doRenverEventHookPre", "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/client/renderer/entity/RenderPlayer;F)Z"));
            overrideList.add(new JumpInsnNode(IFEQ, l2));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new MethodInsnNode(INVOKESTATIC, "org/lwjgl/opengl/GL11", "glColor3f", "(FFF)V"));
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "playerRenderHook", "Ldqr/functions/FuncRenderPlayerHook;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(DLOAD, 2));
            overrideList.add(new VarInsnNode(DLOAD, 4));
            overrideList.add(new VarInsnNode(DLOAD, 6));
            overrideList.add(new VarInsnNode(FLOAD, 8));
            overrideList.add(new VarInsnNode(FLOAD, 9));
            //overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "renderEvent", "Ldqr/api/event/RenderPlayerEvent2;"));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncRenderPlayerHook", "doRenverEventHookD2calc", "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF)D"));
            overrideList.add(new VarInsnNode(DSTORE, 10));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(DLOAD, 2));
            overrideList.add(new VarInsnNode(DLOAD, 10));
            overrideList.add(new VarInsnNode(DLOAD, 6));
            overrideList.add(new VarInsnNode(FLOAD, 8));
            overrideList.add(new VarInsnNode(FLOAD, 9));
            overrideList.add(new MethodInsnNode(INVOKESPECIAL, "net/minecraft/client/renderer/entity/RendererLivingEntity", "doRender", "(Lnet/minecraft/entity/EntityLivingBase;DDDFF)V"));
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "playerRenderHook", "Ldqr/functions/FuncRenderPlayerHook;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new VarInsnNode(FLOAD, 9));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncRenderPlayerHook", "doRenverEventHookPost", "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/client/renderer/entity/RenderPlayer;F)Z"));
            overrideList.add(new InsnNode(POP));
            overrideList.add(new InsnNode(RETURN));
            overrideList.add(l2);
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));

            /*
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "renderEvent", "Ldqr/api/event/RenderPlayerEvent2;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new VarInsnNode(FLOAD, 9));

            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/api/event/RenderPlayerEvent2", "doRenverEventHookPre", "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/client/renderer/entity/RenderPlayer;F)Z"));
            overrideList.add(new JumpInsnNode(IFEQ, l2));

            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "org/lwjgl/opengl/GL11", "glColor3f", "(FFF)V"));

            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "renderEvent", "Ldqr/api/event/RenderPlayerEvent2;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(DLOAD, 2));
            overrideList.add(new VarInsnNode(DLOAD, 4));
            overrideList.add(new VarInsnNode(DLOAD, 6));
            overrideList.add(new VarInsnNode(FLOAD, 8));
            overrideList.add(new VarInsnNode(FLOAD, 9));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/api/event/RenderPlayerEvent2", "doRenverEventHookD2calc", "(Lnet/minecraft/client/entity/AbstractClientPlayer;DDDFF)D"));
            overrideList.add(new VarInsnNode(DSTORE, 10));
            overrideList.add(new VarInsnNode(ALOAD, 0));

            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(DLOAD, 2));
            overrideList.add(new VarInsnNode(DLOAD, 10));
            overrideList.add(new VarInsnNode(DLOAD, 6));
            overrideList.add(new VarInsnNode(FLOAD, 8));
            overrideList.add(new VarInsnNode(FLOAD, 9));
            overrideList.add(new MethodInsnNode(INVOKESPECIAL, "net/minecraft/client/renderer/entity/RendererLivingEntity", "func_76986_a", "(Lnet/minecraft/entity/EntityLivingBase;DDDFF)V"));
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "renderEvent", "Ldqr/api/event/RenderPlayerEvent2;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(ALOAD, 0));

            overrideList.add(new VarInsnNode(FLOAD, 9));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/api/event/RenderPlayerEvent2", "doRenverEventHookPost", "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/client/renderer/entity/RenderPlayer;F)Z"));
            overrideList.add(new JumpInsnNode(IFEQ, l3));

            overrideList.add(new InsnNode(IRETURN));
            overrideList.add(l3);
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(new InsnNode(FCONST_1));
            overrideList.add(l2);
*/
            /*
            overrideList.add(new FieldInsnNode(GETFIELD, "net/minecraft/client/entity/AbstractClientPlayer","field_70129_M","F"));
            overrideList.add(new InsnNode(F2D));
            overrideList.add(new InsnNode(DSUB));
            overrideList.add(new VarInsnNode(DSTORE, 10));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "net/minecraft/client/entity/AbstractClientPlayer", "field_70129_M", "(FFF)V"));
            overrideList.add(new InsnNode(F2D));
            overrideList.add(new InsnNode(DSUB));
            overrideList.add(new VarInsnNode(DSTORE, 10));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "net/minecraft/client/entity/AbstractClientPlayer", "func_70093_af", "()Z"));
            overrideList.add(new JumpInsnNode(IFEQ, l2));
            overrideList.add(new VarInsnNode(DLOAD, 10));

            overrideList.add(new FieldInsnNode(GETFIELD, "net/minecraft/client/entity/AbstractClientPlayer","isSneaking","F"));
            overrideList.add(new InsnNode(F2D));
            overrideList.add(new InsnNode(DSUB));
            overrideList.add(new VarInsnNode(DSTORE, 10));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            //overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "net/minecraft/client/entity/AbstractClientPlayer", "doRenverEventHookPre", "(Lyz;Lbop;F)Z"));
            overrideList.add(new FieldInsnNode(INVOKEVIRTUAL, "net/minecraft/client/entity/AbstractClientPlayer","isSneaking","F"));



            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/api/event/RenderPlayerEvent2", "doRenverEventHookPre", "()Z"));
            overrideList.add(new JumpInsnNode(IFEQ, l2));
            overrideList.add(new InsnNode(ICONST_1));
            overrideList.add(new InsnNode(IRETURN));
            overrideList.add(l2);
			*/
            /*
            overrideList.add(new FieldInsnNode(GETSTATIC, "dqr/DQR", "damMessage", "LdqmIII/functions/FuncDamageMessage;"));
            overrideList.add(new VarInsnNode(ALOAD, 0));
            overrideList.add(new FieldInsnNode(GETFIELD, "net/minecraft/util/CombatTracker", "fighter", "Lnet/minecraft/entity/EntityLivingBase;"));
            overrideList.add(new VarInsnNode(ALOAD, 1));
            overrideList.add(new VarInsnNode(FLOAD, 2));
            overrideList.add(new VarInsnNode(FLOAD, 3));
            overrideList
                    .add(new MethodInsnNode(INVOKEVIRTUAL, "dqr/functions/FuncDamageMessage", "message", "(Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/util/DamageSource;FF)V"));
*/
            // mnode.instructions.get(1)で、対象のメソッドの先頭を取得
            // mnode.instructions.insertで、指定した位置にバイトコードを挿入します。

            mnode.instructions.insert(mnode.instructions.get(1), overrideList);

            // 改変したクラスファイルをバイト列に書き出します
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

            cnode.accept(cw);
            bytes = cw.toByteArray();
            //System.out.println("DEBUGLINE5:**********************************************ENCHANT***********************");
        }

        return bytes;
    }
}
