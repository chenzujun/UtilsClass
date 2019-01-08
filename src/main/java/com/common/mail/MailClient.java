package com.common.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.mail.util.MailSSLSocketFactory;
  
public class MailClient {
    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);
    
//    private static final String SEND_HOST = "smtp.163.com";
//    private static final String SEND_FROM_MAIL = "chen_zujun@163.com";
//    private static final String SEND_USER = "chen_zujun@163.com";
//    private static final String SEND_PASSWORD = "xx";
//    private static final String RECEIVE_HOST = "pop.163.com";
//    private static final String RECEIVE_USER = "chen_zujun@163.com";
//    private static final String RECEIVE_PASSWORD = "xx";
    
    private static final String RECEIVE_HOST = "pop.qq.com";
    private static final String RECEIVE_USER = "837940807@qq.com";
    private static final String RECEIVE_PASSWORD = "hhgawdwandasbbbf";
    
    private static final String SEND_HOST = "smtp.qq.com";
    private static final String SEND_FROM_MAIL = "837940807@qq.com";
    private static final String SEND_USER = "837940807@qq.com";
    private static final String SEND_PASSWORD = "hhgawdwandasbbbf";
    
    public static void sendMail(String toMail, String mailTitle, String mailContent ) throws Exception {
        sendMailFromQQ(SEND_FROM_MAIL, SEND_USER, SEND_PASSWORD, toMail, mailTitle, mailContent);
    }
    
    public static void sendMailFrom163(String fromMail, String user, String password,  
                                String toMail,  
                                String mailTitle,  
                                String mailContent) throws Exception {  
        Properties props = new Properties(); //可以加载一个配置文件  
        // 使用smtp：简单邮件传输协议  
        props.put("mail.smtp.host", SEND_HOST);//存储发送邮件服务器的信息  
        props.put("mail.smtp.auth", "true");//同时通过验证
        
        Session session = Session.getInstance(props);//根据属性新建一个邮件会话  
//        session.setDebug(true); //有他会打印一些调试信息。  
  
        MimeMessage message = new MimeMessage(session);//由邮件会话新建一个消息对象  
        message.setFrom(new InternetAddress(fromMail));//设置发件人的地址  
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));//设置收件人,并设置其接收类型为TO  
        message.setSubject(mailTitle);//设置标题  
        //设置信件内容  
        message.setText(mailContent); //发送 纯文本 邮件
//        message.setContent(mailContent, "text/html;charset=UTF-8"); //发送HTML邮件，内容样式比较丰富  
        message.setSentDate(new Date());//设置发信时间  
        message.saveChanges();//存储邮件信息  
  
        //发送邮件  
        Transport transport = session.getTransport("smtp");
        transport.connect(user, password);
        transport.sendMessage(message, message.getAllRecipients());//发送邮件,其中第二个参数是所有已设好的收件人地址  
        transport.close();  
    }
    
    public static void sendMailFromQQ(String fromMail, final String user, final String password,  
            String toMail,  
            String mailTitle,  
            String mailContent) throws Exception {  

        //用于读取配置文件
        Properties props=new Properties();
        //开启Debug调试
        props.setProperty("mail.debug", "true");
        //发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        //发送邮件服务器的主机名
        props.setProperty("mail.host", SEND_HOST);
        //发送邮件协议
        props.setProperty("mail.transport.protocol", "smtp");

        //开启ssl加密（并不是所有的邮箱服务器都需要，但是qq邮箱服务器是必须的）
        MailSSLSocketFactory msf= new MailSSLSocketFactory();
        msf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", msf);

        //获取Session会话实例（javamail Session与HttpSession的区别是Javamail的Session只是配置信息的集合）
        Session session=Session.getInstance(props,new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                        //用户名密码验证（取得的授权吗）
                        return new PasswordAuthentication (user, password);
                }
        });

        //抽象类MimeMessage为实现类  消息载体封装了邮件的所有消息
        Message message=new MimeMessage(session);
        //设置邮件主题
        message.setSubject(mailTitle);
        //封装需要发送电子邮件的信息
        message.setText(mailContent);

        //设置发件人地址
        message.setFrom(new InternetAddress(SEND_FROM_MAIL));

        //此类的功能是发送邮件 又会话获得实例
        Transport transport=session.getTransport();
        //开启连接
        transport.connect();
        //设置收件人地址邮件信息
        transport.sendMessage(message, new Address[]{new InternetAddress(toMail)});

        //邮件发送后关闭信息
        transport.close();
    }
    
    public static void receiveMailBy163() throws Exception {
        // Create empty properties
        Properties props = new Properties();
        
        // Get session
        Session session = Session.getInstance(props, null);
        session.setDebug(true);
       
        // Get the store
        Store store = session.getStore("pop3");
        store.connect(RECEIVE_HOST, RECEIVE_USER, RECEIVE_PASSWORD);
       
        // Get folder
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
       
        // Get directory
//        Message message[] = folder.getMessages();
        Message[] message = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        
        
        for (int i = 0; i < message.length; i++) {  
            MimeMessage ins = (MimeMessage) message[i];
            StringBuffer sb = getMailInfo(ins);
            System.out.println(sb.toString());
        }  
    }
    
    public static void receiveMailByQQ() throws Exception {
        Properties p = new Properties();
        p.setProperty("mail.pop3.host", RECEIVE_HOST);
        p.setProperty("mail.pop3.port", "995");
        // SSL安全连接参数
        p.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.setProperty("mail.pop3.socketFactory.fallback", "true");
        p.setProperty("mail.pop3.socketFactory.port", "995");

        Session session = Session.getDefaultInstance(p, null);
        Store store = session.getStore("pop3");
        store.connect(RECEIVE_HOST, RECEIVE_USER, RECEIVE_PASSWORD);

        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
//        Message message[] = folder.getMessages();
        Message[] message = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
//        Message[] message = folder.getMessages(folder.getMessageCount()-folder.getUnreadMessageCount()+1,folder.getMessageCount());
        
        logger.info("邮件数量:　" + message.length+"|"+folder.getUnreadMessageCount());
        for (int i = 0; i < message.length; i++) {  
            MimeMessage ins = (MimeMessage) message[i];
            StringBuffer sb = getMailInfo(ins);
            System.out.println(sb.toString()+"|"+MailUtil.isNew(ins));
        }  
    }
    
    private static StringBuffer getMailInfo(MimeMessage message) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(MailUtil.getSubject(message)).append("\r\n");
        sb.append(MailUtil.getFrom(message)).append(" ").append(MailUtil.getSentDate(message)).append("\r\n");
        sb.append(MailUtil.getMailContent((Part) message)).append("\r\n");
        
        return sb;
    }
  
    public static void main(String[] args) throws Exception {  
//        sendMail("1084486137@qq.com", "Java Mail from qq 测试邮件", "邮件内容 测试一下");
        receiveMailByQQ();
    }  
}  