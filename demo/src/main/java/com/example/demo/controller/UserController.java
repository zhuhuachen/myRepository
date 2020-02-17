//package com.example.demo.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.dao.UserRepository;
//import com.example.demo.entity.Role;
//import com.example.demo.entity.User;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//    @Autowired 
//    private UserRepository userRepository;
//
//    /**
//     * 从 用户存储库 获取用户列表
//     * @return
//     */
//    @RequestMapping(value="/findAll",method=RequestMethod.GET)
//    public List<User> getUserlist() {
//        List<User> users = new ArrayList<>();
//        for (User user : userRepository.findAll()) {
//            users.add(user);
//        }
//         return users;
//    }
//    @RequestMapping("/findName")
//    public List<User> findName(String name) {
//    	System.err.println(name);
//        List<User> users = userRepository.findByName(name);
////        for (User user : users) {
////            users.add(user);
////        }
//         return users;
//    }
//    @RequestMapping("/findNameLike")
//    public List<User> findNameLike(String name) {
//    	System.err.println(name);
//        List<User> users = userRepository.findByNameLike(name);
////        for (User user : users) {
////            users.add(user);
////        }
//         return users;
//    }
//    @RequestMapping(value="/add",method=RequestMethod.POST)
//    public String addUser() {
//    	User user=new User();
//    	user.setAge(20);
//    	user.setName("张三");
//    	user.setAddress("广西");
//    	
//    	Role r=new Role();
//    	//r.setRoleid(1);
//    	r.setRolename("管理员");
//    	r.setUser(user);
//    	user.setRoles(r);
//    	userRepository.save(user);
//       return "success";
//    }
//    @RequestMapping(value="/update",method=RequestMethod.PUT)
//    public String updataUser() {
//    	Optional<User> op=userRepository.findById(1l);
//    	User u=op.get();
//    	u.setName("李四");
//    	userRepository.save(u);
//       return "success";
//    }
//    @RequestMapping(value="/delete",method=RequestMethod.DELETE)
//    public String deleteUser() {
//    	Optional<User> op=userRepository.findById(1l);
//    	User u=op.get();
//    	userRepository.delete(u);
//       return "success";
//    }
//}