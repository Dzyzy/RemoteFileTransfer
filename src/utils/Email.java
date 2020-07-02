package utils;

import controller.PromptWindowsController;
import javafx.stage.Stage;
import view.PromptWindows;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {

    public static String codeNow = "";


    public static void sendCode(String userEmail) {
        String emailRegular = "^[1-9]+\\d{8,10}+@qq.com$";
        Pattern patternEmail = Pattern.compile(emailRegular);
        Matcher matcherEmail = patternEmail.matcher(userEmail);
        boolean rsEmail = matcherEmail.matches();
        if(rsEmail) {
            //获取收件人邮箱
            String emailAddress = userEmail;
            Email.sendVerificationCode(emailAddress);
        } else {
            String str = "您邮箱输入的格式错误\n       请输入完整！";
            new PromptWindowsController().ReceiveOutputInformation(str);
            try {
                new PromptWindows().start(new Stage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendVerificationCode(String emailAddress) {
        try {
            //获取验证码
            String verificationCode = getVerificationCode();
            SimpleEmail mail = new SimpleEmail();
            //发送邮件的服务器
            mail.setHostName("smtp.qq.com");
            //刚刚记录的授权码，是开启SMTP的密码
            mail.setAuthentication("962355097@qq.com", "oqyslguqnnbfbfgd");
            //发送邮件的邮箱和发件人
            mail.setFrom("962355097@qq.com", "Dzy");
            //使用安全链接
            mail.setSSLOnConnect(true);
            //收件人的邮箱
            mail.addTo(emailAddress);
            //设置邮件的主题
            mail.setSubject("注册验证码");
            //设置邮件的内容
            mail.setMsg("尊敬的用户：你好！\n 验证码为：" + verificationCode + "\n" + "     (有效期为一分钟)");
            //发送邮件
            mail.send();
        } catch (EmailException e) {
            e.printStackTrace();
            String str = "当前QQ号不存在！";
            new PromptWindowsController().ReceiveOutputInformation(str);
            try {
                new PromptWindows().start(new Stage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String getVerificationCode() {
        String[] beforeShuffle = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
                "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z"};
        //将数组转化为集合
        List list = Arrays.asList(beforeShuffle);
        //打乱集合顺序
        Collections.shuffle(list);
        //建立一个单线程下的字符串变量
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            //将集合转化为字符串
            str.append(list.get(i));
        }
        // 截取字符串第5 - 8个字符，共4个
        codeNow = str.toString().substring(4, 8);
        return codeNow;
    }
}
