package com.revature;

import java.sql.SQLException;

public class EmployeeDaoFactory {
    public static EmployeeDao dao;
    private EmployeeDaoFactory(){}

    public static EmployeeDao getEmployeeDao() throws SQLException {
        if(dao==null)
            dao = new EmployeeDaoImpl();
        return dao;
    }
}
