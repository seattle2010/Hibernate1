package localThread.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class test {
	//1 加载配置文件
//2创建SessionFactory对象,生成Session对象
//3创建Session对象
//4开启事务
//5编写对应增删改查代码
//6提交事务
//7释放资源

	Configuration config = null;
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction tx = null;
	@Before
	public void init() {
		//1 加载配置文件
		config = new Configuration().configure("/hibernate.cfg.xml");
		//2创建SessionFactory对象,生成Session对象
		sessionFactory = config.buildSessionFactory();
		//3创建Session对象
		session = sessionFactory.openSession();
		//4开启事务
		tx = session.beginTransaction();
	}
	//增加
	@Test
	public void testSave() {

		User u = new User();
		u.setName("tom");
		u.setAge(37);
		session.save(u);
		tx.commit();
		session.close();
	}
}
