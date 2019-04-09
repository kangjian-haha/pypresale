package com.pyp.pypresale.Repository;

import com.pyp.pypresale.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Override
    boolean existsById(Integer integer);

    //判断是否存在相同的用户名或学号或电话
    boolean existsByUsername(String username);
    boolean existsByStudentID(String studentID);
    boolean existsByTelephone(String telephone);

    //从学号拿到这个用户
    User findByStudentID(String studentID);

    @Modifying
    @Query(value = "update User u set u.username=?1,u.sex=?2,u.telephone=?3 where u.studentID=?4 ")
    void alterUserInformation(String username,String sex,String telephone,String studentID);

    @Modifying
    @Query(value = "update User u set u.username=?1,u.sex=?2 where u.studentID=?3 ")
    void alterUserInformationNoTel(String username,String sex,String studentID);


    //修改用户信息,判断除自己外,是否存在着相同的用户名和电话
    //@Query(value = "select u from User u where u.username =?1 and u.studentID <> ?2 ")
    boolean existsByUsernameAndStudentIDNot(String username,String studentID);
    //@Query(value = "select u from User u where u.telephone =?1 and u.studentID <> ?2 ")
    boolean existsByTelephoneAndStudentIDNot(String telephone,String studentID);





}
