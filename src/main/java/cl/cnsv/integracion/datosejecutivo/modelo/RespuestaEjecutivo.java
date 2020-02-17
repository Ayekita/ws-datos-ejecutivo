package cl.cnsv.integracion.datosejecutivo.modelo;

/**
 * Representa el mensaje estandar base para las respuesta de servicios.
 *
 * @author {digitali}
 */
public class RespuestaEjecutivo {
	private String sNombre;
    private String sRut;
	private String sDv;
	private String sEmail;
	private String sUser;
	private int    nRut;
	private long   nCodIntermediario;
	private long   nAgencia;
	private long   nOficina;
	private long   nSucursal;
	/**
	 * @return the sNombre
	 */
	public String getsNombre() {
		return sNombre;
	}
	/**
	 * @param sNombre the sNombre to set
	 */
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
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
	/**
	 * @return the sDv
	 */
	public String getsDv() {
		return sDv;
	}
	/**
	 * @param sDv the sDv to set
	 */
	public void setsDv(String sDv) {
		this.sDv = sDv;
	}
	/**
	 * @return the sEmail
	 */
	public String getsEmail() {
		return sEmail;
	}
	/**
	 * @param sEmail the sEmail to set
	 */
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	/**
	 * @return the sUser
	 */
	public String getsUser() {
		return sUser;
	}
	/**
	 * @param sUser the sUser to set
	 */
	public void setsUser(String sUser) {
		this.sUser = sUser;
	}
	/**
	 * @return the nRut
	 */
	public int getnRut() {
		return nRut;
	}
	/**
	 * @param nRut the nRut to set
	 */
	public void setnRut(int nRut) {
		this.nRut = nRut;
	}
	/**
	 * @return the nCodIntermediario
	 */
	public long getnCodIntermediario() {
		return nCodIntermediario;
	}
	/**
	 * @param nCodIntermediario the nCodIntermediario to set
	 */
	public void setnCodIntermediario(long nCodIntermediario) {
		this.nCodIntermediario = nCodIntermediario;
	}
	/**
	 * @return the nAgencia
	 */
	public long getnAgencia() {
		return nAgencia;
	}
	/**
	 * @param nAgencia the nAgencia to set
	 */
	public void setnAgencia(long nAgencia) {
		this.nAgencia = nAgencia;
	}
	/**
	 * @return the nOficina
	 */
	public long getnOficina() {
		return nOficina;
	}
	/**
	 * @param nOficina the nOficina to set
	 */
	public void setnOficina(long nOficina) {
		this.nOficina = nOficina;
	}
	/**
	 * @return the nSucursal
	 */
	public long getnSucursal() {
		return nSucursal;
	}
	/**
	 * @param nSucursal the nSucursal to set
	 */
	public void setnSucursal(long nSucursal) {
		this.nSucursal = nSucursal;
	}


}
