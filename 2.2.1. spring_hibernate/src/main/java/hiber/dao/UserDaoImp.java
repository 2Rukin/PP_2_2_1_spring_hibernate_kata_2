package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public User getUserCarList(String model, int series) {

      Car car= (Car) sessionFactory.getCurrentSession()
              .createQuery("from Car where model = '"+ model+"' and series = '"+series+"'").getSingleResult();

      User user = (User) sessionFactory.getCurrentSession()
              .createQuery("from User where carId = '"+car.getId()+"'").getSingleResult();
      return user;

   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   //



}
