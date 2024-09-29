package lang.constant;

import java.lang.constant.ConstantDescs;
import java.lang.constant.DirectMethodHandleDesc;
import java.lang.constant.MethodHandleDesc;
import java.lang.constant.MethodTypeDesc;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClassDesc {

    @Test
    void test() {
        Class<?> clazz = String.class;
        System.out.println(clazz.describeConstable().get());
    }

    @Test
    void printClassDesc() {
        java.lang.constant.ClassDesc cdString = ConstantDescs.CD_String;

        Assertions.assertEquals("Ljava/lang/String;", cdString.descriptorString());
        Assertions.assertEquals("String", cdString.displayName());
    }

    @Test
    void printMethodDesc() {
        MethodTypeDesc methodType = MethodTypeDesc.of(ConstantDescs.CD_int, ConstantDescs.CD_String);

        MethodHandleDesc methodHandleDesc = MethodHandleDesc.of(
                DirectMethodHandleDesc.Kind.STATIC,
                ConstantDescs.CD_Integer,
                "parseInt",
                methodType.descriptorString()
        );

        // MethodHandleDesc 정보 출력
        Assertions.assertEquals(methodType.descriptorString(), "(Ljava/lang/String;)I");
        Assertions.assertEquals(methodHandleDesc.invocationType().toString(), "MethodTypeDesc[(String)int]");
    }

    @Test
    void fetchMethodHandle() throws Throwable {
        MethodType methodType = MethodType.methodType(int.class, String.class);

        MethodHandle methodHandle = MethodHandles.lookup().findStatic(
                Integer.class,
                "parseInt",
                methodType
        );

        int result = (int) methodHandle.invoke("42");

        Assertions.assertEquals(result, 42);
    }
}
