package br.com.petshop.converter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.EstadoDAO;
import br.com.petshop.modelo.Estado;

@ManagedBean(name = "estadoConverter")
//@Named
//@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter {
	
	@Autowired
	EstadoDAO estadoDao;
	
	private List<Estado> estados = new ArrayList<>();

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				List<Estado> estadosAux = estadoDao.listaEstados();
				for (Estado estado : estadosAux) {
					if(estado.getId() >= 0 && estado.getId() <= estados.size()){
						estados.add(estado.getId().intValue(), estado);
			        }else{
			        	int insertNulls = estado.getId().intValue() - estados.size();
				        for(int i = 0; i < insertNulls; i++){
				        	estados.add(null);
				        }
				        estados.add(estado);
			        }
			        
				}
				return estados.get(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if(object != null) {
            return String.valueOf(((Estado) object).getId());
        }
        else {
            return null;
        }
	}

	public EstadoDAO getEstadoDao() {
		return estadoDao;
	}

	public void setEstadoDao(EstadoDAO estadoDao) {
		this.estadoDao = estadoDao;
	}

}
