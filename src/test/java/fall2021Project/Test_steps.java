package fall2021Project;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
@RunWith(Cucumber.class)
@CucumberOptions(features="use_cases",
tags="@d",
plugin = {"html:target/cucumber/wikipedia.html"},
monochrome = true,
snippets=SnippetType.CAMELCASE,
glue= "fall2021Project",
strict=true
)

public class Test_steps {

}
