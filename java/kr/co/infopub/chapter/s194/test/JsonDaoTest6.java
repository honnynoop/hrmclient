package kr.co.infopub.chapter.s194.test;
import java.sql.SQLException;
import java.util.List;
import kr.co.infopub.chapter.s194.dto.DepartmentDto;
import kr.co.infopub.chapter.s194.model.EmployeeRestJsonDao;
public class JsonDaoTest6 {
	public static void main(String[] args) {
		EmployeeRestJsonDao jdao=new EmployeeRestJsonDao();
		// 6) 			
		try {
			List<DepartmentDto> femps=jdao.findAllDepartments2()  ;
			for(DepartmentDto femp: femps){
				System.out.println(femp);
			}
			System.out.println( "Size ---------------->"+femps.size());
		} catch (SQLException e) {
			System.out.println(e);
		}			
	}
}
