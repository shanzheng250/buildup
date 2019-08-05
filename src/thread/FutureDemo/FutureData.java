package thread.FutureDemo;

/**
 * @ClassName:FutureData
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/5/22 21:07
 * @Version:1.0
 **/
public class FutureData implements Data {

    private RealData realData;


    private boolean isSuccess;

    void setData(){
        if (isSuccess){
            return;
        }




    }




    synchronized Data getData(){

        while(!isSuccess){
            try {
                wait();

            }catch (Exception e){

            }

        }
        return realData;

    }

}
