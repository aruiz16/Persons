package arg.dom;

import java.util.List;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import arg.model.Mueble;

public class MuebleDOM {
	//private String pathFile = "src/data/students.xml";
	private String pathFile = "C:\\Users\\Alejandro RG\\eclipse-workspace\\Unidad2ARG2\\src\\arg\\data\\muebles.xml";

	public void add(Mueble info) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			Element muebles = document.getDocumentElement();
			// Create Mueble tag
			Element mueble = document.createElement("mueble");
			// Create Codigo tag
			Element codigo = document.createElement("codigo");
			codigo.appendChild(document.createTextNode(info.getCodigo()));
			mueble.appendChild(codigo);
			// Create descripcion tag
			Element descripcion = document.createElement("descripcion");
			descripcion.appendChild(document.createTextNode(info.getDescripcion()));
			mueble.appendChild(descripcion);
			// Create Nombre tag
			Element nombre = document.createElement("nombre");
			nombre.appendChild(document.createTextNode(info.getNombre()));
			mueble.appendChild(nombre);
			// Create Cantidad tag
			Element cantidad = document.createElement("cantidad");
			cantidad.appendChild(document.createTextNode(String.valueOf(info.getCantidad())));
			mueble.appendChild(cantidad);
			// Create Duenio tag
			Element duenio = document.createElement("duenio");
			duenio.appendChild(document.createTextNode(info.getDuenio()));
			mueble.appendChild(duenio);
			
			muebles.appendChild(mueble);
			// Write to file
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(String codigo) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("mueble");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element mueble = (Element) nodeList.item(i);
				if (mueble.getElementsByTagName("codigo").item(0).getTextContent().equals(codigo)) {
					mueble.getParentNode().removeChild(mueble);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Mueble info) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("mueble");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element mueble = (Element) nodeList.item(i);
				if (mueble.getElementsByTagName("codigo").item(0).getTextContent().equals(info.getCodigo())) {
					mueble.getElementsByTagName("descripcion").item(0).setTextContent(info.getDescripcion());
					mueble.getElementsByTagName("nombre").item(0).setTextContent(info.getNombre());
					mueble.getElementsByTagName("cantidad").item(0).setTextContent(String.valueOf(info.getCantidad()));
					mueble.getElementsByTagName("duenio").item(0).setTextContent(info.getDuenio());
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Mueble findById(String codigo) {
		Mueble mueble = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("mueble");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element p = (Element) nodeList.item(i);
				if (p.getElementsByTagName("codigo").item(0).getTextContent().equals(codigo)) {
					mueble = new Mueble();
					mueble.setCodigo(codigo);
					mueble.setDescripcion(p.getElementsByTagName("descripcion").item(0).getTextContent());
					mueble.setNombre(p.getElementsByTagName("nombre").item(0).getTextContent());
					mueble.setCantidad(Integer.parseInt(p.getElementsByTagName("cantidad").item(0).getTextContent()));
					mueble.setDuenio(p.getElementsByTagName("duenio").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return mueble;
	}

	public List<Mueble> getMuebles() {
		List<Mueble> muebles = new ArrayList<Mueble>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodeList = document.getElementsByTagName("mueble");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element p = (Element) nodeList.item(i);
			Mueble mueble = new Mueble();
				mueble.setCodigo(p.getElementsByTagName("codigo")
							.item(0).getTextContent());
				mueble.setDescripcion(p.getElementsByTagName("descripcion")
							.item(0).getTextContent());
				mueble.setNombre(p.getElementsByTagName("nombre")
							.item(0).getTextContent());
				mueble.setCantidad(Integer.parseInt(p.getElementsByTagName("cantidad")
							.item(0).getTextContent()));
				mueble.setDuenio(p.getElementsByTagName("duenio")
							.item(0).getTextContent());
				muebles.add(mueble);
		}
	return muebles;
}
}
