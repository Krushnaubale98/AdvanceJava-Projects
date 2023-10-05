package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import maccess.DB06CheckBranch;
import maccess.DB06GenBrCode;
import maccess.DB06Percentage;
import maccess.DB06StuResult;
import maccess.DBConn;
/*Assignment:
DB Table : Student44(rollno,stuname,branch,totmarks,per,result)
                        
Construct JDBC Application to perform the following operations based on user
choice:
     1.AddStudent
     2.ViewStudentByRollNo
     3.ViewAllStudents
     1.AddStudent:
    	   read:
    	       rollNo
    	       stuName
    	       branch
    	       six Sub marks
    	   calculate:
    	       totMarks
    	       per
    	       result
    	Upload assignment:
    	   sm.java123@gmail.com
*/

public class DBCon06 {
	@SuppressWarnings({ "unused" })
	public static void main(String args[]) {
		try {
			try (Scanner sc = new Scanner(System.in)) {
				while (true) {

					System.out.println("=======choice========");
					System.out.println("1.AddStudent\n2.ViewStudentByRollNo\n3.ViewAllStudent");
					System.out.println("Enter the choice:");
					String rollno = null;
					String stuname = null;
					String branch = null;
					int tolmarks = 0;
					float perc = 0;
					String result = null;

					switch (Integer.parseInt(sc.nextLine())) {
					case 1:
						// 1.AddStudent
						System.out.println("Enter the 10(Digit) Stu rollNo: ");
						rollno = sc.nextLine().toUpperCase(); // rollno
						int len = rollno.length();
						if (len == 10) {
							String brCode = rollno.substring(6, 8);
							DB06GenBrCode gbr = new DB06GenBrCode();
							String genBranch = gbr.generate(brCode);
							if (genBranch == null) {
								System.out.println("RollNO not matched with the branch");
							} else {
								System.out.println("Enter the stuName: ");
								stuname = sc.nextLine();// stuname

								System.out.println("Enter the Branch :(CE/EEE/ECE/SCE/MECH):");
								branch = sc.nextLine().toUpperCase(); // branch
							DB06CheckBranch cbr = new DB06CheckBranch();
								boolean br = cbr.verify(branch);
								if (br) {
									if (genBranch.equals(branch)) {
										System.out.println("==Enter the six sub marks== ");
										int i = 1;

										boolean b = false;
										while (i <= 6) {
											System.out.println("Enter the marks sub: " + i);
											int mark = Integer.parseInt(sc.nextLine());

											if (mark < 0 || mark >= 100) {
												System.out.println("invalid marks...");
												continue;
											} // end of if
											else {
												if (mark >= 0 && mark <= 34) {
													b = true;
												}
												tolmarks = tolmarks + mark; // totalmarks
												i++;
											} // end of else

											// System.out.println("TotlMarks: " + tolMarks);
											DB06Percentage percentage = new DB06Percentage();
											perc = percentage.calculate(tolmarks); // percentage

											DB06StuResult res = new DB06StuResult();
											result = res.result(perc, b); // result

										} // end of while

									} else {
										System.out.println("Branch  not matched with the rollno...");
									}

								} else {
									System.out.println("Invalid branch....");
								}

							} // end of if-else
						} else {
							System.out.println("Invalid rollNo");
						} // end of if-else

						/*//create table Students44:
						 * PreparedStatement ps1 = DBConn.connection().prepareStatement(
								"Create table Students44 (rollno varchar2(10),stuname varchar2(10),branch varchar(6),totMarks number(3),perc number(5,2),result varchar2(10))");
						   System.out.println("table created ...");
						*/
						PreparedStatement ps1 = DBConn.connection()
								.prepareStatement("Insert into students44 values(?,?,?,?,?,?)");
						ps1.setString(1, rollno);
						ps1.setString(2, stuname);
						ps1.setString(3, branch);
						ps1.setInt(4, tolmarks);
						ps1.setFloat(5, perc);
						ps1.setString(6, result);
						int k = ps1.executeUpdate();
						if (k > 0) {
							System.out.println("Students added successfully...");
						}

						System.out.println("==========dis details=======");
						System.out.println("Student name :" + stuname);
						System.out.println("Sudent perc: " + perc);

						System.out.println("Sudent rollno: " + rollno);
						System.out.println("Sudent branch: " + branch);
						System.out.println("Student result: " + result);

						break;

					case 2:
						// 2.ViewStudentByRollNo

						System.out.println("Enter the rollno: ");
						String Rollno = sc.nextLine().toUpperCase();

						PreparedStatement ps2 = DBConn.connection()
								.prepareStatement("Select * from students44 where rollno=?");

						ps2.setString(1, Rollno);
						ResultSet rs = ps2.executeQuery();

						if (rs.next()) {

							System.out.println("======Display the student details=====");

							System.out.println("StuName: " + rs.getString(2));
							System.out.println("Branch :" + rs.getString(3));
							System.out.println("TotalMarks: " + rs.getInt(4));
							System.out.println("Percentage: " + rs.getFloat(5));
							System.out.println("Result :" + rs.getString(6));
						} else {
							System.out.println("Invaid login process");
						}

						break;
					case 3:
						// 3.ViewAllStudents

						PreparedStatement ps3 = DBConn.connection().prepareStatement("Select * from students44");
						ResultSet rs1 = ps3.executeQuery();
						while (rs1.next()) {
							System.out.println("" + rs1.getString(1) + "\t" + rs1.getString(2)
									+ "\t" + rs1.getString(3) + "\t" + rs1.getInt(4) + "\t"
									+ rs1.getFloat(5) + "\t " + rs1.getString(6));
						}

					default:
						System.out.println("Invalid Choice......");
					}// end of switch

				} // end of while
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}
}
