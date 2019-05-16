package webadv.s99201105.p02;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;
public class App {
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        Scanner PassWord = new Scanner(System.in);
        System.out.println("请输入账号：");
        String s1 = number.next();
        System.out.println(s1);

        System.out.println("请输入密码：");
        String s2 = PassWord.next();
        System.out.println(s2);
        String expected = sha256hex(s2);
        System.out.println();

        try {
               Assert.assertEquals(expected, App.sha256hex("123456"));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("密码错误！");
        }

        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        System.out.println(sha256hex(args[0]));
    }

    public void testHex() {
        String input = "123456";
        String expected = "8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92";
        Assert.assertEquals(expected, App.sha256hex(input));
    }
}
