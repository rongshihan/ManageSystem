package wxcon;
import bean.TextMessage;
import org.dom4j.DocumentException;
//import util.CheckUtil;
import util.MessageUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class wxconnect extends HttpServlet {
    private final String token = "iamdcz";



    /**
     * 排序方法
     *
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
    public String sort(String token, String timestamp, String nonce) {
        String[] strArray = {token, timestamp, nonce};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     * 将字符串进行sha1加密
     *
     * @param str 需要加密的字符串
     * @return 加密后的内容
     */
    public String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*
     * 接受微信服务器发送的4个参数并且返回echostr
     * 检测是否成功连接
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("开始校验签名");
        /**
         * 接收微信服务器发送请求时传递过来的4个参数
         */
        String signature = request.getParameter("signature");//微信加密签名signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String timestamp = request.getParameter("timestamp");//时间戳
        String nonce = request.getParameter("nonce");//随机数
        String echostr = request.getParameter("echostr");//随机字符串
        //排序
        String sortString = sort(token, timestamp, nonce);
        //加密
        String mySignature = sha1(sortString);
        //校验签名
        if (mySignature != null && mySignature != "" && mySignature.equals(signature)) {
            System.out.println("签名校验通过。");
            //如果检验成功输出echostr，微信服务器接收到此输出，才会确认检验完成。
            response.getWriter().write(echostr);
        } else {
            System.out.println("签名校验失败.");
        }

    }


    /**
     * 接收并处理微信客户端发送的请求
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml;charset=utf-8");
        PrintWriter out = response.getWriter();

        Map<String, String> map = MessageUtils.xmlToMap(request);
        String toUserName = map.get("ToUserName");
        String fromUserName = map.get("FromUserName");
        String msgType = map.get("MsgType");
        String content = map.get("Content");


        // 对文本消息进行处理
        String message = null;
        if (MessageUtils.MESSAGE_TEXT.equals(msgType)) {
            if("1".equals(content)){
                message = MessageUtils.initText(toUserName,fromUserName,MessageUtils.menuFirst());
            }else if("2".equals(content)){
                message = MessageUtils.initText(toUserName,fromUserName,MessageUtils.menuSecond());
            }else if("?".equals(content) || "？".equals(content)){
                message = MessageUtils.initText(toUserName,fromUserName,MessageUtils.menuText());
            }else{
                message = MessageUtils.initText(toUserName,fromUserName,"无法识别的的指令，请回复'?'呼出菜单");
            }
//            TextMessage text = new TextMessage();
//            // 发送和回复是反向的
//            text.setFromUserName(toUserName);
//            text.setToUserName(fromUserName);
//            text.setMsgType("text");
//            text.setCreateTime(String.valueOf(new Date().getTime()));
//            text.setContent("你发送的消息是：" + content);
//            message = MessageUtils.textMessageToXML(text);
//            System.out.println(message);
        }else if(MessageUtils.MESSAGE_EVENT.equals(msgType)){//事件推送
            String eventType = map.get("Event");
            if(MessageUtils.MESSAGE_SUBSCRIBE.equals(eventType)){//关注事件
                message = MessageUtils.initText(toUserName,fromUserName,MessageUtils.initMenuText());

            }
        }else if(MessageUtils.MESSAGE_IMAGE.equals(msgType)){
            message = MessageUtils.initText(toUserName,fromUserName,MessageUtils.initMenuText());
        }
        // 将回应发送给微信服务器
        out.print(message);


    }
}
