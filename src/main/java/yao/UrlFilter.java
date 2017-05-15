package yao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * filter urls in web
 * Created by yao on 4/25/2017.
 */
public class UrlFilter {

    public static Queue<String> getUrls(String webContent) {
        Queue<String> urlQueue = new LinkedList<String>();
        Pattern urlPattern = Pattern.compile("https?://[\\w+.?/]+\\.[A-Za-z]+");
        Matcher urlMatcher = urlPattern.matcher(webContent);
        while (urlMatcher.find()) {
            urlQueue.offer(urlMatcher.group());
        }
        return urlQueue;
    }

}
