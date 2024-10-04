package lang.foreign;

public class LegacyJni {

    // load the shared library
    static {
        System.loadLibrary("legacy-jni");
    }

    private native void sayHello();

    public static void main(String[] args) {
        LegacyJni target = new LegacyJni();

        target.sayHello();
    }
}
