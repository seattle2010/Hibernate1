package com.model.test;


import com.model.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class StudentTest1 {

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

			Student student = new Student();
			student.setName("tom");
			student.setAge(18);
			session.save(student);
			tx.commit();
		}

	//查找
	@Test
	public void testGet() {
		//(Student.class, new Integer(8))
		Student s = session.get(Student.class, 3L);
		System.out.println(s.getName() + "," + s.getAge());
		System.out.println(s);
		tx.commit();
		session.close();
	}

	//删除
	@Test
	public void delete() {
			//最好的做法是先查询出来 再删除
		Student s = session.get(Student.class, 13L);
		session.delete(s);

		tx.commit();
		session.close();
	}

	//修改
	@Test
	public void update() {
		Student s = session.get(Student.class, 12L);
		s.setName("jack");
		s.setAge(19);
		session.update(s);

		tx.commit();
		session.close();
	}

	//保存或者修改 如果不存在就保存 存在就修改
	@Test
	public void testSaveOrUpdate() {
			//保存  不要自己设置id值
		//Student student = new Student();
		//student.setName("rose");
		//student.setAge(18);
		//session.saveOrUpdate(student);

		Student s = session.get(Student.class, 12L);
		s.setName("rose");
		session.saveOrUpdate(s);
	}

	//查询所有
	//@Test
	//public void testQueryAll() {
	//	Query query = session.createQuery("from Student");
	//	session.createQuery("from Student")
	//
	//}
/*
    //增加
    @Test
    public void insert() {
        UserEntity ue = new UserEntity();
        ue.setUsername("Anny");
        ue.setPassword("123");
        ue.setEmail("Anny@163.com");
        session.save(ue);
        tx.commit();
    }
	//修改
		@Test
		public void update() {
			UserEntity user = (UserEntity) session.get(UserEntity.class, new Integer(2));
			user.setUsername("Penny");
			session.update(user);
			tx.commit();
			session.close();
		}
		//查找
		@Test
		public void getById() {
			UserEntity user = (UserEntity) session.get(UserEntity.class, new Integer(8));
			tx.commit();
			session.close();
			System.out.println("ID号：" + user.getId() + "；用户名：" + user.getUsername() +
					"；密码：" + user.getPassword() + "；邮件：" + user.getEmail());
		}
		//删除
		@Test
		public void delete() {
			UserEntity user = (UserEntity) session.get(UserEntity.class, new Integer(6));
			session.delete(user);
			tx.commit();
			session.close();
		}*/




}
