package com.mrcodey.model;

import java.util.ArrayList;

/**
 * Created by Mr.Codey on 2015/10/26.
 * 用户个人信息
 */
public class UserInfo
{
    private int userId;//用户编号
    private String userName;//用户名
    private String userHeadUrl;//用户头像
    private String number;//联系电话
    private String E_mail;//邮箱

    private String address;//居住地
    private String sex;
    private int age;
    private String trueName;//真是姓名
    private String idCard;//身份证号
    private String idCardUrl;//身份证图片
    private String school;//学校
    private String schoolCardUrl;//学生证信息

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getSchoolCardUrl()
    {
        return schoolCardUrl;
    }

    public void setSchoolCardUrl(String schoolCardUrl)
    {
        this.schoolCardUrl = schoolCardUrl;
    }

    public String getSchool()
    {
        return school;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }

    public String getIdCardUrl()
    {
        return idCardUrl;
    }

    public void setIdCardUrl(String idCardUrl)
    {
        this.idCardUrl = idCardUrl;
    }

    public String getIdCard()
    {
        return idCard;
    }

    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getTrueName()
    {
        return trueName;
    }

    public void setTrueName(String trueName)
    {
        this.trueName = trueName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getE_mail()
    {
        return E_mail;
    }

    public void setE_mail(String e_mail)
    {
        E_mail = e_mail;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getUserHeadUrl()
    {
        return userHeadUrl;
    }

    public void setUserHeadUrl(String userHeadUrl)
    {
        this.userHeadUrl = userHeadUrl;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    //安全
    private String xuexinId;//x学信网账号
    private String[] phonebBillUrl;//手机账单流水，多张图片
    private String bankNumber;//银行卡号
    private String alipayNumber;//支付宝账号
    private String[] bankBillUrl;//银行账单流水
    private String guaranteeNumber;//担保人电话
    private ArrayList<ProjectInfo> favorites;//项目收藏列表
    private ArrayList<UserInfo> friends;//好友列表

    private String guarantee;//担保人

    public String getXuexinId()
    {
        return xuexinId;
    }

    public void setXuexinId(String xuexinId)
    {
        this.xuexinId = xuexinId;
    }

    public String[] getPhonebBillUrl()
    {
        return phonebBillUrl;
    }

    public void setPhonebBillUrl(String[] phonebBillUrl)
    {
        this.phonebBillUrl = phonebBillUrl;
    }

    public String getAlipayNumber()
    {
        return alipayNumber;
    }

    public void setAlipayNumber(String alipayNumber)
    {
        this.alipayNumber = alipayNumber;
    }

    public String getBankNumber()
    {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber)
    {
        this.bankNumber = bankNumber;
    }

    public String[] getBankBillUrl()
    {
        return bankBillUrl;
    }

    public void setBankBillUrl(String[] bankBillUrl)
    {
        this.bankBillUrl = bankBillUrl;
    }

    public String getGuarantee()
    {
        return guarantee;
    }

    public void setGuarantee(String guarantee)
    {
        this.guarantee = guarantee;
    }

    public ArrayList<ProjectInfo> getFavorites()
    {
        return favorites;
    }

    public void setFavorites(ArrayList<ProjectInfo> favorites)
    {
        this.favorites = favorites;
    }

    public ArrayList<UserInfo> getFriends()
    {
        return friends;
    }

    public void setFriends(ArrayList<UserInfo> friends)
    {
        this.friends = friends;
    }

    public String getGuaranteeNumber()
    {
        return guaranteeNumber;
    }

    public void setGuaranteeNumber(String guaranteeNumber)
    {
        this.guaranteeNumber = guaranteeNumber;
    }
}
