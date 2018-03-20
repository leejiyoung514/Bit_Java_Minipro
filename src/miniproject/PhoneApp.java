package miniproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		int number, index;
		String line = "";
		String inputName, inputHp, inputCompany, in;
		boolean run = true;

		List<Person> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		Reader fr = new FileReader("phoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		System.out.println("********************************************");
		System.out.println("*          전화번호 관리 프로그램          *");
		System.out.println("********************************************");

		while (run) {
			System.out.println();
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print(">메뉴번호:");
			number = sc.nextInt();
			System.out.println(number);

			switch (number) {
			case 1:
				System.out.println("<1.리스트>");
				list = new ArrayList<>();
				fr = new FileReader("phoneDB.txt");
				br = new BufferedReader(fr);
				while (true) {
					line = br.readLine();

					if (line == null) {
						break;
					}
					String[] personInfo = line.split(",");
					Person person = new Person(personInfo[0], personInfo[1], personInfo[2]);
					list.add(person);
				}

				for (int i = 0; i < list.size(); i++) {
					System.out.println((i + 1) + ". " + list.get(i).getName() + " " + list.get(i).getHp() + "     "
							+ list.get(i).getCompany());
				}
				break;

			case 2:
				System.out.println("<2.등록>");
				list = new ArrayList<>();
				fr = new FileReader("phoneDB.txt");
				br = new BufferedReader(fr);
				while (true) {
					line = br.readLine();

					if (line == null) {
						break;
					}
					String[] personInfo = line.split(",");
					Person person = new Person(personInfo[0], personInfo[1], personInfo[2]);
					list.add(person);
				}

				System.out.print(">이름:");
				inputName = sc.next();
				System.out.print(">휴대전화:");
				inputHp = sc.next();
				System.out.print(">회사전화:");
				inputCompany = sc.next();

				Person person = new Person(inputName, inputHp, inputCompany);
				list.add(person);

				br.close();

				Writer fw = new FileWriter("phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);

				for (int i = 0; i < list.size(); i++) {
					bw.write(list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getCompany());
					bw.newLine();
					bw.flush();
				}
				bw.close();

				System.out.println();
				System.out.println("[등록되었습니다.]");
				break;

			case 3:
				System.out.println("<3.삭제>");
				list = new ArrayList<>();
				fr = new FileReader("phoneDB.txt");
				br = new BufferedReader(fr);

				while (true) {
					line = br.readLine();

					if (line == null) {
						break;
					}
					String[] personInfo = line.split(",");
					person = new Person(personInfo[0], personInfo[1], personInfo[2]);
					list.add(person);
				}
				System.out.print(">번호:");
				index = sc.nextInt();
				list.remove(index - 1);

				fw = new FileWriter("phoneDB.txt");
				bw = new BufferedWriter(fw);
				for (int i = 0; i < list.size(); i++) {
					bw.write(list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getCompany());
					bw.newLine();
					bw.flush();
				}
				bw.close();

				System.out.println();
				System.out.println("[삭제되었습니다.]");
				break;

			case 4:
				System.out.println("<4.검색>");

				list = new ArrayList<>();
				fr = new FileReader("phoneDB.txt");
				br = new BufferedReader(fr);

				while (true) {
					line = br.readLine();

					if (line == null) {
						break;
					}
					String[] personInfo = line.split(",");
					person = new Person(personInfo[0], personInfo[1], personInfo[2]);
					list.add(person);
				}
				System.out.print("찾고자 하는 이름:");
				in = sc.next();

				for (int i = 0; i < list.size(); i++) {
					boolean a = list.get(i).getName().contains(in);

					if (a == true) {
						System.out.println((i + 1) + ". " + list.get(i).getName() + " " + list.get(i).getHp() + "     "
								+ list.get(i).getCompany());
					}
				}

				fw = new FileWriter("phoneDB.txt");
				bw = new BufferedWriter(fw);
				for (int i = 0; i < list.size(); i++) {
					bw.write(list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getCompany());
					bw.newLine();
					bw.flush();
				}
				bw.close();
				break;

			case 5:
				System.out.println();
				System.out.println("********************************************");
				System.out.println("*                감사합니다                *");
				System.out.println("********************************************");

				run = false;
				break;

			default:
				System.out.println("없는 항목입니다(다시 입력해주세요.)");

				break;
			}

		}
	}
}
