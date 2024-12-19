package chap6_객체구현;

class Student1 {
	private String name;
	private String[] subjects;
	private int[] scores;
	private int age;
	private int count;
	private int value;
	private static int numberStudents;

	//Student1[]students 의 데이터타입 순서와 같아야 함.
	public Student1(String name,int age, String[] subjects, int[] scores, int value) {
		super();
		this.name = name;
		this.subjects = subjects;
		this.scores = scores;
		this.age = age;
		this.value = value;
		numberStudents++;
	}
	// 필드
	/*
	 * name, age, subjects[], scores[], count를 private으로 선언
	 * count는 배열의  index로 사용
	 *  numberStudents를 정적 필드로 선언
	 */
	// 생성자
	/*name, age, subjects[], scores[], count를 매개변수로 전달받는 생성자 정의
	 * 
	 */
	//	void setName(String name) {
	//		name=name;
	//	}
	//	void setAge(int age) {
	//		age=age;
	//	}
	//	void setSubjects(String subjects[]) {
	//		subjects=subjects;
	//	}
	//	void setScores(int scores[]) {
	//		scores=scores;
	//	}
	//	void setCount(int count) {
	//		count=count;
	//	}
	// setter 메소드: setName(String name), setAge(int age),  setSubjects(String subjects[]), setScores(int scores[]), setCount(int num)

	// 학생 수를 반환하는 정적 메소드getNumberStudents()
	public static int getCount() {
		return numberStudents;
	}

	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudent() {
		System.out.println("이름="+name+","+"나이="+age);
		for(int i=0; i<subjects.length; i++) {
			System.out.println("과목"+(i+1)+"="+subjects[i]+","+"점수"+(i+1)+"="+scores[i]);
		}
		/*
		 * 이름 = **, 나이 = **
		 * 과목1 = **, 점수1 = **
		 * 과목2 = **, 점수2 = **
		 * ... 등으로 출력
		 */
	}

	// 학생 정보를 출력하는 메소드 (예시용)
	//public void printStudentInfo() {
		/*
		 * 이름 = **, 나이 = **
		 * 과목1 = **, 점수1 = **
		 * 과목2 = **, 점수2 = **
		 * ... 등으로 출력
		 */
	}

public class 실습6_2생성자사용 {
	public static void main(String[] args) {
		String[] subjects = {"수학", "국어", "영어", "과학", "역사"};
		Student1[] students = {
				//생성자를 사용하여 객체 생성
				new Student1("홍길동", 21, subjects, new int[] { 85, 90, 78, 88, 92 }, -1),//배열 ,로 연결(세미콜론 아님)
				new Student1("김유신", 22, subjects, new int[] {75, 80, 85, 90, 95}, -1),
				new Student1("계백", 23, subjects, new int[] {65, 70, 75, 80, 85}, -1),
				new Student1("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, -1),
				new Student1("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, -1)

		};
		// 학생 수를 정적 메소드 호출로 처리
		// 학생 정보 출력 (예시)
		showStudents(students);
	}
	private static void showStudents(Student1[] students) {
		for(int i=0; i< students.length; i++) {
			students[i].printStudent();
		}
	}
}