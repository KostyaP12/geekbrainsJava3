package lesson_g;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        try {
            start(Main.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @BeforeSuite
    public static void before() {
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public static void after() {
        System.out.println("AfterSuite");
    }

    @Test(priority = 10)
    public static void test1() {
        System.out.println("Выполняется тест №1");
    }

    @Test(priority = 8)
    public static void test2() {
        System.out.println("Выполняется тест №2");
    }

    @Test(priority = 6)
    public static void test3() {
        System.out.println("Выполняется тест №3");
    }

    @Test(priority = 7)
    public static void test4() {
        System.out.println("Выполняется тест №4");
    }

    @Test(priority = 1)
    public static void test5() {
        System.out.println("Выполняется тест №5");
    }


    private static void start(Class<?> c) throws NullPointerException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object obj = c.newInstance();
        int buffBefore = 0;
        int buffAfter = 0;
        Method[] methods = c.getDeclaredMethods();
        ArrayList<Method> methodsList = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.getAnnotation(BeforeSuite.class);
                buffBefore++;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                method.getAnnotation(AfterSuite.class);
                buffAfter++;
            }
            if(method.isAnnotationPresent(Test.class)){
                method.getAnnotation(Test.class).priority();
                methodsList.add(method);
            }
        }

        if (buffBefore > 1 || buffAfter > 1)
            throw new RuntimeException("Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре");

        methodsList.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });

        for (Method method : methodsList) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.getAnnotation(BeforeSuite.class);
                method.invoke(obj);
            }
            if(method.isAnnotationPresent(Test.class)){
                method.getAnnotation(Test.class).priority();
                method.invoke(obj);
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                method.getAnnotation(AfterSuite.class);
                method.invoke(obj);
            }
        }
    }
}



