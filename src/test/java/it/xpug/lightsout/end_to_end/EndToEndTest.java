package it.xpug.lightsout.end_to_end;

import static java.util.Arrays.*;
import static org.junit.Assert.*;
import it.xpug.lightsout.*;
import it.xpug.toolkit.http.*;

import java.util.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class EndToEndTest {
	private static final int PORT = 9080;

	private static WebDriver driver;
	private static ReusableJettyApp app;

	@BeforeClass
	public static void startApp() {
		app = new ReusableJettyApp(LightsOutServlet.class);
		app.start(PORT, "src/main/resources");
		driver = new FirefoxDriver();
	}

	@Before
	public void getMainPage() throws Exception {
		driver.get("http://localhost:" + PORT);
	}

	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}

	@Test
	public void startingConfiguration() {
		List<Integer> expected = asList(
				1,1,1,
				1,1,1,
				1,1,1);
		assertEquals(expected, tableValues());
	}

	@Test
	public void clickOnCenterElement() {
		driver.get("http://localhost:" + PORT);
		clickOn(4);
		List<Integer> expected = asList(
				1,0,1,
				0,0,0,
				1,0,1);
		assertEquals(expected, tableValues());
	}

	@Test
	public void clickOnCornerElement() {
		driver.get("http://localhost:" + PORT);
		clickOn(0);
		List<Integer> expected = asList(
				0,0,1,
				0,1,1,
				1,1,1);
		assertEquals(expected, tableValues());
	}

	@Test
	public void clickTwice() {
		driver.get("http://localhost:" + PORT);
		clickOn(0);
		clickOn(3);
		List<Integer> expected = asList(
				1,0,1,
				1,0,1,
				0,1,1);
		assertEquals(expected, tableValues());
	}

	private void clickOn(int index) {
		cells().get(index).click();
	}

	public List<Integer> tableValues() {
		List<Integer> actual = new ArrayList<Integer>();
		for (WebElement cell : cells()) {
			actual.add(Integer.parseInt(cell.getText()));
		}
		return actual;
	}

	public List<WebElement> cells() {
		return driver.findElements(By.xpath("//td"));
	}

}
