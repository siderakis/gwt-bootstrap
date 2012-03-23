package com.github.gwtbootstrap.client.ui.resources.prettify;

import java.util.ArrayList;
import java.util.List;

import com.github.gwtbootstrap.client.ui.resources.JavaScriptInjector;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.Widget;

/**
 * A helper class to inject and configure Google Code Prettify in our code
 * componentes.
 * 
 * @author Carlos A Becker
 * 
 */
public class PrettifyHelper implements HasLang {

	static {
		JavaScriptInjector.inject(PrettifyResources.RESOURCES.prettify_js()
				.getText());
		StyleInjector.inject(PrettifyResources.RESOURCES.prettify_css()
				.getText());
	}

	static List<Integer> importedLangs = new ArrayList<Integer>();
	private final Widget w;

	public PrettifyHelper(Widget w) {
		super();
		this.w = w;
	}

	/**
	 * will import the language if needed.
	 */
	public void setLang(String lang) {

		int i = PrettifyResources.speciallangs.indexOf(lang);

		// XXX thats very very very very ugly, sorry.

		if (i > -1 && !importedLangs.contains(i)) {
			TextResource tr = null;
			switch (i) {
			case 0:
				tr = PrettifyResources.RESOURCES.apollo();
				break;
			case 1:
				tr = PrettifyResources.RESOURCES.clj();
				break;
			case 2:
				tr = PrettifyResources.RESOURCES.css();
				break;
			case 3:
				tr = PrettifyResources.RESOURCES.go();
				break;
			case 4:
				tr = PrettifyResources.RESOURCES.hs();
				break;
			case 5:
				tr = PrettifyResources.RESOURCES.lisp();
				break;
			case 6:
				tr = PrettifyResources.RESOURCES.lua();
				break;
			case 7:
				tr = PrettifyResources.RESOURCES.ml();
				break;
			case 8:
				tr = PrettifyResources.RESOURCES.ml();
				break;
			case 9:
				tr = PrettifyResources.RESOURCES.n();
				break;
			case 10:
				tr = PrettifyResources.RESOURCES.proto();
				break;
			case 11:
				tr = PrettifyResources.RESOURCES.scala();
				break;
			case 12:
				tr = PrettifyResources.RESOURCES.sql();
				break;
			case 13:
				tr = PrettifyResources.RESOURCES.tex();
				break;
			case 14:
				tr = PrettifyResources.RESOURCES.vb();
				break;
			case 15:
				tr = PrettifyResources.RESOURCES.vhdl();
				break;
			case 16:
				tr = PrettifyResources.RESOURCES.wiki();
				break;
			case 17:
				tr = PrettifyResources.RESOURCES.xq();
				break;

			default:
				break;
			}
			if (tr != null) {
				JavaScriptInjector.inject(tr.getText());
				importedLangs.add(i);
			}
		}
	}

	/**
	 * Configure prettyprint.
	 */
	public void configure() {
		configure(false);
	}

	public void configure(boolean showLineNumber) {
		w.setStyleName("prettyprint");
		if(showLineNumber) w.addStyleName("linenums");
		setup();
	}

	private native void setup() /*-{
		$wnd.prettyPrint();
	}-*/;
}
