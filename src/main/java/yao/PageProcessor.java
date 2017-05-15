package yao;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

import java.util.List;

/**
 * pageProccessor from webmagic
 * Created by yao on 4/25/2017.
 */
public class PageProcessor implements us.codecraft.webmagic.processor.PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public void process(Page page) {
        page.putField("title", page.getHtml().regex("<title>(.*)</title>"));
        List<String> urls = page.getHtml().css("table.provincetable").links().regex(".*/search/\\?l=java.*").all();
        page.addTargetRequests(urls);
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new PageProcessor()).addUrl("http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2015/index.html").thread(5).run();
    }
}
