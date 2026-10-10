public class HelloWorld {
    public static void main(String[] args) {
        //ThreadDemo threadDemo = new ThreadDemo();
        //Thread t = new Thread(threadDemo);
        ThreadExtends t = new ThreadExtends();
        t.setPriority(10);
        t.start();
        System.out.println("Hello, World Main Thread!");
    }
}
