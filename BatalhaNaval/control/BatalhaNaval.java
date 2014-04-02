package control;

//import View.*;
//import model.*;


public class BatalhaNaval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		model.CampoM cm = new model.CampoM();
		view.CampoV cv = new view.CampoV();
		
		//char[][] campo = cm.pegaCampo();
		cv.imprimeCampo();
		
	}

}
