package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    private Session getCurrentSession() {
//        Session session = entityManager.unwrap(Session.class);
//        return session;
//    }
//
//    //add-create
//    @Override
//    public void addUser(User user) {
//        getCurrentSession().save(user);
//    }
//
//    //read
//    @SuppressWarnings("unchecked")
//    @Override
//    public List<User> getUsers() {
////        return getCurrentSession().createQuery("from User").list();
//        TypedQuery<User> query = getCurrentSession().createQuery("from User");
//        return query.getResultList();
//    }
//
//    //update
//    @Override
//    public void updateUser(User user) {
//        User userToUpdate = getUserById(user.getId());
//        userToUpdate.setName(user.getName());
//        userToUpdate.setAge(user.getAge());
//        userToUpdate.setSex(user.getSex());
//        getCurrentSession().update(userToUpdate);
//    }
//
//    //delete
//    @Override
//    public void deleteUser(int id) {
//        User user = getUserById(id);
//        if (user != null) {
//            getCurrentSession().delete(user);
//        }
//    }
//
//    //getUser by Id
//    @Override
//    public User getUserById(int id) {
//        User user = (User) getCurrentSession().get(User.class, id);
//        return user;
//    }

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM Users", new BeanPropertyRowMapper<>(User.class));
    }

    public User getUserById(int id) {
        return jdbcTemplate.query("SELECT * FROM Users WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }

    public void addUser(User user) {
        jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?)", user.getName(), user.getAge(),
                user.getEmail());
    }

    public void updateUser(int id, User updateUser) {
        jdbcTemplate.update("UPDATE Users SET name=?, age=?, email=? WHERE id=?", updateUser.getName(),
                updateUser.getAge(), updateUser.getEmail(), id);
    }

    public void deleteUser(int id) {
        jdbcTemplate.update("DELETE FROM Users WHERE id=?", id);
    }

}
