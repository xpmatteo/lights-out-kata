package it.xpug.lightsout;

import static org.junit.Assert.*;

import java.util.*;

import it.xpug.toolkit.html.*;

import org.junit.*;

public class LightsOutViewTest {

	@Test
	public void insertValues() {
		TemplateView view = new TemplateView("index.ftl");
		List<Integer> expected = Arrays.asList(1,1,1,1,1,1,1,1,1);

		HtmlDocument html = new HtmlDocument(view.toHtml());
		List<Integer> actual = new ArrayList<Integer>();
		List<HtmlDocument> cells = html.getNodes("//td");
		for (HtmlDocument cell : cells) {
			actual.add(Integer.parseInt(cell.getText()));
		}
		assertEquals(expected, actual);
	}

}
