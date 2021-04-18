package Runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // To identify and execute the cucumber class
@CucumberOptions(features={"src/test/resources/Register/Register.feature"},
glue = {"StepDefinition"}, dryRun=false,tags="@Register",// this basically to check did i implement all the methods//in case if i missed
//any method ot will help me to identify
//Glue means my providing my entire stpe package to this method
monochrome=true,//basically get the right format in console
strict=true, // this is going to chech very strictlly any steps are missing in the step definition
plugin = {"html:testoutput/casestudy.html","junit:testoutput/casestudy.xml","json:testoutput/casestudy.json"})
public class Test_File {

}
