public class Main {
    public static void main(String[] args) {
        System.out.println(Converter.longToIp(2149583360L));
        System.out.println(Converter.longToIp(255L));
        System.out.println(Converter.ipToLong("128.32.10.0"));
        System.out.println(Converter.ipToLong("0.0.0.255"));
    }
}
