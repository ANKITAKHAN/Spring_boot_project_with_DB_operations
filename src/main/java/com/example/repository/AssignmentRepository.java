package com.example.repository;

import com.example.mapper.EmployeeMapper;
import com.example.objectmodel.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@Repository
public class AssignmentRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    private static ResourceBundle rb = ResourceBundle.getBundle("sql");
    String query;

    private static final Logger logger = LoggerFactory.getLogger(AssignmentRepository.class);

    /*Getting all employees from table*/
    @Cacheable(cacheNames = "employee")
    public List<Employee> getAllEmp(){
        logger.info("fetching employees from db");
        query=rb.getString("selectall");
//        List<Employee> employees = template.query(query,(result,rowNum)->new Employee(result.getInt("id"),result.getString("name")));
//        return employees;
        return template.query(query,new EmployeeMapper());
    }

    /* Fetch emp by id from cached method*/
    public Employee getEmpById(int id) {
        List<Employee> employees=getAllEmp();
        for (Employee e:employees) {
            if (e.getId() == id)
                return e;
        }
        return null;
    }

    //Without cache Getting all employees from table
    public List<Employee> getAllEmployee(){
        logger.info("fetching employees from db");
        query=rb.getString("selectall");
//        List<Employee> employees = template.query(query,(result,rowNum)->new Employee(result.getInt("id"),result.getString("name")));
//        return employees;
        return template.query(query,new EmployeeMapper());
    }

    /*Getting a specific emp by emp id from table*/
    public Employee getEmp(int Id){
        query = rb.getString("selectid");
        Map parameters = new HashMap<>();
        parameters.put("id",Id);
//        Employee employee = template.queryForObject(query,new Object[]{Id},new BeanPropertyRowMapper<>(Employee.class));
//        return employee;
        return (Employee) template.queryForObject(query,parameters,new EmployeeMapper());
    }

    /*Adding an emp into database table*/
    @CacheEvict(value = {"employee"}, allEntries = true)
    public int addEmp(Employee emp){
        query = rb.getString("insert");
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", emp.getId())
                .addValue("name", emp.getName());
        return template.update(query,parameters,holder);
    }
    /*delete an emp from database*/
    @CacheEvict(value = {"employee"}, allEntries = true)
    public int deleteEmp(int id){
        query = rb.getString("delete");
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id);
        return template.update(query,parameters,holder);
        //return template.update(query,id);
    }
    /*update an emp from database*/
    @CacheEvict(value = {"employee"}, allEntries = true)
    public int updateEmp(Employee emp){
        query = rb.getString("update");
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", emp.getId())
                .addValue("name", emp.getName());
        return template.update(query,parameters,holder);
        //return template.update(query,name,id);
    }

}


