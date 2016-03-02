package home.paul;

/**
 * Created by paul on 02.03.16.
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    private String s;

    public Main(String str){
        s = str;
    }

    public void sayHi(){
        System.out.println(s);
    }

    public static void main(String []args){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"config.xml"});//показываем Spring где лежит файл конфигурации
        Main h = (Main) ac.getBean("hello");//указываем id нашего bean-а
        h.sayHi();
    }
}
