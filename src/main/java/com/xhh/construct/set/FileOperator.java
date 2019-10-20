package com.xhh.construct.set;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * 读取文件，进行简单的分词
 */
public class FileOperator {

    public static boolean readFile(String fileName, List<String> words) {
        if (fileName == null || words == null) {
            System.out.println("filename is null or words is null!");
            return false;
        }

        Scanner scanner;
        try {
            File file = new File(fileName);
            if (file.exists()) {

                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(fis, "UTF-8");
                scanner.useLocale(Locale.ENGLISH);

            } else {
                return false;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open " + fileName);
            return false;
        }

        //分词
        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
                    i++;
                }
            }
        }

        return true;
    }

    // 寻找字符串s中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }
        }

        return s.length();
    }
}
