package QueryTest;


import com.model.entity.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class QueryTest {
	@Test
	public void createQuery() {

		//1 加载配置文件
		Configuration config = new Configuration().configure("/hibernate.cfg.xml");
		//2创建SessionFactory对象,生成Session对象
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3创建Session对象
		Session session = sessionFactory.openSession();
		//4开启事务
		Transaction tx = session.beginTransaction();

		//HQL查询
		//Query query = session.createQuery("from Student");
		//Query query = session.createQuery("from Student where age > ?");
		Query query = session.createQuery("from Student where name like ?");

		//设置值
		query.setInteger(0, 18);
		//模糊查询
		query.setString(0, "%0%");
//order by 属性
		List<Student> list = query.list();
		for(Student student:list){
		    System.out.println(student);
		}

		tx.commit();
		session.close();
	}
//QBC的检索方式
	//criteria接口进行条件查询 可以不用写sql语句 是纯面向对象的
	@Test
	public void criteriaTest() {
		//1 加载配置文件
		Configuration config = new Configuration().configure("/hibernate.cfg.xml");
		//2创建SessionFactory对象,生成Session对象
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3创建Session对象
		Session session = sessionFactory.openSession();
		//4开启事务
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);
		List<Student> list = criteria.list();
		for(Student student:list){
			System.out.println(student);
		}
	}

	@Test
	public void criteriaTest2() {
		//1 加载配置文件
		Configuration config = new Configuration().configure("/hibernate.cfg.xml");
		//2创建SessionFactory对象,生成Session对象
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3创建Session对象
		Session session = sessionFactory.openSession();
		//4开启事务
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);
		//添加查询条件 age>18
			//Criterion是接口 Restrictions是他的实现工具类
		//Restrictions提供静态方法 拼接查询条件  gt大于
		criteria.add(Restrictions.gt("age", 18));
		criteria.add(Restrictions.like("name", "%o%"));

		List<Student> list = criteria.list();
		for(Student student:list){
			System.out.println(student);
		}
	}
}
