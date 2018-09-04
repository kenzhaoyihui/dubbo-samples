package com.yzhao.dubbo.samples.validation.client;

import com.yzhao.dubbo.samples.validation.api.ValidationParamter;
import com.yzhao.dubbo.samples.validation.api.ValidationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Set;

public class ValidationConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/validation-consumer.xml"}
        );

        context.start();

        ValidationService validationService = (ValidationService) context.getBean("validationService");

        ValidationParamter paramter = new ValidationParamter();

        //Save OK
        paramter.setName("zhaoyihui");
        paramter.setAge(40);
        paramter.setEmail("hah@qq.com");
        paramter.setLoginDate(new Date(System.currentTimeMillis()-1000000));
        paramter.setExpiryDate(new Date(System.currentTimeMillis()+1000000));
        validationService.save(paramter);


        //Save Error
        try {
            paramter = new ValidationParamter();
            paramter.setAge(100);
            validationService.save(paramter);
            System.err.println("Validation Save Error");
        } catch (Exception e) {
            ConstraintViolationException ve = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations();
            System.out.println("------------------" + violations);
        }


        //Delete OK
        validationService.delete(2, "abc");
        System.out.println("Validation Delete OK");

        //Delete Error
        try {
            validationService.delete(0,"abc");
            System.err.println("Validation Delete Error");
        } catch (Exception e) {
            ConstraintViolationException ve = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations();
            System.out.println("+++++++++++++++++++++++++" + violations);
        }
    }
}
