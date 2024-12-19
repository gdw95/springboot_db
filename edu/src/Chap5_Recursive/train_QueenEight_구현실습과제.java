package Chap5_Recursive;
//print로 변수 값 확인하는 디버깅 노동 피하자
//이클립스 디버깅 실습 필요 : variables tab, Expressions tab 사용하기
//92개 해 확인 필요
import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
//모든 해가 나오는 버젼 만들기 
/*
 * 체스판은 8 x 8 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
 * Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
 * pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능 체스판 최대 배치 문제 : king/16,
 * Queen/8, rook/8, bishop/?, knight/? rook 2개/a, h, knight 2개/b, g, bishop
 * 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
 */
/*
 * 8-Queen 문제는 체스판 위에 8개의 퀸을 배치하되, 서로 공격할 수 없도록 배치하는 문제입니다. 
 * 이 문제를 해결하기 위한 비재귀적(스택 기반) 알고리즘을 구현하려면, 다음과 같은 방법을 사용할 수 있습니다.

개요
1. 스택을 사용하여 백트래킹을 구현합니다. 각 스택의 요소는 체스판의 각 열에 대한 퀸의 배치 상태를 나타냅니다.
2. 퀸을 한 줄씩 배치한 후, 유효한지 확인하고, 다음 줄로 이동합니다.
3. 유효하지 않으면 스택을 이용해 이전 상태로 돌아가서 다른 경로를 시도합니다.

알고리즘
1. 스택을 이용하여 백트래킹을 구현하기 때문에, 현재 상태를 스택에 저장합니다. 
   스택의 각 원소는 퀸의 배치를 나타냅니다.
2. 체스판의 각 열에 대해 가능한 위치를 하나씩 확인하면서 퀸을 배치하고, 
   충돌이 발생하지 않는다면 다음 열로 넘어갑니다.
3. 더 이상 유효한 위치가 없으면, 스택에서 이전 상태로 되돌아가서 새로운 경로를 탐색합니다.
4. 퀸을 8개 다 배치하면, 해를 찾은 것이므로 스택을 이용해 해결책을 저장합니다.
 */


//.....nextMove 실행후 :: ix=4 iy =-1
//nextMove 실행후 :: ix=3 iy =-1
//nextMove 실행후 :: ix=2 iy =-1
//nextMove 실행후 :: ix=1 iy =-1
//nextMove 실행후 :: ix=0 iy =-1
//Chap5_Recursive.Stack4$EmptyGenericStackException: pop빈스택
//	at Chap5_Recursive.Stack4.pop(train_QueenEight_구현실습과제.java:88)
//	at Chap5_Recursive.train_QueenEight_구현실습과제.EightQueen(train_QueenEight_구현실습과제.java:186)
//	at Chap5_Recursive.train_QueenEight_구현실습과제.main(train_QueenEight_구현실습과제.java:335)
//->오류의미 : 스택이 비어있는데, pop() 메소드가 호출되었기 때문에 발생한 EmptyGenericStackException 예외.
//즉. 백트래킹을 진행할 때 스택에서 더 이상 팝할 요소가 없어서 발생한 예외.
//이 오류는 백트래킹을 통해 퀸을 배치하고, 더 이상 유효한 위치가 없을 때 스택을 비우는 과정에서 발생할수있다.
//점검 사항(1) nextMove() 함수에서 -1을 반환하는 이유: 퀸을 배치할 수 있는 위치를 찾지못하면 -1을 반환하고 있음. 하지만 이 -1이 반환되는 시점에서
//그 이전에 이미 퀸을 배치했던 위치를 제거하거나 스택에서 이전 상태로 돌아가는 코드가 없으면, 스택에서 꺼낼 요소가 없음. 즉 반복문 무한루프가 돌면서 스택이 비어버리기 때문에 pop()에서 예외가 발생하는 것임
//점검 사항(2) pop() 호출 시 적절한 체크: pop()을 호출하기 전에, 스택이 비어 있는지 확인하고, 비어있다면 예외 처리하거나 다른 방식으로 백트래킹을 종료 하여야 함.
//(1), (2) 를 통한 해결 방안: 
//nextMove() 로직 개선-> nextMove()에서 퀸을 배치할 수 없는 경우, 그 지점에서 더이상 진행할 수 없음을 알리는 조건을 추가할 것. 즉 백트래킹을 진행할 수 없다면 스택을 비우고 다시 돌아가야함.
//백트래킹 로직 수정-> 스택이 비어 있지 않다는 조건을 확인한 후 pop() 을 호줄해야함. 그 후에 퀸을 제거하고 iy++로 다시 시도할 수 있도록 수정할 것.
//디버깅 및 출력 개선-> 각 단계에서 현재 상태를 출력하여, ix와 iy 값이 제대로 업데이트되고 있는지 확인하는 것이 중요함. 각 스텝에서 nextMove() 가 올바르게 동작하는지 확인할 수 있어야 함.



//Q  .  .  .  .  .  .  . 
//.  .  .  .  Q  .  .  . 
//.  .  .  .  .  .  .  Q 
//.  .  .  .  .  Q  .  . 
//.  .  Q  .  .  .  .  . 
//.  .  .  .  .  .  Q  . 
//.  Q  .  .  .  .  .  . 
//.  .  .  Q  .  .  .  . 
//
//Chap5_Recursive.Stack4$EmptyGenericStackException: pop빈스택
//	at Chap5_Recursive.Stack4.pop(train_QueenEight_구현실습과제.java:110)
//	at Chap5_Recursive.train_QueenEight_구현실습과제.EightQueen(train_QueenEight_구현실습과제.java:269)
//	at Chap5_Recursive.train_QueenEight_구현실습과제.main(train_QueenEight_구현실습과제.java:416)
//->오류의미: 가능한 하나의 해를 나타내고 있으나, 이후에 발생한 오류는 여전히 Stack4.EmptyGenericStackException 오류이다. 스택이 비어있는 상태에서 pop()을 호줄하였기 때문.
//문제의 원인(1) 스택이 비어있음에도 pop()을 호출.
//문제의 원인(2) 백트래킹 로직에서 잘못된 종료 조건: 체스판에서 모든 퀸을 배치한 후, count == 8 로 퀸을 모두 배치했다는 것을 확인한 후, pop() 을 통해 이전 상태로 돌아가려고 함.(오류발생)
//(1), (2) 를 통한 해결 방안:
//스택이 비어있는지 확인-> pop()을 호출하기 전에 스택이 비어있는지 먼저 확인해야 함.
//nextMove 에서 유효한 이동이 없을 때 더이상 진행할 수 없는 경우 처리-> 스택이 비어있다면 더 이상 진행할 수 없으므로 종료하여야 함.




//Q  .  .  .  .  .  .  . 
//.  .  .  .  Q  .  .  . 
//.  .  .  .  .  .  .  Q 
//.  .  .  .  .  Q  .  . 
//.  .  Q  .  .  .  .  . 
//.  .  .  .  .  .  Q  . 
//.  Q  .  .  .  .  .  . 
//.  .  .  Q  .  .  .  . 
//현재 문제의 상태-> 하나의 해결책을 출력하고 종료하고 있다. 모든 가능한 해를 찾고 출력하는 코드로 수정해야함.
//모든 가능한 해를 찾는 방법:
//백트래킹을 계속 진행하여 모든 가능한 해결책을 찾는다.//백트래킹 후, 해가 완성되면 showQueens() 함수로 출력하고, 그 이후에는 다시 이전 상태로 돌아가서 다른 해결책을 찾는다.
//다시 초기화된 체스판에 퀸을 배치하여, 여러 해를 찾고 모두 출력한다.
//재귀적으로 퀸을 배치하고 해가 완성되면 그 해를 출력한다.


class Point {//체스판의 위치를 나타내는 클래스-> 행과 열 2개의 정수로 구성
	int ix;//필드
	int iy;

	public Point(int x, int y) {//메소드 
		ix = x;
		iy = y;
	}
}

class Stack4 {//Point객체를 관리하는 제네릭 스택 구현-> 스택에 요소를 추가, 제거하며 스택의 상태를 확인하는 여러 메소드를 제공.
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	static class EmptyGenericStackException extends Exception {
		//제네릭 스택 자료구조에서 스택이 비어 있을 때 발생할 수 있는 예외를 나타내기 위해 사용됨
		private static final long serialVersionUID = 1L;//직렬화

		public EmptyGenericStackException(String message) {
			super(message);
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	static class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException(String message) {
			super(message);
		}
	}

	private List<Point> data; // 스택용 배열
	// private List<T> data;
	int capacity; // 스택의 크기
	int top; // 스택 포인터

	// --- 생성자(constructor) ---//
	public Stack4(int capacity) {
		this.capacity = capacity;
		this.data = new ArrayList<Point>(capacity);
		this.top = 0;
	}

	// --- 스택에 x를 푸시 ---//
	public boolean push(Point x) throws OverflowGenericStackException {
		if (top >= capacity)
			throw new OverflowGenericStackException("OverflowException");
		data.add(x);
		top++;
		return true;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if (isEmpty())
			throw new EmptyGenericStackException("pop빈스택");
		else {
			return data.remove(--top);
		}
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if (isEmpty())
			throw new EmptyGenericStackException("pop빈스택");
		return data.get(top -1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
		data.clear();
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() throws EmptyGenericStackException{
		if (top <= 0)
			throw new EmptyGenericStackException("stack:: dump - empty");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

public class train_QueenEight_구현실습과제 {
	static void EightQueen(int [][]d) {	//EightQueens()메서드의 주요 논리: 백트래킹 로직이 구현, 모든 가능한 퀸 배치 방법을 찾음.
		//초기화: d라는 2D배열을 사용하여 체스판을 나타냄. 1은 퀸이 배치된 위치, 0은 빈 공간	//스택 st는 퀸의 위치를 저장하는 데 사용//첫 번째 퀸의 시작 위치는 (0,0)으로 설정됨
		//백트래킹 루프: nextmove()함수를 사용하여 현재 행에서 퀸을 배치할수있는 다움 유효한 열을 찾음//현재행에서 유요한 위치가 없으면(return -1) 스택에서 위치제거하고 이전에 배치한 퀸의 다음위치를 시도
		//퀸 배치: 유효한 위치가 발견되면 퀸배치, 그 위치를 스택에 저장한 후 다음 행으로 이동
		//조건 체크: checkRow(), checkCol(), checkDiagSW()와 같은 함수들이 퀸의 배치여부를 확인함. 항상 true 를 반환.
		//추가 체크: checkMove()-> 특정위치(x,y)에 퀸을 배치할 수 있는지 확인하는 함수//showQueens()->체스판을 출력하는 함수

	int numberOfSolutions = 0;
	int count = 0;//퀸 배치 갯수
	int ix = 0, iy = 0;// 행 ix, 열 iy
	Stack4 st = new Stack4(100); //100개를 저장할 수 있는 스택을 만들고
	Point p = new Point(ix, iy);//현 위치를 객체로 만들고
	d[ix][iy] = 1;//현 위치에 queen 을 넣었다는 표시를 하고
	count++;
	st.push(p);// 스택에 현 위치 객체를 push
	ix++;//ix 는 행별로 퀸 배치되는 것을 말한다.
	iy = 0;//다음 행으로 이동하면 열은 0부터 시작
	
	
//	while (true) {//무한루프
//		if (ix == 8) { //완료조건 체크//ix가 8이면 8개 배치 완료, stack이 empty가 아니면 다른 해를 구한다 
//			showQueens(d);
//			count--;
//			try {//백트래킹
//				p = st.pop();
//			}catch (Stack4.EmptyGenericStackException e) {
//				e.printStackTrace();
//				break; //백트래킹이 불가능하면 종료
//			}
//			ix = p.ix;
//			iy = p.iy;
//			iy++;
//			d[ix][iy] = 0;
//			continue;
//		}
//		if ((iy = nextMove(d, ix, iy))== -1) {//다음열 찾기//다음 이동할 열을 iy로 주는데 -1이면 더이상 이동할 열이 없음을 나타냄
//			System.out.println("nextMove 실행후 :: ix="+ix + " iy =" + iy);
//			try {//백트래킹
//				p = st.pop();
//			}catch (Stack4.EmptyGenericStackException e) {
//				e.printStackTrace();
//				break; //백트래킹이 불가능하면 종료
//			}
//			ix = p.ix;
//			iy = p.iy;
//			count--;
//			d[ix][iy] = 0;//퀸을 제거
//			iy++;
//			continue ;
//		}
//		
//		//배치가 가능
//		d[ix][iy] =1;//퀸 배치->현재 위치를 스택에 저장
//		count++;//카운트 증가
//		p = new Point(ix, iy);
//		st.push(p);//현재 위치를 스택에 저장  
//		
//		ix++;//ix 는 증가
//		iy = 0;//iy 는 0
//		
//		if (count == 8) { //퀸 개수 확인 //8개의 퀸이 모두 배치되면, 그 상태를 저장하거나 출력하는 처리가 필요.
//			showQueens(d);//현재 체스판 출력
//			//배치 후 다음 퀸의 위치를 찾기위해 스택을 통해 백트래킹 진행
//
//			try {
//				p = st.pop(); //이전 상태로 돌아가기
//			} catch (Stack4.EmptyGenericStackException e) {
//				e.printStackTrace();
//			}
//			ix = p.ix;
//			iy = p.iy;
//			iy++;
//			d[ix][iy] = 0; //퀸을 제거
//			count--; //카운트 감소
//			continue; //다음 루프 실행
//		}
//	}
//}
	
//	while (true) {
//        if (ix == 8) { // 퀸이 모두 배치된 경우
//            showQueens(d); // 배치된 체스판 출력
//            count--;
//            try {
//                p = st.pop(); // 이전 상태로 백트래킹
//                ix = p.ix;
//                iy = p.iy;
//                iy++;
//                d[ix][iy] = 0; // 퀸 제거
//            } catch (Stack4.EmptyGenericStackException e) {
//                e.printStackTrace();
//                break; // 백트래킹이 불가능하면 종료
//            }
//            continue; // 다시 이전 위치에서 시도
//        }
//
//        // 다음 이동할 위치 찾기
//        int nextCol = nextMove(d, ix, iy);
//        if (nextCol == -1) { // 더 이상 유효한 위치가 없으면
//            try {
//                p = st.pop(); // 스택에서 이전 상태로 돌아가기
//                ix = p.ix;
//                iy = p.iy;
//                count--;
//                d[ix][iy] = 0; // 퀸을 제거하고
//                iy++; // 다음 열로 이동
//            } catch (Stack4.EmptyGenericStackException e) {
//                e.printStackTrace();
//                break; // 백트래킹이 불가능하면 종료
//            }
//            continue; // 다음 상태로 넘어가기
//        }
//
//        // 유효한 위치를 찾았으면 퀸 배치
//        d[ix][nextCol] = 1; // 퀸 배치
//        count++;
//        p = new Point(ix, nextCol); // 퀸의 위치 저장
//        st.push(p); // 스택에 위치 저장
//
//        ix++; // 행 증가
//        iy = 0; // 열은 0부터 시작
//
//        if (count == 8) { // 8개의 퀸이 모두 배치된 경우
//            showQueens(d); // 체스판 출력
//            // 배치 후 백트래킹
//            try {
//                p = st.pop(); // 이전 상태로 돌아가기
//                ix = p.ix;
//                iy = p.iy;
//                iy++; // 다음 열로 이동
//                d[ix][iy] = 0; // 퀸 제거
//                count--;
//            } catch (Stack4.EmptyGenericStackException e) {
//                e.printStackTrace();
//            }
//            continue;
//        }
//    }
//}
	// 백트래킹을 통해 모든 해를 찾음
    while (true) {
        if (ix == 8) { // 퀸이 8개가 배치된 경우
            showQueens(d); // 체스판 출력
            count--; // 퀸 개수 감소
            try {
                if (!st.isEmpty()) { // 스택에 여전히 위치가 있으면
                    p = st.pop(); // 이전 상태로 백트래킹
                    ix = p.ix;
                    iy = p.iy;
                    iy++; // 다음 열로 이동
                    d[ix][iy] = 0; // 퀸을 제거
                } else {
                    break; // 더 이상 해결책이 없으면 종료
                }
            } catch (Stack4.EmptyGenericStackException e) {
                e.printStackTrace();
                break;
            }
            continue; // 새로운 경로를 탐색하기 위해 계속 진행
        }

        // 다음 이동할 위치 찾기
        int next = nextMove(d, ix, iy);
        if (next == -1) { // 더 이상 유효한 위치가 없으면 백트래킹
            try {
                if (!st.isEmpty()) {
                    p = st.pop(); // 이전 상태로 백트래킹
                    ix = p.ix;
                    iy = p.iy;
                    count--; // 퀸 개수 감소
                    d[ix][iy] = 0; // 퀸을 제거
                    iy++; // 다음 열로 이동
                } else {
                    break; // 스택이 비어있으면 종료
                }
            } catch (Stack4.EmptyGenericStackException e) {
                e.printStackTrace();
                break; // 백트래킹이 불가능하면 종료
            }
            continue;
        }

        // 유효한 위치를 찾았으면 퀸 배치
        d[ix][next] = 1; // 퀸 배치
        count++; // 퀸 개수 증가
        p = new Point(ix, next); // 퀸의 위치 저장
        st.push(p); // 스택에 퀸 위치 저장
        ix++; // 다음 행으로 이동
        iy = 0; // 열은 0부터 시작

        if (count == 8) { // 8개의 퀸이 모두 배치되었을 때
            showQueens(d); // 현재 체스판 출력
            try {
                if (!st.isEmpty()) {
                    p = st.pop(); // 이전 상태로 돌아가기
                    ix = p.ix;
                    iy = p.iy;
                    d[ix][iy] = 0; // 퀸 제거
                    iy++; // 다음 열로 이동
                    count--; // 퀸 개수 감소
                }
            } catch (Stack4.EmptyGenericStackException e) {
                e.printStackTrace();
            }
            continue; // 다른 경로를 탐색
        }
    }
}
	
	
	
//배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사
public static boolean checkRow(int[][] d, int crow) {
	for (int col = 0; col < 8; col++) {
		if (d[crow][col] == 1) {
			return false;//현재 행에 퀸이 이미 배치되어 있다면 false 반환
		}
	}
	return true;//퀸을 배치할 수 있다면 true 반환
}

//배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사
public static boolean checkCol(int[][] d, int ccol) {
	for (int row = 0; row < 8; row++) {
		if (d[row][ccol] == 1) {
			return false;
		}
	}
	return true;
}

//배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
public static boolean checkDiagSW(int[][] d, int cx, int cy) {
	int x = cx;
	int y = cy;
	
	while (x < 8 && y >= 0) {
		if (d[x][y] == 1) {
			return false;
		}
		x++; y--;
	}
	x = cx;
	y = cy;
	
	while (y < 8 && x >= 0) {
		if (d[x][y] == 1) {
			return false;
		}
		x--; y++;
	}
	return true;// x++, y-- or x--, y++ where 0<= x,y <= 7
}

//배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
public static boolean checkDiagSE(int[][] d, int cx, int cy) {
	int x = cx;
	int y = cy;
	
	while (x < 8 && y < 8) {
		if(d[x][y] == 1) {
			return false;
		}
		x++; y++;
	}
	x = cx;
	y = cy;
	
	while (x >= 0 && y >= 0) {
		if(d[x][y] == 1) {
			return false;
		}
		x--; y--;
	}
	return true;// x++, y++ or x--, y--
}

//배열 d에서 (x,y)에 퀸을 배치할 수 있는지  조사//네 개를 다 호출
public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
	return checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y);

}

//배열 d에서 현재 위치(row, col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴//checkMove()호출 //for 문 
public static int nextMove(int[][] d, int row, int col) {
	//if (row >= d.length) return -1;//row 가 체스판의 크기를 넘으면 종료-> 예외오류 해결
	//오류: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 8
	
	for (int nextCol = col; nextCol < 8; nextCol++) {
		if (checkMove(d, row, nextCol)) {
			return nextCol;//유효한 다음 열을 찾으면 반환(현재 row, col에 대하여 이동할 nextCol을 return)
		}
	}
	return -1;// 유효한 위치가 없으면 -1 반환. 
}

static void showQueens(int[][] d) {// 배열 출력
	
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (d[i][j] == 1) {
                System.out.print("Q ");
            } else {
                System.out.print(". ");
            }
        }
        System.out.println();
    }
    System.out.println();
}

public static void main(String[] args) {//메인메소드: 체스판을 초기화하고 모든 위치를 0으로 설정한 후, EightQueens()메서드를 호출하여 알고리즘 시작. 
    int[][] d = new int[8][8]; // 8x8 체스판 초기화
    EightQueen(d); // 퀸 배치 시작

}
}