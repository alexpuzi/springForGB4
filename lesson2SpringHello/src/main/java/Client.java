import com.sun.javafx.fxml.BeanAdapter;

public class Client {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContext context = (ApplicationContext) new ClassPathXmlApplicationContext();
        Camera camera = context.getBean();
        camera.doPhotograph();
    }
}

