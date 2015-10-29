package com.mrcodey.model;

import java.util.ArrayList;

/**
 * Created by Mr.Codey on 2015/10/26.
 * 筹人
 */
public class RaisePeople
{
    private int id;//项目编号
    private int needNum;//需要的人数
    private int alredyNum;//已筹的人数
    private ArrayList<String> alredyList;//已筹人列表

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getNeedNum()
    {
        return needNum;
    }

    public void setNeedNum(int needNum)
    {
        this.needNum = needNum;
    }

    public int getAlredyNum()
    {
        return alredyNum;
    }

    public void setAlredyNum(int alredyNum)
    {
        this.alredyNum = alredyNum;
    }

    public ArrayList<String> getAlredyList()
    {
        return alredyList;
    }

    public void setAlredyList(ArrayList<String> alredyList)
    {
        this.alredyList = alredyList;
    }
}
