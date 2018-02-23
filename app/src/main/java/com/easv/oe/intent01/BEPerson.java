package com.easv.oe.intent01;

import java.io.Serializable;

/**
 * Created by oe on 23/02/2018.
 */

public class BEPerson implements Serializable{

    String m_Name;
    String m_Phone;
    int m_height;

    public BEPerson(String name, String phone, int height)
    {
        m_Name = name; m_Phone = phone; m_height = height;
    }

    public String getName() { return m_Name; }
    public String getPhone() { return m_Phone; }
    public int getHeight() { return m_height; }


}
