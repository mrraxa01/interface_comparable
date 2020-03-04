package aplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		String path = "C:\\temp\\in.txt";
		
		try (BufferedReader br = new BufferedReader (new FileReader(path))){
			
			String employeeCsv = br.readLine();
			while (employeeCsv != null) {
				String[] fields = employeeCsv.split(",");//cria um vetor de string lendo 2 posições separadas por ',' nome, salário
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));//salva nome na pos 0 e salário na 1 - converte o salário em double
				employeeCsv = br.readLine();
			}
			Collections.sort(list);
			for (Employee emp : list) {
				System.out.println(emp.getName() + "," + emp.getSalary());
				
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

}
