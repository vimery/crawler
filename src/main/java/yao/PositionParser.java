package yao;

import com.google.gson.*;
import yao.tools.BeanTools;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PositionParser {

    public static List<PositionBean> parsePosition(String json) {
        Gson gson = new Gson();
        List<PositionBean> list = new ArrayList<PositionBean>();
        JsonObject web = new JsonParser().parse(json).getAsJsonObject();
        JsonObject content = web.getAsJsonObject("content");
        JsonObject positionResult = content.getAsJsonObject("positionResult");
        JsonArray result = positionResult.getAsJsonArray("result");
        for (JsonElement jo : result) {
            PositionBean bean = new PositionBean();
            PositionVO vo = gson.fromJson(jo, PositionVO.class);
            BeanTools.BeanCopy(bean, vo);
            String salary = vo.getSalary().toLowerCase();
            bean.setId(UUID.randomUUID().toString());
            try {
                bean.setMinSalary(Integer.parseInt(salary.substring(0, salary.indexOf("k"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
            bean.setMaxSalary(Integer.parseInt(salary.substring(salary.indexOf("-") + 1, salary.lastIndexOf("k"))));
            list.add(bean);
        }
        return list;
    }

}
