package com.hsy.base64;

import android.util.Log;

import com.hsy.base64.sun.misc.BASE64Decoder;
import com.hsy.base64.sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author: syhuang
 * @date: 2018/5/8
 */

public class Base64Utils {
    static String TAG = Base64Utils.class.getSimpleName();

    /**
     * 图片转化成base64字符串
     *
     * @param path
     * @return
     */
    public static String getImageToBase64(String path) {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        //待处理的图片
        String imgFile = path;
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            while (in.read(data) > 0) {
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG, e.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                Log.i(TAG, e.getMessage());
            }
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        //返回Base64编码过的字节数组字符串
        return encoder.encode(data);
    }

    /**
     * base64字符串转化成图片
     *
     * @param imgStr
     * @return
     */
    public static boolean generateImage(String imgStr) {
        //对字节数组字符串进行Base64解码并生成图片
        //图像数据为空
        if (imgStr == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                //调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            //生成jpeg图片
            //新生成的图片
            String imgFilePath = "d://222.jpg";
            out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();

            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                Log.i(TAG, e.getMessage());
            }
        }
    }

}
