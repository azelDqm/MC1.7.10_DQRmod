package ak.potionextension.asm;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by A.K. on 14/03/13.
 */
public class PotionArrayTransformer implements IClassTransformer, Opcodes{
    private static final String TARGET_CLASS_NAME = "net.minecraft.potion.Potion";//qi
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (/*!FMLLaunchHandler.side().isClient() || */!transformedName.equals(TARGET_CLASS_NAME)) {return basicClass;}
        try {
            PotionExtensionCorePlugin.LOGGER.info("Start transforming Potion Class");
            ClassReader classReader = new ClassReader(basicClass);
            ClassWriter classWriter = new ClassWriter(1);
            classReader.accept(new CustomVisitor(name,classWriter), 8);
            PotionExtensionCorePlugin.LOGGER.info("Finish transforming Potion Class");
//            return basicClass;
            return classWriter.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("failed : PotionArrayTransformer loading", e);
        }
    }

    /*Custom ClassVisitor
    * visitMethodでメソッドを一から書き直すことが出来る。*/
    class CustomVisitor extends ClassVisitor {
        //難読化後のクラス名。FMLDeobfuscatingRemapper.INSTANCE.mapMethodNameを使う際に使用。今回は使わない。
        String owner;
        public CustomVisitor(String owner ,ClassVisitor cv) {
            super(Opcodes.ASM4,cv);
            this.owner = owner;
        }
        static final String targetMethodName = "<clinit>";//static init method
        static final String targetMethodDesc = "()V";//static init method description

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            if (targetMethodName.equals(name) && targetMethodDesc.equals(desc)) {
                //static initメソッドの時のみ、Custom MethodVisitorを生成する。
                PotionExtensionCorePlugin.LOGGER.info("Transforming static init method");
                /*通常は、メソッド頭にフックを付けたりするのに使用。
                今回はInsnNodeの入れ替えなので、CustomMethodVisitorを生成して返している。*/
                return new CustomMethodVisitor(this.api, super.visitMethod(access, name, desc, signature, exceptions));
            }
            return super.visitMethod(access, name, desc, signature, exceptions);
        }
    }

    /*Custom MethodVisitor
    * visit**Methodで、InsnNodeの入れ替えや、追加等出来る。*/
    class CustomMethodVisitor extends MethodVisitor {
        public CustomMethodVisitor(int api, MethodVisitor mv) {
            super(api, mv);
        }

        static final int targetOpcode = Opcodes.BIPUSH;//Byteをスタックに入れるOpcode
        static final int targetOperand = 32;//もともとpushされる数字（Byte制限）
        static final int newOperand = Byte.MAX_VALUE;//pushしたい数字。ここでは固定した数字しか扱えない。

        @Override
        public void visitIntInsn(int opcode, int operand) {
            if (targetOpcode == opcode && targetOperand == operand) {
                //BIPUSH 32を、BIPUSH Byte.MAX_VALUEに入れ替える。
                PotionExtensionCorePlugin.LOGGER.info("Change BIPUSH 32 to BIPUSH BYTE.MAX_VALUE");
//                super.visitIntInsn(opcode, newOperand);
                /*Configから数字を持ってきて、代入したい場合、以下のように記述するとよい。
                * 第一引数：参照か、代入か。クラス変数か、インスタンス変数か。GETSTATIC, PUTSTATIC, GETFIELD or PUTFIELD.
                * 第二引数：変数持っているクラスの完全修飾名。但し,"."は"/"に変換のこと。
                * 第三引数：変数名。
                * 第四引数：変数の形名。整数型は"I"*/
                super.visitFieldInsn(GETSTATIC, "ak/potionextension/asm/PotionExtensionCorePlugin", "maxPotionArray", "I");
            } else super.visitIntInsn(opcode, operand);
        }
    }
}
