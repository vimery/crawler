package yao;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * get web from a queue of urls
 * Created by yao on 4/25/2017.
 */
public class WebGetter {

    public String getWeb(String urlString, String args) throws IOException {
        StringBuilder web = new StringBuilder();
        URL url = new URL(urlString);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/x");
        conn.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch, br");
        conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
        conn.setRequestProperty("Cache-Control", "max-age=0");
        conn.setRequestProperty("Cookie", "user_trace_token=20170409163536-81367b77-1cff-11e7-9d7c-5254005c3644; LGUID=20170409163536-813681d1-1cff-11e7-9d7c-5254005c3644; JSESSIONID=ABAAABAAAIAACBID3B1AF91524B4B5FC03CBD8531C207FE; TG-TRACK-CODE=index_navigation; _gat=1; PRE_UTM=; PRE_HOST=; PRE_SITE=https%3A%2F%2Fwww.lagou.com%2Fzhaopin%2FJava%2F%3FlabelWords%3Dlabel; PRE_LAND=https%3A%2F%2Fwww.lagou.com%2Fjobs%2Flist_Java%3Fpx%3Ddefault%26gj%3D3%25E5%25B9%25B4%25E5%258F%258A%25E4%25BB%25A5%25E4%25B8%258B%26city%3D%25E6%25B7%25B1%25E5%259C%25B3; _putrc=A76F01E57418E709; login=true; unick=%E9%99%88%E5%B0%A7; showExpriedIndex=1; showExpriedCompanyHome=1; showExpriedMyPublish=1; hasDeliver=18; SEARCH_ID=26ea68e5dc6d4813aae75dd3efd54eaf; index_location_city=%E6%B7%B1%E5%9C%B3; _gid=GA1.2.1713149158.1494835147; _ga=GA1.2.1971180955.1491726927; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1494597245,1494776825,1494832428,1494832433; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1494835147; LGSID=20170515155826-46942914-3944-11e7-b77f-525400f775ce; LGRID=20170515155912-62078f25-3944-11e7-b77f-525400f775ce");

        conn.setRequestMethod("POST");

        //设置参数
        OutputStream os = conn.getOutputStream();
        os.write(args.getBytes());
        os.close();

        InputStream is = conn.getInputStream();
        InputStreamReader isReader = new InputStreamReader(is);
        BufferedReader bfReader = new BufferedReader(isReader);
        String str;
        while ((str = bfReader.readLine()) != null) {
            web.append(str);
        }
        bfReader.close();
        isReader.close();
        is.close();
        return web.toString();
    }

}
