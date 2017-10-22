package localThread.service;

import com.model.entity.Student;
import localThread.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserService {
	public void ServiceSave(Student s1, Student s2) {
		UserDao dao = new UserDao();

		//1 加载配置文件
		Configuration config = new Configuration().configure("/hibernate.cfg.xml");
		//2创建SessionFactory对象,生成Session对象
		SessionFactory sessionFactory = config.buildSessionFactory();
		//3创建Session对象

		//!!!!!!                这块的getSession()改成getCurrentSession()
		Session session = sessionFactory.getCurrentSession();
		//4开启事务
		Transaction tx = session.beginTransaction();


try{

	dao.DaoSave1(s1);

	//int a = 10/0;
	dao.DaoSave1(s2);

	//提交事务
	tx.commit();
}catch(Exception e){
    e.printStackTrace();
    //出现问题回滚
    tx.rollback();
}
	}
}
