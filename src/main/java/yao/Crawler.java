package yao;

import yao.tools.JDBC;

import java.io.IOException;
import java.util.List;

/**
 * web crawler
 * Created by yao on 4/25/2017.
 */
public class Crawler {

    /**
     * first : set a url to get web
     * second : get all urls from the web, and put them into a queue
     * third : choose a url to get web
     * forth : repeat second to third until arriving an end
     */
    public static void main(String[] args) {
        WebGetter getter = new WebGetter();
        String web = "";
        int pageSize = 15;
        int pageNo = 1;
        while (pageNo <= pageSize) {
            try {
                web = getter.getWeb("https://www.lagou.com/jobs/positionAjax.json?gj=3%E5%B9%B4%E5%8F%8A%E4%BB%A5%E4%B8%8B&px=default&city=%E6%B7%B1%E5%9C%B3&needAddtionalResult=false", "first=false&pn=" + pageNo + "&kd=Java");
            } catch (IOException e) {
                System.out.println("net is not available");
                e.printStackTrace();
            }

            List<PositionBean> list = PositionParser.parsePosition(web);
            for (PositionBean p : list) {
                System.out.println(p.toString());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            JDBC.insert(list);
            pageNo++;
        }
    }

}
