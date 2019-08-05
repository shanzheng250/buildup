package thread.FutureDemo;

/**
 * @ClassName:Main
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/5/22 21:08
 * @Version:1.0
 **/
public class Main {

    public static Data requese(){

        FutureData futureData = new FutureData();

        new Thread(()->{

            // 获取超长时间结果
            RealData data = new RealData();

            // 设置数据，并唤醒get方法
            futureData.setData();


        }).start();


        return futureData;
    }


    public static void main(String[] args) {

    }
}
