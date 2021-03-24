package com.zcd.model;

import java.io.Serializable;
import java.util.Date;

/**
 * (Hotel)实体类
 *
 * @author makejava
 * @since 2021-01-21 11:12:27
 */
public class Hotel implements Serializable {
    private static final long serialVersionUID = 871367568658937007L;

    private Long hotelGroupId;

    private Long id;

    private String code;
    /**
     * R=初始 H=停用 I=在用
     */
    private String sta;
    /**
     * 0=正常 1=不正常
     */
    private String audit;

    private String descript;

    private String descriptEn;

    private String descriptShort;
    /**
     * code_country.code
     */
    private String country;
    /**
     * 自由输入
     */
    private String city;

    private String address1;

    private String address2;

    private String phone;

    private String fax;

    private String phoneRsv;

    private String website;

    private String email;

    private String dns;

    private String remark;

    private byte[] logo;

    private String photo;

    private String htmlInfo;

    private Object listOrder;

    private String createUser;

    private Date createDatetime;

    private String modifyUser;

    private Date modifyDatetime;

    private String provinceCode;

    private String cityCode;

    private String districtCode;

    private String townCode;

    private String shoppingDistrictCode;

    private String scenicSpotCode;

    private String bookListOrder;

    private String startLevelCode;

    private String brandCode;

    private String score;

    private String categoryCode;

    private String manageType;

    private String mapHtml;

    private String pairPic;

    private String appType;

    private String clientType;

    private String clientVersion;

    private String onlineCheck;

    private String area1;

    private String area2;

    private String serverName;

    private Date decorationDate;

    private Date openDate;

    private String hotelPolicy;


    public Long getHotelGroupId() {
        return hotelGroupId;
    }

    public void setHotelGroupId(Long hotelGroupId) {
        this.hotelGroupId = hotelGroupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSta() {
        return sta;
    }

    public void setSta(String sta) {
        this.sta = sta;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getDescriptEn() {
        return descriptEn;
    }

    public void setDescriptEn(String descriptEn) {
        this.descriptEn = descriptEn;
    }

    public String getDescriptShort() {
        return descriptShort;
    }

    public void setDescriptShort(String descriptShort) {
        this.descriptShort = descriptShort;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhoneRsv() {
        return phoneRsv;
    }

    public void setPhoneRsv(String phoneRsv) {
        this.phoneRsv = phoneRsv;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getHtmlInfo() {
        return htmlInfo;
    }

    public void setHtmlInfo(String htmlInfo) {
        this.htmlInfo = htmlInfo;
    }

    public Object getListOrder() {
        return listOrder;
    }

    public void setListOrder(Object listOrder) {
        this.listOrder = listOrder;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(Date modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getShoppingDistrictCode() {
        return shoppingDistrictCode;
    }

    public void setShoppingDistrictCode(String shoppingDistrictCode) {
        this.shoppingDistrictCode = shoppingDistrictCode;
    }

    public String getScenicSpotCode() {
        return scenicSpotCode;
    }

    public void setScenicSpotCode(String scenicSpotCode) {
        this.scenicSpotCode = scenicSpotCode;
    }

    public String getBookListOrder() {
        return bookListOrder;
    }

    public void setBookListOrder(String bookListOrder) {
        this.bookListOrder = bookListOrder;
    }

    public String getStartLevelCode() {
        return startLevelCode;
    }

    public void setStartLevelCode(String startLevelCode) {
        this.startLevelCode = startLevelCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getManageType() {
        return manageType;
    }

    public void setManageType(String manageType) {
        this.manageType = manageType;
    }

    public String getMapHtml() {
        return mapHtml;
    }

    public void setMapHtml(String mapHtml) {
        this.mapHtml = mapHtml;
    }

    public String getPairPic() {
        return pairPic;
    }

    public void setPairPic(String pairPic) {
        this.pairPic = pairPic;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getOnlineCheck() {
        return onlineCheck;
    }

    public void setOnlineCheck(String onlineCheck) {
        this.onlineCheck = onlineCheck;
    }

    public String getArea1() {
        return area1;
    }

    public void setArea1(String area1) {
        this.area1 = area1;
    }

    public String getArea2() {
        return area2;
    }

    public void setArea2(String area2) {
        this.area2 = area2;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Date getDecorationDate() {
        return decorationDate;
    }

    public void setDecorationDate(Date decorationDate) {
        this.decorationDate = decorationDate;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getHotelPolicy() {
        return hotelPolicy;
    }

    public void setHotelPolicy(String hotelPolicy) {
        this.hotelPolicy = hotelPolicy;
    }

}