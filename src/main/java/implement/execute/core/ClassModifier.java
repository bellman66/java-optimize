package implement.execute.core;

/**
 * Class 파일 수정
 */
public class ClassModifier {

    private static final int CONSTANT_POOL_COUNT_INDEX = 8;
    private static final int CONSTANT_UTF8_INFO = 1;
    private static final int[] CONSTANT_ITEM_LENGTH = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};
    private static final int u1 = 1;
    private static final int u2 = 2;

    private byte[] classByte;

    ClassModifier(byte[] classByte) {
        this.classByte = classByte;
    }

    /**
     * CONSTANT UTF 상수 내용을 수정
     *
     * @param oldStr
     * @param newStr
     * @return
     */
    public byte[] modifyUTF8Constant(String oldStr, String newStr) {
        int cpc = getConstantPool();
        int offset = CONSTANT_POOL_COUNT_INDEX + u2;

        for (int i=0; i<cpc; i++) {
            int tag = ByteUtils.bytes2Int(classByte, offset, u1);

            if (tag == CONSTANT_UTF8_INFO) {
                int length = ByteUtils.bytes2Int(classByte, offset + u1, u2);
                offset += (u1 + u2);
                String str = ByteUtils.bytes2String(classByte, offset, length);

                if (str.equalsIgnoreCase(oldStr)) {
                    byte[] strBytes = ByteUtils.string2Bytes(newStr);
                    byte[] strLen = ByteUtils.int2Bytes(newStr.length(), u2);

                    classByte = ByteUtils.bytesReplace(classByte, offset - u2, u2, strLen);
                    classByte = ByteUtils.bytesReplace(classByte, offset, length, strBytes);
                    return classByte;
                } else {
                    offset += length;
                }
            } else {
                offset += CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return null;
    }

    private int getConstantPool() {
        return ByteUtils.bytes2Int(classByte, CONSTANT_POOL_COUNT_INDEX, u2);
    }
}
