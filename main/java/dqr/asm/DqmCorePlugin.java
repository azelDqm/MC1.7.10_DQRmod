package dqr.asm;

import java.io.File;
import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

// TransformerExclusions: Transformerから除外するクラス名を設定するためのアノテーション
//
//  値は文字列の配列で、複数指定も可能です。
//  指定した文字列と前方一致するクラス名は、後述のクラスの動的な変換処理から除外されます。
//  例えば、自身のクラスが変換されないように、自身のパッケージ以下を除外指定する、などが出来ます。
//  必須ではありません。必要に応じて設定してください。
//  本チュートリアルでは、参考として自身のパッケージを変換処理から除外しています。
//
// IFMLLoadingPlugin: Coremods としてロードするために必要なインタフェース

@IFMLLoadingPlugin.MCVersion("1.7.10")
@TransformerExclusions({"dqr.asm"})
public class DqmCorePlugin implements IFMLLoadingPlugin
{
    // coremod の jar ファイルのパス抽象表現を保持します。
    // Transformer 以外から呼ばれることは考慮しないため、デフォルトのアクセス指定子としています。

    static File location;

    // このプラグインが動作するために必要となるライブラリセットのクラス名の配列です。
    // 本チュートリアルでは使用しないため説明は割愛します。
    // インターフェイスの javadocや、FMLCorePlugin クラスの実装を参照してみてください。

    public String[] getLibraryRequestClass()
    {
        return null;
    }

    // Class の改変機能を実装したクラスの完全修飾名の配列を返します。
    // 本チュートリアルの変換処理クラスは TutorialTransformer のみなので、一つだけを配列に詰め返却しています。

   //@Override
    public String[] getASMTransformerClass()
    {
        return new String[]{"dqr.asm.DqmTransFormer"};
    }

    // coremod の名前やバージョン情報を格納しているクラスの完全修飾名を返します。

    @Override
    public String getModContainerClass()
    {
        return "dqr.asm.DqmModContainer";
    }

    // IFMLCallHook を実装しているクラス名を返す必要があります。
    // 本チュートリアルでは、コールフックを用いないため、こちらの説明も割愛します。

    @Override
    public String getSetupClass()
    {
        return "dqr.asm.DepLoader";
    }

    // IFMLLoadingPlugin のメソッドです。(IFMLCallHook にも同じシグネチャーのメソッドがありますが、違います)
    // 今回は coremod 自身の jar ファイルパスを取得しています。これは後述のトランスフォーマークラスで、
    // jarから置換用クラスを取得しているためで、そのような処理を行わないのであれば何も実装しなくても構いません。
    //
    // なお、IFMLLoadingPlugin のメソッドとして呼ばれた際は、"mcLocation"、"coremodList"、"coremodLocation" の3つ、
    // IFMLCallHook のメソッドとして呼ばれた際は、"classLoader" がマップに設定されています。(FML#511現在)
    //
    // 渡されるマップの中身は、cpw.mods.fml.relauncher.RelaunchLibraryManager の実装からも確認する事が出来ます。


    @Override
    public void injectData(Map<String, Object> data)
    {
        for (String key : data.keySet()) {
            System.out.println("val : " + data.get(key) + "/key : " + key);
        }


        if (data.containsKey("coremodLocation"))
        {
            location = (File) data.get("coremodLocation");
        }
    }

	@Override
	public String getAccessTransformerClass() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}



 }
