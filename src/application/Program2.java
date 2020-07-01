package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();


		System.out.println("=== TEST 1: findById =======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

		System.out.println("\n=== TEST 3: Department findAll ===");
		List<Department> list = departmentDao.findAll();

		for (Department d : list) {
			System.out.println(d);

		}

		System.out.println("\n=== TEST 4: Department insert ===");
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id: " + newDepartment.getId());

		System.out.println("\n=== TEST 5: Department update ===");
		Department dep2= departmentDao.findById(7);
		dep2.setName("Cars");
		departmentDao.update(dep2);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 6: Department delete ===");
		System.out.println("Enter id for delete: ");
		int id = scan.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		scan.close();

	}

}
