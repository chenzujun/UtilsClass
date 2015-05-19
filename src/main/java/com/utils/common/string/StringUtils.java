package com.utils.common.string;

public class StringUtils
{
    public static void main(String[] args)
    {
        String str = "aa,bb,cc";
        String strs[] = {};
        for (int i = 0; i < strs.length; i++)
        {
            if(i == 1){
                strs[i] = "change";
            }
        }
        for (int i = 0; i < strs.length; i++)
        {
            if(i == 0){
                str = strs[0];
            }else {
                str += ","+strs[i];
            }
            
        }
        System.out.println(str);
    }
}
