package com.jvm.deme;

/**
 * @program: JVMDemo
 * @ClassName ClassLoaderTest
 * @description:
 * @author: huJie
 * @create: 2022-03-29 18:05
 **/
public class ClassLoaderTest {
    public static void main(String[] args) {

        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);// sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);// sun.misc.Launcher$ExtClassLoader@1b6d3586

        // 获取其上层   试图获取bootstrap   获取不到引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader); // null


        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);  // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 引导类加载器加载   JAVA的核心类库都是引导类加载器进行加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1); // null

    }

}
