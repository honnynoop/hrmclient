package kr.co.infopub.chapter.s191.model;

import java.sql.SQLException;
import java.util.List;

import javafx.collections.ObservableList;
import kr.co.infopub.chapter.s191.dto.DepConvert;
import kr.co.infopub.chapter.s191.dto.DepCount;
import kr.co.infopub.chapter.s191.dto.DepCountConvert;
import kr.co.infopub.chapter.s191.dto.DepCountDto;
import kr.co.infopub.chapter.s191.dto.Department;
import kr.co.infopub.chapter.s191.dto.DepartmentDto;
import kr.co.infopub.chapter.s191.dto.EmpConvert;
import kr.co.infopub.chapter.s191.dto.EmployeeDto;
import kr.co.infopub.chapter.s191.dto.Employee;


public class EmployeeService {
 private static EmployeeService employeeService;
 private  EmployeeDAO employeeDAO; 
 private EmployeeService() {
	employeeDAO=new EmployeeDAO();
 }
 public static EmployeeService getInstance(){
	if(employeeService==null){
		employeeService=new EmployeeService();
	}
	return employeeService;
 }
	public ObservableList<Department> findAllDepartments() throws SQLException{
		List<DepartmentDto> blist=employeeDAO.findAllDepartments();
		return DepConvert.toObservProFromDto(blist);
	}
	public ObservableList<Employee> findEmployeesByDepartName(String val) throws SQLException{
		 List<EmployeeDto> emplists=employeeDAO.findEmployeesByDepartName( val);
		 return EmpConvert.toObservProFromDto(emplists);
	}

	public ObservableList<Employee> findAllEmployees() throws SQLException{
		List<EmployeeDto> blist  = employeeDAO.findAllEmployees ();
    	return EmpConvert.toObservProFromDto(blist);
	}

	public ObservableList<Employee> findTreeManagerInEmployee() throws SQLException{
		 List<EmployeeDto> bdlists= employeeDAO.findTreeManagerInEmployee();
		 return EmpConvert.toObservProFromDto(bdlists);
	}

	public int getTreeMaxLevel() throws SQLException{
		return  employeeDAO.getTreeMaxLevel();
	}

	public ObservableList<Employee> findEmployeesByEmpId(String val) throws SQLException{
		List<EmployeeDto> elists=employeeDAO.findEmployeesByEmpId(val);//100
		return EmpConvert.toObservProFromDto(elists);
	}

	public Employee findEmployeeById(String string) throws SQLException{
		EmployeeDto edto =employeeDAO.findEmployeeById(string);
		return EmpConvert.toPro(edto);
	}

	public ObservableList<Employee> findManagersByName(String searchname) throws SQLException{
		 List<EmployeeDto> elists=employeeDAO.findManagersByName(searchname);
		return EmpConvert.toObservProFromDto(elists);
	}

	public ObservableList<String> findAllJobs() throws SQLException{
	    List<String> jlists=employeeDAO.findAllJobs();
		return EmpConvert.strList(jlists);
	}

	public ObservableList<Department> findAllDepartments2() throws SQLException{
        List<DepartmentDto> edeps=employeeDAO.findAllDepartments2 ();
		return DepConvert.toObservProFromDto(edeps);
	}

	public int addEmployee(EmployeeDto empdto) throws SQLException{
		return employeeDAO.addEmployee(empdto);
	}

	public boolean updateEmployee(Employee emp) throws SQLException{
		EmployeeDto edot=EmpConvert.toDto(emp);
		return employeeDAO.updateEmployee(edot);
	}

	public boolean deleteEmployee(Employee emp) throws SQLException{
		EmployeeDto edot=EmpConvert.toDto(emp);
		return employeeDAO.deleteEmployee(edot);
	}

	public ObservableList<DepCount> findAllDepCounts() throws SQLException{
 	    List<DepCountDto> deplist = employeeDAO.findAllDepCounts();
	    return DepCountConvert.toObservProFromDto(deplist);
	}

	public int getEmployeesTotal() throws SQLException{
		return employeeDAO.getEmployeesTotal();
	}
	
}
