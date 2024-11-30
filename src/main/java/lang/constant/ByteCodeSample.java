package lang.constant;

import java.awt.print.Printable;

/**
 *  javap -c -v -l .\ByteCodeSample.class
 *
 *  Classfile /C:/workspace/java-optimize/build/classes/java/main/lang/constant/ByteCodeSample.class
 *   Last modified 2024. 11. 30.; size 1382 bytes
 *   MD5 checksum e4a0159615aa8cae7d8995bd22cd67f6
 *   Compiled from "ByteCodeSample.java"
 * public class lang.constant.ByteCodeSample
 *   minor version: 0
 *   major version: 61
 *   flags: (0x0021) ACC_PUBLIC, ACC_SUPER
 *   this_class: #8                          // lang/constant/ByteCodeSample
 *   super_class: #2                         // java/lang/Object
 *   interfaces: 0, fields: 3, methods: 3, attributes: 3
 * Constant pool:
 *    #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
 *    #2 = Class              #4             // java/lang/Object
 *    #3 = NameAndType        #5:#6          // "<init>":()V
 *    #4 = Utf8               java/lang/Object
 *    #5 = Utf8               <init>
 *    #6 = Utf8               ()V
 *    #7 = Fieldref           #8.#9          // lang/constant/ByteCodeSample.name:Ljava/lang/String;
 *    #8 = Class              #10            // lang/constant/ByteCodeSample
 *    #9 = NameAndType        #11:#12        // name:Ljava/lang/String;
 *   #10 = Utf8               lang/constant/ByteCodeSample
 *   #11 = Utf8               name
 *   #12 = Utf8               Ljava/lang/String;
 *   #13 = Fieldref           #14.#15        // java/lang/System.out:Ljava/io/PrintStream;
 *   #14 = Class              #16            // java/lang/System
 *   #15 = NameAndType        #17:#18        // out:Ljava/io/PrintStream;
 *   #16 = Utf8               java/lang/System
 *   #17 = Utf8               out
 *   #18 = Utf8               Ljava/io/PrintStream;
 *   #19 = InvokeDynamic      #0:#20         // #0:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
 *   #20 = NameAndType        #21:#22        // makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
 *   #21 = Utf8               makeConcatWithConstants
 *   #22 = Utf8               (Ljava/lang/String;)Ljava/lang/String;
 *   #23 = Methodref          #24.#25        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *   #24 = Class              #26            // java/io/PrintStream
 *   #25 = NameAndType        #27:#28        // println:(Ljava/lang/String;)V
 *   #26 = Utf8               java/io/PrintStream
 *   #27 = Utf8               println
 *   #28 = Utf8               (Ljava/lang/String;)V
 *   #29 = String             #30            // Sample
 *   #30 = Utf8               Sample
 *   #31 = Methodref          #8.#32         // lang/constant/ByteCodeSample."<init>":(Ljava/lang/String;)V
 *   #32 = NameAndType        #5:#28         // "<init>":(Ljava/lang/String;)V
 *   #33 = Fieldref           #8.#34         // lang/constant/ByteCodeSample.length:I
 *   #34 = NameAndType        #35:#36        // length:I
 *   #35 = Utf8               length
 *   #36 = Utf8               I
 *   #37 = Double             10.0d
 *   #39 = Methodref          #40.#41        // java/lang/Double.valueOf:(D)Ljava/lang/Double;
 *   #40 = Class              #42            // java/lang/Double
 *   #41 = NameAndType        #43:#44        // valueOf:(D)Ljava/lang/Double;
 *   #42 = Utf8               java/lang/Double
 *   #43 = Utf8               valueOf
 *   #44 = Utf8               (D)Ljava/lang/Double;
 *   #45 = Fieldref           #8.#46         // lang/constant/ByteCodeSample.value:Ljava/lang/Double;
 *   #46 = NameAndType        #47:#48        // value:Ljava/lang/Double;
 *   #47 = Utf8               value
 *   #48 = Utf8               Ljava/lang/Double;
 *   #49 = Utf8               Code
 *   #50 = Utf8               LineNumberTable
 *   #51 = Utf8               LocalVariableTable
 *   #52 = Utf8               this
 *   #53 = Utf8               Llang/constant/ByteCodeSample;
 *   #54 = Utf8               print
 *   #55 = Utf8               main
 *   #56 = Utf8               ([Ljava/lang/String;)V
 *   #57 = Utf8               args
 *   #58 = Utf8               [Ljava/lang/String;
 *   #59 = Utf8               sample
 *   #60 = Utf8               SourceFile
 *   #61 = Utf8               ByteCodeSample.java
 *   #62 = Utf8               BootstrapMethods
 *   #63 = MethodHandle       6:#64          // REF_invokeStatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
 *   #64 = Methodref          #65.#66        // java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
 *   #65 = Class              #67            // java/lang/invoke/StringConcatFactory
 *   #66 = NameAndType        #21:#68        // makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
 *   #67 = Utf8               java/lang/invoke/StringConcatFactory
 *   #68 = Utf8               (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
 *   #69 = String             #70            // Name: \u0001
 *   #70 = Utf8               Name: \u0001
 *   #71 = Utf8               InnerClasses
 *   #72 = Class              #73            // java/lang/invoke/MethodHandles$Lookup
 *   #73 = Utf8               java/lang/invoke/MethodHandles$Lookup
 *   #74 = Class              #75            // java/lang/invoke/MethodHandles
 *   #75 = Utf8               java/lang/invoke/MethodHandles
 *   #76 = Utf8               Lookup
 * {
 *   public int length;
 *     descriptor: I
 *     flags: (0x0001) ACC_PUBLIC
 *
 *   protected transient java.lang.Double value;
 *     descriptor: Ljava/lang/Double;
 *     flags: (0x0084) ACC_PROTECTED, ACC_TRANSIENT
 *
 *   public lang.constant.ByteCodeSample(java.lang.String);
 *     descriptor: (Ljava/lang/String;)V
 *     flags: (0x0001) ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: aload_0
 *          5: aload_1
 *          6: putfield      #7                  // Field name:Ljava/lang/String;
 *          9: return
 *       LineNumberTable:
 *         line 172: 0
 *         line 173: 4
 *         line 174: 9
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      10     0  this   Llang/constant/ByteCodeSample;
 *             0      10     1  name   Ljava/lang/String;
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: (0x0009) ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=3, locals=2, args_size=1
 *          0: new           #8                  // class lang/constant/ByteCodeSample
 *          3: dup
 *          4: ldc           #29                 // String Sample
 *          6: invokespecial #31                 // Method "<init>":(Ljava/lang/String;)V
 *          9: astore_1
 *         10: aload_1
 *         11: bipush        10
 *         13: putfield      #33                 // Field length:I
 *         16: aload_1
 *         17: ldc2_w        #37                 // double 10.0d
 *         20: invokestatic  #39                 // Method java/lang/Double.valueOf:(D)Ljava/lang/Double;
 *         23: putfield      #45                 // Field value:Ljava/lang/Double;
 *         26: return
 *       LineNumberTable:
 *         line 181: 0
 *         line 182: 10
 *         line 183: 16
 *         line 184: 26
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      27     0  args   [Ljava/lang/String;
 *            10      17     1 sample   Llang/constant/ByteCodeSample;
 * }
 * SourceFile: "ByteCodeSample.java"
 * BootstrapMethods:
 *   0: #63 REF_invokeStatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
 *     Method arguments:
 *       #69 Name: \u0001
 * InnerClasses:
 *   public static final #76= #72 of #74;    // Lookup=class java/lang/invoke/MethodHandles$Lookup of class java/lang/invoke/MethodHandles
 **/
public class ByteCodeSample {

    /**
     *    init()
     *
     *    #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
     *    #2 = Class              #4             // java/lang/Object
     *    #3 = NameAndType        #5:#6          // "<init>":()V
     *    #4 = Utf8               java/lang/Object
     *    #5 = Utf8               <init>
     *    #6 = Utf8               ()V
     */

    /**
     *    private String name;
     *
     *    #7 = Fieldref           #8.#9          // lang/constant/ByteCodeSample.name:Ljava/lang/String;
     *    #8 = Class              #10            // lang/constant/ByteCodeSample
     *    #9 = NameAndType        #11:#12        // name:Ljava/lang/String;
     *    #10 = Utf8               lang/constant/ByteCodeSample
     *    #11 = Utf8               name
     *    #12 = Utf8               Ljava/lang/String;
     */
    private String name;

    /**
     *   ref field PrintStream
     *
     *   #13 = Fieldref           #14.#15        // java/lang/System.out:Ljava/io/PrintStream;
     *   #14 = Class              #16            // java/lang/System
     *   #15 = NameAndType        #17:#18        // out:Ljava/io/PrintStream;
     *   #16 = Utf8               java/lang/System
     *   #17 = Utf8               out
     *   #18 = Utf8               Ljava/io/PrintStream;
     */

    /**
     *   public int length;
     *
     *   #33 = Fieldref           #8.#34         // lang/constant/ByteCodeSample.length:I
     *   #34 = NameAndType        #35:#36        // length:I
     *   #35 = Utf8               length
     *   #36 = Utf8               I
     */
    public int length;

    /**
     *   protected transient Double value;
     *
     *   #45 = Fieldref           #8.#46         // lang/constant/ByteCodeSample.value:Ljava/lang/Double;
     *   #46 = NameAndType        #47:#48        // value:Ljava/lang/Double;
     *   #47 = Utf8               value
     *   #48 = Utf8               Ljava/lang/Double;
     */
    protected transient Double value;

    public ByteCodeSample(String name) {
        this.name = name;
    }

    private void print() {
        /**
         *  System.out.println("Name: " + name);
         *
         *  #19 = InvokeDynamic      #0:#20         // #0:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         *  #20 = NameAndType        #21:#22        // makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
         *  #21 = Utf8               makeConcatWithConstants
         *  #22 = Utf8               (Ljava/lang/String;)Ljava/lang/String;
         *  #23 = Methodref          #24.#25        // java/io/PrintStream.println:(Ljava/lang/String;)V
         *  #24 = Class              #26            // java/io/PrintStream
         *  #25 = NameAndType        #27:#28        // println:(Ljava/lang/String;)V
         *  #26 = Utf8               java/io/PrintStream
         *  #27 = Utf8               println
         *  #28 = Utf8               (Ljava/lang/String;)V
         */
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        ByteCodeSample sample = new ByteCodeSample("Sample");
        sample.length = 10;
        sample.value = 10.0;
    }
}
