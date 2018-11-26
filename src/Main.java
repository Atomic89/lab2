import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String ip = "", mask = "", gateway = "", dns = "";
        boolean check = false;
        Process pp = null, pp2 = null;
        System.out.println("Выберите какие настройки включить 1 или 2?");
        System.out.print("Настройка № = ");
        Scanner in = new Scanner(System.in);

        String numberSet = in.next();
        switch (numberSet) {
            case "1":
                ip = "192.168.1.34";
                mask = "255.255.255.0";
                gateway = "192.168.1.1";
                dns = "195.121.111.111";
                check = true;
                break;
            case "2":
                ip = "192.168.1.35";
                mask = "255.255.234.0";
                gateway = "192.168.1.1";
                dns = "195.121.111.111";
                check = true;
                break;
            default:
                break;
        }
        String[] command1 = {"netsh", "interface", "ip", "set", "address",
                "name=", "Local Area Connection" ,"source=static", "addr=", ip,
                "mask=", mask, "gateway=", gateway};
        String[] command2 = { "netsh", "interface", "ip", "set", "dnsservers",
                "name=", "Local Area Connection" ,"source=static", "address=", dns};

        if(check) {
             pp = java.lang.Runtime.getRuntime().exec(command1);
             pp2 = java.lang.Runtime.getRuntime().exec(command2);
        }

        if(pp != null && pp2 != null) {
            pp.destroy();
            pp2.destroy();
        }
    }
}
