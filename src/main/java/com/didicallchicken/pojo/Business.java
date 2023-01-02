package com.didicallchicken.pojo;

import java.util.List;

public class Business<T> {  //商家
   private Integer businessId;
   private String  businessName;
   private Float   grade;
   private String  description;
   private String  type;
   private List<T> goodsList;
   private Integer monthlySales;    //月售
   private String  busImg; //图片路径

    public Integer getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(Integer monthlySales) {
        this.monthlySales = monthlySales;
    }

    public String getBusImg() {
        return busImg;
    }

    public void setBusImg(String busImg) {
        this.busImg = busImg;
    }

    public List<T> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<T> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessId=" + businessId +
                ", businessName='" + businessName + '\'' +
                ", grade=" + grade +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", goodsList=" + goodsList +
                ", monthlySales=" + monthlySales +
                ", busImg='" + busImg + '\'' +
                '}';
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
