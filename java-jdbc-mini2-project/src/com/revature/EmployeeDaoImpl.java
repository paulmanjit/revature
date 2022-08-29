package com.revature;
import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
Connection connection;
    public EmployeeDaoImpl() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }
    @Override
    public void addEmployee(Employee employee)throws SQLException {
        String sql = "insert into employee (name, email) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setInt(3, employee.getId());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Employee saved");
        else
            System.out.println("Oops! something went wrong");
    }
    @Override   //update
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "update employee name =? email= ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setInt(3, employee.getId());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Employee update");
        else
            System.out.println("something went wrong");
    }
    @Override    //delete
    public void deleteEmployee(int id) throws SQLException {
            String sql = "delete from employee where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Employee update");
        else
            System.out.println("something went wrong");
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            Employee employee = new Employee(id, name, email);
            employees.add(employee);
        }
        return employees;

    }
    @Override
    public Employee getEmployeeById(int empid) throws SQLException {
        Employee employee = new Employee();
        String sql = "select * from employee where id = "+ empid;
        Statement statement = connection.createStatement();
        ResultSet resultSet =  statement.executeQuery(sql);
        if(resultSet!=null){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email  =resultSet.getString(3);
            employee = new Employee(id, name, email);
        }else{
            System.out.println("no record found");
        }
        return employee;
    }

}