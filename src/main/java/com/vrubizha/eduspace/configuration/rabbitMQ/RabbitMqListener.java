//package com.vrubizha.eduspace.configuration.rabbitMQ;
//
//import com.vrubizha.eduspace.domain.FriendRequest;
//import com.vrubizha.eduspace.domain.Student;
//import com.vrubizha.eduspace.service.StudentService;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@EnableRabbit
//@Component
//@Slf4j
//public class RabbitMqListener {
//
//    @Autowired
//    private StudentService studentService;
//
//    private final static Logger logger=LoggerFactory.getLogger(RabbitMqListener.class);
//
//    @RabbitListener(queues = "queue1")
//    public void processQueue1(FriendRequest message) {
//        logger.info("Received from friendRequest: " + new String(message.toString()));
//
//        opponentName(message);
//    }
//
//
//    @ModelAttribute("receivedRequest")
//    private String opponentName(FriendRequest friendRequest){
//        int accountId=friendRequest.getAccount().getId();
//       Student student=studentService.findStudentById(accountId);
//       StringBuilder sb=new StringBuilder();
//       return sb.append(student.getFirstName())
//               .append(" ").append(student.getNameByFather())
//               .append(" ").append(student.getLastName()).toString();
//
//    }
//}
