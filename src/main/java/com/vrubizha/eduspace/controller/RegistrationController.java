package com.vrubizha.eduspace.controller;

import com.vrubizha.eduspace.domain.FriendRequest;
import com.vrubizha.eduspace.domain.Group;
import com.vrubizha.eduspace.domain.Student;
import com.vrubizha.eduspace.security.domain.User;
import com.vrubizha.eduspace.security.service.UserService;
import com.vrubizha.eduspace.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.Set;



@Controller
@Slf4j
public class RegistrationController {

    private static final Logger logger=LoggerFactory.getLogger(RegistrationController.class);


    private final UserService userService;
    private final StudentService studentService;

    @Autowired
    public RegistrationController(UserService userService, StudentService studentService) {
        this.userService = userService;
        this.studentService = studentService;
    }

    @GetMapping(value={"/", "/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(value="/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

    @GetMapping(value="/students/account")
    @RabbitListener(queues = "queue1")
    public ModelAndView home(FriendRequest friendRequest){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        Student student=studentService.findStudentByEmail(user.getEmail());
        logger.info("Received from friendRequest: " + new String(friendRequest.toString()));
        Set<Group> studentsGroups=student.getGroups();
        logger.info("Initialized [Authentication] "+auth.getName()+" and [User] "+user.getLastName());
        logger.info("Initialized groups: "+studentsGroups.toString());
        modelAndView.addObject("user",user);
        modelAndView.addObject("student",student);
        modelAndView.addObject("studentsGroups",studentsGroups);
        modelAndView.addObject("receivedRequest",opponentName(friendRequest));
        modelAndView.setViewName("studentAccount");
        return modelAndView;
    }

    @ModelAttribute("receivedRequest")
    private String opponentName(FriendRequest friendRequest){
        int accountId=friendRequest.getAccount().getId();
        Student student=studentService.findStudentById(accountId);
        StringBuilder sb=new StringBuilder();
        return sb.append(student.getFirstName())
                .append(" ").append(student.getNameByFather())
                .append(" ").append(student.getLastName()).toString();

    }
}
