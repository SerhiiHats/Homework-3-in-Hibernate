import models.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *Создать новую базу данных с помощью MySQLWorkbench.
 * Создать Gradle-проект и настроить его правильно.
 * Создать файл с настройками hibernate.cfg.xml.
 * И создать класс Animal(int age, String name, boolean tail) с методами get и set, как сущность к нашей таблице.
 * И с помощью hibernate создать новую таблицу с начальным значением.
 **/

public class Main {
    public static void main(String[] args) {

        Animal animal = new Animal();

        animal.setAge(15);
        animal.setName("Cat");
        animal.setTail(true);

        System.out.println(animal);

        //Фабрика соединения
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        //сессия - продукт фабрики соединения
        Session session = factory.openSession();    //открыли сессию
        session.beginTransaction();                //начало транзакции сессии
        session.save(animal);                      //сохранение объекта в сессии
        session.getTransaction().commit();         //коммит транзакции в сессии
        session.close();                           //закрываем сессию
    }
}
