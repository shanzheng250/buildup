package rxjava;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class RxJava {


	/*****
	 * @Date:2019/6/13 9:51
	 *
	 *
	 * Observable (publish) 事件源  可被观察对象
	 * Obserer (Subscriber)  订阅者 观察对象
	 *
	 *  也是常说的pub -sub模式 即观察者-订阅者模式
	 *  在spring中就是ApplicationListener applicationEvent
	 **/
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	    Observable.create(new Observable.OnSubscribe<String>(){
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("aaa");
				subscriber.onNext("bbb");
				subscriber.onError(new Exception());
			}
		}).subscribeOn(Schedulers.immediate()).subscribe(new Observer<String>() {
                @Override
                public void onCompleted() {
                    System.out.println("success");
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("exception");
                }

                @Override
                public void onNext(String s) {
                    System.out.println("onNext" + s);
                }
            });

	}
}
