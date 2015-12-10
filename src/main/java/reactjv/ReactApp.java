package reactjv;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.*;

/**
 *
 */
public class ReactApp {
    private static Map<String, String> storage = new HashMap<>();

    static {
        storage.put("http://google.com", "Google");
        storage.put("http://oracle.com", "Oracle");
        storage.put("http://opensuse.org", "OpenSuse");
        storage.put("http://reactive.io", "Netflix");
        storage.put("http://scala-lang.org", "Typesafe");
        storage.put("http://slideshare.net", "Unknown");
    }

    private static Observable<List<String>> query(String query) {
        List<String> result = new ArrayList<>(storage.keySet());
        return Observable.just(result);
    }

    private static Observable<String> getTitle(String url) {
        System.out.println(url + " : " + Thread.currentThread());
        if (url.contains("google")) {
            throw new RuntimeException("runtime error");
        }
        return Observable.just(storage.get(url));
    }

    public static void main(String[] args) {

        Observable<List<String>> step1 = query("some query").subscribeOn(Schedulers.test());
        Observable<String> step2 = step1.flatMap(urls -> Observable.from(urls));
        Observable<String> step3 = step2.flatMap(url -> getTitle(url)).onErrorResumeNext(throwable -> {
            throwable.printStackTrace();
            return Observable.just("Replaced");
        });
        Observable<String> step4 = step3.filter(title -> title != null);
        Observable<String> step5 = step4.take(5);
        Iterator<String> it = step5.toBlocking().getIterator();
        while(it.hasNext()) {
            System.out.println(it.next() + " : " + Thread.currentThread());
        }

        Observable.just("url1", "url2", "url3")
                .subscribe(url -> System.out.println(url));

        query("some query")
                .subscribe(urls -> {
                    Observable.from(urls)
                            .subscribe(url -> System.out.println(url));
                });
    }
}
