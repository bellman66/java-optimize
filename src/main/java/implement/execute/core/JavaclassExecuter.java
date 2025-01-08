package implement.execute.core;

public class JavaclassExecuter {

    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "implement/execute/core/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();

        Class<?> clazz = loader.loadByte(modiBytes);
        try {
            clazz.getMethod("compileLoop").invoke(null);
        } catch (Exception e) {
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}
