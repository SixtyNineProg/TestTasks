public class Converter {
    public static String longToIp(long d)
    {
        long v1 = d & 0xff;
        long v2 = (d >> 8) & 0xff;
        long v3 = (d >> 16) & 0xff;
        long v4 = (d >> 24);
        return v4 + "." + v3 + "." + v2 + "." + v1;
    }

    public static long ipToLong(String ipAddress) {

        String[] ipAddressInArray = ipAddress.split("\\.");

        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);

        }

        return result;
    }
}
