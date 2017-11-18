package com.yihongyuan.tools;

import com.google.gson.Gson;
import tangshi.TangShi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.*;

import static com.yihongyuan.tools.HttpUtils.requestByGetMethod;

/**
 * @Author lidepeng
 * @Date 2017-11-18 13:14
 * @Description
 */
public class TangShiMain {

    public static void main(String[] aa){
        List<TangShi> tangShis = new ArrayList<TangShi>();
        for(int i =1;i<4;i++) {
            TangShi tangShi = new TangShi();
            try {
                String str = requestByGetMethod("http://tools.2345.com/tangshi/"+i+".htm");
                System.out.println(str);
                Document doc = Jsoup.parse(str);
                Elements elements = doc.select("div.poem_name");
                for (Element item : elements) {
                    Element element = item.select("p").get(0);
                    String name = element.text();
                    tangShi.setAuthor(name);
                    String tName = item.select("h2").text();
                    tangShi.setName(tName);
                }
                Elements textElements = doc.select("div.poem_detail");
                for (Element item : textElements) {
                    Element element = item.select("p").get(0);
                    String name = element.text();
                    tangShi.setText(name);
                }
                Elements poem_explain = doc.select("div.poem_explain");
                for (Element item : poem_explain) {
                    Element element = item.select("dd").get(0);
                    String name = element.text();
                    tangShi.setExplain(name);
                    tangShi.setClearfix(item.select("dd").get(1).text());
                    tangShi.setClearfix2(item.select("dd").get(2).text());
                }
                tangShis.add(tangShi);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        stringStream(new Gson().toJson(tangShis));
    }

    public static void stringStream(String str) {
        InputStream in = new ByteArrayInputStream(str.getBytes());
        BufferedInputStream bips = new BufferedInputStream(in);
        int len;
        byte[] b = new byte[81920000];
        OutputStream out = null;
        try {
            out = new FileOutputStream(new File(
                    "D:\\out.txt"));
            len = bips.read(b);
            if (len > 0) {
                out.write(b, 0, len);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            out.close();
            bips.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
