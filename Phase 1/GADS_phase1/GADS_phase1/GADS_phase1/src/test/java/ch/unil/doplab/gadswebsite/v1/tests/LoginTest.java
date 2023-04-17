/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadswebsite.v1.tests;

import ch.unil.doplab.gadswebsite.v1.controllers.LoginController;
import ch.unil.doplab.gadswebsite.v1.controllers.UserController;

import ch.unil.doplab.gadswebsite.v1.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.v1.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
public class LoginTest {
    @Test
    public void generateLoginTest() throws DoesNotExistException {
                    String username = "John";
                    System.out.println("1");
                    String password = "1234";
                                        System.out.println("2");

                    LoginController.setUsername(username);
                                        System.out.println("3");

                    LoginController.setPassword(password);
                                        System.out.println("4");

                    Assert.assertThrows(DoesNotExistException.class,()->{

                         UserController.findByUsername(username);
                        
                    });
    
    }
                    
    
}
