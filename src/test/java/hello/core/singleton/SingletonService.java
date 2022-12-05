package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //static으로 가지고 있음-> 클래스 레벨에 올라가기 때문에 딱 하나만 존재

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() { //private으로 생성자 만들어 두면 외부에서 생성자를 통해 새로 객체 생성이 불가능
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
