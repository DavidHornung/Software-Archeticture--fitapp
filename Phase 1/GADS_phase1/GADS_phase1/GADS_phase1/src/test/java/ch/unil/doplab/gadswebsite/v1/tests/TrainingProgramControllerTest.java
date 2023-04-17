/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadswebsite.v1.tests;

import ch.unil.doplab.gadswebsite.v1.controllers.TrainingProgramController;
import ch.unil.doplab.gadswebsite.v1.models.TrainingProgram;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
public class TrainingProgramControllerTest {
    @Test
    public void generateTrainingProgramTest() {
        //TrainingProgramController tpc = new TrainingProgramController();
        List trainingProgram = TrainingProgramController.generateTrainingProgram("Gain weight", 2, 1, 0, 0, 0);
        Assert.assertEquals(trainingProgram.size(), 1);
    }
    
}
