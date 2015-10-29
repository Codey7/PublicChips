package com.mrcodey.model;

import java.util.ArrayList;

/**
 * Created by Mr.Codey on 2015/10/26.
 * 筹钱项目
 */
public class RaiseMoney
{
    private int Id;//项目编号
    private int goalMoney;//目标金额
    private int oneMoney;//一份额金额
    private int alredyMoney;//已筹金额
    private ArrayList<String> alredyList;//已筹人列表
    private String account; //资金账号

    public ArrayList<String> getAlredyList()
    {
        return alredyList;
    }

    public void setAlredyList(ArrayList<String> alredyList)
    {
        this.alredyList = alredyList;
    }

    public int getOneMoney()
    {
        return oneMoney;
    }

    public void setOneMoney(int oneMoney)
    {
        this.oneMoney = oneMoney;
    }

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public int getGoalMoney()
    {
        return goalMoney;
    }

    public void setGoalMoney(int goalMoney)
    {
        this.goalMoney = goalMoney;
    }

    public int getAlredyMoney()
    {
        return alredyMoney;
    }

    public void setAlredyMoney(int alredyMoney)
    {
        this.alredyMoney = alredyMoney;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }
}
