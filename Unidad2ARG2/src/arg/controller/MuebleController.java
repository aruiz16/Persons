package arg.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arg.dom.MuebleDOM;
import arg.model.Mueble;

/**
 * Servlet implementation class MuebleController
 */
@WebServlet("/MuebleController")
public class MuebleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Mueble mueble;
	private List<Mueble> muebles;
	private MuebleDOM muebleDOM;
	private List <String> ids = new ArrayList<String>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuebleController() {
        super();
        mueble = new Mueble();
        muebles = new java.util.ArrayList<Mueble>();
        muebleDOM = new MuebleDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(request.getParameter("btn_save")!=null) {
			mueble.setDescripcion(request.getParameter("descripcion"));
			mueble.setNombre(request.getParameter("nombre"));
			try {
				mueble.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
			}catch(NumberFormatException e) {
				mueble.setCantidad(1);
			}
			mueble.setDuenio(request.getParameter("duenio"));
			if(mueble.getCodigo()=="") {
				String newId = "00"+String.format("%05d", 1);
				mueble.setCodigo(newId);
				if(muebles.size()>0) {
					ids.clear();
					for(Mueble m: muebles) {
						ids.add(m.getCodigo());
					}
					for(int i=0; i<=ids.size();i++) {
						newId = "00"+String.format("%05d", i+1);
						if(!ids.contains(newId)) {
							mueble.setCodigo(newId);
							break;
						}
					}
				}
				muebleDOM.add(mueble);
				} else {
					muebleDOM.update(mueble);
			}
			muebles = muebleDOM.getMuebles();
			request.setAttribute("muebles", muebles);
			request.getRequestDispatcher("mueble_list.jsp").forward(request, response);
		} else if(request.getParameter("btn_new")!= null) {
			mueble = new Mueble();
			request.getRequestDispatcher("mueble_form.jsp").forward(request, response);
		} else if(request.getParameter("btn_edit")!=null) {
			try {
				String codigo = request.getParameter("codigo");
				mueble = muebleDOM.findById(codigo);
			}catch(Exception e) {
				mueble = new Mueble();
			}
			request.setAttribute("mueble", mueble);
			request.getRequestDispatcher("mueble_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				String codigo = request.getParameter("codigo");
				muebleDOM.delete(codigo);
				muebles = muebleDOM.getMuebles();
			}catch(Exception e) {
				
			}
			request.setAttribute("muebles", muebles);
			request.getRequestDispatcher("mueble_list.jsp").forward(request, response);
		}else {
			muebles = muebleDOM.getMuebles();
			request.setAttribute("muebles", muebles);
			request.getRequestDispatcher("mueble_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
