package yao.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * bean tools
 * Created by yao on 2017/5/15.
 */
public class BeanTools {

    public static void BeanCopy(Object target, Object origin) {
        Field[] filds = origin.getClass().getDeclaredFields();
        for (Field field : filds) {
            setFieldValueByName(field.getName(), target, getFieldValueByName(field.getName(), origin));
        }
    }

    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter);
            return method.invoke(o);
        } catch (Exception e) {
            return null;
        }
    }

    private static void setFieldValueByName(String fieldName, Object o, Object arg) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String setter = "set" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(setter, arg.getClass());
            method.invoke(o, arg);
        } catch (Exception e) {
            //没找到方法直接忽略
        }
    }

}
