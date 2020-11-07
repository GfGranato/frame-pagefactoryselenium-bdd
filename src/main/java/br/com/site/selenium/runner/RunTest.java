package br.com.site.selenium.runner;

import br.com.site.selenium.core.utils.report.Report;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

/**
 * Gerar report com o plugin ClueCumber baseado no custom.css acima
 * @author Guilherme-Evangelista
 * @author guilherme.granato
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"br/com/site/selenium/test/steps", "br/com/site/selenium/core/hooks"},
        tags = {"@executar"}
)
public class RunTest {
    @AfterClass
    public static void gerarRelatorio() {
        Report.gerarRelarotioClueCumber();
    }
}
