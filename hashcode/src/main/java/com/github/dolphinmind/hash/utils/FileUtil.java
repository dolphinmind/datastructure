package com.github.dolphinmind.hash.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class FileUtil {

    /**
     * 读取本地文件，单词表
     * @param url 单词表.txt文件
     * @return 单词集合(去重)
     */
    public static Set<String> readWordList(String url) {
        Set<String> list = new HashSet<>();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(url), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] ss = line.split("\t");
                list.add(ss[1]);
            }
            br.close();
            isr.close();
        } catch (Exception ignore) {
            return null;
        }
        return list;
    }

    public static void writeWordList2Txt(String fileName, String content) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }


}
