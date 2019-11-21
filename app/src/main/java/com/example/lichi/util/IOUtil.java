package com.example.lichi.util;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**写出
 */
public class IOUtil {
    public static void write(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter("/data/data/cn.hlju.file/"
                    + fileName);
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void write1(Context context, String fileName, String content) {
        try {
            FileOutputStream out = context.openFileOutput(fileName, context.MODE_PRIVATE);
            out.write(content.getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
