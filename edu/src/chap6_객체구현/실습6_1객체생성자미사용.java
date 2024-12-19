package chap6_객체구현;

class Student {
	private String name;
	private String[] subjects;
	private int[] scores;
	private int age;
	private int count;
	private int value;
	private static int numberStudents;
	
	public Student() {
		numberStudents++;
	}
	// 필드
	/*
	 * name, age, subjects[], scores[], count를 private으로 선언
	 * count는 배열의  index로 사용
	 */
	void setName(String name) {
		this.name=name;
	}
	void setAge(int age) {
		this.age=age;
	}
	void setSubjects(String subjects[]) {
		this.subjects=subjects;
	}
	void setScores(int scores[]) {
		this.scores=scores;
	}
	void setCount(int count) {
		this.count=count;
	}
	// setter 메소드: setName(String name), setAge(int age),  setSubjects(String subjects[]), setScores(int scores[]), setCount(int num)
	// 학생 수를 반환하는 정적 메소드
	public static int getCount() {
		return numberStudents;
	}

	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudent() {
		
		System.out.println("이름="+name+","+"나이="+age);
		for(int i=0; i<count; i++) {
			System.out.println("과목"+(i+1)+"="+subjects[i]+","+"점수"+(i+1)+"+"+scores[i]);
		}
		/*
		 * 이름 = **, 나이 = **
		 * 과목1 = **, 점수1 = **
		 * 과목2 = **, 점수2 = **
		 * ... 등으로 출력
		 */
	}
}
public class 실습6_1객체생성자미사용 {//과목 출력 int n, s.setCount(n);
	static Student makeStudent(String name, int age, String[] subjects, int[] scores, int n) {
		Student s = new Student();
		//setter를 사용한 구현
		s.setName(name); 
		s.setAge(age);
		s.setSubjects(subjects);
		s.setScores(scores);
		s.setCount(n);
		return s;
	}
	public static void showStudent(Student[]students) {
		for(int i=0; i<students.length; i++) {
			students[i].printStudent();
		}
	}
	//showStudents() 메소드 구현 -printStudent() 메소드를 호출하여 구현
	public static void showStudents(Student[]students) {
		for(int i=0; i< students.length; i++) {
			students[i].printStudent();
		}
	}

		public static void main(String[] args) {
			String[] subjects = {"수학", "국어", "영어", "과학", "역사"};
			Student[] students = {
					makeStudent("홍길동", 21, subjects, new int[]{85, 90, 78, 88, 92}, 5),
					makeStudent("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, 5),
					makeStudent("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, 5),
					makeStudent("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, 5),
					makeStudent("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, 5)
			};
			//둘 메소드 차이 알 것
			int num = Student.getCount();//정적 메소드
//			students[0].printStudent();//인스턴스 메소드
			// 학생 정보 출력 (예시)
			showStudents(students);
		}
	}