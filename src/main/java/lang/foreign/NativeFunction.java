package lang.foreign;

//import java.lang.foreign.FunctionDescriptor;
//import java.lang.foreign.Linker;
//import java.lang.foreign.MemorySegment;
//import java.lang.foreign.SymbolLookup;
//import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NativeFunction {
//    @Test
//    void executeNativeFunction() throws Throwable {
//        Linker linker = Linker.nativeLinker();
//        SymbolLookup symbolLookup = linker.defaultLookup();
//        MemorySegment strlenMemorySegment = symbolLookup.find("strlen").orElseThrow();
//
//        FunctionDescriptor descriptor = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
//        MethodHandle strlenMethodHandle = linker.downcallHandle(strlenMemorySegment, descriptor);
//
//        String line = "Hello";
//        long length = (long) strlenMethodHandle.invoke(line);// 0L is a null pointer
//        Assertions.assertEquals(length, line.length());
//    }

//
}
