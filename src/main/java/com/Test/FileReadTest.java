package com.Test;

import java.io.File;

/**
 * Created by Xin on 2017/6/1.
 */
public class FileReadTest {
    public static void traverseFolder2() {
        File file = new File("E:\\CourseDesign\\picture\\");
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                        String[] splitFile=file2.getAbsolutePath().split("\\\\");
                        System.out.println(splitFile[splitFile.length-1]);
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    public static void main(String[] args) {
        traverseFolder2();
    }
}
