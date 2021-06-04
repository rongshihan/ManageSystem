package util;

import bean.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MessageUtils {

    public   static final String MESSAGE_TEXT = "text";
    public   static final String MESSAGE_IMAGE = "image";
    public   static final String MESSAGE_VOICE = "voice";
    public   static final String MESSAGE_VIDEO = "video";
    public   static final String MESSAGE_LINK = "link";
    public   static final String MESSAGE_LOCATION = "location";
    public   static final String MESSAGE_EVENT = "event";
    public   static final String MESSAGE_SUBSCRIBE = "subscribe";
    public   static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public   static final String MESSAGE_CLICK = "click";
    public   static final String MESSAGE_VIEW = "view";


    /*
     *xml转map集合
     */
    public static Map<String,String> xmlToMap(HttpServletRequest req) {
        Map<String, String> map = new HashMap<String,String>();
        SAXReader reader = new SAXReader();

        try {
            //从request中获取输入流
            InputStream ins = req.getInputStream();
            Document doc = reader.read(ins);

            //获取xml中的根元素
            Element root = doc.getRootElement();

            //获取根元素所有的节点，放到list中
            List<Element> list = root.elements();
            // 遍历
            for (Element e : list){
                map.put(e.getName(), e.getText());
            }

            ins.close();
            return map;
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * 将文本消息对象转换成XML
     */
    public static String textMessageToXML(TextMessage textMessage){
        //用XStream将实体类的实例转换成xml
        XStream xstream = new XStream();
        //将xml的默认接待转换成“xml”
        xstream.alias("xml",textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    public static String initText(String toUserName,String fromUserName,String content){
        TextMessage text = new TextMessage();
        // 发送和回复是反向的
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(MessageUtils.MESSAGE_TEXT);
        text.setCreateTime(String.valueOf(new Date().getTime()));
        text.setContent(content);
        return MessageUtils.textMessageToXML(text);
    }

    public static String initMenuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎您的关注，请按照菜单提示进行操作\n");
        sb.append("1.菜单第一项\n");
        sb.append("2.菜单第二项\n");
        sb.append("回复‘?’调出菜单\n");
        return sb.toString();
    }
    /*
     * 拼一个主菜单
     */
    public static String menuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("1.菜单第一项\n");
        sb.append("2.菜单第二项\n");
        sb.append("回复‘?’调出菜单\n");
        return sb.toString();
    }

    public static String menuFirst(){
        StringBuffer sb = new StringBuffer();
        sb.append("你选择了菜单第一项\n");
        return sb.toString();
    }

    public static String menuSecond(){
        StringBuffer sb = new StringBuffer();
        sb.append("你选择了菜单第二项\n");
        return sb.toString();
    }

}
