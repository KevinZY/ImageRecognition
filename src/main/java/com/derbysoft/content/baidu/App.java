package com.derbysoft.content.baidu;

import com.amazonaws.util.IOUtils;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.google.common.collect.Maps;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Hello world!
 */
public class App {

    //设置APPID/AK/SK
    public static final String APP_ID = "10864475";
    public static final String API_KEY = "GMNSvEZW94sFVNhGZjvU66gN";
    public static final String SECRET_KEY = "PxmkBmvGT1eZGkuMLODqPjVqI2SZpxM4";

    public static void main(String[] args) throws IOException {
        // 初始化一个AipImageClassifyClient
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//    client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//    client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//    System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String url = "http://image.wyn88.com/adminbranch/201705251622011063_middle.jpg";
        URL url1 = new URL(url);
        InputStream inputStream = url1.openStream();
        JSONObject res = client
                .objectDetect(IOUtils.toByteArray(inputStream), Maps.<String, String>newHashMap());
        System.out.println(res.toString(2));
        inputStream.close();
    }
}
