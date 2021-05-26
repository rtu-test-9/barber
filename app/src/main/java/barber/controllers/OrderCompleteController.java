package barber.controllers;

import barber.dao.EmployeeDAO;
import barber.entities.Employee;
import barber.entities.Order;
import barber.services.EmailService;
import barber.services.EmployeeService;
import barber.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@Transactional
public class OrderCompleteController {

    private EmployeeService employeeService;

    private OrderService orderService;

    private EmailService emailService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orderComplete")
    public String orderComplete(@RequestParam(name = "master_id") String master_id, @RequestParam(name = "email") String email, @RequestParam(name = "service_id") String service_id, @RequestParam(name="time") String chosenTime) {
        Order order = new Order();
        Employee master = employeeService.findById(Long.parseLong(master_id));
        DateFormat format = new SimpleDateFormat("YYYY-M-d H:m:s");
        Date date;

        try {
            date = format.parse(chosenTime);
        }
        catch (ParseException exception) {
            date = null;
            System.out.println("ParseError");
        }
        order.setTime(date);
        order.setEmail(email);
        orderService.createOrder(order, Long.parseLong(service_id), master);
        emailService.sendMessage("Запись в BAYER", "Ваш заказ принят к мастеру " + master.getName() + " на " + date.toString());
        return "successPage";
    }
}
