package yao.tools;

import yao.PositionBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * jdbc tool
 * Created by yao on 2017/5/15.
 */
public class JDBC {

    public static Connection  getConn(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/job?serverTimezone=UTC&useSSL=true&characterEncoding=utf8","root","112358");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int insert(PositionBean bean){
        Connection conn = getConn();
        String sql = "insert into positions(id,positionName,workYear,education," +
                "jobNature,financeStage,industryField,city,minSalary,maxSalary," +
                "positionAdvantage,companyShortName,district,companySize,companyFullName," +
                "positionType) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt;
        int i = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getId());
            pstmt.setString(2, bean.getPositionName());
            pstmt.setString(3, bean.getWorkYear());
            pstmt.setString(4, bean.getEducation());
            pstmt.setString(5, bean.getJobNature());
            pstmt.setString(6, bean.getFinanceStage());
            pstmt.setString(7, bean.getIndustryField());
            pstmt.setString(8, bean.getCity());
            pstmt.setInt(9, bean.getMinSalary());
            pstmt.setInt(10, bean.getMaxSalary());
            pstmt.setString(11, bean.getPositionAdvantage());
            pstmt.setString(12, bean.getCompanyShortName());
            pstmt.setString(13, bean.getDistrict());
            pstmt.setString(14, bean.getCompanySize());
            pstmt.setString(15, bean.getCompanyFullName());
            pstmt.setString(16, bean.getSecondType());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static int insert(List<PositionBean> list){
        int i = 0;
        for (PositionBean bean : list){
            if(insert(bean) > 0){
                i++;
            }
        }
        return i;
    }
}
