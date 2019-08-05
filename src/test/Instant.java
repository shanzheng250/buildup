package test;
/**
 * 引用的对象为一个
 * @author shanz
 * @date 2018年9月29日
 */
public  class Instant {

    private static class staticDemo {
        private static Instant instant =new Instant();
    }

    public static Instant getInstant(){
        return  staticDemo.instant;
    }
}

