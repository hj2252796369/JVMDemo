package com.jvm.deme;

import com.sun.media.sound.WaveFloatFileWriter;
import com.sun.nio.zipfs.ZipPath;
import sun.misc.Launcher;

import java.net.URL;

/**
 * @program: JVMDemo
 * @ClassName ClassLoaderTest01
 * @description:
 * @author: huJie
 * @create: 2022-03-29 18:28
 **/
public class ClassLoaderTest01 {
    public static void main(String[] args) {

        System.out.println("=============启动类加载器=============");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }

        // 查看从上面jar包中的类是由什么加载器加载的
        ClassLoader classLoader = WaveFloatFileWriter.class.getClassLoader();
        System.out.println(classLoader);   //  null  ---bootstrap


        System.out.println("=============扩展类加载器=============");
        String extDirs = System.getProperty("java.ext.dirs");

        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }

        // 从上面的路径中获取一个类查看类加载器
        ClassLoader classLoader1 = ZipPath.class.getClassLoader();
        System.out.println(classLoader1);//  sun.misc.Launcher$ExtClassLoader@677327b6

    }
}
