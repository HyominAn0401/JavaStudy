package DataStructure;

public class IntStack {

    private int[] stk; //스택용 배열
    private int capacity; // 스택 용량
    private int ptr; // 스택 포인터

    // 실행 시 예외 : 스택이 비어있음
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException() {}
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException() {}
    }

    // 생성자
    public IntStack(int maxlen){
        ptr = 0;
        capacity = maxlen;
        try{
            stk = new int[capacity]; //스택 본체용 배열 생성
        } catch (OutOfMemoryError e){
            capacity = 0;
        }
    }

    // 스택에 push
    public int push(int x) throws OverflowIntStackException{
        if(ptr>=capacity)   throw new OverflowIntStackException();
        return stk[ptr++]=x; //x를 배열에 저장 -> 포인터 증가
    }

    // 스택에서 pop
    public int pop() throws EmptyIntStackException{
        if(ptr<=0)  throw new EmptyIntStackException();
        return stk[--ptr];
    }

    // 스택 꼭대기 데이터 피크
    public int peek() throws EmptyIntStackException{
        if(ptr<=0)  throw new EmptyIntStackException();
        return stk[ptr-1];
    }

    // 스택 모든 요소 삭제
    public void clear(){
        ptr = 0;
    }

    // 요소값 찾기
    public int indexOf(int x){
        for(int i=ptr-1; i>=0; i--){
            if(stk[i]==x){
                return i;
            }
        }
        return -1;
    }

    // 스택 용량 반환
    public int getCapacity(){
        return capacity;
    }

    // 스택에 쌓여 있는 데이터 개수 반환
    public int size(){
        return ptr;
    }

    // 스택이 비어 있는가?
    public boolean isEmpty(){
        return ptr<=0;
    }

    // 스택이 가득 차 있는가?
    public boolean isFull(){
        return ptr>=capacity;
    }

    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump(){
        if(ptr<=0)
            System.out.println("Stack is Empty");
        else{
            for(int i=0; i<ptr; i++){
                System.out.print(stk[i]+" ");
            }
            System.out.println();
        }
    }
}
