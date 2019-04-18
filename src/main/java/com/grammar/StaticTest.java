package com.grammar;

public class StaticTest
{

    public static final String HK_ISSUE_PUTAWAY_MODEL = "您的包裹已退回倉庫，請在辦工時間致電：852-30183617，儘快處理避免產生倉租，謝謝";
    static String hk4PLmodel = "包裹{0}抵達{1},提貨碼{2}免租期{3}天，超期10HKD/天。請儘快取貨";
    public final String HK_ISSUE_PUTAWAY_MODELS = "您的包裹已退回倉庫，請在辦工時間致電：852-30183617，儘快處理避免產生倉租，謝謝";

    public static void main(String[] args)
    {
        staticFunction();
    }
 
    static StaticTest st = new StaticTest();
 
    static
    {
        System.out.println("1");
    }
 
    {
        System.out.println("2");
    }
 
    int a=110;
    static int b =112;
    
    StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
        b=10;
        System.out.println("StaticTest,b="+b);
    }
 
    public static void staticFunction(){
        System.out.println(HK_ISSUE_PUTAWAY_MODEL);
        System.out.println(hk4PLmodel);
        StaticTest s = new StaticTest();
        System.out.println(s.HK_ISSUE_PUTAWAY_MODELS);
        System.out.println(b);
    }
 
    
}