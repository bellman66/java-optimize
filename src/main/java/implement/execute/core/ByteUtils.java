package implement.execute.core;

public final class ByteUtils {

    public static int bytes2Int(byte[] bytes, int start, int length) {
        int sum = 0;
        int end = start + length;

        for (int i = start; i < end; i++) {
            int n = ((int) bytes[i]) & 0xff;
            n <<= (--length) * 8;
            sum += n;
        }
        return sum;
    }

    public static byte[] int2Bytes(int value, int length) {
        byte[] result = new byte[length];

        for (int i = length - 1; i >= 0; i--) {
            result[i] = (byte) (value & 0xFF);
            value >>= 8;
        }
        return result;
    }

    public static String bytes2String(byte[] bytes, int start, int length) {
        return new String(bytes, start, length);
    }

    public static byte[] string2Bytes(String str) {
        return str.getBytes();
    }

    public static byte[] bytesReplace(byte[] originalBytes, int offset, int length, byte[] replaceBytes) {
        byte[] newBytes = new byte[originalBytes.length + replaceBytes.length - length];
        System.arraycopy(originalBytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        System.arraycopy(originalBytes, offset + length, newBytes, offset + replaceBytes.length, originalBytes.length - offset - length);
        return newBytes;
    }
}
