package yao;

/**
 * position info bean
 * Created by yao on 2017/5/15.
 */
public class PositionVO {

    //职位名称
    private String positionName;
    //工作年限
    private String workYear;
    //教育程度
    private String education;
    //职业性质
    private String jobNature;
    //融资阶段
    private String financeStage;
    //所属领域
    private String industryField;
    //城市
    private String city;
    //薪酬
    private String salary;
    //职业优势
    private String positionAdvantage;
    //公司简称
    private String companyShortName;
    //区域
    private String district;
    //公司规模
    private String companySize;
    //公司全名
    private String companyFullName;
    //职业类型
    private String secondType;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature;
    }

    public String getFinanceStage() {
        return financeStage;
    }

    public void setFinanceStage(String financeStage) {
        this.financeStage = financeStage;
    }

    public String getIndustryField() {
        return industryField;
    }

    public void setIndustryField(String industryField) {
        this.industryField = industryField;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPositionAdvantage() {
        return positionAdvantage;
    }

    public void setPositionAdvantage(String positionAdvantage) {
        this.positionAdvantage = positionAdvantage;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getCompanyFullName() {
        return companyFullName;
    }

    public void setCompanyFullName(String companyFullName) {
        this.companyFullName = companyFullName;
    }

    public String getSecondType() {
        return secondType;
    }

    public void setSecondType(String secondType) {
        this.secondType = secondType;
    }

    @Override
    public String toString() {
        return "positionName:" + positionName + " workYear:" + workYear + " salary:" + salary + " companySize:" + companySize + " companyFullName:" + companyFullName;
    }
}
