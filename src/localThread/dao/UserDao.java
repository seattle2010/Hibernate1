package localThread.dao;

import com.model.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {

	public void  DaoSave1(Student s1) {
		//Configuration config = null;
		//SessionFactory sessionFactory = null;
		//Session session = null;
		//Transaction tx = null;

			//1 加载配置文件
		Configuration config = new Configuration().configure("/hibernate.cfg.xml");
			//2创建SessionFactory对象,生成Session对象
		SessionFactory sessionFactory = config.buildSessionFactory();
			//3创建Session对象
		Session	session = sessionFactory.getCurrentSession();
			//4开启事务
		Transaction	tx = session.beginTransaction();

		session.save(s1);
		}


	public void  DaoSave2(Student s2) {


		//1 加载配置文件
		Configuration config = new Configuration().configure("/hibernate.cfg.xml");
		//2创建SessionFactory对象,生成Session对象
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3创建Session对象
		Session	session = sessionFactory.getCurrentSession();
		//4开启事务
		Transaction	tx = session.beginTransaction();

		session.save(s2);

	}
}
