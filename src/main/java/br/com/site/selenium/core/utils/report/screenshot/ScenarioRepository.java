package br.com.site.selenium.core.utils.report.screenshot;

import br.com.site.selenium.core.driver.DriverFactory;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que interage com o report
 *
 * @author Guilherme-Evangelista
 * @author guilherme.granato
 */
public class ScenarioRepository {

    private static final Map<Long, Scenario> repository = new HashMap<Long, Scenario>();

    public static void add(Scenario scenario) {
        if (get() == null)
            repository.put(getId(), scenario);
    }

    public static void remove() {
        if (get() != null)
            repository.remove(getId());
    }

    private static Scenario get() {
        return repository.get(getId());
    }

    public static Long getId() {
        return Thread.currentThread().getId();
    }

    /**
     * Screenshot com highlights.
     */
    public static void screenShot() {
        try {
            byte[] print = Screenshot.take(DriverFactory.getDriver());
            get().embed(print, "image/png");
        } catch (Exception ignored) {
        }
    }

    /**
     * Screenshot com highlights.
     * @param elements elementos destacados
     */
    public static void screenShot(WebElement... elements) {
        try {
            byte[] print = Screenshot.take(DriverFactory.getDriver(), elements);
            get().embed(print, "image/png");
        } catch (Exception ignored) {}
    }

    /**
     * Adicionar textos ao relatório.
     */
    public static void addText(String texto) {
        if (texto != null)
            get().log(texto);
    }
}
