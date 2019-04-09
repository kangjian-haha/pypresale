package com.pyp.pypresale.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kangjian
 * @date 2019/4/5 20:57
 */
public class PatternUtils {

    //编写正则表达式 验证手机号码格式是否正确
    public static boolean patternTelephone(String str){
        //手机号码验证规则
        String regEx = "^[1](([3][0-9])|([4][5,7,9])|([5][4,6,9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
        // 编译正则表达式
        Pattern pattern=Pattern.compile(regEx);
        Matcher matcher=pattern.matcher(str);
        return matcher.matches();
    }
}
