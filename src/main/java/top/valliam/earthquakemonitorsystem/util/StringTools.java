package top.valliam.earthquakemonitorsystem.util;

/**
 * @Classname StringTools
 * @Description 判断字符串和对象是否为空
 * @Date 2019/11/15 5:40 下午
 * @Created by valliam
 */
public class StringTools {

    public static boolean isNullOrEmpty(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    public static boolean isNullOrEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }
}
