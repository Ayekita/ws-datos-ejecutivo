package cl.cnsv.integracion.datosejecutivo.modelo;

public class Ejecutivo {
	private int rut;
	private String sRut;
	private String dv;
	private String nombre="";
	private String email="";
	private String user=""; 
	private int nbranch=0;
	private int nproduct=0;
	/**
	 * @return the rut
	 */
	public int getRut() {
		return rut;
	}
	/**
	 * @param rut the rut to set
	 */
	public void setRut(int rut) {
		this.rut = rut;
	}
	/**
	 * @return the dv
	 */
	public String getDv() {
		return dv;
	}
	/**
	 * @param dv the dv to set
	 */
	public void setDv(String dv) {
		this.dv = dv;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return the nbranch
	 */
	public int getNbranch() {
		return nbranch;
	}
	/**
	 * @param nbranch the nbranch to set
	 */
	public void setNbranch(int nbranch) {
		this.nbranch = nbranch;
	}
	/**
	 * @return the nproduct
	 */
	public int getNproduct() {
		return nproduct;
	}
	/**
	 * @param nproduct the nproduct to set
	 */
	public void setNproduct(int nproduct) {
		this.nproduct = nproduct;
	}
	/**
	 * @return the sRut
	 */
	public String getsRut() {
		return sRut;
	}
	/**
	 * @param sRut the sRut to set
	 */
	public void setsRut(String sRut) {
		this.sRut = sRut;
	}
	
	
}
