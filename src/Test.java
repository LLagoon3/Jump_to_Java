import java.util.ArrayList;
import java.util.Arrays;



class Animal{
    String name;
    public Animal(String n){ //기본 생성자
        this.name = n;
    }
    public void printName(){ //메서드
        System.out.println(this.name);
    }
    // public String getName(){
    //     return this.name;
    // }
}

class Dog extends Animal{//부모 클래스의 생성자에 매개변수가 있으면 자동으로 호출X
    public Dog(String n){//자식 클래스 기본 생성자
        super(n);//부모 클래스 기본생성자 호출
    }
    void sleep(){
        System.out.println(this.name + " Zzz");
    }
}

class HouseDog extends Dog{
    public HouseDog(String n){
        super(n);
    }
    public HouseDog(int type){//생성자 오버로딩
        super("");
        if (type == 1){
            this.name = "yorkshire";
        }
        else if (type == 2){
            this.name = "bulldog";
        }
    }
    void sleep(){//메소드 오버라이딩
        System.out.println(this.name + " Zzz in House");
    }
    void sleep(int time){//메소드 오버로딩
        System.out.println(this.name + " Zzz in House for " + time);
    }
}

interface Predator{//인터페이스
    String getName();//인터페이스 메소드 -> 상속받은 클래스에서 재정의
    default void printName(){//디폴트 메소드 -> 오버라이딩 가능
        System.out.println(getName());
    }
}

interface Barkable{
    void bark();
}

interface BarkablePredator extends Barkable, Predator{//인터페이스 다중 상속
}

class Tiger extends Animal implements Predator, Barkable{
    public Tiger(String name){
        super(name);
    }
    public String getName(){
        return this.name;
    }
    public void bark(){
        System.out.println("Tiger Bark " + this.name);
    }
}

class Lion extends Animal implements Predator, Barkable{
    public Lion(String name){
        super(name);
    }
    public String getName(){
        return this.name;
    }
    public void bark(){
        System.out.println("Lion Bark " + this.name);
    }
}

class ZooKeeper{
    void feed(Predator predator){
        System.out.println("feed to " + predator.getName());
    }
}

class Bouncer{
    // void barkAnimal(Predator predator){
    //     if (predator instanceof Tiger){
    //         System.out.println("Tiger Bark " + predator.getName());
    //     }
    //     else if(predator instanceof Lion){
    //         System.out.println("Lion Bark " + predator.getName());
    //     }
    // }
    void barkAnimal(Barkable barkable){//인자가 predator와 barkable 두 인터페이스의 객체 -> 다형성
        barkable.bark();
    }
}

abstract class _Predator extends Animal{//추상 클래스
    public _Predator(String name){//생성자
        super(name);
    }
    abstract String getFood();//추상 메소드 -> 상속받은 클래스에서 구현
    void printFood(){
        System.out.println("Food is " + getFood());
    }
}

class _Tiger extends _Predator implements Barkable{
    public _Tiger(String name){
        super(name);
    }
    public String getFood(){//추상 클래스 메소드 구현
        return "banana";
    }
    public void bark(){//인터페이스 메소드 구현
        System.out.println("_Tiger Bark " + this.name);
    }
}



public class Test {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        

        //자료형의 최대/최소 길이
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
        

        //배열
        int arr[]; //선언
        arr = new int[5]; //생성


        //동적배열
        ArrayList<Integer> arrlist = new ArrayList<>();


        //switch
        int tmp = 1;
        switch(tmp){
            case 0:
                System.out.println('X');
                break;
            case 1:
                System.out.println('O');
                break;
            default:
                System.out.println('X');
        }


        //삼항 연산 
        //변수 = (조건) ? true일 때 : false일 때 
        // Boolean result = (tmp == 1) ? true : false;
        System.out.println((tmp == 1) ? true : false);


        //반복문
        for (int i = 0; i < 5; i++){
            arr[i] = i;
            arrlist.add(i);
        }
        System.out.printf("arr : %s\narrlist : %s\n", Arrays.toString(arr), arrlist.toString());

        for(int num : arrlist){
            System.out.print(num);
        }
        System.out.print('\n');

        while(tmp == 1){
            System.out.println(tmp);
            tmp -= 1;
        }


        //클래스
        Dog dog = new Dog("name");
        dog.printName();
        dog.sleep();
        Animal dog1 = new Dog("name");//IS-A, 이 경우 Dog의 메소드 사용불가
        HouseDog dog2 = new HouseDog("House Dog");
        dog2.sleep(4);
        HouseDog dog3 = new HouseDog(1);
        dog3.printName();
        

        //인터페이스
        ZooKeeper zooKeeper = new ZooKeeper();
        Predator tiger = new Tiger("tiger");//IS-A, Barkable 인터페이스 메소드 사용불가
        Lion lion = new Lion("lion");
        zooKeeper.feed(tiger);
        lion.printName();


        //다형성
        Bouncer bouncer = new Bouncer();
        bouncer.barkAnimal(lion);

        //추상 클래스
        _Tiger _tiger = new _Tiger("_tiger");//_Predator 추상 클래스, Barkable 인터페이스
        System.out.println("Get Food : " + _tiger.getFood());
    }
}
